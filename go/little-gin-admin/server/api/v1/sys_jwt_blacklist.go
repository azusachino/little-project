package v1

import (
	"fmt"
	"github.com/gin-gonic/gin"
	"little-gin-admin/global/response"
	"little-gin-admin/model"
	"little-gin-admin/service"
)

// @Tags jwt
// @Summary jwt加入黑名单
// @Security ApiKeyAuth
// @accept application/json
// @Produce application/json
// @Success 200 {string} string "{"success":true,"data":{},"msg":"拉黑成功"}"
// @Router /jwt/jsonInBlacklist [post]
func JsonInBlacklist(c *gin.Context) {
	token := c.Request.Header.Get("x-token")
	modelJwt := model.JwtBlacklist{
		Jwt: token,
	}
	err := service.JsonInBlacklist(modelJwt)
	if err != nil {
		response.FailWithMessage(fmt.Sprintf("jwt作废失败，%v", err), c)
	} else {
		response.OkWithMessage("jwt作废成功", c)
	}
}
