package com.musinsa.goods.service;

import com.musinsa.goods.domain.Goods;
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
    public void saveGoods(Goods goods) {
        // TODO : 상품번호가 없는 경우 - 등록, 상품번호가 있는 경우 - 수정
        /*if (goods.getGoodsNo()) {

        }*/
        goods.setRegDm(LocalDateTime.now());
        goods.setUpdDm(LocalDateTime.now());

        goodsRepository.save(goods);
    }

    /**
     * 상품 번호를 통해 해당 상품의 상품 정보를 조회
     * @param goodsNo
     * @return
     */
    public Goods findByGoodsNo(Long goodsNo) {
        return goodsRepository.findById(goodsNo).orElseThrow(); // TODO : 예외 처리 (커스텀 Exception)
    }

    /**
     * 업체 아이디를 통해 해당 업체의 상품 정보를 조회
     * @param comId
     * @return
     */
    public List<Goods> findByComId(String comId) {
        return goodsRepository.findByComId(comId).orElseThrow(); // TODO : 예외 처리 (커스텀 Exception)
    }
}
