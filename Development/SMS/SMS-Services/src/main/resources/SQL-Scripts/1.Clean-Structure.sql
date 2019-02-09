
CREATE SCHEMA sms;
use sms;

CREATE TABLE auth_user (
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_name varchar(45) NOT NULL,
  user_pass varchar(15) NOT NULL,
  first_name varchar(15) NOT NULL,
  last_name varchar(15) NOT NULL
);
CREATE TABLE cor_category (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  label_en VARCHAR(45) NOT NULL
);


CREATE TABLE cor_type (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  label_en VARCHAR(45) NOT NULL
);


CREATE TABLE cor_level (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  label_en VARCHAR(45) NOT NULL
);

CREATE TABLE course (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cor_name VARCHAR(20) NOT NULL,
  duration INT NOT NULL,
  start_date INT NOT NULL,
  end_date INT,
  instructor_id INT NOT NULL,
  category_id INT NOT NULL,
  type_id INT NOT NULL,
  level_id INT NOT NULL,
  description VARCHAR(200),

  CONSTRAINT fk_course_cor_category FOREIGN KEY (category_id) REFERENCES cor_category (id),
  CONSTRAINT fk_course_cor_type FOREIGN KEY (type_id) REFERENCES cor_type (id),
  CONSTRAINT fk_course_cor_level FOREIGN KEY (level_id) REFERENCES cor_level (id),
  CONSTRAINT fk_course_auth_user FOREIGN KEY (instructor_id) REFERENCES auth_user (id)

  );



CREATE TABLE course_std (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cor_id INT NOT NULL,
  std_id INT NOT NULL,

  CONSTRAINT fk_course_std_course FOREIGN KEY (cor_id) REFERENCES course (id),
  CONSTRAINT fk_course_std_auth_user FOREIGN KEY (std_id) REFERENCES auth_user (id)

  );


CREATE TABLE attendance (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cor_id INT NOT NULL,
  attendance_date DATE NOT NULL ,
  CONSTRAINT fk_attendance_course FOREIGN KEY (cor_id) REFERENCES course (id)
  );


CREATE TABLE cor_std_att (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cor_id INT NOT NULL,
  att_id INT NOT NULL,
    CONSTRAINT fk_cor_std_att_course FOREIGN KEY (cor_id) REFERENCES course (id),
    CONSTRAINT fk_cor_std_att_attendance FOREIGN KEY (att_id) REFERENCES course (id)

  );