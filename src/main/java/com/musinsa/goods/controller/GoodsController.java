package com.musinsa.goods.controller;

import com.musinsa.goods.domain.Goods;
import com.musinsa.goods.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "상품", description = "상품 정보를 등록 및 조회할 수 있습니다.")
@RestController
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    /* TODO : 요구사항
     * 1. (완료) 샘플 스키마를 참고하여 스키마 완성
     *  - TODO : 기타 테이블 추가 생성 고민
     * 2. (완료) API 버저닝 고려
     *  - https://restfulapi.net/versioning/
     *  - https://www.baeldung.com/rest-versioning
     *  - 2-1. End-Point Versioning > v1 / v2
     *  - 2-2. Http Header Versioning
     * 3. 비정상적인 API 호출에 대해 에러 처리가 고려되어야 함 (throttling)
     *  - https://gardeny.tistory.com/44 (호출 횟수 제한)
     *  - https://javacan.tistory.com/entry/ratelimiter-ratelimitj-bucket4j-intro (RateLimiter, RateLimitJ, Bucket4j)
     *  - https://happyer16.tistory.com/entry/API-rate-limiting-request-throttling-%EA%B0%9C%EB%B0%9C%ED%95%98%EA%B8%B0 (Guava > Redis - API rate-limiting)
     *  - 3-1. CSRF (무차별 Request)
     * 4. 상품 API 가 저장되는 저장소 혹은 방식은 추후 변경될 수 있다는 가정 필요
     * 5. 인증은 고려하지 않는다.
     */

    /**
     * 상품 등록 및 수정
     * @param goods
     */
    @ApiOperation(value = "상품 등록/수정", response = Goods.class, notes = "상품을 등록 및 수정할 수 있습니다.")
    @PostMapping(value = "/v1/goods")
    public Long saveGoods(final @Valid Goods goods) { // TODO : 추후 @RequestBody 추가
        return goodsService.saveGoods(goods);
    }

    /**
     * 상품 번호를 통해 해당 상품의 상품 정보를 조회
     * @param goodsNo
     * @return
     */
    @ApiOperation(value = "상품 조회", response = Goods.class, notes = "상품 번호를 통해 해당 상품의 상품 정보를 조회할 수 있습니다.")
    @ApiImplicitParam(name = "goodsNo", required = true, dataType = "long", paramType = "path", value = "상품번호", defaultValue = "1")
    @GetMapping(value = "/v1/goods/{goodsNo}")
    public Goods findByGoodsNo(@PathVariable("goodsNo") Long goodsNo) {
        return goodsService.findByGoodsNo(goodsNo);
    }

    /**
     * 업체 아이디를 통해 해당 업체의 상품 정보를 조회
     * @param comId
     * @return
     */
    @ApiOperation(value = "상품 조회", response = Goods.class, notes = "업체 아이디를 통해 해당 업체의 상품 정보를 조회할 수 있습니다.")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "comId", required = true, dataType = "string", paramType = "path", value = "업체 아이디", defaultValue = "test2")
    })
    @GetMapping(value = "/v1/companyGoods/{comId}")
    public List<Goods> findByComId(@PathVariable("comId") String comId) {
        return goodsService.findByComId(comId);
    }
}
