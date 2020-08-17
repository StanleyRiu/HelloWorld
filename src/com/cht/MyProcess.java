package com.cht;

import javax.print.DocFlavor;
import java.io.*;

public class MyProcess {
    ProcessBuilder processbuilder = new ProcessBuilder();
    Process process = null;
    InputStream is = null;
    InputStreamReader isr = null;
    BufferedReader br = null;
    StringBuilder sb = new StringBuilder();

    void test() {
        processbuilder.command("cmd.exe", "/c", "tree", "d:\\c23");
        try {
            process = processbuilder.start();
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
