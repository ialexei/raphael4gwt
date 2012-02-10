package org.sgx.raphael4gwt.test.gallery;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.PaperWidget;
import org.sgx.raphael4gwt.raphael.event.Callback;
import org.sgx.raphael4gwt.raphael.event.PaperListener;
import org.sgx.raphael4gwt.test.CircleGlowingAndDraggin;
import org.sgx.raphael4gwt.test.DragAndSnap;
import org.sgx.raphael4gwt.test.EventRegisterAndUnregister;
import org.sgx.raphael4gwt.test.ImageSimpleTest;
import org.sgx.raphael4gwt.test.util.GUIUtil;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainPanel extends VerticalPanel {
	private static final int PAPER_WIDTH = 600;
	private static final int PAPER_HEIGHT = 600;
	private FlowPanel testEvent;
	private PaperWidget paperWidget;
	private HorizontalSplitPanel horizontalSplitPanel;
	private FlowPanel testGeneral;
	protected Paper paper;
	private VerticalPanel testPanel;

	public MainPanel() {
		
		setSize("100%", GUIUtil.getMaxHeightStr());
		
		FlowPanel toobarPanel = new FlowPanel();
		add(toobarPanel);
		
		Button aboutButton = new Button("About", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				GUIUtil.showMessage("About this app", "This is a simple gallery of raphael4gwt examples.\n" +
						"See : http://code.google.com/p/raphael4gwt/.\n" +
						"Author: Sebastián Gurin <sebastigurin@gmail.com>");
			}
		});		
		toobarPanel.add(aboutButton);
		
		Button clearPaperButton = new Button("Clear paper", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				paper.clear();
			}
		});		
		toobarPanel.add(clearPaperButton);
		
		Button testDescButton = new Button("test description", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				GUIUtil.showMessage(GalleryUtil.getInstance().getCurrentTest().getName()+"'s description: ", 
					GalleryUtil.getInstance().getCurrentTest().getDescription());				
			}
		});		
		toobarPanel.add(testDescButton);
		
		Button showJavaButton = new Button("view java sources", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				GUIUtil.showText(GalleryUtil.getInstance().getCurrentTest().getName()+"'s java class source code: ", 
					GalleryUtil.getInstance().getCurrentTest().getJavaClassSource());				
			}
		});		
		toobarPanel.add(showJavaButton);
		
		
		horizontalSplitPanel = new HorizontalSplitPanel();
		horizontalSplitPanel.setSize("100%", "100%");
		horizontalSplitPanel.setSplitPosition("30%");
		add(horizontalSplitPanel);
		setCellHeight(horizontalSplitPanel, "100%");
		setCellWidth(horizontalSplitPanel, "100%");
		horizontalSplitPanel.setSize("100%", "100%");
		
		DecoratedStackPanel decoratedStackPanel = new DecoratedStackPanel();
		horizontalSplitPanel.setLeftWidget(decoratedStackPanel);
		decoratedStackPanel.setSize("100%", "100%");
		
		testGeneral = new FlowPanel();
		decoratedStackPanel.add(testGeneral, "General", false);
		testGeneral.setSize("100%", "100%");
				
		
		VerticalPanel vp2 = new VerticalPanel();
		testPanel = new VerticalPanel();
		testPanel.setWidth("100%");
		GalleryUtil.getInstance().setTestPanel(testPanel);
		vp2.add(new Label("Test controls: "));
		vp2.add(testPanel);
		vp2.add(new Label("Test canvas: "));
		paperWidget = new PaperWidget(PAPER_WIDTH, PAPER_HEIGHT, new PaperListener() {
			
			@Override
			public void paperLoaded(Paper paper) {
				/* the paper is loaded! so now we can instantiate all our tests */
				MainPanel.this.paper=paper;
				GalleryUtil.getInstance().loadAllTest(paperWidget.getPaper(), PAPER_WIDTH, PAPER_HEIGHT);
				GalleryUtil.getInstance().doAddAllGeneralTests(testGeneral);
			}
		});
		paperWidget.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		vp2.add(paperWidget);
		horizontalSplitPanel.setRightWidget(vp2);
		paperWidget.setSize("100%", "100%");
		
	}

}
