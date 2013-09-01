package org.sgx.espinillo.client.impl1.ui;

import org.sgx.espinillo.client.impl1.commands.ChangeShapeAttrsCmd;
import org.sgx.espinillo.client.impl1.model.VEditor1;
import org.sgx.espinillo.client.impl1.test.PaperOverlay;
import org.sgx.espinillo.client.model.Command;
import org.sgx.espinillo.client.model.CommandListener;
import org.sgx.espinillo.client.model.Document;
import org.sgx.espinillo.client.model.SelectionListener;
import org.sgx.espinillo.client.model.VEditor;
import org.sgx.espinillo.client.model.tool.Toolbar;
import org.sgx.espinillo.client.util.Util;
import org.sgx.gwteditors.client.impl1.EditorFramework1;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;
//import org.sgx.raphael4gwt.raphael.PaperWidget;
import org.sgx.raphael4gwt.raphael.event.PaperListener;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * the main widget of espinillo editor - contains the paper widget, the toolbars, the menu, etc.
 * @author sg
 */
public class VEditorWidget extends DockPanel {
	
	private static VEditorWidget instance;

	public static VEditorWidget getInstance() {
		if (null == instance) {
			instance = new VEditorWidget();
		}
		return instance;
	}
	
	public RCPaperWidget paperWidget;
	private VEditor veditor;
	private Label status;
//	private ShapeBean currentSelectionShapeBean;
//	private PropertyHaverEditor1<ShapeBean> shapeEditor;
	private EditorFramework1 editorFramework;
	private VEditorMenuBar menuBar;
	private ShapePropsPanel shapePropsPanel;
	protected PaperOverlay paperOverlay;
	public boolean rightClickFired;
	private Document currentDocument;

	public EditorFramework1 getEditorFramework() {
		return editorFramework;
	}
	public Document getCurrentDocument() {
		return currentDocument;
	}
	public ShapePropsPanel getShapePropertiesPanel() {
		return shapePropsPanel;
	}
	public VEditorWidget() {
		veditor = new VEditor1();
		
		//do not forget of initialize the gwteditors framework !
		editorFramework = new EditorFramework1(); 
		editorFramework.start();
		
		initGUI();
	}

	private void initGUI() {
		setWidth("100%"); //all the window space
		
		
		//top
		
		VerticalPanel topPanel = new VerticalPanel();
		topPanel.setWidth("100%");
		topPanel.getElement().addClassName("top-panel");
		add(topPanel, DockPanel.NORTH);		
		menuBar = new VEditorMenuBar();
		topPanel.add(menuBar);
		
		FlowPanel toolbarPanel = new FlowPanel();
		topPanel.add(toolbarPanel);
		final Toolbar toolbar = veditor.getToolbar();
		for (int i = 0; i < toolbar.getAllToolNames().length; i++) {
			final String name = toolbar.getAllToolNames()[i];
			String label = toolbar.getAllToolLabels()[i];
			label=label==null?name:label;
			Button b = new Button(label, new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					Document doc = getVeditor().getCurrentDocument();
					Toolbar toolbar = getVeditor().getToolbar();
					toolbar.setCurrentTool(doc, toolbar.newTool(name, doc));
				}
			});
			b.getElement().addClassName(Util.toCSSClass(name));
			toolbarPanel.add(b);
		}
		
		
		
		//bottom
		
		FlowPanel flowPanel_1 = new FlowPanel();
		add(flowPanel_1, DockPanel.SOUTH);
		
		status=new Label("status bar");
		flowPanel_1.add(status);
		
		
		
		//left
		
		shapePropsPanel=new ShapePropsPanel();
		add(shapePropsPanel, DockPanel.WEST);		
		
		
		//right
		
		FlowPanel rightPanel = new FlowPanel();
		add(rightPanel, DockPanel.EAST);
		
		Label lblRightpanel = new Label("rightPanel");
		rightPanel.add(lblRightpanel);
		
		
		
		//center -the paper - async loaded.
		paperWidget = new RCPaperWidget(1500, 1500);
		
		currentDocument = VEditorMain.newDocument(getVeditor(), paperWidget.getPaper(), "unamed1");
		currentDocument.addSelectionListener(new SelectionListener() {					
			@Override
			public void selectionChange(Document d) {
				shapePropsPanel.notifyEspinilloSelectionChange(d.getSelection());
			}
		}); 
		currentDocument.addCommandListener(ChangeShapeAttrsCmd.class, new CommandListener() {
			
			@Override
			public void onCommandExec(Command c) {
				shapePropsPanel.doShapeChange(c);				
			}
			
			@Override
			public boolean beforeCommandExec(Command c) {
				// TODO Auto-generated method stub
				return true;
			}
		});
		
//		, new PaperListener() {
//			@Override
//			public void paperLoaded(Paper p) {
//				
//				VEditorMain.newDocument(getVeditor(), p, "unamed1", 
//					new SelectionListener() {					
//					@Override
//					public void selectionChange(Document d) {
//						shapePropsPanel.notifyEspinilloSelectionChange(d.getSelection());
//					}
//				});
//				//put an overlay on top of the paper
////				paperOverlay = new PaperOverlay(paperWidget);
////				paperOverlay.getElement().setId("paperoverlay1");
////				paperWidget.add(paperOverlay);
//			}
//		});
		
		paperWidget.getElement().getStyle().setProperty("border", "1px solid black"); 
		paperWidget.setWidth("500px");
		paperWidget.setHeight("500px");
		
		paperWidget.addContextClickHandler(new ContextClickHandler() {			
			@Override
			public void handleContextClick(Event theEvent) {
				Window.alert("context");
			}
		});
		add(paperWidget, DockPanel.CENTER);
		
		
		
		
	}
	public Label getStatus() {
		return status;
	}
	public VEditor getVeditor() {
		return veditor;
	}
}
