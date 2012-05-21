package org.sgx.raphael4gwt.gtest.gallery.tests;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.bar.BarChart;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;
import org.sgx.raphael4gwt.gtest.gallery.Test;

import com.google.gwt.dom.client.NativeEvent;
/**
 * simple barchart example
 * @author sg
 *
 */
public class BarChartTest1 extends Test {	
	static Logger logger = Logger.getLogger("BarChartTest1");
 
	@Override
	public void test() {
		
		double[][] vals = new double[][]{
			{55, 20, 13, 32, 5, 1, 2, 10}
		};
		
		getPaper().text(100,600, "click the chart for painting it...");
		final BarChart barchart = getGPaper().barchart(100,100,400,400, vals);
		logger.log(Level.SEVERE, barchart.print());
		
		//because charts are set we can iterate and paint each row.
		barchart.attr("transform", "s1,1");
		barchart.click(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				Shape fs = barchart.firstShape();
				String transform = fs.getAttribute("transform");
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
		barchart.label(new String[][]{{"c++", "java", "python", "smalltalk", "lisp", 
			"javascript", "perl", "shall"}}, true);
		
		
	}

	//test class stuff
	public BarChartTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		setName("bar1");
		setDescription("simple bar chart example");
	}
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.BarChartTest1().getText();
	}

}
