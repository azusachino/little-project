create
database if not exists `publish`;
use
`publish`;


create table if not exists user
(
    USER_ID
    int
    auto_increment
    comment
    '用户ID'
    primary
    key,
    USERNAME
    varchar
(
    50
) not null comment '姓名',
    PASSWORD varchar
(
    100
) not null comment '登陆密码',
    SEX varchar
(
    1
) null comment '性别 0:保密,1:男,2:女',
    AVATAR varchar
(
    60
) null default '../../assets/icon.jpg' comment '头像地址',
    CREATE_TIME TIMESTAMP not NULL DEFAULT current_timestamp comment '创建时间',
    UPDATE_TIME TIMESTAMP NULL ON UPDATE current_timestamp comment '上次修改时间',
    LAST_LOGIN_TIME TIMESTAMP NULL comment '上次登录时间',
    STATUS varchar
(
    1
) not null default '1' comment '账户状态 1:正常,2:已注销,3:长时间无人使用',
    constraint user_USERNAME_index unique
(
    USERNAME
)
    )
    comment '用户表';


create table if not exists permission
(
    PERMISSION_ID
    int
    auto_increment
    comment
    '权限ID'
    primary
    key,
    PERMISSION
    varchar
(
    50
) not null comment '权限'
    )
    comment '权限表';

create table if not exists role
(
    ROLE_ID
    int
    not
    null
    comment
    '用户类型ID'
    primary
    key,
    ROLE
    varchar
(
    50
) not null comment '用户类型'
    )
    comment '用户类型表';

create table if not exists user_role
(
    USER_ID varchar
(
    10
) not null comment '用户ID',
    ROLE_ID varchar
(
    10
) not null default '3' comment '角色ID'
    )
    comment '用户角色关联表';

create table if not exists role_permission
(
    ROLE_ID varchar
(
    10
) not null comment '角色ID',
    PERMISSION_ID varchar
(
    10
) not null comment '权限ID'
    )
    comment '角色权限表';

