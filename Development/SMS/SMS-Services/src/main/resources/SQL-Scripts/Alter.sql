-----YARA----
INSERT INTO auth_view (id, label_ar, description_ar) VALUE (1, 'Add-Attendance', '');
INSERT INTO auth_role_view (role_id, view_id) VALUE (1,1);
INSERT INTO auth_user_view (user_id, view_id) VALUE (4,1);
-----YARA----