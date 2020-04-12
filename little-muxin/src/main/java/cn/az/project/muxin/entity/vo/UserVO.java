package cn.az.project.muxin.entity.vo;

import lombok.Data;

/**
 * @author az
 * @date 2020/4/10
 */
@Data
public class UserVO {
    private String id;
    private String username;
    private String faceImage;
    private String faceImageLarge;
    private String nickname;
    private String qrCode;
}
