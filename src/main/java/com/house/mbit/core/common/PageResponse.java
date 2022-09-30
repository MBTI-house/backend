package com.house.mbit.core.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageResponse<T> {
    int page;
    int size;
    Long totalCount;
    List<T> items;
}
