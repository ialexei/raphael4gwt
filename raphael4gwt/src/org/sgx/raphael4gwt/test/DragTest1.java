package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Circle;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.Point;
import org.sgx.raphael4gwt.raphael.event.DDListener;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.gallery.GalleryResources;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.resources.client.ImageResource;

/**
 * this test shows many ways of drag&drop shapes.
 * 
 * @author sg
 * 
 */
public class DragTest1 extends Test {

	@Override
	public void test() {
		final Circle c = paper.circle(200, 200, 100);
		c.setAttribute("fill", "red");

		/* make the circle draggable : register a drag and drop listener on the figure */
		c.drag(new DDListener() {
			@Override
			public void onStart(int x, int y, NativeEvent e) {
			}

			@Override
			public void onMove(int dx, int dy, int x, int y, NativeEvent e) {
				/*
				 * we want to move the circle so its center is just where the mouse pointer is. so we use Raphael.getCoordsInPaper for getting the mouse event coords in the paper.
				 */
				Point coords = Raphael.getCoordsInPaper(paper, e);
				c.setAttribute("cx", coords.getX());
				c.setAttribute("cy", coords.getY());
			}

			@Override
			public void onEnd(NativeEvent e) {
			}
		});

		/*
		 * now make an image drag and drop, this time not using Raphael.getCoordsInPaper but substracting papaer's absolute coords.
		 */

		ImageResource img1Res = GalleryResources.INSTANCE.smallLion();

		// paper absolute coords in the document are needed for dragging the element.
		final int paperAbsX = paper.getCanvasElement().getAbsoluteLeft();
		final int paperAbsY = paper.getCanvasElement().getAbsoluteTop();

		final Shape img2 = paper.image(img1Res, 130, 10, 120, 120);
		img2.drag(new DDListener() {

			private int startx;
			private int starty;

			@Override
			public void onStart(int x, int y, NativeEvent e) {
				startx = x - img2.getAttributeInt("x") - paperAbsX;
				starty = y - img2.getAttributeInt("y") - paperAbsY;
			}

			@Override
			public void onMove(int dx, int dy, int x, int y, NativeEvent e) {
				int absx = x - paperAbsX - startx, absy = y - paperAbsY - starty;
				System.out.println(absx + ", " + absy);
				img2.setAttribute("x", absx);
				img2.setAttribute("y", absy);
			}

			@Override
			public void onEnd(NativeEvent e) {
			}
		});

		/* and another image with drag and drop, this time easy using only relative coords and transformations */
		final Shape img3 = paper.image(img1Res, 130, 130, 120, 120);
		img3.drag(new DDListener() {
			@Override
			public void onStart(int x, int y, NativeEvent e) {
			}

			@Override
			public void onMove(int dx, int dy, int x, int y, NativeEvent e) {
				img3.transform("t" + dx + "," + dy);
			}

			@Override
			public void onEnd(NativeEvent e) {
			}
		});
	}

	// test information:
	public String[] getTags() {
		return new String[] { GalleryUtil.TAG_EVENT };
	}

	public DragTest1(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name = "drag&drop";
		this.description = "simple drag and drop example - how to drag a raphael figure.";
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.DragTest1().getText();
	}

}
