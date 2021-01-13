package request

import "little-gin-admin/model"

type SysDictionarySearch struct {
	model.SysDictionary
	PageInfo
}
