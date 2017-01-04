package com.mehmetzahit.bean;

/**
 * Created by GUNEY on 26.11.2016.
 */

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@ManagedBean(name = "FileUpload")
@SessionScoped
public class FileUploadView {

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

//    public void handleFileUpload(FileUploadEvent event) {
//        String test = "mzg";
//        String path="C:\\Users\\GUNEY\\Desktop\\upload\\" + test;
//        File filem = new File(path);
//        if(!filem.exists())  filem.mkdir();
//
//        File uploadDirectory = new File(path);
//
//        UploadedFile files = event.getFile();
//        File file = new File(uploadDirectory, event.getFile().getFileName());
//
//        try {
//            System.out.println(event.getFile().getFileName());
//            storeInputStream(files.getInputstream(), file);
//            fileName=event.getFile().getFileName();
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dosya yükleme başarılı"));
//
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dosya yükleme hatalı", e.getMessage()));
//
//        }
//    }
//
//
//    private static void storeInputStream(InputStream in, File file) throws IOException {
//
//        FileOutputStream out = new FileOutputStream(file);
//        byte[] buffer = new byte[4096];
//        int bytesRead = 0;
//        while (true) {
//            bytesRead = in.read(buffer);
//            if (bytesRead > 0) {
//                out.write(buffer, 0, bytesRead);
//
//            } else {
//                break;
//            }
//        }
//
//        out.close();
//        in.close();
//    }
}

