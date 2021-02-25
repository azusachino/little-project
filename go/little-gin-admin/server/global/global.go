package global

import (
	"github.com/go-redis/redis"
	"github.com/jinzhu/gorm"
	o "github.com/op/go-logging"
	"github.com/spf13/viper"
	"little-gin-admin/config"
)

var (
	DB           *gorm.DB
	RedisClient  *redis.Client
	ServerConfig config.Server
	Viper        *viper.Viper
	Logger       *o.Logger
)
