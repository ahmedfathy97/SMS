ALTER TABLE `sms`.`attachment`
    ADD COLUMN `cor_id` INT NOT NULL AFTER `file_src_id`,
    ADD COLUMN `start_date` DATE NULL DEFAULT NULL AFTER `cor_id`,
    ADD COLUMN `end_date` DATE NULL DEFAULT NULL AFTER `start_date`,
    CHANGE COLUMN `content_type` `content_type` VARCHAR(100) NOT NULL;



ALTER TABLE `sms`.`exam`
ADD COLUMN `is_closed` TINYINT(4) NULL AFTER `course_id`;


CREATE TABLE `sms`.`course_assignment`
(
    `id`             INT  NOT NULL auto_increment,
    `cor_id`         INT  NOT NULL,
    `lec_id`         INT  NOT NULL,
    `file_attach_id` INT  NULL,
    `start_date`     DATE NOT NULL,
    `end_date`       DATE NOT NULL,
    PRIMARY KEY (`id`)
);


ALTER TABLE `sms`.`course_assignment`
    ADD INDEX `fk_course_assignment_course_idx` (`cor_id` ASC) VISIBLE,
    ADD INDEX `fk_course_assignment_attachment_idx` (`file_attach_id` ASC) VISIBLE;
;
ALTER TABLE `sms`.`course_assignment`
    ADD CONSTRAINT `fk_course_assignment_course`
        FOREIGN KEY (`cor_id`)
            REFERENCES `sms`.`course` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD CONSTRAINT `fk_course_assignment_attachment`
        FOREIGN KEY (`file_attach_id`)
            REFERENCES `sms`.`attachment` (`file_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;



CREATE TABLE `sms`.`course_assign_answer`
(
    `id`             INT  NOT NULL auto_increment,
    `assignment_id`  INT  NOT NULL,
    `std_id`         INT  NULL,
    `file_attach_id` INT  NULL DEFAULT NULL,
    `answer_date`    DATE NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `assignment_id_idx` (`assignment_id` ASC) VISIBLE,
    INDEX `file_attach_id_idx` (`file_attach_id` ASC) VISIBLE,
    CONSTRAINT `fk_course_assign_answer_course_assignment`
        FOREIGN KEY (`assignment_id`)
            REFERENCES `sms`.`course_assignment` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_course_assign_asnwer_attachment`
        FOREIGN KEY (`file_attach_id`)
            REFERENCES `sms`.`attachment` (`file_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);




ALTER TABLE `sms`.`user_detail`
ADD COLUMN `image_path` VARCHAR(45) NULL AFTER `university_id`;
