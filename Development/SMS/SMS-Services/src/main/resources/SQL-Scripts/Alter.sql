USE sms ;
 -- manar(view user_profile)--
 -- manar(view user_profile)
 -- instructor
 INSERT INTO auth_view (id, label_ar, description_ar) VALUE (5, 'User-Profile', '');
 INSERT INTO auth_role_view (role_id, view_id) VALUE (1,5);
 INSERT INTO auth_user_view (user_id, view_id) VALUE (1,5);
-- manar--
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,5);
-- student
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (2,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (3,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (7,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (8,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (10,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (11,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (12,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (13,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (14,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (16,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (17,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (18,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (19,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (20,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (21,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (22,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (23,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (24,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (25,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (26,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (27,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (28,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (29,5);
-- system admin
INSERT INTO auth_role_view (role_id, view_id) VALUE (3,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE(9,5);
INSERT INTO auth_user_view (user_id, view_id) VALUE (15,5);
 -- manar(view user_edit)
 -- instructor
 INSERT INTO auth_view (id, label_ar, description_ar) VALUE (6, 'User-Edit', '');
 INSERT INTO auth_role_view (role_id, view_id) VALUE (1,6);
 INSERT INTO auth_user_view (user_id, view_id) VALUE (1,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,6);
-- student
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (2,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (3,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (7,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (8,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (10,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (11,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (12,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (13,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (14,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (16,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (17,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (18,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (19,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (20,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (21,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (22,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (23,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (24,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (25,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (26,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (27,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (28,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (29,6);
-- system admin
INSERT INTO auth_role_view (role_id, view_id) VALUE (3,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE(9,6);
INSERT INTO auth_user_view (user_id, view_id) VALUE (15,6);
-- manar end--




 --  yara( role action )-- -- --
INSERT INTO auth_user_role (user_id, role_id) VALUE (10, 2);
--  Yara View (Create Attendance)-- --
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (3, 'Add-Attendance', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,3);
-- Yara View (Attendance)----
-- -- - Yara View (Attendance)-- --

-- Yara Action (View Attendance)
-- -- - Yara Action (View Attendance)
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (3, 'Add-Attendance', '');
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (1,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (4,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (5,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (6,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (30,3);

-- -- student
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (2,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (3,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (7,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (8,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (10,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (11,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (12,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (13,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (14,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (16,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (17,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (18,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (19,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (20,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (21,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (22,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (23,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (24,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (25,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (26,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (27,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (28,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (29,3);
-- -- -- -- end-- -- -- --

--  Yara Action (View Attendance)

--  Yara View (Create Announcement)-- --
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (4, 'Add-Announcement', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,4);
--  student
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (2,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (3,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (7,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (8,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (10,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (11,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (12,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (13,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (14,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (16,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (17,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (18,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (19,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (20,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (21,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (22,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (23,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (24,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (25,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (26,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (27,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (28,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (29,4);
--  Yara View (Announcement)-- --

--  Yara Action (View Announcement)
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (4, 'Add-Announcement', '');
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,4);
INSERT INTO auth_user_action (user_id, action_id) VALUE (1,4);
INSERT INTO auth_user_action (user_id, action_id) VALUE (4,4);
INSERT INTO auth_user_action (user_id, action_id) VALUE (5,4);
INSERT INTO auth_user_action (user_id, action_id) VALUE (6,4);
INSERT INTO auth_user_action (user_id, action_id) VALUE (30,4);
--  Yara Action (View Announcement)


--  start hala -- (view Grade)
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (2, 'Add-Grade', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,2);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,2);
--  new instructor
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,2);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,2);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,2);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,2);
--  -- -- --








--  ahmed start --
ALTER TABLE `sms`.`quiz`
CHANGE COLUMN `auto_close` `is_closed` TINYINT(4) NULL DEFAULT NULL ;
--  ahmed end --



-- new image--
UPDATE `sms`.`course` SET `image_path`='/assets/images/course/hala1.png' WHERE `id`='2';

UPDATE `sms`.`course` SET `image_path`='/assets/images/course/Programming.jpg' WHERE `id`='5';

UPDATE `sms`.`course` SET `image_path`='/assets/images/course/neural.jpg' WHERE `id`='6';

UPDATE `sms`.`course` SET `image_path`='/assets/images/course/data.jpg' WHERE `id`='7';

UPDATE `sms`.`course` SET `image_path`='/assets/images/course/c++.jpg' WHERE `id`='8';
-- end-- --

-- manar--
UPDATE `sms`.`user_detail` SET `age`='50', `gender`='male', `phone`='0123654' WHERE `user_id`='1';
UPDATE `sms`.`user_detail` SET `age`='20', `gender`='female', `phone`='45893210' WHERE `user_id`='2';
UPDATE `sms`.`user_detail` SET `age`='23', `gender`='female', `phone`='014785' WHERE `user_id`='3';
UPDATE `sms`.`user_detail` SET `age`='40', `gender`='male', `phone`='0258963' WHERE `user_id`='4';
UPDATE `sms`.`user_detail` SET `age`='35', `gender`='male', `phone`='01254789' WHERE `user_id`='5';
UPDATE `sms`.`user_detail` SET `age`='55', `gender`='female', `phone`='0321458' WHERE `user_id`='6';
UPDATE `sms`.`user_detail` SET `age`='25', `gender`='male', `phone`='012587' WHERE `user_id`='7';
-- manar--


-- auth action on enroll student --
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (5, 'ENROLL_STUDENT', '');
INSERT INTO auth_role_action (role_id, action_id) VALUE (2,5);
INSERT INTO auth_user_action (user_id, action_id) VALUE (2,5);
INSERT INTO auth_user_action (user_id, action_id) VALUE (10,5);
INSERT INTO auth_user_action (user_id, action_id) VALUE (7,5);


--  hala( role action )-- -- --
INSERT INTO auth_user_role (user_id, role_id) VALUE (7, 2);
INSERT INTO auth_user_role (user_id, role_id) VALUE (2, 2);


-- Ahmed View (course quizes)-- --
-- instructor
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (10, 'Course-Quizes', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,10);
-- student
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (2,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (3,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (7,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (8,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (10,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (11,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (12,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (13,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (14,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (16,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (17,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (18,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (19,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (20,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (21,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (22,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (23,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (24,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (25,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (26,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (27,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (28,10);
INSERT INTO auth_user_view (user_id, view_id) VALUE (29,10);
-- end-- -- -- --

-- Ahmed action (course quizes)-- --
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (10, 'Course-Quizes', '');
INSERT INTO auth_role_action (role_id, action_id ) VALUE (1,10);
INSERT INTO auth_user_action (user_id, action_id) VALUE (1,10);
INSERT INTO auth_user_action (user_id, action_id) VALUE (4,10);
INSERT INTO auth_user_action (user_id, action_id) VALUE (5,10);
INSERT INTO auth_user_action (user_id, action_id) VALUE (6,10);
INSERT INTO auth_user_action (user_id, action_id) VALUE (30,10);
-- end-- -- -- --


-- Ahmed View (create quize)-- --
-- instructor
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (11, 'Create-Quizes', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,11);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,11);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,11);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,11);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,11);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,11);
-- end-- -- -- --

-- Ahmed action (create quiz)-- --
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (11, 'Create-Quizes', '');
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,11);
INSERT INTO auth_user_action (user_id, action_id) VALUE (1,11);
INSERT INTO auth_user_action (user_id, action_id) VALUE (4,11);
INSERT INTO auth_user_action (user_id, action_id) VALUE (5,11);
INSERT INTO auth_user_action (user_id, action_id) VALUE (6,11);
INSERT INTO auth_user_action (user_id, action_id) VALUE (30,11);
-- end-- -- -- --

-- Ahmed View (add question)-- --
-- instructor
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (12, 'Add_Question', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,12);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,12);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,12);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,12);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,12);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,12);
-- end-- -- -- --

-- Ahmed action (add question)-- --
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (12, 'Add_Question', '');
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,12);
INSERT INTO auth_user_action (user_id, action_id) VALUE (1,12);
INSERT INTO auth_user_action (user_id, action_id) VALUE (4,12);
INSERT INTO auth_user_action (user_id, action_id) VALUE (5,12);
INSERT INTO auth_user_action (user_id, action_id) VALUE (6,12);
INSERT INTO auth_user_action (user_id, action_id) VALUE (30,12);
-- end-- -- -- --


-- Ahmed View (answer question)-- --
-- student
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (13, 'Answer_Question', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (2,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (3,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (7,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (8,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (10,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (11,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (12,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (13,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (14,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (16,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (17,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (18,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (19,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (20,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (21,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (22,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (23,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (24,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (25,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (26,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (27,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (28,13);
INSERT INTO auth_user_view (user_id, view_id) VALUE (29,13);
-- end-- -- -- --
-- Ahmed action (answer question)-- --
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (13, 'Answer_Question', '');
INSERT INTO auth_role_action (role_id, action_id) VALUE (2,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (2,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (3,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (7,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (8,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (10,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (11,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (12,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (13,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (14,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (16,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (17,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (18,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (19,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (20,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (21,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (22,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (23,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (24,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (25,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (26,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (27,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (28,13);
INSERT INTO auth_user_action (user_id, action_id) VALUE (29,13);
-- end-- -- -- --

-- Ahmed View (Quiz_Details)-- --
-- instructor
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (14, 'Quiz_Details', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,14);
-- student
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (2,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (3,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (7,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (8,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (10,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (11,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (12,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (13,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (14,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (16,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (17,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (18,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (19,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (20,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (21,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (22,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (23,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (24,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (25,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (26,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (27,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (28,14);
INSERT INTO auth_user_view (user_id, view_id) VALUE (29,14);
-- end-- -- -- --

-- Ahmed action (Quiz_Details)-- --
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (14, 'Quiz_Details', '');
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,14);
INSERT INTO auth_user_action (user_id, action_id) VALUE (1,14);
INSERT INTO auth_user_action (user_id, action_id) VALUE (4,14);
INSERT INTO auth_user_action (user_id, action_id) VALUE (5,14);
INSERT INTO auth_user_action (user_id, action_id) VALUE (6,14);
INSERT INTO auth_user_action (user_id, action_id) VALUE (30,14);


-- -- -- New Script ADD COURSE (Youssef) ------
INSERT INTO `sms`.`auth_view` (`id`, `label_ar`, `description_ar`) VALUES ('8', 'Add_Cor', 'create new course');
INSERT INTO `sms`.`auth_role_view` (`role_id`, `view_id`) VALUES ('1', '8');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('1', '8');
INSERT INTO `sms`.`auth_action` (`id`, `label_ar`, `description_ar`) VALUES ('8', 'Add_Cor', 'create new course actions');
INSERT INTO `sms`.`auth_role_action` (`role_id`, `action_id`) VALUES ('1', '8');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('1', '8');


INSERT INTO `sms`.`auth_view` (`id`, `label_ar`, `description_ar`) VALUES ('9', 'Add-lec', 'create lec component');
INSERT INTO `sms`.`auth_role_view` (`role_id`, `view_id`) VALUES ('1', '9');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('1', '9');

INSERT INTO `sms`.`auth_action` (`id`, `label_ar`, `description_ar`) VALUES ('9', 'Add-lec', 'Add Lec Button');
INSERT INTO `sms`.`auth_role_action` (`role_id`, `action_id`) VALUES ('1', '9');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('1', '9');

-- -- -- -- -- -- END --------------------
-- Ahmed View (Main_Details)-- --
-- instructor
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (15, 'Main_Details', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,15);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,15);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,15);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,15);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,15);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,15);
-- Ahmed View (Main_Details)

--yara view (quiz_result)---
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (16, 'Quiz_Result', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (2,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (3,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (7,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (8,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (10,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (11,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (12,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (13,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (14,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (16,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (17,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (18,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (19,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (20,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (21,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (22,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (23,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (24,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (25,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (26,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (27,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (28,16);
INSERT INTO auth_user_view (user_id, view_id) VALUE (29,16);
-- end-- -- -- --

-- ahmed authaction (close quiz)
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (15, 'Close_quiz', '');
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,15);
INSERT INTO auth_user_action (user_id, action_id) VALUE (1,15);
INSERT INTO auth_user_action (user_id, action_id) VALUE (4,15);
INSERT INTO auth_user_action (user_id, action_id) VALUE (5,15);
INSERT INTO auth_user_action (user_id, action_id) VALUE (6,15);
INSERT INTO auth_user_action (user_id, action_id) VALUE (30,15);
-- end --