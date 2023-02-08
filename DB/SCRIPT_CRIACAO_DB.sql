CREATE DATABASE app_controle_vencimentos;

USE app_controle_vencimentos;

create table perfil
	(
	id int not null primary key auto_increment,
    nome varchar(50) not null,
    descricao varchar(120) not null
	);

create table usuario
	(
    id int primary key not null auto_increment,
	usuario varchar(20) not null,
    senha varchar(32) not null,
    perfil_id int not null,
    ativo varchar(3) not null default 'NÃO',
    logado varchar(3) default 'NÃO',
    foreign key(perfil_id) references perfil(id)
    );
    
create table tipo_veiculo
	(
	id int primary key not null auto_increment,
	nome varchar(50) unique not null
    );

create table veiculo
	(
	id int primary key not null auto_increment,
	placa varchar(10) unique not null,
    modelo varchar(50) not null,
    tipo_id int not null,
    bottom varchar(3) not null default 'NÃO',
    ativo varchar(3) not null default 'NÃO'
	);

create table motorista
	(
    id int primary key not null auto_increment,
	nome varchar(50) not null,
    ativo varchar(3) not null default 'NÃO'
    );
    
create table emissor
	(
    id int primary key not null auto_increment,
	nome varchar(50) not null
    );
    
create table licenca
	(
	id int primary key not null auto_increment,
	nome varchar(50) not null,
    emissor_id int not null,
    ativo varchar(3) not null default 'NÃO',
    foreign key(emissor_id) references emissor(id)
    );
    
create table documento
	(
	id int primary key not null auto_increment,
	nome varchar(50) not null,
    emissor_id int not null,  
	ativo varchar(3) not null default 'NÃO',
    foreign key(emissor_id) references emissor(id)
    );
    
create table licenca_veiculo
	(
    licenca_id int not null,
    veiculo_id int not null,
    numero varchar(20) not null,
    data_emissao date not null,
    data_validade date not null,
    ativo varchar(3) not null default 'NÃO',
    usuario_id int not null,
    primary key(licenca_id, veiculo_id),
    foreign key(usuario_id) references usuario(id)
    );  
    
create table documento_veiculo
	(
    documento_id int not null,
    veiculo_id int not null,
    numero varchar(20) not null,
    data_emissao date not null,
    data_validade date not null,
    ativo varchar(3) not null default 'NÃO',
    usuario_id int not null,
    primary key(documento_id, veiculo_id),
    foreign key(usuario_id) references usuario(id)
    );
    
create table documento_motorista
	(
    motorista_id int not null,
    documento_id int not null,
    numero varchar(20) not null,
    data_emissao date not null,
    data_validade date not null,
    ativo varchar(3) not null default 'NÃO',
    usuario_id int not null,
    primary key(motorista_id, documento_id),
    foreign key(usuario_id) references usuario(id)
    );
    
create table motorista_veiculo
	(
    motorista_id int not null,
    veiculo_id int not null,
    data_inicial date not null,
    data_final date,
    ativo varchar(3) not null default 'NÃO',
    usuario_id int not null,
    primary key(motorista_id, veiculo_id),
    foreign key(usuario_id) references usuario(id)
    );
    
create table historico_acessos
	(
    id int primary key not null,
    usuario_id int not null,
    acesso date not null,
    foreign key(usuario_id) references usuario(id)
    );
