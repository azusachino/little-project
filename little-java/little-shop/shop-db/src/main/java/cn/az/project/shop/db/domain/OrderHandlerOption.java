package cn.az.project.shop.db.domain;

import lombok.Data;

/**
 * The type Order option.
 *
 * @author Liz
 */
@Data
public class OrderHandlerOption {
    private boolean cancel = false;
    private boolean delete = false;
    private boolean pay = false;
    private boolean comment = false;
    private boolean confirm = false;
    private boolean refund = false;
    private boolean reBuy = false;
}
