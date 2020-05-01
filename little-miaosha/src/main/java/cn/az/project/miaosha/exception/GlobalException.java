package cn.az.project.miaosha.exception;

import cn.az.project.miaosha.result.CodeMessage;

/**
 * @author az
 * @since 2020-04-13
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1845302575113494136L;

    private final CodeMessage codeMessage;

    public GlobalException(CodeMessage codeMessage) {
        super(codeMessage.getMessage());
        this.codeMessage = codeMessage;
    }

    public CodeMessage getCodeMessage() {
        return codeMessage;
    }
}
