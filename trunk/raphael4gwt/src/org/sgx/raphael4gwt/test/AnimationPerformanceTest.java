package org.sgx.raphael4gwt.test;

import java.util.LinkedList;
import java.util.List;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.Callback;
import org.sgx.raphael4gwt.raphael.pathobj.PathObject;
import org.sgx.raphael4gwt.raphael.util.Util;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;

import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author sg
 * 
 */
public class AnimationPerformanceTest extends Test {

	@Override
	public void test() {
		// VerticalPanel panel = GalleryUtil.getInstance().getTestPanel();
		int pathCount = 32;
		List<Path> paths = new LinkedList<Path>();
		for (int i = 0; i < pathCount; i++) {
			paths.add(buildPath(getPaper()));
		}
	}

	//randomization min&max
	int maxx = 400;
	int maxy = 400;
	int minx = 70;
	int miny = 70;
	int msmin = 12000, msmax=32000;
	int pointCountMin=4, pointCountMax=12;
	int strokeWidthMin=1, strokeWidthMax=13; 
	int translatexmin=10, translatexmax=400, translateymin=20,  translateymax=400; 
	
	
	private Callback callback1 = new Callback() {
		@Override
		public void call(Shape s) {
			AnimationPerformanceTest.this.call(s);
		}
	};
	

	private Path buildPath(Paper paper) {
		int pointCount = 15, initx=Util.randomBetween(100,400), inity=Util.randomBetween(100,400);
		Attrs attrs = Attrs.create().fill("#33ff11").stroke("#125566")
				.strokeWidth(5).opacity(0.8);

		String strokedasharray = Raphael.STROKE_DASHARRAY_ALL[Util.randomBetween(0,
						Raphael.STROKE_DASHARRAY_ALL.length - 1)]; 
		
		// and now a random path
		// getPaper().text(400, 400, "a very strange thing");
		PathObject pathObj1 = PathObject.create(initx, inity);
		for (int i = 0; i < pointCount; i++) {
			pathObj1.T(Util.randomBetween(translatexmin, translatexmax),
					Util.randomBetween(translateymin, translateymax));
		}
		pathObj1.z();
		Path path = getPaper().path(pathObj1)
			.attr(attrs
				.strokeWidth(2)				
				.strokeDashArray(strokedasharray)
			).cast();

		call(path);
		return path;
		// p=paper.path();
		// return p;
	}

	// /**
	// * animation finish callback
	// */
	// @Override
	public void call(final Shape s) {

		int x = Util.randomBetween(minx, maxx);
		int y = Util.randomBetween(miny, maxy);
		int pointCount = Util.randomBetween(pointCountMin, pointCountMax);
		int ms = Util.randomBetween(msmin, msmax);

		PathObject p = PathObject.create(x, y);
		for (int i = 0; i < pointCount; i++) {
			p.T(Util.randomBetween(x, y), Util.randomBetween(x, y));
		}
		
//		String transform = "T"+Util.randomBetween(translatexmin, translatexmax)+","+
//				Util.randomBetween(translateymin, translateymax); 

		Attrs attrs = Attrs.create()
			.path(p)
			.strokeWidth(Util.randomBetween(strokeWidthMin, strokeWidthMax))
			.stroke(randomColor())
			.fill(randomColor())
//			.transform(transform)
			;

		String easing = Raphael.EASING_ALL[Util.randomBetween(0,
				Raphael.EASING_ALL.length - 1)];
		s.animate(attrs, ms, easing, callback1);
	}

	// test information:
	@Override
	public String[] getTags() {
		return new String[] { GalleryUtil.TAG_ANIM };
	}

	public AnimationPerformanceTest(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name = "animationPerformance1";
		this.description = "animationPerformance1";
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.BlurAndEmbossTest1().getText();
	}

}
