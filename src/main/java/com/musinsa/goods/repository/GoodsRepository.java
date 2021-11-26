package com.musinsa.goods.repository;

import com.musinsa.goods.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    /**
     * 업체 아이디를 통한 상품 조회
     * @param comId
     * @return
     */
    Optional<List<Goods>> findByComId(String comId);
}
