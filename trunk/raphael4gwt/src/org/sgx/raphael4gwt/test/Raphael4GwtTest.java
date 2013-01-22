package org.sgx.raphael4gwt.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.sgx.raphael4gwt.raphael.Circle;
import org.sgx.raphael4gwt.raphael.Constants;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.Text;
import org.sgx.raphael4gwt.raphael.base.Animation;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Glow;
import org.sgx.raphael4gwt.raphael.event.Callback;
import org.sgx.raphael4gwt.raphael.event.DDListener;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;
import org.sgx.raphael4gwt.raphael.util.Util;
import org.sgx.raphael4gwt.test.gallery.MainPanel;
import org.sgx.raphael4gwt.test.gallery.GalleryResources;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Raphael4GwtTest implements EntryPoint {
	static Logger logger = Logger.getLogger("Raphael4GwtTest");
	String attr1 = "world";
	
	@Override
	public void onModuleLoad() {
		testMainPanel();
//		testCustomAttrs();
	}
	private void testMainPanel() {
		RootPanel.get().add(new MainPanel());
	}
	
	
//	private void testCustomAttrs() {
//		Paper p = Raphael.paper(440,140,400,400);
//		
////		testCustomAttrsNative(p);
//		testCustomAttrsNative2(p);
//	}
//	
//	public static interface CA1 {
//		Attrs notify(int d);
//	}
//	public static native final void registerCA1(Paper paper, String attrName, CA1 ca1)/*-{
////		$wnd.ca1=ca1;
//		paper.customAttributes[attrName]=$entry(function(o){
//			
////			$wnd.document.getElementById("anchor1").innerHTML +=
////			" ----- "+ this+" - "+o+" - "+arguments.length;
//		
//		
//			return ca1.@org.sgx.raphael4gwt.test.Raphael4GwtTest.CA1::notify(I)(o);
//		});
//		$wnd.document.getElementById("anchor1").innerHTML +="---"+$wnd.Raphael.is(paper.customAttributes[attrName], "function");
//	}-*/;
// 
//	private void testCustomAttrsNative2(Paper p) {
//		final AnchorElement anchor = Document.get().createAnchorElement();
//		RootPanel.get().getElement().appendChild(anchor);
//		anchor.getStyle().setMargin(20, com.google.gwt.dom.client.Style.Unit.PX);
//		anchor.setId("anchor1");
//		anchor.setInnerText("halksajdlkasjdlkasjd");
//		
//		CA1 ca1 = new CA1() {			
//			@Override
//			public Attrs notify(int d) {	
//				logger.log(Level.SEVERE, "notify: "+d);
//				return Attrs.create().fill("rgb("+d+",100,100)");
//			}
//		};
//		registerCA1(p, "ca1", ca1);
//		
//		Shape rect = p.rect(0,0,200,200).attr(Attrs.create().fill("blue"));
//		rect.setAttribute("ca1", 0);
//		rect.animate(Attrs.create().set("ca1", 233), 1000);
//	}
//
//	private native final void testCustomAttrsNative(Paper p)/*-{
//		var rect = p.rect(20,30,140,150);
//		p.customAttributes["hue"]=function(num) {
//			num=num%1;
//			return {fill: "hsb("+num+", 0.75, 1)"};
//		};
//		
//		rect.attr({hue: 0.1});
//		rect.animate({hue: 0.9}, 2000);
//	}-*/;
//
//
//	
//	
//
//	private void testTest() {
//		VerticalPanel vp = new VerticalPanel();
//		RootPanel.get().add(vp);
//		int pwidth = 500, pheight=500;
//		Paper paper = Raphael.paper(20, 20, pwidth, pheight);
////		new CircleGlowingAndDraggin(paper, pwidth, pheight).test();
//		new EventRegisterAndUnregister(paper, pwidth, pheight).test();
//	}

}
