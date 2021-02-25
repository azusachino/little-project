package initialize

import (
	"github.com/go-redis/redis"
	"little-gin-admin/global"
)

func Redis() {
	redisCfg := global.ServerConfig.Redis
	client := redis.NewClient(&redis.Options{
		Addr:     redisCfg.Addr,
		Password: redisCfg.Password, // no password set
		DB:       redisCfg.DB,       // use default DB
	})
	pong, err := client.Ping().Result()
	if err != nil {
		global.Logger.Error(err)
	} else {
		global.Logger.Info("redis connect ping response:", pong)
		global.RedisClient = client
	}
}
