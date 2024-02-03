package com.johnlyon.uploadfile.utils;


import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.IOException;
import java.security.PrivilegedExceptionAction;

public class Connect {
    public static FileSystem connectCluster(String user) throws IOException, InterruptedException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://192.168.0.231:9000");
        UserGroupInformation userGroupInformation = UserGroupInformation.createRemoteUser(user);
        return userGroupInformation.doAs((PrivilegedExceptionAction<FileSystem>) () -> FileSystem.get(configuration));
    }

    public static LocalFileSystem connectLocal() throws IOException {
        Configuration configuration = new Configuration();
        return LocalFileSystem.newInstanceLocal(configuration);
    }
}
