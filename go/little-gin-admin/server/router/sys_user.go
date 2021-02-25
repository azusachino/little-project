package router

import (
	"github.com/gin-gonic/gin"
	"little-gin-admin/api/v1"
	"little-gin-admin/middleware"
)

func InitUserRouter(Router *gin.RouterGroup) {
	UserRouter := Router.Group("user").
		Use(middleware.JWTAuth()).        // JWT 角色校验
		Use(middleware.CasbinHandler()).  // 权限 => 相当于interceptor
		Use(middleware.OperationRecord()) // 访问记录入表
	{
		UserRouter.POST("changePassword", v1.ChangePassword)     // 修改密码
		UserRouter.POST("uploadHeaderImg", v1.UploadHeaderImg)   // 上传头像
		UserRouter.POST("getUserList", v1.GetUserList)           // 分页获取用户列表
		UserRouter.POST("setUserAuthority", v1.SetUserAuthority) // 设置用户权限
		UserRouter.DELETE("deleteUser", v1.DeleteUser)           // 删除用户
	}
}
