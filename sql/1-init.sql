-- 商品表
create table if not exists `biz_goods`
(
    id          bigint not null auto_increment,
    name        varchar(64)    default null comment '商品名称',
    goods_count int            default 0 comment '商品数量',
    icon        varchar(64)    default null comment '商品图标',
    price       decimal(19, 2) default 0 comment '商品价格',
    keywords    varchar(255)   default null comment '关键字',
    status      tinyint(4)     default 1 comment '有效标识，0-无效，1-有效',
    create_time datetime       default null,
    update_time datetime       default null,
    primary key (id)
) comment '商品表'
;