show tables;
select * from score;
select  count()from score;
-- 表名
select 1 as "随便"from score;
-- 求和 平均值 最大值 最小值
select sum(score) from score;
select avg(score) from score;
select max(score) from score;
select min(score) from score;

create table emp(
  id int primary key auto_increment,
  name varchar(20) not null,
  role varchar(20) not null,
  salary numeric(11,2)
);
insert into emp(name, role, salary) values
('马云','服务员', 1000.20),
('马化腾','游戏陪玩', 2000.99),
('孙悟空','游戏角色', 999.11),
('猪无能','游戏角色', 333.5),
('沙和尚','游戏角色', 700.33),
('隔壁老王','董事长', 12000.66);

-- 查询工资的最高值 最小值 平均值
select role,max(salary),min(salary),avg(salary)from emp group by role;

select name,role,max(salary),min(salary),avg(salary),
       name from emp group by  role,name having avg(salary)>1000;


insert into emp(name, role, salary) values
 ('马云','服务员', 1000.20),
('马化腾','游戏陪玩', 2000.99);

select * from emp;

insert into emp(name,role,salary) values
                                         ('马云','服务员', 1000.20);

select * from emp;

select role,max(salary),min(salary),avg(salary),
       name from emp where id>3 group by role,name having avg(salary)>1000;

-- 内连接
select * from classes cls join
                  student s on cls.id = s.classes_id;

select score from student stu,score sco
where st.id=sco.student_id and stu.name='许仙';

select * from classes cls join student s
      on cls.id=s.classes_id
join score s2 on s.id = s2.student_id
join course c on s2.course_id = c.id;

select cls.id,sum(s2.score) from classes cls join student s
                  on cls.id=s.classes_id
                          join score s2 on s.id = s2.student_id
                          join course c on s2.course_id = c.id
                          group by cls.id;

select cls.id,cls .name,s.name,sum(s2.score) from classes cls
      join student s
      on cls.id=s.classes_id
      join score s2 on s.id = s2.student_id
      join course c on s2.course_id = c.id
      group by cls.id,s.id having sum(s2.score)>200;

-- 外连接
select s.id,s.name from studnet s
                          join score s2 on s.id=s2.student_id
                          group by s.id;

-- 查询各个班级语文课程的总分
select s.id,s.name,s2.score from student s
      join score s2 on s.id = s2.student_id
      join course c on s2.course_id=c.id
      where c.name='语文';

-- 查询各个班级没门课程的总分
select c2.name,c.name,sum(s2.score) from student s
join score s2 on s.id = s2.student_id
join course c on s2.course_id=c.id
join classes c2 on s.classes_id = c2.id
group by c2.id,c.id;




-- 先查询“计算机原理”和“Java”课程的id
select id,name from course where name='Java' or name='计算机原理';
-- 再查询成绩表中，“计算机原理”成绩比“Java”成绩 好的信息
SELECT
       s1.*
FROM
     score s1,
     score s2,
     course c,
     course c2
WHERE
    s1.student_id = s2.student_id
  and s1.course_id=c.id
  and s2.course_id=c2.id
  AND s1.score > s2.score
  AND c.name='计算机原理'
  and c2.name='java';
-- 也可以使用join on 语句来进行自连接查询
SELECT
       s1.*
FROM
     score s1
       JOIN score s2 ON s1.student_id = s2.student_id
                          AND s1.score < s2.score
                          AND s1.course_id = 1
                          AND s2.course_id = 3;
