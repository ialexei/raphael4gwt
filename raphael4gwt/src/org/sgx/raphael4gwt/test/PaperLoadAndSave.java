package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.util.UnitUtil;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Window;
/**
 * this example shows how to shapes from json json params to a paper, 
 * and viceversa how to export a paper state to json, using shape and peper add and toJSON methods.
 * @author sg
 *
 */
public class PaperLoadAndSave extends Test{

	@Override
	public void test() {
//		test1(); 
		
		test2(); 
	}
	
	private void test2() {
		String s = "[{\"type\":\"rect\",\"x\":\"400\",\"y\":\"400\",\"width\":\"300\",\"height\":\"300\",\"r\":\"0\",\"rx\":\"0\",\"ry\":\"0\",\"fill\":\"none\",\"stroke\":\"#000\",\"stroke-width\":\"1\",\"transform\":\"\",\"type\":\"rect\"}]";

		paper.add(s);

		Set list = paper.getAllShapes();

		for (int i = 0; i < list.size(); i++) {
			Shape shape = list.item(i);
			System.out.println(shape.getType() + " ; x:" + shape.getBBox().getX() + " ; y:" + shape.getBBox().getY());
		}
	}

	private void test1() {
		paper.circle(100,100,40).attr(Attrs.create().fill("red").strokeWidth(12));
		JsArray<Attrs> save1 = paper.writeToObject();//.toJSON();
		paper.clear();
		paper.add(save1); //import from object
		
		String jsonStr1 = "[{type:'rect', x:200,y:200,width:300,height:300,fill:'green'}]";		
		paper.add( jsonStr1	);
		Window.alert("importing json: \n"+jsonStr1+"\n - and now the paper json export is: \n"+paper.writeToString());
		
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
		this.description="this example shows how to shapes from json json params " +
			"to a paper, \nand viceversa how to export a paper state to json, " +
			"using shape and peper add and toJSON methods.";
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.PaperLoadAndSave().getText();
	}

}
