package org.sgx.espinillo.client.impl1.ui;

import org.sgx.espinillo.client.impl1.model.VEditor1;
import org.sgx.espinillo.client.model.Document;
import org.sgx.espinillo.client.model.SelectionListener;
import org.sgx.espinillo.client.model.VEditor;
import org.sgx.espinillo.client.model.tool.Toolbar;
import org.sgx.gwteditors.client.impl1.EditorFramework1;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.PaperWidget;
import org.sgx.raphael4gwt.raphael.event.PaperListener;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * 
 * @author sg
 *
 */
public class VEditorWidget extends DockPanel {
	
	private static VEditorWidget instance;

	public static VEditorWidget getInstance() {
		if (null == instance) {
			instance = new VEditorWidget();
		}
		return instance;
	}
	
	private PaperWidget paperWidget;
	private VEditor veditor;
	private Label status;
//	private ShapeBean currentSelectionShapeBean;
//	private PropertyHaverEditor1<ShapeBean> shapeEditor;
	private EditorFramework1 edFramework;
	private VEditorMenuBar menuBar;
	private ShapePropsPanel shapePropsPanel;

	public ShapePropsPanel getShapePropertiesPanel() {
		return shapePropsPanel;
	}
	public VEditorWidget() {
		veditor = new VEditor1();
		
		//do not forget of initialize the gwteditors framework !
		edFramework = new EditorFramework1(); 
		edFramework.start();
		
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
		
		for(final String tn : veditor.getToolbar().getAllToolNames()) {
			Button b = new Button(tn, new ClickHandler() {			
				@Override
				public void onClick(ClickEvent event) {
					Document doc = getVeditor().getCurrentDocument();
					Toolbar toolbar = getVeditor().getToolbar();
					toolbar.setCurrentTool(doc, toolbar.newTool(tn, doc));
				}
			});
			toolbarPanel.add(b);
		}		
		
		
		
		//bottom
		
		FlowPanel flowPanel_1 = new FlowPanel();
		add(flowPanel_1, DockPanel.SOUTH);
		
		status=new Label();
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
		paperWidget = new PaperWidget(1400, 500, new PaperListener() {
			
			@Override
			public void paperLoaded(Paper p) {
				VEditorMain.newDocument(getVeditor(), p, "unamed1", 
					new SelectionListener() {					
					@Override
					public void selectionChange(Document d) {
						shapePropsPanel.notifyEspinilloSelectionChange(d.getSelection());
					}					
				});
			}
		});
		paperWidget.setWidth("100%");
		add(paperWidget, DockPanel.CENTER);
		
		
	}
public Label getStatus() {
	return status;
}
public VEditor getVeditor() {
	return veditor;
}
}
