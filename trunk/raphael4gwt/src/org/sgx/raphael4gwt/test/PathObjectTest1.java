package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Attr;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.pathobj.PathObject;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
/**
 * show different types of using the artificial type PathCmd for 
 * programatically create a path in java (using pbjects not string based api)
 * @author sg
 *
 */
public class PathObjectTest1 extends Test {


	@Override
	public void test() {
		PathObject po1 = PathObject.create(10,10);
		po1 = po1.L(50,0).L(0, 50).Z(); 
		Shape path1 = paper.path(po1).attr(new Attr().fill("red")); 
	}
	
	//test stuff

	public PathObjectTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="path object1";
		this.description="pathObject usage example";		
		
	}
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_PATH, GalleryUtil.TAG_EXTENSION};
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.PathObjectTest1().getText();
	}

}
