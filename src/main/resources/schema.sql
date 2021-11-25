-- 상품 마스터 > Table Schema
DROP TABLE goods if EXISTS;
CREATE TABLE goods(
    goods_no BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '상품번호',
    goods_nm VARCHAR(100) NOT NULL COMMENT '상품명',
    goods_cont VARCHAR(10000) NOT NULL COMMENT'상품설명',
    com_id VARCHAR(20) NOT NULL COMMENT '업체 아이디',
    reg_dm DATETIME NOT NULL COMMENT '상품정보 최초등록일시',
    upd_dm DATETIME NOT NULL COMMENT '상품정보 수정일시'
);