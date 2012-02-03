package org.sgx.raphael4gwt.raphael;

/**
 * a tool class for creating a layer above the paper for capturing events. 
 * usefull for tools over the paper.
 * @author sg
 *
 */
public class PaperGlass {

	Rect shape=null;
	Paper paper=null;
	public PaperGlass(Paper p) {}	
	
	public void load() {
//		if(paper==null)
//			return; // cannot attach to null paper.
//		if(shape==null)
//			shape=paper.rect(0, 0, ., w, h)
	}
	
	public void unload() {
		
	}
	
	
	
	public Rect getShape() {
		return shape;
	}

	public void setShape(Rect shape) {
		this.shape = shape;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	
	
	

}
