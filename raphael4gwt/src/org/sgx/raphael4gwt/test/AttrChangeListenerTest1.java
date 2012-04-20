package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.AttrChangeListener;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;
/**
 * @author sg
 *
 */
public class AttrChangeListenerTest1 extends Test {
	
	private Shape rect;
	
	@Override
	public void test() {
		rect = paper.rect(80,80,200,300).attr(
			Attrs.create().fill("yellow")
		);
		paper.text(100,100, "show a simple example of registering a listener \n" +
				"that will be notified when some type of attribute change value. \n" +
				"click the rectangle to test...");
		rect.addAttrChangeListener("transform", new AttrChangeListener() {			
			@Override
			public void attributeChange(String attrName, Object oldVal, Object newVal) {
				Window.alert("rect transformed from "+oldVal+" to "+newVal);
			}
		});
		rect.click(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				rect.attr(Attrs.create().transform("t100,100"));
			}
		});
	}

	//test information:
	public AttrChangeListenerTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="attr change";
		this.description="shows how to register for attribute change notifications.";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.AttrChangeListenerTest1().getText();
	}

}
