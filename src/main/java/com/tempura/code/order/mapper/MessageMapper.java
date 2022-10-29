package com.tempura.code.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wzs
 * @since 2022/10/29
 */
@Mapper
public interface MessageMapper {

    /**
     * 数据插入
     * @param messageContent 内容
     */
    void insert(@Param("messageContent") String messageContent);
}
