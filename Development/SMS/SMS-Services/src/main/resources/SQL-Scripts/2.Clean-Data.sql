#INSERTion user_auth
INSERT INTO `sms`.`auth_user` (`id`, `user_name`, `user_pass`, `first_name`, `last_name`)
VALUES ('1', 'ahmed matar', '1234', 'ahmed', 'matar');
INSERT INTO `sms`.`auth_user` (`id`, `user_name`, `user_pass`, `first_name`, `last_name`)
VALUES ('2', 'ahmed taha', '1233', 'ahmed', 'taha');

# INSERTion courseCategoryTable
INSERT INTO `sms`.`cor_category` (`id`, `label_en`) VALUES ('1', 'Design');
INSERT INTO `sms`.`cor_category` (`id`, `label_en`) VALUES ('2', 'Programming');
INSERT INTO `sms`.`cor_category` (`id`, `label_en`) VALUES ('3', 'IT');
INSERT INTO `sms`.`cor_category` (`id`, `label_en`) VALUES ('4', 'Web Development');

# INSERTion courseTypeTable
INSERT INTO `sms`.`cor_type` (`id`, `label_en`) VALUES ('1', 'Acadmic');
INSERT INTO `sms`.`cor_type` (`id`, `label_en`) VALUES ('2', 'Practical');

# INSERTion courseLevelTable
INSERT INTO `sms`.`cor_level` (`id`, `label_en`) VALUES ('1', 'Under Grduated');
INSERT INTO `sms`.`cor_level` (`id`, `label_en`) VALUES ('2', 'Graduated');
INSERT INTO `sms`.`cor_level` (`id`, `label_en`) VALUES ('3', 'Beginner');
INSERT INTO `sms`.`cor_level` (`id`, `label_en`) VALUES ('4', 'Advanced');
INSERT INTO `sms`.`cor_level` (`id`, `label_en`) VALUES ('5', 'Entery');

#INSERTion course
INSERT INTO `sms`.`course` (`id`, `cor_name`, `duration`, `start_date`, `end_date`, `instructor_id`, `category_id`, `type_id`, `level_id`, `description`)
 VALUES ('1', 'java', '3', '2018-5-12', '2018-8-12', '1', '1', '1', '1', 'programming language');
INSERT INTO `sms`.`course` (`id`, `cor_name`, `duration`, `start_date`, `end_date`, `instructor_id`, `category_id`, `type_id`, `level_id`, `description`)
VALUES ('2', 'c++', '3', '2018-5-12', '2018-8-12', '2', '2', '2', '2', 'programming language');
