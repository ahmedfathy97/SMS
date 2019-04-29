-----Yara View (Create Attendance)----
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (3, 'Add-Attendance', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (5,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (6,3);
INSERT INTO auth_user_view (user_id, view_id) VALUE (30,3);
-----Yara View (Attendance)----

-----Yara Action (View Attendance)
INSERT INTO auth_action (id, label_ar, description_ar) VALUE (3, 'Add-Attendance', '');
INSERT INTO auth_role_action (role_id, action_id) VALUE (1,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (1,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (4,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (5,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (6,3);
INSERT INTO auth_user_action (user_id, action_id) VALUE (30,3);
-----Yara Action (View Attendance)


--start hala--
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (2, 'Add-Grade', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,2);
INSERT INTO auth_user_view (user_id, view_id) VALUE (1,2);
--end hala----