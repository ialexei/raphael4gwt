package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.*;
import org.sgx.raphael4gwt.raphael.base.*;
import org.sgx.raphael4gwt.raphael.eve.AttrChangeEvent;
import org.sgx.raphael4gwt.raphael.eve.AttrChangeListener;
import org.sgx.raphael4gwt.raphael.eve.Eve;
import org.sgx.raphael4gwt.raphael.eve.EveEvent;
import org.sgx.raphael4gwt.raphael.eve.EveListener;
import org.sgx.raphael4gwt.raphael.eve.MouseEveEvent;
import org.sgx.raphael4gwt.raphael.eve.MouseEveListener;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;
import org.sgx.raphael4gwt.raphael.util.Util;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.user.client.Window;
/**
 * @author sg
 *
 */
public class EveEventsTest1 extends Test {
	
	private Shape rect;
	
	int flag=0;
	
	@Override
	public void test() {
		Util.cleanTests();
		rect = paper.rect(80,80,200,300).attr(
			Attrs.create().fill("yellow")
		);
		Eve.on("raphael.event.click."+rect.getId(), new MouseEveListener() {			
			@Override
			public Object call(MouseEveEvent e) {
//				Window.alert("click in rect1 detected - shapeid: "+e.getShape().getId()+
//						", coords: "+JsUtil.print(e.getEvent()));
				flag++;
				return null;
			}
		});
		
		Util.assertEquals(0, flag, "eve attr event 1");
		
		//trigger an event programtically
		MouseEveEvent me1 = new MouseEveEvent();
//		me1.set
//		Eve.trigger();
		Util.assertEquals(0, flag, "eve attr event 1");
//		Window.alert(Util.printAssertsFailed());
		
	}

	//test information:
	@Override
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_EVENT, GalleryUtil.TAG_EXTENSION, GalleryUtil.TAG_EVE};
	}
	public EveEventsTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="eve events 1";
		this.description="shows how to use eve for events like click, etc";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.EveEventsTest1().getText();
	}

}
