package org.sgx.raphael4gwt.raphael.base;

/**
 * a gradient stop
 * @author sg
 *
 */
public class Stop {
String color;
int offset;

public Stop(String color, int offset) {
	super();
	this.color = color;
	this.offset = offset;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public int getOffset() {
	return offset;
}
public void setOffset(int offset) {
	this.offset = offset;
}

}
