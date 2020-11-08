package cn.az.project.rpc.config;

import cn.az.project.rpc.utils.CuratorUtils;
import cn.az.project.rpc.utils.ThreadPoolFactoryUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author az
 * @since 11/08/20
 */
@Slf4j
public class CustomShutdownHook {

    private static final CustomShutdownHook CUSTOM_SHUTDOWN_HOOK = new CustomShutdownHook();

    public static CustomShutdownHook getInstance() {
        return CUSTOM_SHUTDOWN_HOOK;
    }

    public void clearAll() {
        log.info("addShutdownHook for clearAll");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            CuratorUtils.clearRegistry(CuratorUtils.getZkClient());
            ThreadPoolFactoryUtils.shutDownAllThreadPool();
        }));
    }
}
