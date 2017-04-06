create database contactdb;

CREATE TABLE `contact` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

create database timsheet;

CREATE TABLE `timesheetdetails` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`timesheet_date` DATE NOT NULL,
	`login_time` TIME NOT NULL,
	`logout_time` TIME NOT NULL,
	`lunch_duration` TIME NOT NULL,
	`total_worked_hours` VARCHAR(50) NULL DEFAULT NULL,
	`total_decimated_hours` DOUBLE NULL DEFAULT NULL,
	`man_days` DOUBLE NULL DEFAULT NULL,
	`created_date` DATE NULL DEFAULT NULL,
	`modified_date` DATE NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8