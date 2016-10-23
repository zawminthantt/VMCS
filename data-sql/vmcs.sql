drop database if exists vmcs;

create database vmcs;

use vmcs;

create table CashPropertyFile (
	name varchar(8) not null primary key,
	[value] varchar(128) not null,
	quantity varchar(128) not null,
	weight varchar(128) not null
);

create table DrinkPropertyFile (
	name varchar(8) not null primary key,
	quantity varchar(128) not null,
	price varchar(128) not null
);