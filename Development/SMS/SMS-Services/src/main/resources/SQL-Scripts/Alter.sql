#start hala course_stdtable
ALTER TABLE `sms`.`course_std`
ADD COLUMN `mid_1_grd` INT(11) NOT NULL AFTER `std_id`,
ADD COLUMN `semi_final_grd` INT(11) NOT NULL AFTER `mid_1_grd`,
ADD COLUMN `mid_2_grd` INT(11) NOT NULL AFTER `semi_final_grd`,
ADD COLUMN `final_grd` INT(11) NOT NULL AFTER `mid_2_grd`;
#end hala