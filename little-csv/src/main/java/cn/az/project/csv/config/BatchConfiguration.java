package cn.az.project.csv.config;

import cn.az.project.csv.entity.Person;
import cn.az.project.csv.entity.VipPerson;
import cn.az.project.csv.listener.JobCompletionNotificationListener;
import cn.az.project.csv.processor.PersonProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

/**
 * @author az
 * @date 2020/3/19
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final DataSource dataSource;

    @Autowired
    public BatchConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, DataSource dataSource) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.dataSource = dataSource;
    }

    @Bean
    public FlatFileItemReader<Person> reader() {
        return new FlatFileItemReaderBuilder<Person>()
                .name("personReader")
                .resource(new ClassPathResource("sample-data.csv"))
                .delimited()
                .names("firstName", "lastName")
                .fieldSetMapper(beanWrapperFieldSetMapper())
                .build();
    }

    @Bean
    public BeanWrapperFieldSetMapper<Person> beanWrapperFieldSetMapper() {
        BeanWrapperFieldSetMapper<Person> wrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        wrapperFieldSetMapper.setTargetType(Person.class);
        return wrapperFieldSetMapper;
    }

    @Bean
    public PersonProcessor personProcessor() {
        return new PersonProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<VipPerson> writer() {
        return new JdbcBatchItemWriterBuilder<VipPerson>()
                .itemSqlParameterSourceProvider(sourceProvider())
                .sql("")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public BeanPropertyItemSqlParameterSourceProvider<VipPerson> sourceProvider() {
        return new BeanPropertyItemSqlParameterSourceProvider<>();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step)
                .end()
                .build();
    }

    @Bean
    public Step step(JdbcBatchItemWriter<VipPerson> writer) {
        return stepBuilderFactory.get("step")
                .<Person, VipPerson>chunk(10)
                .reader(reader())
                .processor(personProcessor())
                .writer(writer())
                .build();
    }
}
