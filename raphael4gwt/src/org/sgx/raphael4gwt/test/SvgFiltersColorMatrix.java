package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;
import org.sgx.raphael4gwt.raphael.svg.filter.Filter;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterFactory;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterOperation;
import org.sgx.raphael4gwt.raphael.svg.filter.params.ColorMatrix;
import org.sgx.raphael4gwt.raphael.svg.filter.params.FilterOperationParam;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.image.TestImageResources;

import com.google.gwt.dom.client.NativeEvent;
/**
 * SvgFiltersColorMatrix
 * @author sg
 *
 */
public class SvgFiltersColorMatrix extends Test {
	
	@Override
	public void test() {
		paper.text(100, 5, "click the images to zoom in").attr(Attrs.create().fontSize(14).stroke("pink").fontWeight(3));
		
		//the original - no filter
		Shape shape = paper				
			.image(
						TestImageResources.INSTANCE.smallLion()
//						"http://upload.wikimedia.org/wikipedia/commons/3/3f/Bikesgray.jpg"
				, 0, 30, 150,150); 
		Shape text0 = paper.text(60,100, "original").attr(Attrs.create()
			.fontSize(18)
			.stroke("rgb(20,20,100)")
			.fill("green")
		);
		
		
		Shape shape1 = shape.clone().transform("t150,0"); 
		Filter filter1 = paper.filterCreate("filter1");	
		FilterOperationParam param = ColorMatrix.create()
			.type(ColorMatrix.TYPE_MATRIX)
			.values(".73 .13 .33 0 0 " +
					".33 .43 .33 0 0 " +
					".33 .23 .73 0 0 " +
					".33 .33 .33 0 0"); 
		FilterOperation fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter1.appendOperation(fop); 	
		shape1.filterInstall(filter1); 
		text0.clone().transform("t140,0").attr("text", "matrix"); 
		registerZommer(shape1); 
		
		
		Shape shape2 = shape.clone().transform("t300,0"); 
		Filter filter2 = paper.filterCreate("filter2");	
		param = ColorMatrix.create()
			.type(ColorMatrix.TYPE_SATURATE)
			.values(".4"); 
		fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter2.appendOperation(fop); 	
		shape2.filterInstall(filter2); 
		text0.clone().transform("t300,0").attr("text", "saturate .4"); 
		registerZommer(shape2); 
		
		Shape shape3 = shape.clone().transform("t0,150"); 
		Filter filter3 = paper.filterCreate("filter3");	
		param = ColorMatrix.create()
			.type(ColorMatrix.TYPE_HUEROTATE)
			.values("90"); 
		fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter3.appendOperation(fop); 	
		shape3.filterInstall(filter3); 
		text0.clone().transform("t0,150").attr("text", "hueRotate 90"); 
		registerZommer(shape3); 
		
		Shape shape4 = shape.clone().transform("t150,150"); 
		Filter filter4 = paper.filterCreate("filter4");	
		param = ColorMatrix.create()
			.type(ColorMatrix.TYPE_LUMINANCETOALPHA)
			.values("90"); 
		fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter4.appendOperation(fop); 	
		shape4.filterInstall(filter4); 
		text0.clone().transform("t150,150").attr("text", "luminanceToAlpha"); 
		registerZommer(shape4); 
		
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
	public SvgFiltersColorMatrix(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="SvgFiltersColorMatrix";
		this.description="SvgFiltersColorMatrix ";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.SvgFiltersColorMatrix().getText();
	}

}
