package cn.az.project.csv.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author az
 * @date 2020/3/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Integer id;

    private String firstName;
    private String lastName;

    private transient LocalDateTime createTime;

    public VipPerson toVip() {
        VipPerson vip = new VipPerson();
        vip.setId(this.id);
        vip.setFirstName(this.firstName);
        vip.setLastName(this.lastName);
        vip.setCreateTime(this.createTime);
        vip.setVip(true);
        return vip;
    }
}
