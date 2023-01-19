create table USER
(
    user_id bigint not null auto_increment,
    provider varchar(255),
    slogan varchar(255),
    token varchar(255),
    primary key (user_id));

create table HABIT
(
    habit_id bigint not null auto_increment,
    emoji varchar(255),
    name varchar(255),
    status varchar(255),
    target_cnt integer,
    user_id bigint,
    primary key (habit_id),
    foreign key (user_id) references user (user_id)
);