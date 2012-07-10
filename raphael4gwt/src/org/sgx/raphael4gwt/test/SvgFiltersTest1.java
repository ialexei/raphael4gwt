package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.svg.filter.Filter;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterFactory;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterOperation;
import org.sgx.raphael4gwt.raphael.svg.filter.ops.GaussianBlur;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.image.IconPaths;
import org.sgx.raphael4gwt.test.image.TestImageResources;
/**
 * @author sg
 *
 */
public class SvgFiltersTest1 extends Test {
	
	@Override
	public void test() {
		
		Shape shape1 = paper.path(IconPaths.question).attr( Attrs.create().
			fill(TestImageResources.INSTANCE.smallLion()).
			transform("s6.0t10,10")
		);
		
		double blur = 0.2; 
		for (int i = 1; i < 8; i++) {
			blur+=0.2; 
			Shape shape2 = shape1.clone().translate(18*i, 0); 
			
			Filter filter1 = paper.filterCreate("filter_"+i);
			
			//the filter operation logic definition (POJO)
			GaussianBlur blur1 = new GaussianBlur(blur);
			
			//the native filter operation object (object overlay) 
			FilterOperation fop1 = FilterFactory.getInstance().createFilterOperation(blur1); 
			
			filter1.appendOperation(fop1); 			
			
			shape2.filterInstall(filter1); 
			
		}
	}

	
	//test information:
	@Override
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_SVG, GalleryUtil.TAG_EXTENSION};
	}
	public SvgFiltersTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="SvgFiltersTest1";
		this.description="SvgFiltersTest1";		
	}		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.SvgFiltersTest1().getText();
	}

}
