-- start hala course_std
ALTER TABLE course_std
ADD COLUMN mid_1_grd INT(11)  AFTER std_id,
ADD COLUMN semi_final_grd INT(11)  AFTER mid_1_grd,
ADD COLUMN mid_2_grd INT(11)  AFTER semi_final_grd,
ADD COLUMN final_grd INT(11)  AFTER mid_2_grd;
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

-- fathy start --
ALTER TABLE question
CHANGE COLUMN question_content  question VARCHAR(500) NOT NULL ,
CHANGE COLUMN question_answer model_answer VARCHAR(500) NOT NULL ;
-- fathy end --


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




-- fathy start --




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


-- fathy start 15/3/2019 --

ALTER TABLE `sms`.`question`
ADD COLUMN `question_grade` INT NOT NULL AFTER `quiz_question_type_id`;

ALTER TABLE `sms`.`student_answer`
ADD COLUMN `student_score` INT NOT NULL AFTER `is_correct`;

-- fathy end 15/3/2019 --



-- fathy start 13/4/2019

ALTER TABLE `sms`.`lecture`
ADD COLUMN `course_id` INT NOT NULL AFTER `description`;


ALTER TABLE `sms`.`lecture`
ADD INDEX `fk_course_lectures_idx` (`course_id` ASC);
ALTER TABLE `sms`.`lecture`
ADD CONSTRAINT `fk_course_lectures`
  FOREIGN KEY (`course_id`)
  REFERENCES `sms`.`course` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- fathy end 13/4/2019
-- yara start --
CREATE TABLE `sms`.`announcment` (
  `id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `content` VARCHAR(255) NOT NULL,
  `announ_date` DATE NOT NULL,
  `course_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_announcment_course_idx` (`course_id` ASC),
  CONSTRAINT `fk_announcment_course`
    FOREIGN KEY (`course_id`)
    REFERENCES `sms`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
-- yara end --