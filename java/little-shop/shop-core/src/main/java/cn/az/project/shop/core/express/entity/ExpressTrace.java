package cn.az.project.shop.core.express.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author az
 * @since 09/09/20
 */
@Data
public class ExpressTrace {

    @JsonProperty("AcceptStation")
    private String acceptStation;
    @JsonProperty("AcceptTime")
    private String acceptTime;
}
