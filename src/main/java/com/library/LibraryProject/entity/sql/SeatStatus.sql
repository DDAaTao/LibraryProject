-- auto Generated on 2018-09-14 00:47:07 
-- DROP TABLE IF EXISTS seat_status; 
CREATE TABLE seat_status(
	seat_id VARCHAR (50) NOT NULL AUTO_INCREMENT COMMENT 'seatId',
	seat_user_time VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'seatUserTime',
	PRIMARY KEY (seat_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'seat_status';
