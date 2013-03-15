package org.sgx.raphael4gwt.tut;

//import org.sgx.gwteditors.client.util.GUIUtil;
//import org.sgx.gwteditors.testgallery.gallery.Test;
//import org.sgx.gwteditors.testgallery.manual.test.ManualTestHome;

import java.util.regex.Pattern;

import org.sgx.raphael4gwt.test.Test;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.PreElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class TestRun extends Composite {

	private static TestRunUiBinder uiBinder = GWT.create(TestRunUiBinder.class);

	interface TestRunUiBinder extends UiBinder<Widget, TestRun> {
	}

	String testName, showSources;
	@UiField VerticalPanel panel;
	@UiField Button seeSources;
	@UiField SpanElement testNameEl, descrEl; 
	@UiField PreElement code; 
	private Test test;
	
	
	public TestRun() {
		initWidget(uiBinder.createAndBindUi(this));	
		seeSources.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				doSeeSources();
			}
		}); 
		
	}

	protected void doSeeSources() {
//		if(test==null||test.getJavaClassSource()==null|| test.getJavaSources().keySet().size()<1)
//			return;
//		ExternalTextResource res = test.getJavaSources().values().iterator().next(); 
//		if (res == null)
//			return;
//		try {
//			res.getText(new ResourceCallback<TextResource>() {
//				@Override
//				public void onSuccess(TextResource resource) {
//					
//					
//					String s = getSourceCodeForShowing(resource.getText()); 
//				
//					HTML el = new HTML();
//					PreElement pre = Document.get().createPreElement();
////					Element pre = Document.get().createDivElement(); 
//					
//					el.getElement().appendChild(pre); 
////					Document.get().getBody().appendChild(pre); 
////					 HTML el = HTML.wrap(pre); 
//					DialogBox db = GUIUtil.acceptDialog("Source", el);
//
//					db.setWidth("80%"); 
//					db.setHeight("400px"); 
//					
////					GUIUtil.showWidgetDialog("Source", el); 
////					el.setSize("200px", "200px"); 
////					GwtEditorsManual.prettyPrint(pre); 
////					GUIUtil.showText("Source", s);
//					
//					String pretty = GwtEditorsManual.prettyPrintOne(s); 
//					pre.setInnerHTML(pretty); 
//					pre.getStyle().setProperty("width", "400px"); 
//					pre.getStyle().setProperty("height", "300px");
//					pre.getStyle().setProperty("overflow", "scroll");
//					pre.addClassName("prettyprint"); 
//					db.center(); 
//				}
//
//				@Override
//				public void onError(ResourceException e) {
//					System.out.println("ERROR getting resource " + test.getClass());
//				}
//			});
//		} catch (ResourceException e) {
//			e.printStackTrace();
//		}
	}

	protected String getSourceCodeForShowing(String s) {
		int i = s.indexOf("/*---begintestmaincode---*/");
		int j = s.indexOf("/*---endtestmaincode---*/");
		try {
			s = s.substring(i + "/*---begintestmaincode---*/".length(), j);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	
	}
	
	

	private void doTest() {
//		test = ManualTestHome.getInstance().get(getTestName()); 		
//		if(test==null)
//			return;
//		test.test(panel);
		testNameEl.setInnerText(test.getName()); 
		descrEl.setInnerText(test.getDescription()); 
	}
	
	
	public String getTestName() {
		return testName;
	}

	public void setTestName(String tname) {
		this.testName = tname;
		doTest();
		if(showSources!=null)
			doShowSourcesNext(); 
	}

	public String getShowSources() {
		return showSources;
	}

	public void setShowSources(String showSources) {
		this.showSources = showSources;
		doShowSourcesNext();
		if(test!=null)
			doShowSourcesNext(); 
	}

	private void doShowSourcesNext() {
//		if(showSources!=null&&showSources.equals("true")) {
//			if(test==null||test.getJavaSources()==null|| test.getJavaSources().keySet().size()<1)
//				return;
//
//		
//			ExternalTextResource res = test.getJavaSources().values().iterator().next(); 
//			if (res == null)
//				return;
////			System.out.println("YYYY: "+res);
//			try {
//				res.getText(new ResourceCallback<TextResource>() {
//					@Override
//					public void onSuccess(TextResource resource) {
//						String s = getSourceCodeForShowing(resource.getText()); 
////						System.out.println("YYYY2: "+s);
//						String pretty = GwtEditorsManual.prettyPrintOne(s); 
//						code.setInnerHTML(pretty); 
//						code.getStyle().setProperty("display", "block"); 
//					}
//					@Override
//					public void onError(ResourceException e) {
//						System.out.println("ERROR getting resource " + test.getClass());
//					}
//				});
//			} catch (ResourceException e) {
//				e.printStackTrace();
//			}
//		}
	}

	

}
