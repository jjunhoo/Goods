package com.musinsa.goods.service;

import com.musinsa.goods.domain.Goods;
import com.musinsa.goods.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GoodsService {
    private final GoodsRepository goodsRepository;

    // TODO : 상품 등록

    // TODO : 상품 조회 (단건 : 상품번호)
    public Goods findByGoodsNo(Long goodsNo) {
        return goodsRepository.findById(goodsNo).orElseThrow(); // TODO : 예외 처리 (커스텀 Exception)
    }

    // TODO : 상품 조회 (다건 : 업체 아이디)
    public List<Goods> findByComId(String comId) {
        return goodsRepository.findByComId(comId).orElseThrow(); // TODO : 예외 처리 (커스텀 Exception)
    }
}
