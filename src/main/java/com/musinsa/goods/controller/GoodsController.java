package com.musinsa.goods.controller;

import com.musinsa.goods.domain.Goods;
import com.musinsa.goods.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "상품 정보", description = "상품 정보를 등록 및 조회할 수 있습니다.")
@RestController
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    /* TODO
     * 1. 샘플 스키마를 참고하여 스키마 완성
     * 2. API 버저닝 고려
     * 3. 비정상적인 API 호출에 대해 에러 처리가 고려되어야 함 (throttling)
     * 4. 상품 API 가 저장되는 저장소 혹은 방식은 추후 변경될 수 있다는 가정 필요
     * 5. 인증은 고려하지 않는다.
     */

    // TODO : 상품 등록

    // TODO : 상품 조회 (단건 : 상품번호)
    @ApiOperation(value = "상품 조회", response = Goods.class, notes = "상품 번호를 통해 해당 상품의 상품 정보를 조회할 수 있습니다.")
    @GetMapping(value = "/v1/goods/{goodsNo}")
    public Goods findByGoodsNo(@PathVariable("goodsNo") Long goodsNo) {
        return goodsService.findByGoodsNo(goodsNo);
    }

    // TODO : 상품 조회 (다건 : 업체 아이디)
    @ApiOperation(value = "상품 조회", response = Goods.class, notes = "업체 아이디를 통해 해당 업체의 상품 정보를 조회할 수 있습니다.")
    @GetMapping(value = "/v1/companyGoods/{comId}")
    public List<Goods> findByComId(@PathVariable("comId") String comId) {
        return goodsService.findByComId(comId);
    }
}
