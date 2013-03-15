package org.sgx.raphael4gwt.raphael.widget;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.HasAllKeyHandlers;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class PaperWidget extends Composite /*implements 
Focusable, HasAllKeyHandlers*/ 
{

	private static PaperWidgetUiBinder uiBinder = GWT.create(PaperWidgetUiBinder.class);

	interface PaperWidgetUiBinder extends UiBinder<Widget, PaperWidget> {
	}

	@UiField
	Element paperEl;
	
//	@UiField
//	FocusPanel container;
	
	Paper paper = null;
	int paperWidth, paperHeight; 

	@UiConstructor public PaperWidget(int paperWidth, int paperHeight) {
		this.paperWidth=paperWidth; 
		this.paperHeight=paperHeight; 
		initWidget(uiBinder.createAndBindUi(this));
		createPaper();
	}

	public PaperWidget() {
		this(0, 0);
	}


	private Paper createPaper() {
		if (paper == null && paperWidth > 0 && paperHeight > 0)
			paper = Raphael.paper(paperEl, paperWidth, paperHeight);
		return paper;
	}

	public Paper getPaper() {
		return paper;
	}
	
//	/**
//	 * 
//	 * @return
//	 */
//	public Paper createPaper() {
//		if (paper == null && paperWidth > 0 && paperHeight > 0)
//			paper = Raphael.paper(paperEl, paperWidth, paperHeight);
//		return paper;
//	}
	public void setPaperHeight(int paperHeight) {
		this.paperHeight = paperHeight;
	}

	public void setPaperWidth(int paperWidth) {
		this.paperWidth = paperWidth;
	}

//	@Override
//	public int getTabIndex() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void setAccessKey(char key) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setFocus(boolean focused) {
//		container.setFocus(focused); 
//		//		if(focused)
////			paperEl.focus(); 
//	}
//
//	@Override
//	public void setTabIndex(int index) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {
//		return container.addKeyUpHandler(handler); 
////		 return addDomHandler(handler, KeyUpEvent.getType());
//	}
//	public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
//		return container.addKeyDownHandler(handler);
////	    return addDomHandler(handler, KeyDownEvent.getType());
//	  }
//
//
//	@Override
//	public HandlerRegistration addKeyPressHandler(KeyPressHandler handler) {
//		return container.addKeyPressHandler(handler);		
////		return addDomHandler(handler, KeyPressEvent.getType());
//	}
//
////	@Override
////	public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
////		// TODO Auto-generated method stub
////		return null;
////	}


	

}
