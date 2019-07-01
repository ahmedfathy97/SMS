INSERT INTO auth_role (id, label_ar, description_ar) VALUES ('1', 'Instructor', 'teach courses');
INSERT INTO auth_role (id, label_ar, description_ar) VALUES ('2', 'student', 'study courses');
INSERT INTO auth_role (id, label_ar, description_ar) VALUES ('3', 'system_admin', 'control ');

INSERT INTO auth_view (id, label_ar, description_ar) VALUE (1, 'User-List', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (2, 'Add-Grade', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (3, 'Add-Attendance', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (4, 'Add-Announcement', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (5, 'User-Profile', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (6, 'User-Edit', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUES ('8', 'Add_Cor', 'create new course');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (10, 'Course-Quizes', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (11, 'Create-Quizes', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (12, 'Add_Question', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (13, 'Answer_Question', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (14, 'Quiz_Details', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUES ('9', 'Add-lec', 'create lec component');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (15, 'Main_Details', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (16, 'Quiz_Result', '');
INSERT INTO auth_view (id, label_ar) VALUES ('7', 'Add-Matrial');
INSERT INTO auth_view (id, label_ar) VALUES ('17', 'Lecture_Details');
INSERT INTO auth_view (id, label_ar) VALUES ('18', 'Course_Lectures');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (24, 'COURSE_EXAMS', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (19, 'ADD_EXAM_QUESTION', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (20, 'ANSWER_EXAM_QUESTION', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (21, 'EXAM_DETAILS', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (22, 'EXAM_MAIN_DETAILS', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (23, 'EXAM_RESULT', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (25, 'Course_list', '');
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (26, 'My_Course', '');

INSERT INTO auth_action (id, label_ar, description_ar) VALUE (1, 'Add-Grade', '');
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (3, 'Add-Attendance', '');
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (4, 'Add-Announcement', '');
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (5, 'ENROLL_STUDENT', '');
INSERT INTO auth_action (id, label_ar) VALUES ('7', 'Add-Matrial');
INSERT INTO auth_action (id, label_ar, description_ar) VALUES ('8', 'Add_Cor', 'create new course actions');
INSERT INTO auth_action (id, label_ar, description_ar) VALUES ('9', 'Add-lec', 'Add Lec Button');
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (10, 'Course-Quizes', '');
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (11, 'Create-Quizes', '');
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (12, 'Add_Question', '');
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (13, 'Answer_Question', '');
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (14, 'Quiz_Details', '');
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (15, 'Close_quiz', '');
INSERT INTO auth_action (id, label_ar) VALUES ('16', 'Download-Matrial');
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (17, 'CLOSE_EXAM', '');
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (18, 'ANSWER_EXAM_QUESTION', '');


INSERT INTO auth_role_view (role_id, view_id) VALUE (3,1);
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,1);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,5);
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,5);
INSERT INTO auth_role_view (role_id, view_id) VALUE (3,5);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,6);
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,6);
INSERT INTO auth_role_view (role_id, view_id) VALUE (3,6);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,3);
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,3);
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,3);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,4);
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,4);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,2);
INSERT INTO auth_role_action (role_id, action_id) VALUE (2,5);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,10);
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,10);
INSERT INTO auth_role_action (role_id, action_id ) VALUE (1,10);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,11);
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,11);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,12);
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,12);
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,13);
INSERT INTO auth_role_action (role_id, action_id) VALUE (2,13);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,14);
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,14);
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,14);
INSERT INTO auth_role_view (role_id, view_id) VALUES ('1', '8');
INSERT INTO auth_role_action (role_id, action_id) VALUES ('1', '8');
INSERT INTO auth_role_view (role_id, view_id) VALUES ('1', '9');
INSERT INTO auth_role_action (role_id, action_id) VALUES ('1', '9');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,15);
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,16);




INSERT INTO auth_role_action (role_id, action_id) VALUE (1,15);
UPDATE auth_view SET label_ar = 'Add-Material' WHERE (id = '7');
INSERT INTO auth_role_view (role_id, view_id) VALUES ('1', '7');
UPDATE auth_action SET label_ar = 'Add-Material' WHERE (id = '7');
INSERT INTO auth_role_action (role_id, action_id) VALUES ('1', '7');
INSERT INTO auth_role_action (role_id, action_id) VALUES ('1', '16');
INSERT INTO auth_role_action (role_id, action_id) VALUES ('2', '16');
INSERT INTO auth_role_view (role_id, view_id) VALUES ('1', '17');
INSERT INTO auth_role_view (role_id, view_id) VALUES ('2', '17');
INSERT INTO auth_role_view (role_id, view_id) VALUES ('1', '18');
INSERT INTO auth_role_view (role_id, view_id) VALUES ('2', '18');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,13);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,24);
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,24);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,19);
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,20);
INSERT INTO auth_role_action (role_id, action_id) VALUE (2,18);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,21);
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,21);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,22);
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,23);
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,17);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,25);
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,25);
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,26);
INSERT INTO auth_role_view (role_id, view_id) VALUE (2,26);


INSERT INTO question_type (id, label_en) VALUES ('1', 'MCQ');
INSERT INTO question_type (id, label_en) VALUES ('2', 'True & False');

INSERT INTO file_source (id, lable_en) VALUES ('1', 'Attachment');
INSERT INTO file_source (id, lable_en) VALUES ('2', 'Assignment');






INSERT INTO `sms`.`cor_category` (`label_en`) VALUES ('Information System');
INSERT INTO `sms`.`cor_category` (`label_en`) VALUES ('Computer Science');
INSERT INTO `sms`.`cor_category` (`label_en`) VALUES ('Programming');
INSERT INTO `sms`.`cor_category` (`label_en`) VALUES ('Multimedia');


INSERT INTO `sms`.`cor_type` (`label_en`) VALUES ('Academic');
INSERT INTO `sms`.`cor_type` (`label_en`) VALUES ('Practical');


INSERT INTO `sms`.`cor_level` (`label_en`) VALUES ('Beginner');
INSERT INTO `sms`.`cor_level` (`label_en`) VALUES ('Intermediate');
INSERT INTO `sms`.`cor_level` (`label_en`) VALUES ('Advanced');

