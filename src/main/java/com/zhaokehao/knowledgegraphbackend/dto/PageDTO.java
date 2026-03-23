package com.zhaokehao.knowledgegraphbackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageDTO<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Long total;
    private Integer totalPages;
    private List<T> records;

    // 计算总页数（静态工具方法）
    public static int calculateTotalPages(Long total, Integer pageSize) {
        if (total == 0 || pageSize == 0) {
            return 0;
        }
        return (int) (total % pageSize == 0 ? total / pageSize : total / pageSize + 1);
    }

}
