package v1

import (
	"fmt"
	"github.com/gin-gonic/gin"
	"little-gin-admin/global/response"
	"little-gin-admin/model"
	"little-gin-admin/model/request"
	"little-gin-admin/service"
	"little-gin-admin/utils"
	"time"
)

func CreateMpInfo(c *gin.Context) {
	// 定义dto
	var mi model.MpInfo
	// 接收JSON参数
	_ = c.ShouldBindJSON(&mi)
	// 追加参数校验规则
	MpInfoVerify := utils.Rules{
		"title":   {utils.NotEmpty()},
		"content": {utils.NotEmpty()},
	}
	// 进行参数校验
	MpInfoVerifyErr := utils.Verify(mi, MpInfoVerify)
	// 返回错误信息
	if MpInfoVerifyErr != nil {
		response.FailWithMessage(MpInfoVerifyErr.Error(), c)
		return
	}
	// 进行权限校验
	claims, _ := c.Get("claims")
	// 转型
	waitUse := claims.(*request.CustomClaims)
	mi.CreateUser = waitUse.Id
	mi.CreateTime = time.Now()
	err := service.CreateMpInfo(mi)
	if err != nil {
		response.FailWithMessage(fmt.Sprintf("创建失败：%v", err), c)
	} else {
		response.OkWithMessage("创建成功", c)
	}
}
