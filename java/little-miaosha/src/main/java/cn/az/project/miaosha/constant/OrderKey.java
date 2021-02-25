package cn.az.project.miaosha.constant;

/**
 * @author az
 */
public class OrderKey extends BasePrefix {

    public OrderKey(String prefix) {
        super(prefix);
    }

    public static OrderKey getMiaoshaOrderByUidGid() {
        return new OrderKey("moug");
    }

}
