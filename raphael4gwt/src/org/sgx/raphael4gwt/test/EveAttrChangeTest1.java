package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.*;
import org.sgx.raphael4gwt.raphael.base.*;
import org.sgx.raphael4gwt.raphael.eve.AttrChangeEvent;
import org.sgx.raphael4gwt.raphael.eve.AttrChangeListener;
import org.sgx.raphael4gwt.raphael.eve.Eve;
import org.sgx.raphael4gwt.raphael.eve.EveEvent;
import org.sgx.raphael4gwt.raphael.eve.EveListener;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;
import org.sgx.raphael4gwt.raphael.util.Util;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.user.client.Window;
/**
 * @author sg
 *
 */
public class EveAttrChangeTest1 extends Test {
	
	private Shape rect;
	
	String flag="";
	
	@Override
	public void test() {
		Util.cleanTests();
		rect = paper.rect(80,80,200,300).attr(
			Attrs.create().fill("yellow")
		);
		Eve.on("raphael.attr.fill."+rect.getId(), new AttrChangeListener() {			
			@Override
			public Object call(AttrChangeEvent e) {
//				Window.alert(e+" - "+JsUtil.print(e.getData()));
				flag = e.getNewValue()+"";
				return "listener 1";
			}
		});
		
		rect.attr(Attrs.create().fill("red"));
		Util.assertEquals("red", flag, "eve attr event 1");
		Util.assertTrue(flag.equals("red"), "eve attr event 1.1");
		
		//now change an attribute by triggering the event raphael.attr.fill
		JsArrayMixed ret = Eve.trigger(new AttrChangeEvent(rect, "fill", "blue"));
		
		Util.assertTrue(JsUtil.arrayContains(ret, "listener 1"), "eve attr event 2");
		
		Window.alert(Util.printAssertsFailed());
		
//		if(!JsUtil.arrayContains(listenerReturns, "listener 1"))
//			Window.alert("Error: one listener returned missed");
	}

	//test information:
	@Override
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_EVENT, GalleryUtil.TAG_EXTENSION, GalleryUtil.TAG_EVE};
	}
	public EveAttrChangeTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="attr change";
		this.description="shows how to register for attribute change notifications.";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.AttrChangeListenerTest1().getText();
	}

}
