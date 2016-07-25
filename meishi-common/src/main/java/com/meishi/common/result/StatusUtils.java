package com.meishi.common.result;

import java.util.List;

public class StatusUtils {

    /**
     * 获取成功的状态
     * @return
     */
    public static Status getSuccessStatus() {
        return StatusPool.getPool().getStatus(StatusConstant.COMMON_SUCCESS);
    }


    /**
     * 从接口返回的Result中获取status
     * @param result
     * @return
     */
    public static Status getStatusFromResult(Result result) {

        String status = result.isSuccess() ? StatusConstant.COMMON_SUCCESS : result.getErrors().get(0);
        return StatusPool.getPool().getStatus(status);
    }

    /**
     * 从接口返回的Result中获取status
     * @param result
     * @return
     */
    public static Status buildStatus(Result result) {

        boolean isSuccess = result.isSuccess();
        if (isSuccess) {
            return getSuccessStatus();
        } else {
            List<String> errors = result.getErrors();
            String error = errors.get(0);
            Status status = new Status(error, false);
            return status;
        }
    }
}
