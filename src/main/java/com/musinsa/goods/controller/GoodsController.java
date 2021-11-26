package com.musinsa.goods.controller;

import com.musinsa.goods.domain.Goods;
import com.musinsa.goods.service.GoodsService;
import com.musinsa.goods.common.util.ResponseObject;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "상품", description = "상품 정보를 등록 및 조회할 수 있습니다.")
@RestController
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    /**
     * 상품 등록 및 수정
     *
     * @param goods
     */
    @ApiOperation(value = "상품 등록/수정", response = Goods.class, notes = "상품을 등록 및 수정할 수 있습니다.")
    @PostMapping(value = "/v1/goods")
    public ResponseEntity<ResponseObject> saveGoods(final @Valid @RequestBody Goods goods) {
        ResponseObject responseObject = new ResponseObject().of(goodsService.saveGoods(goods));

        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    /**
     * 상품 번호를 통해 해당 상품의 상품 정보를 조회
     *
     * @param goodsNo
     * @return
     */
    @ApiOperation(value = "상품 조회", response = Goods.class, notes = "상품 번호를 통해 해당 상품의 상품 정보를 조회할 수 있습니다.")
    @ApiImplicitParam(name = "goodsNo", required = true, dataType = "int", paramType = "path", value = "상품번호", example = "1", defaultValue = "1")
    @GetMapping(value = "/v1/goods/{goodsNo}")
    public ResponseEntity<ResponseObject> findByGoodsNo(@PathVariable("goodsNo") Integer goodsNo) {
        ResponseObject responseObject = new ResponseObject().of(goodsService.findByGoodsNo(goodsNo));

        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    /**
     * 업체 아이디를 통해 해당 업체의 상품 정보를 조회
     *
     * @param comId
     * @return
     */
    @ApiOperation(value = "상품 조회", response = Goods.class, notes = "업체 아이디를 통해 해당 업체의 상품 정보를 조회할 수 있습니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "comId", required = true, dataType = "string", paramType = "path", value = "업체 아이디", example = "test1", defaultValue = "test2")
    })
    @GetMapping(value = "/v1/companyGoods/{comId}")
    public ResponseEntity<ResponseObject> findByComId(@PathVariable("comId") String comId) {
        ResponseObject responseObject = new ResponseObject().of(goodsService.findByComId(comId));

        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
}