CREATE TABLE IF NOT EXISTS `NEWS`
(
    `NEWS_ID` bigint
(
    20
) NOT NULL AUTO_INCREMENT COMMENT '新闻主键id',
    `TITLE` varchar
(
    200
) NOT NULL DEFAULT '' COMMENT '标题',
    `CATEGORY_ID` bigint
(
    20
) NOT NULL DEFAULT '0' COMMENT '新闻类型',
    `COVER_IMAGE` varchar
(
    200
) NOT NULL DEFAULT '' COMMENT '新闻封面图片',
    `CONTENT` text NOT NULL COMMENT '内容',
    `STATUS` tinyint
(
    4
) NOT NULL DEFAULT '0' COMMENT '发布状态 0-发布 1-草稿',
    `VIEWS` bigint
(
    20
) NOT NULL DEFAULT '0' COMMENT '浏览量',
    `IS_DELETED` tinyint
(
    4
) NOT NULL DEFAULT '0' COMMENT '是否已删除 0-未删除 1-已删除',
    `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY
(
    `NEWS_ID`
)
    ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


insert into `NEWS`(`NEWS_ID`, `TITLE`, `CATEGORY_ID`, `COVER_IMAGE`, `CONTENT`, `STATUS`, `VIEWS`, `IS_DELETED`,
                   `CREATE_TIME`, `UPDATE_TIME`)
values (1, '基层访问', 1, 'http://localhost:28083/files/20190203_0219105.png',
        '<p class=\"text\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;text-indent:2em;\">\n	新华社北京2月1日电 中华民族传统节日农历春节来临之际，中共中央总书记、国家主席、中央军委主席习近平在北京看望慰问基层干部群众，考察北京冬奥会、冬残奥会筹办工作，向全国各族人民致以美好的新春祝福，祝各族人民幸福安康，祝伟大祖国繁荣吉祥。\n</p>\n<p class=\"text\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;text-indent:2em;\">\n	中共中央政治局常委、国务院副总理韩正陪同考察北京冬奥会和冬残奥会筹办工作。\n</p>\n<p class=\"text\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;text-indent:2em;\">\n	冬日的北京，阳光万里，碧空如洗。2月1日，习近平在中共中央政治局委员、北京市委书记蔡奇和市长陈吉宁陪同下，深入机关、社区、冬训中心考察调研，给基层干部群众送去党中央的关心和慰问。\n</p>\n<p align=\"center\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/7551828141/641\" />\n</p>\n<p align=\"center\" class=\"text image_desc\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;\">\n	2月1日，中共中央总书记、国家主席、中央军委主席习近平在北京看望慰问基层干部群众，考察北京冬奥会、冬残奥会筹办工作。这是1日上午，习近平在北京市公安局，同公安英模和干警代表一一握手，向全国广大公安干警致以新春祝福。 新华社记者 谢环驰 摄\n</p>\n<p class=\"text\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;text-indent:2em;\">\n	上午，习近平首先来到北京市公安局，走进合成作战指挥中心和指挥大厅，通过大屏幕了解勤务指挥调度、巡逻警务、视频警务、区域警务合作和京津冀警务协同发展等工作情况。指挥大厅内，习近平通过视频连线一线执勤民警，向他们表示诚挚慰问，叮嘱他们注意安全、保重身体，并向全国广大公安干警拜年。在北京市公安局一层大厅，习近平同公安英模和干警代表一一握手。习近平强调，党中央十分关心过节期间全国特别是首都地区的社会稳定，为的是确保人民群众平平安安过好年。今年是新中国成立70周年，确保首都社会稳定，北京市使命光荣、责任重大、任务艰巨。要统筹推进各方面工作，坚决完成好任务，让党中央放心、让全国人民放心。\n</p>\n<p align=\"center\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/7551828142/641\" />\n</p>\n<p align=\"center\" class=\"text image_desc\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;\">\n	2月1日，中共中央总书记、国家主席、中央军委主席习近平在北京看望慰问基层干部群众，考察北京冬奥会、冬残奥会筹办工作。这是1日上午，习近平在前门东区草厂四条胡同32号院，高兴地拿起一幅“福”字，亲自贴到门上，给这里的老街坊们拜年。 新华社记者 鞠鹏 摄\n</p>\n<p class=\"text\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;text-indent:2em;\">\n	临近春节，北京城内年味渐浓，大街小巷张灯结彩，家家户户喜迎春节。习近平来到前门东区，沿草厂四条胡同步行察看街巷风貌，听取区域规划建设、老城保护、疏解腾退、人居环境改善等情况介绍。前门东区是北京老城重要历史片区，是北京这座千年古都深厚文化底蕴的重要体现。习近平对北京开展旧城保护整治的思路和做法表示肯定。他强调，一个城市的历史遗迹、文化古迹、人文底蕴，是城市生命的一部分。文化底蕴毁掉了，城市建得再新再好，也是缺乏生命力的。要把老城区改造提升同保护历史遗迹、保存历史文脉统一起来，既要改善人居环境，又要保护历史文化底蕴，让历史文化和现代生活融为一体。老北京的一个显著特色就是胡同，要注意保留胡同特色，让城市留住记忆，让人们记住乡愁。\n</p>\n<p align=\"center\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/7551828143/641\" />\n</p>\n<p align=\"center\" class=\"text image_desc\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;\">\n	2月1日，中共中央总书记、国家主席、中央军委主席习近平在北京看望慰问基层干部群众，考察北京冬奥会、冬残奥会筹办工作。这是1日上午，习近平来到前门东区草厂四条胡同看望慰问群众。 新华社记者 谢环驰 摄\n</p>',
        1, 0, 1, '2019-02-03 02:14:56', '2019-02-02 22:16:48');
insert into `NEWS`(`NEWS_ID`, `TITLE`, `CATEGORY_ID`, `COVER_IMAGE`, `CONTENT`, `STATUS`, `VIEWS`, `IS_DELETED`,
                   `CREATE_TIME`, `UPDATE_TIME`)
values (2, '资讯管理系统', 1, 'http://localhost:28083/files/20190203_12162017.jpg',
        '<p class=\"introduction\" style=\"color:#555555;font-family:&quot;font-size:18px;\">\n	导语：在休闲方式上，近八成人选择泡汤养生。不同年龄人群也有自己的偏好。30岁以上偏爱洗浴汗蒸、茶馆、按摩/足疗，30岁以下偏爱网吧/电竞、桌游和酒吧。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	《恭喜发财》又在大街小巷开始响起来，提醒着我们最盛大的节日——春节就要到了。这个春节你将在哪里，和谁一起，又会如何度过呢？\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	近日，某外卖点评搜索平台发布《2019春节消费地图》（下称“报告”），基于大数据洞察了不同地域消费者不同的过年方式，一起来看看。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<span style=\"font-weight:bolder;\">春节餐桌上的C位 还是传统美食</span>\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	吃是过年头等大事。这个春节，各地的年味主食依然被传统美食主宰。北京的饺子、烤鸭，广州的煲仔饭、椰子鸡，武汉的热干面，西安的泡馍，成都的串串，华东的八宝饭，西部的腊肉……依旧是各个地方过年最火菜品。这些菜品每年都有，但大家每年对它们也都有不同的期待。\n</p>\n<div class=\"LazyLoad is-visible\" style=\"margin:0px;padding:0px;font-family:&quot;font-size:18px;\">\n	<p class=\"one-p\">\n		<img class=\"CONTENT-picture\" alt=\"\" src=\"https://inews.gtimg.com/newsapp_bt/0/7566165035/1000\" />\n	</p>\n</div>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	除了北方的饺子、南方的盆菜这些传统菜品，这个春节还有网红菜来凑热闹。《报告》显示，舒芙蕾、脏脏茶、炭火蛙锅成为2018春节期间搜索量最高的三样网红菜，相信2019它们也不会缺席。\n</p>\n<div class=\"LazyLoad\" style=\"margin:0px;padding:0px;font-family:&quot;font-size:18px;\">\n</div>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<span style=\"font-weight:bolder;\">休闲方式选什么？近八成人选择泡汤养生</span>\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	除了吃喝，春节该怎么玩？亲朋好友、同窗同事一起聚聚，休闲玩乐肯定少不了。在休闲方式上，近八成人选择泡汤养生。不同年龄人群也有自己的偏好。30岁以上偏爱洗浴汗蒸、茶馆、按摩/足疗，30岁以下偏爱网吧/电竞、桌游和酒吧。\n</p>\n<div class=\"LazyLoad\" style=\"margin:0px;padding:0px;font-family:&quot;font-size:18px;\">\n</div>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<span style=\"font-weight:bolder;\">过年去旅游 上海迪士尼很火爆</span>\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	假期出游犒劳一下自己，也成国人度假标配。大年初一聚会过后，不少国人就选择踏上旅行的征途。数据显示，2019春节景区附近酒店提前预定订单中，正月初二、初三的需求最旺。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	国内景区中，上海迪士尼、横店影视城、哈尔滨冰雪大世界成为最热景区。境外游中，中国香港、曼谷、东京成为最热目的地。东京、大阪、京都热度上升最快。\n</p>\n<div class=\"LazyLoad\" style=\"margin:0px;padding:0px;font-family:&quot;font-size:18px;\">\n</div>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<span style=\"font-weight:bolder;\">感受传统民俗文化成“新潮流”</span>\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	当然，还有越来越多的消费者开始回归年味，逛庙会、赏花灯、看展览……传统民俗文化已经成为过年“新潮流”了。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	《报告》显示，春节期间花灯庙会同比增速94%，展览馆增速94%，祈福地增速47%。西安-大唐芙蓉园成为全国人气最高的花灯庙会。人们赶的不只是热闹，更是体验民俗的美好，感受传统年味。\n</p>\n<div class=\"LazyLoad is-visible\" style=\"margin:0px;padding:0px;font-family:&quot;font-size:18px;\">\n	<p class=\"one-p\">\n		<img class=\"CONTENT-picture\" alt=\"\" src=\"https://inews.gtimg.com/newsapp_bt/0/7566165040/1000\" />\n	</p>\n</div>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	在品质升级、服务升级的趋势下，国人对年味的定义日趋多元、个性。但比吃什么玩什么更重要的是，和谁吃和谁玩。只要与家人坐在一起，吃什么，怎么吃，去哪里，也都是年味。愿你的2019春节，被美好包围。\n</p>\n<div class=\"article-STATUS\" style=\"margin:0px;padding:20px 0px 50px;font-family:&quot;font-size:18px;\">\n	<div style=\"margin:0px;padding:0px;\">\n	</div>\n	<div class=\"through theend\" style=\"margin:0px auto;padding:0px;text-align:center;font-family:Politica;\">\n		<span style=\"background:#FFFFFF;\">THE END</span>\n	</div>\n</div>',
        1, 0, 1, '2019-02-03 12:12:07', '2019-02-03 12:12:07');
insert into `NEWS`(`NEWS_ID`, `TITLE`, `CATEGORY_ID`, `COVER_IMAGE`, `CONTENT`, `STATUS`, `VIEWS`, `IS_DELETED`,
                   `CREATE_TIME`, `UPDATE_TIME`)
values (3, '431', 6, 'http://localhost:28083/files/20190203_12165832.png', '4321', 1, 0, 1, '2019-02-03 12:12:43',
        '2019-02-03 12:12:43');
insert into `NEWS`(`NEWS_ID`, `TITLE`, `CATEGORY_ID`, `COVER_IMAGE`, `CONTENT`, `STATUS`, `VIEWS`, `IS_DELETED`,
                   `CREATE_TIME`, `UPDATE_TIME`)
values (4, '春节过后，宋朝人是怎么发“开工红包”的', 11, 'http://localhost:8080/files/20190212_16514211.jpg',
        '<img src=\"/files/20190212_16513567.jpg\" alt=\"\" />', 1, 0, 0, '2019-02-12 16:47:25', '2019-02-12 16:47:25');
insert into `NEWS`(`NEWS_ID`, `TITLE`, `CATEGORY_ID`, `COVER_IMAGE`, `CONTENT`, `STATUS`, `VIEWS`, `IS_DELETED`,
                   `CREATE_TIME`, `UPDATE_TIME`)
values (5, '《流浪地球》的改编：理性属于科幻文学，感性属于科幻电影？', 11, 'http://localhost:8080/files/20190212_16530862.jpg',
        '<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	春节期间公映的《疯狂的外星人》虽然在片头上还注明改编自刘慈欣原著小说《乡村教师》，但情节已经面目全非，毫无关联。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	然而，看过全片之后，我们却惊讶地发现，整个电影的核心理念，至少在三个方面理念，完全是承继自刘慈欣的。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	这使得这部电影有一些奇怪，明明在情节上已经将原著小说的旧有故事彻底推翻，重新编造了一系列矛盾冲突，让电影成为一部完全与原著情节割断的电影，但内在核心理念上，却从另一个地方，又移植了原著作者的思想。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	《疯狂的外星人》的根本主题是什么？\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	其实看到最后，整个电影的目的，就是想开涮一下代表最先进国家的C国人，其实就是大家心照不宣的美国人。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/7609000820/1000\" class=\"CONTENT-picture\" />\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	电影基本接洽了好莱坞电影里的美国人总是冲在前面、担当拯救重任的共同“人设”，但是同时，却对美国这种斗勇使狠的蛮横霸权作风，作了无微不至的讽刺。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	在影片里，同时接洽了好莱坞定型的是对俄罗斯的设定。在影片开头，当美国人与外星人准备建立交往的时候，特意提到了象征着俄国人的S国，美国人如此一意孤行地抢先与外星人建交，防备着的就是俄罗斯。而这种设定，也是好莱坞电影冷战时期及后冷战时代，都必不可少的基本规则。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	而美国人一到了克里姆林宫，立刻大开杀戒，几乎就是好莱坞谍战片万变不离其宗的最喜欢的想象，包括《碟中谍》系列在冷战后，还要让汤姆克鲁斯大闹俄罗斯的红场。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	可以看出，好莱坞电影对破坏前苏联的经典代表性场景，有着一种什么样的强烈渴望与期待。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/7616455844/1000\" class=\"CONTENT-picture\" />\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	中国电影基本接收了好莱坞电影的衣钵，《疯狂的外星人》让美国人与俄罗斯人莫名其妙地在谈判之后，来了一场疯狂对射。这个场面可能吗？谈判会带着武器进入室内吗？\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	反正从这一幕可以看出，中国电影不仅涉足过去一直由好莱坞电影承包的拯救世界的主题了，而且开始插足世界国与国之际的刀光剑影了。中国电影的内在气质，已经纸包不住火地接受好莱坞全球到处见缝插针的取景思维了。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	《疯狂的外星人》里与美国的全副武装及俄罗斯的火力全开相不同的是，中国却是一片融融乐乐的俗世桃源。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	当美国飞机扬长进入中国国土的时候，我们看到中国国防力量聊胜于无，根本没有适时出击，而一个耍猴的，却承接了与美国特工的直接面对面的任务。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/6760770329/1000\" class=\"CONTENT-picture\" />\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	偶有警察上门，一直把耍猴的当成了喝醉酒的，于是，电影里的中国，同样是好莱坞电影里的惯常设计，就是中国是敞开着大门，随时恭请外国人来去无阻。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	《疯狂的外星人》最主要的任务，我们上面说了，就是拿美国人开涮。美国人就是电影里被耍的猴。特别是耿浩用自己耍猴的猴，代替外星人，去忽悠美国人的时候，那一帮美国人乖乖就范，而在这种耍美国人的过程中，最恶劣的想象，就是用亚洲人的粪便这一最不洁的物品，来让美国人在嘴里滚来滚去，就像当年义和团用马桶迎战侵略中国的洋兵洋将一样，中国人获得了精神上的胜利。那个愚蠢的美国人，也在电影里暴跳如雷，给我们中国人带来了无穷的快乐。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	中国人凭什么可以耍美国人的猴？\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/7452812931/1000\" class=\"CONTENT-picture\" />\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	这就是中国人的悠久的文化传统，也就是电影里所想表达出的主题。耍猴的耿浩具有根深叶茂的家传身教，他一直苦守祖业，在游乐场里，艰难谋生，因为耍猴的职业行当的需要，他善于变通转换，善于因势利导，善于随行就市，所以，他对付外星人与美国人，用的都是一套手法，耍猴的绳在手里时，那就用鞭子对付你；如果技不如人，那么就下跪臣服，但一旦逮着机会，依然会耍你一下，比如让美国人吃屎丸，就是耍猴人的一次最伟大的胜利。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	耍猴人就靠着自己的耍猴技巧，最后让外星人没了脾气，而同时，他身边的挚友阿飞，则用中国文化里伟大的酒，浸泡了外星人，让中国传统文化的酒神精神，灌输进外星人的身体。两个中国男人，双管齐下，立刻让外星人融洽进了中华文化博大精深的肉体上的“耍”与精神上的“醉”的两种至高无上的纯粹境界里，乐颠颠地离开了地球，与中国人建交了。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	美国人最后还在那里穷兵黩武，去刚果抓猴，根本不知道，中国人就用自己的国粹——肉体上的“耍”与精神上的“醉”把外星人征服了。由此，电影完成了它的讽喻意图。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	这些情节，都是宁浩编出来的，我们可以在字幕上，看到故事来源于宁浩。编剧里也没有刘慈欣的名字。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	那么，你要问了，这部电影里，有着刘慈欣什么样的思想精髓？\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	我想，刘慈欣的思想精髓，重点体现在外星人与地球人的冲突与交锋环节里。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/7346600580/1000\" class=\"CONTENT-picture\" />\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	首先，我们看到，低级文明是不应该存在的理念，贯穿全片。这是刘慈欣小说里极具悲剧意义的一条颠扑不破的真理。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	刘慈欣在《三体》中提出宇宙文明有两条公理：一是生存是文明的第一需要。二是文明不断增长和扩张，但宇宙中物质总量保持不变。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	也就是说世界资源是有限的，但是生命能够无限繁衍，这必然导致无限生命对有限资源的竞争与掠夺，最后解决的办法，只能是高级文明毁灭低端文明。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/7616456355/1000\" class=\"CONTENT-picture\" />\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	所以，影片里的外星人，从一开始就秉承了刘慈欣这样的理念，称地球是垃圾星球，地球人是低端生物，在影片的最后，外星人大战地球人的时候，还在那里叫嚣：“你们这些低端文明就不应该存在。”\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	所以，这就决定了同样是表现地球人与外星人接触的《疯狂的外星人》与斯皮尔伯格拍摄的《ET》有着本质的区别。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/7616456356/1000\" class=\"CONTENT-picture\" />\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	在《ET》中，通过一个孩子的视野与心灵窗口，看到了地球文明对其它新异文明的强烈的渴望沟通与交流的内在情愫，把文明之间能够达到的相互融洽存在的共同心理语境，表现得相当温馨与美好。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	这可能与美国文化海纳百川的基因有着密切关系，毕竟美国是一个由移民打造的国家，对异域文明能够兼收并蓄，并没有在心理上出现强烈的排斥情绪，并且随着美国社会反思声浪一次次鼓荡向前，这种接受异域文化的社会企求，越来越成为社会主流的一种思潮。斯皮尔伯格拍摄的《ET》就反映了这样的一种社会倾向。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	而我们中国相对而言，多年来一直是闭关锁国的精神趋向，依然如巨石阵一样沉淀在中国人血脉之中，这就形成了一种乌眼鸡式的竞争文化，你多吃了一口，我就少吃一口，也就自然而然地把自己的思维方式，移交给了电影里的外星人的基本立场之中。从而我们电影里的外星人，实际上就是一个中国人思维模式的变种。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	其次，我们可以从《疯狂的外星人》里看到刘慈欣提出的一种“猜疑链”的重要概念的巨大影响。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	“猜疑链”的重要概念出现在《三体》第二部中，大致意思是，就是人与人之间因为利害冲突关系，存在着一种根深蒂固的猜疑情结，谁都不知道谁先下手干掉自己，那么与其这样，不如先出手干掉对方。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	《三国演义》中的曹操杀死吕伯奢，就是因为曹操觉得自己如果慢一节拍，吕伯奢就会杀掉自己。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/7533725610/1000\" class=\"CONTENT-picture\" />\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	所以，刘慈欣在小说认为，这是人类的“黑暗森林”，“在这片森林中，他人就是地狱，就是永恒的威胁，任何暴露自己存在的生命都将很快被消灭。这就是宇宙文明的图景，这就是对费米悖论的解释。”\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	所以，我们在《疯狂的外星人》里看到的情节交锋，基本就是对刘慈欣这一理论的图解。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	美国人与俄国人一语不合，就大打出手；外星人不断地拍摄游乐园里的各个景点，暴露出自己的生命存在的方位，立刻引动美国特工在世界各地到处出没；而中国人与外星人之间，从没有什么感情上的沟通，“他人就是地狱，就是永恒的威胁”，是耿浩、阿飞对待外星人的基本态度，在电影里设置的几次强弱逆转中，耿浩、阿飞都是无一例外地按照这样的态度，取舍对外星人臣服还是掳掠，从没有像美国电影《ET》所表现的那样，有过相互的理解与沟通。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	影片中，当外星人魂灵移到猴子身上时，耿浩还是运用了过去驯猴的残存的对猴子的影响，用一根香蕉控制了外星人，实际上，这也是电影里唯一具有的温情的生命可以沟通的段落，也由此看出，这部电影里恰恰回避了生命之间可能搭起来的共同生存的信念。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	这样的信念，在刘慈欣的小说里同样不存在。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/7495213336/1000\" class=\"CONTENT-picture\" />\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	第三点，就是电影里接纳了刘慈欣的终极解脱方式，就是无为而治。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	《三体》中，面对外星人的入侵，章北海采取的是一种逃跑主义，回避敌人的攻击，驾驶战舰逃之夭夭，反而成为大英雄；地球人采取的“面壁者”计划中，其他三人，都是运用武力的办法，迎战强敌，唯有中国的罗辑，无为而治，听之任之，得过且过，沉缅在俗世的现实生活中，这典型的反映了中国文化中的一种世俗的只顾眼前、不顾来世的文化态度。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	在《疯狂的外星人》里，我们看到耿浩尚有一点理想，想传承家业，发扬光大国粹，而与之对应的阿飞，则典型的是中国俗世文化的集萃：钱在他眼里是最有魅力的东西，做买卖不择手段，面对强者身份立刻能够从爹转换成儿子，而整个电影里张扬的正是，不管你美国人在那里忧天忧天、忙个不停，咱中国人还是做自己的生意，过自己的生活，美国人在刚果那里还在擒贼呢，咱们中国人已经把生意做到宇宙上去了。世俗生活对于中国人来说，永远是美丽的，无为而治，对于中国人永远是一个战无不胜的法宝。这种思想，成为刘慈欣小说里解决宇宙难以解决问题时的最后一道堤岸。而《疯狂的外星人》里的最后解决方案，实在是得了刘慈欣这一理论的真传。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/7616456520/1000\" class=\"CONTENT-picture\" />\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	《疯狂的外星人》算不上一个好电影，它像《捉妖记》一样，发明了一个萌宠小怪物，然后制造一点笑料，顺便把美国人拉进来，对他们如狼似虎的使命担当进行了一次不遗余力的开涮，但值得我们注意的是，倒是影片内质里的刘慈欣精髓，或许这不仅仅是刘慈欣的一个人的内心感悟，而很可能是中国文化深层心理烙印在中国人心理上的共同诉求，这才使得不管电影情节如何改动，都难以蜕去中国印。\n</p>',
        1, 0, 0, '2019-02-12 16:48:50', '2019-02-12 02:53:47');
insert into `NEWS`(`NEWS_ID`, `TITLE`, `CATEGORY_ID`, `COVER_IMAGE`, `CONTENT`, `STATUS`, `VIEWS`, `IS_DELETED`,
                   `CREATE_TIME`, `UPDATE_TIME`)
values (6, '《流浪地球》的改编：理性属于科幻文学，感性属于科幻电影？', 11, 'http://localhost:8080/files/20190212_16543993.jpg',
        '<p class=\"one-p\" style=\"font-family:\" font-size:18px;\"=\"\">xxx\n	</p>', 1, 0, 0,
        '2019-02-12 16:50:21', '2019-02-12 07:20:27');


CREATE TABLE IF NOT EXISTS `CATEGORY`
(
    `CATEGORY_ID` bigint
(
    20
) NOT NULL AUTO_INCREMENT COMMENT '类别主键id',
    `CATEGORY_NAME` varchar
(
    200
) NOT NULL DEFAULT '' COMMENT '类别名称',
    `IS_DELETED` tinyint
(
    4
) NOT NULL DEFAULT '0' COMMENT '是否已删除 0-未删除 1-已删除',
    `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY
(
    `CATEGORY_ID`
)
    ) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `CATEGORY` */

