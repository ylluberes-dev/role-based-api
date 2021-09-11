create database role_base;

use role_base;

create table users
(
    id int,
    name varchar(100),
    email varchar(100),
    password varchar(100)
);

alter table users
    add constraint users_pk
        primary key (id);

create table roles
(
    id int,
    name varchar(100)
);


alter table roles
    add constraint roles_pk
        primary key (id);


create table users_roles
(
    user_id int,
    role_id int
);

alter table users_roles
    add constraint users_roles_pk
        primary key(user_id, role_id);

alter table users_roles
    add constraint fk_ur_users
        foreign key (user_id) references users (id);

alter table users_roles
    add constraint fk_ur_roles
        foreign key (role_id) references roles (id);


create table messages
(
    id int ,
    content varchar(200)
);

alter table messages
    add constraint pk_messages
        primary key(id);


create table persistent_logins
(
    username varchar(64) not null,
    series varchar(64) primary key,
    token varchar(64) not null,
    last_used timestamp not null
);


insert into roles  values (1,'ADMIN');
insert into users value (1,'Yasser','ylluberes19@gmail.com','12345');
insert into users_roles values(1,1);

update users u
set u.password = '$2a$10$ifX3EE.OyIDCPS0FZ4hk/e8sd/2xlkSd06nE9qIu8HLeZ2wf5SvtK'
where 1 = 1;
   