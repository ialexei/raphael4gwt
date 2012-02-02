package org.sgx.raphael4gwt.raphael.util;

import com.google.gwt.dom.client.*;
import com.google.gwt.resources.client.TextResource;

public class JavascriptInjector {

  private static HeadElement head;

  public static void inject(TextResource r) {
    HeadElement head = getHead();
    ScriptElement element = createScriptElement();
    element.setText(r.getText());
    head.appendChild(element);
  }
  
  public static void inject(String javascript) {
    HeadElement head = getHead();
    ScriptElement element = createScriptElement();
    element.setText(javascript);
    head.appendChild(element);
  }

  private static ScriptElement createScriptElement() {
    ScriptElement script = Document.get().createScriptElement();
    script.setAttribute("language", "javascript");
    return script;
  }

  private static HeadElement getHead() {
    if (head == null) {
      Element element = Document.get().getElementsByTagName("head").getItem(0);
      assert element != null : "HTML Head element required";
      HeadElement head = HeadElement.as(element);
      JavascriptInjector.head = head;
    }
    return JavascriptInjector.head;
  }

}
