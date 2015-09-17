Table of Contents


# What is it? #

A gwt lightweight java API for [http://raphaeljs.com/](raphaeljs.md), a graphic drawing JavaScript library. It uses GWT overly types for implementing zero overhear java API for raphaeljs.

Based on latest raphaeljs version, currently 2.1. All raphaeljs features supported. Very straightforward java  API to raphael javascript API.



# How to include it in your GWT project #

1) add the following in your project's gwt.xml file:

```
<inherits name="org.sgx.raphael4gwt.Raphael4Gwt" />
```

2) add the .jar to your gwt project's classpath. For example, copy it to war/WEB-INF/lib folder and add it to the java class path.

3) you are ready to use it.


# How to use it #

The following are some GWT Entry point class examples that show different ways of creating a raphael paper

The first is the most easy and that is creating a Raphael paper from "thin air" not asociated with any particular HTML element:

## Creating a paper in the body ##
```

package org.sgx.civ.client;

import org.sgx.raphael4gwt.raphael.Attr;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.Shape;
import org.sgx.raphael4gwt.raphael.event.MouseEventListener;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.client.Window;

public class Civ implements EntryPoint {

@Override
public void onModuleLoad() {
	//create a raphael paper at 0,0 screen coords and size 600x600
	Paper paper = Raphael.paper(0, 0, 600, 600);
	
	//draw a red rounded rectangle
	Shape rect1 = paper.rect(20,  10, 220, 250, 14).
			attr(new Attr().fill("red"));
	
	//install a click handler in the rectangle 
	rect1.click(new MouseEventListener() {			
		@Override
		public void notifyMouseEvent(NativeEvent e) {
			Window.alert("ouch at X == "+e.getClientX()); 
		}
	}); 
}

}

```


## Creating a paper Using PaperWidget ##

raphael4gwt comes with a basic GWT Widget that host a Paper. This is nice when using GWTWidgets and raphael4gwt. Only the paper is the widget; shapes you draw are not widgets:

```

/**
 * a gwt entry points that use PaperWidget for showing a raphael paper on it, with other gwt widgets.
 * @author sg
 */
public class Raphael4GwtTestAlone implements EntryPoint{

	@Override
	public void onModuleLoad() {
		
		PaperWidget paperWidget = new PaperWidget(PAPER_WIDTH, PAPER_HEIGHT); 
		
		RootPanel.get().add(paperWidget); 

                //draw something
		Paper paper=paperWidget.getPaper();
		paper.rect(10,10,40,60,2);
	}
}
```





## Creating a paper GWT dom (no widgets) ##

Normally you want to create the raphael paper inside an existing HTML element. For that we pass the element id or the HTML element it self to the Raphael method. In the following example, we create an HTML element and then a Raphael paper inside it. We manipulate the HTML DOM using gwt.dom.client. IMPORTANT: the HTML Element must be attached to the document before creating a Raphael paper on it:

```

package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Circle;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;

/**
 * a gwt entry points that shows a very simple use case using 
 * gwt.client.dom for creating an element in the body and attach 
 * a raphael paper to it. Has nothing to do with GWT widgets. 
 * @author sg
 */
public class Raphael4GwtTestAloneNoWidget implements EntryPoint {
	@Override
	public void onModuleLoad() {
		DivElement el1 = Document.get().createDivElement();
		
		//ensure the element is attach to document before crating raphael paper
		Document.get().getBody().appendChild(el1);
		
		//create the raphael paper using the simplepanel
		Paper paper = Raphael.paper(el1, 1500, 1500);
		
		//draw something
		Circle circle1 = paper.circle(150, 150, 40);
		circle1.setAttribute("fill", "red");	
	}	
}


```


