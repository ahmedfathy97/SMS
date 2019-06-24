CREATE SCHEMA sms;
USE sms;


CREATE TABLE college (
  id INT NOT NULL,
  labelEN VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_unique (id ASC));


CREATE TABLE university (
  id INT NOT NULL,
  labelEN VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_unique (id ASC));



CREATE TABLE country (
  id INT NOT NULL,
  labelEN VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_unique (id ASC)
  );


CREATE TABLE auth_user (
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  user_password VARCHAR(45) NOT NULL,
  is_active INT(1) NOT NULL DEFAULT 1,
  created_on DATETIME NOT NULL ,
  PRIMARY KEY (id)
);


CREATE TABLE user_detail (
  user_id INT NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  age INT  NULL ,
  birth_date DATE NULL ,
  gender VARCHAR(45)  NULL ,
  phone INT  NULL ,
  college_id INT NULL ,
  country_id INT NULL ,
  university_id INT NULL ,
  PRIMARY KEY (user_id),
  CONSTRAINT fk_user_detail_auth_user FOREIGN KEY (user_id) REFERENCES auth_user (id) ,
  CONSTRAINT fk_user_detail_college FOREIGN KEY (college_id) REFERENCES college (id) ,
  CONSTRAINT fk_user_detail_university FOREIGN KEY (university_id) REFERENCES university (id) ,
  CONSTRAINT fk_user_detail_country FOREIGN KEY (country_id)  REFERENCES country (id)
);


CREATE TABLE auth_view (
  id INT NOT NULL,
  label_ar VARCHAR(45) NOT NULL,
  description_ar VARCHAR(200) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC)
);

CREATE TABLE auth_action (
  id INT NOT NULL,
  label_ar VARCHAR(45) NOT NULL,
  description_ar VARCHAR(200) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC)
);

CREATE TABLE auth_role (
  id INT NOT NULL,
  label_ar VARCHAR(45) NOT NULL,
  description_ar VARCHAR(200) NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC)
);

CREATE TABLE auth_role_action (
  role_id INT NOT NULL,
  action_id INT NOT NULL,
  PRIMARY KEY (role_id, action_id),
  CONSTRAINT fk_auth_role_action_action FOREIGN KEY (action_id) REFERENCES auth_action (id),
  CONSTRAINT fk_auth_role_action_role FOREIGN KEY (role_id) REFERENCES auth_role (id)
);

CREATE TABLE auth_role_view (
  role_id INT NOT NULL,
  view_id INT NOT NULL,
  PRIMARY KEY (role_id, view_id),
  CONSTRAINT fk_auth_role_view_view FOREIGN KEY (view_id) REFERENCES auth_view (id),
  CONSTRAINT fk_auth_role_view_role FOREIGN KEY (role_id) REFERENCES auth_role (id)
);

CREATE TABLE auth_user_role (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY (user_id, role_id),
  CONSTRAINT fk_auth_user_role_user FOREIGN KEY (user_id) REFERENCES auth_user (id),
  CONSTRAINT fk_auth_user_role_role FOREIGN KEY (role_id) REFERENCES auth_role (id)
);

CREATE TABLE auth_user_action (
  user_id INT NOT NULL,
  action_id INT NOT NULL,
  PRIMARY KEY (user_id, action_id),
  CONSTRAINT fk_auth_user_action_action FOREIGN KEY (action_id) REFERENCES auth_action (id),
  CONSTRAINT fk_auth_user_action_user FOREIGN KEY (user_id) REFERENCES auth_user (id)
);

CREATE TABLE auth_user_view (
  user_id INT NOT NULL,
  view_id INT NOT NULL,
  PRIMARY KEY (user_id, view_id),
  CONSTRAINT fk_auth_user_view_view FOREIGN KEY (view_id) REFERENCES auth_view (id),
  CONSTRAINT fk_auth_user_view_user FOREIGN KEY (user_id) REFERENCES auth_user (id)
);

