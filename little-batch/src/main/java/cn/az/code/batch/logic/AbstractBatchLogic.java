package cn.az.code.batch.logic;

import lombok.Getter;
import lombok.Setter;

/**
 * @author az
 * @date 2020/3/15
 */
@Getter
@Setter
public abstract class AbstractBatchLogic implements Runnable{

    private boolean stopFlag = false;

    private boolean isWorking = false;

}
