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
