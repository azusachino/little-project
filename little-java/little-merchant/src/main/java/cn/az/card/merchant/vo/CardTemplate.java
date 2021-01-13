package cn.az.card.merchant.vo;

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
public class CardTemplate {

    private Integer id;

    private String title;

    private String summary;

    private String description;

    /**
     * Max coupons limit
     */
    private Long limit;

    private Boolean hasToken;

    private Integer background;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

}
