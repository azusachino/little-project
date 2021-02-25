package router

import (
	"github.com/gin-gonic/gin"
	"little-gin-admin/api/v1"
	"little-gin-admin/middleware"
)

func InitSystemRouter(Router *gin.RouterGroup) {
	UserRouter := Router.Group("system").Use(middleware.JWTAuth()).Use(middleware.CasbinHandler())
	{
		UserRouter.POST("getSystemConfig", v1.GetSystemConfig) // 获取配置文件内容
		UserRouter.POST("setSystemConfig", v1.SetSystemConfig) // 设置配置文件内容
	}
}
