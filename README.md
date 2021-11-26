# 상품 등록/조회 REST API

### 1. Swagger
- Swagger : http://localhost:8080/swagger-ui.html

### 2. API 
- 상품 조회 (Param : 업체 아이디) : GET
   ```HTTP
   http://localhost:8080/v1/companyGoods/{comId}
   ```
- 상품 조회 (Param : 상품번호) : GET
   ```HTTP
   http://localhost:8080/v1/goods/{goodsNo}
   ```
- 상품 등록/수정 : POST
   ```HTTP
   http://localhost:8080/v1/goods
   ```
    1. 존재하는 상품번호 (goodsNo) 를 입력하여 API 를 호출하는 경우, 수정
    ```json
       {
         "goodsNo": 3,
         "goodsNm": "[테스트]상품명",
         "goodsCont": "[테스트]상품설명",
         "comId": "companyId1"
       }
    ```
    2. 상품번호를 입력하지 않거나, 0으로 입력하여 API 를 호출하는 경우, 등록
    ```json
       {
         "goodsNo": 0,
         "goodsNm": "[테스트]상품명",
         "goodsCont": "[테스트]상품설명",
         "comId": "companyId1"
       }
       또는
       {
         "goodsNm": "[테스트]상품명",
         "goodsCont": "[테스트]상품설명",
         "comId": "companyId1"
       }
    ```
    * 인증 프로세스는 고려하지 않기 때문에 상품번호 존재 유무만 Validation  