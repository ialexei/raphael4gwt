package org.sgx.espinillo.client.impl1.ui.i18in;

import com.google.gwt.core.client.GWT;
/**
 * 
 * @author sg
 *
 */
public interface Messages extends com.google.gwt.i18n.client.Messages {
	
	public static Messages INSTANCE = GWT.create(Messages.class);
	
	String file();

	String open();

	String msg1();

	String openDocument();

	String unamed();

	String save();

	String edit();

	String undo();

	String saveDocument();

	String redo();

	String copy();

	String cut();

	String paste();

	String help();

	String userManual();

	String about();

	String msg2(String docname);
	
	String html_aboutDialogContent();
}
