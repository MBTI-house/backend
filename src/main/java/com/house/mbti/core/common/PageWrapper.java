package com.house.mbti.core.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageWrapper<T> {
    int page;
    int size;
    Long totalCount;
    List<T> list;
}
