package org.sgx.raphael4gwt.raphael.base;

import com.google.gwt.core.client.JavaScriptObject;

public class Animation extends JavaScriptObject {
	
protected Animation(){}
/**
 * Creates a copy of existing animation object with given delay. 
 * @param ms number of ms to pass between animation start and actual animation
 * @return a new animation object
 */
public native final Animation delay(int ms)/*-{
		var dump = function(o) {
			var s = "{";
			for(var i in o) {
				s+=i+"("+typeof(o[i])+"): "+o[i]+", ";
			}
			return s+"}";
		};
		$wnd.alert(dump(this));
	return this.delay(ms);
}-*/;
/**
 * Creates a copy of existing animation object with given repetition. 
 * @param repeat number iterations of animation. For infinite animation pass negative
 * @return  new altered Animation object
 */
public native final Animation repeat(int repeat)/*-{
	if(repeat<0)
		repeat = Infinity;
	return this.repeat(repeat);
}-*/;
}
