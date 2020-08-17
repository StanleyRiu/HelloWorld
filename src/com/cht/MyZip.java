package com.cht;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MyZip {
    void zipFile(String srcDir, String zipfile) {
        File srcFile = new File(srcDir);
        if (! srcFile.exists() || ! srcFile.isDirectory()) {
            System.err.println("file doesn't exist or is not directory");
            return;
        }
        String dstDir = srcFile.getParent();
        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(dstDir, zipfile)));

            for (File f : srcFile.listFiles()) {
                checkFileType(f, zos, f.getName());
            }
            zos.finish();
            zos.flush();
            zos.close();
            System.out.println("done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkFileType(File f, ZipOutputStream zos, String name) {
        if (f.isDirectory()) {
            //System.out.println("processing..."+name);
            for (File file : f.listFiles()) {
                checkFileType(file, zos, name+File.separator+file.getName());
            }
        } else {
            addZipFile(f, zos, name);
        }
    }

    private void addZipFile(File f, ZipOutputStream zos, String name) {
        byte[] b = new byte[(int) f.length()];
        int l;
        try {
            FileInputStream fis = new FileInputStream(f);
            //System.out.println("processing..."+name+", file length: "+f.length());
            ZipEntry ze = new ZipEntry(name);
            zos.putNextEntry(ze);
            while ((l=fis.read(b)) != -1 && f.length()!=0) {
                if (f.length()==0) System.out.println("b= "+b.toString()+", length==0, read byte= "+l);
                zos.write(b, 0, l);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
