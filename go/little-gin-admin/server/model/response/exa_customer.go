package response

import "little-gin-admin/model"

type ExaCustomerResponse struct {
	Customer model.ExaCustomer `json:"customer"`
}
