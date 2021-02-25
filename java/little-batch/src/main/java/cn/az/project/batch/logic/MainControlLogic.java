package cn.az.project.batch.logic;

import lombok.extern.slf4j.Slf4j;

/**
 * @author az
 */
@Slf4j
public class MainControlLogic extends AbstractBatchLogic {

    @Override
    public void run() {

        try {
            while (!stopFlag) {

            }
        } catch (Exception e) {
            log.error("error occurred ", e);
        } finally {
            isWorking = false;
            stopFlag = true;

        }
    }
}
