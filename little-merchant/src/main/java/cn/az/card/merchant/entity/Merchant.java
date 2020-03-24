package cn.az.card.merchant.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author az
 * @date 2020/3/17
 */
@Data
@TableName("merchant")
@NoArgsConstructor
@AllArgsConstructor
public class Merchant implements Serializable {

    private static final long serialVersionUID = 3534567624729270723L;

    @TableId
    private Integer id;
    private String name;

    private String logoUrl;
    private String businessLicenseUrl;
    private String phone;
    private String address;

    private Boolean isAudit;

}
