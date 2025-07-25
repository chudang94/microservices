create table IF NOT EXISTS `t_inventory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sku_code` varchar(255) ,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;