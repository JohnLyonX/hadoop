package com.johnlyon.uploadfile;

import org.apache.hadoop.fs.Path;
import com.johnlyon.uploadfile.service.UploadFileService;

import java.io.IOException;

public class UploadFileMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        UploadFileService.UploadFile(args[0], new Path(args[1]), new Path(args[2]));
    }
}
