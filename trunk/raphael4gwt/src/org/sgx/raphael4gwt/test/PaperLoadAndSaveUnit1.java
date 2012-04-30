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
public class PaperLoadAndSaveUnit1 extends Test{

	@Override
	public void test() {
		UnitUtil test = new UnitUtil(PaperLoadAndSaveUnit1.class.getName());
		
		test.assertEquals(0, paper.writeToObject().length(), "writeObject0");
		
		paper.circle(100,100,40).attr(Attrs.create().fill("red").strokeWidth(12));
		
		JsArray<Attrs> save1 = paper.writeToObject();//.toJSON();
		test.assertEquals(1, save1.length(), "writeObject1");
		
		paper.clear();
		test.assertEquals(0, paper.writeToObject().length(), "writeObject2");
		
		paper.add(save1); //import from object
		test.assertEquals(1, paper.writeToObject().length(), "writeObject3");
		paper.add( //import from json string
				"[{type:'rect', x:200,y:200,width:300,height:300,fill:'green'}]");
		test.assertEquals(2, paper.writeToObject().length(), "writeObject4");
		
		paper.text(200, 200, "you should see a \"'´ red circle and green rect. ").
			attr("font-size",22);
		test.assertEquals(3, paper.writeToObject().length(), "writeObject5");
		
		String src1 = paper.writeToString();
		paper.clear();
		test.assertEquals(0, paper.writeToObject().length(), "writeObject6");
		
//		Window.alert("Loading string: "+src1);
		paper.add(src1);
		test.assertEquals(3, paper.writeToObject().length(), "writeObject7");
		
		Window.alert("test results: "+test.printResults());
	}
	
	//test stuff
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_EXTENSION};
	}
	public PaperLoadAndSaveUnit1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="PaperLoadAndSave2";
		this.description="this junit like test example " +
			"shows how to shapes from json json data " +
			"to a paper, \nand viceversa how to export a paper state to json, " +
			"using shape and peper add and toJSON methods.";
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.PaperLoadAndSaveUnit1().getText();
	}

}
