package org.richfaces.book.examples;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;
@ManagedBean
@SessionScoped
public class FileUploadBean {
	private ArrayList<UploadedFile> files = new ArrayList<UploadedFile>();

	public void paint(OutputStream stream, Object object) throws IOException {
		stream.write(getFiles().get((Integer) object).getData());
	}

	public void listener(FileUploadEvent event) throws Exception {
		UploadedFile item = event.getUploadedFile();
		files.add(item);
	}

	public Date getTimeStamp(){
		return new Date();
	}
	
	// Getters and setters

	public ArrayList<UploadedFile> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<UploadedFile> files) {
		this.files = files;
	}

}
