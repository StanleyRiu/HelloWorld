package com.cht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyProcess2 {
    Runtime runtime = null;
    Process process = null;
    InputStream is = null;
    InputStreamReader isr = null;
    BufferedReader br = null;
    StringBuilder sb = new StringBuilder();

    void test() {
        runtime = Runtime.getRuntime();
        try {
            process = runtime.exec(new String[]{"cmd.exe", "/c", "tree", "d:\\c23"});
            is = process.getInputStream();
            isr = new InputStreamReader(is, "BIG5");
            br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sb.toString());
    }
}
