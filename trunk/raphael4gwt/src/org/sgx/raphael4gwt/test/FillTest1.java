package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Ellipse;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Rect;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Gradient;
import org.sgx.raphael4gwt.raphael.event.ForEachCallback;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.gallery.IconPaths;
import org.sgx.raphael4gwt.test.gallery.GalleryResources;

public class FillTest1 extends Test {
	
	private int ycounter;
	

	@Override
	public void test() {
		paper.setStart();
		paper.rect(12, 12, 100,10);
		paper.path(IconPaths.question);
		Set shapes = paper.setFinish();
		ycounter=50;
		
		shapes.forEach(new ForEachCallback() {
			@Override
			public boolean call(Shape s, int i) {
				s.translate(100, ycounter);
				s.scale(3.0, 4.0);
				s.attr( Attrs.create().
					fill(GalleryResources.INSTANCE.smallLion())
				);
				ycounter+=100;
				return true;
			};
		});	
		
		//draw other two elements and ill them with gradients
		Rect r1 = paper.rect(212, 12, 100,10);
		r1.attr(Attrs.create().fill(Gradient.linear(0.5, "#ff0000", "#ffff00")));
		Ellipse e1 = paper.ellipse(250,180,112,40);
		e1.attr(Attrs.create().fill(Gradient.radial(0.5, 0.5, "#ffaa55", "#00aaee")));
		
	}

	//test information:
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_SHAPE};
	}
	public FillTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="fill shape tests";
		this.description="verifting fill works with gradients and images to";		
	}
		
	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.FillTest1().getText();
	}

}