the second way is similar to the first, but using a GWT SimplePanel widget, and creating the raphael paper inside it.
```
package org.sgx.raphael4gwt.test;

import org.sgx.raphael4gwt.raphael.Circle;
import org.sgx.raphael4gwt.raphael.Paper;
import org.sgx.raphael4gwt.raphael.Raphael;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * a gwt entry points that shows a very simple use case.
 * @author sg
 */
public class Raphael4GwtTestAloneSimple implements EntryPoint {
	@Override
	public void onModuleLoad() {
		//we will use a simple panel in which to put our aphael paper:
		SimplePanel paperPanel = new SimplePanel();
		
		//ensure the element is attach to document before crating raphael paper
		RootPanel.get().add(paperPanel); 
			
		//create the raphael paper using the simplepanel
		Paper paper = Raphael.paper(paperPanel.getElement(), 1500, 1500);
		
		//draw something
		Circle circle1 = paper.circle(150, 150, 40);
		circle1.setAttribute("fill", "red");	
	}	
}
```


## Using PaperWidget in UIBinder ##

The following example shows a UIBinder widget that uses PaperWidget importing and using it in the ui.xml file passing the paper's width and height as xml attributes. No extra work is required to start drawing:

**MainGameView.ui.xml**
```
<!DOCTYPE ui:UiBinder SYSTEM "http://dl.google.com/gwt/DTD/xhtml.ent">
<ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder" 
    xmlns:g="urn:import:com.google.gwt.user.client.ui"
    xmlns:raphael="urn:import:org.sgx.raphael4gwt.raphael.widget"
    >
	<ui:style>
		
	</ui:style>
	<g:HTMLPanel>
	    <table>
	        <tr><h3>This is your game of Horror ho ho ho</h3></tr>
	        <tr>
	            <td>
	            <ul>
	                <li><b>Options</b> nightmare</li>
	                <li><b>Start</b> Frankenstein</li>
	            </ul>
	            	</td>
	            	
	            <td>
	                <raphael:PaperWidget ui:field="paperWidget" paperWidth="600" paperHeight="600">	                    
	                </raphael:PaperWidget>	                
	            </td>
	        </tr>
	        
	    </table>
	</g:HTMLPanel>
</ui:UiBinder> 
```

**MainGameView.java**
```
package org.sgx.raphael4gwttest.client.uibindertest1;

import org.sgx.raphael4gwt.raphael.base.Attrs;
import org.sgx.raphael4gwt.raphael.widget.PaperWidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MainGameView extends Composite {

	private static MainGameViewUiBinder uiBinder = GWT.create(MainGameViewUiBinder.class);

	interface MainGameViewUiBinder extends UiBinder<Widget, MainGameView> {
	}

	@UiField PaperWidget paperWidget;
	
	public MainGameView() {
		initWidget(uiBinder.createAndBindUi(this));
		
		// ready to use the paper: 

		paperWidget.getPaper().rect(10,10,20,30,5).attr(Attrs.create().fill("red")); 
	}

}

```

## Using uibinder and dom (no widgets) ##

TODO


# Dynamic JavaScript loading #

when inheriting org.sgx.raphael4gwt.Raphael4Gwt GWT module your GWT application will load all the required JavaScript code. For org.sgx.raphael4gwt.Raphael4Gwt this is about 140 kb and for org.sgx.raphael4gwt.GRaphael4Gwt are 140 + 40 = 180 kb in total.

This is not good when trying to optimize initial web page startup time, and fortunately raphael4gwt comes with Modules and utilities that will let you load these necessary javascript code synamically only when needed. You must:

  1. inherit org.sgx.raphael4gwt.GRaphael4GwtNoScript GWT module instead of org.sgx.raphael4gwt.GRaphael4Gwt. GRaphael4GwtNoScript will not load any extra javascript at startup.

  1. use RaphaelLoader utility class for loading raphael or graphael javascript code dynamically only when you need the tool. The following EntryPoint class shows howto. When a button that when clicked will load the required Js files and show a Graphael Pie chart.

Open it using a network traffic tool like firebug and see how javascript is loading.

