package cn.az.project.csv.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author az
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VipPerson {

    private Integer id;

    private String firstName;
    private String lastName;

    private transient boolean vip;

    private transient LocalDateTime createTime;
}
