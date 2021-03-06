package org.sgx.raphael4gwt.raphael.jsutil;

import com.google.gwt.core.client.JsArrayMixed;

/**
 * this callback that receives the native javascript "arguments" array as a parameter (JsArrayMixed). 
 * User is responsible for casting/accessing this object. 
 * 
 * Use JsUtil.toFunction() for transforming this into a native javascrpit function.
 *   
 * TODO: refactor method signature call to return an Object
 * 
 * @author sg
 *
 */
public interface AbstractCallback {
	Object call(JsArrayMixed args); 
}
