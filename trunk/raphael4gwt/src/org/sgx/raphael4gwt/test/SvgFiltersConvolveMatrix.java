package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.raphael.svg.filter.Filter;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterFactory;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterOperation;
import org.sgx.raphael4gwt.raphael.svg.filter.params.ConvolveMatrix;
import org.sgx.raphael4gwt.raphael.svg.filter.params.FilterOperationParam;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.dom.client.NativeEvent;
/**
 * feConvolveMatrix filter showcase
 * @author sg
 *
 */
public class SvgFiltersConvolveMatrix extends Test {
	
	@Override
	public void test() {
		paper.text(100, 5, "click the images to zoom in").attr(Attrs.create().fontSize(14).stroke("pink").fontWeight(3)); 
		
		Shape shape0 = paper.image(
//				TestImageResources.INSTANCE.smallLion()
				"http://upload.wikimedia.org/wikipedia/commons/3/3f/Bikesgray.jpg"
				, 20, 20, 130, 110); 
		Shape text0 = paper.text(60,100, "original").attr(Attrs.create()
			.fontSize(18)
			.stroke("rgb(20,20,100)")
			.fill("green")
		);
		registerZommer(shape0);
		
		//the original - no filter
		Shape shape1 = shape0.clone().transform("t140,0"); 
		Filter filter1 = paper.filterCreate("filter1");	
		FilterOperationParam param = ConvolveMatrix.create()
			.order(3)
			.kernelMatrix("-2 -1 0 -1 1 1 0 1 2")
			.bias(0.8).divisor(0.2); 			
		FilterOperation fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter1.appendOperation(fop); 	
		shape1.filterInstall(filter1); 
		text0.clone().transform("t140,0").attr("text", "emboss1"); 
		registerZommer(shape1); 
		
		Shape shape2 = shape0.clone().transform("t280,0"); 
		Filter filter2 = paper.filterCreate("filter2");	
		param = ConvolveMatrix.create()
			.order(3)
			.kernelMatrix("-1 -1 0 -1 0 1 0 1 1")
			.bias(1).divisor(0.2); 			
		fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter2.appendOperation(fop); 	
		shape2.filterInstall(filter2); 
		text0.clone().transform("t280,0").attr("text", "emboss2");
		registerZommer(shape2);
		
		Shape shape3 = shape0.clone().transform("t0,140"); 
		Filter filter3 = paper.filterCreate("filter3");	
		param = ConvolveMatrix.create()
			.order(3)
			.kernelMatrix("0 1 0 1 -4 1 0 1 0")
			.bias(1).divisor(0.2); 			
		fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter3.appendOperation(fop); 	
		shape3.filterInstall(filter3); 
		text0.clone().transform("t0,140").attr("text", "edge1"); 
		registerZommer(shape3);
		
		Shape shape4 = shape0.clone().transform("t140,140"); 
		Filter filter4 = paper.filterCreate("filter4");	
		param = ConvolveMatrix.create()
			.order(3)
			.kernelMatrix("0 -1 0 -1 5 -1 0 -1 0")
			.bias(1).divisor(0.1); 			
		fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter4.appendOperation(fop); 	
		shape4.filterInstall(filter4); 
		text0.clone().transform("t140,140").attr("text", "Sharpen1"); 
		registerZommer(shape4); 
		
		Shape shape5 = shape0.clone().transform("t280,140"); 
		Filter filter5 = paper.filterCreate("filter5");	
		param = ConvolveMatrix.create()
			.order(3)
			.kernelMatrix("1 2 1 0 0 0 -1 -2 -1")
			.bias(1).divisor(0.5); 			
		fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter5.appendOperation(fop); 	
		shape5.filterInstall(filter5); 
		text0.clone().transform("t280,140").attr("text", "SobelH"); 
		registerZommer(shape5); 
		
		Shape shape6 = shape0.clone().transform("t280,280"); 
		Filter filter6 = paper.filterCreate("robertCrossX");	
		param = ConvolveMatrix.create()
			.order(2)
			.kernelMatrix("1 0 0 -1")
			.bias(1).divisor(0.3); 			
		fop = FilterFactory.getInstance().createFilterOperation(param); 	
		fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter6.appendOperation(fop); 
		shape6.filterInstall(filter6); 
		text0.clone().transform("t280,280").attr("text", "robertCrossX"); 
		registerZommer(shape6); 

		//a total rober cross - this is robertCrossX and then robertCrossY - in the same filter. 
		Shape shape7 = shape0.clone().transform("t140,280"); 
		Filter filter7 = paper.filterCreate("robertcrossxy");	
		param = ConvolveMatrix.create()
			.order(2)
			.kernelMatrix("1 0 0 -1")
			.bias(1).divisor(0.3); 			
		fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter7.appendOperation(fop); 	
		param = ConvolveMatrix.create()
				.order(2)
				.kernelMatrix("0 1 -1 0")
				.bias(1).divisor(0.3); 			
		fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter7.appendOperation(fop); 
		shape7.filterInstall(filter7); 
		text0.clone().transform("t140,280").attr("text", "robertCrossXY"); 
		registerZommer(shape7); 
		
		Shape shape8 = shape0.clone().transform("t0,280"); 
		Filter filter8 = paper.filterCreate("robertcrossy");		
		filter8.appendOperation(fop); 	
		param = ConvolveMatrix.create()
				.order(2)
				.kernelMatrix("0 1 -1 0")
				.bias(1).divisor(0.3); 			
		fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter8.appendOperation(fop); 
		shape8.filterInstall(filter8); 
		text0.clone().transform("t0,280").attr("text", "robertCrossY"); 
		registerZommer(shape8); 
		
		final Shape shape9 = shape0.clone().transform("t420,0"); 
		Filter filter9 = paper.filterCreate("log1");		
		filter9.appendOperation(fop); 	
		param = ConvolveMatrix.create()
				.order(9)
				.kernelMatrix(
						
					" 0 1 1 2 2 2 1 1 0" +
					" 1 2 4 5 5 5 4 2 1 "+
					" 1 4 5 3 0 3 5 4 1 "+
					" 2 5 3 -12 -24 -12 3 5 2 "+
					" 2 5 0 -24 -40 -24 0 5 2 "+
					" 2 5 3 -12 -24 -12 3 5 2 "+
					" 1 4 5 3 0 3 5 4 1 "+
					" 1 2 4 5 5 5 4 2 1 "+
					" 0 1 1 2 2 2 1 1 0" )
				.bias(1).divisor(1); 			
		fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter9.appendOperation(fop); 
		shape9.filterInstall(filter9); 
		text0.clone().transform("t420,0").attr("text", "LoG");
		registerZommer(shape9); 
		
		
		
		
	}

	
	private void registerZommer(final Shape s) {
		s.click(new MouseEventListener() {			
			@Override
			public void notifyMouseEvent(NativeEvent e) {
				if(s.getData("maximized")!=null) {
					s.hide(); 
					s.toBack(); 
				}
				else {
					s.transform("T120,120s4,4");
					s.toFront();
					s.setData("maximized", "true");
				}
			}
		}); 
	}


	//test information:
	@Override
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_SVG, GalleryUtil.TAG_EXTENSION};
	}
	public SvgFiltersConvolveMatrix(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="SvgFiltersConvolveMatrix";
		this.description="feConvolveMatrix filter showcase";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.SvgFiltersConvolveMatrix().getText();
	}

}
