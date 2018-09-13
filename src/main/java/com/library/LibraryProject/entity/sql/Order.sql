-- auto Generated on 2018-09-14 00:48:14 
-- DROP TABLE IF EXISTS order; 
CREATE TABLE order(
	order_id INT (11) NOT NULL AUTO_INCREMENT COMMENT 'orderId',
	user_id INT (11) NOT NULL DEFAULT -1 COMMENT 'userId',
	seat_status VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'seatStatus',
	order_status VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'orderStatus',
	order_start DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'orderStart',
	order_finish DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'orderFinish',
	order_create DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'orderCreate',
	PRIMARY KEY (order_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'order';
