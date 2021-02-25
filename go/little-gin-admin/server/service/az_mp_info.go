package service

import (
	"little-gin-admin/global"
	"little-gin-admin/model"
)

func CreateMpInfo(mi model.MpInfo) (err error) {
	err = global.DB.Create(&mi).Error
	return err
}
