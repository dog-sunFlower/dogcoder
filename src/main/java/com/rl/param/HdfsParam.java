package com.rl.param;

/**
 * Created by linghongbo on 2015/9/7.
 */
public class HdfsParam {

    /**
     * hdfs路径
     */
    private String storePath;

    /**
     * 是否压缩 true:压缩  false:不压缩
     */
    private boolean compress;

    /**
     * 压缩情况下，采用hdfs何种压缩方式
     */
    private String compressCodec;

    public String getStorePath() {
        return storePath;
    }

    public void setStorePath(String storePath) {
        this.storePath = storePath;
    }

    public boolean isCompress() {
        return compress;
    }

    public void setCompress(boolean compress) {
        this.compress = compress;
    }

    public String getCompressCodec() {
        return compressCodec;
    }

    public void setCompressCodec(String compressCodec) {
        this.compressCodec = compressCodec;
    }
}
