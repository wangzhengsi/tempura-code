package com.tempura.code.common.result;

/**
 * @author wzs
 * @date 2022/10/18
 */
public class ResultUtil{

    public static <T> Result<T> success() {
        return success(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null, 0L);
    }

    public static <T> Result<T> success(T model) {
        return success(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), model, 0L);
    }

    public static <T> Result<T> success(String code, String message, T model, long total) {
        Result<T> resultVO = new Result<>();
        resultVO.setSuccess(true);
        resultVO.setCode(code);
        resultVO.setMessage(message);
        resultVO.setModel(model);
        resultVO.setTotalRecord(total);
        return resultVO;
    }


}
