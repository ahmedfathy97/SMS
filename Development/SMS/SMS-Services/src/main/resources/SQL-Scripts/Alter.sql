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

-- yara view (quiz_result)---
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


-- Abanoub start --

ALTER TABLE `sms`.`file_source`
    CHANGE COLUMN `lable_en` `lable_en` VARCHAR(15) NOT NULL ;

INSERT INTO `sms`.`file_source` (`id`, `lable_en`) VALUES ('1', 'attachment');
INSERT INTO `sms`.`file_source` (`id`, `lable_en`) VALUES ('2', 'assignment');

ALTER TABLE `sms`.`attachment`
    CHANGE COLUMN `content_type` `content_type` VARCHAR(50) NOT NULL ;
-- Abanoub end --


-- Abanoub start --

-- add-material --

INSERT INTO `sms`.`auth_view` (`id`, `label_ar`) VALUES ('7', 'Add-Matrial');
UPDATE `sms`.`auth_view` SET `label_ar` = 'Add-Material' WHERE (`id` = '7');

INSERT INTO `sms`.`auth_role_view` (`role_id`, `view_id`) VALUES ('1', '7');

INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('1', '7');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('30', '7');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('4', '7');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('5', '7');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('6', '7');

-- AuthAction --
INSERT INTO `sms`.`auth_action` (`id`, `label_ar`) VALUES ('7', 'Add-Matrial');
UPDATE `sms`.`auth_action` SET `label_ar` = 'Add-Material' WHERE (`id` = '7');

INSERT INTO `sms`.`auth_role_action` (`role_id`, `action_id`) VALUES ('1', '7');

INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('1', '7');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('30', '7');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('4', '7');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('5', '7');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('6', '7');

-- add-material end --

-- download-material --
    -- AuthAction --
INSERT INTO `sms`.`auth_action` (`id`, `label_ar`) VALUES ('16', 'Download-Matrial');

INSERT INTO `sms`.`auth_role_action` (`role_id`, `action_id`) VALUES ('1', '16');
INSERT INTO `sms`.`auth_role_action` (`role_id`, `action_id`) VALUES ('2', '16');

INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('1', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('2', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('3', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('4', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('5', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('6', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('7', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('8', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('10', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('11', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('12', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('13', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('14', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('16', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('17', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('18', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('19', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('20', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('21', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('22', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('23', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('24', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('25', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('26', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('27', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('28', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('29', '16');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('30', '16');

-- download-material end --
-- lecture-details --

INSERT INTO `sms`.`auth_view` (`id`, `label_ar`) VALUES ('17', 'Lecture_Details');

INSERT INTO `sms`.`auth_role_view` (`role_id`, `view_id`) VALUES ('1', '17');
INSERT INTO `sms`.`auth_role_view` (`role_id`, `view_id`) VALUES ('2', '17');

INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('1', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('2', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('3', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('4', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('5', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('6', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('7', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('8', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('10', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('11', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('12', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('13', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('14', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('16', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('17', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('18', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('19', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('20', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('21', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('22', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('23', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('24', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('25', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('26', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('27', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('28', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('29', '17');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('30', '17');

-- lecture-details end --

-- course-lectures --

INSERT INTO `sms`.`auth_view` (`id`, `label_ar`) VALUES ('18', 'Course_Lectures');

INSERT INTO `sms`.`auth_role_view` (`role_id`, `view_id`) VALUES ('1', '18');
INSERT INTO `sms`.`auth_role_view` (`role_id`, `view_id`) VALUES ('2', '18');

INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('1', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('2', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('3', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('4', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('5', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('6', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('7', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('8', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('10', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('11', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('12', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('13', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('14', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('16', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('17', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('18', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('19', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('20', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('21', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('22', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('23', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('24', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('25', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('26', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('27', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('28', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('29', '18');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('30', '18');

-- course-lectures end --

-- Abanoub End --




-- ahmed start --

 INSERT INTO auth_role_view (role_id, view_id) VALUE (1,13);
 INSERT INTO auth_user_view (user_id, view_id) VALUE (1,13);
 INSERT INTO auth_user_view (user_id, view_id) VALUE (4,13);
 INSERT INTO auth_user_view (user_id, view_id) VALUE (5,13);
 INSERT INTO auth_user_view (user_id, view_id) VALUE (6,13);
 INSERT INTO auth_user_view (user_id, view_id) VALUE (30,13);




-- Ahmed View (course exams)-- --
-- instructor
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (24, 'COURSE_EXAMS', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,24);
-- student
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (2,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (3,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (7,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (8,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (10,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (11,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (12,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (13,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (14,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (16,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (17,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (18,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (19,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (20,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (21,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (22,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (23,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (24,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (25,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (26,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (27,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (28,24);
INSERT INTO auth_user_view (user_id, view_id) VALUE (29,24);
-- end-- -- -- --





-- Ahmed View (add exam question)-- --
-- instructor
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (19, 'ADD_EXAM_QUESTION', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,19);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,19);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,19);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,19);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,19);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,19);
-- end-- -- -- --



-- Ahmed View (answer question)-- --
-- student
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (20, 'ANSWER_EXAM_QUESTION', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (2,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (3,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (7,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (8,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (10 ,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (11,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (12,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (13,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (14,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (16,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (17,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (18,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (19,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (20,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (21,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (22,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (23,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (24,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (25,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (26,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (27,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (28,20);
INSERT INTO auth_user_view (user_id, view_id) VALUE (29,20);
-- end-- -- -- --
-- Ahmed action (answer exam question)-- --
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (18, 'ANSWER_EXAM_QUESTION', '');
INSERT INTO auth_role_action (role_id, action_id) VALUE (2,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (2,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (3,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (7,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (8,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (10,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (11,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (12,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (13,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (14,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (16,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (17,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (18,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (19,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (20,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (21,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (22,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (23,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (24,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (25,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (26,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (27,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (28,18);
INSERT INTO auth_user_action (user_id, action_id) VALUE (29,18);
-- end-- -- -- --

-- Ahmed View (Exam_Details)-- --
-- instructor
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (21, 'EXAM_DETAILS', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,21);
-- student
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (2,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (3,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (7,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (8,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (10,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (11,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (12,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (13,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (14,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (16,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (17,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (18,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (19,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (20,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (21,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (22,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (23,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (24,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (25,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (26,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (27,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (28,21);
INSERT INTO auth_user_view (user_id, view_id) VALUE (29,21);
-- end-- -- -- --







-- Ahmed View (Main_Details)-- --
-- instructor
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (22, 'EXAM_MAIN_DETAILS', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,22);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,22);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,22);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,22);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,22);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,22);


INSERT INTO auth_view (id, label_ar, description_ar) VALUE (23, 'EXAM_RESULT', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (2,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (3,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (7,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (8,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (10,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (11,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (12,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (13,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (14,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (16,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (17,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (18,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (19,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (20,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (21,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (22,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (23,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (24,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (25,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (26,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (27,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (28,23);
INSERT INTO auth_user_view (user_id, view_id) VALUE (29,23);
-- end-- -- -- --

-- ahmed auth action (close exam)
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (17, 'CLOSE_EXAM', '');
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,17);
INSERT INTO auth_user_action (user_id, action_id) VALUE (1,17);
INSERT INTO auth_user_action (user_id, action_id) VALUE (4,17);
INSERT INTO auth_user_action (user_id, action_id) VALUE (5,17);
INSERT INTO auth_user_action (user_id, action_id) VALUE (6,17);
INSERT INTO auth_user_action (user_id, action_id) VALUE (30,17);


