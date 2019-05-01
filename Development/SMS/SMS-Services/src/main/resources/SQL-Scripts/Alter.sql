USE sms ;


 --manar(view user_profile)--
 INSERT INTO auth_view (id, label_ar, description_ar) VALUE (5, 'User-Profile', '');
 INSERT INTO auth_role_view (role_id, view_id) VALUE (1,5);
 INSERT INTO auth_user_view (user_id, view_id) VALUE (2,5);
 INSERT INTO auth_user_view (user_id, view_id) VALUE (1,5);
 INSERT INTO auth_user_view (user_id, view_id) VALUE (9,5);
--manar--

 -- yara( role action )------
INSERT INTO auth_user_role (user_id, role_id) VALUE (10, 2);



-- Yara View (Create Attendance)----
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (3, 'Add-Attendance', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,3);
----- Yara View (Attendance)----

----- Yara Action (View Attendance)
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (3, 'Add-Attendance', '');
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (1,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (4,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (5,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (6,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (30,3);
-- Yara Action (View Attendance)

-- Yara View (Create Announcement)----
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (4, 'Add-Announcement', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,4);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,4);
-- Yara View (Announcement)----

-- Yara Action (View Announcement)
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (4, 'Add-Announcement', '');
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,4);
INSERT INTO auth_user_action (user_id, action_id) VALUE (1,4);
INSERT INTO auth_user_action (user_id, action_id) VALUE (4,4);
INSERT INTO auth_user_action (user_id, action_id) VALUE (5,4);
INSERT INTO auth_user_action (user_id, action_id) VALUE (6,4);
INSERT INTO auth_user_action (user_id, action_id) VALUE (30,4);
-- Yara Action (View Announcement)


-- start hala --(view Grade)
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (2, 'Add-Grade', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,2);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,2);
--new instructor
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,2);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,2);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,2);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,2);
--------



-- end hala --


-- Youssef Lec Auth --

INSERT INTO `sms`.`auth_view` (`id`, `label_ar`, `description_ar`) VALUES ('9', 'Create-lec', 'creat lec component');
INSERT INTO `sms`.`auth_role_view` (`role_id`, `view_id`) VALUES ('1', '9');
INSERT INTO `sms`.`auth_user_view` (`user_id`, `view_id`) VALUES ('1', '9');


-- ahmed start --
ALTER TABLE `sms`.`quiz`
CHANGE COLUMN `auto_close` `is_closed` TINYINT(4) NULL DEFAULT NULL ;
-- ahmed end --

-- 1/5 yousef--

DELETE FROM `sms`.`auth_role_view` WHERE `role_id`='1' and`view_id`='7';

DELETE FROM `sms`.`auth_user_view` WHERE `user_id`='1' and`view_id`='7';

DELETE FROM `sms`.`auth_view` WHERE `id`='7';



INSERT INTO `sms`.`auth_action` (`id`, `label_ar`, `description_ar`) VALUES ('7', 'Add-lec', 'Add Lec Button');
INSERT INTO `sms`.`auth_role_action` (`role_id`, `action_id`) VALUES ('1', '7');
INSERT INTO `sms`.`auth_user_action` (`user_id`, `action_id`) VALUES ('1', '7');

---end

--new image--
UPDATE `sms`.`course` SET `image_path`='/assets/images/course/hala1.png' WHERE `id`='2';

UPDATE `sms`.`course` SET `image_path`='/assets/images/course/Programming.jpg' WHERE `id`='5';

UPDATE `sms`.`course` SET `image_path`='/assets/images/course/neural.jpg' WHERE `id`='6';

UPDATE `sms`.`course` SET `image_path`='/assets/images/course/data.jpg' WHERE `id`='7';

UPDATE `sms`.`course` SET `image_path`='/assets/images/course/c++.jpg' WHERE `id`='8';
--end----

--manar--
UPDATE `sms`.`user_detail` SET `age`='50', `gender`='male', `phone`='0123654' WHERE `user_id`='1';
UPDATE `sms`.`user_detail` SET `age`='20', `gender`='female', `phone`='45893210' WHERE `user_id`='2';
UPDATE `sms`.`user_detail` SET `age`='23', `gender`='female', `phone`='014785' WHERE `user_id`='3';
UPDATE `sms`.`user_detail` SET `age`='40', `gender`='male', `phone`='0258963' WHERE `user_id`='4';
UPDATE `sms`.`user_detail` SET `age`='35', `gender`='male', `phone`='01254789' WHERE `user_id`='5';
UPDATE `sms`.`user_detail` SET `age`='55', `gender`='female', `phone`='0321458' WHERE `user_id`='6';
UPDATE `sms`.`user_detail` SET `age`='25', `gender`='male', `phone`='012587' WHERE `user_id`='7';
--manar--

--auth action on enroll student --
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (5, 'ENROLL_STUDENT', '');
INSERT INTO auth_role_action (role_id, action_id) VALUE (2,5);
INSERT INTO auth_user_action (user_id, action_id) VALUE (2,5);
INSERT INTO auth_user_action (user_id, action_id) VALUE (10,5);
INSERT INTO auth_user_action (user_id, action_id) VALUE (7,5)

--------------
----- hala( role action )------
INSERT INTO auth_user_role (user_id, role_id) VALUE (7, 2);
INSERT INTO auth_user_role (user_id, role_id) VALUE (2, 2);
--------