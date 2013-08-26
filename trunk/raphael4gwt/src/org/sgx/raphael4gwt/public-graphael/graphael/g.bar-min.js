/*! raphael4gwt 2013-08-26 */
!function(){function a(a,b,c,f,g,h,i,j){var k,l={round:"round",sharp:"sharp",soft:"soft",square:"square"};if(g&&!f||!g&&!c)return i?"":j.path();switch(h=l[h]||"square",f=Math.round(f),c=Math.round(c),a=Math.round(a),b=Math.round(b),h){case"round":if(g)m=~~(c/2),m>f?(m=f,k=["M",a-~~(c/2),b,"l",0,0,"a",~~(c/2),m,0,0,1,c,0,"l",0,0,"z"]):k=["M",a-m,b,"l",0,m-f,"a",m,m,0,1,1,c,0,"l",0,f-m,"z"];else{var m=~~(f/2);m>c?(m=c,k=["M",a+.5,b+.5-~~(f/2),"l",0,0,"a",m,~~(f/2),0,0,1,0,f,"l",0,0,"z"]):k=["M",a+.5,b+.5-m,"l",c-m,0,"a",m,m,0,1,1,0,f,"l",m-c,0,"z"]}break;case"sharp":if(g)n=~~(c/2),k=["M",a+n,b,"l",-c,0,0,-e(f-n,0),n,-d(n,f),n,d(n,f),n,"z"];else{var n=~~(f/2);k=["M",a,b+n,"l",0,-f,e(c-n,0),0,d(n,c),n,-d(n,c),n+(f>2*n),"z"]}break;case"square":k=g?["M",a+~~(c/2),b,"l",1-c,0,0,-f,c-1,0,"z"]:["M",a,b+~~(f/2),"l",0,-f,c,0,0,f,"z"];break;case"soft":g?(m=d(Math.round(c/5),f),k=["M",a-~~(c/2),b,"l",0,m-f,"a",m,m,0,0,1,m,-m,"l",c-2*m,0,"a",m,m,0,0,1,m,m,"l",0,f-m,"z"]):(m=d(c,Math.round(f/5)),k=["M",a+.5,b+.5-~~(f/2),"l",c-m,0,"a",m,m,0,0,1,m,m,"l",0,f-2*m,"a",m,m,0,0,1,-m,m,"l",m-c,0,"z"])}return i?k.join(","):j.path(k)}function b(b,c,d,e,f,g,h){h=h||{};var i=this,j=h.type||"square",k=parseFloat(h.gutter||"20%"),l=b.set(),m=b.set(),n=b.set(),o=b.set(),p=Math.max.apply(Math,g),q=[],r=0,s=h.colors||i.colors,t=g.length;if(Raphael.is(g[0],"array")){p=[],r=t,t=0;for(var u=g.length;u--;)m.push(b.set()),p.push(Math.max.apply(Math,g[u])),t=Math.max(t,g[u].length);if(h.stacked)for(var u=t;u--;){for(var v=0,w=g.length;w--;)v+=+g[w][u]||0;q.push(v)}for(var u=g.length;u--;)if(g[u].length<t)for(var w=t;w--;)g[u].push(0);p=Math.max.apply(Math,h.stacked?q:p)}p=h.to||p;var x=100*(e/(t*(100+k)+k)),y=x*k/100,z=null==h.vgutter?20:h.vgutter,A=[],B=c+y,C=(f-2*z)/p;h.stretch||(y=Math.round(y),x=Math.floor(x)),!h.stacked&&(x/=r||1);for(var u=0;t>u;u++){A=[];for(var w=0;(r||1)>w;w++){var D=Math.round((r?g[w][u]:g[u])*C),E=d+f-z-D,F=a(Math.round(B+x/2),E+D,x,D,!0,j,null,b).attr({stroke:"none",fill:s[r?w:u]});r?m[w].push(F):m.push(F),F.y=E,F.x=Math.round(B+x/2),F.w=x,F.h=D,F.value=r?g[w][u]:g[u],h.stacked?A.push(F):B+=x}if(h.stacked){var G;o.push(G=b.rect(A[0].x-A[0].w/2,d,x,f).attr(i.shim)),G.bars=b.set();for(var H=0,I=A.length;I--;)A[I].toFront();for(var I=0,J=A.length;J>I;I++){var K,F=A[I],D=(H+F.value)*C,L=a(F.x,d+f-z-.5*!!H,x,D,!0,j,1,b);G.bars.push(F),H&&F.attr({path:L}),F.h=D,F.y=d+f-z-.5*!!H-D,n.push(K=b.rect(F.x-F.w/2,F.y,x,F.value*C).attr(i.shim)),K.bar=F,K.value=F.value,H+=F.value}B+=x}B+=y}if(o.toFront(),B=c+y,!h.stacked)for(var u=0;t>u;u++){for(var w=0;(r||1)>w;w++){var K;n.push(K=b.rect(Math.round(B),d+z,x,f-z).attr(i.shim)),K.bar=r?m[w][u]:m[u],K.value=K.bar.value,B+=x}B+=y}return l.label=function(a){a=a||[],this.labels=b.set();for(var c=this[0],d=0;d<c.length;d++){var e=c[d],f=[];if(e)for(var g=0;g<e.length;g++){var h=e[g],i=h.getBBox();f.push(b.label(i.x,i.y,a[d][g]))}}return this.push(this.labels),this},l.hover=function(a,b){return o.hide(),n.show(),n.mouseover(a).mouseout(b),this},l.hoverColumn=function(a,b){return n.hide(),o.show(),b=b||function(){},o.mouseover(a).mouseout(b),this},l.click=function(a){return o.hide(),n.show(),n.click(a),this},l.each=function(a){if(!Raphael.is(a,"function"))return this;for(var b=n.length;b--;)a.call(n[b]);return this},l.eachColumn=function(a){if(!Raphael.is(a,"function"))return this;for(var b=o.length;b--;)a.call(o[b]);return this},l.clickColumn=function(a){return n.hide(),o.show(),o.click(a),this},l.push(m,n,o),l.bars=m,l.covers=n,l}function c(b,c,d,e,f,g,h){h=h||{};var i=this,j=h.type||"square",k=parseFloat(h.gutter||"20%"),l=b.set(),m=b.set(),n=b.set(),o=b.set(),p=Math.max.apply(Math,g),q=[],r=0,s=h.colors||i.colors,t=g.length;if(Raphael.is(g[0],"array")){p=[],r=t,t=0;for(var u=g.length;u--;)m.push(b.set()),p.push(Math.max.apply(Math,g[u])),t=Math.max(t,g[u].length);if(h.stacked)for(var u=t;u--;){for(var v=0,w=g.length;w--;)v+=+g[w][u]||0;q.push(v)}for(var u=g.length;u--;)if(g[u].length<t)for(var w=t;w--;)g[u].push(0);p=Math.max.apply(Math,h.stacked?q:p)}p=h.to||p;var x=Math.floor(100*(f/(t*(100+k)+k))),y=Math.floor(x*k/100),z=[],A=d+y,B=(e-1)/p;!h.stacked&&(x/=r||1);for(var u=0;t>u;u++){z=[];for(var w=0;(r||1)>w;w++){var C=r?g[w][u]:g[u],D=a(c,A+x/2,Math.round(C*B),x-1,!1,j,null,b).attr({stroke:"none",fill:s[r?w:u]});r?m[w].push(D):m.push(D),D.x=c+Math.round(C*B),D.y=A+x/2,D.w=Math.round(C*B),D.h=x,D.value=+C,h.stacked?z.push(D):A+=x}if(h.stacked){var E=b.rect(c,z[0].y-z[0].h/2,e,x).attr(i.shim);o.push(E),E.bars=b.set();for(var F=0,G=z.length;G--;)z[G].toFront();for(var G=0,H=z.length;H>G;G++){var I,D=z[G],C=Math.round((F+D.value)*B),J=a(c,D.y,C,x-1,!1,j,1,b);E.bars.push(D),F&&D.attr({path:J}),D.w=C,D.x=c+C,n.push(I=b.rect(c+F*B,D.y-D.h/2,D.value*B,x).attr(i.shim)),I.bar=D,F+=D.value}A+=x}A+=y}if(o.toFront(),A=d+y,!h.stacked)for(var u=0;t>u;u++){for(var w=0;(r||1)>w;w++){var I=b.rect(c,A,e,x).attr(i.shim);n.push(I),I.bar=r?m[w][u]:m[u],I.value=I.bar.value,A+=x}A+=y}return l.label=function(a,d){a=a||[],this.labels=b.set();for(var e=0;t>e;e++)for(var f=0;r>f;f++){var h,i=b.labelise(r?a[f]&&a[f][e]:a[e],r?g[f][e]:g[e],p),j=d?m[e*(r||1)+f].x-x/2+3:c+5,k=d?"end":"start";this.labels.push(h=b.text(j,m[e*(r||1)+f].y,i).attr(txtattr).attr({"text-anchor":k}).insertBefore(n[0])),h.getBBox().x<c+5?h.attr({x:c+5,"text-anchor":"start"}):m[e*(r||1)+f].label=h}return this},l.hover=function(a,b){return o.hide(),n.show(),b=b||function(){},n.mouseover(a).mouseout(b),this},l.hoverColumn=function(a,b){return n.hide(),o.show(),b=b||function(){},o.mouseover(a).mouseout(b),this},l.each=function(a){if(!Raphael.is(a,"function"))return this;for(var b=n.length;b--;)a.call(n[b]);return this},l.eachColumn=function(a){if(!Raphael.is(a,"function"))return this;for(var b=o.length;b--;)a.call(o[b]);return this},l.click=function(a){return o.hide(),n.show(),n.click(a),this},l.clickColumn=function(a){return n.hide(),o.show(),o.click(a),this},l.push(m,n,o),l.bars=m,l.covers=n,l}var d=Math.min,e=Math.max,f=function(){};f.prototype=Raphael.g,c.prototype=b.prototype=new f,Raphael.fn.barchart=function(a,c,d,e,f,g){return new b(this,a,c,d,e,f,g)},Raphael.fn.hbarchart=function(a,b,d,e,f,g){return new c(this,a,b,d,e,f,g)}}();