package com.workspace.fileHandling;

import org.apache.commons.io.FileUtils;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.*;

public class Zipper {
    public File zip(final String fileVal,final String fileName) {
        if ((fileVal == null) || (fileVal.length() == 0)) {
            throw new IllegalArgumentException("Cannot zip null or empty string");
        }
        if ((fileName == null) || (fileName.length() == 0)) {
            throw new IllegalArgumentException("Valid filename necessary");
        }
        File zipFile= new File("C:\\fileDownloadExample\\"+fileName+".zip");
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile))){
            ZipEntry zipEntry = new ZipEntry(fileName+".txt");
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.write(fileVal.getBytes(StandardCharsets.UTF_8));
            zipOutputStream.closeEntry();
        } catch(IOException e) {
            throw new RuntimeException("Failed to zip content", e);
        }
        return zipFile;
    }
}
