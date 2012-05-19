package org.sgx.raphael4gwt.gtest.gallery.tests;

import java.util.logging.Logger;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.GShape;
import org.sgx.raphael4gwt.graphael.sunburst.Cluster;
import org.sgx.raphael4gwt.graphael.sunburst.SunBurstChart;
import org.sgx.raphael4gwt.graphael.sunburst.SunBurstContext;
import org.sgx.raphael4gwt.graphael.sunburst.SunBurstHoverListener;
import org.sgx.raphael4gwt.graphael.sunburst.SunBurstOpts;
import org.sgx.raphael4gwt.gtest.gallery.Test;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Set;
import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.base.Glow;
/**
 * shows bargraph with columns hovering 
 * @author sg
 *
 */
public class SunBurstTest1 extends Test {

static Logger logger = Logger.getLogger("SunBurstTest1");
protected Set glow;
protected GShape popup;

@Override
public void test() {
	
	//chart clusters defined with Cluster helper class
	Cluster [] c = {
		new Cluster("Cluster A", new Cluster[]{
			new Cluster("Cluster A.1", 40),
			new Cluster("Cluster A.2", 60)
		}),
		new Cluster("Cluster B", 100),
		new Cluster("Cluster c", 110),
		new Cluster("Cluster D", new Cluster[]{
				new Cluster("Cluster D.1", 140),
				new Cluster("Cluster D.2", 160)
			}),
	};
	
//	JavaScriptObject clusters = JsUtil.evalObject("{   	    'Cluster A': 50,   	    'Cluster B': {   	        'Sub-Cluster B-A': 25,   	        'Sub-Cluster B-B': 75,   	    },   	    'Cluster C': {   	        'Sub-Cluster C-A': 86,   	        'Sub-Cluster C-B': 23,   	        'Sub-Cluster C-C': {   	            'Depth 3 - A': 50,   	            'Depth 3 - B': 125,   	            WithoutQuotes: 14   	        }   	    }   	}");
	 
	SunBurstOpts opts = new SunBurstOpts();
	opts.setRootLabel("Clusters tests 1");
	opts.setOffsetAngle(90);
	opts.setColors(new String[]{"#E8420C", "#FF9600", "#FF0057", "#A90CE8", "#1D0DFF"});
	opts.setGradients(new String[]{"45-#E8420C-#E832FF", "45-#FF9600-#FF96FF",
       	       "45-#FF0057-#FF00FF", "45-#A90CE8-#A90CFF",
       	       "45-#1D0DFF-#1D0DFF"});
	opts.setLevelWidths(new int[]{25, 75, 50, 40, 30});	
	
	SunBurstChart sunburst1 = getGPaper().sunburst(300,300, c, opts);
	
	sunburst1.hover(new SunBurstHoverListener() {
		
		@Override
		public void hoverOut(SunBurstContext c) {
			if(glow!=null)
				glow.remove();
			glow=null;
			
			if(popup!=null)
				popup.remove();
			popup=null;
		}
		
		@Override
		public void hoverIn(SunBurstContext c) {
			glow = c.getSector().glow(new Glow());
			popup = getGPaper().popup(c.getMX(), c.getMY(), 
				c.getSector().getLabel()+": "+c.getSector().getValue()).
				attr(Attrs.create().opacity(0.7)).<GShape>cast();
//			popup.animate(Attrs.create().opacity(1), 300, "linear");
		}
	});

}


//test class stuff
public SunBurstTest1(Paper paper, int paperWidth, int paperHeight) {
	super(paper, paperWidth, paperHeight);
	setName("sunburst1");
	setDescription("sunburst chart test 1");
}
GPaper getGPaper() {
	return (GPaper)paper;
}
@Override
public String getJavaClassSource() {
	return TestResources.INSTANCE.SunBurstTest1().getText();
}

}