insert into `CATEGORY`(`CATEGORY_ID`, `CATEGORY_NAME`, `IS_DELETED`, `CREATE_TIME`)
values (1, '体育', 0, '2019-02-02 21:51:24');
insert into `CATEGORY`(`CATEGORY_ID`, `CATEGORY_NAME`, `IS_DELETED`, `CREATE_TIME`)
values (2, '图片', 0, '2019-02-02 21:53:22');
insert into `CATEGORY`(`CATEGORY_ID`, `CATEGORY_NAME`, `IS_DELETED`, `CREATE_TIME`)
values (3, '132', 1, '2019-02-02 22:00:37');
insert into `CATEGORY`(`CATEGORY_ID`, `CATEGORY_NAME`, `IS_DELETED`, `CREATE_TIME`)
values (4, 'afdspppp', 1, '2019-02-02 22:01:01');
insert into `CATEGORY`(`CATEGORY_ID`, `CATEGORY_NAME`, `IS_DELETED`, `CREATE_TIME`)
values (5, 'dfadsf', 1, '2019-02-02 22:01:14');
insert into `CATEGORY`(`CATEGORY_ID`, `CATEGORY_NAME`, `IS_DELETED`, `CREATE_TIME`)
values (6, 'o8', 1, '2019-02-02 22:01:30');
insert into `CATEGORY`(`CATEGORY_ID`, `CATEGORY_NAME`, `IS_DELETED`, `CREATE_TIME`)
values (7, '视频', 0, '2019-02-12 01:00:13');
insert into `CATEGORY`(`CATEGORY_ID`, `CATEGORY_NAME`, `IS_DELETED`, `CREATE_TIME`)
values (8, '军事', 0, '2019-02-12 01:22:41');
insert into `CATEGORY`(`CATEGORY_ID`, `CATEGORY_NAME`, `IS_DELETED`, `CREATE_TIME`)
values (9, 'IT资讯', 0, '2019-02-12 01:28:15');
insert into `CATEGORY`(`CATEGORY_ID`, `CATEGORY_NAME`, `IS_DELETED`, `CREATE_TIME`)
values (10, '教育', 0, '2019-02-12 01:28:29');
insert into `CATEGORY`(`CATEGORY_ID`, `CATEGORY_NAME`, `IS_DELETED`, `CREATE_TIME`)
values (11, '文化', 0, '2019-02-12 01:28:38');

