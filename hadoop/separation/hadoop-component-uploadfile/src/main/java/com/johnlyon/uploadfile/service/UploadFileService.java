package com.johnlyon.uploadfile.service;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import com.johnlyon.uploadfile.utils.Connect;

import java.io.IOException;

public class UploadFileService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static void UploadFile(String user, Path from, Path to) throws IOException, InterruptedException {
        FileSystem fs = Connect.connectCluster(user);
        if (!fs.exists(to)) {
            fs.mkdirs(to);
        };
        long startTime = System.currentTimeMillis();
        fs.copyFromLocalFile(from, to);
        fs.close();
        long endTime = System.currentTimeMillis();
        long imeElapsed = endTime - startTime;
        System.out.println(ANSI_GREEN + "success: spend " + imeElapsed + " /millis" + " The File in: " + to + "/" + from.getName() + ANSI_RESET);
    }
}