CREATE TABLE cor_category (
  id       INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  label_en VARCHAR(45) NOT NULL
);

CREATE TABLE cor_type (
  id       INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  label_en VARCHAR(45) NOT NULL
);

CREATE TABLE cor_level (
  id       INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  label_en VARCHAR(45) NOT NULL
);


CREATE TABLE course (
  id            INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cor_name      VARCHAR(100) NOT NULL,
  duration      INT         NOT NULL,
  start_date    DATE        NOT NULL,
  end_date      DATE,
  instructorID INT         NOT NULL,
  category_id   INT         NOT NULL,
  type_id       INT         NOT NULL,
  level_id      INT         NOT NULL,
  description   VARCHAR(500),
  image_path VARCHAR(45) NULL ,
  CONSTRAINT fk_course_cor_category FOREIGN KEY (category_id) REFERENCES cor_category (id),
  CONSTRAINT fk_course_cor_type FOREIGN KEY (type_id) REFERENCES cor_type (id),
  CONSTRAINT fk_course_cor_level FOREIGN KEY (level_id) REFERENCES cor_level (id),
  CONSTRAINT fk_course_auth_user FOREIGN KEY (instructorID) REFERENCES auth_user (id)
);

CREATE TABLE course_std (
  id     INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cor_id INT NOT NULL,
  std_id INT NOT NULL,
  mid_1_grd INT(11) ,
  semi_final_grd INT(11) ,
  mid_2_grd INT(11),
  final_grd INT(11),
  CONSTRAINT fk_course_std_course FOREIGN KEY (cor_id) REFERENCES course (id),
  CONSTRAINT fk_course_std_auth_user FOREIGN KEY (std_id) REFERENCES auth_user (id)
);

CREATE TABLE attendance (
  id              INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cor_id          INT  NOT NULL,
  created_on DATE NOT NULL,
  CONSTRAINT fk_attendance_course FOREIGN KEY (cor_id) REFERENCES course (id)
);


CREATE TABLE cor_std_att (
  id     INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cor_id INT NOT NULL,
  std_id INT NOT NULL,
  att_id INT NOT NULL,
  is_attended INT NOT NULL,
  CONSTRAINT fk_cor_std_att_course FOREIGN KEY (cor_id) REFERENCES course (id),
  CONSTRAINT fk_cor_std_att_attendance FOREIGN KEY (att_id) REFERENCES course (id),
  CONSTRAINT fk_cor_std_auth_user FOREIGN KEY (std_id) REFERENCES course (id)

);


CREATE TABLE quiz (
  id INT NOT NULL AUTO_INCREMENT,
  quiz_name VARCHAR(45) NOT NULL,
  grade INT NOT NULL,
  course_id INT NOT NULL ,
  start_date DATE NOT NULL ,
  close_date DATE NOT NULL ,
  is_closed TINYINT(4) NULL DEFAULT NULL  ,
  PRIMARY KEY (id),
  CONSTRAINT fk_quiz_course  FOREIGN KEY (course_id)  REFERENCES course (id)
  );

  CREATE TABLE question_type (
  id INT NOT NULL AUTO_INCREMENT,
  label_en VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));


  CREATE TABLE question (
  id INT NOT NULL AUTO_INCREMENT,
  question VARCHAR(500) NOT NULL,
  model_answer VARCHAR(500) NOT NULL,
  answer1 VARCHAR(500) NULL,
  answer2 VARCHAR(500) NULL,
  answer3 VARCHAR(500) NULL,
  answer4 VARCHAR(500) NULL,
  quiz_id INT NOT NULL,
  quiz_question_type_id INT NOT NULL,
  question_grade INT NOT NULL ,
  PRIMARY KEY (id),
  CONSTRAINT fk_question_quiz FOREIGN KEY (quiz_id) REFERENCES quiz (id) ,
  CONSTRAINT fk_question_quiz_question_type FOREIGN KEY (quiz_question_type_id) REFERENCES question_type (id)
    );

  CREATE TABLE student_answer (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  quiz_id INT NOT NULL,
  question_id INT NOT NULL,
  answer VARCHAR(25) NOT NULL,
  is_correct TINYINT NOT NULL,
  student_score INT NOT NULL ,
  PRIMARY KEY (id),
  CONSTRAINT student_id_fk FOREIGN KEY (user_id)  REFERENCES sms.auth_user (id) ,
  CONSTRAINT quiz_id_fk FOREIGN KEY (quiz_id) REFERENCES sms.quiz (id) ,
  CONSTRAINT question_id_fk FOREIGN KEY (question_id) REFERENCES sms.question (id)
  );


