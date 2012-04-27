package org.sgx.espinillo.client.model.tool;

import java.util.LinkedList;
import java.util.List;

import org.sgx.espinillo.client.impl1.util.ToolUtil;
import org.sgx.espinillo.client.model.Document;

public abstract class AbstractTool implements Tool {

	private Document document;
	private List<ToolListener> listeners;
	private String name;
	public AbstractTool(Document document, String name) {
		this.document=document;
		this.name=name;
		listeners=new LinkedList<ToolListener>();
	}
	public void addToolListener(ToolListener l) {
		listeners.add(l);
	}
	public void removeToolListener(ToolListener l) {
		listeners.remove(l);
	}
	protected void notifyAllFinnish(ToolEvent te) {
		for(ToolListener l : listeners) {
			l.onFinnish(te);
		}
	}
	protected void notifyAllStart(ToolEvent te) {
		for(ToolListener l : listeners) {
			l.onStart(te);
		}
	}
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void install() {
		Tool ct = getDocument().getVEditor().getToolbar().getCurrentTool(getDocument());
		if(ct!=null)
			ct.uninstall();
//		ToolUtil.getInstance().setCurrentTool(getDocument(), this);
	}
	
	@Override
	public void uninstall() {
		
	}
}
