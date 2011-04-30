package org.richfaces.book.examples;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class FileSystemBean {
	private List<FileSystemNode> rootDirs;
	private List<String> rootFiles;
	private FileSystemNode rootNode = new FileSystemNode("/");

	public List<FileSystemNode> getRootDirs() {
		if (rootDirs == null) {
			rootDirs = rootNode.getDirectories();
		}
		return rootDirs;
	}

	public List<String> getRootFiles() {
		if (rootFiles == null) {
			rootFiles = rootNode.getFiles();
		}
		return rootFiles;
	}
}