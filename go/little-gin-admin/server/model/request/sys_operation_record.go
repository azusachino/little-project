package request

import "little-gin-admin/model"

type SysOperationRecordSearch struct {
	model.SysOperationRecord
	PageInfo
}
