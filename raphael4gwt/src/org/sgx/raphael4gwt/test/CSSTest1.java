package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Circle;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Rect;
import org.sgx.raphael4gwt.raphael.Text;
import org.sgx.raphael4gwt.raphael.base.CSSRule;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Window;

public class CSSTest1 extends Test{

	@Override
	public void test() {
		Circle c1 = paper.circle(90,120,40);
		c1.data("class1234", "value2345"); 
		Rect r1 = paper.rect(100,100,200,230); 
		Text t1 = paper.text(200, 100, "Luis said, \"I'm the state\"");
		t1.data("class", "c1"); 
		
		paper.styleAdd("sty1", 
			"rect, circle {fill: blue; opacity: 0.4, stroke-width: 12px, stroke: green}" +
			".c1 {font-size: 16px; font-weight: bolder}" +
			"[class1234=value2345] {stroke: yellow; stroke-width: 3px}"
		,true); 
		
		Window.alert("Now manipulate the stylesheet programatically\n and then re apply style to reflect changes..."); 
		JsArray<CSSRule> sty1 = paper.styleGet("sty1");
		
		//get the first rule object - rule1.getSelector()=="rect, circle"
		CSSRule rule1 = sty1.get(0);
		//modify its value 
		rule1.getValue().strokeWidth(22).strokeDashArray("-..").opacity(0.2);
		
		//delete the 3rd rule ([class1234=value2345])
		JsUtil.arrayRemoveItem(sty1, 2); 
		
		//recall paper.styleApply for reflecting stylesheet changes
		paper.styleApply("sty1"); 
		
		
	}
	
	//test stuff
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_EXTENSION};
	}
	public CSSTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="CSS 1";
		this.description="show how to use paper.style* methods for managing raphael CSS stylesheets.";
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.CSSTest1().getText();
	}

}
