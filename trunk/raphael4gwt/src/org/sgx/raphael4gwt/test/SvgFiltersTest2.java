package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;
import org.sgx.raphael4gwt.raphael.svg.filter.Filter;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterFactory;
import org.sgx.raphael4gwt.raphael.svg.filter.FilterOperation;
import org.sgx.raphael4gwt.raphael.svg.filter.ops.GaussianBlur;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.image.IconPaths;
import org.sgx.raphael4gwt.test.image.TestImageResources;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.TextBox;
/**
 * 
 * use two different kind of svg filter operation definitions - using the ops package (pure java operation hierarchy) and using the params package (operation overlay types hierarchy - 0 overhead)
 * @author sg
 *
 */
public class SvgFiltersTest2 extends Test {
	
	private TextBox text1;
	@Override
	public void test() {
		
		Shape shape = paper.path(IconPaths.question).attr( Attrs.create().
			fill(TestImageResources.INSTANCE.smallLion())
		);

//		text1 = new TextBox(); 
//		text1.setText(" ops: "); 
//		GalleryUtil.getInstance().getTestPanel().add(text1); 
		double blur = 0.2; 
		
		Shape shape1 = shape.clone().translateNT(200,100).scaleNT(5.0, 5.0);  
		
		Filter filter1 = paper.filterCreate("filter_ops1");	
		
		//the filter operation logic definition (POJO)
		GaussianBlur blur1 = new GaussianBlur(blur);
		
		//the native filter operation object (object overlay) 
		FilterOperation fop1 = FilterFactory.getInstance().createFilterOperation(blur1); 
		
		filter1.appendOperation(fop1); 
		
		shape1.filterInstall(filter1); 
		
		
		
		//now the same but using the params package - use overlay types so there is 0 overhead with the extension
		

		
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
		return TestResources.INSTANCE.SvgFiltersTest1().getText();
	}

}
