package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.util.UnitUtil;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Window;
/**
 * this example shows how to shapes from json json data to a paper, 
 * and viceversa how to export a paper state to json, using shape and peper add and toJSON methods.
 * @author sg
 *
 */
public class PaperLoadAndSave extends Test{

	@Override
	public void test() {
		paper.circle(100,100,40).attr(Attrs.create().fill("red").strokeWidth(12));
		JsArray<Attrs> save1 = paper.writeToObject();//.toJSON();
		paper.clear();
		paper.add(save1); //import from object
		paper.add( //import from json string
				"[{type:'rect', x:200,y:200,width:300,height:300,fill:'green'}]");
		paper.text(200, 200, "you should see a \"'´ red circle and green rect. ").
			attr("font-size",22);
		
		String src1 = paper.writeToString();
		paper.clear();
		
		Window.alert("Loading string: "+src1);
		paper.add(src1);
	}
	
	//test stuff
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_EXTENSION};
	}
	public PaperLoadAndSave(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="PaperLoadAndSave";
		this.description="this example shows how to shapes from json json data " +
			"to a paper, \nand viceversa how to export a paper state to json, " +
			"using shape and peper add and toJSON methods.";
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.PaperLoadAndSave().getText();
	}

}
