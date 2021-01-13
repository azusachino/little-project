package response

import "little-gin-admin/model"

type ExaFileResponse struct {
	File model.ExaFileUploadAndDownload `json:"file"`
}
