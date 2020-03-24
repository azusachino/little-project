CREATE TABLE IF NOT EXISTS `merchant`
(
    `id`                   int(10) unsigned                 NOT NULL AUTO_INCREMENT,
    `name`                 varchar(64) COLLATE utf8mb4_bin  NOT NULL COMMENT '商户名称',
    `logo_url`             varchar(256) COLLATE utf8mb4_bin NOT NULL COMMENT '商户 logo',
    `business_license_url` varchar(256) COLLATE utf8mb4_bin NOT NULL COMMENT '商户营业执照',
    `phone`                varchar(64) COLLATE utf8mb4_bin  NOT NULL COMMENT '商户联系电话',
    `address`              varchar(64) COLLATE utf8mb4_bin  NOT NULL COMMENT '商户地址',
    `is_audit`             boolean                          NOT NULL default false COMMENT '是否通过审核',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 17
  DEFAULT CHARSET = utf8;
