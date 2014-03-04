# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table site (
  site_id                   bigint auto_increment not null,
  title                     longtext not null,
  url                       varchar(191) not null,
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




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table site;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

