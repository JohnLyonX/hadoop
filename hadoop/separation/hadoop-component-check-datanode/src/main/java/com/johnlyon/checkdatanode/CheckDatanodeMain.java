package com.johnlyon.checkdatanode;

import com.johnlyon.checkdatanode.service.CheckDatanodeService;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class CheckDatanodeMain {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask checkDatanodeInfo = new TimerTask() {
            @Override
            public void run() {
                try {
                    CheckDatanodeService.getDatanodeInfo();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        timer.schedule(checkDatanodeInfo, 0,100000);
    }
}
