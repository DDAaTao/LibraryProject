-- auto Generated on 2018-09-14 00:47:58 
-- DROP TABLE IF EXISTS seat_location; 
CREATE TABLE seat_location(
	seat_id VARCHAR (50) NOT NULL AUTO_INCREMENT COMMENT 'seatId',
	seat_area VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'seatArea',
	seat_storey VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'seatStorey',
	seat_room VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'seatRoom',
	seat_number VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'seatNumber',
	PRIMARY KEY (seat_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'seat_location';
