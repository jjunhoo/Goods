package com.musinsa.goods.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "goods")
public class Goods {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_no") // 상품번호
    private Long goodsNo;
    @Column(name = "goods_nm") // 상품명
    private String goodsNm;
    @Column(name = "goods_cont") // 상품설명
    private String goodsCont;
    @Column(name = "com_id") // 업체 아이디
    private String comId;
    @Column(name = "reg_dm") // 상품정보 최초등록일시
    private LocalDateTime regDm;
    @Column(name = "upd_dm") // 상품정보 수정일시
    private LocalDateTime updDm;
}
