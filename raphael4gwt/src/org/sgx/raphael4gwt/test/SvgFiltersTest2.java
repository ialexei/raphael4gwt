package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.svg.filter.Filter;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterFactory;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterOperation;
import org.sgx.raphael4gwt.raphael.svg.filter.params.GaussianBlur;
import org.sgx.raphael4gwt.raphael.svg.filter.params.Morphology;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.image.IconPaths;
import org.sgx.raphael4gwt.test.image.TestImageResources;

import com.google.gwt.user.client.ui.TextBox;
/**
 * 
 * use two different kind of svg filter operation definitions - using the ops package (pure java operation hierarchy) and using the params package (operation overlay types hierarchy - 0 overhead)
 * @author sg
 *
 */
public class SvgFiltersTest2 extends Test {
	
//	private TextBox text1;
	@Override
	public void test() {
		
		Shape shape = paper
				.image(TestImageResources.INSTANCE.smallLion(), 0, 0, 20, 20)
//				.path(IconPaths.question)
//				.circle(110, 10, 20)
				.attr( Attrs.create()
			.fill(TestImageResources.INSTANCE.smallLion())
			.strokeWidth(0)
		);
		shape.translateNT(-40,-40); 
		double scale=6.0, dx=110, dy=110; 
		
		//the original - no filter
		Shape shape0 = shape.clone().translateNT(dx,dy).scaleNT(scale, scale);  
		
		Shape shape1 = shape.clone().translateNT(dx*2,dy).scaleNT(scale, scale);  
		
		//first, create the Filter. A filter instance can be applied to one or more shapes.
		Filter filter1 = paper.filterCreate("filter1");	
		
		//Now, create a new filter operation definition, in this case feGaussianblur 
		GaussianBlur blur1 = GaussianBlur.create(2);
		
		//And now create a FilterOperation object 
		FilterOperation fop1 = FilterFactory.getInstance().createFilterOperation(blur1); 
		
		//append the filter operation to the filter. 
		filter1.appendOperation(fop1); 		
		
		//install the filter in a shape
		shape1.filterInstall(filter1); 
		
		
		//now append another operation to the same filter and it will be applied to shapes with the filter installed automatically: 
		Morphology morph1 = Morphology.create(Morphology.OPERATOR_ERODE, 2, 3); 
		FilterOperation fop2 = FilterFactory.getInstance().createFilterOperation(morph1); 
		filter1.appendOperation(fop2);		
		
		//now other shape, and other filter with different operations
		Shape shape2 = shape.clone().translateNT(dx*2,dy*2).scaleNT(scale, scale);  
		Filter filter2 = paper.filterCreate("filter2");
		Morphology morph2 = Morphology.create(Morphology.OPERATOR_DILATE, 2, 3); 
		FilterOperation fop3 = FilterFactory.getInstance().createFilterOperation(morph2); 
		filter2.appendOperation(fop3);	
		shape2.filterInstall(filter2); 
		
		Shape shape3 = shape.clone().translateNT(dx,dy*2).scaleNT(scale, scale);  
		Filter filter3 = paper.filterCreate("filter3");
		GaussianBlur blur2 = GaussianBlur.create(1.5,1.7);
//		Morphology morph3 = Morphology.create(Morphology.OPERATOR_DILATE, 2, 3); 
		FilterOperation fop4 = FilterFactory.getInstance().createFilterOperation(blur2); 
		filter3.appendOperation(fop4);	
		shape3.filterInstall(filter3); 
		
	}

	
	//test information:
	@Override
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_SVG, GalleryUtil.TAG_EXTENSION};
	}
	public SvgFiltersTest2(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="SvgFiltersTest2";
		this.description="SvgFiltersTest2";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.SvgFiltersTest2().getText();
	}

}
