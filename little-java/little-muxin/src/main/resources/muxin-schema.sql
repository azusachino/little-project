SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat_msg
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat`
(
    `id`          varchar(64)  NOT NULL,
    `sender_id`   varchar(64)  NOT NULL,
    `receiver_id` varchar(64)  NOT NULL,
    `message`     varchar(255) NOT NULL,
    `sign_flag`   int(1) NOT NULL COMMENT '消息是否签收状态\r\n1：签收\r\n0：未签收\r\n',
    `create_time` datetime     NOT NULL COMMENT '发送请求的事件',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Records of chat_msg
-- ----------------------------

-- ----------------------------
-- Table structure for friend_request
-- ----------------------------
DROP TABLE IF EXISTS `friend_request`;
CREATE TABLE `friend_request`
(
    `id`                varchar(64) NOT NULL,
    `sender_id`         varchar(64) NOT NULL,
    `receiver_id`       varchar(64) NOT NULL,
    `request_date_time` datetime    NOT NULL COMMENT '发送请求的事件',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Records of friends_request
-- ----------------------------

-- ----------------------------
-- Table structure for friends
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend`
(
    `id`        varchar(64) NOT NULL,
    `user_id`   varchar(64) NOT NULL COMMENT '用户id',
    `friend_id` varchar(64) NOT NULL COMMENT '用户的好友id',
    PRIMARY KEY (`id`),
    UNIQUE KEY `user_friend` (`user_id`, `friend_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Records of my_friends
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`               varchar(64)                                                  NOT NULL,
    `username`         varchar(20)                                                  NOT NULL COMMENT '用户名，账号，慕信号',
    `password`         varchar(64)                                                  NOT NULL COMMENT '密码',
    `face_image`       varchar(255)                                                 NOT NULL COMMENT '我的头像，如果没有默认给一张',
    `face_image_large` varchar(255)                                                 NOT NULL,
    `nickname`         varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '昵称',
    `qr_code`          varchar(255)                                                 NOT NULL COMMENT '新用户注册后默认后台生成二维码，并且上传到fast dfs',
    `cid`              varchar(64) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`),
    UNIQUE KEY `username` (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
