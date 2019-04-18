
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (1, 'View-Course', 'Viewing Course Details Page');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (2, 'Create-Course', 'Viewing Create Course Page');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (3, 'Create-Translation', 'Viewing Create Course Translation Page');

INSERT INTO auth_action (id, label_ar, description_ar) VALUE (1, 'Enroll-Course', '');
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (2, 'Submit-Course', '');
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (3, 'Submit-Translation', '');
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (4, 'Edit-Translation', '');

INSERT INTO auth_role (id, label_ar, description_ar) VALUE (1, 'Instructor', 'Teaching Courses');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,1);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,2);
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,2);

INSERT INTO auth_role (id, label_ar, description_ar) VALUE (2, 'Student', 'Learning Courses');
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,1);
INSERT INTO auth_role_action (role_id, action_id) VALUE (2,1);

INSERT INTO auth_role (id, label_ar, description_ar) VALUE (3, 'Translator', 'Translating Courses');
INSERT INTO auth_role_view (role_id, view_id) VALUE (3,1);
INSERT INTO auth_role_view (role_id, view_id) VALUE (3,3);
INSERT INTO auth_role_action (role_id, action_id) VALUE (3,3);
INSERT INTO auth_role_action (role_id, action_id) VALUE (3,4);

INSERT INTO auth_user (id, username, user_password, is_active, created_on) VALUE (1, 'Ahmed_Mater', 'e10adc3949ba59abbe56e057f20f883e', 1, NOW());
INSERT INTO user_detail (user_id, first_name, last_name, email) VALUE (1, 'Ahmed', 'Mater', 'ahmed.mater@ism.com');
INSERT INTO auth_user_role (user_id, role_id) VALUE (1,1);
INSERT INTO auth_user_role (user_id, role_id) VALUE (1,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,1);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,2);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (1,2);
INSERT INTO auth_user_action (user_id, action_id) VALUE (1,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (1,4);

INSERT INTO auth_user (id, username, user_password, is_active, created_on) VALUE (2, 'Ali_Maher', 'e10adc3949ba59abbe56e057f20f883e', 1, NOW());
INSERT INTO user_detail (user_id, first_name, last_name, email) VALUE (2, 'Ali', 'Maher', 'ali.maher@ism.com');
INSERT INTO auth_user_role (user_id, role_id) VALUE (2,2);
INSERT INTO auth_user_view (user_id, view_id) VALUE (2,1);
INSERT INTO auth_user_view (user_id, view_id) VALUE (2,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (2,1);
INSERT INTO auth_user_action (user_id, action_id) VALUE (2,3);

INSERT INTO auth_user (id, username, user_password, is_active, created_on) VALUE (3, 'Mona_Ramy', 'e10adc3949ba59abbe56e057f20f883e', 1, NOW());
INSERT INTO user_detail (user_id, first_name, last_name, email) VALUE (3, 'Mona', 'Ramy', 'mona.rami@ism.com');
INSERT INTO auth_user_role (user_id, role_id) VALUE (3,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (3,1);
INSERT INTO auth_user_view (user_id, view_id) VALUE (3,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (3,3);

SELECT * FROM auth_user_view WHERE user_id = 1 AND view_id IN (3, 2);
SELECT * FROM auth_user_action WHERE user_id = 1 AND action_id = 4;


INSERT INTO cor_category (id, label_en) VALUES (1, 'Design');
INSERT INTO cor_category (id, label_en) VALUES (2, 'Programming');
INSERT INTO cor_category (id, label_en) VALUES (3, 'IT');
INSERT INTO cor_category (id, label_en) VALUES (4, 'Web Development');


INSERT INTO cor_type (id, label_en) VALUES (1, 'Academic');
INSERT INTO cor_type (id, label_en) VALUES (2, 'Practical');


INSERT INTO cor_level (id, label_en) VALUES (1, 'Beginner');
INSERT INTO cor_level (id, label_en) VALUES (2, 'Advanced');
INSERT INTO cor_level (id, label_en) VALUES (3, 'Intermediate');

INSERT INTO course (id, cor_name, duration, start_date, end_date, instructor_id, category_id, type_id, level_id, description)
 VALUES (1, 'Java', 3, '2018-5-12', '2018-8-12', 1, 1, 1, 1, 'Programming Language');
INSERT INTO course (id, cor_name, duration, start_date, end_date, instructor_id, category_id, type_id, level_id, description)
VALUES (2, 'C++', 3, '2018-5-12', '2018-8-12', 2, 2, 2, 2, 'Programming Language');
INSERT INTO course (id, cor_name, duration, start_date, end_date, instructor_id, category_id, type_id, level_id, description)
VALUES (3, 'C', 3, '2018-5-12', '2018-8-12', 2, 2, 2, 2, 'Programming Language');
INSERT INTO course (id, cor_name, duration, start_date, end_date, instructor_id, category_id, type_id, level_id, description)
VALUES (4, 'C#', 3, '2018-5-12', '2018-8-12', 2, 2, 2, 2, 'Programming Language');

--manar--
UPDATE `sms`.`user_detail` SET `age`='20', `gender`='male', `phone`='0115698753', `college`='engneerig' WHERE `user_id`='1';
UPDATE `sms`.`user_detail` SET `age`='45', `gender`='male', `phone`='010255998', `college`='law' WHERE `user_id`='2';
UPDATE `sms`.`user_detail` SET `age`='35', `gender`='female', `phone`='0156986540', `college`='arts' WHERE `user_id`='3';

UPDATE `sms`.`user_detail` SET `user_name`='Ahmed-Mater' WHERE `user_id`='1';
UPDATE `sms`.`user_detail` SET `user_name`='Ali-Maher' WHERE `user_id`='2';
UPDATE `sms`.`user_detail` SET `user_name`='Mona-Ramy' WHERE `user_id`='3';
--manar--
UPDATE `sms`.`user_detail` SET `user_name`='Ahmed Mater' WHERE `user_id`='1';