Initially only 18kb of js is loaded for displaying the the document and after the button is clicked two files of aprox 195kb (total) are loaded and then a chart is showed. these 195kbs are the javascript files corresponding to raphael and graphael code that are only loaded when required for showing a chart:

```
import org.sgx.raphael4gwt.graphael.GPaper;
import org.sgx.raphael4gwt.graphael.GRaphaelLoader;
import org.sgx.raphael4gwt.graphael.pie.PieOpts;
import org.sgx.raphael4gwt.raphael.Raphael;
import org.sgx.raphael4gwt.raphael.RaphaelLoader.Listener;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class Raphael4gwtNoScriptTestEP implements EntryPoint {

	@Override
	public void onModuleLoad() {
		RootPanel.get().add(new Button("load graphael example", new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				GRaphaelLoader.loadGRaphael(new Listener() {			
					@Override
					public void loaded(Exception error) {
						if(error == null) {
							doGraphaelExample(); 
						}
						else {
							Window.alert("ERROR loading graphael : "+error);
							error.printStackTrace(); 
						}
					}
				}); 
			}
		})); 
		
	}

	private void doGraphaelExample() {
        	GPaper paper = Raphael.paper(0,0,600,600).cast();
        	PieOpts opts = PieOpts.create(); 
        	paper.piechart(200f, 200, 100, new double[]{10, 40, 70, 90}, opts);
	}

}
```



# Generate the .jar using ant #

This section explains how to build raphel4gwt.jar file from SVN. You will need the following software : Java, GWT SDK, subversion (svn) and ant. In a **nix shell the steps are the following:**


```
#download the SVG repository
svn checkout http://raphael4gwt.googlecode.com/svn/trunk/raphael4gwt raphael4gwt-read-only

cd raphael4gwt-read-only

#edit gwt.sdk property in build.properties according to your system (points to GWT SDK folder). In this example use the cat command for ilustration but you can use your favourite text editor. 
cat > build.properties
gwt.sdk=/home/sebastian/programas/gwt-2.4.0
raphael4gwt.version=0.37
Ctrl-D

ant jar
```

If everything was fine, you should have raphael4gwt jar file at dist/ folder.

Note, if in the last example, you make `ant compile` you will compile all the raphael4gwt exmpales, so after the command finish you could open `war/index.html` in your browser for running the main raphael4gwt example gallery and `war/graphaelExamples.html` for graphael example gallery.


# Maven #

This project has a maven project definition. You can for example, download the sources and install the project on your maven system:

```

svn checkout http://raphael4gwt.googlecode.com/svn/trunk/raphael4gwt raphael4gwt-read-only
cd raphael4gwt-read-only/raphael4gwt
mvn clean install

```

Once you have installed it on your system like before, then you can include it as a maven dependency in you Gwt projects. This is the relevant information for that. Sorry, this project is not currently on maven central.

```

<groupId>org.sgx</groupId>
<artifactId>raphael4gwt</artifactId>
<version>0.41</version>

```

