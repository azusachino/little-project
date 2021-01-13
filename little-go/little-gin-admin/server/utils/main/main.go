package main

import (
	"little-gin-admin/utils"
	"sync"
)

type Test struct {
	mu   sync.Mutex
	m    map[string]interface{}
	name string
}

func NewTest() *Test {
	return &Test{
		mu: sync.Mutex{},
		m:  make(map[string]interface{}),
	}
}

func main() {
	// print(utils.EncryptDES([]byte("hello")))
	//res, err := utils.PathExists("D://Projects")
	//print(res, err)

	println(utils.MD5V([]byte("hello"))) // 5d41402abc4b2a76b9719d911017c592
	println(utils.StructToMap(NewTest()))
}
