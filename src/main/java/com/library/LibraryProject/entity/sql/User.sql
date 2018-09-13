-- auto Generated on 2018-09-14 00:01:00 
-- DROP TABLE IF EXISTS user; 
CREATE TABLE user(
	user_id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'userId',
	user_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'userName',
	user_number VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'userNumber',
	user_password VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'userPassword',
	user_sex VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'userSex',
	user_academy VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'userAcademy',
	user_profession VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'userProfession',
	user_violation VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'userViolation',
	user_status VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'userStatus',
	PRIMARY KEY (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user';
