package org.sgx.raphael4gwt.raphael.base;

public class Arrow {
public static final String TYPE_CLASSIC="classic", 
	TYPE_OVAL="oval", TYPE_BLOCK="block", TYPE_OPEN="open", 
	TYPE_DIAMOND="diamond", TYPE_NONE="none",
	WIDTH_WIDE="wide",WIDTH_NARROW="narrow",WIDTH_MIDIUM="midium",
	LENGTH_LONG="long",LENGTH_SHORT="short",LENGTH_MIDIUM="midium";

public static String build(String type, String width, String length) {
	String s = type;
	if(width!=null)
		s+="-"+width;
	if(length!=null && width!=null)
		s+="-"+length;
	return s;
}
}
