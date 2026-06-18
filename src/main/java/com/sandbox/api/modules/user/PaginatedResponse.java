package com.sandbox.api.modules.user;

import java.util.List;

public record PaginatedResponse<T>(
        List<T> data,
        int total,
        int limit,
        int offset
) {
}