CREATE TABLE announcment (
  id INT(11) NOT NULL AUTO_INCREMENT,
  title VARCHAR(45) NOT NULL,
  content VARCHAR(255) NOT NULL,
  announ_date DATE NOT NULL,
  course_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_announcment_course  FOREIGN KEY (course_id)  REFERENCES sms.course (id)

  );


CREATE TABLE file_source (
  id         INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  lable_en   varchar(15) NOT NULL
);

CREATE TABLE attachment (
  file_id            INT     NOT NULL AUTO_INCREMENT PRIMARY KEY,
  file_name     VARCHAR(100)  NOT NULL,
  content_type  VARCHAR(50)  NOT NULL,
  file_size	INT	    Not NULL,
  extension     VARCHAR(10)   NOT NULL,
  file_path     VARCHAR(150) NOT NULL,
  upload_date   DATE         NOT NULL,
  source_id     INT          NOT NULL,
  file_src_id   INT          ,
  CONSTRAINT FOREIGN KEY (file_src_id) REFERENCES file_source (id)
);


CREATE TABLE lecture (
  id            INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title      VARCHAR(25),
  lecture_date   DATE   NOT NULL,
  video_url  VARCHAR(1000) ,
  description   VARCHAR(1000) ,
  course_id INT NOT NULL ,
  CONSTRAINT fk_course_lectures FOREIGN KEY (course_id) REFERENCES sms.course (id)
);

CREATE TABLE exam (
  id INT NOT NULL AUTO_INCREMENT,
  exam_name VARCHAR(45) NOT NULL,
  grade INT NOT NULL,
  course_id INT NOT NULL ,
  PRIMARY KEY (id),
  CONSTRAINT fk_exam_course  FOREIGN KEY (course_id)  REFERENCES course (id)
  );

CREATE TABLE exam_question (
  id INT NOT NULL AUTO_INCREMENT,
  question VARCHAR(500) NOT NULL,
  model_answer VARCHAR(500) NOT NULL,
  answer1 VARCHAR(500) NULL,
  answer2 VARCHAR(500) NULL,
  answer3 VARCHAR(500) NULL,
  answer4 VARCHAR(500) NULL,
  exam_id INT NOT NULL,
  exam_question_type_id INT NOT NULL,
  question_grade INT NOT NULL ,
  PRIMARY KEY (id),
  CONSTRAINT fk_question_exam FOREIGN KEY (exam_id) REFERENCES exam (id) ,
  CONSTRAINT fk_question_type FOREIGN KEY (exam_question_type_id) REFERENCES question_type (id)
    );

CREATE TABLE student_exam_answer (
  id INT NOT NULL AUTO_INCREMENT,
  student_id INT NOT NULL,
  exam_id INT NOT NULL,
  question_id INT NOT NULL,
  answer VARCHAR(25) NOT NULL,
  is_correct TINYINT NOT NULL,
  student_score INT NOT NULL ,
  PRIMARY KEY (id),
  CONSTRAINT student_id FOREIGN KEY (student_id)  REFERENCES sms.auth_user (id) ,
  CONSTRAINT exam_id_fk FOREIGN KEY (exam_id) REFERENCES sms.exam (id) ,
  CONSTRAINT question_id FOREIGN KEY (question_id) REFERENCES sms.exam_question (id)
  );






