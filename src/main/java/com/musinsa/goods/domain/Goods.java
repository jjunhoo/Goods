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
import java.time.LocalDateTime;

@Entity
@Data
@ApiModel(value = "상품 정보")
@Table(name = "goods")
public class Goods {
    @ApiModelProperty(value = "상품번호", position = 1)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Pattern(regexp = PatternConstants.NUMBER_FORMAT, message = PatternConstants.NUMBER_MSG)
    // TODO : @Size
    @Column(name = "goods_no")
    private Long goodsNo;

    @ApiModelProperty(value = "상품명", required = true, position = 2)
    @NotEmpty(message = "상품명")
    // TODO : @Size
    // @Pattern(regexp = PatternConstants.ENG_NUMBER_FORMAT, message = PatternConstants.ENG_NUMBER_MSG) // TODO :
    @Column(name = "goods_nm")
    // TODO : Bean Validation 추가 > Trouble Shouting > The annotation @NotEmpty is disallowed for this data type > @NotEmpty(message = "상품설명")
    private String goodsNm;

    @ApiModelProperty(value = "상품설명", required = true, position = 3)
    @NotEmpty(message = "상품설명")
    // TODO : @Size
    @Column(name = "goods_cont")
    private String goodsCont;

    @ApiModelProperty(value = "업체 아이디", required = true, position = 4)
    @NotEmpty(message = "업체 아이디")
    // TODO : @Size
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
