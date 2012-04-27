package org.sgx.espinillo.client.model;

import java.util.List;

import org.sgx.espinillo.client.model.tool.Toolbar;

/**
 * i represent the entire visual editor platform. some of my responsbilities are
 * 
 * 1) keep a list of documents 
 * 2) keep properties values currently selected by the user, 
 * most significant: the shape attributes selected by the user which will 
 * be used to paint figures in the editor. 
 * 3) keep the toolbar to be used
 * 
 * @author sg
 *
 */
public interface VEditor {
Toolbar getToolbar();

//drawings
List<Document>getDocuments();
Document getCurrentDocument();
void setCurrentDocument(Document currentDocument);
void newDocument(int x, int y);
void closeDocument(Document d);
//void loadDocument();//TODO
///**
// * initializes the editor, opening a new empty or template.document ready to work with. 
// */
//public void init();
}
