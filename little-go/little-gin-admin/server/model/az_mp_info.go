package model

import (
	"github.com/jinzhu/gorm"
	"time"
)

type MpInfo struct {
	gorm.Model
	Title      string    `json:"title" form:"title" gorm:"comment:'文章标题'"`
	Content    string    `json:"content" form:"content" gorm:"comment:'文章内容'"`
	CreateUser string    `json:"createUser" form:"createUser" gorm:"comment:'创建人'"`
	CreateTime time.Time `json:"createTime" form:"createTime" gorm:"comment:'创建时间'"`
}
