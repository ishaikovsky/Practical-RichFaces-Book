package org.richfaces.book.examples;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class FileSystemBean {
    private static final String SRC_PATH = "/WEB-INF";

    private List<FileSystemNode> webInfRoots;

    public synchronized List<FileSystemNode> getWebInfRoots() {
        if (webInfRoots == null) {
            webInfRoots = new FileSystemNode(SRC_PATH).getDirectories();
        }

        return webInfRoots;
    }
}