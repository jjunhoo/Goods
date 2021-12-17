package com.musinsa.goods.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@ApiModel(value = "상품 정보")
@Table(name = "goods")
public class Goods {
    @ApiModelProperty(value = "상품번호", position = 1)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_no")
    private int goodsNo;

    @ApiModelProperty(value = "상품명", required = true, position = 2)
    @NotEmpty(message = "상품명")
    @Size(max = 100, message = "상품명")
    @Column(name = "goods_nm")
    private String goodsNm;

    @ApiModelProperty(value = "상품설명", required = true, position = 3)
    @NotEmpty(message = "상품설명")
    @Column(name = "goods_cont")
    private String goodsCont;

    @ApiModelProperty(value = "업체 아이디", required = true, position = 4)
    @NotEmpty(message = "업체 아이디")
    @Size(max = 20, message = "업체 아이디")
    @Column(name = "com_id")
    private String comId;

    @ApiModelProperty(value = "상품정보 최초등록일시", hidden = true, position = 5)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    @Column(name = "reg_dm")
    private LocalDateTime regDm;

    @ApiModelProperty(value = "상품정보 수정일시", hidden = true, position = 6)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    @Column(name = "upd_dm")
    private LocalDateTime updDm;
}
