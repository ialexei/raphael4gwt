package org.sgx.espinillo.client.impl1.ui;

import org.sgx.espinillo.client.model.VEditor;
import org.sgx.raphael4gwt.raphael.util.GUIUtil;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.*;

public class VEditorWidgetUtil extends MenuBar{

//	private static VEditorWidgetUtil instance;
//
//	private VEditorWidgetUtil() {
//	}
//
//	public static VEditorWidgetUtil getInstance() {
//		if (null == instance) {
//			instance = new VEditorWidgetUtil();
//		}
//		return instance;
//	}
//	
	
	
	public VEditorWidgetUtil() {
//		MenuBar menuBar = new MenuBar(false);
//		topPanel.add(menuBar);
		MenuBar menuBar_1 = new MenuBar(true);
		
		MenuItem mntmFile = new MenuItem("File", false, menuBar_1);
		
		MenuItem mntmOpen = new MenuItem("Open", false, new Command() {
			public void execute() {
				SaveDialog d = new SaveDialog(getVeditor().getCurrentDocument());
				GUIUtil.showDialogBox(d);
			}

			
		});
		menuBar_1.addItem(mntmOpen);
		
		MenuItem mntmSave = new MenuItem("Save", false, new Command() {
			public void execute() {
			}
		});
		menuBar_1.addItem(mntmSave);
		addItem(mntmFile);
		MenuBar menuBar_2 = new MenuBar(true);
		
		MenuItem mntmEdit = new MenuItem("Edit", false, menuBar_2);
		
		MenuItem mntmUndo = new MenuItem("Undo", false, new Command() {			
			@Override
			public void execute() {
				getVeditor().getCurrentDocument().undo();
			}
		});
		menuBar_2.addItem(mntmUndo);
		
		MenuItem mntmRedo = new MenuItem("Redo", false, new Command() {			
			@Override
			public void execute() {
				getVeditor().getCurrentDocument().redo();
			}
		});
		menuBar_2.addItem(mntmRedo);
		
		MenuItemSeparator separator = new MenuItemSeparator();
		menuBar_2.addSeparator(separator);
		
		MenuItem mntmCopy = new MenuItem("Copy", false, (Command) null);
		menuBar_2.addItem(mntmCopy);
		
		MenuItem mntmCut = new MenuItem("Cut", false, (Command) null);
		menuBar_2.addItem(mntmCut);
		
		MenuItem mntmPaste = new MenuItem("Paste", false, (Command) null);
		menuBar_2.addItem(mntmPaste);
		addItem(mntmEdit);
		MenuBar menuBar_3 = new MenuBar(true);
		
		MenuItem mntmHelp = new MenuItem("Help", false, menuBar_3);
		
		MenuItem mntmUserManual = new MenuItem("User Manual", false, (Command) null);
		menuBar_3.addItem(mntmUserManual);
		
		MenuItem mntmAbout = new MenuItem("About", false, (Command) null);
		menuBar_3.addItem(mntmAbout);
		addItem(mntmHelp);
		
	}
	protected VEditor getVeditor() {
		return VEditorWidget.getInstance().getVeditor();
	}
}
