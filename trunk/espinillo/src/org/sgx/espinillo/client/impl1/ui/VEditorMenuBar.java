package org.sgx.espinillo.client.impl1.ui;

import org.sgx.espinillo.client.impl1.commands.ClipboardCmd;
import org.sgx.espinillo.client.impl1.ui.htmls.HTMLResources;
import org.sgx.espinillo.client.impl1.util.ClipboardUtil;
import org.sgx.espinillo.client.impl1.util.ShapeUtil;
import org.sgx.espinillo.client.impl1.util.ToolUtil;
import org.sgx.espinillo.client.model.Document;
import org.sgx.espinillo.client.model.SelectionListener;
import org.sgx.espinillo.client.model.VEditor;
import org.sgx.gwteditors.client.util.AcceptCancelDialogListener;
import org.sgx.gwteditors.client.util.GUIUtil;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;
//import org.sgx.raphael4gwt.raphael.util.GUIUtil;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.*;

public class VEditorMenuBar extends MenuBar{
	
	public VEditorMenuBar() {
		MenuBar menuBar_1 = new MenuBar(true);
		
		MenuItem mntmFile = new MenuItem("File", false, menuBar_1);
		
		MenuItem mntmOpen = new MenuItem("Open", false, new Command() {
			public void execute() {
				
				VerticalPanel vp = new VerticalPanel();
				final TextArea input = new TextArea();
				input.setSize("100%", "200px");
				
				vp.add(new Label("Please copy the data of a previus saved document " +
					"to open it: "));
				vp.add(input);
				DialogBox db = GUIUtil.acceptCancelDialog("Open document", vp, 
					new AcceptCancelDialogListener() {
				
				@Override
				public void notifyCancel(DialogBox db) {
				}
				
				@Override
				public void notifyAccept(DialogBox db) {
					//TODO: oipen a new document - now we use the same paper.
					Paper paper = getVeditor().getCurrentDocument().getPaper();
					paper.clear();
					Document doc = VEditorMain.newDocument(getVeditor(), paper, "unamed2", 
						new SelectionListener() {					
						@Override
						public void selectionChange(Document d) {
							VEditorWidget.getInstance().getShapePropertiesPanel()
								.notifyEspinilloSelectionChange(d.getSelection());
						}					
					});
					paper.add(input.getText());
				}
			});
				GUIUtil.showDialogBox(db);
			}

			
		});
		menuBar_1.addItem(mntmOpen);
		
		MenuItem mntmSave = new MenuItem("Save", false, new Command() {
			public void execute() {
				Document doc = VEditorWidget.getInstance().getVeditor().getCurrentDocument();
				
				VerticalPanel vp = new VerticalPanel();
				TextArea input = new TextArea();
				Set allshapes = doc.getPaper().getAllShapes();
				allshapes.exclude(ToolUtil.getInstance().getPaperMask(doc));
				input.setText(allshapes.writeToString());
				input.setSize("100%", "200px");
				vp.add(new Label("This is \""+doc.getName()+
					"\" data\nPlease copy&paste it in a text file."));
				vp.add(input);
				
				DialogBox db = GUIUtil.acceptDialog("Save document", vp);
				GUIUtil.showDialogBox(db);
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
		
		MenuItem mntmCopy = new MenuItem("Copy", false, new Command() {			
			@Override
			public void execute() {
				Document doc = getVeditor().getCurrentDocument();
				ClipboardCmd cmd = new ClipboardCmd(doc, 
					ClipboardCmd.TYPE_COPY, doc.getSelection());				
				getVeditor().getCurrentDocument().execute(cmd);
			}
		});
		menuBar_2.addItem(mntmCopy);
		
		MenuItem mntmCut = new MenuItem("Cut", false, new Command() {			
			@Override
			public void execute() {
				Document doc = getVeditor().getCurrentDocument();
				ClipboardCmd cmd = new ClipboardCmd(doc, 
					ClipboardCmd.TYPE_CUT, doc.getSelection());				
				getVeditor().getCurrentDocument().execute(cmd);
			}
		});
		menuBar_2.addItem(mntmCut);
		
		MenuItem mntmPaste = new MenuItem("Paste", false, new Command() {			
			@Override
			public void execute() {
				Document doc = getVeditor().getCurrentDocument();
				ClipboardCmd cmd = new ClipboardCmd(doc, ClipboardCmd.TYPE_PASTE, 
					ClipboardUtil.getInstance().getClipboard(doc));				
				doc.execute(cmd);
			}
		});
		menuBar_2.addItem(mntmPaste);
		addItem(mntmEdit);
		MenuBar menuBar_3 = new MenuBar(true);
		
		MenuItem mntmHelp = new MenuItem("Help", false, menuBar_3);
		
		MenuItem mntmUserManual = new MenuItem("User Manual", false, (Command) null);
		menuBar_3.addItem(mntmUserManual);
		
		MenuItem mntmAbout = new MenuItem("About", false, new Command() {			
			@Override
			public void execute() {
				DialogBox db = GUIUtil.acceptDialog("About", 
						new HTML(HTMLResources.INSTANCE.aboutDialog().getText()));
				GUIUtil.showDialogBox(db);
//				HTML h = new HTML(HTMLResources.INSTANCE.aboutDialog().getText());
//				db = new DialogBox();
			}
		});
		menuBar_3.addItem(mntmAbout);
		addItem(mntmHelp);
		
	}
	protected VEditor getVeditor() {
		return VEditorWidget.getInstance().getVeditor();
	}
}
