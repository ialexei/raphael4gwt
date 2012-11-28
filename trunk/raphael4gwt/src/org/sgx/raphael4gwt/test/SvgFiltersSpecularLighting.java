package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.svg.filter.Filter;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterFactory;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterOperation;
import org.sgx.raphael4gwt.raphael.svg.filter.params.ComponentTransfer;
import org.sgx.raphael4gwt.raphael.svg.filter.params.FilterOperationParam;
import org.sgx.raphael4gwt.raphael.svg.filter.params.light.PointLight;
import org.sgx.raphael4gwt.raphael.svg.filter.params.light.SpecularLighting;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.image.TestImageResources;
/**
 * SvgFiltersSpecularLighting 
 * @author sg
 *
 */
public class SvgFiltersSpecularLighting extends Test {
	
	@Override
	public void test() {
		
		//the original - no filter
		Shape shape = paper.image(
			TestImageResources.INSTANCE.smallLion(), 0, 0, 150, 150
		); 
		Shape mask = paper.rect(0,0,150,150).attr(Attrs.create().stroke("none")); 
		
		String t = "t150,0"; 
		Shape shape1 = shape.clone().transform(t);//paper.rect(0,0,150,150).attr(Attrs.create().stroke("none"));//shape.clone().transform("t150,0");
		Shape mask1 = mask.clone().transform(t); 		
		Filter filter1 = paper.filterCreate("filter1");	
		FilterOperationParam param = SpecularLighting.create()
				.specularExponent(25)
				.lightningColor("pink").lightSource(PointLight.create().x(50).y(50).z(50)); 		
		FilterOperation fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter1.appendOperation(fop); 	
		mask1.filterInstall(filter1); 
		
		
		t = "t300,0"; 
		Shape shape2 = shape.clone().transform(t);//paper.rect(0,0,150,150).attr(Attrs.create().stroke("none"));//shape.clone().transform("t150,0");
		Shape mask2 = mask.clone().transform(t); 		
		Filter filter2 = paper.filterCreate("filter2");	
		param = SpecularLighting.create()
				.specularExponent(125)
				.lightningColor("blue").lightSource(PointLight.create().x(110).y(110).z(150)); 		
		fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter2.appendOperation(fop); 	
		mask2.filterInstall(filter2); 
		
	}

	
	//test information:
	@Override
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_SVG, GalleryUtil.TAG_EXTENSION};
	}
	public SvgFiltersSpecularLighting(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="SvgFiltersSpecularLighting";
		this.description="SvgFiltersSpecularLighting";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.SvgFiltersSpecularLighting().getText();
	}

}
