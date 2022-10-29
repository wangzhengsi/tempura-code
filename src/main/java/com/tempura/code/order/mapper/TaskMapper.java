package com.tempura.code.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Mapper
public interface TaskMapper {

    /**
     * 数据插入
     * @param taskContent 内容
     */
    void insert(@Param("taskContent") String taskContent);
}
