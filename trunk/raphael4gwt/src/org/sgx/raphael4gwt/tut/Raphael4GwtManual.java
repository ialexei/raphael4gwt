package org.sgx.raphael4gwt.tut;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Raphael4GwtManual extends Composite {

	private static GwtEditorsManualUiBinder uiBinder = GWT.create(GwtEditorsManualUiBinder.class);

	interface GwtEditorsManualUiBinder extends UiBinder<Widget, Raphael4GwtManual> {
	}

	public Raphael4GwtManual() {
		initWidget(uiBinder.createAndBindUi(this));
		addAttachHandler(new AttachEvent.Handler() {

			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if (event.isAttached()) {
					init();
				}
			}
		});
	}

	protected void init() {
//		prettyPrint();
		makeTOC();
	}

	private void makeTOC() {
//		HourMinutePicker time=new HourMinutePicker(PickerFormat._12_HOUR);
//		RootPanel.get().add(time); 
		
//		TimeBox timePicker = new TimeBox(new Date());
//		RootPanel.get().add(timePicker);
		
//		Element container = Document.get().getElementById("toc");		
//		NodeList<Element> titles1 = Document.get().getBody().getElementsByTagName("h2");
//		for (int i = 0; i < titles1.getLength(); i++) {
//			Element title = titles1.getItem(i);
//			if(title.getId()==null||title.getId().equals("")) 
//				title.setId("toc_title_"+i);
//			String id = title.getId();
//			AnchorElement anchor = Document.get().createAnchorElement();
//			anchor.setHref("#"+id); 
//			anchor.setInnerHTML(title.getInnerHTML()); 
//			container.appendChild(anchor);
////			container.appendChild(Document.get().createBRElement()); 
//			
//		}
		
		Element container = Document.get().getElementById("toc");	
		Element tocRoot = Document.get().getElementById("gwteditorsManualMain");		
		Toc toc = new Toc(container, tocRoot);
		toc.make(); 
	}

//	public static native final void prettyPrint()/*-{
//		$wnd.prettyPrint();
//	}-*/;
	
//	public static native final String prettyPrintOne(String s)/*-{
//		return $wnd.prettyPrintOne(s);
//	}-*/;
	
//	public static native final void prettyPrint(JavaScriptObject el)/*-{
//	$wnd.prettyPrint(el);
//}-*/;
}
