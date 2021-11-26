package com.musinsa.goods.common.valid;

import com.musinsa.goods.common.constants.ExceptionCode;
import com.musinsa.goods.common.exception.BusinessLogicException;
import com.musinsa.goods.domain.Goods;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ValidGoods {
    /**
     * 상품 정보 Validation
     * @param goods
     */
    public static void validGoods(final Goods goods) {
        // 상품번호 Validation
        if (goods.getGoodsNo() < 0) {
            throw new BusinessLogicException(ExceptionCode.ERROR_CODE_2002);
        }
    }
}
