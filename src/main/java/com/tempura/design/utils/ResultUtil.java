package com.tempura.design.utils;

import com.tempura.design.common.result.DataResultVO;
import com.tempura.design.common.result.ResultEnum;

/**
 * @author wzs
 * @date 2022/10/18
 */
public class ResultUtil{

    public static <T> DataResultVO<T> success() {
        return success(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null, 0L);
    }

    public static <T> DataResultVO<T> success(T model) {
        return success(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), model, 0L);
    }

    public static <T> DataResultVO<T> success(String code, String message, T model, long total) {
        DataResultVO<T> resultVO = new DataResultVO<>();
        resultVO.setSuccess(true);
        resultVO.setCode(code);
        resultVO.setMessage(message);
        resultVO.setModel(model);
        resultVO.setTotalRecord(total);
        return resultVO;
    }


}
