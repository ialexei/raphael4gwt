package org.sgx.raphael4gwt.gtest.gallery.tests;

import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.graphael.radar.RadarChart;
import org.sgx.raphael4gwt.graphael.radar.RadarContext;
import org.sgx.raphael4gwt.graphael.radar.RadarHoverListener;
import org.sgx.raphael4gwt.graphael.radar.RadarOpts;
import org.sgx.raphael4gwt.gtest.gallery.Test;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.base.Attrs;
/**
 * radars showing football players position
 * @author sg
 *
 */
public class RadarTest2 extends Test {		
 
class Player {
	public String name;
	public int x, y;
	/**
	 * array of 8 values: top, top-right, right, etc
	 */
	public double[] stats;
	public Player(String name, double[] stats, int x, int y) {
		super();
		this.name = name;
		this.stats = stats;
		this.x=x;
		this.y=y;
	}
}
	
@Override
public void test() {
	
	//a list of players
	Player [] players = new Player[]{
		new Player("Diego Forlán", new double[]{6, 9, 10, 8, 6, 3, 2, 3}, 100,150), 
		new Player("Ruso Perez", new double[]{8, 4, 3, 4, 8, 8, 7, 8}, 400,150),
		new Player("Arevalo Ríos", new double[]{9, 4, 3, 4, 10, 8, 7, 8}, 100, 400),
		new Player("Diego Godín", new double[]{6, 2, 1, 2, 6, 9, 10, 10}, 400, 400),
	};
	
	RadarOpts opts = new RadarOpts();
	opts.setLegend(new String[]{"middle right", "attack right", "attack center", 
			"attack left", "center left", "defense left", "defense center", "defense right"});
	for(Player p : players) {
		getGPaper().text(p.x, p.y-120,p.name).attr(Attrs.create().fontSize(16));
		RadarChart radar = getGPaper().radar(p.x, p.y, 100, p.stats, opts);
		registerHovering(radar);
	}	
}

private void registerHovering(RadarChart radar) {
	radar.hover(new RadarHoverListener() {		
		GShape popup=null;
		@Override
		public void hoverOut(RadarContext ctx) {
			if(popup!=null) {
				popup.remove();
				popup=null;
			}
			ctx.getLabel().attr(Attrs.create().fontSize(12).
					fontWeight(Raphael.FONT_WEIGHT_NORMAL));
		}			
		@Override
		public void hoverIn(RadarContext ctx) {
			popup = getGPaper().popup(ctx.getMX(), ctx.getMY(), ctx.getValue()+"");
			ctx.getLabel().attr(Attrs.create().fontSize(14).
					fontWeight(Raphael.FONT_WEIGHT_BOLD));
		}
	});
}

//test class stuff
public RadarTest2(Paper paper, int paperWidth, int paperHeight) {
	super(paper, paperWidth, paperHeight);
	setName("radar2");
	setDescription("radar chart test 2");
}
@Override
public String getJavaClassSource() {
	return TestResources.INSTANCE.RadarTest2().getText();
}

}
