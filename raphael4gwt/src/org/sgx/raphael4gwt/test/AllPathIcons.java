package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Path;
import org.sgx.raphael4gwt.test.image.IconPaths;

//import static org.sgx.raphael4gwt.test.image.IconPaths.*;

public class AllPathIcons extends Test {


	public AllPathIcons(Paper paper, int paperWidth, int paperHeight) {
		super(paper, paperWidth, paperHeight);
		this.name="path icons";
		this.description="Show all raphaelis icons made with SVG paths";
		
	}

	@Override
	public void test() {

		String[] iconPaths = new String[] {
			IconPaths.question, IconPaths.i, IconPaths.dollar, IconPaths.temp, 
			IconPaths.thunder, IconPaths.snow,  IconPaths.hail,  IconPaths.rain,
			IconPaths.cloudy, IconPaths.sun, IconPaths.undo, IconPaths.merge, 
			IconPaths.split, IconPaths.fork, IconPaths.shuffle, IconPaths.arrowalt, 
			IconPaths.smile, IconPaths.smile2, IconPaths.alarm, IconPaths.clock,
			IconPaths.globeAlt, IconPaths.globe, IconPaths.globeAlt2, IconPaths.warning, IconPaths.arrowleftalt,
			IconPaths.arrow, IconPaths.arrowalt
		};
		
		int stepX = paperWidth/20;
		int stepY = paperWidth/20;
		int x = 0, y = 0;
		for (int i = 0; i < iconPaths.length; i++) {
			x+=stepX;
			if(x>paperWidth-40) {
				x=0;
				y+=stepY;
			}
				
			Path p = paper.path(iconPaths[i]);
			p.translate(x, y);
		}
		
		
	}

	@Override
	public String getJavaClassSource() {
		// TODO Auto-generated method stub
		return null;
	}

}
