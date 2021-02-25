create
database if not exists test;

use
test;

drop table if exists people;

create table people
(
    id          int auto_increment not null primary key,
    first_name  varchar(30) default '',
    last_name   varchar(30) default '',
    create_time datetime    default CURRENT_DATE()
)
