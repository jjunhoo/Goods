package com.musinsa.goods.service;

import com.musinsa.goods.common.constants.ExceptionCode;
import com.musinsa.goods.common.valid.ValidGoods;
import com.musinsa.goods.domain.Goods;
import com.musinsa.goods.common.exception.BusinessLogicException;
import com.musinsa.goods.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GoodsService {
    private final GoodsRepository goodsRepository;

    /**
     * 상품 등록 및 수정
     * @param goods
     */
    @Transactional
    public Integer saveGoods(final Goods goods) {
        LocalDateTime localDateTime = LocalDateTime.now();

        if (goods.getGoodsNo() == 0) { // 상품 등록
            goods.setRegDm(localDateTime);
            goods.setUpdDm(localDateTime);

            return goodsRepository.save(goods).getGoodsNo();
        } else { // 상품 수정
            ValidGoods.validGoods(goods); // 상품 정보 Validation

            Goods goodsInfo = goodsRepository.findById(goods.getGoodsNo()).orElseThrow(() -> { throw new BusinessLogicException(ExceptionCode.ERROR_CODE_1001, "상품번호"); });
            goodsInfo.setGoodsNm(goods.getGoodsNm());
            goodsInfo.setGoodsCont(goods.getGoodsCont());
            goodsInfo.setComId(goods.getComId());
            goodsInfo.setUpdDm(localDateTime);

            return goodsInfo.getGoodsNo();
        }
    }

    /**
     * 상품 번호를 통해 해당 상품의 상품 정보를 조회
     * @param goodsNo
     * @return
     */
    public Goods findByGoodsNo(Integer goodsNo) {
        return goodsRepository.findById(goodsNo).orElseThrow(() -> { throw new BusinessLogicException(ExceptionCode.ERROR_CODE_1001, "상품번호"); });
    }

    /**
     * 업체 아이디를 통해 해당 업체의 상품 정보를 조회
     * @param comId
     * @return
     */
    public List<Goods> findByComId(String comId) {
        return goodsRepository.findByComId(comId).orElseThrow(() -> { throw new BusinessLogicException(ExceptionCode.ERROR_CODE_1001, "업체 아이디"); });
    }
}
