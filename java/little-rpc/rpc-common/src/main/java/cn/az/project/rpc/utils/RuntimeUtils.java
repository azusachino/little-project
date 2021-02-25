package cn.az.project.rpc.utils;

/**
 * @author az
 * @since 11/08/20
 */
public class RuntimeUtils {

    private RuntimeUtils() {
    }

    public static int cpus() {
        return Runtime.getRuntime().availableProcessors();
    }
}
