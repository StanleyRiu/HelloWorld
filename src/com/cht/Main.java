package com.cht;

public class Main {

    public static void main(String[] args) {
        //new MyTimer().test();
        //new MyThread().start();
        new MyRunnable().run();
        //new MyProcess().test();
        //new MyProcess2().test();
        //new MyZip().zipFile("D:\\C23\\OSS開源軟體檢測\\0723_高雄航空站人事差勤管理系統\\[OSS][01]高雄航空站人事差勤管理系統\\KIAWeb", "kia.zip");
        //new MyItextPdf().test();
        //new MyPdfBox().insertImage();
    }
    void run() {
        new MyThread().start();
        new MyRunnable().run();
    }
}
