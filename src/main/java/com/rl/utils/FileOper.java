//package com.rl.utils;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.fs.*;
//import org.apache.hadoop.io.compress.CompressionCodec;
//import org.apache.hadoop.io.compress.CompressionCodecFactory;
//import org.apache.hadoop.io.compress.CompressionInputStream;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by linghongbo on 2015/9/7.
// * 文件操作类，用于提供对hdfs或本地文件删除
// * 重写、创建
// */
//public class FileOper {
//
//    private FileSystem fs;
//    private static final Logger _LOG = LoggerFactory.getLogger(FileOper.class);
//
//    public static final String UNDER_LINE = "_";
//
//    public FileOper() throws IOException {
//        Configuration conf = new Configuration();
//        this.fs = FileSystem.get(conf);
//    }
//
//    public FileOper(Boolean local) throws IOException {
//        Configuration conf = new Configuration();
//        if (local) {
//            this.fs = FileSystem.getLocal(conf);
//        } else {
//            this.fs = FileSystem.get(conf);
//        }
//    }
//
//    public boolean coverDir(HdfsParam param) throws IOException {
//        boolean suc = false;
//        if (param != null) {
//            suc = coverDir(param.getStorePath());
//        }
//        return suc;
//    }
//
//    public boolean coverDir(String path) throws IOException {
//        if (StringUtils.isBlank(path)) {
//            _LOG.info("");
//            return false;
//        }
//
//        boolean suc = false;
//        if (StringUtils.isNoneBlank(path)) {
//            Path dir = new Path(path);
//            if (fs.isDirectory(dir) && fs.exists(dir)) {
//                // 如果为目录且在hdfs上存在，则覆盖
//                fs.delete(dir, true);
//            } else if (fs.isFile(dir)) {
//                throw new RuntimeException("hdfs path:" + path + " not is directory!");
//            }
//            suc = fs.mkdirs(dir);
//        }
//        return suc;
//    }
//
//    public InputStream getCodecInputStream(HdfsParam param) throws IOException {
//        if (param == null) {
//            _LOG.warn("get InputStream failed, HdfsParam object is null!");
//            return  null;
//        }
//
//        String storeHdfs = param.getStorePath();
//        FSDataInputStream inputStream = null;
//        if (StringUtils.isNoneBlank(storeHdfs)) {
//            Path storePath = new Path(storeHdfs);
//            CompressionCodecFactory factory = new CompressionCodecFactory(fs.getConf());
//            CompressionCodec codec = factory.getCodec(storePath);
//            inputStream = fs.open(storePath);
//            if (codec != null) {
//                _LOG.info("get Codec is:" + codec.getClass().getName());
//                CompressionInputStream comInputStream = codec.createInputStream(inputStream);
//                return comInputStream;
//            }
//        }
//        return inputStream;
//    }
//
//
//    public FileSystem getFs() {
//        return fs;
//    }
//
//    public List<Path> getFileLists(String spath, PathFilter filter) throws IOException {
//        List<Path> paths = new ArrayList<Path>();
//        Path path = new Path(spath);
//        FileStatus[] statuses = null;
//        if (filter != null) {
//            statuses = fs.globStatus(path, filter);
//        } else {
//            statuses = fs.globStatus(path);
//        }
//
//        if (statuses != null) {
//            for (FileStatus status : statuses) {
//                paths.add(status.getPath());
//            }
//        }
//        fs.close();
//        return paths;
//    }
//
//    public List<Path> getFileLists(String spath) throws IOException {
//        return getFileLists(spath, null);
//    }
//
//}
