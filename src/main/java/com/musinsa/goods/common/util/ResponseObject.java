package com.musinsa.goods.common.util;

import lombok.Data;

@Data
public class ResponseObject {
    private Object data;

    public ResponseObject of(Object data) {
        this.data = data;
        return this;
    }
}
