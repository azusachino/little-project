package initialize

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
	"little-gin-admin/global"
	"os"
)

// 初始化数据库并产生数据库全局变量
func Mysql() {
	admin := global.ServerConfig.Mysql
	if db, err := gorm.Open("mysql", admin.Username+":"+admin.Password+"@("+admin.Path+")/"+admin.Dbname+"?"+admin.Config); err != nil {
		global.Logger.Error("MySQL启动异常", err)
		os.Exit(0)
	} else {
		global.DB = db
		global.DB.DB().SetMaxIdleConns(admin.MaxIdleConns)
		global.DB.DB().SetMaxOpenConns(admin.MaxOpenConns)
		global.DB.LogMode(admin.LogMode)
	}
}
