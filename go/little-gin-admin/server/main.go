package main

import (
	"little-gin-admin/core"
	"little-gin-admin/global"
	"little-gin-admin/initialize"
)

func main() {
	switch global.ServerConfig.System.DbType {
	case "mysql":
		initialize.Mysql()
	// case "sqlite":
	//	initialize.Sqlite()  // sqlite需要gcc支持 windows用户需要自行安装gcc 如需使用打开注释即可
	default:
		initialize.Mysql()
	}
	initialize.DBTables()
	// 程序结束前关闭数据库链接
	defer global.DB.Close()

	core.RunWindowsServer()
}
