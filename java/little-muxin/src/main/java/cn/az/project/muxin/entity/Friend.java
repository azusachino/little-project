package cn.az.project.muxin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author az
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Friend implements Serializable {

    private static final long serialVersionUID = 8102457462224594036L;

    @TableId
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户的好友id
     */
    private String friendId;

}

