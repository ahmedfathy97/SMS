-- start hala course_std
ALTER TABLE course_std
ADD COLUMN mid_1_grd INT(11)  AFTER std_id,
ADD COLUMN semi_final_grd INT(11)  AFTER mid_1_grd,
ADD COLUMN mid_2_grd INT(11)  AFTER semi_final_grd,
ADD COLUMN final_grd INT(11)  AFTER mid_2_grd;

INSERT INTO auth_user (user_name, user_pass, first_name, last_name) VALUES ('Hala', '12', 'Hala', 'Mahmoud');
INSERT INTO auth_user (user_name, user_pass, first_name, last_name) VALUES ('Yara', '132', 'Yara', 'Abd El Rahman');
INSERT INTO auth_user (user_name, user_pass, first_name, last_name) VALUES ('Ahmed', '1234', 'Ahmed', 'Fathy');
INSERT INTO auth_user (user_name, user_pass, first_name, last_name) VALUES ('Yousef', '10', 'yousef', 'Reda');

INSERT INTO course_std (cor_id, std_id) VALUES (2, 3);
INSERT INTO course_std (cor_id, std_id) VALUES (2, 4);
INSERT INTO course_std (cor_id, std_id) VALUES (2, 5);
INSERT INTO course_std (cor_id, std_id) VALUES (1, 2);
INSERT INTO course_std (cor_id, std_id) VALUES (1, 3);
INSERT INTO course_std (cor_id, std_id) VALUES (4, 1);
INSERT INTO course_std (cor_id, std_id) VALUES (4, 2);
INSERT INTO course_std (cor_id, std_id) VALUES (4, 3);
INSERT INTO course_std (cor_id, std_id) VALUES (4, 4);


-- end hala

-- Youssef

ALTER TABLE course
CHANGE COLUMN start_date start_date DATE NOT NULL ,
CHANGE COLUMN end_date end_date DATE NULL DEFAULT NULL ;

-- Youssef

