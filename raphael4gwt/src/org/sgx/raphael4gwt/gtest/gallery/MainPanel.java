package org.sgx.raphael4gwt.gtest.gallery;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.util.GUIUtil;
import org.sgx.raphael4gwt.raphael.widget.PaperWidget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainPanel extends VerticalPanel {
	private static final int PAPER_WIDTH = 900;
	private static final int PAPER_HEIGHT = 900;
	private FlowPanel testEvent;
//	private PaperWidgetOld paperWidget;
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
		
		Button showJavaButton2 = new Button("view java sources 2", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				String className = GalleryUtil.getInstance().getCurrentTest().getClass().getName(); //getSimpleName is not supported by gwt
				String simpleName = className.substring(className.lastIndexOf('.')+1, className.length());
				String html = "http://cancerbero.vacau.com/gwt/raphael4gwt-j2h/org/sgx/raphael4gwt/test/"+simpleName+".java.html";
				Window.open(html, className, null);				
			}
		});		
		toobarPanel.add(showJavaButton2);
		
		
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
		vp2.setWidth("100%");
		testPanel = new VerticalPanel();
		testPanel.setWidth("100%");
		GalleryUtil.getInstance().setTestPanel(testPanel);
		vp2.add(new Label("Test controls: "));
		vp2.add(testPanel);
		vp2.add(new Label("Test canvas: "));
		
		paperWidget = new PaperWidget(PAPER_WIDTH, PAPER_HEIGHT); 
		MainPanel.this.paper=paperWidget.getPaper(); //.createPaper(PAPER_WIDTH, PAPER_HEIGHT);
		paperWidget.getPaper().rect(10,10,40,60,2);
		vp2.add(paperWidget); 
		
		GalleryUtil.getInstance().loadAllTest(paperWidget.getPaper(), PAPER_WIDTH, PAPER_HEIGHT);
		GalleryUtil.getInstance().doAddAllGeneralTests(testGeneral);		
		GalleryUtil.getInstance().checkUrl();
				
//		paperWidget = new PaperWidgetOld(PAPER_WIDTH, PAPER_HEIGHT, new PaperListener() {
//			
//			@Override
//			public void paperLoaded(Paper paper) {
//				/* the paper is loaded! so now we can instantiate all our tests */
//				MainPanel.this.paper=paper;
////				native1(paper);
//				GalleryUtil.getInstance().loadAllTest(paperWidget.getPaper(), PAPER_WIDTH, PAPER_HEIGHT);
//				GalleryUtil.getInstance().doAddAllGeneralTests(testGeneral);
//				
//				GalleryUtil.getInstance().checkUrl();
//			}
//		});
//		paperWidget.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
//		vp2.add(paperWidget);
		
		
		horizontalSplitPanel.setRightWidget(vp2);
		paperWidget.setSize("100%", "100%");
		
	}

//	protected native final void native1(Paper p)/*-{
//		$wnd.alert(p.piechart+"");
//	}-*/;


}
