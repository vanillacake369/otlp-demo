# Purpose of this project
# Architecture
# Why ?
# Features
1. 회원이 외부결제 API 를 통해 포인트를 충전한다.
2. 회원이 상품 N 개를 포인트로 구매한다.
3. 구매한 상품 갯수에 따라 상품 재고가 차감된다.
4. 구매한 포인트 수에 따라 회원 포인트 잔액이 차감뙨다.
5. 결제에 따라 주문서가 발급된다.
6. 주문서에 따라 판매자의 포인트가 충전된다.
7. 충전된 포인트는 화폐로 변환 가능하다. 
# Domain
1. 회원 :: 구매자/판매자
2. 결제 :: 포인트 사용내역
3. 상품
4. 주문서
# Concurrency Control
PostgreSQL MVCC 와 Vacuum 에 따라 처리
# Reference