create database test;
use test;
create table pessoa( id int not null auto_increment, 
nome varchar(30) not null,  
sexo varchar(30), 
dataNascimentcategoryo date, 
endereco varchar(30), 
telefone int not null, primary key(id) );

insert pessoa values(null, 'emanuel', 'm', '2004-06-07', 'aguas', 994656215);

select * from pessoaTables