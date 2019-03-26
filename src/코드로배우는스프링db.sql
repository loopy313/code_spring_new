select * from tbl_reply where bno=22 ;

drop table tbl_board;
create sequence seq_board nocache;
create table tbl_board(
    bno number(10,0),
    title varchar2(200) not null,
    content varchar2(2000) not null,
    writer varchar2(50) not null,
    regdate date default sysdate,
    updatedate date default sysdate);
    
alter table tbl_board add constraint pk_board primary key(bno);

insert into tbl_board(bno,title,content,writer) values(seq_board.nextval,'test title','test content','user00');
insert into tbl_board(bno,title,content,writer) select seq_board.nextval,title,content,writer from tbl_board;

select * from (select /*+index_desc(tbl_board pk_board)*/rownum rn,bno,title,content,writer,regdate,updatedate
from tbl_board where title like '%Test%' and rownum<=20) where rn>10;

select * from (select /*+index_desc(tbl_board pk_board)*/rownum rn,bno,title,content,writer,regdate,updatedate
from tbl_board rownum<=20) where rn>10;

select /*+index_asc(tbl_board pk_board)*/rownum rn,bno,title from tbl_board where rownum<=20;
delete from tbl_board;
desc tbl_board;

create table tbl_reply(
rno number(10,0),
bno number(10,0) not null,
reply varchar2(1000) not null,
replyer varchar2(50) not null,
replyDate date default sysdate,
updateDate date default sysdate
);
desc tbl_reply;
alter table tbl_reply rename column replayer to replyer;
create sequence seq_reply nocache;
alter table tbl_reply add constraint pk_reply primary key(rno);
alter table tbl_reply add constraint fk_reply_board foreign key(bno) references tbl_board(bno);

select * from tbl_reply order by bno asc;
delete from tbl_reply;

insert into tbl_reply (rno,bno,reply,replyer) values(seq_reply.nextval,65536,'aaa','bbb');
select * from tbl_reply where rno=5; 

 select /*+index_asc(tbl_reply ron)*/rno,bno,reply,replyer,replyDate,updatedate
        from tbl_reply order by rno desc;
select * from tbl_reply;
select to_date(replydate,'yyyy-mm-dd hh24:mi:ss') from tbl_reply where bno=22;

select sysdate from dual;
select to_date(sysdate,'yyyy-mm-dd hh24:mi:ss') from dual;

create index idx_reply on tbl_reply(bno desc,rno asc);
drop index idx_reply;

select /*+index(tbl_reply idx_reply)*/rownum,bno,rno,reply from tbl_reply;
select /*+index(tbl_reply idx_reply)*/rownum rn,bno,rno,reply,replyer,replyDate,updateDate from tbl_reply where bno=65536 and rno>0;

create table tbl_sample1(col1 varchar2(500));
create table tbl_sample2(col2 varchar2(50));
select * from tbl_sample1;
select * from tbl_sample2;

delete tbl_sample1;
delete tbl_sample2;
commit;