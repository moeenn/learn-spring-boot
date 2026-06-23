package com.sandbox.api.common.dto;

import java.util.List;

public record PaginatedResponse<T>(
        List<T> data,
        int total,
        int limit,
        int offset
) {
}
