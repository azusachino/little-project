package cn.az.project.miaosha.domain.vo;

import cn.az.project.miaosha.validator.IsMobile;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author az
 * @since 2020-04-13
 */
@Data
@ToString
public class LoginVO {

    @NotNull
    @IsMobile
    private String mobile;
    @NotNull
    @Size(min = 3, max = 30)
    private String password;
}
