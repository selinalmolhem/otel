/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DocumentDao;
import Entity.Document;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Bayoon
 */
@Named
@SessionScoped
public class DocumentController implements Serializable{
    private Document document;
    private List<Document> documentlist;
    private DocumentDao documentdao;
    
    private Part doc;
    private final String uploadto="/Users/Bayoon/upload/"; //C:\\Users\Bayoon\\upload 
    public void upload(){
        try {
            InputStream input = doc.getInputStream();
            File f = new File(this.uploadto +doc.getSubmittedFileName());
            Files.copy(input, f.toPath());

           document=this.getDocument();
           document.setFilepath(f.getParent());
           document.setFilename(f.getName());
           document.setFiletype(doc.getContentType());
           
           this.getDocumentdao().insert(document);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public String getUploadto() {
        return uploadto;
    }

    public Document getDocument() {
        if(this.document==null)
            this.document=new Document();
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Document> getDocumentlist() {
        this.documentlist=this.getDocumentdao().findAll();
        return documentlist;
    }

    public void setDocumentlist(List<Document> documentlist) {
        this.documentlist = documentlist;
    }

    public DocumentDao getDocumentdao() {
        if(this.documentdao==null)
            this.documentdao=new DocumentDao();
        return documentdao;
    }

    public void setDocumentdao(DocumentDao documentdao) {
        this.documentdao = documentdao;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }
    
}
