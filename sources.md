# Using raphael4gwt sources #

These are some notes on how generating raphael4gwt from the sources.



# Requirements #
You will need the following software in order to compilethe rpahael4gwt project from the sources:

  * Java
  * GWT SDK
  * subversion (svn)
  * ant


# Building raphael4gwt Jar #

```
svn checkout http://raphael4gwt.googlecode.com/svn/trunk/ raphael4gwt-read-only

cd raphael4gwt-read-only/raphael4gwt

#edit gwt.sdk property in build.properties according to your system (points to GWT SDK folder)
cat > build.properties
gwt.sdk=/home/sebastian/programas/gwt-2.4.0
Ctrl-D

ant jar
```

If everything is fine, you will have the raphael4gwt.jar file at dist/raphael4gwt.jar path.

# Compiling and running  raphael4gwt demos #

# Compiling and running espinillo vector drawing tool #