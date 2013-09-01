package org.sgx.espinillo.client.impl1.ui;

import org.sgx.espinillo.client.impl1.commands.ClipboardCmd;
import org.sgx.espinillo.client.impl1.eds.TransformBean1;
import org.sgx.espinillo.client.impl1.ui.i18in.Messages;
import org.sgx.espinillo.client.impl1.util.ClipboardUtil;
import org.sgx.espinillo.client.impl1.util.ShapeUtil;
import org.sgx.espinillo.client.impl1.util.ToolUtil;
import org.sgx.espinillo.client.model.Document;
import org.sgx.espinillo.client.model.SelectionListener;
import org.sgx.espinillo.client.model.VEditor;
import org.sgx.espinillo.client.util.Util;
import org.sgx.gwteditors.client.impl1.complex.PropertyHaverEditor2;
import org.sgx.gwteditors.client.util.AcceptCancelDialogListener;
import org.sgx.gwteditors.client.util.GUIUtil;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Rectangle;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class VEditorMenuBar extends MenuBar {

	protected DialogBox transformAllDialog;

	public VEditorMenuBar() {

		MenuBar menuBar_1 = new MenuBar(true);

		MenuItem mntmFile = new MenuItem(Messages.INSTANCE.file(), false, menuBar_1);

		MenuItem mntmOpen = new MenuItem(Messages.INSTANCE.open(), false, new Command() {
			public void execute() {

				VerticalPanel vp = new VerticalPanel();
				final TextArea input = new TextArea();
				input.setSize("100%", "200px");

				vp.add(new Label(Messages.INSTANCE.msg1()));
				vp.add(input);
				DialogBox db = GUIUtil.acceptCancelDialog(Messages.INSTANCE.openDocument(), vp,
						new AcceptCancelDialogListener() {

							@Override
							public void notifyCancel(DialogBox db) {
								db.hide();
							}

							@Override
							public void notifyAccept(DialogBox db) {
								// TODO: oipen a new document - now we use the same paper.
								Paper paper = getVeditor().getCurrentDocument().getPaper();
								paper.clear();
								VEditorMain.newDocument(getVeditor(), paper, Messages.INSTANCE.unamed(),
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

		MenuItem mntmSave = new MenuItem(Messages.INSTANCE.save(), false, new Command() {
			public void execute() {
				Document doc = VEditorWidget.getInstance().getVeditor().getCurrentDocument();

				VerticalPanel vp = new VerticalPanel();
				TextArea input = new TextArea();
				Set allshapes = doc.getPaper().getAllShapes();
				allshapes.exclude(ToolUtil.getInstance().getPaperMask(doc));
				input.setText(allshapes.writeToString());
				input.setSize("100%", "200px");
				vp.add(new Label(Messages.INSTANCE.msg2(getVeditor().getCurrentDocument().getName())));
				vp.add(input);

				DialogBox db = GUIUtil.acceptDialog(Messages.INSTANCE.saveDocument(), vp);
				GUIUtil.showDialogBox(db);
			}
		});
		menuBar_1.addItem(mntmSave);

		MenuItem mntmNewItem = new MenuItem(Messages.INSTANCE.exportToSVG(), false, new Command() {
			public void execute() {
				Document doc = VEditorWidget.getInstance().getVeditor().getCurrentDocument();

				VerticalPanel vp = new VerticalPanel();
				TextArea input = new TextArea();
				// TODO: exclude mask and selection feedback shapes from paper before exporting it.
				input.setText(doc.getPaper().toSVG());
				input.setSize("100%", "200px");
				vp.add(new Label(Messages.INSTANCE.msg2(getVeditor().getCurrentDocument().getName())));
				vp.add(input);
				DialogBox db = GUIUtil.acceptDialog(Messages.INSTANCE.exportToSVG(), vp);
				GUIUtil.showDialogBox(db);
			}
		});
		menuBar_1.addItem(mntmNewItem);

		MenuItem mntmNewItem_1 = new MenuItem(Messages.INSTANCE.importSVG(), false, new Command() {
			public void execute() {
				VerticalPanel vp = new VerticalPanel();
				final TextArea input = new TextArea();
				input.setSize("100%", "200px");
				input.setText("<svg style=\"overflow: hidden; position: relative;\" "
						+ "xmlns=\"http://www.w3.org/2000/svg\" " + "xmlns:xlink=\"http://www.w3.org/1999/xlink\" "
						+ "width=\"600\" version=\"1.1\" height=\"600\">"
						+ "<rect transform=\"matrix(1,0,0,1,0,0)\" x=\"10\" y=\"20\" width=\"100\""
						+ " height=\"200\" r=\"12\" rx=\"12\" ry=\"12\" fill=\"red\" stroke=\"#000\" "
						+ "stroke-width=\"8\"></rect><circle transform=\"matrix(1,0,0,1,0,0)\" "
						+ "cx=\"200\" cy=\"200\" r=\"50\" fill=\"none\" stroke=\"#000\"></circle>"
						+ "<ellipse transform=\"matrix(1,0,0,1,0,0)\" cx=\"100\" cy=\"100\" rx=\"50\" "
						+ "ry=\"120\" fill=\"none\" stroke=\"#000\"></ellipse></svg>");

				vp.add(new Label(Messages.INSTANCE.msg1()));
				vp.add(input);
				DialogBox db = GUIUtil.acceptCancelDialog(Messages.INSTANCE.importSVG(), vp,
						new AcceptCancelDialogListener() {

							@Override
							public void notifyCancel(DialogBox db) {
								db.hide();
							}

							@Override
							public void notifyAccept(DialogBox db) {
								// TODO: open a new document - now we use the same paper.
								Paper paper = getVeditor().getCurrentDocument().getPaper();
								paper.clear();
								VEditorMain.newDocument(getVeditor(), paper, Messages.INSTANCE.unamed(),
										new SelectionListener() {
											@Override
											public void selectionChange(Document d) {
												VEditorWidget.getInstance().getShapePropertiesPanel()
														.notifyEspinilloSelectionChange(d.getSelection());
											}
										});
								paper.importSvg(input.getText());
							}
						});
				GUIUtil.showDialogBox(db);
			}
		});
		menuBar_1.addItem(mntmNewItem_1);
		menuBar_1.addSeparator();

		MenuItem mntmLangs = new MenuItem(Messages.INSTANCE.language(), false, new Command() {
			public void execute() {

			}
		});
		MenuBar langsMenuBar = new MenuBar(true);
		MenuItem langes = new MenuItem(Messages.INSTANCE.english(), false, new Command() {
			public void execute() {
				String url = Util.getCurrentAddressUrl();
				if (!url.contains("en.html") && !url.contains("index.html")) {
					if (Window.confirm(Messages.INSTANCE.reloadEditorConfirmation())) {
						Util.setCurrentAddressUrl("/espinillo/en.html");
					}
				}
			}
		});
		langsMenuBar.addItem(langes);
		MenuItem langen = new MenuItem(Messages.INSTANCE.spanish(), false, new Command() {
			public void execute() {
				String url = Util.getCurrentAddressUrl();
				if (!url.contains("es.html")) {
					if (Window.confirm(Messages.INSTANCE.reloadEditorConfirmation())) {
						Util.setCurrentAddressUrl("/espinillo/es.html");
					}
				}
			}
		});
		langsMenuBar.addItem(langen);

		mntmLangs.setSubMenu(langsMenuBar);
		menuBar_1.addItem(mntmLangs);

		// menuBar_1.addItem(langsMenuItem);
		addItem(mntmFile);

		
		
		
		
		
		MenuBar menuBar_2 = new MenuBar(true);
		

		MenuItem mntmEdit = new MenuItem(Messages.INSTANCE.edit(), false, menuBar_2);

		MenuItem mntmUndo = new MenuItem(Messages.INSTANCE.undo(), false, new Command() {
			@Override
			public void execute() {
				getVeditor().getCurrentDocument().undo();
			}
		});
		menuBar_2.addItem(mntmUndo);

		MenuItem mntmRedo = new MenuItem(Messages.INSTANCE.redo(), false, new Command() {
			@Override
			public void execute() {
				getVeditor().getCurrentDocument().redo();
			}
		});
		menuBar_2.addItem(mntmRedo);

		MenuItemSeparator separator = new MenuItemSeparator();
		menuBar_2.addSeparator(separator);

		MenuItem mntmCopy = new MenuItem(Messages.INSTANCE.copy(), false, new Command() {
			@Override
			public void execute() {
				Document doc = getVeditor().getCurrentDocument();
				ClipboardCmd cmd = new ClipboardCmd(doc, ClipboardCmd.TYPE_COPY, doc.getSelection());
				getVeditor().getCurrentDocument().execute(cmd);
			}
		});
		menuBar_2.addItem(mntmCopy);

		MenuItem mntmCut = new MenuItem(Messages.INSTANCE.cut(), false, new Command() {
			@Override
			public void execute() {
				Document doc = getVeditor().getCurrentDocument();
				ClipboardCmd cmd = new ClipboardCmd(doc, ClipboardCmd.TYPE_CUT, doc.getSelection());
				getVeditor().getCurrentDocument().execute(cmd);
			}
		});
		menuBar_2.addItem(mntmCut);

		MenuItem mntmPaste = new MenuItem(Messages.INSTANCE.paste(), false, new Command() {
			@Override
			public void execute() {
				Document doc = getVeditor().getCurrentDocument();
				ClipboardCmd cmd = new ClipboardCmd(doc, ClipboardCmd.TYPE_PASTE, ClipboardUtil.getInstance()
						.getClipboard(doc));
				doc.execute(cmd);
			}
		});
		menuBar_2.addItem(mntmPaste);
		addItem(mntmEdit);

		
		

		MenuBar menuBar_view = new MenuBar(true);
		MenuItem mntmNewMenu_view = new MenuItem("View", false, menuBar_view);

		MenuItem mntmNewMenu_view1 = new MenuItem("zoom in", false, new Command() {
			@Override
			public void execute() {
				Paper paper = getVeditor().getCurrentDocument().getPaper();
//				paper.setv
				ShapeUtil.getInstance().dumpPaper(paper);
			}
		});
		menuBar_view.addItem(mntmNewMenu_view1);
		addItem(mntmNewMenu_view); 
		
		
		
		
		

		MenuBar menuBar = new MenuBar(true);
		MenuItem mntmNewMenu = new MenuItem("Tools", false, menuBar);

		MenuItem mntmNewItem_2 = new MenuItem("Inspect Paper", false, new Command() {
			@Override
			public void execute() {
				Paper paper = getVeditor().getCurrentDocument().getPaper();
				ShapeUtil.getInstance().dumpPaper(paper);
			}
		});
		menuBar.addItem(mntmNewItem_2);

		MenuItem mntmNewItem_3 = new MenuItem("Transform all", false, new Command() {
			@Override
			public void execute() {

				// final TextBox text = new TextBox();
				// text.setText("..t-20,-4s-1.4,-1.5r11");
				TransformBean1 bean = TransformBean1.create();
				final PropertyHaverEditor2<TransformBean1> ed = new PropertyHaverEditor2<TransformBean1>();
				ed.load(bean);

				transformAllDialog = GUIUtil.acceptCancelDialog("transform all", ed.getWidget(),
						new AcceptCancelDialogListener() {

							@Override
							public void notifyCancel(DialogBox db) {
//								transformAllDialog.hide();
							}

							@Override
							public void notifyAccept(DialogBox db) {
								Paper paper = getVeditor().getCurrentDocument().getPaper();
								final Set all = paper.allShapes();
								Rectangle allbb = all.getBBox(); 
								final double 
									mx=allbb.getX()+allbb.getWidth()/2, 
									my=allbb.getY()+allbb.getHeight()/2; 
								all.forEach(new ForEachCallback() {
									@Override
									public boolean call(Shape shape, int index) {
										if(shape.getData(ShapeUtil.CLASS)!=null&&shape.getData(ShapeUtil.CLASS).equals(ShapeUtil.CLASS_MASK))
											return true;										

										if(shape.getType().equals("path")&&shape.attr("transform")!=null&&!shape.attr("transform").equals("")) {
											String newPath = Raphael.transformPath(shape.attr("path"), shape.attr("transform"));
											shape.attr(Attrs.create().path(newPath).transform(""));
										}
										
//										Rectangle bb = shape.getBBox(true); 
//										final double 
//											mx=bb.getX()+bb.getWidth()/2, 
//											my=bb.getY()+bb.getHeight()/2; 
										TransformBean1 tdata = ed.flush();
										System.out.println(tdata.getAbsolute());
										String t = "";
										t += (tdata.getAbsolute() ? "S" : "s");
										t += (tdata.getScaleX() + "," + tdata.getScaleY());
										t+=","+mx+","+my;//,100,100"; 
										t += (tdata.getAbsolute() ? "T" : "t");
										t+=tdata.getTranslateX()+","+tdata.getTranslateY(); 
										
										shape.attr(Attrs.create().transform(t));
										
										// t+=(tdata.getAbsolute() ? "T" : "t");
										// t+=(tdata.getTranslateX()+","+tdata.getTranslateY());

//										if (shape.getType().equals("path")) {
//											String path2 = Raphael.transformPath(shape.attr("path"), t);
//											shape.attr("path", path2); 
//										} else {
//											shape.transform(t); 
//										}
										return true;
									}
								});
								//
//								transformAllDialog.hide();
							}
						});

				// ShapeUtil.getInstance().dumpPaper(paper);
			}
		});
		menuBar.addItem(mntmNewItem_3);
		addItem(mntmNewMenu);

		MenuBar menuBar_3 = new MenuBar(true);

		MenuItem mntmHelp = new MenuItem(Messages.INSTANCE.help(), false, menuBar_3);

		MenuItem mntmUserManual = new MenuItem(Messages.INSTANCE.userManual(), false, (Command) null);
		menuBar_3.addItem(mntmUserManual);

		MenuItem mntmAbout = new MenuItem(Messages.INSTANCE.about(), false, new Command() {
			@Override
			public void execute() {
				DialogBox db = GUIUtil.acceptDialog(Messages.INSTANCE.about(),
						new HTML(Messages.INSTANCE.html_aboutDialogContent()));
				GUIUtil.showDialogBox(db);
			}
		});
		menuBar_3.addItem(mntmAbout);
		addItem(mntmHelp);

	}

	protected VEditor getVeditor() {
		return VEditorWidget.getInstance().getVeditor();
	}
}
