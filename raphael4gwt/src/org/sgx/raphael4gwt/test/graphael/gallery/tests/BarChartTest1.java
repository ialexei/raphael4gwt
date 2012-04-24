package org.sgx.raphael4gwt.test.graphael.gallery.tests;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.bar.BarChart;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.raphael.util.ShapeUtil;
import org.sgx.raphael4gwt.raphael.util.Util;
import org.sgx.raphael4gwt.test.Test;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;
/**
 * simple barchart example
 * @author sg
 *
 */
public class BarChartTest1 extends Test {	
	
 
	@Override
	public void test() {
		
		double[][] vals = new double[][]{
			{55, 20, 13, 32, 5, 1, 2, 10}
		};
		
		getPaper().text(100,600, "click the chart for painting it...");
		final BarChart barchart = getGPaper().barchart(100,100,400,400, vals);
		
		//because charts are set we can iterate and paint each row.
		barchart.attr("transform", "s1,1");
		barchart.click(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				Shape firstShape = ShapeUtil.getFirstShape(barchart);
				String transform = firstShape.getAttribute("transform");

				if(transform!=null && !transform.equals("s1,1")) {
					
					barchart.animate(Attrs.create().
							transform("s1,1").
							fill(randomColor()), 
						500, ">"
					);
				}
				else {
					barchart.animate(Attrs.create().
							transform("s0.5,0.5").
							fill(randomColor()), 
						500, ">"
					);
				}
			}
		});
		barchart.label(new String[][]{{"asd", "sdf", "dfg", "wer", "asd", "sdf", "dfg", "wer"}}, true);
		
		
	}

	//test class stuff
	public BarChartTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		setName("bar1");
		setDescription("simple bar chart example");
	}
	GPaper getGPaper() {
		return (GPaper)paper;
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.BarChartTest1().getText();
	}

}
