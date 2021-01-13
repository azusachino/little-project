package service

import (
	"little-gin-admin/global"
	"little-gin-admin/model"
)

// @title    Create
// @description   create a workflow, 创建工作流
// @auth                     （2020/04/05  20:22）
// @param     wk              model.SysWorkflow
// @return                    error

func Create(wk model.SysWorkflow) error {
	err := global.DB.Create(&wk).Error
	return err
}
