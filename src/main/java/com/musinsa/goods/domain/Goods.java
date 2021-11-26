package com.musinsa.goods.domain;

import com.musinsa.goods.common.constants.PatternConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@ApiModel(value = "상품 정보")
@Table(name = "goods")
public class Goods implements Serializable {
    // TODO : @Size
    // TODO : // @Pattern(regexp = PatternConstants.NUMBER_FORMAT, message = PatternConstants.NUMBER_MSG)
    @ApiModelProperty(value = "상품번호", position = 1)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_no")
    private Long goodsNo;

    // TODO : 업체 상품 번호
    /*@ApiModelProperty(value = "업체상품번호", position = 7)
    private String comGoodsNo;*/

    @ApiModelProperty(value = "상품명", required = true, position = 2)
    @NotEmpty(message = "상품명")
    @Column(name = "goods_nm")
    private String goodsNm;

    @ApiModelProperty(value = "상품설명", required = true, position = 3)
    @NotEmpty(message = "상품설명")
    @Column(name = "goods_cont")
    private String goodsCont;

    @ApiModelProperty(value = "업체 아이디", required = true, position = 4)
    @NotEmpty(message = "업체 아이디")
    @Column(name = "com_id")
    private String comId;

    @ApiModelProperty(value = "상품정보 최초등록일시", position = 5)
    @ApiParam(hidden = true)
    @Column(name = "reg_dm")
    private LocalDateTime regDm;

    @ApiModelProperty(value = "상품정보 수정일시", position = 6)
    @ApiParam(hidden = true)
    @Column(name = "upd_dm")
    private LocalDateTime updDm;
}
