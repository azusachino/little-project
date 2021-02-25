package core

import (
	"fmt"
	"little-gin-admin/global"
	"little-gin-admin/initialize"
	"time"
)

type server interface {
	ListenAndServe() error
}

func RunWindowsServer() {
	if global.ServerConfig.System.UseMultipoint {
		// 初始化redis服务
		initialize.Redis()
	}
	Router := initialize.Routers()
	Router.Static("/static", "./resource/page")

	//InstallPlugs(Router)
	// end 插件描述

	address := fmt.Sprintf(":%d", global.ServerConfig.System.Addr)
	s := initServer(address, Router)
	// 保证文本顺序输出
	// In order to ensure that the text order output can be deleted
	time.Sleep(10 * time.Microsecond)
	global.Logger.Debug("server run success on ", address)

	fmt.Printf(`欢迎使用 Little-Gin-Admin
	默认自动化文档地址:http://127.0.0.1%s/swagger/index.html
	默认前端文件运行地址:http://127.0.0.1:8080
`, address)
	global.Logger.Error(s.ListenAndServe())
}
