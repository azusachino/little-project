package cn.az.project.rpc.extension;

/**
 * @author az
 * @since 11/08/20
 */
public class Holder<T> {

    private volatile T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
