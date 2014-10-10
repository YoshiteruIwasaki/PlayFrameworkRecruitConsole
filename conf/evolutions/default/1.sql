# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table category (
  category_id               bigint not null,
  title                     varchar(255) not null,
  sort_order                integer not null,
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint uq_category_sort_order unique (sort_order),
  constraint pk_category primary key (category_id))
;

create table company (
  company_id                bigint not null,
  title                     varchar(255) not null,
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint pk_company primary key (company_id))
;

create table site (
  site_id                   bigint not null,
  title                     varchar(255) not null,
  url                       varchar(191) not null,
  category_id               bigint,
  company_id                bigint,
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint uq_site_url unique (url),
  constraint pk_site primary key (site_id))
;

create table tag (
  tag_id                    bigint not null,
  title                     varchar(255) not null,
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint pk_tag primary key (tag_id))
;

create table tag_site_map (
  map_id                    bigint not null,
  tag_id                    bigint,
  site_id                   bigint,
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint pk_tag_site_map primary key (map_id))
;

create table user (
  user_id                   bigint not null,
  email                     varchar(191),
  password                  varchar(255),
  create_date               timestamp not null,
  update_date               timestamp not null,
  constraint uq_user_email unique (email),
  constraint pk_user primary key (user_id))
;

create sequence category_seq;

create sequence company_seq;

create sequence site_seq;

create sequence tag_seq;

create sequence tag_site_map_seq;

create sequence user_seq;

alter table site add constraint fk_site_category_1 foreign key (category_id) references category (category_id);
create index ix_site_category_1 on site (category_id);
alter table site add constraint fk_site_company_2 foreign key (company_id) references company (company_id);
create index ix_site_company_2 on site (company_id);
alter table tag_site_map add constraint fk_tag_site_map_tag_3 foreign key (tag_id) references tag (tag_id);
create index ix_tag_site_map_tag_3 on tag_site_map (tag_id);
alter table tag_site_map add constraint fk_tag_site_map_site_4 foreign key (site_id) references site (site_id);
create index ix_tag_site_map_site_4 on tag_site_map (site_id);



# --- !Downs

drop table if exists category cascade;

drop table if exists company cascade;

drop table if exists site cascade;

drop table if exists tag cascade;

drop table if exists tag_site_map cascade;

drop table if exists user cascade;

drop sequence if exists category_seq;

drop sequence if exists company_seq;

drop sequence if exists site_seq;

drop sequence if exists tag_seq;

drop sequence if exists tag_site_map_seq;

drop sequence if exists user_seq;

