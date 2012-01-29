package org.sgx.raphael4gwt.raphael.base;
import org.sgx.raphael4gwt.raphael.NativeAttrs;
import org.sgx.raphael4gwt.raphael.jsutil.JsUtil;

import com.google.gwt.dev.js.ast.JsUnaryOperation;

/**
 * a pure java object bean with info about raphael shapes attributes and values. 
 * So users can work safely with attributes java bean object, instantiate it and so...
 * 
 * @author sg
 *
 */
public class Attrs {
	private NativeAttrs nativeAttrs;
	public Attrs(){
		this((NativeAttrs) JsUtil.empty());
	};
	public Attrs(NativeAttrs nativeAttrs){
		this.nativeAttrs=nativeAttrs;
	}
	
	public NativeAttrs getNativeAttrs() {
		return nativeAttrs;
	}
	public void setNativeAttrs(NativeAttrs nativeAttrs) {
		this.nativeAttrs = nativeAttrs;
	}
	public final String getFill() {
		return nativeAttrs.getFill();
	}
	public final void setFill(String fill) {
		nativeAttrs.setFill(fill);
	};
	public static Attrs createFromNative(NativeAttrs na) {
		return new Attrs(na);
	}
}
