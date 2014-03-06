# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table category (
  category_id               bigint auto_increment not null,
  title                     varchar(255) not null,
  sort_order                integer not null,
  create_date               datetime not null,
  update_date               datetime not null,
  constraint uq_category_sort_order unique (sort_order),
  constraint pk_category primary key (category_id))
;

create table site (
  site_id                   bigint auto_increment not null,
  title                     varchar(255) not null,
  url                       varchar(191) not null,
  category_id               bigint,
  create_date               datetime not null,
  update_date               datetime not null,
  constraint uq_site_url unique (url),
  constraint pk_site primary key (site_id))
;

create table user (
  user_id                   bigint auto_increment not null,
  email                     varchar(191),
  password                  varchar(255),
  create_date               datetime not null,
  update_date               datetime not null,
  constraint uq_user_email unique (email),
  constraint pk_user primary key (user_id))
;

alter table site add constraint fk_site_category_1 foreign key (category_id) references category (category_id) on delete restrict on update restrict;
create index ix_site_category_1 on site (category_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table category;

drop table site;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

