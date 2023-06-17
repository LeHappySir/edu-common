package com.lagou.edu.common.exception;

/**
 * ErrorType
 *
 * @author xianhongle
 * @data 2022/4/10 7:07 下午
 **/
public interface ErrorType {

    /**
     * 返回code
     *
     * @return
     */
    String getCode();

    /**
     * 返回mesg
     *
     * @return
     */
    String getMesg();

}
