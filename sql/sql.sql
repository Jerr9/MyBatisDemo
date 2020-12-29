create table tb_user
(
  id   int(128) auto_increment
    primary key,
  name varchar(64) not null,
  age  int(8)      not null,
  sex  int(4)      not null
)
  engine = InnoDB;


