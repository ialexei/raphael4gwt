package org.sgx.espinillo.client.impl1.eds;

import org.sgx.gwteditors.client.impl1.basetypes.SelectionList;
import org.sgx.gwteditors.client.impl1.edbean.EditableBean;

public abstract class ArrowEndBean implements EditableBean {
	public static final String[] TYPES = new String[]{
		"classic", "block", "open", "oval", "diamond", "none"
	};
	public static final String[] WIDTHS = new String[]{
		"wide", "narrow", "midium", "length"
	};
	public static final String[] LENGTHS = new String[]{
		"long", "short", "midium"
	};
	
	SelectionList<String> type, width, length;
	
	public ArrowEndBean(){
		super();	
		type=new SelectionList<String>(TYPES, new String[]{"classic"});
		width=new SelectionList<String>(WIDTHS, new String[]{"wide"});
		length=new SelectionList<String>(LENGTHS, new String[]{"long"});
	}

	public ArrowEndBean(String type, String width, String length) {
		this();
		this.type.getSelection().clear();
		this.type.getSelection().add(type);
		this.width.getSelection().clear();
		this.width.getSelection().add(width);
		this.length.getSelection().clear();
		this.length.getSelection().add(length);
	}

	public SelectionList<String> getType() {
		return type;
	}

	public void setType(SelectionList<String> type) {
		this.type = type;
	}

	public SelectionList<String> getWidth() {
		return width;
	}

	public void setWidth(SelectionList<String> width) {
		this.width = width;
	}

	public SelectionList<String> getLength() {
		return length;
	}

	public void setLength(SelectionList<String> length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "type: "+type.getSelection().get(0)+
			", width: "+width.getSelection().get(0)+
			", length: "+length.getSelection().get(0);
	}

	public String toRaphaelString() {
		return type.getSelection().get(0)+"-"+width.getSelection().get(0)+
			"-"+length.getSelection().get(0);
	}

	public void setSelectedType(String s) {
		this.type.setSelection(s);
	}

	public void setSelectedWidth(String s) {
		this.width.setSelection(s);
	}
	
	public void setSelectedLength(String s) {
		this.length.setSelection(s);
	}
}
