package cn.az.project.rpc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author az
 * @since 11/08/20
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RpcServiceProperties {

    private String version;

    private String group;

    private String serviceName;

    public String toRpcServiceName() {
        return this.getServiceName() + this.getGroup() + this.getVersion();
    }
}
