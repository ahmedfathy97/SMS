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
INSERT INTO course_std (cor_id, std_id) VALUES (4, 4);

-- end hala

-- Youssef

ALTER TABLE course
CHANGE COLUMN start_date start_date DATE NOT NULL ,
CHANGE COLUMN end_date end_date DATE NULL DEFAULT NULL ;

-- Youssef