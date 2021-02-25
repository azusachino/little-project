package utils

import (
	"bytes"
	"crypto/cipher"
	"crypto/des"
)

func padding(src []byte, blockSize int) []byte {
	n := len(src)
	padNum := blockSize - n%blockSize
	pad := bytes.Repeat([]byte{byte(padNum)}, padNum)
	dst := append(src, pad...)
	return dst
}

func unPadding(src []byte) []byte {
	n := len(src)
	unPadNum := int(src[n-1])
	dst := src[:n-unPadNum]
	return dst
}

func EncryptDES(src []byte) []byte {
	key := []byte("az")
	block, _ := des.NewCipher(key)
	src = padding(src, block.BlockSize())
	blockMode := cipher.NewCBCEncrypter(block, key)
	blockMode.CryptBlocks(src, src)
	return src
}

func DecryptDES(src []byte) []byte {
	key := []byte("az")
	block, _ := des.NewCipher(key)
	blockMode := cipher.NewCBCDecrypter(block, key)
	blockMode.CryptBlocks(src, src)
	src = unPadding(src)
	return src
}
