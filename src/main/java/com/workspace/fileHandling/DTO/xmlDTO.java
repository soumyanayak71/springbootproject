package com.workspace.fileHandling.DTO;

import java.io.Serializable;

public class xmlDTO implements Serializable {

    private static final long serialVersionUID = 7275010202217132042L;
    private String fileValue;
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileValue(){

        return fileValue;
    }

    public void setFileValue(String fileValue){

        this.fileValue=fileValue;
    }
}
