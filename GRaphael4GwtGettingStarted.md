# Getting started to write charts using http://g.raphaeljs.com/ in GWT #

## Introduction ##

This project, raphael4gwt, also includes support for graphael charting library at http://g.raphaeljs.com/ as a second GWT module. graphael is a javascriupt library, based on raphaeljs for making good looking and live charts on web pages.

In this document I will try to explain how to get started to make graphael charts on your GWT applications.

First of all, download the latest version of raphael4gwt.jar and add it to your GWT project's java classpath.

Now, add the modules the module org.sgx.raphael4gwt.GRaphael4Gwt to your module definition (yourproject.gwt.xml), it will be something like the following:

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE module PUBLIC "-//Google Inc.//DTD Google Web Toolkit 2.4.0//EN" "http://google-web-toolkit.googlecode.com/svn/tags/2.4.0/distro-source/core/src/gwt-module.dtd">

<module>
	<inherits name="com.google.gwt.user.User" />
	<inherits name="com.google.gwt.resources.Resources" />
	<inherits name="org.sgx.raphael4gwt.GRaphael4Gwt" />	
	
	<inherits name='com.google.gwt.user.theme.clean.Clean' />

	<entry-point class="myorg.myapp.MyAppEntryPoint" />
	
	<source path="test" />
	
</module>
```

Now we are ready to use graphael javaAPI in our entry point classes, in the example, myorg.myapp.MyAppEntryPoint:

```
package myorg.myapp;

import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.raphael.Raphael;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class GRaphael4GwtTest implements EntryPoint {

	@Override
	public void onModuleLoad() {
		
		/* create a normal raphael paper, but casting it to 
		 * GPaper - the class that contain the Charts stuff */
		GPaper paper = (GPaper)Raphael.paper(0,0,600,600);
		
		//create a simple pie chart at 200,200 with pie radius 100
		paper.piechart(200, 200, 100, new double[]{10, 40, 70, 90});
		
	}
	
}

```

In summary, a GPaper have methods for drawing different kind of charts, like piecharts, dotcharts, linecharts, bar charts, etc. You build the charts just like any other shape and pass the values to represent (arrays of numbers) and some configuration for the chart in an Opts objects. Also you can register mouse event listeners for special parts of the chart, for example, be notified when user hovers the mouse over the chart bars or pie sectors and react. Just see the [gallery http://cancerbero.vacau.com/gwt/graphael4gwtGallery/](example.md) java sources for detailed examples.