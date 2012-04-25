package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Rect;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.util.UnitUtil;

import com.google.gwt.user.client.Window;

/**
 * shape unit like tests
 * @author sg
 */
public class ShapeUnitTest1 extends Test {

	@Override
	public void test() {
		
		UnitUtil testCase1 = new UnitUtil();
		String results = null;
		
		try {
			Rect rect1 = paper.rect(30,40, 50, 60), 
				rect2 = paper.rect(130,140, 50, 60);
			
			testCase1.assertEquals(30, Integer.parseInt(rect1.getAttribute("x")), "attr1");
			
			testCase1.assertEquals("", rect1.getAttribute("transform"), "attr2");
			
			rect1.attr(Attrs.create().transform("r33"));
			
			testCase1.assertEquals("r33", rect1.getAttribute("transform"), "attr3");
			
			Set set1 = paper.set();
			set1.push(rect1);
			set1.push(rect2);
			
			testCase1.assertEquals("", rect2.getAttribute("transform"), "attr4");
			
			set1.attr(Attrs.create().transform("r55"));
			
			testCase1.assertEquals("r55", rect2.getAttribute("transform"), "attr5");
			
			results = testCase1.printResults();
			
		} catch (Exception e) {
			
			results = "Exception before test end: "+e+
				" - results till throw: "+testCase1.printResults();
		}		
		
		Window.alert("test results: "+results);
	}
	
	
	//test data:
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_SHAPE};
	}
	public ShapeUnitTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="ShapeUnit1";
		this.description="shape unit like tests";
		
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.ShapeUnitTest1().getText();
	}

}
