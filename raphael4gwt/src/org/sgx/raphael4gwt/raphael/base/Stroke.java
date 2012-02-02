package org.sgx.raphael4gwt.raphael.base;

public class Stroke {
	public static final String LINECAP_BUTT="butt", 
			LINECAP_SQUARE="square",  LINECAP_ROUND="round", 
			LINEJOIN_BEVEL="bevel", LINEJOIN_ROUND="round", 
			LINEJOIN_MITER="miter";
	String color, dasharray, linecap, linejoin;
	double miterlimit, opacity;
	int width;
	
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDasharray() {
		return dasharray;
	}
	public void setDasharray(String dasharray) {
		this.dasharray = dasharray;
	}
	public String getLinecap() {
		return linecap;
	}
	public void setLinecap(String linecap) {
		this.linecap = linecap;
	}
	public String getLinejoin() {
		return linejoin;
	}
	public void setLinejoin(String linejoin) {
		this.linejoin = linejoin;
	}
	public double getMiterlimit() {
		return miterlimit;
	}
	public void setMiterlimit(double miterlimit) {
		this.miterlimit = miterlimit;
	}
	public double getOpacity() {
		return opacity;
	}
	public void setOpacity(double opacity) {
		this.opacity = opacity;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	
}
