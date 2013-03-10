package org.sgx.raphael4gwt.graphael.org;

import com.google.gwt.dom.client.NativeEvent;

public interface OrgEventHandler {
void notifyEvent(NativeEvent event, OrgNode box);
}
