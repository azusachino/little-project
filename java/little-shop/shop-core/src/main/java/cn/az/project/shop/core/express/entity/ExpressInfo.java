package cn.az.project.shop.core.express.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author az
 * @since 09/09/20
 */
@Data
@ToString
public class ExpressInfo {
    @JsonProperty("LogisticCode")
    private String logisticCode;
    @JsonProperty("ShipperCode")
    private String shipperCode;
    @JsonProperty("Traces")
    private List<ExpressTrace> expressTraces;
    @JsonProperty("State")
    private String state;
    @JsonProperty("EBusinessID")
    private String eBusinessId;
    @JsonProperty("Success")
    private Boolean success;
    @JsonProperty("Reason")
    private String reason;
    private String shipperName;
}
