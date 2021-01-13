package cn.az.project.rpc.compress;

import cn.az.project.rpc.extension.SPI;

/**
 * @author az
 * @since 12/09/20 22:49
 */
@SPI
public interface Compress {

    byte[] compress(byte[] bytes);


    byte[] decompress(byte[] bytes);
}
