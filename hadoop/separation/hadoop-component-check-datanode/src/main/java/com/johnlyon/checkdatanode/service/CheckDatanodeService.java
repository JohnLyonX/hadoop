package com.johnlyon.checkdatanode.service;

import com.johnlyon.checkdatanode.utils.Connect;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;

import java.io.IOException;

public class CheckDatanodeService {
    public static void getDatanodeInfo() throws IOException, InterruptedException {
        FileSystem setUpConnect = Connect.connectCluster();
        DistributedFileSystem distributedFileSystem = (DistributedFileSystem) setUpConnect;
        DatanodeInfo[] datanodeInfos = distributedFileSystem.getDataNodeStats();
        for (DatanodeInfo datanodeInfo : datanodeInfos) {
            System.out.println(datanodeInfo.getDatanodeReport());
        }

    }
}