Also, you can reference my personal maven repository that contains this project latest version. For that see [example pom.xml](http://code.google.com/p/raphael4gwt/source/browse/raphael4gwttest/pom.xml). The relevant parts:

```
<repositories>
  <repository>....
    <id>sgmavenrepo</id>
    <name>Maven Repository for sg libraries</name>
    <url>http://sgmavenrepo.googlecode.com/svn/maven/repo</url>
  </repository>
</repositories>.

<dependencies>....
	<dependency>
		<groupId>org.sgx</groupId>
		<artifactId>raphael4gwt</artifactId>
		<version>0.41</version>
	</dependency>
</dependencies>
```

# Compiling Javascript #
raphael4gwt includes all the raphael libraries files plus some extensions and charting libraries like graphael, raphycharts, gantt, etc. All of these javascripts are minified and packed into a single file so GWT modules like Raphael and GRaphael can easily include all the required javascript automatically.

These javascript files are located in folders src/org/sgx/raphael4gwt/public/ and src/org/sgx/raphael4gwt/public-graphael/. If you need to change any of them, then you will need to regenerate the minified versions. This can be easily done using grunt js as follows:

Install nodejs on your system
```
cd jseditors
npm install grunt
npm install grunt-contrib-uglify
grunt
```


# Project objectives #

The objective is to provide the most direct java API to raphaeljs javascript API.
Nevertheless, when javascript overloading methods is overused in javascript,
some API methods are renamed from original. For example, Element.attr function
is Divided into Shap.setAttribute(s) and getAttribute(s).
Also artificial classes like MouseEventListener and Attrs, but always performing critical operations with zero overhead.

Also this project author is writing a [Raphaeljs tutorial](http://cancerbero.vacau.com/raphaeltut/) documenting all raphaeljs features not obvious for users new to SVG and vector drawing. A lot of raphael extensions are collected and documented there, and many of this exatensions, some authored by Sebastián Gurin, are included on raphael4gwt.



# raphael4gwt vs. raphaelgwt - why another raphael gwt porting? #

The project raphaelgwt, is a known raphael java API for GWT. It is well integrated with GWT widgets, for example
each raphael shap like circles, rectangles, etc are gwt widgets. raphaelgwt uses gwt event system for manage raphael shapes events and not raphaeljs native event system.

This can be good because it allows that wraps the overlay with a more Java-friendly API that will operate side-by-side with other GWT Widgets.

raphaelgwt also has the class RaphaelJS for doing raphael stuff natively. In gwt4raphael's author opinion, gwtraphael's RaphaelJS class

**do not cover the 100% raphaeljs native stuff, for example there is no java api for raphaeljs native event (because events are managed only at GWT widget level).**

**is not a rich java api for raphael objects, It try to cover all shapes api with a single class (Raphaeljs)**

So in conclusion (IMHO) raphaelgwt is not a good native raphaeljs java API for GWT. It focus on integration with GWT widgets but not in a good & updated raphaeljs java API.

raphael4gwt on the other hand focus on a complete and direct java API for raphaeljs. This means that in  your GWT applications you use raphael4gwt the as you would use raphaeljs natively. You create a raphael paper in some existing dom element, draw circles, text paths in that paper, set some attributes, and possible register some events handlers, perform animations, etc.

in raphael4gwt there is minimal tools for integrating with GWT widgets. There exists a simple PaperWidget, a GWT widget with a raphael paper inside. But raphaels circles, rects, paths, etc won't be gwt Widgets as oposition to raphaelgwt but native (overlay type) objects for no object wrapping overhead.

in raphael4gwt, raphael shapes shapes events are not related at all with gwt widgets events. The only thing it is used from gwt api is gwt.client.dom classes for referencing html dom objects in the API when neccesary.

Another big difference is that currently raphaelgwt is based on raphaeljs 1.x, while raphael4gwt is based on raphael 2.x.

Also I already have experience developing a raphaeljs java API, but for java2script, a framework similar to GWT.
The project http://yui4java.sourceforge.net/ contains some java APIs for java2script of known javascript toolkits like yui 2 and 3, soundmanager, and raphaeljs.
See for example a demonstration of my raphael java API for java2script (using also yui java API, check suorce code in the demo itself):
http://yui4java.sourceforge.net/yui/org.sgx.j2s.raphael.test.demo.Main.html

Now I'm learning best practices for porting existing javascript toolkits to GWT instead java2script.

With this in mind, I developed raphael4gwt, enjoy it. Perhaps one day raphalegwt can adopt it for the
lower layers, or vice versa, migrate raphael4gwt code to raphaelgwt for getting the both things, a good
raphaeljs 2.0 java API (based on gwt overlay types) and good integration between raphael Shapes and GWT widgets.