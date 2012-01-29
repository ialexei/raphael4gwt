package org.sgx.raphael4gwt.raphael.event;

import com.google.gwt.dom.client.NativeEvent;

public interface DDListener {
void onMove(int dx, int dy, int x, int y, NativeEvent e);
void onStart(int x, int y, NativeEvent e);
void onEnd(NativeEvent e);
}
