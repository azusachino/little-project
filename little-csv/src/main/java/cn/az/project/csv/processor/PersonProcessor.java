package cn.az.project.csv.processor;

import cn.az.project.csv.entity.Person;
import cn.az.project.csv.entity.VipPerson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.util.StringUtils;

/**
 * @author az
 * @date 2020/3/19
 */
@Slf4j
public class PersonProcessor implements ItemProcessor<Person, VipPerson> {

    private static final String VIP = "vip";

    @Override
    public VipPerson process(Person person) {
        String lastName = person.getLastName();
        if (!StringUtils.hasLength(lastName)) {
            return null;
        }
        if (StringUtils.hasText(VIP)) {
            return person.toVip();
        }
        return null;
    }
}