CREATE TABLE IF NOT EXISTS `COMMENT`
(
    `COMMENT_ID` bigint
(
    20
) NOT NULL AUTO_INCREMENT COMMENT '评论主键id',
    `NEWS_ID` bigint
(
    20
) NOT NULL DEFAULT '0' COMMENT '关联咨询主键id',
    `USER_ID` varchar
(
    200
) NOT NULL DEFAULT '' COMMENT '评论人',
    `CONTENT` varchar
(
    300
) NOT NULL DEFAULT '' COMMENT '评论内容',
    `STATUS` tinyint
(
    4
) NOT NULL DEFAULT '0' COMMENT '评论状态 0-未审核 1-审核通过',
    `IS_DELETED` tinyint
(
    4
) NOT NULL DEFAULT '0' COMMENT '是否已删除 0-未删除 1-已删除',
    `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY
(
    `COMMENT_ID`
)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `COMMENT` */

insert into `COMMENT`(`COMMENT_ID`, `NEWS_ID`, `USER_ID`, `CONTENT`, `STATUS`, `IS_DELETED`, `CREATE_TIME`)
values (1, 1, '13', 'fads', 1, 0, '2019-02-02 22:29:33');
insert into `COMMENT`(`COMMENT_ID`, `NEWS_ID`, `USER_ID`, `CONTENT`, `STATUS`, `IS_DELETED`, `CREATE_TIME`)
values (2, 2, 'sdfds', '评论测试', 0, 0, '2019-02-02 22:34:30');
insert into `COMMENT`(`COMMENT_ID`, `NEWS_ID`, `USER_ID`, `CONTENT`, `STATUS`, `IS_DELETED`, `CREATE_TIME`)
values (3, 1, 'fads', '留言测试', 0, 0, '2019-02-03 14:35:42');
