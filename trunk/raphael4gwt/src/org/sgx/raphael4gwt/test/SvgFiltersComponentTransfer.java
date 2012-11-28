package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.svg.filter.Filter;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterFactory;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterOperation;
import org.sgx.raphael4gwt.raphael.svg.filter.params.ComponentTransfer;
import org.sgx.raphael4gwt.raphael.svg.filter.params.FilterOperationParam;
import org.sgx.raphael4gwt.raphael.svg.filter.params.Turbulence;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.image.TestImageResources;

import com.google.gwt.user.client.ui.TextBox;
/**
 * SvgFiltersComponentTransfer 
 * @author sg
 *
 */
public class SvgFiltersComponentTransfer extends Test {
	
	@Override
	public void test() {
		
		//the original - no filter
		Shape shape = paper
				
				.image(
						TestImageResources.INSTANCE.smallLion()
//						"http://upload.wikimedia.org/wikipedia/commons/3/3f/Bikesgray.jpg"
						, 0, 0, 150,150); 
//			.rect(0,0,120,120).attr(Attrs.create().fill("90-#fff-#000"));
		
		Shape shape1 = shape.clone().transform("t150,0"); 
		Filter filter1 = paper.filterCreate("filter1");	
		FilterOperationParam param = ComponentTransfer.create()
			.funcR(
				ComponentTransfer.Function.create().type("linear").slope(0.5).intercept(0.25)
			)
			.funcG(
				ComponentTransfer.Function.create().type("linear").slope(0.9).intercept(0.75)
			)
			.funcB(
				ComponentTransfer.Function.create().type("linear").slope(0.6).intercept(0.45)
			);  
		FilterOperation fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter1.appendOperation(fop); 	
		shape1.filterInstall(filter1); 
		
		
	}

	
	//test information:
	@Override
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_SVG, GalleryUtil.TAG_EXTENSION};
	}
	public SvgFiltersComponentTransfer(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="SvgFiltersComponentTransfer";
		this.description="SvgFiltersComponentTransfer ";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.SvgFiltersTurbulence().getText();
	}

}
