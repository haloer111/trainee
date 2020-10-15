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

-- 订单表
create table if not exists `biz_order`
(
    id          bigint not null auto_increment,
    order_no    varchar(64)    default null comment '订单号',
    total_price decimal(19, 2) default 0 comment '订单总价',
    keywords    varchar(255)   default null comment '关键字',
    status      int(10) comment '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
    create_time datetime       default null,
    update_time datetime       default null,
    primary key (id)
) comment '订单表'
;

-- 订单详情表
create table if not exists `biz_order_detail`
(
    id          bigint not null auto_increment,
    order_id    bigint         default null comment '订单id',
    order_no    varchar(64)    default null comment '订单号',
    goods_id    bigint         default null comment '商品id',
    goods_price decimal(19, 2) default 0 comment '商品价格',
    goods_name  varchar(255)   default null comment '商品名字',
    goods_count int(10)        default null comment '商品数量',
    create_time datetime       default null,
    update_time datetime       default null,
    primary key (id)
) comment '订单详情表'
;

-- 用户表
create table if not exists sys_user
(
    id          bigint not null auto_increment,
    username    varchar(64) comment '用户名',
    password    varchar(64) comment '密码',
    icon        varchar(500) comment '头像',
    email       varchar(100) comment '邮箱',
    nick_name   varchar(200) comment '昵称',
    note        varchar(500) comment '备注信息',
    create_time datetime comment '创建时间',
    update_time datetime       default null,
    login_time  datetime comment '最后登录时间',
    status      int(1) default 1 comment '帐号启用状态：0->禁用；1->启用',
    primary key (id)
) comment '用户表'
;

-- 角色表
create table if not exists sys_role
(
    id          bigint not null auto_increment,
    name        varchar(100) comment '名称',
    description varchar(500) comment '描述',
    admin_count int comment '后台用户数量',
    create_time datetime comment '创建时间',
    update_time datetime       default null,
    status      int(1) default 1 comment '启用状态：0->禁用；1->启用',
    sort        int    default 0,
    primary key (id)
) comment '角色表'
;

-- 资源表
create table if not exists sys_resource
(
    id          bigint not null auto_increment,
    name        varchar(100) comment '名称',
    url         varchar(200) comment '资源URL',
    create_time datetime comment '创建时间',
    update_time datetime       default null,
    primary key (id)
) comment '资源表'
;

-- 用户-角色关系表
create table sys_user_role_relation
(
    id       bigint not null auto_increment,
    admin_id bigint,
    role_id  bigint,
    primary key (id)
);

-- 后台角色资源关系表
create table sys_role_resource_relation
(
    id          bigint not null auto_increment,
    role_id     bigint comment '角色ID',
    resource_id bigint comment '资源ID',
    primary key (id)
);
