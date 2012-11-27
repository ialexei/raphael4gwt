package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.svg.filter.Filter;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterFactory;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterOperation;
import org.sgx.raphael4gwt.raphael.svg.filter.params.FilterOperationParam;
import org.sgx.raphael4gwt.raphael.svg.filter.params.Turbulence;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.user.client.ui.TextBox;
/**
 * feTurbulence SVG filter showcase. 
 * @author sg
 *
 */
public class SvgFiltersTurbulence extends Test {
	
	@Override
	public void test() {
		
		//the original - no filter
		Shape shape = paper
				.rect(0,0,120,120);
		Filter filter = paper.filterCreate("filter1");	
		FilterOperationParam param = Turbulence.create()
			.type("turbulence")
			.baseFrequency(0.05)
			.numOctaves(2); 
		FilterOperation fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter.appendOperation(fop); 	
		shape.filterInstall(filter); 
		
		
		shape =  shape.clone().transform("...t0,140"); 		
		param = Turbulence.create()
				.type("turbulence")
				.baseFrequency(0.1)
				.numOctaves(2); 
		fop = FilterFactory.getInstance().createFilterOperation(param); 
		filter = paper.filterCreate("filter2");	
		filter.appendOperation(fop); 	
		shape.filterInstall(filter); 
		
		
		shape =  shape.clone().transform("...t0,140"); 	
		param = Turbulence.create()
				.type("turbulence")
				.baseFrequency(0.05)
				.numOctaves(10); 
		fop = FilterFactory.getInstance().createFilterOperation(param); 
		filter = paper.filterCreate("filter3");	
		filter.appendOperation(fop); 	
		shape.filterInstall(filter); 
		
		shape =  shape.clone().transform("...t140,0"); 	
		param = Turbulence.create()
				.type("fractalNoise")
				.baseFrequency(0.1)
				.numOctaves(4); 
		fop = FilterFactory.getInstance().createFilterOperation(param); 
		filter = paper.filterCreate("filter4");	
		filter.appendOperation(fop); 	
		shape.filterInstall(filter); 
		
		shape =  shape.clone().transform("...t0,-140"); 	
		param = Turbulence.create()
				.type("fractalNoise")
				.baseFrequency(0.5)
				.numOctaves(4); 
		fop = FilterFactory.getInstance().createFilterOperation(param); 
		filter = paper.filterCreate("filter5");	
		filter.appendOperation(fop); 	
		shape.filterInstall(filter);
			
		shape =  shape.clone().transform("...t0,-140"); 	
		param = Turbulence.create()
				.type("fractalNoise")
				.baseFrequency(0.1)
				.numOctaves(1); 
		fop = FilterFactory.getInstance().createFilterOperation(param); 
		filter = paper.filterCreate("filter6");	
		filter.appendOperation(fop); 	
		shape.filterInstall(filter);
	}

	
	//test information:
	@Override
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_SVG, GalleryUtil.TAG_EXTENSION};
	}
	public SvgFiltersTurbulence(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="SvgFiltersTurbulence";
		this.description="feTurbulence SVG filter showcase. ";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.SvgFiltersTurbulence().getText();
	}

}
