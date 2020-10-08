package cn.az.project.batch.logic;

import lombok.Getter;
import lombok.Setter;

/**
 * @author az
 * @date 2020/3/15
 */
@Getter
@Setter
public abstract class AbstractBatchLogic extends Thread {

    protected volatile boolean stopFlag = false;

    protected boolean isWorking = false;

}
