USE `order_service`;
drop table t_order_line_items;
drop table t_orders;

CREATE TABLE `t_orders`
(
    `id`            BIGINT(20) NOT NULL AUTO_INCREMENT,
    `order_number`  VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `t_order_line_items`
(
    `id`          BIGINT(20) NOT NULL AUTO_INCREMENT,
    `sku_code`    VARCHAR(255),
    `price`       DECIMAL(19, 2),
    `quantity`    INT(11),
    `order_id`    BIGINT(20),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`order_id`) REFERENCES `t_orders`(`id`)
);