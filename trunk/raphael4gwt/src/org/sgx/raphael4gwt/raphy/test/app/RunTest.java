package org.sgx.raphael4gwt.raphy.test.app;

import org.sgx.raphael4gwt.raphael.util.GUIUtil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class RunTest extends Composite {

	private static RunTestUiBinder uiBinder = GWT.create(RunTestUiBinder.class);

	interface RunTestUiBinder extends UiBinder<Widget, RunTest> {
	}

	String testName;
	@UiField
	Element containerEl;

	@UiField
	Element descEl;
	@UiField
	Button seeSourcesButton;

	@UiConstructor
	public RunTest(String testName) {
		this.testName = testName;
		initWidget(uiBinder.createAndBindUi(this));
		
		addAttachHandler(new AttachEvent.Handler() {			
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				doRunTest();
			}
		}); 
		seeSourcesButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				doSeeSources();
			}
		});
	}

	private void doRunTest() {
		RaphyTest test = RaphyTestHome.getInstance().getByName(testName);
		if(test!=null) {
			test.test(containerEl);
			descEl.setInnerHTML(test.getDescription()); 
		}
		//TODO: else	
	}

	protected void doSeeSources() {
		RaphyTest test = RaphyTestHome.getInstance().getByName(testName);
		if(test==null)
			return ; 
		final ExternalTextResource res0 = test.getResources().values().iterator().next();
		try {
			res0.getText(new ResourceCallback<TextResource>() {				
				@Override
				public void onSuccess(TextResource resource) {
					GUIUtil.showText(res0.getName(), resource.getText()); 
//					Window.alert(resource.getText()); 
				}				
				@Override
				public void onError(ResourceException e) {
					Window.alert("error getting resource. "); 
					e.printStackTrace(); 
				}
			});
		} catch (ResourceException e) {
			Window.alert("exception getting resource. "); 
			e.printStackTrace(); 
		} 
	}

}
