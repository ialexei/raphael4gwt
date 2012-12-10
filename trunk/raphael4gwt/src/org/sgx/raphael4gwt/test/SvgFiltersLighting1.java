package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.svg.filter.Filter;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterFactory;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterOperation;
import org.sgx.raphael4gwt.raphael.svg.filter.params.ComponentTransfer;
import org.sgx.raphael4gwt.raphael.svg.filter.params.Composite;
import org.sgx.raphael4gwt.raphael.svg.filter.params.FilterOperationParam;
import org.sgx.raphael4gwt.raphael.svg.filter.params.Merge;
import org.sgx.raphael4gwt.raphael.svg.filter.params.light.DiffuseLighting;
import org.sgx.raphael4gwt.raphael.svg.filter.params.light.PointLight;
import org.sgx.raphael4gwt.raphael.svg.filter.params.light.SpecularLighting;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.image.TestImageResources;
/**
 * SvgFiltersSpecularLighting 
 * @author sg
 *
 */
public class SvgFiltersLighting1 extends Test {
	
	@Override
	public void test() {
		int M = 150; 
		//the original - no filter
		Shape shape = paper.image(
			TestImageResources.INSTANCE.smallLion(), 0, 0, M, M
		); 
		Shape mask = paper.rect(0,0,M,M).attr(Attrs.create().stroke("none")); 
		
		
		/*
		 * the following is a filter with two SpecularLighting and a feMerge that joins the two lights LIKE IN THE FOLLOWING: 
		 * 
		  <filter id="filter1">
			  <feSpecularLighting specularExponent="25" lighting-color="red" kernelUnitLength="3 4" result="A" id="svgfilterop1">
			  		<fePointLight x="50" y="50" z="50"/>
			  </feSpecularLighting>
			  <feSpecularLighting specularExponent="125" lighting-color="green" kernelUnitLength="5 6" result="B" id="svgfilterop2">
			  		<fePointLight x="5" y="5" z="30"/>
			  </feSpecularLighting>
			  
			  <feMerge id="svgfilterop3">
				  <feMergeNode in="A"/>
				  <feMergeNode in="B"/>
			  </feMerge>
		  </filter>
		 */
		String t = "t"+M+",0"; 
		Shape shape1 = shape.clone().transform(t);
		Shape mask1 = mask.clone().transform(t); 		
		Filter filter1 = paper.filterCreate("filter1");	
		FilterOperationParam param = SpecularLighting.create()
			.specularExponent(25)
			.lightningColor("red")
			.kernelUnitLength("3 4")
			.lightSource(
				PointLight.create().x(50).y(50).z(50)
			)
			.result("A"); 		
		FilterOperation fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter1.appendOperation(fop); 	
		
		param = SpecularLighting.create()
			.specularExponent(125)
			.lightningColor("green")
			.kernelUnitLength("5 6")
			.lightSource(
				PointLight.create().x(5).y(5).z(30)
			)
			.result("B"); 		
		fop = FilterFactory.getInstance().createFilterOperation(param); 		
		filter1.appendOperation(fop); 	
		
		param = Merge.create("A", "B"); 
		fop = FilterFactory.getInstance().createFilterOperation(param); 
		filter1.appendOperation(fop); 	
		
		mask1.filterInstall(filter1); 
		
		
		/* now a DiffuseLighting that uses feComposite, like in 
		<filter id = "i1">
	        <feDiffuseLighting result = "diffOut" in = "SourceGraphic" diffuseConstant = "1.2" lighting-color = "white">
	            <fePointLight x = "400" y = "400" z = "150" pointsAtX = "0" pointsAtY = "0" pointsAtZ = "0"/>
	        </feDiffuseLighting>
	        <feComposite in = "SourceGraphic" in2 = "diffOut" operator = "arithmetic" k1 = "1" k2 = "0" k3 = "0" k4 = "0"/>
	    </filter>
	    */
		t = "t0,"+M; 
		Shape shape2 = shape.clone().transform(t); 		
		Filter filter2 = paper.filterCreate("filter2");	
		param = DiffuseLighting.create()
			.diffuseConstant(1.1)
			.lightningColor("blue")
			.kernelUnitLength("2 2")
			.lightSource(
				PointLight.create().x(25).y(25).z(9)
			).result("diffOut"); 		
		fop = FilterFactory.getInstance().createFilterOperation(param);
		filter2.appendOperation(fop);
		
		param = Composite.create()
				.in2("diffOut").operator("arithmetic")
				.k1(1).k2(0).k3(0).k4(0)
				.in("SourceGraphic"); 

		fop = FilterFactory.getInstance().createFilterOperation(param);
		filter2.appendOperation(fop); 	
		shape2.filterInstall(filter2); 
		
	}

	
	//test information:
	@Override
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_SVG, GalleryUtil.TAG_EXTENSION};
	}
	public SvgFiltersLighting1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="SvgFiltersLighting1";
		this.description="SvgFiltersLighting1";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.SvgFiltersLighting1().getText();
	}

}
