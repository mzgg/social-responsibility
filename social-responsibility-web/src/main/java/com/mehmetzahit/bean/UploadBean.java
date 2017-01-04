package com.mehmetzahit.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GUNEY on 26.11.2016.
 */
@ManagedBean
@RequestScoped
public class UploadBean {
    public final static int SIZE_LIMIT = 100000;
    private Part filePart;
    private File uploadDirectory = new File("C:\\Users\\GUNEY\\Desktop\\upload");

    public Part getFilePart() {
        return filePart;
    }
    public void setFilePart(Part filePart) {
        this.filePart = filePart;
    }

    public void upload() {
        File file = new File(uploadDirectory, filePart.getSubmittedFileName());
        try {
        //    storeInputStream(filePart.getInputStream(),file);

            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Dosya yükleme başarılı"));


        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Dosya yükleme hatalı",e.getMessage()));

        }

    }

    public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
        List<FacesMessage> messages = new ArrayList<FacesMessage>();
        Part part = (Part) value;

        if (part.getSize() > SIZE_LIMIT) {
            messages.add(new FacesMessage("Dosya boyutu çok büyük"));
        }

        if (!"image/jpeg".equals(part.getContentType()) && !"image/png".equals(part.getContentType())) {
            messages.add(new FacesMessage("Resim istenilen uzantıda değil"));
        }

        if (!messages.isEmpty()) {
            throw new ValidatorException(messages);
        }
    }

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
