package org.sgx.raphael4gwt.raphael.base;

import org.sgx.raphael4gwt.raphael.Raphael;

/**represent a raphael arrow. Arrow constants are in Raphael
 * @author sg
 *
 */
public class Arrow {	

public static final String TYPE_CLASSIC="classic", 
	TYPE_OVAL="oval", TYPE_BLOCK="block", TYPE_OPEN="open", 
	TYPE_DIAMOND="diamond", TYPE_NONE="none",
	WIDTH_WIDE="wide",WIDTH_NARROW="narrow",WIDTH_MIDIUM="midium",
	LENGTH_LONG="long",LENGTH_SHORT="short",LENGTH_MIDIUM="midium";

String type, width, length;

public Arrow(String type, String width, String length) {
	super();
	this.type = type;
	this.width = width;
	this.length = length;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getWidth() {
	return width;
}

public void setWidth(String width) {
	this.width = width;
}

public String getLength() {
	return length;
}

public void setLength(String length) {
	this.length = length;
}


	@Override
	public String toString() {
		return arrowGetString(type, width, length);
	}
	
	/**
	 * shapes support the attribute arrow-end that is an 
	 * arrowhead on the end of the path. The format for string is <type>[-<width>[-<length>]]. 
	 * @see base.Arrow for a java object repr of an arrow.
	 * 
	 * @param type Possible types: classic, block, open, oval, diamond, none
	 * @param width Possible widths: wide, narrow, midium
	 * @param length Possible lengths : long, short, midium
	 * 
	 * @return
	 */
	public static String arrowGetString(String type, String width, String length) {
		String s = type;
		if(width!=null)
			s+="-"+width;
		if(length!=null && width!=null)
			s+="-"+length;
		return s;
	}
}
