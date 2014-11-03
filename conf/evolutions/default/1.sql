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

create table company (
  company_id                bigint auto_increment not null,
  title                     varchar(255) not null,
  create_date               datetime not null,
  update_date               datetime not null,
  constraint pk_company primary key (company_id))
;

create table site (
  site_id                   bigint auto_increment not null,
  title                     varchar(255) not null,
  url                       varchar(191) not null,
  category_id               bigint,
  company_id                bigint,
  create_date               datetime not null,
  update_date               datetime not null,
  constraint uq_site_url unique (url),
  constraint pk_site primary key (site_id))
;

create table tag (
  tag_id                    bigint auto_increment not null,
  title                     varchar(255) not null,
  create_date               datetime not null,
  update_date               datetime not null,
  constraint pk_tag primary key (tag_id))
;

create table tag_site_map (
  map_id                    bigint auto_increment not null,
  tag_id                    bigint,
  site_id                   bigint,
  create_date               datetime not null,
  update_date               datetime not null,
  constraint pk_tag_site_map primary key (map_id))
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
alter table site add constraint fk_site_company_2 foreign key (company_id) references company (company_id) on delete restrict on update restrict;
create index ix_site_company_2 on site (company_id);
alter table tag_site_map add constraint fk_tag_site_map_tag_3 foreign key (tag_id) references tag (tag_id) on delete restrict on update restrict;
create index ix_tag_site_map_tag_3 on tag_site_map (tag_id);
alter table tag_site_map add constraint fk_tag_site_map_site_4 foreign key (site_id) references site (site_id) on delete restrict on update restrict;
create index ix_tag_site_map_site_4 on tag_site_map (site_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table category;

drop table company;

drop table site;

drop table tag;

drop table tag_site_map;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

