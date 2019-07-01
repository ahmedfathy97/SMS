ALTER TABLE `sms`.`attachment`
    CHANGE COLUMN `content_type` `content_type` VARCHAR(100) NOT NULL,
    CHANGE COLUMN `file_name` `file_name` VARCHAR(100) NOT NULL,
    ADD COLUMN `start_date` DATE NULL AFTER `file_src_id`,
    ADD COLUMN `end_date` DATE NULL AFTER `start_date`,
    ADD COLUMN `corID` INT NULL AFTER `corID`;



ALTER TABLE `sms`.`exam`
ADD COLUMN `is_closed` TINYINT(4) NULL AFTER `course_id`;
