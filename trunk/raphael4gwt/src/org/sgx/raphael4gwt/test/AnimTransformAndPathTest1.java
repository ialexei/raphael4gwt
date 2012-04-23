package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Animation;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.Callback;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;
import org.sgx.raphael4gwt.test.image.IconPaths;

import com.google.gwt.user.client.Window;

public class AnimTransformAndPathTest1 extends Test {

	
	@Override
	public void test() {
		Path alarm1 = paper.path(IconPaths.alarm);		
		
		//create an attribute object a la javascript:
		Attrs now = (Attrs) JsUtil.obj(
			"fill", "red", 
			"transform", "t200,100"
		);
		Attrs future1 = (Attrs) JsUtil.obj(
			"fill", "green", 
			"transform", "t400,400,s4.0,4.0"
		);
		
		alarm1.attr(now);
		Animation animation1 = Raphael.animation(
				future1, 2000, Raphael.EASING_BACKIN, new Callback() {					
				@Override
				public void call(Shape src) {
					Window.alert("transformation finished - src is : "+src.getType());
				}
		});
		alarm1.animate(animation1);
		
	}
	
	//test stuff
	public AnimTransformAndPathTest1(Paper paper, int paperWidth,
			int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="anim1";
		this.description="anim transform and path with test.";
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.AnimTransformAndPathTest1().getText();
	}

}
