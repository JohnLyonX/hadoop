package com.johnlyon.checkdatanode.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.IOException;
import java.security.PrivilegedExceptionAction;

public class Connect {
    public static FileSystem connectCluster() throws IOException, InterruptedException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://192.168.0.231:9000");
        UserGroupInformation userGroupInformation = UserGroupInformation.createRemoteUser("hadoop");
        return userGroupInformation.doAs(new PrivilegedExceptionAction<FileSystem>() {
            @Override
            public FileSystem run() throws Exception {
                return FileSystem.get(configuration);
            }
        });
    }

    public static LocalFileSystem connectLocal() throws IOException {
        Configuration configuration = new Configuration();
        return LocalFileSystem.newInstanceLocal(configuration);
    }
}
