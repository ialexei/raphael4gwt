package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.base.AnimKeyFrames;
import org.sgx.raphael4gwt.raphael.base.Animation;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.event.Callback;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;
import org.sgx.raphael4gwt.raphael.util.Util;
import org.sgx.raphael4gwt.test.gallery.GalleryUtil;
import org.sgx.raphael4gwt.test.image.IconPaths;

import com.google.gwt.user.client.Window;
/**
 * show usage of AnimKeyFrames for animating a shape using keyframes.
 * @author sg
 *
 */
public class AnimKeyframesTest1 extends Test {
	
	@Override
	public void test() {
		
		for (int i = 0; i < 5; i++) {
			Shape path1 = paper.path(IconPaths.alarm).
				attr(Attrs.create().transform("S7.5T"+(100+90*i)+",200"));
			
			AnimKeyFrames anim = AnimKeyFrames.create();
			anim.put("20%", getRandomAttrs());
			anim.put("40%", getRandomAttrs());
			anim.put("60%", getRandomAttrs());
			anim.put("80%", getRandomAttrs());
			anim.put("100%", getRandomAttrs());
			
			path1.animate(anim, 12000);
		}
		
	}
	
	private Attrs getRandomAttrs() {
		return Attrs.create().stroke(Util.randomColor()).
				fill(Util.randomColor()).
				strokeWidth(Util.randomBetween(3,23));
	}

	//test stuff
	@Override
	public String[] getTags() {
		return new String[]{GalleryUtil.TAG_PATH, GalleryUtil.TAG_ANIM};
	}
	public AnimKeyframesTest1(Paper paper, int paperWidth,
			int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="anim keyframes";
		this.description="show usage of AnimKeyFrames for animating a shape using keyframes.";
	}

	@Override
	public String getJavaClassSource() {
		return TestResources.INSTANCE.AnimKeyframesTest1().getText();
	}

}
