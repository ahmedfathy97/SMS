INSERT INTO auth_user (id, user_name, user_pass, first_name, last_name)
VALUES (1, 'Ahmed_Matar', '1234', 'Ahmed', 'Matar');
INSERT INTO auth_user (id, user_name, user_pass, first_name, last_name)
VALUES (2, 'ahmed_Taha', '1233', 'Ahmed', 'Taha');

INSERT INTO cor_category (id, label_en) VALUES (1, 'Design');
INSERT INTO cor_category (id, label_en) VALUES (2, 'Programming');
INSERT INTO cor_category (id, label_en) VALUES (3, 'IT');
INSERT INTO cor_category (id, label_en) VALUES (4, 'Web Development');

-- TODO: Youssef there is Typo here
INSERT INTO cor_type (id, label_en) VALUES (1, 'Acadmic');
INSERT INTO cor_type (id, label_en) VALUES (2, 'Practical');

-- TODO: Youssef there is Typo here
INSERT INTO cor_level (id, label_en) VALUES (1, 'Under Grduated');
INSERT INTO cor_level (id, label_en) VALUES (2, 'Graduated');
INSERT INTO cor_level (id, label_en) VALUES (3, 'Beginner');
INSERT INTO cor_level (id, label_en) VALUES (4, 'Advanced');
-- TODO: Youssef there is Typo here
INSERT INTO cor_level (id, label_en) VALUES (5, 'Entery');

INSERT INTO course (id, cor_name, duration, start_date, end_date, instructor_id, category_id, type_id, level_id, description)
 VALUES (1, 'Java', 3, '2018-5-12', '2018-8-12', 1, 1, 1, 1, 'Programming Language');
INSERT INTO course (id, cor_name, duration, start_date, end_date, instructor_id, category_id, type_id, level_id, description)
VALUES (2, 'C++', 3, '2018-5-12', '2018-8-12', 2, 2, 2, 2, 'Programming Language');
INSERT INTO course (id, cor_name, duration, start_date, end_date, instructor_id, category_id, type_id, level_id, description)
VALUES (3, 'C', 3, '2018-5-12', '2018-8-12', 2, 2, 2, 2, 'Programming Language');
INSERT INTO course (id, cor_name, duration, start_date, end_date, instructor_id, category_id, type_id, level_id, description)
VALUES (4, 'C#', 3, '2018-5-12', '2018-8-12', 2, 2, 2, 2, 'Programming Language');
