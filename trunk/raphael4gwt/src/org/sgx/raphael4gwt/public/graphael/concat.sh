ALL=g.raphael.all

cat g.raphael-min.js > $ALL-min.js
cat g.bar-min.js >> $ALL-min.js
cat g.dot-min.js >> $ALL-min.js
cat g.line-min.js >> $ALL-min.js
cat g.pie-min.js >> $ALL-min.js

echo "/* g.raphael */" > $ALL.js
cat g.raphael.js >> $ALL.js

echo "/* g.bar */" >> $ALL.js
cat g.bar.js >> $ALL.js

echo "/* g.dot */" >> $ALL.js
cat g.dot.js >> $ALL.js

echo "/* g.line */" >> $ALL.js
cat g.line.js >> $ALL.js

echo "/* g.pie */" >> $ALL.js
cat g.pie.js >> $ALL.js