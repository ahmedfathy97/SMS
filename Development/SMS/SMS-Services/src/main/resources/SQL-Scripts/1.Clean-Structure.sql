CREATE SCHEMA sms;
USE sms;

CREATE TABLE auth_user (
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  user_password VARCHAR(45) NOT NULL,
  is_active INT(1) NOT NULL DEFAULT 1,
  created_on DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (id)
);

CREATE TABLE user_detail (
  user_id INT NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_id),
  UNIQUE INDEX user_id_UNIQUE (user_id ASC),
  CONSTRAINT fk_user_detail_auth_user FOREIGN KEY (user_id) REFERENCES auth_user (id)
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
  cor_name      VARCHAR(20) NOT NULL,
  duration      INT         NOT NULL,
  start_date    DATE        NOT NULL,
  end_date      DATE,
  instructor_id INT         NOT NULL,
  category_id   INT         NOT NULL,
  type_id       INT         NOT NULL,
  level_id      INT         NOT NULL,
  description   VARCHAR(200),
  CONSTRAINT fk_course_cor_category FOREIGN KEY (category_id) REFERENCES cor_category (id),
  CONSTRAINT fk_course_cor_type FOREIGN KEY (type_id) REFERENCES cor_type (id),
  CONSTRAINT fk_course_cor_level FOREIGN KEY (level_id) REFERENCES cor_level (id),
  CONSTRAINT fk_course_auth_user FOREIGN KEY (instructor_id) REFERENCES auth_user (id)
);

CREATE TABLE course_std (
  id     INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  cor_id INT NOT NULL,
  std_id INT NOT NULL,
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
  -- TODO: Yara - There is extra comma on the last line here - remove it and take care in the next time
  CONSTRAINT fk_cor_std_auth_user FOREIGN KEY (std_id) REFERENCES course (id),

);

-- yousef ----



