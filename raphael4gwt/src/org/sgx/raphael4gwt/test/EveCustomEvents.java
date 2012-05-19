package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.eve.AbstractEvent;
import org.sgx.raphael4gwt.raphael.eve.Eve;
import org.sgx.raphael4gwt.raphael.eve.EveEvent;
import org.sgx.raphael4gwt.raphael.eve.EveEventInstantiator;
import org.sgx.raphael4gwt.raphael.eve.EveListener;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;
import org.sgx.raphael4gwt.raphael.util.Util;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.user.client.Window;

/**
 * int this example we show how to create a custom event type and event listeners class, 
 * like the ones created for raphael predefined events like raphael.attr, raphael.event, etc
 * @author sg
 *
 */
public class EveCustomEvents extends Test {

/**
 * MyEveEvent1 is an custom event definition example. It has the event name prefix "foo.bar.click",
 * and has 1 attribute param1 (eve event parameter).The complete event name is foo.bar.click.(param1||*); 
 * @author sebastian
 *
 */
class MyEveEvent1 extends AbstractEvent {
	int param1;
	public MyEveEvent1(){
		super();
	}
	
	public MyEveEvent1(int param1) {
		super();
		this.param1 = param1;
	}
	public int getParam1() {
		return param1;
	}
	public void setParam1(int param1) {
		this.param1 = param1;
	}
	@Override
	public String getName() {
		return "foo.bar.click."+(param1<0?"*":param1);
	}	
	//the folowing to methods are neccesary to be implemented for comunication with native eve,
	@Override
	public void fromJsArray(JsArrayMixed jsa) {
		setParam1((int) jsa.getNumber(0));
	}
	@Override
	public JsArrayMixed toJsArray() {
		JsArrayMixed jsa = JsArrayMixed.createArray().<JsArrayMixed>cast();
		jsa.push(param1);
		return jsa;
	}		
}

abstract class MyEveEvent1Listener extends EveListener<MyEveEvent1> {
	@Override
	public EveEventInstantiator<MyEveEvent1> getEventInstantiator() {
		return new EveEventInstantiator<EveCustomEvents.MyEveEvent1>() {
			@Override
			public EveEvent instantiate() {
				return new MyEveEvent1();
			}				
		};
	}		
}

@Override
public void test() {
	Util.cleanTests();
	
	Eve.on("foo.bar.click.*", new MyEveEvent1Listener() {			
		@Override
		public Object call(MyEveEvent1 e) {
			return "listener1";
		}
	});
	Eve.on("foo.bar.click.41", new MyEveEvent1Listener() {			
		@Override
		public Object call(MyEveEvent1 e) {
			return "listener2";
		}
	});
	Eve.on("foo.bar.click.42", new MyEveEvent1Listener() {			
		@Override
		public Object call(MyEveEvent1 e) {
			return "listener3";
		}
	});
	
	//trigger
	JsArrayMixed triggerReturn = Eve.trigger(new MyEveEvent1(41));
	
	Util.assertTrue(JsUtil.arrayContains(triggerReturn, "listener1"), "custom event test 1");
	Util.assertTrue(JsUtil.arrayContains(triggerReturn, "listener2"), "custom event test 2");
	Util.assertTrue(!JsUtil.arrayContains(triggerReturn, "listener3"), "custom event test 3");
	
	Window.alert(Util.printAssertsFailed());
}

//test stuff

@Override
public String[] getTags() {
	return new String[]{GalleryUtil.TAG_EVENT, GalleryUtil.TAG_EVE, GalleryUtil.TAG_EXTENSION};
}
@Override
public String getJavaClassSource() {
	return TestResources.INSTANCE.EveTest1().getText();
}

public EveCustomEvents(Paper paper, int paperWidth, int paperHeight) {
	super(paper, paperWidth, paperHeight);
	this.name="EveCustomEvents";
	this.description="EveCustomEvents";		
}

}
