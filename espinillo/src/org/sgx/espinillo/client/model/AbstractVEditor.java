package org.sgx.espinillo.client.model;

import java.util.LinkedList;
import java.util.List;

import org.sgx.espinillo.client.model.tool.Toolbar;

public abstract class AbstractVEditor implements VEditor {

	Toolbar toolbar;
	List<Document> documents;
	Document currentDocument;
	
	public AbstractVEditor() {
		documents=new LinkedList<Document>();
	}
	
	@Override
	public Toolbar getToolbar() {
		return toolbar;
	}

	@Override
	public List<Document> getDocuments() {
		return documents;
	}

	public void setToolbar(Toolbar toolbar) {
		this.toolbar = toolbar;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document getCurrentDocument() {
		return currentDocument;
	}

	public void setCurrentDocument(Document currentDocument) {
		this.currentDocument = currentDocument;
	}

//	public abstract void init();
}
