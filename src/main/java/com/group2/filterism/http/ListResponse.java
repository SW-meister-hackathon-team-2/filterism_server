package com.group2.filterism.http;

import java.util.List;

public record ListResponse<V>(
        List<V> data,
        int dataOfNumber
) {
    public ListResponse(List<V> data) {
        this(data, data.size());
    }
}
