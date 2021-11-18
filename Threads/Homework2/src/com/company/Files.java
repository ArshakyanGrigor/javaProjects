package com.company;

import java.io.*;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class Files extends Thread {
    private final CountDownLatch countDownLatch;

    public Files(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        File file = null;
        FileOutputStream fileOutStream = null;
        while (countDownLatch.getCount() != 0) {
            try {
                file = new File(UUID.randomUUID().toString());
                fileOutStream = new FileOutputStream(file);
                if (!file.exists()) {
                    file.createNewFile();
                }
                for (int i = 0; i < 10000000; i++) {
                    String data = UUID.randomUUID() + "\n";
                    byte[] b = data.getBytes();
                    fileOutStream.write(b);
                }
                countDownLatch.countDown();
                fileOutStream.flush();
                fileOutStream.close();
                System.out.println("File writing done.");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileOutStream != null) {
                        fileOutStream.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}