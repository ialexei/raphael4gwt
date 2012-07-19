java API for svg API extensions done in raphael-svg-filter.js by sgurin

for representing filter operations there are 2 main different implementations:  

* the ops package - that has 100% java class hierarchy translatable (w some overhead) to native js params obejcts

* the params package containing overlay types (with 0 overhead) for native javascript params objects - also with hierarchy

both packages are associated - you can go from one to another - toNative() and others.   