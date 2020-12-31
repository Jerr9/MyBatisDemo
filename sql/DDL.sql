-- we don't know how to generate schema mybatis_demo (class Schema) :(
create table tb_order_detail
(
	id int(4) auto_increment
		primary key,
	order_id varchar(128) not null,
	detail_id bigint not null,
	create_time datetime default CURRENT_TIMESTAMP null,
	update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
	constraint tb_order_detail_unique_index
		unique (detail_id)
)
engine=InnoDB charset=utf8
;

create table tb_order_master
(
	id int(4) auto_increment
		primary key,
	order_id varchar(128) not null,
	order_status tinyint default '0' not null comment '0：待支付、10：已支付、20：已发货、30：已完成、40：已取消',
	cancel_time datetime null,
	cancel_type tinyint default '0' not null comment '0：默认状态（未取消）、10：超时未支付、20：用户取消、30：其他原因',
	pay_status tinyint default '0' not null,
	pay_time datetime null,
	user_id varchar(256) not null,
	create_time datetime default CURRENT_TIMESTAMP null,
	update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
	constraint tb_order_master_unique_index
		unique (order_id)
)
engine=InnoDB charset=utf8
;

create table tb_product
(
	product_id int auto_increment
		primary key,
	product_name varchar(256) not null,
	price decimal(9,2) not null,
	product_description varchar(512) default '' null,
	is_sale tinyint(2) default '0' not null comment '是否在售。0：下架、1：在售',
	stock int(8) unsigned default '0' not null,
	category_id int(4) null,
	product_icon varchar(256) default '' null,
	create_time datetime default CURRENT_TIMESTAMP null,
	update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
)
engine=InnoDB charset=utf8
;

create table tb_product_category
(
	category_id int(4) auto_increment
		primary key,
	category_name varchar(256) not null,
	category_description varchar(512) default '' null,
	category_icon varchar(256) default '' null,
	create_time datetime default CURRENT_TIMESTAMP null,
	update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
	constraint tb_product_unique_index
		unique (category_id)
)
engine=InnoDB charset=utf8
;

create table tb_role
(
	role_id mediumint auto_increment
		primary key,
	role_name varchar(128) null,
	create_time datetime default CURRENT_TIMESTAMP null,
	update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
)
engine=InnoDB charset=utf8
;

create table tb_user
(
	id int auto_increment
		primary key,
	uid varchar(128) not null,
	role_id mediumint not null default 1000;
	name varchar(64) not null,
	age int(8) not null,
	sex int(4) not null,
	create_time datetime default CURRENT_TIMESTAMP null,
	update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
	constraint tb_user_unique_index
		unique (uid)
)
engine=InnoDB charset=utf8
;

