ALTER TABLE `sms`.`attachment`
    ADD COLUMN `corID` INT NOT NULL AFTER `file_src_id`,
    ADD COLUMN `start_date` DATE NULL DEFAULT NULL AFTER `corID`,
    ADD COLUMN `end_date` DATE NULL DEFAULT NULL AFTER `start_date`,
    CHANGE COLUMN `content_type` `content_type` VARCHAR(100) NOT NULL;



ALTER TABLE `sms`.`exam`
ADD COLUMN `is_closed` TINYINT(4) NULL AFTER `course_id`;

ALTER TABLE `sms`.`user_detail`
ADD COLUMN `image_path` VARCHAR(45) NULL AFTER `university_id`;
