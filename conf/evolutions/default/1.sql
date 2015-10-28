# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table aluno (
  id                        bigint not null,
  matricula                 varchar(255) not null,
  nome                      varchar(255) not null,
  cpf                       varchar(255) not null,
  data_nascimento           timestamp,
  constraint uq_aluno_matricula unique (matricula),
  constraint uq_aluno_cpf unique (cpf),
  constraint pk_aluno primary key (id))
;

create table disciplina (
  id                        bigint not null,
  nome                      varchar(255) not null,
  carga_horaria             integer,
  constraint pk_disciplina primary key (id))
;

create table professor (
  id                        bigint not null,
  nome                      varchar(255) not null,
  cpf                       varchar(255),
  constraint uq_professor_cpf unique (cpf),
  constraint pk_professor primary key (id))
;

create table turma (
  id                        bigint not null,
  professor_id              bigint not null,
  disciplina_id             bigint not null,
  constraint pk_turma primary key (id))
;


create table aluno_turma (
  aluno_id                       bigint not null,
  turma_id                       bigint not null,
  constraint pk_aluno_turma primary key (aluno_id, turma_id))
;

create table professor_disciplina (
  professor_id                   bigint not null,
  disciplina_id                  bigint not null,
  constraint pk_professor_disciplina primary key (professor_id, disciplina_id))
;

create table turma_aluno (
  turma_id                       bigint not null,
  aluno_id                       bigint not null,
  constraint pk_turma_aluno primary key (turma_id, aluno_id))
;
create sequence aluno_seq;

create sequence disciplina_seq;

create sequence professor_seq;

create sequence turma_seq;

alter table turma add constraint fk_turma_professor_1 foreign key (professor_id) references professor (id);
create index ix_turma_professor_1 on turma (professor_id);
alter table turma add constraint fk_turma_disciplina_2 foreign key (disciplina_id) references disciplina (id);
create index ix_turma_disciplina_2 on turma (disciplina_id);



alter table aluno_turma add constraint fk_aluno_turma_aluno_01 foreign key (aluno_id) references aluno (id);

alter table aluno_turma add constraint fk_aluno_turma_turma_02 foreign key (turma_id) references turma (id);

alter table professor_disciplina add constraint fk_professor_disciplina_profe_01 foreign key (professor_id) references professor (id);

alter table professor_disciplina add constraint fk_professor_disciplina_disci_02 foreign key (disciplina_id) references disciplina (id);

alter table turma_aluno add constraint fk_turma_aluno_turma_01 foreign key (turma_id) references turma (id);

alter table turma_aluno add constraint fk_turma_aluno_aluno_02 foreign key (aluno_id) references aluno (id);

# --- !Downs

drop table if exists aluno cascade;

drop table if exists aluno_turma cascade;

drop table if exists disciplina cascade;

drop table if exists professor cascade;

drop table if exists professor_disciplina cascade;

drop table if exists turma cascade;

drop table if exists turma_aluno cascade;

drop sequence if exists aluno_seq;

drop sequence if exists disciplina_seq;

drop sequence if exists professor_seq;

drop sequence if exists turma_seq;