-- fathy satrt
CREATE TABLE quiz (
  id INT NOT NULL AUTO_INCREMENT,
  quiz_name VARCHAR(45) NOT NULL,
  grade INT NOT NULL,
  date DATE NOT NULL,
  course_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_quiz_course
    FOREIGN KEY (course_id)
    REFERENCES course (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



    CREATE TABLE question (
  id INT NOT NULL AUTO_INCREMENT,
  question_content VARCHAR(500) NOT NULL,
  question_answer VARCHAR(500) NOT NULL,
  answer1 VARCHAR(500) NULL,
  answer2 VARCHAR(500) NULL,
  answer3 VARCHAR(500) NULL,
  answer4 VARCHAR(500) NULL,
  quiz_id INT NOT NULL,
  quiz_question_type_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_question_quiz
    FOREIGN KEY (quiz_id)
    REFERENCES quiz (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    CREATE TABLE question_type (
  id INT NOT NULL AUTO_INCREMENT,
  label_en VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));


  ALTER TABLE question
ADD CONSTRAINT fk_question_quiz_question_type
  FOREIGN KEY (quiz_question_type_id)
  REFERENCES question_type (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  ALTER TABLE quiz
CHANGE COLUMN date due_date DATE NOT NULL ;


INSERT INTO `sms`.`question_type` (`id`, `label_en`) VALUES ('1', 'mcq');
INSERT INTO `sms`.`question_type` (`id`, `label_en`) VALUES ('2', 'truefalse');
INSERT INTO `sms`.`question_type` (`id`, `label_en`) VALUES ('3', 'written');



-- fathy End
--hala start
INSERT INTO course_std (cor_id, std_id) VALUES (4, 6);
-- hala End

-- Abanoub Start --

CREATE TABLE file_source (
  id         INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  lable_en   INT NOT NULL
);

CREATE TABLE attachment (
  file_id            INT     NOT NULL AUTO_INCREMENT PRIMARY KEY,
  file_name     VARCHAR(60)  NOT NULL,
  content_type  VARCHAR(20)  NOT NULL,
  file_size	INT	    Not NULL,
  extension     VARCHAR(6)   NOT NULL,
  file_path     VARCHAR(100) NOT NULL,
  upload_date   DATE         NOT NULL,
  source_id     INT          NOT NULL,
  file_src_id   INT          ,
  CONSTRAINT FOREIGN KEY (file_src_id) REFERENCES file_source (id)
);

-- Abanoub End --

-- fathy start--
ALTER TABLE question
CHANGE COLUMN question_content  question VARCHAR(500) NOT NULL ,
CHANGE COLUMN question_answer model_answer VARCHAR(500) NOT NULL ;
-- fathy end --

--start Manar

ALTER TABLE `sms`.`auth_user`
ADD COLUMN `age` INT NOT NULL AFTER `last_name`,
ADD COLUMN `gender` VARCHAR(45) NOT NULL AFTER `age`,
ADD COLUMN `e_mail` VARCHAR(100) NOT NULL AFTER `gender`,
ADD COLUMN `phone` INT NOT NULL AFTER `e_mail`,
ADD COLUMN `college` VARCHAR(100) NULL AFTER `phone`;

ALTER TABLE `sms`.`auth_user`
CHANGE COLUMN `phone` `phone` INT(11) NULL ;

UPDATE `sms`.`auth_user` SET `gender`='male', `e_mail`='ahned@jhj', `phone`='125' WHERE `id`='1';
UPDATE `sms`.`auth_user` SET `gender`='male', `e_mail`='ahmed@khhkhna', `phone`='126' WHERE `id`='2';
UPDATE `sms`.`auth_user` SET `gender`='female', `e_mail`='ajhjhj@jjhj', `phone`='125' WHERE `id`='3';
UPDATE `sms`.`auth_user` SET `gender`='female', `e_mail`='hjhjhjh@jhjh', `phone`='1478' WHERE `id`='4';
UPDATE `sms`.`auth_user` SET `gender`='male', `e_mail`='ggfgfg@jh', `phone`='1258' WHERE `id`='5';
UPDATE `sms`.`auth_user` SET `gender`='male', `e_mail`='gfgffg', `phone`='965' WHERE `id`='6';

INSERT INTO `sms`.`auth_user` (`id`, `user_name`, `user_pass`, `first_name`, `last_name`, `age`, `gender`, `e_mail`, `phone`) VALUES ('7', 'manar', '1569', 'manar', 'el sayed', '20', 'female', 'kjuytr@huyt.com', '15897');

--end manar

-- fathy start --
ALTER TABLE `sms`.`quiz`
CHANGE COLUMN `due_date` `start_date` DATE NOT NULL ,
ADD COLUMN `close_date` DATE NOT NULL AFTER `course_id`;

ALTER TABLE `sms`.`quiz`
ADD COLUMN `auto_close` TINYINT NULL AFTER `close_date`;

-- fathy end --

-- yousef start
CREATE TABLE lecture (
  id            INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title      VARCHAR(25),
  lecture_date   DATE   NOT NULL,
  video_url  VARCHAR(1000) ,
  description   VARCHAR(200)
);

-- yousef end




--fathy start --




CREATE TABLE `sms`.`student_answer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `quiz_id` INT NOT NULL,
  `question_id` INT NOT NULL,
  `answer` VARCHAR(25) NOT NULL,
  `is_correct` TINYINT NOT NULL,
  `question_score` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `student_id_fk_idx` (`user_id` ASC),
  INDEX `quiz_id_fk_idx` (`quiz_id` ASC),
  INDEX `question_id_fk_idx` (`question_id` ASC),
  CONSTRAINT `student_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `sms`.`auth_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `quiz_id_fk`
    FOREIGN KEY (`quiz_id`)
    REFERENCES `sms`.`quiz` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `question_id_fk`
    FOREIGN KEY (`question_id`)
    REFERENCES `sms`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



    ALTER TABLE `sms`.`student_answer`
    DROP COLUMN `question_score`;

-- fathy end --


--fathy start 15/3/2019 --

ALTER TABLE `sms`.`question`
ADD COLUMN `question_grade` INT NOT NULL AFTER `quiz_question_type_id`;

ALTER TABLE `sms`.`student_answer`
ADD COLUMN `student_score` INT NOT NULL AFTER `is_correct`;

--fathy end 15/3/2019 --
