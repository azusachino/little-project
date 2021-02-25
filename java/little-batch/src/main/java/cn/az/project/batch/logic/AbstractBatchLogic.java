package cn.az.project.batch.logic;

import lombok.Getter;
import lombok.Setter;

/**
 * @author az
 */
@Getter
@Setter
public abstract class AbstractBatchLogic extends Thread {

    protected volatile boolean stopFlag = false;

    protected boolean isWorking = false;

}
