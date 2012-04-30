package org.sgx.espinillo.client.impl1.util;

import java.util.HashMap;
import java.util.Map;

import org.sgx.espinillo.client.model.Document;
import org.sgx.raphael4gwt.raphael.Set;

public class ClipboardUtil {
private static ClipboardUtil instance;

private ClipboardUtil() {
	clipboards=new HashMap<Document, Set>();
}

public static ClipboardUtil getInstance() {
	if (null == instance) {
		instance = new ClipboardUtil();
	}
	return instance;
}
Map<Document, Set> clipboards;
public Set getClipboard(Document d) {
	return clipboards.get(d);
}
public void setClipboard(Document d, Set clipboard) {
	clipboards.put(d, clipboard);
}

}
