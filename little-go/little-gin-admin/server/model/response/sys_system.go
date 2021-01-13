package response

import "little-gin-admin/config"

type SysConfigResponse struct {
	Config config.Server `json:"config"`
}
