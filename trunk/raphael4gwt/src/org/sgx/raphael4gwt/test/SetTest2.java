package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Rect;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;
import org.sgx.raphael4gwt.raphael.util.ShapeUtil;
import org.sgx.raphael4gwt.test.util.UnitUtil;

import com.google.gwt.user.client.Window;

/**
 * advanced set API demo and unit testing
 * @author sg
 */
public class SetTest2 extends Test {


	protected Shape first;
	private int counter;

	@Override
	public void test() {
		
		UnitUtil testCase1 = new UnitUtil();
		
		Rect rect1 = paper.rect(30,40, 50, 60), 
			rect2 = paper.rect(130,140, 50, 60);
		
		rect1.setData("data1", "rect1");
		rect2.setData("data1", "rect2");
		
		Set set1 = paper.set();
		set1.push(rect1);
		set1.push(rect2); 
		testCase1.assertEquals(2, set1.size(),"1");
		
		counter=0;
		set1.forEach(new ForEachCallback() {			
			@Override
			public boolean call(Shape shape, int index) {
				counter++;
				return false;
			}
		});
		testCase1.assertEquals(1, counter, "1.5");
		
		set1.filter(new ForEachCallback() {	//removes rect2
			@Override
			public boolean call(Shape shape, int index) {				
				boolean b = shape.getData("data1")!=null && 
						shape.getData("data1").equals("rect2");
				return b;
			}
		});
		
//		Window.alert(ShapeUtil.printSet(set1, new ShapeUtil.ShapePrinter() {					
//			@Override
//			public String print(Shape s) {						
//				return "{type: "+s.getType()+", class: "+s.getData("data1")+"}, ";
//			}
//		}));
		
		
		testCase1.assertEquals(1, set1.size(), "2");
		testCase1.assertEquals("rect1", getFirst(set1).getData("data1"), "3");
		
		Window.alert("test results: "+testCase1.printResults());
	}
	
	public Shape getFirst(Set s) {
		first = null;
		s.forEach(new ForEachCallback() {			
			@Override
			public boolean call(Shape shape, int index) {
				first=shape;
				return false;
			}
		});
		return first;
	}

	//test data:
	public SetTest2(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="Set 2";
		this.description="advanced set API demo and unit testing";
		
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.SetTest2().getText();
	}

}
