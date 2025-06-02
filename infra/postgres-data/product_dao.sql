create table product_dao
(
    prd_idx    bigint not null
        constraint pk_productdao
            primary key,
    uuid       bigint not null
        constraint fk_productdao_on_uuid
            references user_dao,
    name       varchar(255),
    price      numeric,
    quantity   bigint,
    created_at timestamp,
    expired_at timestamp
);

comment on column product_dao.prd_idx is '상품 ID';

alter table product_dao
    owner to postgres;

INSERT INTO public.product_dao (prd_idx, uuid, name, price, quantity, created_at, expired_at) VALUES (1, 1, '아이폰', 100, 3, '2025-05-20 13:06:15.000000', '2025-05-27 13:06:07.000000');
INSERT INTO public.product_dao (prd_idx, uuid, name, price, quantity, created_at, expired_at) VALUES (2, 1, '갤럭시폰', 90, 4, '2025-05-20 13:06:15.000000', '2025-05-27 13:06:07.000000');
INSERT INTO public.product_dao (prd_idx, uuid, name, price, quantity, created_at, expired_at) VALUES (3, 1, 'Go가이드북', 10, 100, '2025-05-20 13:06:15.000000', '2025-05-27 13:06:07.000000');
