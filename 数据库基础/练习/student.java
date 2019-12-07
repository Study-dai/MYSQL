-- 创建班级表，有使用MySQL关键字作为字段时，需要使用``来标识
DROP TABLE IF EXISTS classes;
CREATE TABLE classes (
	id INT PRIMARY KEY auto_increment,
	name VARCHAR(20),
	`desc` VARCHAR(100)
);

-- 重新设置学生表结构
DROP TABLE IF EXISTS student;
CREATE TABLE student (
    id INT PRIMARY KEY auto_increment,
    sn INT UNIQUE,
    name VARCHAR(20) DEFAULT 'unkown',
    qq_mail VARCHAR(20),
	classes_id int,
	FOREIGN KEY (classes_id) REFERENCES classes(id)
);

-- 创建课程表
DROP TABLE IF EXISTS course;
CREATE TABLE course (
    id INT PRIMARY KEY auto_increment,
    name VARCHAR(20)
);

-- 创建课程学生中间表：考试成绩表
DROP TABLE IF EXISTS score;
CREATE TABLE score (
    id INT PRIMARY KEY auto_increment,
	score DECIMAL(3, 1),
    student_id int,
	course_id int,
	FOREIGN KEY (student_id) REFERENCES student(id),
	FOREIGN KEY (course_id) REFERENCES course(id)
);