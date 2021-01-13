package cn.az.project.muxin.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Scanner;

/**
 * @author az
 * @version 12/13/2019
 */

public class CodeGenerator {

    private static final String URL = "jdbc:mysql://localhost:3306/muxin?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "azusa520";
    private static final String AUTHOR = "az";
    private static final String BASE_PACKAGE_URL = "cn.az.project.muxin";
    private static final String XML_PACKAGE_URL = "/src/main/resources/mapper/";
    private static final String XML_MAPPER_TEMPLATE_PATH = "templates/mapper.xml.ftl";
    private static final String MAPPER_TEMPLATE_PATH = "templates/mapper.java";
    private static final String ENTITY_TEMPLATE_PATH = "templates/entity.java";
    private static final String SERVICE_TEMPLATE_PATH = "templates/service.java";
    private static final String SERVICE_IMPL_TEMPLATE_PATH = "templates/serviceImpl.java";
    private static final String CONTROLLER_TEMPLATE_PATH = "templates/controller.java";
    private static final String SUB_PROJECT_NAME = "/little-muxin";
    private static final String PROJECT_PATH = System.getProperty("user.dir") + SUB_PROJECT_NAME;

    public static void main(String[] args) {
        List<String> tableNames = List.of("user", "chat", "friend", "friend-request");
        tableNames.forEach(CodeGenerator::generate);
    }

    public static void generate(String tableName) {
        AutoGenerator generator = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setOutputDir(PROJECT_PATH + "/src/main/java");
        globalConfig.setAuthor(AUTHOR);
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(true);
        globalConfig.setBaseResultMap(true);
        generator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(URL);
        dataSourceConfig.setDriverName(DRIVER);
        dataSourceConfig.setUsername(USERNAME);
        dataSourceConfig.setPassword(PASSWORD);
        generator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(BASE_PACKAGE_URL);
        generator.setPackageInfo(packageConfig);

        // 自定义配置
        InjectionConfig cfg = new SimpleInjectionConfig();
        cfg.setFileOutConfigList(List.of(new SimpleFileOutConfig(XML_MAPPER_TEMPLATE_PATH)));
        generator.setCfg(cfg);

        // 配置自定义代码模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml("");
        templateConfig.setMapper(MAPPER_TEMPLATE_PATH);
        templateConfig.setEntity(ENTITY_TEMPLATE_PATH);
        templateConfig.setService(SERVICE_TEMPLATE_PATH);
        templateConfig.setServiceImpl(SERVICE_IMPL_TEMPLATE_PATH);
        templateConfig.setController(CONTROLLER_TEMPLATE_PATH);
        generator.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(tableName);
//        strategy.setSuperEntityColumns("id");
        strategy.setEntitySerialVersionUID(true);
        strategy.setControllerMappingHyphenStyle(true);
        generator.setStrategy(strategy);
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.hasLength(ipt)) {
                return ipt;
            }
        }
        throw new Exception("请输入正确的" + tip + "！");
    }

    public static class SimpleInjectionConfig extends InjectionConfig {
        @Override
        public void initMap() {
        }
    }

    public static class SimpleFileOutConfig extends FileOutConfig {
        public SimpleFileOutConfig(String templatePath) {
            super(templatePath);
        }

        @Override
        public String outputFile(TableInfo tableInfo) {
            return PROJECT_PATH + XML_PACKAGE_URL + tableInfo.getMapperName() + ".xml";
        }
    }
}
