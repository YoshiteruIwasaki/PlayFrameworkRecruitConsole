# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table site (
  site_id                   bigint auto_increment not null,
  title                     varchar(255),
  url                       longtext,
  create_date               datetime not null,
  update_date               datetime not null,
  constraint pk_site primary key (site_id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table site;

SET FOREIGN_KEY_CHECKS=1;

