# Make cr_id  FK
ALTER TABLE `sms`.`cor_main_details`
ADD CONSTRAINT `fk_cor_main_details_course`
  FOREIGN KEY (`cr_id`)
  REFERENCES `sms`.`course` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
# Make category_id type_id level_id  Fk

ALTER TABLE `sms`.`cor_main_details`
ADD INDEX `fk_cor_main_details_cor_category_idx` (`category_id` ASC),
ADD INDEX `fk_cor_main_details_cor_type_idx` (`type_id` ASC),
ADD INDEX `fk_cor_main_details_cor_level_idx` (`level_id` ASC);
ALTER TABLE `sms`.`cor_main_details`
ADD CONSTRAINT `fk_cor_main_details_cor_category`
  FOREIGN KEY (`category_id`)
  REFERENCES `sms`.`cor_category` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_cor_main_details_cor_type`
  FOREIGN KEY (`type_id`)
  REFERENCES `sms`.`cor_type` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_cor_main_details_cor_level`
  FOREIGN KEY (`level_id`)
  REFERENCES `sms`.`cor_level` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
