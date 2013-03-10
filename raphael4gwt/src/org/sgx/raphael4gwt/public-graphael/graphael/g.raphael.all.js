
/* g.raphael */

/*!
 * g.Raphael 0.51 - Charting library, based on Raphaël
 *
 * Copyright (c) 2009-2012 Dmitry Baranovskiy (http://g.raphaeljs.com)
 * Licensed under the MIT (http://www.opensource.org/licenses/mit-license.php) license.
 */

/*
 * Tooltips on Element prototype
 */
/*\
 * Element.popup
 [ method ]
 **
 * Puts the context Element in a 'popup' tooltip. Can also be used on sets.
 **
 > Parameters
 **
 - dir (string) location of Element relative to the tail: `'down'`, `'left'`, `'up'` [default], or `'right'`.
 - size (number) amount of bevel/padding around the Element, as well as half the width and height of the tail [default: `5`]
 - x (number) x coordinate of the popup's tail [default: Element's `x` or `cx`]
 - y (number) y coordinate of the popup's tail [default: Element's `y` or `cy`]
 **
 = (object) path element of the popup
 \*/
Raphael.el.popup = function (dir, size, x, y) {
    var paper = this.paper || this[0].paper,
        bb, xy, center, cw, ch;

    if (!paper) return;

    switch (this.type) {
        case 'text':
        case 'circle':
        case 'ellipse': center = true; break;
        default: center = false;
    }

    dir = dir == null ? 'up' : dir;
    size = size || 5;
    bb = this.getBBox();

    x = typeof x == 'number' ? x : (center ? bb.x + bb.width / 2 : bb.x);
    y = typeof y == 'number' ? y : (center ? bb.y + bb.height / 2 : bb.y);
    cw = Math.max(bb.width / 2 - size, 0);
    ch = Math.max(bb.height / 2 - size, 0);

    //sgurin : fix for raphael 2.1 https://github.com/jhurt/g.raphael/commit/97644e810fdb1e2519e2246b1a5be5934232a7de
//  this.translate(x - bb.x - (center ? bb.width / 2 : 0), y - bb.y - (center ? bb.height / 2 : 0));
//  bb = this.getBBox();  
    this.translate(x - bb.x - (center ? bb.width / 2 : 0), y - bb.y - (center ? bb.height / 2 : 0));
    bb = this.getBBox();

    var paths = {
        up: [
            'M', x, y,
            'l', -size, -size, -cw, 0,
            'a', size, size, 0, 0, 1, -size, -size,
            'l', 0, -bb.height,
            'a', size, size, 0, 0, 1, size, -size,
            'l', size * 2 + cw * 2, 0,
            'a', size, size, 0, 0, 1, size, size,
            'l', 0, bb.height,
            'a', size, size, 0, 0, 1, -size, size,
            'l', -cw, 0,
            'z'
        ].join(','),
        down: [
            'M', x, y,
            'l', size, size, cw, 0,
            'a', size, size, 0, 0, 1, size, size,
            'l', 0, bb.height,
            'a', size, size, 0, 0, 1, -size, size,
            'l', -(size * 2 + cw * 2), 0,
            'a', size, size, 0, 0, 1, -size, -size,
            'l', 0, -bb.height,
            'a', size, size, 0, 0, 1, size, -size,
            'l', cw, 0,
            'z'
        ].join(','),
        left: [
            'M', x, y,
            'l', -size, size, 0, ch,
            'a', size, size, 0, 0, 1, -size, size,
            'l', -bb.width, 0,
            'a', size, size, 0, 0, 1, -size, -size,
            'l', 0, -(size * 2 + ch * 2),
            'a', size, size, 0, 0, 1, size, -size,
            'l', bb.width, 0,
            'a', size, size, 0, 0, 1, size, size,
            'l', 0, ch,
            'z'
        ].join(','),
        right: [
            'M', x, y,
            'l', size, -size, 0, -ch,
            'a', size, size, 0, 0, 1, size, -size,
            'l', bb.width, 0,
            'a', size, size, 0, 0, 1, size, size,
            'l', 0, size * 2 + ch * 2,
            'a', size, size, 0, 0, 1, -size, size,
            'l', -bb.width, 0,
            'a', size, size, 0, 0, 1, -size, -size,
            'l', 0, -ch,
            'z'
        ].join(',')
    };

    xy = {
        up: { x: -!center * (bb.width / 2), y: -size * 2 - (center ? bb.height / 2 : bb.height) },
        down: { x: -!center * (bb.width / 2), y: size * 2 + (center ? bb.height / 2 : bb.height) },
        left: { x: -size * 2 - (center ? bb.width / 2 : bb.width), y: -!center * (bb.height / 2) },
        right: { x: size * 2 + (center ? bb.width / 2 : bb.width), y: -!center * (bb.height / 2) }
    }[dir];

    this.translate(xy.x, xy.y);
    return paper.path(paths[dir]).attr({ fill: "#000", stroke: "none" }).insertBefore(this.node ? this : this[0]);
};

/*\
 * Element.tag
 [ method ]
 **
 * Puts the context Element in a 'tag' tooltip. Can also be used on sets.
 **
 > Parameters
 **
 - angle (number) angle of orientation in degrees [default: `0`]
 - r (number) radius of the loop [default: `5`]
 - x (number) x coordinate of the center of the tag loop [default: Element's `x` or `cx`]
 - y (number) y coordinate of the center of the tag loop [default: Element's `x` or `cx`]
 **
 = (object) path element of the tag
 \*/
Raphael.el.tag = function (angle, r, x, y) {
    var d = 3,
        paper = this.paper || this[0].paper;

    if (!paper) return;

    var p = paper.path().attr({ fill: '#000', stroke: '#000' }),
        bb = this.getBBox(),
        dx, R, center, tmp;

    switch (this.type) {
        case 'text':
        case 'circle':
        case 'ellipse': center = true; break;
        default: center = false;
    }

    angle = angle || 0;
    x = typeof x == 'number' ? x : (center ? bb.x + bb.width / 2 : bb.x);
    y = typeof y == 'number' ? y : (center ? bb.y + bb.height / 2 : bb.y);
    r = r == null ? 5 : r;
    R = .5522 * r;

    if (bb.height >= r * 2) {
        p.attr({
            path: [
                "M", x, y + r,
                "a", r, r, 0, 1, 1, 0, -r * 2, r, r, 0, 1, 1, 0, r * 2,
                "m", 0, -r * 2 -d,
                "a", r + d, r + d, 0, 1, 0, 0, (r + d) * 2,
                "L", x + r + d, y + bb.height / 2 + d,
                "l", bb.width + 2 * d, 0, 0, -bb.height - 2 * d, -bb.width - 2 * d, 0,
                "L", x, y - r - d
            ].join(",")
        });
    } else {
        dx = Math.sqrt(Math.pow(r + d, 2) - Math.pow(bb.height / 2 + d, 2));
        p.attr({
            path: [
                "M", x, y + r,
                "c", -R, 0, -r, R - r, -r, -r, 0, -R, r - R, -r, r, -r, R, 0, r, r - R, r, r, 0, R, R - r, r, -r, r,
                "M", x + dx, y - bb.height / 2 - d,
                "a", r + d, r + d, 0, 1, 0, 0, bb.height + 2 * d,
                "l", r + d - dx + bb.width + 2 * d, 0, 0, -bb.height - 2 * d,
                "L", x + dx, y - bb.height / 2 - d
            ].join(",")
        });
    }

    angle = 360 - angle;
    p.rotate(angle, x, y);

    if (this.attrs) {
        //elements
        this.attr(this.attrs.x ? 'x' : 'cx', x + r + d + (!center ? this.type == 'text' ? bb.width : 0 : bb.width / 2)).attr('y', center ? y : y - bb.height / 2);
        this.rotate(angle, x, y);
        angle > 90 && angle < 270 && this.attr(this.attrs.x ? 'x' : 'cx', x - r - d - (!center ? bb.width : bb.width / 2)).rotate(180, x, y);
    } else {
        //sets
        if (angle > 90 && angle < 270) {
            this.translate(x - bb.x - bb.width - r - d, y - bb.y - bb.height / 2);
            this.rotate(angle - 180, bb.x + bb.width + r + d, bb.y + bb.height / 2);
        } else {
            this.translate(x - bb.x + r + d, y - bb.y - bb.height / 2);
            this.rotate(angle, bb.x - r - d, bb.y + bb.height / 2); 
        }
    }

    return p.insertBefore(this.node ? this : this[0]);
};

/*\
 * Element.drop
 [ method ]
 **
 * Puts the context Element in a 'drop' tooltip. Can also be used on sets.
 **
 > Parameters
 **
 - angle (number) angle of orientation in degrees [default: `0`]
 - x (number) x coordinate of the drop's point [default: Element's `x` or `cx`]
 - y (number) y coordinate of the drop's point [default: Element's `x` or `cx`]
 **
 = (object) path element of the drop
 \*/
Raphael.el.drop = function (angle, x, y) {
    var bb = this.getBBox(),
        paper = this.paper || this[0].paper,
        center, size, p, dx, dy;

    if (!paper) return;

    switch (this.type) {
        case 'text':
        case 'circle':
        case 'ellipse': center = true; break;
        default: center = false;
    }

    angle = angle || 0;

    x = typeof x == 'number' ? x : (center ? bb.x + bb.width / 2 : bb.x);
    y = typeof y == 'number' ? y : (center ? bb.y + bb.height / 2 : bb.y);
    size = Math.max(bb.width, bb.height) + Math.min(bb.width, bb.height);
    p = paper.path([
        "M", x, y,
        "l", size, 0,
        "A", size * .4, size * .4, 0, 1, 0, x + size * .7, y - size * .7,
        "z"
    ]).attr({fill: "#000", stroke: "none"}).rotate(22.5 - angle, x, y);

    angle = (angle + 90) * Math.PI / 180;
    dx = (x + size * Math.sin(angle)) - (center ? 0 : bb.width / 2);
    dy = (y + size * Math.cos(angle)) - (center ? 0 : bb.height / 2);

    this.attrs ?
        this.attr(this.attrs.x ? 'x' : 'cx', dx).attr(this.attrs.y ? 'y' : 'cy', dy) :
        this.translate(dx - bb.x, dy - bb.y);

    return p.insertBefore(this.node ? this : this[0]);
};

/*\
 * Element.flag
 [ method ]
 **
 * Puts the context Element in a 'flag' tooltip. Can also be used on sets.
 **
 > Parameters
 **
 - angle (number) angle of orientation in degrees [default: `0`]
 - x (number) x coordinate of the flag's point [default: Element's `x` or `cx`]
 - y (number) y coordinate of the flag's point [default: Element's `x` or `cx`]
 **
 = (object) path element of the flag
 \*/
Raphael.el.flag = function (angle, x, y) {
    var d = 3,
        paper = this.paper || this[0].paper;

    if (!paper) return;

    var p = paper.path().attr({ fill: '#000', stroke: '#000' }),
        bb = this.getBBox(),
        h = bb.height / 2,
        center;

    switch (this.type) {
        case 'text':
        case 'circle':
        case 'ellipse': center = true; break;
        default: center = false;
    }

    angle = angle || 0;
    x = typeof x == 'number' ? x : (center ? bb.x + bb.width / 2 : bb.x);
    y = typeof y == 'number' ? y : (center ? bb.y + bb.height / 2: bb.y);

    p.attr({
        path: [
            "M", x, y,
            "l", h + d, -h - d, bb.width + 2 * d, 0, 0, bb.height + 2 * d, -bb.width - 2 * d, 0,
            "z"
        ].join(",")
    });

    angle = 360 - angle;
    p.rotate(angle, x, y);

    if (this.attrs) {
        //elements
        this.attr(this.attrs.x ? 'x' : 'cx', x + h + d + (!center ? this.type == 'text' ? bb.width : 0 : bb.width / 2)).attr('y', center ? y : y - bb.height / 2);
        this.rotate(angle, x, y);
        angle > 90 && angle < 270 && this.attr(this.attrs.x ? 'x' : 'cx', x - h - d - (!center ? bb.width : bb.width / 2)).rotate(180, x, y);
    } else {
        //sets
        if (angle > 90 && angle < 270) {
            this.translate(x - bb.x - bb.width - h - d, y - bb.y - bb.height / 2);
            this.rotate(angle - 180, bb.x + bb.width + h + d, bb.y + bb.height / 2);
        } else {
            this.translate(x - bb.x + h + d, y - bb.y - bb.height / 2);
            this.rotate(angle, bb.x - h - d, bb.y + bb.height / 2);
        }
    }

    return p.insertBefore(this.node ? this : this[0]);
};

/*\
 * Element.label
 [ method ]
 **
 * Puts the context Element in a 'label' tooltip. Can also be used on sets.
 **
 = (object) path element of the label.
 \*/
Raphael.el.label = function () {
    var bb = this.getBBox(),
        paper = this.paper || this[0].paper,
        r = Math.min(20, bb.width + 10, bb.height + 10) / 2;

    if (!paper) return;

    return paper.rect(bb.x - r / 2, bb.y - r / 2, bb.width + r, bb.height + r, r).attr({ stroke: 'none', fill: '#000' }).insertBefore(this.node ? this : this[0]);
};

/*\
 * Element.blob
 [ method ]
 **
 * Puts the context Element in a 'blob' tooltip. Can also be used on sets.
 **
 > Parameters
 **
 - angle (number) angle of orientation in degrees [default: `0`]
 - x (number) x coordinate of the blob's tail [default: Element's `x` or `cx`]
 - y (number) y coordinate of the blob's tail [default: Element's `x` or `cx`]
 **
 = (object) path element of the blob
 \*/
Raphael.el.blob = function (angle, x, y) {
    var bb = this.getBBox(),
        rad = Math.PI / 180,
        paper = this.paper || this[0].paper,
        p, center, size;

    if (!paper) return;

    switch (this.type) {
        case 'text':
        case 'circle':
        case 'ellipse': center = true; break;
        default: center = false;
    }

    p = paper.path().attr({ fill: "#000", stroke: "none" });
    angle = (+angle + 1 ? angle : 45) + 90;
    size = Math.min(bb.height, bb.width);
    x = typeof x == 'number' ? x : (center ? bb.x + bb.width / 2 : bb.x);
    y = typeof y == 'number' ? y : (center ? bb.y + bb.height / 2 : bb.y);

    var w = Math.max(bb.width + size, size * 25 / 12),
        h = Math.max(bb.height + size, size * 25 / 12),
        x2 = x + size * Math.sin((angle - 22.5) * rad),
        y2 = y + size * Math.cos((angle - 22.5) * rad),
        x1 = x + size * Math.sin((angle + 22.5) * rad),
        y1 = y + size * Math.cos((angle + 22.5) * rad),
        dx = (x1 - x2) / 2,
        dy = (y1 - y2) / 2,
        rx = w / 2,
        ry = h / 2,
        k = -Math.sqrt(Math.abs(rx * rx * ry * ry - rx * rx * dy * dy - ry * ry * dx * dx) / (rx * rx * dy * dy + ry * ry * dx * dx)),
        cx = k * rx * dy / ry + (x1 + x2) / 2,
        cy = k * -ry * dx / rx + (y1 + y2) / 2;

    p.attr({
        x: cx,
        y: cy,
        path: [
            "M", x, y,
            "L", x1, y1,
            "A", rx, ry, 0, 1, 1, x2, y2,
            "z"
        ].join(",")
    });

    this.translate(cx - bb.x - bb.width / 2, cy - bb.y - bb.height / 2);

    return p.insertBefore(this.node ? this : this[0]);
};

/*
 * Tooltips on Paper prototype
 */
/*\
 * Paper.label
 [ method ]
 **
 * Puts the given `text` into a 'label' tooltip. The text is given a default style according to @g.txtattr. See @Element.label
 **
 > Parameters
 **
 - x (number) x coordinate of the center of the label
 - y (number) y coordinate of the center of the label
 - text (string) text to place inside the label
 **
 = (object) set containing the label path and the text element
 > Usage
 | paper.label(50, 50, "$9.99");
 \*/
Raphael.fn.label = function (x, y, text) {
    var set = this.set();

    text = this.text(x, y, text).attr(Raphael.g.txtattr);
    return set.push(text.label(), text);
};

/*\
 * Paper.popup
 [ method ]
 **
 * Puts the given `text` into a 'popup' tooltip. The text is given a default style according to @g.txtattr. See @Element.popup
 *
 * Note: The `dir` parameter has changed from g.Raphael 0.4.1 to 0.5. The options `0`, `1`, `2`, and `3` has been changed to `'down'`, `'left'`, `'up'`, and `'right'` respectively.
 **
 > Parameters
 **
 - x (number) x coordinate of the popup's tail
 - y (number) y coordinate of the popup's tail
 - text (string) text to place inside the popup
 - dir (string) location of the text relative to the tail: `'down'`, `'left'`, `'up'` [default], or `'right'`.
 - size (number) amount of padding around the Element [default: `5`]
 **
 = (object) set containing the popup path and the text element
 > Usage
 | paper.popup(50, 50, "$9.99", 'down');
 \*/
Raphael.fn.popup = function (x, y, text, dir, size) {
    var set = this.set();

    text = this.text(x, y, text).attr(Raphael.g.txtattr);
    
  //sgurin : fix for raphael 2.1 https://github.com/jhurt/g.raphael/commit/97644e810fdb1e2519e2246b1a5be5934232a7de
    //return set.push(text.popup(dir, size), text);
    return set.push(text.popup(dir, size, x, y), text);
};

/*\
 * Paper.tag
 [ method ]
 **
 * Puts the given text into a 'tag' tooltip. The text is given a default style according to @g.txtattr. See @Element.tag
 **
 > Parameters
 **
 - x (number) x coordinate of the center of the tag loop
 - y (number) y coordinate of the center of the tag loop
 - text (string) text to place inside the tag
 - angle (number) angle of orientation in degrees [default: `0`]
 - r (number) radius of the loop [default: `5`]
 **
 = (object) set containing the tag path and the text element
 > Usage
 | paper.tag(50, 50, "$9.99", 60);
 \*/
Raphael.fn.tag = function (x, y, text, angle, r) {
    var set = this.set();

    text = this.text(x, y, text).attr(Raphael.g.txtattr);
    return set.push(text.tag(angle, r), text);
};

/*\
 * Paper.flag
 [ method ]
 **
 * Puts the given `text` into a 'flag' tooltip. The text is given a default style according to @g.txtattr. See @Element.flag
 **
 > Parameters
 **
 - x (number) x coordinate of the flag's point
 - y (number) y coordinate of the flag's point
 - text (string) text to place inside the flag
 - angle (number) angle of orientation in degrees [default: `0`]
 **
 = (object) set containing the flag path and the text element
 > Usage
 | paper.flag(50, 50, "$9.99", 60);
 \*/
Raphael.fn.flag = function (x, y, text, angle) {
    var set = this.set();

    text = this.text(x, y, text).attr(Raphael.g.txtattr);
    return set.push(text.flag(angle), text);
};

/*\
 * Paper.drop
 [ method ]
 **
 * Puts the given text into a 'drop' tooltip. The text is given a default style according to @g.txtattr. See @Element.drop
 **
 > Parameters
 **
 - x (number) x coordinate of the drop's point
 - y (number) y coordinate of the drop's point
 - text (string) text to place inside the drop
 - angle (number) angle of orientation in degrees [default: `0`]
 **
 = (object) set containing the drop path and the text element
 > Usage
 | paper.drop(50, 50, "$9.99", 60);
 \*/
Raphael.fn.drop = function (x, y, text, angle) {
    var set = this.set();

    text = this.text(x, y, text).attr(Raphael.g.txtattr);
    return set.push(text.drop(angle), text);
};

/*\
 * Paper.blob
 [ method ]
 **
 * Puts the given text into a 'blob' tooltip. The text is given a default style according to @g.txtattr. See @Element.blob
 **
 > Parameters
 **
 - x (number) x coordinate of the blob's tail
 - y (number) y coordinate of the blob's tail
 - text (string) text to place inside the blob
 - angle (number) angle of orientation in degrees [default: `0`]
 **
 = (object) set containing the blob path and the text element
 > Usage
 | paper.blob(50, 50, "$9.99", 60);
 \*/
Raphael.fn.blob = function (x, y, text, angle) {
    var set = this.set();

    text = this.text(x, y, text).attr(Raphael.g.txtattr);
    return set.push(text.blob(angle), text);
};

/**
 * Brightness functions on the Element prototype
 */
/*\
 * Element.lighter
 [ method ]
 **
 * Makes the context element lighter by increasing the brightness and reducing the saturation by a given factor. Can be called on Sets.
 **
 > Parameters
 **
 - times (number) adjustment factor [default: `2`]
 **
 = (object) Element
 > Usage
 | paper.circle(50, 50, 20).attr({
 |     fill: "#ff0000",
 |     stroke: "#fff",
 |     "stroke-width": 2
 | }).lighter(6);
 \*/
Raphael.el.lighter = function (times) {
    times = times || 2;

    var fs = [this.attrs.fill, this.attrs.stroke];

    this.fs = this.fs || [fs[0], fs[1]];

    fs[0] = Raphael.rgb2hsb(Raphael.getRGB(fs[0]).hex);
    fs[1] = Raphael.rgb2hsb(Raphael.getRGB(fs[1]).hex);
    fs[0].b = Math.min(fs[0].b * times, 1);
    fs[0].s = fs[0].s / times;
    fs[1].b = Math.min(fs[1].b * times, 1);
    fs[1].s = fs[1].s / times;

    this.attr({fill: "hsb(" + [fs[0].h, fs[0].s, fs[0].b] + ")", stroke: "hsb(" + [fs[1].h, fs[1].s, fs[1].b] + ")"});
    return this;
};

/*\
 * Element.darker
 [ method ]
 **
 * Makes the context element darker by decreasing the brightness and increasing the saturation by a given factor. Can be called on Sets.
 **
 > Parameters
 **
 - times (number) adjustment factor [default: `2`]
 **
 = (object) Element
 > Usage
 | paper.circle(50, 50, 20).attr({
 |     fill: "#ff0000",
 |     stroke: "#fff",
 |     "stroke-width": 2
 | }).darker(6);
 \*/
Raphael.el.darker = function (times) {
    times = times || 2;

    var fs = [this.attrs.fill, this.attrs.stroke];

    this.fs = this.fs || [fs[0], fs[1]];

    fs[0] = Raphael.rgb2hsb(Raphael.getRGB(fs[0]).hex);
    fs[1] = Raphael.rgb2hsb(Raphael.getRGB(fs[1]).hex);
    fs[0].s = Math.min(fs[0].s * times, 1);
    fs[0].b = fs[0].b / times;
    fs[1].s = Math.min(fs[1].s * times, 1);
    fs[1].b = fs[1].b / times;

    this.attr({fill: "hsb(" + [fs[0].h, fs[0].s, fs[0].b] + ")", stroke: "hsb(" + [fs[1].h, fs[1].s, fs[1].b] + ")"});
    return this;
};

/*\
 * Element.resetBrightness
 [ method ]
 **
 * Resets brightness and saturation levels to their original values. See @Element.lighter and @Element.darker. Can be called on Sets.
 **
 = (object) Element
 > Usage
 | paper.circle(50, 50, 20).attr({
 |     fill: "#ff0000",
 |     stroke: "#fff",
 |     "stroke-width": 2
 | }).lighter(6).resetBrightness();
 \*/
Raphael.el.resetBrightness = function () {
    if (this.fs) {
        this.attr({ fill: this.fs[0], stroke: this.fs[1] });
        delete this.fs;
    }
    return this;
};

//alias to set prototype
(function () {
    var brightness = ['lighter', 'darker', 'resetBrightness'],
        tooltips = ['popup', 'tag', 'flag', 'label', 'drop', 'blob'];

    for (var f in tooltips) (function (name) {
        Raphael.st[name] = function () {
            return Raphael.el[name].apply(this, arguments);
        };
    })(tooltips[f]);

    for (var f in brightness) (function (name) {
        Raphael.st[name] = function () {
            for (var i = 0; i < this.length; i++) {
                this[i][name].apply(this[i], arguments);
            }

            return this;
        };
    })(brightness[f]);
})();

//chart prototype for storing common functions
Raphael.g = {
    /*\
     * g.shim
     [ object ]
     **
     * An attribute object that charts will set on all generated shims (shims being the invisible objects that mouse events are bound to)
     **
     > Default value
     | { stroke: 'none', fill: '#000', 'fill-opacity': 0 }
     \*/
    shim: { stroke: 'none', fill: '#000', 'fill-opacity': 0 },

    /*\
     * g.txtattr
     [ object ]
     **
     * An attribute object that charts and tooltips will set on any generated text
     **
     > Default value
     | { font: '12px Arial, sans-serif', fill: '#fff' }
     \*/  
    txtattr: { font: '12px Arial, sans-serif', fill: '#fff' },

    /*\
     * g.colors
     [ array ]
     **
     * An array of color values that charts will iterate through when drawing chart data values.
     **
     \*/
    colors: (function () {
            var hues = [.6, .2, .05, .1333, .75, 0],
                colors = [];

            for (var i = 0; i < 10; i++) {
                if (i < hues.length) {
                    colors.push('hsb(' + hues[i] + ',.75, .75)');
                } else {
                    colors.push('hsb(' + hues[i - hues.length] + ', 1, .5)');
                }
            }

            return colors;
    })(),
    
    snapEnds: function(from, to, steps) {
        var f = from,
            t = to;

        if (f == t) {
            return {from: f, to: t, power: 0};
        }

        function round(a) {
            return Math.abs(a - .5) < .25 ? ~~(a) + .5 : Math.round(a);
        }

        var d = (t - f) / steps,
            r = ~~(d),
            R = r,
            i = 0;

        if (r) {
            while (R) {
                i--;
                R = ~~(d * Math.pow(10, i)) / Math.pow(10, i);
            }

            i ++;
        } else {
            if(d == 0 || !isFinite(d)) {
                i = 1;
            } else {
                while (!r) {
                    i = i || 1;
                    r = ~~(d * Math.pow(10, i)) / Math.pow(10, i);
                    i++;
                }
            }

            i && i--;
        }

        t = round(to * Math.pow(10, i)) / Math.pow(10, i);

        if (t < to) {
            t = round((to + .5) * Math.pow(10, i)) / Math.pow(10, i);
        }

        f = round((from - (i > 0 ? 0 : .5)) * Math.pow(10, i)) / Math.pow(10, i);
        return { from: f, to: t, power: i };
    },

    axis: function (x, y, length, from, to, steps, orientation, labels, type, dashsize, paper) {
        dashsize = dashsize == null ? 2 : dashsize;
        type = type || "t";
        steps = steps || 10;
        paper = arguments[arguments.length-1] //paper is always last argument

        var path = type == "|" || type == " " ? ["M", x + .5, y, "l", 0, .001] : orientation == 1 || orientation == 3 ? ["M", x + .5, y, "l", 0, -length] : ["M", x, y + .5, "l", length, 0],
            ends = this.snapEnds(from, to, steps),
            f = ends.from,
            t = ends.to,
            i = ends.power,
            j = 0,
            txtattr = { font: "11px 'Fontin Sans', Fontin-Sans, sans-serif" },
            text = paper.set(),
            d;

        d = (t - f) / steps;

        var label = f,
            rnd = i > 0 ? i : 0;
            dx = length / steps;

        if (+orientation == 1 || +orientation == 3) {
            var Y = y,
                addon = (orientation - 1 ? 1 : -1) * (dashsize + 3 + !!(orientation - 1));

            while (Y >= y - length) {
                type != "-" && type != " " && (path = path.concat(["M", x - (type == "+" || type == "|" ? dashsize : !(orientation - 1) * dashsize * 2), Y + .5, "l", dashsize * 2 + 1, 0]));
                text.push(paper.text(x + addon, Y, (labels && labels[j++]) || (Math.round(label) == label ? label : +label.toFixed(rnd))).attr(txtattr).attr({ "text-anchor": orientation - 1 ? "start" : "end" }));
                label += d;
                Y -= dx;
            }

            if (Math.round(Y + dx - (y - length))) {
                type != "-" && type != " " && (path = path.concat(["M", x - (type == "+" || type == "|" ? dashsize : !(orientation - 1) * dashsize * 2), y - length + .5, "l", dashsize * 2 + 1, 0]));
                text.push(paper.text(x + addon, y - length, (labels && labels[j]) || (Math.round(label) == label ? label : +label.toFixed(rnd))).attr(txtattr).attr({ "text-anchor": orientation - 1 ? "start" : "end" }));
            }
        } else {
            label = f;
            rnd = (i > 0) * i;
            addon = (orientation ? -1 : 1) * (dashsize + 9 + !orientation);

            var X = x,
                dx = length / steps,
                txt = 0,
                prev = 0;

            while (X <= x + length) {
                type != "-" && type != " " && (path = path.concat(["M", X + .5, y - (type == "+" ? dashsize : !!orientation * dashsize * 2), "l", 0, dashsize * 2 + 1]));
                text.push(txt = paper.text(X, y + addon, (labels && labels[j++]) || (Math.round(label) == label ? label : +label.toFixed(rnd))).attr(txtattr));

                var bb = txt.getBBox();

                if (prev >= bb.x - 5) {
                    text.pop(text.length - 1).remove();
                } else {
                    prev = bb.x + bb.width;
                }

                label += d;
                X += dx;
            }

            if (Math.round(X - dx - x - length)) {
                type != "-" && type != " " && (path = path.concat(["M", x + length + .5, y - (type == "+" ? dashsize : !!orientation * dashsize * 2), "l", 0, dashsize * 2 + 1]));
                text.push(paper.text(x + length, y + addon, (labels && labels[j]) || (Math.round(label) == label ? label : +label.toFixed(rnd))).attr(txtattr));
            }
        }

        var res = paper.path(path);

        res.text = text;
        res.all = paper.set([res, text]);
        res.remove = function () {
            this.text.remove();
            this.constructor.prototype.remove.call(this);
        };

        return res;
    },
    
    labelise: function(label, val, total) {
        if (label) {
            return (label + "").replace(/(##+(?:\.#+)?)|(%%+(?:\.%+)?)/g, function (all, value, percent) {
                if (value) {
                    return (+val).toFixed(value.replace(/^#+\.?/g, "").length);
                }
                if (percent) {
                    return (val * 100 / total).toFixed(percent.replace(/^%+\.?/g, "").length) + "%";
                }
            });
        } else {
            return (+val).toFixed(0);
        }
    }
}

/* g.bar */

/*!
 * g.Raphael 0.51 - Charting library, based on Raphaël
 *
 * Copyright (c) 2009-2012 Dmitry Baranovskiy (http://g.raphaeljs.com)
 * Licensed under the MIT (http://www.opensource.org/licenses/mit-license.php) license.
 */
(function () {
    var mmin = Math.min,
        mmax = Math.max;

    function finger(x, y, width, height, dir, ending, isPath, paper) {
        var path,
            ends = { round: 'round', sharp: 'sharp', soft: 'soft', square: 'square' };

        // dir 0 for horizontal and 1 for vertical
        if ((dir && !height) || (!dir && !width)) {
            return isPath ? "" : paper.path();
        }

        ending = ends[ending] || "square";
        height = Math.round(height);
        width = Math.round(width);
        x = Math.round(x);
        y = Math.round(y);

        switch (ending) {
            case "round":
                if (!dir) {
                    var r = ~~(height / 2);

                    if (width < r) {
                        r = width;
                        path = [
                            "M", x + .5, y + .5 - ~~(height / 2),
                            "l", 0, 0,
                            "a", r, ~~(height / 2), 0, 0, 1, 0, height,
                            "l", 0, 0,
                            "z"
                        ];
                    } else {
                        path = [
                            "M", x + .5, y + .5 - r,
                            "l", width - r, 0,
                            "a", r, r, 0, 1, 1, 0, height,
                            "l", r - width, 0,
                            "z"
                        ];
                    }
                } else {
                    r = ~~(width / 2);

                    if (height < r) {
                        r = height;
                        path = [
                            "M", x - ~~(width / 2), y,
                            "l", 0, 0,
                            "a", ~~(width / 2), r, 0, 0, 1, width, 0,
                            "l", 0, 0,
                            "z"
                        ];
                    } else {
                        path = [
                            "M", x - r, y,
                            "l", 0, r - height,
                            "a", r, r, 0, 1, 1, width, 0,
                            "l", 0, height - r,
                            "z"
                        ];
                    }
                }
                break;
            case "sharp":
                if (!dir) {
                    var half = ~~(height / 2);

                    path = [
                        "M", x, y + half,
                        "l", 0, -height, mmax(width - half, 0), 0, mmin(half, width), half, -mmin(half, width), half + (half * 2 < height),
                        "z"
                    ];
                } else {
                    half = ~~(width / 2);
                    path = [
                        "M", x + half, y,
                        "l", -width, 0, 0, -mmax(height - half, 0), half, -mmin(half, height), half, mmin(half, height), half,
                        "z"
                    ];
                }
                break;
            case "square":
                if (!dir) {
                    path = [
                        "M", x, y + ~~(height / 2),
                        "l", 0, -height, width, 0, 0, height,
                        "z"
                    ];
                } else {
                    path = [
                        "M", x + ~~(width / 2), y,
                        "l", 1 - width, 0, 0, -height, width - 1, 0,
                        "z"
                    ];
                }
                break;
            case "soft":
                if (!dir) {
                    r = mmin(width, Math.round(height / 5));
                    path = [
                        "M", x + .5, y + .5 - ~~(height / 2),
                        "l", width - r, 0,
                        "a", r, r, 0, 0, 1, r, r,
                        "l", 0, height - r * 2,
                        "a", r, r, 0, 0, 1, -r, r,
                        "l", r - width, 0,
                        "z"
                    ];
                } else {
                    r = mmin(Math.round(width / 5), height);
                    path = [
                        "M", x - ~~(width / 2), y,
                        "l", 0, r - height,
                        "a", r, r, 0, 0, 1, r, -r,
                        "l", width - 2 * r, 0,
                        "a", r, r, 0, 0, 1, r, r,
                        "l", 0, height - r,
                        "z"
                    ];
                }
        }

        if (isPath) {
            return path.join(",");
        } else {
            return paper.path(path);
        }
    }

/*\
 * Paper.vbarchart
 [ method ]
 **
 * Creates a vertical bar chart
 **
 > Parameters
 **
 - x (number) x coordinate of the chart
 - y (number) y coordinate of the chart
 - width (number) width of the chart (respected by all elements in the set)
 - height (number) height of the chart (respected by all elements in the set)
 - values (array) values
 - opts (object) options for the chart
 o {
 o type (string) type of endings of the bar. Default: 'square'. Other options are: 'round', 'sharp', 'soft'.
 o gutter (number)(string) default '20%' (WHAT DOES IT DO?)
 o vgutter (number)
 o colors (array) colors be used repeatedly to plot the bars. If multicolumn bar is used each sequence of bars with use a different color.
 o stacked (boolean) whether or not to tread values as in a stacked bar chart
 o to
 o stretch (boolean)
 o }
 **
 = (object) path element of the popup
 > Usage
 | r.vbarchart(0, 0, 620, 260, [76, 70, 67, 71, 69], {})
 \*/
 
    function VBarchart(paper, x, y, width, height, values, opts) {
        opts = opts || {};

        var chartinst = this,
            type = opts.type || "square",
            gutter = parseFloat(opts.gutter || "20%"),
            chart = paper.set(),
            bars = paper.set(),
            covers = paper.set(),
            covers2 = paper.set(),
            total = Math.max.apply(Math, values),
            stacktotal = [],
            multi = 0,
            colors = opts.colors || chartinst.colors,
            len = values.length;

        if (Raphael.is(values[0], "array")) {
            total = [];
            multi = len;
            len = 0;

            for (var i = values.length; i--;) {
                bars.push(paper.set());
                total.push(Math.max.apply(Math, values[i]));
                len = Math.max(len, values[i].length);
            }

            if (opts.stacked) {
                for (var i = len; i--;) {
                    var tot = 0;

                    for (var j = values.length; j--;) {
                        tot +=+ values[j][i] || 0;
                    }

                    stacktotal.push(tot);
                }
            }

            for (var i = values.length; i--;) {
                if (values[i].length < len) {
                    for (var j = len; j--;) {
                        values[i].push(0);
                    }
                }
            }

            total = Math.max.apply(Math, opts.stacked ? stacktotal : total);
        }
        
        total = (opts.to) || total;

        var barwidth = width / (len * (100 + gutter) + gutter) * 100,
            barhgutter = barwidth * gutter / 100,
            barvgutter = opts.vgutter == null ? 20 : opts.vgutter,
            stack = [],
            X = x + barhgutter,
            Y = (height - 2 * barvgutter) / total;

        if (!opts.stretch) {
            barhgutter = Math.round(barhgutter);
            barwidth = Math.floor(barwidth);
        }

        !opts.stacked && (barwidth /= multi || 1);

        for (var i = 0; i < len; i++) {
            stack = [];

            for (var j = 0; j < (multi || 1); j++) {
                var h = Math.round((multi ? values[j][i] : values[i]) * Y),
                    top = y + height - barvgutter - h,
                    bar = finger(Math.round(X + barwidth / 2), top + h, barwidth, h, true, type, null, paper).attr({ stroke: "none", fill: colors[multi ? j : i] });

                if (multi) {
                    bars[j].push(bar);
                } else {
                    bars.push(bar);
                }

                bar.y = top;
                bar.x = Math.round(X + barwidth / 2);
                bar.w = barwidth;
                bar.h = h;
                bar.value = multi ? values[j][i] : values[i];

                if (!opts.stacked) {
                    X += barwidth;
                } else {
                    stack.push(bar);
                }
            }

            if (opts.stacked) {
                var cvr;

                covers2.push(cvr = paper.rect(stack[0].x - stack[0].w / 2, y, barwidth, height).attr(chartinst.shim));
                cvr.bars = paper.set();

                var size = 0;

                for (var s = stack.length; s--;) {
                    stack[s].toFront();
                }

                for (var s = 0, ss = stack.length; s < ss; s++) {
                    var bar = stack[s],
                        cover,
                        h = (size + bar.value) * Y,
                        path = finger(bar.x, y + height - barvgutter - !!size * .5, barwidth, h, true, type, 1, paper);

                    cvr.bars.push(bar);
                    size && bar.attr({path: path});
                    bar.h = h;
                    bar.y = y + height - barvgutter - !!size * .5 - h;
                    covers.push(cover = paper.rect(bar.x - bar.w / 2, bar.y, barwidth, bar.value * Y).attr(chartinst.shim));
                    cover.bar = bar;
                    cover.value = bar.value;
                    size += bar.value;
                }

                X += barwidth;
            }

            X += barhgutter;
        }

        covers2.toFront();
        X = x + barhgutter;

        if (!opts.stacked) {
            for (var i = 0; i < len; i++) {
                for (var j = 0; j < (multi || 1); j++) {
                    var cover;

                    covers.push(cover = paper.rect(Math.round(X), y + barvgutter, barwidth, height - barvgutter).attr(chartinst.shim));
                    cover.bar = multi ? bars[j][i] : bars[i];
                    cover.value = cover.bar.value;
                    X += barwidth;
                }

                X += barhgutter;
            }
        }

        /**
         * sgurin rewritten
         * @param labels an array of array of strings, 
         * like [["label1", ...]]. dimensions must be same. 
         * it will store labels in a set of sets called this.labels, for example:
         * 
         * var g1 = paper.barchart(...).label([[...]]);
         * g1.label.forEach(function(labelSet){
         * 		//labelSet is the n-th set of labels:
         * 
         * 		labelSet.forEach(function(label){
         * 			//do something with each individual label
         * 		})
         * });
         * @returns
         */
        chart.label = function (labels) {
            labels = labels || [];
            this.labels = paper.set();
            
        	var root=this[0];
        	for(var i = 0; i < root.length; i++) {
        		var set = root[i], 
        			l1 = [];
        		if(set) for ( var j = 0; j < set.length; j++) {
        			var bar = set[j], bb = bar.getBBox();
					l1.push(paper.label(bb.x, bb.y, labels[i][j]));
				}
        	}
        	this.push(this.labels);
        	
            return this;
        };
        
//        chart.label = function (labels, isBottom) {
//            labels = labels || [];
//            this.labels = paper.set();
//
//            var L, l = -Infinity;
//
//            if (opts.stacked) {
//                for (var i = 0; i < len; i++) {
//                    var tot = 0;
//
//                    for (var j = 0; j < (multi || 1); j++) {
//                        tot += multi ? values[j][i] : values[i];
//
//                        if (j == multi - 1) {
//                            var label = paper.labelise(labels[i], tot, total);
//
//                            L = paper.text(bars[i * (multi || 1) + j].x, y + height - barvgutter / 2, label).attr(txtattr).insertBefore(covers[i * (multi || 1) + j]);
//
//                            var bb = L.getBBox();
//
//                            if (bb.x - 7 < l) {
//                                L.remove();
//                            } else {
//                                this.labels.push(L);
//                                l = bb.x + bb.width;
//                            }
//                        }
//                    }
//                }
//            } else {
//                for (var i = 0; i < len; i++) {
//                    for (var j = 0; j < (multi || 1); j++) {
//                        var label = paper.labelise(multi ? labels[j] && labels[j][i] : labels[i], multi ? values[j][i] : values[i], total);
//
//                        L = paper.text(bars[i * (multi || 1) + j].x, isBottom ? y + height - barvgutter / 2 : bars[i * (multi || 1) + j].y - 10, label).attr(txtattr).insertBefore(covers[i * (multi || 1) + j]);
//
//                        var bb = L.getBBox();
//
//                        if (bb.x - 7 < l) {
//                            L.remove();
//                        } else {
//                            this.labels.push(L);
//                            l = bb.x + bb.width;
//                        }
//                    }
//                }
//            }
//            return this;
//        };

        chart.hover = function (fin, fout) {
            covers2.hide();
            covers.show();
            covers.mouseover(fin).mouseout(fout);
            return this;
        };

        chart.hoverColumn = function (fin, fout) {
            covers.hide();
            covers2.show();
            fout = fout || function () {};
            covers2.mouseover(fin).mouseout(fout);
            return this;
        };

        chart.click = function (f) {
            covers2.hide();
            covers.show();
            covers.click(f);
            return this;
        };

        chart.each = function (f) {
            if (!Raphael.is(f, "function")) {
                return this;
            }
            for (var i = covers.length; i--;) {
                f.call(covers[i]);
            }
            return this;
        };

        chart.eachColumn = function (f) {
            if (!Raphael.is(f, "function")) {
                return this;
            }
            for (var i = covers2.length; i--;) {
                f.call(covers2[i]);
            }
            return this;
        };

        chart.clickColumn = function (f) {
            covers.hide();
            covers2.show();
            covers2.click(f);
            return this;
        };

        chart.push(bars, covers, covers2);
        chart.bars = bars;
        chart.covers = covers;
        return chart;
    };
    
    //inheritance
    var F = function() {};
    F.prototype = Raphael.g;
    HBarchart.prototype = VBarchart.prototype = new F; //prototype reused by hbarchart
    
    Raphael.fn.barchart = function(x, y, width, height, values, opts) {
        return new VBarchart(this, x, y, width, height, values, opts);
    };
    
/*\
 * Paper.barchart
 [ method ]
 **
 * Creates a horizontal bar chart
 **
 > Parameters
 **
 - x (number) x coordinate of the chart
 - y (number) y coordinate of the chart
 - width (number) width of the chart (respected by all elements in the set)
 - height (number) height of the chart (respected by all elements in the set)
 - values (array) values
 - opts (object) options for the chart
 o {
 o type (string) type of endings of the bar. Default: 'square'. Other options are: 'round', 'sharp', 'soft'.
 o gutter (number)(string) default '20%' (WHAT DOES IT DO?)
 o vgutter (number)
 o colors (array) colors be used repeatedly to plot the bars. If multicolumn bar is used each sequence of bars with use a different color.
 o stacked (boolean) whether or not to tread values as in a stacked bar chart
 o to
 o stretch (boolean)
 o }
 **
 = (object) path element of the popup
 > Usage
 | r.barchart(0, 0, 620, 260, [76, 70, 67, 71, 69], {})
 \*/
 
    function HBarchart(paper, x, y, width, height, values, opts) {
        opts = opts || {};

        var chartinst = this,
            type = opts.type || "square",
            gutter = parseFloat(opts.gutter || "20%"),
            chart = paper.set(),
            bars = paper.set(),
            covers = paper.set(),
            covers2 = paper.set(),
            total = Math.max.apply(Math, values),
            stacktotal = [],
            multi = 0,
            colors = opts.colors || chartinst.colors,
            len = values.length;

        if (Raphael.is(values[0], "array")) {
            total = [];
            multi = len;
            len = 0;

            for (var i = values.length; i--;) {
                bars.push(paper.set());
                total.push(Math.max.apply(Math, values[i]));
                len = Math.max(len, values[i].length);
            }

            if (opts.stacked) {
                for (var i = len; i--;) {
                    var tot = 0;
                    for (var j = values.length; j--;) {
                        tot +=+ values[j][i] || 0;
                    }
                    stacktotal.push(tot);
                }
            }

            for (var i = values.length; i--;) {
                if (values[i].length < len) {
                    for (var j = len; j--;) {
                        values[i].push(0);
                    }
                }
            }

            total = Math.max.apply(Math, opts.stacked ? stacktotal : total);
        }
        
        total = (opts.to) || total;

        var barheight = Math.floor(height / (len * (100 + gutter) + gutter) * 100),
            bargutter = Math.floor(barheight * gutter / 100),
            stack = [],
            Y = y + bargutter,
            X = (width - 1) / total;

        !opts.stacked && (barheight /= multi || 1);

        for (var i = 0; i < len; i++) {
            stack = [];

            for (var j = 0; j < (multi || 1); j++) {
                var val = multi ? values[j][i] : values[i],
                    bar = finger(x, Y + barheight / 2, Math.round(val * X), barheight - 1, false, type, null, paper).attr({stroke: "none", fill: colors[multi ? j : i]});

                if (multi) {
                    bars[j].push(bar);
                } else {
                    bars.push(bar);
                }

                bar.x = x + Math.round(val * X);
                bar.y = Y + barheight / 2;
                bar.w = Math.round(val * X);
                bar.h = barheight;
                bar.value = +val;

                if (!opts.stacked) {
                    Y += barheight;
                } else {
                    stack.push(bar);
                }
            }

            if (opts.stacked) {
                var cvr = paper.rect(x, stack[0].y - stack[0].h / 2, width, barheight).attr(chartinst.shim);

                covers2.push(cvr);
                cvr.bars = paper.set();

                var size = 0;

                for (var s = stack.length; s--;) {
                    stack[s].toFront();
                }

                for (var s = 0, ss = stack.length; s < ss; s++) {
                    var bar = stack[s],
                        cover,
                        val = Math.round((size + bar.value) * X),
                        path = finger(x, bar.y, val, barheight - 1, false, type, 1, paper);

                    cvr.bars.push(bar);
                    size && bar.attr({ path: path });
                    bar.w = val;
                    bar.x = x + val;
                    covers.push(cover = paper.rect(x + size * X, bar.y - bar.h / 2, bar.value * X, barheight).attr(chartinst.shim));
                    cover.bar = bar;
                    size += bar.value;
                }

                Y += barheight;
            }

            Y += bargutter;
        }

        covers2.toFront();
        Y = y + bargutter;

        if (!opts.stacked) {
            for (var i = 0; i < len; i++) {
                for (var j = 0; j < (multi || 1); j++) {
                    var cover = paper.rect(x, Y, width, barheight).attr(chartinst.shim);

                    covers.push(cover);
                    cover.bar = multi ? bars[j][i] : bars[i];
                    cover.value = cover.bar.value;
                    Y += barheight;
                }

                Y += bargutter;
            }
        }

        chart.label = function (labels, isRight) {
            labels = labels || [];
            this.labels = paper.set();

            for (var i = 0; i < len; i++) {
                for (var j = 0; j < multi; j++) {
                    var  label = paper.labelise(multi ? labels[j] && labels[j][i] : labels[i], multi ? values[j][i] : values[i], total),
                        X = isRight ? bars[i * (multi || 1) + j].x - barheight / 2 + 3 : x + 5,
                        A = isRight ? "end" : "start",
                        L;

                    this.labels.push(L = paper.text(X, bars[i * (multi || 1) + j].y, label).attr(txtattr).attr({ "text-anchor": A }).insertBefore(covers[0]));

                    if (L.getBBox().x < x + 5) {
                        L.attr({x: x + 5, "text-anchor": "start"});
                    } else {
                        bars[i * (multi || 1) + j].label = L;
                    }
                }
            }

            return this;
        };

        chart.hover = function (fin, fout) {
            covers2.hide();
            covers.show();
            fout = fout || function () {};
            covers.mouseover(fin).mouseout(fout);
            return this;
        };

        chart.hoverColumn = function (fin, fout) {
            covers.hide();
            covers2.show();
            fout = fout || function () {};
            covers2.mouseover(fin).mouseout(fout);
            return this;
        };

        chart.each = function (f) {
            if (!Raphael.is(f, "function")) {
                return this;
            }
            for (var i = covers.length; i--;) {
                f.call(covers[i]);
            }
            return this;
        };

        chart.eachColumn = function (f) {
            if (!Raphael.is(f, "function")) {
                return this;
            }
            for (var i = covers2.length; i--;) {
                f.call(covers2[i]);
            }
            return this;
        };

        chart.click = function (f) {
            covers2.hide();
            covers.show();
            covers.click(f);
            return this;
        };

        chart.clickColumn = function (f) {
            covers.hide();
            covers2.show();
            covers2.click(f);
            return this;
        };

        chart.push(bars, covers, covers2);
        chart.bars = bars;
        chart.covers = covers;
        return chart;
    };
    
    Raphael.fn.hbarchart = function(x, y, width, height, values, opts) {
        return new HBarchart(this, x, y, width, height, values, opts);
    };
    
})();

/* g.dot */

/*!
 * g.Raphael 0.51 - Charting library, based on Raphaël
 *
 * Copyright (c) 2009-2012 Dmitry Baranovskiy (http://g.raphaeljs.com)
 * Licensed under the MIT (http://www.opensource.org/licenses/mit-license.php) license.
 */

(function () {
        var colorValue = function (value, total, s, b) {
            return 'hsb(' + [Math.min((1 - value / total) * .4, 1), s || .75, b || .75] + ')';
        };
 
    function Dotchart(paper, x, y, width, height, valuesx, valuesy, size, opts) {
        
        function drawAxis(ax) {
            +ax[0] && (ax[0] = chartinst.axis(x + gutter, y + gutter, width - 2 * gutter, minx, maxx, opts.axisxstep || Math.floor((width - 2 * gutter) / 20), 2, opts.axisxlabels || null, opts.axisxtype || "t", null, paper));
            +ax[1] && (ax[1] = chartinst.axis(x + width - gutter, y + height - gutter, height - 2 * gutter, miny, maxy, opts.axisystep || Math.floor((height - 2 * gutter) / 20), 3, opts.axisylabels || null, opts.axisytype || "t", null, paper));
            +ax[2] && (ax[2] = chartinst.axis(x + gutter, y + height - gutter + maxR, width - 2 * gutter, minx, maxx, opts.axisxstep || Math.floor((width - 2 * gutter) / 20), 0, opts.axisxlabels || null, opts.axisxtype || "t", null, paper));
            +ax[3] && (ax[3] = chartinst.axis(x + gutter - maxR, y + height - gutter, height - 2 * gutter, miny, maxy, opts.axisystep || Math.floor((height - 2 * gutter) / 20), 1, opts.axisylabels || null, opts.axisytype || "t", null, paper));
        }
        
        //providing defaults
        
        opts = opts || {};
        var chartinst = this;
        var xdim = chartinst.snapEnds(Math.min.apply(Math, valuesx), Math.max.apply(Math, valuesx), valuesx.length - 1),
            minx = xdim.from,
            maxx = xdim.to,
            gutter = opts.gutter || 10,
            ydim = chartinst.snapEnds(Math.min.apply(Math, valuesy), Math.max.apply(Math, valuesy), valuesy.length - 1),
            miny = ydim.from,
            maxy = ydim.to,
            len = Math.max(valuesx.length, valuesy.length, size.length),
            symbol = paper[opts.symbol] || "circle",
            res = paper.set(),
            series = paper.set(),
            max = opts.max || 100,
            top = Math.max.apply(Math, size),
            R = [],
            k = Math.sqrt(top / Math.PI) * 2 / max;

        for (var i = 0; i < len; i++) {
            R[i] = Math.min(Math.sqrt(size[i] / Math.PI) * 2 / k, max);
        }

        gutter = Math.max.apply(Math, R.concat(gutter));

 /*\
 * dotchart.axis
 [ object ]
 **
 * Set containing Elements of the chart axis. Only exists if `'axis'` definition string was passed to @Paper.dotchart
 **
 \*/
        var axis = paper.set(),
            maxR = Math.max.apply(Math, R);

        if (opts.axis) {
            var ax = (opts.axis + "").split(/[,\s]+/);

            drawAxis.call(chartinst, ax);

            var g = [], b = [];

            for (var i = 0, ii = ax.length; i < ii; i++) {
                var bb = ax[i].all ? ax[i].all.getBBox()[["height", "width"][i % 2]] : 0;

                g[i] = bb + gutter;
                b[i] = bb;
            }

            gutter = Math.max.apply(Math, g.concat(gutter));

            for (var i = 0, ii = ax.length; i < ii; i++) if (ax[i].all) {
                ax[i].remove();
                ax[i] = 1;
            }

            drawAxis.call(chartinst, ax);

            for (var i = 0, ii = ax.length; i < ii; i++) if (ax[i].all) {
                axis.push(ax[i].all);
            }

            res.axis = axis;
        }

        var kx = (width - gutter * 2) / ((maxx - minx) || 1),
            ky = (height - gutter * 2) / ((maxy - miny) || 1);

        for (var i = 0, ii = valuesy.length; i < ii; i++) {
            var sym = paper.raphael.is(symbol, "array") ? symbol[i] : symbol,
                X = x + gutter + (valuesx[i] - minx) * kx,
                Y = y + height - gutter - (valuesy[i] - miny) * ky;

            sym && R[i] && series.push(paper[sym](X, Y, R[i]).attr({ fill: opts.heat ? colorValue(R[i], maxR) : chartinst.colors[0], "fill-opacity": opts.opacity ? R[i] / max : 1, stroke: "none" }));
        }

        var covers = paper.set();

        for (var i = 0, ii = valuesy.length; i < ii; i++) {
            var X = x + gutter + (valuesx[i] - minx) * kx,
                Y = y + height - gutter - (valuesy[i] - miny) * ky;

            covers.push(paper.circle(X, Y, maxR).attr(chartinst.shim));
            opts.href && opts.href[i] && covers[i].attr({href: opts.href[i]});
            covers[i].r = +R[i].toFixed(3);
            covers[i].x = +X.toFixed(3);
            covers[i].y = +Y.toFixed(3);
            covers[i].X = valuesx[i];
            covers[i].Y = valuesy[i];
            covers[i].value = size[i] || 0;
            covers[i].dot = series[i];
        }

 /*\
 * dotchart.covers
 [ object ]
 **
 * Set of Elements positioned above the symbols and mirroring them in size and shape. Covers are used as a surface for events capturing. Each cover has a property `'dot'` being a reference to the actual data-representing symbol. 
 **
 ** 
 \*/
        res.covers = covers;
 /*\
 * dotchart.series
 [ object ]
 **
 * Set of Elements containing the actual data-representing symbols.
 **
 ** 
 \*/
        res.series = series;
        res.push(series, axis, covers);

 /*\
 * dotchart.hover
 [ method ]
 > Parameters
 - mouseover handler (function) handler for the event
 - mouseout handler (function) handler for the event
 * Conveniece method to set up hover-in and hover-out event handlers
 = (object) @dotchart object
 **
 \*/
        res.hover = function (fin, fout) {
            covers.mouseover(fin).mouseout(fout);
            return this;
        };

 /*\
 * dotchart.click
 [ method ]
 > Parameters
 - click handler (function) handler for the event
 * Conveniece method to set up click event handler
 = (object) @dotchart object
 **
 \*/
        res.click = function (f) {
            covers.click(f);
            return this;
        };

 /*\
 * dotchart.each
 [ method ]
 > Parameters
 - callback (function) called for every item in @dotchart.covers.
 - this (object) callback is executed in a context of a cover element object
 * Conveniece method iterating on every symbol in the chart
 = (object) @dotchart object
 **
 \*/
        res.each = function (f) {
            if (!paper.raphael.is(f, "function")) {
                return this;
            }

            for (var i = covers.length; i--;) {
                f.call(covers[i]);
            }

            return this;
        };

 /*\
 * dotchart.href
 [ method ]
 > Parameters
 - map (array) Array of objects `{x: 1, y: 20, value: 15, href: "http://www.raphaeljs.com"}`
 * Iterates on all @dotchart.covers elements. If x, y and value on the object are the same as on the cover it sets up a link on a symbol using the passef `href`.
 = (object) @dotchart object
 **
 \*/
        res.href = function (map) {
            var cover;

            for (var i = covers.length; i--;) {
                cover = covers[i];

                if (cover.X == map.x && cover.Y == map.y && cover.value == map.value) {
                    cover.attr({href: map.href});
                }
            }
        };
        return res;
    };
    
    //inheritance
    var F = function() {};
    F.prototype = Raphael.g
    Dotchart.prototype = new F;
    
/*
 * dotchart method on paper
 */
/*\
 * Paper.dotchart
 [ method ]
 **
 * Plots a dot chart
 **
 > Parameters
 - x (number) x coordinate of the chart
 - y (number) y coordinate of the chart
 - width (number) width of the chart (respected by all elements in the set)
 - height (number) height of the chart (respected by all elements in the set)
 - valuesx (array) values used to plot x asis
 - valuesy (array) values used to plot y asis
 - size (array) values used as data
 - opts (object) options for the chart
 > Possible options
 o {
 o max (number) maximum diameter of a dot [default: 100]
 o symbol (string) symbol used for rendering on the chart. The only possible option is `'circle'` [default]
 o gutter (number) distance between symbols on the chart [default: 10]
 o heat (boolean) whether or not to enable coloring higher value symbols with warmer hue [default: false]
 o opacity (number) opacity of the symbols [default: 1]
 o href (array) array of URLs to set up click-throughs on the symbols
 o axis (string) Which axes should be renedered. String of four values evaluated in order `'top right bottom left'` e.g. `'0 0 1 1'`.
 o axisxstep (number) the number of steps to plot on the axis X
 o axisystep (number) the number of steps to plot on the axis Y
 o axisxlabels (array) labels to be rendered instead of numeric values on axis X
 o axisylabels (array) labels to be rendered instead of numeric values on axis Y
 o axisxtype (string) Possible values: `'t'` [default], `'|'`, `' '`, `'-'`, `'+'` 
 o axisytype (string) Possible values: `'t'` [default], `'|'`, `' '`, `'-'`, `'+'`
 o }
 **
 = (object) @dotchart object
 > Usage
 | //life, expectancy, country and spending per capita (fictional data)
 | r.dotchart(0, 0, 620, 260, [76, 70, 67, 71, 69], [0, 1, 2, 3, 4], [100, 120, 140, 160, 500], {max: 10, axisylabels: ['Mexico', 'Argentina', 'Cuba', 'Canada', 'United States of America'], heat: true, axis: '0 0 1 1'})
 \*/
    Raphael.fn.dotchart = function(x, y, width, height, valuesx, valuesy, size, opts) {
        return new Dotchart(this, x, y, width, height, valuesx, valuesy, size, opts);
    }
})();

/* g.line */

/*!
 * g.Raphael 0.51 - Charting library, based on Raphaël
 *
 * Copyright (c) 2009-2012 Dmitry Baranovskiy (http://g.raphaeljs.com)
 * Licensed under the MIT (http://www.opensource.org/licenses/mit-license.php) license.
 */

(function () {

    function shrink(values, dim) {
        var k = values.length / dim,
            j = 0,
            l = k,
            sum = 0,
            res = [];

        while (j < values.length) {
            l--;

            if (l < 0) {
                sum += values[j] * (1 + l);
                res.push(sum / k);
                sum = values[j++] * -l;
                l += k;
            } else {
                sum += values[j++] * 1;
            }
        }
        return res;
    }

    function getAnchors(p1x, p1y, p2x, p2y, p3x, p3y) {
        var l1 = (p2x - p1x) / 2,
            l2 = (p3x - p2x) / 2,
            a = Math.atan((p2x - p1x) / Math.abs(p2y - p1y)),
            b = Math.atan((p3x - p2x) / Math.abs(p2y - p3y));

        a = p1y < p2y ? Math.PI - a : a;
        b = p3y < p2y ? Math.PI - b : b;

        var alpha = Math.PI / 2 - ((a + b) % (Math.PI * 2)) / 2,
            dx1 = l1 * Math.sin(alpha + a),
            dy1 = l1 * Math.cos(alpha + a),
            dx2 = l2 * Math.sin(alpha + b),
            dy2 = l2 * Math.cos(alpha + b);

        return {
            x1: p2x - dx1,
            y1: p2y + dy1,
            x2: p2x + dx2,
            y2: p2y + dy2
        };
    }

    function Linechart(paper, x, y, width, height, valuesx, valuesy, opts) {
        
        var chartinst = this;
        
        opts = opts || {};

        if (!paper.raphael.is(valuesx[0], "array")) {
            valuesx = [valuesx];
        }

        if (!paper.raphael.is(valuesy[0], "array")) {
            valuesy = [valuesy];
        }

        var gutter = opts.gutter || 10,
            len = Math.max(valuesx[0].length, valuesy[0].length),
            symbol = opts.symbol || "",
            colors = opts.colors || chartinst.colors,
            columns = null,
            dots = null,
            chart = paper.set(),
            path = [];

        for (var i = 0, ii = valuesy.length; i < ii; i++) {
            len = Math.max(len, valuesy[i].length);
        }

 /*\
 * linechart.shades
 [ object ]
 **
 * Set containing Elements corresponding to shades plotted in the chart (if `opts.shade` was `true`).
 **
 ** 
 \*/
        var shades = paper.set();

        for (i = 0, ii = valuesy.length; i < ii; i++) {
            if (opts.shade) {
                shades.push(paper.path().attr({ stroke: "none", fill: colors[i], opacity: opts.nostroke ? 1 : .3 }));
            }

            if (valuesy[i].length > width - 2 * gutter) {
                valuesy[i] = shrink(valuesy[i], width - 2 * gutter);
                len = width - 2 * gutter;
            }

            if (valuesx[i] && valuesx[i].length > width - 2 * gutter) {
                valuesx[i] = shrink(valuesx[i], width - 2 * gutter);
            }
        }

        var allx = Array.prototype.concat.apply([], valuesx),
            ally = Array.prototype.concat.apply([], valuesy),
            xdim = chartinst.snapEnds(Math.min.apply(Math, allx), Math.max.apply(Math, allx), valuesx[0].length - 1),
            minx = xdim.from,
            maxx = xdim.to,
            ydim = chartinst.snapEnds(Math.min.apply(Math, ally), Math.max.apply(Math, ally), valuesy[0].length - 1),
            miny = ydim.from,
            maxy = ydim.to,
            kx = (width - gutter * 2) / ((maxx - minx) || 1),
            ky = (height - gutter * 2) / ((maxy - miny) || 1);

 /*\
 * linechart.axis
 [ object ]
 **
 * Set containing Elements of the chart axis. The set is populated if `'axis'` definition string was passed to @Paper.linechart 
 **
 ** 
 \*/
        var axis = paper.set();

        if (opts.axis) {
            var ax = (opts.axis + "").split(/[,\s]+/);
            +ax[0] && axis.push(chartinst.axis(x + gutter, y + gutter, width - 2 * gutter, minx, maxx, opts.axisxstep || Math.floor((width - 2 * gutter) / 20), 2, paper));
            +ax[1] && axis.push(chartinst.axis(x + width - gutter, y + height - gutter, height - 2 * gutter, miny, maxy, opts.axisystep || Math.floor((height - 2 * gutter) / 20), 3, paper));
            +ax[2] && axis.push(chartinst.axis(x + gutter, y + height - gutter, width - 2 * gutter, minx, maxx, opts.axisxstep || Math.floor((width - 2 * gutter) / 20), 0, paper));
            +ax[3] && axis.push(chartinst.axis(x + gutter, y + height - gutter, height - 2 * gutter, miny, maxy, opts.axisystep || Math.floor((height - 2 * gutter) / 20), 1, paper));
        }

 /*\
 * linechart.lines
 [ object ]
 **
 * Set containing Elements corresponding to lines plotted in the chart.
 **
 ** 
 \*/
        var lines = paper.set(),
 /*\
 * linechart.symbols
 [ object ]
 **
 * Set containing Elements corresponding to symbols plotted in the chart.
 **
 ** 
 \*/
            symbols = paper.set(),
            line;

        for (i = 0, ii = valuesy.length; i < ii; i++) {
            if (!opts.nostroke) {
                lines.push(line = paper.path().attr({
                    stroke: colors[i],
                    "stroke-width": opts.width || 2,
                    "stroke-linejoin": "round",
                    "stroke-linecap": "round",
                    "stroke-dasharray": opts.dash || ""
                }));
            }

            var sym = Raphael.is(symbol, "array") ? symbol[i] : symbol,
                symset = paper.set();

            path = [];

            for (var j = 0, jj = valuesy[i].length; j < jj; j++) {
                var X = x + gutter + ((valuesx[i] || valuesx[0])[j] - minx) * kx,
                    Y = y + height - gutter - (valuesy[i][j] - miny) * ky;

                (Raphael.is(sym, "array") ? sym[j] : sym) && symset.push(paper[Raphael.is(sym, "array") ? sym[j] : sym](X, Y, (opts.width || 2) * 3).attr({ fill: colors[i], stroke: "none" }));

                if (opts.smooth) {
                    if (j && j != jj - 1) {
                        var X0 = x + gutter + ((valuesx[i] || valuesx[0])[j - 1] - minx) * kx,
                            Y0 = y + height - gutter - (valuesy[i][j - 1] - miny) * ky,
                            X2 = x + gutter + ((valuesx[i] || valuesx[0])[j + 1] - minx) * kx,
                            Y2 = y + height - gutter - (valuesy[i][j + 1] - miny) * ky,
                            a = getAnchors(X0, Y0, X, Y, X2, Y2);

                        path = path.concat([a.x1, a.y1, X, Y, a.x2, a.y2]);
                    }

                    if (!j) {
                        path = ["M", X, Y, "C", X, Y];
                    }
                } else {
                    path = path.concat([j ? "L" : "M", X, Y]);
                }
            }

            if (opts.smooth) {
                path = path.concat([X, Y, X, Y]);
            }

            symbols.push(symset);

            if (opts.shade) {
                shades[i].attr({ path: path.concat(["L", X, y + height - gutter, "L",  x + gutter + ((valuesx[i] || valuesx[0])[0] - minx) * kx, y + height - gutter, "z"]).join(",") });
            }

            !opts.nostroke && line.attr({ path: path.join(",") });
        }

        function createColumns(f) {
            // unite Xs together
            var Xs = [];

            for (var i = 0, ii = valuesx.length; i < ii; i++) {
                Xs = Xs.concat(valuesx[i]);
            }

            Xs.sort(function(a,b) { return a - b; });
            // remove duplicates

            var Xs2 = [],
                xs = [];

            for (i = 0, ii = Xs.length; i < ii; i++) {
                Xs[i] != Xs[i - 1] && Xs2.push(Xs[i]) && xs.push(x + gutter + (Xs[i] - minx) * kx);
            }

            Xs = Xs2;
            ii = Xs.length;

            var cvrs = f || paper.set();

            for (i = 0; i < ii; i++) {
                var X = xs[i] - (xs[i] - (xs[i - 1] || x)) / 2,
                    w = ((xs[i + 1] || x + width) - xs[i]) / 2 + (xs[i] - (xs[i - 1] || x)) / 2,
                    C;

                f ? (C = {}) : cvrs.push(C = paper.rect(X - 1, y, Math.max(w + 1, 1), height).attr({ stroke: "none", fill: "#000", opacity: 0 }));
                C.values = [];
                C.symbols = paper.set();
                C.y = [];
                C.x = xs[i];
                C.axis = Xs[i];

                for (var j = 0, jj = valuesy.length; j < jj; j++) {
                    Xs2 = valuesx[j] || valuesx[0];

                    for (var k = 0, kk = Xs2.length; k < kk; k++) {
                        if (Xs2[k] == Xs[i]) {
                            C.values.push(valuesy[j][k]);
                            C.y.push(y + height - gutter - (valuesy[j][k] - miny) * ky);
                            C.symbols.push(chart.symbols[j][k]);
                        }
                    }
                }

                f && f.call(C);
            }

            !f && (columns = cvrs);
        }

        function createDots(f) {
            var cvrs = f || paper.set(),
                C;

            for (var i = 0, ii = valuesy.length; i < ii; i++) {
                for (var j = 0, jj = valuesy[i].length; j < jj; j++) {
                    var X = x + gutter + ((valuesx[i] || valuesx[0])[j] - minx) * kx,
                        nearX = x + gutter + ((valuesx[i] || valuesx[0])[j ? j - 1 : 1] - minx) * kx,
                        Y = y + height - gutter - (valuesy[i][j] - miny) * ky;
                    f ? (C = {}) : cvrs.push(C = paper.circle(X, Y, Math.abs(nearX - X) / 2).attr({ stroke: "#000", fill: "#000", opacity: 1 }));
                    C.x = X;
                    C.y = Y;
                    C.value = valuesy[i][j];
                    C.line = chart.lines[i];
                    C.shade = chart.shades[i];
                    C.symbol = chart.symbols[i][j];
                    C.symbols = chart.symbols[i];
                    C.axis = (valuesx[i] || valuesx[0])[j];
                    f && f.call(C);
                }
            }

            !f && (dots = cvrs);
        }

        chart.push(lines, shades, symbols, axis, columns, dots);
        chart.lines = lines;
        chart.shades = shades;
        chart.symbols = symbols;
        chart.axis = axis;

 /*\
 * linechart.hoverColumn
 [ method ]
 > Parameters
 - mouseover handler (function) handler for the event
 - mouseout handler (function) handler for the event
 - this (object) callback is executed in a context of a cover element
 * Conveniece method to set up hover-in and hover-out event handlers on the entire area of the chart.
 * The handlers are passed a event object containing 
 o {
 o x (number) x coordinate on all lines in the chart
 o y (array) y coordinates of all lines corresponding to the x
 o }
 = (object) @linechart object
 **
 \*/
 
        chart.hoverColumn = function (fin, fout) {
            !columns && createColumns();
            columns.mouseover(fin).mouseout(fout);
            return this;
        };

 /*\
 * linechart.clickColumn
 [ method ]
 > Parameters
 - click handler (function) handler for the event
 - this (object) callback is executed in a context of a cover element
 * Conveniece method to set up click event handler on the antire area of the chart.
 * The handler is passed a event object containing 
 o {
 o x (number) x coordinate on all lines in the chart
 o y (array) y coordinates of all lines corresponding to the x
 o }
 = (object) @linechart object
 **
 \*/
        chart.clickColumn = function (f) {
            !columns && createColumns();
            columns.click(f);
            return this;
        };

 /*\
 * linechart.hrefColumn
 [ method ]
 > Parameters
 - cols (object) object containing values as keys and URLs as values, e.g. {1: 'http://www.raphaeljs.com', 2: 'http://g.raphaeljs.com'}
 * Creates click-throughs on the whole area of the chart corresponding to x values
 = (object) @linechart object
 **
 \*/
        chart.hrefColumn = function (cols) {
            var hrefs = paper.raphael.is(arguments[0], "array") ? arguments[0] : arguments;

            if (!(arguments.length - 1) && typeof cols == "object") {
                for (var x in cols) {
                    for (var i = 0, ii = columns.length; i < ii; i++) if (columns[i].axis == x) {
                        columns[i].attr("href", cols[x]);
                    }
                }
            }

            !columns && createColumns();

            for (i = 0, ii = hrefs.length; i < ii; i++) {
                columns[i] && columns[i].attr("href", hrefs[i]);
            }

            return this;
        };

 /*\
 * linechart.hover
 [ method ]
 > Parameters
 - mouseover handler (function) handler for the event
 - mouseout handler (function) handler for the event
 * Conveniece method to set up hover-in and hover-out event handlers working on the lines of the chart.
 * Use @linechart.hoverColumn to work with the entire chart area.
 = (object) @linechart object
 **
 \*/
        chart.hover = function (fin, fout) {
            !dots && createDots();
            dots.mouseover(fin).mouseout(fout);
            return this;
        };

 /*\
 * linechart.click
 [ method ]
 > Parameters
 - click handler (function) handler for the event
 - this (object) callback is executed in a context of a cover element
 * Conveniece method to set up click event handler on the lines of the chart
 * Use @linechart.clickColumn to work with the entire chart area.
 = (object) @linechart object
 **
 \*/
        chart.click = function (f) {
            !dots && createDots();
            dots.click(f);
            return this;
        };

 /*\
 * linechart.each
 [ method ]
 > Parameters
 - callback (function) function executed for every data point
 - this (object) context of the callback function.
 o {
 o x (number) x coordinate of the data point
 o y (number) y coordinate of the data point
 o value (number) value represented by the data point
 o }
 * Iterates over each unique data point plotted on every line on the chart.  
 = (object) @linechart object
 **
 \*/
        chart.each = function (f) {
            createDots(f);
            return this;
        };

 /*\
 * linechart.eachColumn
 [ method ]
 > Parameters
 - callback (function) function executed for every column
 - this (object) context of the callback function.
 o {
 o x (number) x coordinate of the data point
 o y (array) y coordinates of data points existing for the given x
 o values (array) values represented by the data points existing for the given x
 o }
 * Iterates over each column area (area plotted above the chart).
 = (object) @linechart object
 **
 \*/
        chart.eachColumn = function (f) {
            createColumns(f);
            return this;
        };

        return chart;
    };
    
    //inheritance
    var F = function() {};
    F.prototype = Raphael.g;
    Linechart.prototype = new F;
    
 /*
 * linechart method on paper
 */
/*\
 * Paper.linechart
 [ method ]
 **
 * Creates a line chart
 **
 > Parameters
 **
 - x (number) x coordinate of the chart
 - y (number) y coordinate of the chart
 - width (number) width of the chart (including the axis)
 - height (number) height of the chart (including the axis)
 - valuesx (array) values to plot on axis x
 - valuesy (array) values to plot on axis y
 - opts (object) options for the chart
 o {
 o gutter (number) distance between symbols on the chart
 o symbol (string) (array) symbol to be plotted as nodes of the chart, if array are passed symbols are printed iteratively. Currently `'circle'` and `''` (no symbol) are the only supported options.
 o width (number) controls the size of the plotted symbol. Also controls the thickness of the line using a formula stroke-width=width/2. This option is likely to change in the future versions of g.raphael.
 o colors (array) colors to plot data series. Raphael default colors are used if not passed
 o shade (boolean) whether or not to plot a shade of the chart [default: false]. Currently only a shade between the line and x axis is supported.
 o nostroke (boolean) whether or not to plot lines [default: false]. Only practical when shade is enabled. 
 o dash (string) changes display of the line from continues to dashed or dotted (Possible values are the same as stroke-dasharray attribute, see @Element.attr).
 o smooth (boolean) changes display of the line from point-to-point straight lines to curves (type C, see @Paper.path).
 o axis (string) Which axes should be renedered. String of four values evaluated in order `'top right bottom left'` e.g. `'0 0 1 1'`.
 o axisxstep (number) distance between values on axis X
 o axisystep (number) distance between values on axis Y
 o }
 **
 = (object) path element of the popup
 > Usage
 | r.linechart(0, 0, 99, 99, [1,2,3,4,5], [[1,2,3,4,5], [1,3,9,16,25], [100,50,25,12,6]], {smooth: true, colors: ['#F00', '#0F0', '#FF0'], symbol: 'circle'});
 \*/
    Raphael.fn.linechart = function(x, y, width, height, valuesx, valuesy, opts) {
        return new Linechart(this, x, y, width, height, valuesx, valuesy, opts);
    }
    
})();

/* g.pie */

/*!
 * g.Raphael 0.51 - Charting library, based on Raphaël
 *
 * Copyright (c) 2009-2012 Dmitry Baranovskiy (http://g.raphaeljs.com)
 * Licensed under the MIT (http://www.opensource.org/licenses/mit-license.php) license.
 */

 /*
 * piechart method on paper
 */
/*\
 * Paper.piechart
 [ method ]
 **
 * Creates a pie chart
 **
 > Parameters
 **
 - cx (number) x coordinate of the chart
 - cy (number) y coordinate of the chart
 - r (integer) radius of the chart
 - values (array) values used to plot
 - opts (object) options for the chart
 o {
 o minPercent (number) minimal percent threshold which will have a slice rendered. Sliced corresponding to data points below this threshold will be collapsed into 1 additional slice. [default `1`]
 o maxSlices (number) a threshold for how many slices should be rendered before collapsing all remaining slices into 1 additional slice (to focus on most important data points). [default `100`]
 o stroke (string) color of the circle stroke in HTML color format [default `"#FFF"`]
 o strokewidth (integer) width of the chart stroke [default `1`]
 o init (boolean) whether or not to show animation when the chart is ready [default `false`]
 o colors (array) colors be used to plot the chart
 o href (array) urls to to set up clicks on chart slices
 o legend (array) array containing strings that will be used in a legend. Other label options work if legend is defined.
 o legendcolor (string) color of text in legend [default `"#000"`]
 o legendothers (string) text that will be used in legend to describe options that are collapsed into 1 slice, because they are too small to render [default `"Others"`]
 o legendmark (string) symbol used as a bullet point in legend that has the same colour as the chart slice [default `"circle"`]
 o legendpos (string) position of the legend on the chart [default `"east"`]. Other options are `"north"`, `"south"`, `"west"`
 o }
 **
 = (object) path element of the popup
 > Usage
 | r.piechart(cx, cy, r, values, opts)
 \*/
 
(function () {

    function Piechart(paper, cx, cy, r, values, opts) {
        opts = opts || {};

        var chartinst = this,
            sectors = [],
            covers = paper.set(),
            chart = paper.set(),
            series = paper.set(),
            order = [],
            len = values.length,
            angle = 0,
            total = 0,
            others = 0,
            cut = opts.maxSlices || 100,
            minPercent = parseFloat(opts.minPercent) || 1,
            defcut = Boolean( minPercent );

        function sector(cx, cy, r, startAngle, endAngle, fill) {
            var rad = Math.PI / 180,
                x1 = cx + r * Math.cos(-startAngle * rad),
                x2 = cx + r * Math.cos(-endAngle * rad),
                xm = cx + r / 2 * Math.cos(-(startAngle + (endAngle - startAngle) / 2) * rad),
                y1 = cy + r * Math.sin(-startAngle * rad),
                y2 = cy + r * Math.sin(-endAngle * rad),
                ym = cy + r / 2 * Math.sin(-(startAngle + (endAngle - startAngle) / 2) * rad),
                res = [
                    "M", cx, cy,
                    "L", x1, y1,
                    "A", r, r, 0, +(Math.abs(endAngle - startAngle) > 180), 1, x2, y2,
                    "z"
                ];

            res.middle = { x: xm, y: ym };
            return res;
        }

        chart.covers = covers;

        if (len == 1) {
            series.push(paper.circle(cx, cy, r).attr({ fill: opts.colors && opts.colors[0] || chartinst.colors[0], stroke: opts.stroke || "#fff", "stroke-width": opts.strokewidth == null ? 1 : opts.strokewidth }));
            covers.push(paper.circle(cx, cy, r).attr(chartinst.shim));
            total = values[0];
            values[0] = { value: values[0], order: 0, valueOf: function () { return this.value; } };
            opts.href && opts.href[0] && covers[0].attr({ href: opts.href[0] });
            series[0].middle = {x: cx, y: cy};
            series[0].mangle = 180;
        } else {
            for (var i = 0; i < len; i++) {
                total += values[i];
                values[i] = { value: values[i], order: i, valueOf: function () { return this.value; } };
            }
            
            //values are sorted numerically
            values.sort(function (a, b) {
                return b.value - a.value;
            });
            
            for (i = 0; i < len; i++) {
                if (defcut && values[i] * 100 / total < minPercent) {
                    cut = i;
                    defcut = false;
                }

                if (i > cut) {
                    defcut = false;
                    values[cut].value += values[i];
                    values[cut].others = true;
                    others = values[cut].value;
                }
            }

            len = Math.min(cut + 1, values.length);
            others && values.splice(len) && (values[cut].others = true);

            for (i = 0; i < len; i++) {
                var mangle = angle - 360 * values[i] / total / 2;

                if (!i) {
                    angle = 90 - mangle;
                    mangle = angle - 360 * values[i] / total / 2;
                }

                if (opts.init) {
                    var ipath = sector(cx, cy, 1, angle, angle - 360 * values[i] / total).join(",");
                }

                var path = sector(cx, cy, r, angle, angle -= 360 * values[i] / total);
                var j = (opts.matchColors && opts.matchColors == true) ? values[i].order : i;
                var p = paper.path(opts.init ? ipath : path).attr({ fill: opts.colors && opts.colors[j] || chartinst.colors[j] || "#666", stroke: opts.stroke || "#fff", "stroke-width": (opts.strokewidth == null ? 1 : opts.strokewidth), "stroke-linejoin": "round" });

                p.value = values[i];
                p.middle = path.middle;
                p.mangle = mangle;
                sectors.push(p);
                series.push(p);
                opts.init && p.animate({ path: path.join(",") }, (+opts.init - 1) || 1000, ">");
            }

            for (i = 0; i < len; i++) {
                p = paper.path(sectors[i].attr("path")).attr(chartinst.shim);                
                //sgurin - fixed Cyril Hansen - reorder hrefs
                //opts.href && opts.href[i] && p.attr({ href: opts.href[i] });
                var j = values[i].order; 
                opts.href && opts.href[j] && p.attr({ href: opts.href[j] });                
                p.attr = function () {};
                covers.push(p);
                series.push(p);
            }
        }

        chart.hover = function (fin, fout) {
            fout = fout || function () {};

            var that = this;

            for (var i = 0; i < len; i++) {
                (function (sector, cover, j) {
                    var o = {
                        sector: sector,
                        cover: cover,
                        cx: cx,
                        cy: cy,
                        mx: sector.middle.x,
                        my: sector.middle.y,
                        mangle: sector.mangle,
                        r: r,
                        value: values[j],
                        total: total,
                        label: that.labels && that.labels[j]
                    };
                    cover.mouseover(function () {
                        fin.call(o);
                    }).mouseout(function () {
                        fout.call(o);
                    });
                })(series[i], covers[i], i);
            }
            return this;
        };

        // x: where label could be put
        // y: where label could be put
        // value: value to show
        // total: total number to count %
        chart.each = function (f) {
            var that = this;

            for (var i = 0; i < len; i++) {
                (function (sector, cover, j) {
                    var o = {
                        sector: sector,
                        cover: cover,
                        cx: cx,
                        cy: cy,
                        x: sector.middle.x,
                        y: sector.middle.y,
                        mangle: sector.mangle,
                        r: r,
                        value: values[j],
                        total: total,
                        label: that.labels && that.labels[j]
                    };
                    f.call(o);
                })(series[i], covers[i], i);
            }
            return this;
        };

        chart.click = function (f) {
            var that = this;

            for (var i = 0; i < len; i++) {
                (function (sector, cover, j) {
                    var o = {
                        sector: sector,
                        cover: cover,
                        cx: cx,
                        cy: cy,
                        mx: sector.middle.x,
                        my: sector.middle.y,
                        mangle: sector.mangle,
                        r: r,
                        value: values[j],
                        total: total,
                        label: that.labels && that.labels[j]
                    };
                    cover.click(function () { f.call(o); });
                })(series[i], covers[i], i);
            }
            return this;
        };

        chart.inject = function (element) {
            element.insertBefore(covers[0]);
        };

        var legend = function (labels, otherslabel, mark, dir) {
            var x = cx + r + r / 5,
                y = cy,
                h = y + 10;

            labels = labels || [];
            dir = (dir && dir.toLowerCase && dir.toLowerCase()) || "east";
            mark = paper[mark && mark.toLowerCase()] || "circle";
            chart.labels = paper.set();

            for (var i = 0; i < len; i++) {
                var clr = series[i].attr("fill"),
                    j = values[i].order,
                    txt;

                values[i].others && (labels[j] = otherslabel || "Others");
                labels[j] = chartinst.labelise(labels[j], values[i], total);
                chart.labels.push(paper.set());
                chart.labels[i].push(paper[mark](x + 5, h, 5).attr({ fill: clr, stroke: "none" }));
                chart.labels[i].push(txt = paper.text(x + 20, h, labels[j] || values[j]).attr(chartinst.txtattr).attr({ fill: opts.legendcolor || "#000", "text-anchor": "start"}));
                covers[i].label = chart.labels[i];
                h += txt.getBBox().height * 1.2;
            }

            var bb = chart.labels.getBBox(),
                tr = {
                    east: [0, -bb.height / 2],
                    west: [-bb.width - 2 * r - 20, -bb.height / 2],
                    north: [-r - bb.width / 2, -r - bb.height - 10],
                    south: [-r - bb.width / 2, r + 10]
                }[dir];

            chart.labels.translate.apply(chart.labels, tr);
            chart.push(chart.labels);
        };

        if (opts.legend) {
            legend(opts.legend, opts.legendothers, opts.legendmark, opts.legendpos);
        }

        chart.push(series, covers);
        chart.series = series;
        chart.covers = covers;

        return chart;
    };
    
    //inheritance
    var F = function() {};
    F.prototype = Raphael.g;
    Piechart.prototype = new F;
    
    //public
    Raphael.fn.piechart = function(cx, cy, r, values, opts) {
        return new Piechart(this, cx, cy, r, values, opts);
    }
    
})();
/* g.sunburst */

/*!
 * g.sunburst 0.1 - Sunburst diagrams
 * Needs g.Raphael 0.4.1 - Charting library, based on Raphaël
 *
 * Copyright (c)2011 zynamics GmbH (http://zynamics.com)
 * Licensed under the MIT (http://www.opensource.org/licenses/mit-license.php)
 * license.
 * 
 * 
 * See http://vis.stanford.edu/protovis/ex/sunburst.html for more
information. Rendering is done much the same way.

Use like this (include g.raphael.js and g.sunburst.js):

var r = Raphael("area");
var clusters = {
    "Cluster A": 50,
    "Cluster B": {
        "Sub-Cluster B-A": 25,
        "Sub-Cluster B-B": 75,
    }
    "Cluster C": {
        "Sub-Cluster C-A": 86,
        "Sub-Cluster C-B": 23,
        "Sub-Cluster C-C": {
            "Depth 3 - A": 50,
            "Depth 3 - B": 125
            WithoutQuotes: 14
        }
    }
};

sunburst = r.g.sunburst(350, 350, clusters, {
    rootLabel: "clusters",
    offsetAngle: 90,
    // With of each "ring"
    levelWidths: [25, 75, 50, 40, 30],
    // Colors array, by default used per slice
    colors: ["#E8420C", "#FF9600", "#FF0057", "#A90CE8", "#1D0DFF"],
    // You can also specify gradients instead of colors
    //gradients: ["45-#E8420C-#E832FF", "45-#FF9600-#FF96FF"),
    //    "45-#FF0057-#FF00FF", "45-#A90CE8-#A90CFF",
    //    "45-#1D0DFF-#1D0DFF"],
    // Draw each level in a different color
    //colorizeByLevel: true,
    // Gradient function, this needs the color array;
    // will likey be replaced by an eachSector() function
    onGradient: function(rootSect, depth) {
        return shadeColor(this.colors[rootSect % this.colors.length],
            0.1 * (depth + 2));
    },
    stroke: "#fff",
    strokewidth: 1
});

The diagram also supports the hover and the click event.

 *
 * Author: Christian Blichmann <christian.blichmann@zynamics.com>
 * acomodated by sgurin for raphael 2.1 and raphael4gwt.
 */
Raphael.fn.sunburst = function(cx, cy, values, opts) {
	opts = opts || {};
	var paper = this,
	    chart = this.set(),
	    series = this.set(),
	    levelRadii = [];

	function levelRadius(level) {
		if (levelRadii[level])
			return levelRadii[level];

		var levelWidth = opts.onLevelWidth || function(level) {
				return this.levelWidths ? this.levelWidths[level] :
					(this.levelWidth || 50);
			},
			res = 0;

		for (var i = 0; i <= level; i++)
			res += levelWidth.call(opts, i);

		levelRadii[level] = res;
		return res;
	}

	function sector(cx, cy, ri, ro, startAngle, endAngle, params) {
		var sliceAngle = endAngle - startAngle,
		    full = Math.abs(sliceAngle) >= 360;
		if (full)
			endAngle = startAngle + 359.99;

		var large = Math.abs(sliceAngle) > 180,
		    rad = Math.PI / 180,
		    xo1 = cx + ro * Math.cos(-startAngle * rad),
		    yo1 = cy + ro * Math.sin(-startAngle * rad),
		    xo2 = cx + ro * Math.cos(-endAngle * rad),
		    yo2 = cy + ro * Math.sin(-endAngle * rad),
		    xi1 = cx + ri * Math.cos(-startAngle * rad),
		    yi1 = cy + ri * Math.sin(-startAngle * rad),
		    xi2 = cx + ri * Math.cos(-endAngle * rad),
		    yi2 = cy + ri * Math.sin(-endAngle * rad),
		    halfAngle = Math.abs(endAngle + startAngle) / 2,
		    rm = (ro + ri) / 2,
		    xm = cx + rm * Math.cos(-halfAngle * rad),
		    ym = cy + rm * Math.sin(-halfAngle * rad),
		    res = paper.path([
				"M", xi1, yi1,
				"A", ri, ri, 0, +large, 0, xi2, yi2,
				full ? "M" : "L", xo2, yo2,
				"A", ro, ro, 0, +large, 1, xo1, yo1,
				"Z"
			]);
		res.middle = {x: xm, y: ym};
		res.mangle = halfAngle;
		res.ri = ri;
		res.ro = ro;
		return res.attr(params);
	}

	function getDataSeriesFromObj(rootLabel, values) {
		var res = {label: rootLabel, value: 0, children: []},
		    maxDepth = 0,
		    child;
		for (var i in values) {
			if (~~values[i]) {
				res.value += values[i];
				child = {label: i, value: values[i], depth: 0, children: []};
			} else {
				child = getDataSeriesFromObj(i, values[i]);
				res.value += child.value;
			}
			maxDepth = Math.max(maxDepth, child.depth);
			res.children[res.children.length] = child;
		}
		res.depth = maxDepth + 1;
		return res;
	}

	function colorAttr(idx, depth) {
		var idx = idx % (opts.colors.length || opts.gradients.length);

		if (opts.onGradient)
			return {gradient: opts.onGradient.call(opts, idx, depth)};

		return opts.gradients ? {gradient: opts.gradients[idx]} : {
			fill: opts.colors ? opts.colors[idx] : Raphael.getColor()};
	}

	function renderSeries(data, renderTo, level, total, prevAngle, parentIdx) {
		level = level || 0;
		total = total || data.value;
		prevAngle = prevAngle || (opts.offsetAngle || 0);
		parentIdx = parentIdx || 0;
		var startAngle,
		    endAngle = prevAngle,
		    children = data.children,
		    childIdx = 0;
		for (var i = 0; i < children.length; i++) {
			startAngle = endAngle;
			endAngle += children[i].value / total * 360;

			var thisIdx = level == 0 ? childIdx : parentIdx,
			    sect = sector(cx, cy, levelRadius(level), levelRadius(level + 1),
			    startAngle, endAngle,
			    colorAttr(!opts.colorizeByLevel ? thisIdx : level, level)).attr({
						stroke: opts.stroke || "#fff",
						"stroke-width": opts.strokewidth || 1});
			sect.level = level;
			sect.value = children[i].value;
			sect.label = children[i].label;
			renderTo.push(sect);
			renderSeries(children[i], renderTo, level + 1, total, startAngle,
				thisIdx);
			childIdx++;
		}
	}

	Raphael.getColor.reset();
	var data = getDataSeriesFromObj(opts.rootLabel, values);
	renderSeries(data, series);

	function getCallbackContext(sector) {
		return {
			sector: sector,
			cx: cx,
			cy: cy,
			mx: sector.middle.x,
			my: sector.middle.y,
			mangle: sector.mangle
		};
	}

	chart.hover = function(fin, fout) {
		fout = fout || function () {};
		for (var i = 0; i < series.length; i++)
			(function (sector) {
				var o = getCallbackContext(sector);
				sector.mouseover(function () { fin.call(o); });
				sector.mouseout(function () { fout.call(o); });
			})(series[i]);
		return this;
	};

	chart.click = function(f) {
		for (var i = 0; i < series.length; i++)
			(function (sector) {
				var o = getCallbackContext(sector);
				sector.click(function () { f.call(o); });
			})(series[i]);
		return this;
	};

	// TODO: Need access functions for individual rings, sectors and items
	chart.push(series);
	chart.series = series;
	return chart;
};

/* g.radar */

//from https://github.com/sentience/g.raphael/commit/81d142f542dd47c96f1159bb5e8978ad75ca42d2
/* Copyright (c) 2009 Dmitry Baranovskiy (http://g.raphaeljs.com)
 * Licensed under the MIT (http://www.opensource.org/licenses/mit-license.php) license.
 */
(function() {
    function Radarchart(paper, cx, cy, r, values, opts) {
        opts = opts || {};

        var chartinst = this,
            arms = [],                      // holds the values, their positions, paths, arms, circles
            chart = paper.set(),            // the chart that will be constructed and returned
            covers = paper.set(),           // holds the areas for event handling
            series = paper.set(),
            middle_point,                   // raphael circle for background mesh
            mesh = paper.set(),             // the background mesh
            total = 0,
            max = Math.max.apply(Math, values), // the maximum of the values
            len = values.length,            // number of values
            web = {pointarray: [], path: null}; // connecting lines between values
        
        // overwrite default values for options with opts
        var default_opts = {
            meshwidth:    1,
            strokewidth:  2,
            stroke:       "#f90",
            meshcolor:    "#999",
            helplines:    5,
            circleradius:   10,
            numbers:      true,
            numberscolor: "#fff"
        };
        for (var property in opts)
            default_opts[property] = opts[property];
        opts = default_opts;
        delete default_opts;
        
        // helper function for drawing an arm
        var arm = function (sx, sy, r, angle, m) {
            var rad = Math.PI / 180,
                cos = Math.cos(-angle * rad),
                sin = Math.sin(-angle * rad),
                x   = sx + r * cos,
                y   = sy + r * sin,
                ex  = sx + m * cos,
                ey  = sy + m * sin,
                res = {
                    x:          x,
                    y:          y,
                    //start:    {x: sx, y: sy},
                    //end:      {x: ex, y: ey},
                    path:       ["M", cx, cy, "L", x, y].join(','),
                    rest:       ["M", x, y, "L", ex, ey].join(',')
                };
            return res;
        }

        // calculate total of all values
        for (var i = len; i--;) {
            total +=+ values[i];
        }
        
        // draw middle point and mesh circles
        middle_point = paper.circle(cx, cy, 5).attr({stroke: opts.meshcolor, fill: opts.meshcolor, "stroke-width": opts.meshwidth});
        if (opts.helplines){
            var helpradius = r / opts.helplines;
            for (var i = 0; i < opts.helplines; i++) {
                mesh.push(paper.circle(cx, cy, helpradius*(i+1)).attr({stroke: opts.meshcolor, "stroke-width": opts.meshwidth}));
            }
        }
        
        // calculate the arms
        for (var i = 0; i < len; i++) {
            arms[i] = arm(cx, cy, r * values[i] / max, i * 360 / len, r);
        }
            
        // draw a polygon through the value points
        web.pointarray.push("M");
        for (var i = 0; i < len; i++) {
            web.pointarray.push(arms[i].x, arms[i].y, "L");
        }
        web.pointarray.push(arms[0].x, arms[0].y);
        web.path = paper.path(web.pointarray.join(',')).attr({stroke: opts.stroke, "stroke-width": opts.meshwidth, fill: opts.stroke, "fill-opacity": 0.4});
            
        // draw the value points (and arms) as latest to make sure they are the topmost
        for (var i = 0; i < len; i++) {
            arms[i].path =  paper.path(arms[i].path)
                                .attr({stroke: opts.stroke,     "stroke-width": opts.strokewidth});
            arms[i].rest =  paper.path(arms[i].rest)
                                .attr({stroke: opts.meshcolor, "stroke-width": opts.meshwidth});
            arms[i].point = paper.circle(arms[i].x, arms[i].y, opts.circleradius)
                                .attr({stroke: opts.stroke, fill: opts.stroke });
            if(opts.numbers){
                arms[i].number = paper.text(arms[i].x, arms[i].y+1, i+1).attr(chartinst.txtattr).attr({fill: opts.numberscolor, "text-anchor": "middle"});
            }
            var cover = paper.set();
            cover.push(arms[i].path, arms[i].rest, arms[i].point);
            if (arms[i].number)
              cover.push(arms[i].number);
            covers.push(cover);
            series.push(arms[i].point);
        }

        chart.hover = function (fin, fout) {
            fout = fout || function () {};
            var that = this;
            for (var i = len; i--;) {
                (function (arm, cover, j) {
                    var o = {
                        arm: arm.point,
                        number: arm.number,
                        cover: cover,
                        cx: cx,
                        cy: cy,
                        mx: arm.x,
                        my: arm.y,
                        value: values[j],
                        max: max,
                        label: that.labels && that.labels[j]
                    };
                    o.cover.mouseover(function () {
                        fin.call(o);
                    }).mouseout(function () {
                        fout.call(o);
                    });
                    if (o.label){
                        o.label.mouseover(function () {
                            fin.call(o);
                        }).mouseout(function () {
                            fout.call(o);
                        });
                    }
                })(arms[i], covers[i], i);
            }
            return this;
        };

        // x: where label could be put
        // y: where label could be put
        // value: value to show
        // total: total number to count %
        chart.each = function (f) {
            if (!Raphael.is(f, "function")) {
                return this;
            }
            var that = this;
            for (var i = len; i--;) {
                (function (arm, cover, j) {
                    var o = {
                        arm: arm.point,
                        number: arm.number,
                        cover: cover,
                        cx: cx,
                        cy: cy,
                        x: arm.x,
                        y: arm.y,
                        value: values[j],
                        max: max,
                        label: that.labels && that.labels[j]
                    };
                    f.call(o);
                })(arms[i], covers[i], i);
            }
            return this;
        };
     
        chart.click = function (f) {
            var that = this;
            for (var i = len; i--;) {
                (function (arm, cover, j) {
                    var o = {
                        arm: arm.point,
                        number: arm.number,
                        cover: cover,
                        cx: cx,
                        cy: cy,
                        mx: arm.x,
                        my: arm.y,
                        value: values[j],
                        max: max,
                        label: that.labels && that.labels[j]
                    };
                    cover.click(function () { f.call(o); });
                    if (o.label){
                        o.label.click(function () {
                            f.call(o);
                        });
                    }
                })(arms[i], covers[i], i);
            }
            return this;
        };

        var legend = function (labels, otherslabel, mark, dir) {
            var x = cx + r + r / 5,
                y = cy,
                h = y + 10;
            
            labels = labels || [];
            dir = (dir && dir.toLowerCase && dir.toLowerCase()) || "east";
            mark = paper[mark && mark.toLowerCase()] || "circle";
            chart.labels = paper.set();

            for (var i = 0; i < len; i++) {
                var clr = series[i].attr("fill"),
                    txt;
                
                values[i].others && (labels[j] = otherslabel || "Others");
                labels[i] = chartinst.labelise(labels[i], values[i], total);
                chart.labels.push(paper.set());
                chart.labels[i].push(paper[mark](x + 5, h, 8).attr({fill: clr, stroke: "none"}));
                chart.labels[i].push(txt = paper.text(x + 20, h, labels[i] || values[i]).attr(chartinst.txtattr).attr({fill: opts.legendcolor || "#000", "text-anchor": "start"}));
                if(opts.numbers){
                    chart.labels[i].push(paper.text(x + 5, h + 1, i + 1).attr(chartinst.txtattr).attr({fill: opts.numberscolor, "text-anchor": "middle"}));
                }
                covers[i].label = chart.labels[i];
                h += txt.getBBox().height * 1.2;
            }

            var bb = chart.labels.getBBox(),
                tr = {
                    east: [0, -bb.height / 2],
                    west: [-bb.width - 2 * r - 20, -bb.height / 2],
                    north: [-r - bb.width / 2, -r - bb.height - 10],
                    south: [-r - bb.width / 2, r + 10]
                }[dir];
            
            chart.labels.translate.apply(chart.labels, tr);
            chart.push(chart.labels);
        };

        if (opts.legend) {
            legend(opts.legend, opts.legendothers, opts.legendmark, opts.legendpos);
        }

        chart.push(series, covers, middle_point, mesh);
        chart.series = series;
        chart.covers = covers;

        return chart;
    };

    //inheritance
    var F = function() {};
    F.prototype = Raphael.g;
    Radarchart.prototype = new F;
    
    //public
    Raphael.fn.radarchart = function(cx, cy, r, values, opts) {
        return new Radarchart(this, cx, cy, r, values, opts);
    };

})();

/* raphalytics */

/*
 * this file contains both popup.js and raphalytics.js from https://github.com/tataencu/raphalytics
 * with the following modifications for integrating with graphael
 * 
 * 1) raphalytics includes a Raphael.fn.popup function that will override original graphael popup()
 * so we change its name to raphalytics_popup() everywhere. 
 */




(function () {
var tokenRegex = /\{([^\}]+)\}/g,
    objNotationRegex = /(?:(?:^|\.)(.+?)(?=\[|\.|$|\()|\[('|")(.+?)\2\])(\(\))?/g, // matches .xxxxx or ["xxxxx"] to run over object properties
    replacer = function (all, key, obj) {
        var res = obj;
        key.replace(objNotationRegex, function (all, name, quote, quotedName, isFunc) {
            name = name || quotedName;
            if (res) {
                if (name in res) {
                    res = res[name];
                }
                typeof res == "function" && isFunc && (res = res());
            }
        });
        res = (res == null || res == obj ? all : res) + "";
        return res;
    },
    fill = function (str, obj) {
        return String(str).replace(tokenRegex, function (all, key) {
            return replacer(all, key, obj);
        });
    };
    Raphael.fn.raphalytics_popup = function (X, Y, set, pos, ret) {
        pos = String(pos || "top-middle").split("-");
        pos[1] = pos[1] || "middle";
        var r = 5,
            bb = set.getBBox(),
            w = Math.round(bb.width),
            h = Math.round(bb.height),
            x = Math.round(bb.x) - r,
            y = Math.round(bb.y) - r,
            gap = Math.min(h / 2, w / 2, 10),
            shapes = {
                top: "M{x},{y}h{w4},{w4},{w4},{w4}a{r},{r},0,0,1,{r},{r}v{h4},{h4},{h4},{h4}a{r},{r},0,0,1,-{r},{r}l-{right},0-{gap},{gap}-{gap}-{gap}-{left},0a{r},{r},0,0,1-{r}-{r}v-{h4}-{h4}-{h4}-{h4}a{r},{r},0,0,1,{r}-{r}z",
                bottom: "M{x},{y}l{left},0,{gap}-{gap},{gap},{gap},{right},0a{r},{r},0,0,1,{r},{r}v{h4},{h4},{h4},{h4}a{r},{r},0,0,1,-{r},{r}h-{w4}-{w4}-{w4}-{w4}a{r},{r},0,0,1-{r}-{r}v-{h4}-{h4}-{h4}-{h4}a{r},{r},0,0,1,{r}-{r}z",
                right: "M{x},{y}h{w4},{w4},{w4},{w4}a{r},{r},0,0,1,{r},{r}v{h4},{h4},{h4},{h4}a{r},{r},0,0,1,-{r},{r}h-{w4}-{w4}-{w4}-{w4}a{r},{r},0,0,1-{r}-{r}l0-{bottom}-{gap}-{gap},{gap}-{gap},0-{top}a{r},{r},0,0,1,{r}-{r}z",
                left: "M{x},{y}h{w4},{w4},{w4},{w4}a{r},{r},0,0,1,{r},{r}l0,{top},{gap},{gap}-{gap},{gap},0,{bottom}a{r},{r},0,0,1,-{r},{r}h-{w4}-{w4}-{w4}-{w4}a{r},{r},0,0,1-{r}-{r}v-{h4}-{h4}-{h4}-{h4}a{r},{r},0,0,1,{r}-{r}z"
            },
            offset = {
                hx0: X - (x + r + w - gap * 2),
                hx1: X - (x + r + w / 2 - gap),
                hx2: X - (x + r + gap),
                vhy: Y - (y + r + h + r + gap),
                "^hy": Y - (y - gap)
                
            },
            mask = [{
                x: x + r,
                y: y,
                w: w,
                w4: w / 4,
                h4: h / 4,
                right: 0,
                left: w - gap * 2,
                bottom: 0,
                top: h - gap * 2,
                r: r,
                h: h,
                gap: gap
            }, {
                x: x + r,
                y: y,
                w: w,
                w4: w / 4,
                h4: h / 4,
                left: w / 2 - gap,
                right: w / 2 - gap,
                top: h / 2 - gap,
                bottom: h / 2 - gap,
                r: r,
                h: h,
                gap: gap
            }, {
                x: x + r,
                y: y,
                w: w,
                w4: w / 4,
                h4: h / 4,
                left: 0,
                right: w - gap * 2,
                top: 0,
                bottom: h - gap * 2,
                r: r,
                h: h,
                gap: gap
            }][pos[1] == "middle" ? 1 : (pos[1] == "top" || pos[1] == "left") * 2];
            var dx = 0,
                dy = 0,
                out = this.path(fill(shapes[pos[0]], mask)).insertBefore(set);
            switch (pos[0]) {
                case "top":
                    dx = X - (x + r + mask.left + gap);
                    dy = Y - (y + r + h + r + gap);
                break;
                case "bottom":
                    dx = X - (x + r + mask.left + gap);
                    dy = Y - (y - gap);
                break;
                case "left":
                    dx = X - (x + r + w + r + gap);
                    dy = Y - (y + r + mask.top + gap);
                break;
                case "right":
                    dx = X - (x - gap);
                    dy = Y - (y + r + mask.top + gap);
                break;
            }
            out.translate(dx, dy);
            if (ret) {
                ret = out.attr("path");
                out.remove();
                return {
                    path: ret,
                    dx: dx,
                    dy: dy
                };
            }
            set.translate(dx, dy);
            return out;
    };
})();







Raphael.fn.drawGridBorder = function(x, y, w, h, type, color) {
	if (type == 'full') {
		var path = [ "M", Math.round(x), Math.round(y), "L", Math.round(x + w),
				Math.round(y), Math.round(x + w), Math.round(y + h),
				Math.round(x), Math.round(y + h), Math.round(x), Math.round(y) ];
	}

	if (type == 'xoy') {
		var path = [ "M", Math.round(x), Math.round(y + h), "L",
				Math.round(x + w), Math.round(y + h), "M", Math.round(x),
				Math.round(y + h), "L", Math.round(x), Math.round(y) ];
	}

	if (type == 'minimalist') {
		var path = [ "M", Math.round(x), Math.round(y + h), "L",
				Math.round(x + w), Math.round(y + h) ];
	}

	return this.path(path.join(",")).attr({
		stroke : color,
		'stroke-width' : 0.5
	});
}

Raphael.fn.drawGrid = function(x, y, w, h, wv, hv, type, color) {
	var path = [], rowHeight = h / hv, columnWidth = w / wv;

	if (type == 'y_grid' || type == 'full_grid' || type == 'minimalist') {
		var start_from = (type == 'minimalist' ? 0 : 1);

		for ( var i = start_from; i < hv; i++) {
			path = path.concat([ "M", Math.round(x),
					Math.round(y + i * rowHeight), "H", Math.round(x + w) ]);
		}
	}

	if (type == 'x_grid' || type == 'full_grid') {
		for (i = 1; i < wv; i++) {
			path = path.concat([ "M", Math.round(x + i * columnWidth),
					Math.round(y), "V", Math.round(y + h) ]);
		}
	}

	return this.path(path.join(",")).attr({
		stroke : color,
		'stroke-width' : 0.5
	});
};

function raphalytics(paper, data, labels, tooltips, options) {
	function getAnchors(p1x, p1y, p2x, p2y, p3x, p3y) {
		var l1 = (p2x - p1x) / 2, l2 = (p3x - p2x) / 2, a = Math
				.atan((p2x - p1x) / Math.abs(p2y - p1y)), b = Math
				.atan((p3x - p2x) / Math.abs(p2y - p3y));

		a = p1y < p2y ? Math.PI - a : a;
		b = p3y < p2y ? Math.PI - b : b;

		var alpha = Math.PI / 2 - ((a + b) % (Math.PI * 2)) / 2, dx1 = l1
				* Math.sin(alpha + a), dy1 = l1 * Math.cos(alpha + a), dx2 = l2
				* Math.sin(alpha + b), dy2 = l2 * Math.cos(alpha + b);

		return {
			x1 : p2x - dx1,
			y1 : p2y + dy1,
			x2 : p2x + dx2,
			y2 : p2y + dy2
		};
	}

	// Grab the data
	if (typeof data[0] !== 'object') {
		data = [ data ];
	}

	if (typeof tooltips[0] !== 'object') {
		tooltips = [ tooltips ];
	}

	var max_value = Math.max.apply(Math, data[0]);

	for (i = 0, ii = data.length; i < ii; i++) {
		if (Math.max.apply(Math, data[i]) > max_value) {
			max_value = Math.max.apply(Math, data[i]);
		}
	}

	// Graph options and styling
	var width = options.width || 750, height = options.height || 150, leftgutter = options.leftgutter || 10, bottomgutter = options.bottomgutter || 16, topgutter = options.topgutter || 14, rightgutter = options.rightgutter || 10, normalize = options.normalize || true, smooth = options.smooth || false, fill = options.fill || false, gridtype = options.gridtype
			|| 'minimalist', gridcolor = options.gridcolor || '#ccc', gridbordertype = options.gridbordertype
			|| (gridtype == 'minimalist' ? 'minimalist' : 'full'), gridbordercolor = options.gridbordercolor
			|| (gridtype == 'minimalist' ? '#000' : '#ccc'), color = options.color
			|| '#2F69BF', tooltipcolor = options.tooltipcolor || '#000', tooltipbordercolor = options.tooltipbordercolor
			|| '#666', tooltiptextcolor = options.tooltiptextcolor || '#fff', labelcolor = options.labelcolor
			|| '#000', y_labels_number = options.y_labels_number || 2, y_label_0 = options.y_label_0 || false, y_labels_position = options.y_labels_position
			|| 'inside', txt = {
		font : '12px Helvetica, Arial',
		fill : "#fff"
	};

	if (max_value < y_labels_number) {
		max_value = y_labels_number;
	}

	if (normalize) {
		max_value = Math.ceil(4 * max_value / 3);

		if (max_value > 10) {
			var pow = Math.pow(10, max_value.toString().length - 1);
			max_value = Math.ceil(max_value / pow) * pow;
		}
	}

	if (y_labels_position == 'outside'
			&& leftgutter < max_value.toString().length * 8) {
		leftgutter = max_value.toString().length * 8;
	}

	var X = (width - leftgutter - rightgutter) / (labels.length - 1), Y = (height
			- bottomgutter - topgutter)
			/ max_value;

	paper.drawGridBorder(leftgutter, topgutter, width - leftgutter
			- rightgutter, height - topgutter - bottomgutter, gridbordertype,
			gridbordercolor);
	paper.drawGrid(leftgutter, topgutter, width - leftgutter - rightgutter,
			height - topgutter - bottomgutter, labels.length - 1,
			y_labels_number, gridtype, gridcolor);

	if (typeof color != 'object') {
		color = [ color ];
	}

	var path, bgp, label = paper.set(), lx = 0, ly = 0, is_label_visible = false, blanket = paper
			.set(), p, bgpp, leave_timer, cur_color;

	label.push(paper.text(60, 12, tooltips[0][0]).attr(txt).attr({
		fill : tooltiptextcolor
	}));
	label.hide();
	paper.frame = paper.raphalytics_popup(100, 100, label, "right").attr({
		fill : tooltipcolor,
		stroke : tooltipbordercolor,
		"stroke-width" : 2,
		"fill-opacity" : .7
	}).hide();

	// Draw lines
	for ( var j = 0, jj = data.length; j < jj; j++) {
		if (typeof color[j] == 'undefined') {
			cur_color = color[color.length - 1];
		} else {
			cur_color = color[j];
		}

		path = paper.path().attr({
			stroke : cur_color,
			"stroke-width" : 4,
			"stroke-linejoin" : "round"
		});

		if (fill) {
			bgp = paper.path().attr({
				stroke : "none",
				opacity : .3,
				fill : cur_color
			});
		}

		p = null;
		bgpp = null;

		for ( var i = 0, ii = labels.length; i < ii; i++) {
			var y = Math.round(height - bottomgutter - Y * data[j][i]), x = Math
					.round(leftgutter + X * i);

			if (!i) {
				if (smooth) {
					p = [ "M", x, y, "C", x, y ];
				} else {
					p = [ "M", x, y, "L", x, y ];
				}

				if (fill) {
					if (smooth) {
						bgpp = [ "M", leftgutter, height - bottomgutter, "L",
								x, y, "C", x, y ];
					} else {
						bgpp = [ "M", leftgutter, height - bottomgutter, "L",
								x, y, "L", x, y ];
					}
				}
			}

			if (i && i < ii - 1) {
				var Y0 = Math.round(height - bottomgutter - Y * data[j][i - 1]), X0 = Math
						.round(leftgutter + X * i), Y2 = Math.round(height
						- bottomgutter - Y * data[j][i + 1]), X2 = Math
						.round(leftgutter + X * (i + 1));

				var a = getAnchors(X0, Y0, x, y, X2, Y2);

				if (smooth) {
					p = p.concat([ a.x1, a.y1, x, y, a.x2, a.y2 ]);
				} else {
					p = p.concat([ x, y ]);
				}

				if (fill) {
					if (smooth) {
						bgpp = bgpp.concat([ a.x1, a.y1, x, y, a.x2, a.y2 ]);
					} else {
						bgpp = bgpp.concat([ x, y ]);
					}
				}
			}

			var dot = paper.circle(x, y, 4).attr({
				fill : cur_color,
				stroke : cur_color,
				"stroke-width" : 2
			});

			if (typeof tooltips[j] == 'object'
					&& typeof tooltips[j][i] != 'undefined'
					&& tooltips[j][i] != false) {
				blanket.push(paper.rect(x - 10, y - 10, 20, 20).attr({
					stroke : "none",
					fill : "#fff",
					opacity : 0
				}));

				var rect = blanket[blanket.length - 1];

				(function(line, x, y, data, tooltip, dot) {
					var timer, i = 0;

					rect
							.hover(
									function() {
										clearTimeout(leave_timer);

										var side = "right";

										if (x + paper.frame.getBBox().width > width) {
											side = "left";
										}

										var ppp = paper.raphalytics_popup(x, y, label,
												side, 1), anim = Raphael
												.animation({
													path : ppp.path,
													transform : [ "t", ppp.dx,
															ppp.dy ]
												}, 200 * is_label_visible);

										lx = label[0].transform()[0][1]
												+ ppp.dx;
										ly = label[0].transform()[0][2]
												+ ppp.dy;

										paper.frame.show().stop().animate(anim);

										label[0].attr({
											text : tooltip
										}).show().stop().animateWith(
												paper.frame, anim, {
													transform : [ "t", lx, ly ]
												}, 200 * is_label_visible);

										dot.attr("r", 6);
										is_label_visible = true;
									}, function() {
										dot.attr("r", 4);

										leave_timer = setTimeout(function() {
											paper.frame.hide();
											label[0].hide();
											is_label_visible = false;
										}, 1000);
									});
				})(j, x, y, data[j][i], tooltips[j][i], dot);
			}
		}

		if (smooth) {
			p = p.concat([ x, y, x, y ]);
		} else {
			p = p.concat([ x, y ]);
		}

		path.attr({
			path : p
		});

		if (fill) {
			if (smooth) {
				bgpp = bgpp.concat([ x, y, x, y, "L", x, height - bottomgutter,
						"z" ]);
			} else {
				bgpp = bgpp.concat([ x, y, x, height - bottomgutter, "z" ]);
			}

			bgp.attr({
				path : bgpp
			});
		}
	}

	// Y labels
	var start_from = (y_label_0 ? 0 : 1);
	var value = 0;
	var y_label_anchor = (y_labels_position == 'outside' ? 'end' : 'start');
	for (i = start_from; i <= y_labels_number; i++) {
		value = Math.round(i * max_value / y_labels_number);
		value = value.toString();
		var label_x = (y_labels_position == 'outside' ? leftgutter - 1
				: leftgutter + 1);
		var label_y = (y_labels_position == 'outside' ? height
				- bottomgutter
				- i
				* Math.round((height - topgutter - bottomgutter)
						/ y_labels_number) : (i == 0 ? height
				- bottomgutter
				- i
				* Math.round((height - topgutter - bottomgutter)
						/ y_labels_number) - 8 : height
				- bottomgutter
				- i
				* Math.round((height - topgutter - bottomgutter)
						/ y_labels_number) + 8));
		paper.text(label_x, label_y, value).attr(txt).attr({
			fill : 'white',
			'stroke' : '#fff',
			'stroke-width' : 2,
			'text-anchor' : y_label_anchor
		}).toFront();
		paper.text(label_x, label_y, value).attr(txt).attr({
			fill : labelcolor,
			'text-anchor' : y_label_anchor
		}).toFront();
	}

	// X labels
	for ( var i = 0, ii = labels.length; i < ii; i++) {
		if (labels[i]) {
			var x = Math.round(leftgutter + X * i), x_label_anchor = (i == 0 ? 'start'
					: (i == ii - 1 ? 'end' : 'middle'));
			t = paper.text(x, height - 6, labels[i]).attr(txt).attr({
				fill : labelcolor,
				'text-anchor' : x_label_anchor
			}).toBack();
		}
	}

	paper.frame.toFront();
	label[0].toFront();
	blanket.toFront();

};

Raphael.fn.raphalytics = function(data, labels, tooltips, options) {
	return new raphalytics(this, data, labels, tooltips, options);
}

/* orgchart */

/*
 * lib_gg_orgchart 0.4 - JavaScript Organizational Chart Drawing Library
 *
 * Copyright (c) 2012 Gorka G Llona - http://www.fluxus.com.ve/gorka.
 * Licensed under the GNU Lesser General Public License.
 * Project home: http://www.fluxus.com.ve/gorka/lib_gg_orgchart.
 * 
 * Revision history:
 * v.0.4.0        (2012.05.14, GG): made publicly available
 * v.0.4.1 beta 1 (2012.07.11, GG): added support for images within boxes
 * v.0.4.1 beta 2 (2012.08.20, YL): fixed rendering issues with IE8
 *
 * Contributors:
 * GG :: Gorka G LLONA
 * YL :: Yoann LECUYER
 */


// PARAMETERS YOU SHOULD DEFINE IN YOUR HTML FILE
// see companion html file for samples and documentation

/*
var oc_data;                                  // json organizational chart hierarchy
var oc_style;                                 // json organizational chart styles
function oc_box_click_handler (event, box);   // handler for box clicking event
*/

// END OF PARAMETERS

// PUBLIC FUNCTIONS


// call this function in order to draw the chart
// note: oc_data and oc_style will be changed in this operation
//
function oc_render () {
	oc_calc();
	oc_draw();
}

if (navigator.appName == 'Microsoft Internet Explorer')
	var oc_IE = 1;
else
	var oc_IE = 0;


// END OF PUBLIC FUNCTIONS

// PRIVATE FUNCTIONS AND VARIABLES


// global variables
var oc_max_text_width = 0;
var oc_max_text_height = 0;
var oc_max_title_lines = 0;
var oc_max_subtitle_lines = 0;
var oc_paper = null;


// clone an object or array
// 
function oc_clone (obj) {
	var newObj = (obj instanceof Array) ? [] : {};
	for (i in obj) {
		if (obj[i] && typeof obj[i] == "object")
			newObj[i] = oc_clone(obj[i]);
		else
			newObj[i] = obj[i];
	}
	return newObj;
}


// add an offset to a (x, y) point
//
function oc_add2point (base, delta) {
	base[0] += delta[0];
	base[1] += delta[1];
}


// return a string made by repeating 'str' 'times' times
//
function oc_repeat_str (str, times) {
	var result = '';
	for (var i = 0; i < times -1; i++)
		result += str;
	return result;
}


// calc all orgchart metrics needed for drawing
//
function oc_calc () {
	oc_text_limit(oc_data.root);
	oc_delete_special_chars(oc_data.root);
	oc_text_dimensions(oc_data.root);
	oc_data.root.is_root = true;
	oc_boundboxes_dimensions(oc_data.root);
}


// insert newlines in titles and subtitles in order to meet max_text_width limit of each line
//
function oc_text_limit (node) {

	if (oc_style.max_text_width == 0)
		return;
	node.title = oc_text_limit_obj(node.title);
	node.subtitle = oc_text_limit_obj(node.subtitle);
	if (node.children === undefined)
		return;
	for (var i = 0; i < node.children.length - (oc_IE); i++)
		oc_text_limit(node.children[i]);
}


// insert newlines in a string in order to meet max_text_width limit
//
function oc_text_limit_obj (str) {
	if (str == undefined)
		return undefined;
	var parts = str.split(/[ \n]+/);
	var lines = [];
	var line_str = '';
	var last_line_str = '';
	for (var i = 0; i < parts.length - (0); i++) {
		var last_line_str = line_str;
		line_str += (i == 0 ? '' : ' ') + parts[i];
		if (line_str.length > oc_style.max_text_width) {
			lines.push(last_line_str);
			line_str = parts[i];
		}
	}
	if (line_str != '')
		lines.push(line_str);
	var result = lines.join('\n');
	return result;
}


// substitute special chars in node title and subtitle (they don't render well in SVG)
//
function oc_delete_special_chars (node) {

	node.title = oc_delete_special_chars_obj(node.title);
	node.subtitle = oc_delete_special_chars_obj(node.subtitle);
	if (node.children === undefined)
		return;
	for (var i = 0; i < node.children.length - (oc_IE); i++)
		oc_delete_special_chars(node.children[i]);
}


// substitute special chars in a string
//
function oc_delete_special_chars_obj (str) {
	if (str === undefined)
		return undefined;
	str = str.replace(/á/g, 'a');
	str = str.replace(/é/g, 'e');
	str = str.replace(/í/g, 'i');
	str = str.replace(/ó/g, 'o');
	str = str.replace(/ú/g, 'u');
	str = str.replace(/Á/g, 'A');
	str = str.replace(/É/g, 'E');
	str = str.replace(/Í/g, 'I');
	str = str.replace(/Ó/g, 'O');
	str = str.replace(/Ú/g, 'U');
	str = str.replace(/ñ/g, 'n');
	str = str.replace(/Ñ/g, 'N');
	return str;
}


// calc text dimensions in order to calc size of boxes
// result will be stored in global variables
//
function oc_text_dimensions (node) {

	var dimensions_title    = [ 0, 0 ];
	var dimensions_subtitle = [ 0, 0 ];
	node.title_lines = node.subtitle_lines = 0;

	// check title dimensions
	dimensions_title = oc_text_dimensions_obj (node.title, oc_style.title_char_size);
	node.title_lines = dimensions_title[2];
	if (node.title_lines > oc_max_title_lines)
		oc_max_title_lines = node.title_lines;

	// check subtitle dimensions
	if (node.subtitle !== undefined) {
		dimensions_subtitle = oc_text_dimensions_obj (node.subtitle, oc_style.subtitle_char_size);
		node.subtitle_lines = dimensions_subtitle[2];
		if (node.subtitle_lines > oc_max_subtitle_lines)
			oc_max_subtitle_lines = node.subtitle_lines;
	}

	// check node dimensions vs stored dimensions
	if (dimensions_title[0] > oc_max_text_width)
		oc_max_text_width = dimensions_title[0];
	if (oc_style.use_images && oc_style.images_size[0] > oc_max_text_width)   // GG 110712 include space for optional image width
		oc_max_text_width = oc_style.images_size[0];
	if (dimensions_subtitle[0] > oc_max_text_width)
		oc_max_text_width = dimensions_subtitle[0];
	if (dimensions_title[1] + dimensions_subtitle[1] > oc_max_text_height)
		oc_max_text_height = dimensions_title[1] + dimensions_subtitle[1];

	// traverse children
	if (node.children === undefined)
		return;
	for (var i = 0; i < node.children.length - (oc_IE); i++)
		oc_text_dimensions(node.children[i]);
}


// calc the size (in pixels) of a multi-line string
// third element of the returned array is the number of lines of the text
//
function oc_text_dimensions_obj (text, font_pixels) {
	var width = 0;
	var parts = text.split('\n');
	if (parts.length == 0)
		return [0, 0];
	for (var i = 0; i < parts.length - (0) ; i++) {
		if (parts[i].length > width)
			width = parts[i].length;
	}
	return [ width * font_pixels[0], (parts.length - (0)) * font_pixels[1], parts.length - (0)];
}


// calc all metrics (of a node and subnodes) needed for drawing the chart
//
function oc_boundboxes_dimensions (node) {
	// complete attributes
	if (node.type === undefined)
		node.type = 'subordinate';
	//if (node.is_root !== undefined)
		node.deltacorner = [ 0, 0 ];

	// traverse down recursively; add position attribute to collateral and staff children
	var oc_staff_position = 0;
	var oc_collateral_position = 0;
	if (node.children !== undefined) {
		for (var i = 0; i < node.children.length - (oc_IE) ; i++) {
			var child = node.children[i];
			if (child.type == 'staff')
				child.position = (oc_staff_position++ % 2 == 0 ? 'left' : 'right');
			else if (child.type == 'collateral')
				child.position = (oc_collateral_position++ % 2 == 0 ? 'left' : 'right');
			oc_boundboxes_dimensions(child);
		}
	}

	// now each children have: boundbox, deltacenter, fullbbox, deltacorner and xoffset
	// now calc this node boundbox and deltacenter
	node.boundbox = [
		oc_max_text_width  + 2 * oc_style.inner_padding,
		oc_max_text_height + 2 * oc_style.inner_padding
	];

	// GG 110712 add vertical space for images within boxes
	if (oc_style.use_images && node.image !== undefined)
		node.boundbox[1] += oc_style.inner_padding * 1 + oc_style.images_size[1];

	var y = node.boundbox[1];
	if (node.is_root !== undefined) {
		oc_add2point(node.boundbox, [
			2 * oc_style.hline,   // 0
			2 * oc_style.vline    // 0
		]);
		node.deltacenter = [ node.boundbox[0] / 2, y / 2 + 2 * oc_style.vline ];
	}
	else if (node.type == 'collateral') {
		oc_add2point(node.boundbox, [
			2 * oc_style.hline,
			2 * oc_style.vline   // 0
		]);
		node.deltacenter = [ node.boundbox[0] / 2, y / 2 + 2 * oc_style.vline ];
	}
	else if (node.type == 'staff') {
		oc_add2point(node.boundbox, [
			2 * oc_style.hline,
			1 * oc_style.vline
		]);
		node.deltacenter = [ node.boundbox[0] / 2, y / 2 + 1 * oc_style.vline ];
	}
	else {   // subordinate
		oc_add2point(node.boundbox, [
			2 * oc_style.hline,
			2 * oc_style.vline
		]);
		node.deltacenter = [ node.boundbox[0] / 2, y / 2 + 2 * oc_style.vline ];
	}

	// now prepare calc of this node fullbbox and deltacorner of children
	node.fullbbox = oc_clone(node.boundbox);
	if (node.children === undefined)
		node.xoffset = 0;
	// 1. collateral children
	var collateral_left_width  = node.boundbox[0] / 2;
	var collateral_right_width = node.boundbox[0] / 2;
	var collateral_children = 0;
	if (node.children !== undefined) {
		for (var i = 0; i < node.children.length - (oc_IE) ; i++) {
			var child = node.children[i];
			if (child.type != 'collateral')
				continue;
			collateral_children++;
			if (child.position == 'left')
				collateral_left_width = child.fullbbox[0] + node.boundbox[0] / 2;
			else   // right
				collateral_right_width = child.fullbbox[0] + node.boundbox[0] / 2;
		}
	}            
	// 2. staff children
	var staff_height = 0;
	var last_left_height = 0;
	var last_right_height = 0;
	var staff_left_width = 0;
	var staff_right_width = 0;
	var staff_children = 0;
	if (node.children !== undefined) {
		for (var i = 0; i < node.children.length - (oc_IE); i++) {
			var child = node.children[i];
			if (child.type != 'staff')
				continue;
			staff_children++;
			if (child.position == 'left') {
				staff_height += child.fullbbox[1];
				last_left_height = child.fullbbox[1];
				if (staff_left_width < child.fullbbox[0])
					staff_left_width = child.fullbbox[0];
			}
			else {   // right
				last_left_height = child.fullbbox[1];
				if (child.fullbbox[1] > last_left_height)
					staff_height += child.fullbbox[1] - last_left_height;
				if (staff_right_width < child.fullbbox[0])
					staff_right_width = child.fullbbox[0];
			}
		}
	}        
	// 3. subordinate children
	var subordinate_full_width = 0;
	if (node.children !== undefined) {
		for (var i = 0; i < node.children.length - (oc_IE); i++) {
			var child = node.children[i];
			if (child.type != 'subordinate')
				continue;
			subordinate_full_width += child.fullbbox[0];
		}
	}

	// calc total width and xoffset of this node
	var left_width = 0;
	if (collateral_left_width      > left_width) left_width = collateral_left_width;
	if (staff_left_width           > left_width) left_width = staff_left_width;
	if (subordinate_full_width / 2 > left_width) left_width = subordinate_full_width / 2;
	var right_width = 0;
	if (collateral_right_width     > right_width) right_width = collateral_right_width;
	if (staff_right_width          > right_width) right_width = staff_right_width;
	if (subordinate_full_width / 2 > right_width) right_width = subordinate_full_width / 2;
	node.xoffset = left_width - node.boundbox[0] / 2;

	// now calc this node fullbbox, and deltacorner of children
	// 1. collateral children
	if (node.children !== undefined) {
		for (var i = 0; i < node.children.length - (oc_IE) ; i++) {
			var child = node.children[i];
			if (child.type != 'collateral')
				continue;
			if (child.position == 'left') {
				child.deltacorner = [
					left_width - node.boundbox[0] / 2 - child.fullbbox[0],
					0
				];
			}
			else {   // right
				child.deltacorner = [
					left_width + node.boundbox[0] / 2,
					0
				];
			}
			oc_update_fullbbox(node, child);
		}
	}            
	// 2. staff children
	staff_height = 0;
	last_left_height = 0;
	last_right_height = 0;
	if (node.children !== undefined) {
		for (var i = 0; i < node.children.length - (oc_IE); i++) {
			var child = node.children[i];
			if (child.type != 'staff')
				continue;
			if (child.position == 'left') {
				child.deltacorner = [
					left_width - child.fullbbox[0],
					node.boundbox[1] + staff_height
				];
				staff_height    += child.fullbbox[1];
				last_left_height = child.fullbbox[1];
				if (staff_children == 1)   // patch for case of only one children drawn at botton left of the node
					node.fullbbox[0] += node.boundbox[0] ;
			}
			else {   // right
				child.deltacorner = [
					left_width,
					node.boundbox[1] + last_right_height
				];
				last_left_height = child.fullbbox[1];
				if (child.fullbbox[1] > last_left_height)
					staff_height += child.fullbbox[1] - last_left_height;
			}
			oc_update_fullbbox(node, child);
		}
	}            
	// 3. subordinate children
	var incremental_width = 0;
	var diff_width = left_width - subordinate_full_width / 2;
	if (diff_width < 0) diff_width = 0;
	if (node.children !== undefined) {
		for (var i = 0; i < node.children.length - (oc_IE); i++) {
			var child = node.children[i];
			if (child.type != 'subordinate')
				continue;
			child.deltacorner = [
				diff_width + incremental_width,
				node.boundbox[1] + staff_height
			];
			incremental_width += child.fullbbox[0];
		}
		for (var i = 0; i < node.children.length - (oc_IE); i++) {
			var child = node.children[i];
			if (child.type != 'subordinate')
				continue;
			oc_update_fullbbox(node, child);
		}
	}

	if (OC_DEBUG) { 
		if (node.children !== undefined) {
			for (var i = 0; i < node.children.length - (oc_IE); i++) {
				var child = node.children[i];
				console.log('oc_boundboxes_dimensions [' + child.title + '] ' +
					'boundbox(' + child.boundbox[0] + ',' + child.boundbox[1] + ') ' +
					'deltacenter(' + child.deltacenter[0] + ',' + child.deltacenter[1] + ') ' +
					'fullbbox(' + child.fullbbox[0] + ',' + child.fullbbox[1] + ') ' +
					'deltacorner(' + child.deltacorner[0] + ',' + child.deltacorner[1] + ') ' +
					'xoffset(' + child.xoffset + ')');
			}
		}
	}
}


// update the full bounding box of a subtree by adding the size and relative position of a child
//
function oc_update_fullbbox(node, child) {
	// entran: child.deltacorner, node.fullbbox
	var x0 = 0, y0 = 0, x1 = node.fullbbox[0], y1 = node.fullbbox[1];

	if (child.deltacorner[0] < x0)                        x0 = child.deltacorner[0];
	if (child.deltacorner[0] + child.fullbbox[0] > x1)    x1 = child.deltacorner[0] + child.fullbbox[0];
	if (child.deltacorner[1] + child.fullbbox[1] > y1)    y1 = child.deltacorner[1] + child.fullbbox[1];
	if (x0 < node.deltacorner[0])                         node.deltacorner[0] = x0;

	if (OC_DEBUG)
		console.log('updatefullbbox ' + node.title + ' <-- ' + child.title + ' x0=' + x0 + ' x1=' + x1 + ' y0=' + y0 + ' y1=' + y1);

	node.fullbbox = [ x1 - x0, y1 - y0 ];
}


// after all calcs, draw the chart into the 'oc_container' DIV
//
function oc_draw () {
	oc_paper = new Raphael(document.getElementById(oc_style.container), oc_data.root.fullbbox[0], oc_data.root.fullbbox[1]);
	oc_draw_obj(oc_data.root, null, 0, 0);
	// draw orgchart title here
}


// draw a subtree
//
function oc_draw_obj (node, parent, xoffset, yoffset) {
	// draw children
	if (node.children !== undefined) {
		for (var i = 0; i < node.children.length - (oc_IE); i++)
			oc_draw_obj(node.children[i], node, node.deltacorner[0] + xoffset, node.deltacorner[1] + yoffset);
	}

	if (OC_DEBUG) {
		console.log('drawing ' + node.title + ': legacyXoff=' + xoffset + ' legacyYoff=' + yoffset +
			' dcornerX=' + node.deltacorner[0] + ' dcornerY=' + node.deltacorner[1] + ' dcenterX=' +
			node.deltacenter[0] +' dcenterY=' + node.deltacenter[1] + ' xoff=' + node.xoffset);
	}

	// draw this node rectangle
	var xc = xoffset + node.deltacorner[0] + node.deltacenter[0] + node.xoffset;
	var yc = yoffset + node.deltacorner[1] + node.deltacenter[1];
	var x0 = xc - oc_max_text_width  / 2 - oc_style.inner_padding;
	var x1 = xc + oc_max_text_width  / 2 + oc_style.inner_padding;
	// GG 110712 support for embeeded images
	if (oc_style.use_images && node.image !== undefined) {
		var y0 = yc - oc_max_text_height / 2 - oc_style.inner_padding - oc_style.images_size[1] / 2 - oc_style.inner_padding / 2;
		var y1 = yc + oc_max_text_height / 2 + oc_style.inner_padding + oc_style.images_size[1] / 2 + oc_style.inner_padding / 2;
	}
	else {
		var y0 = yc - oc_max_text_height / 2 - oc_style.inner_padding;
		var y1 = yc + oc_max_text_height / 2 + oc_style.inner_padding;
	}
	var box = oc_paper.rect(x0, y0, x1 - x0, y1 - y0);
	box.attr('fill'  , oc_style.box_color       );
	box.attr('stroke', oc_style.box_border_color);
	if (node.id !== undefined)
		box.oc_id = node.id;

	// attach events to rectangle
	box.hover(
		function (event) { this.attr({ fill: oc_style.box_color_hover }); },
		function (event) { this.attr({ fill: oc_style.box_color       }); }
		//, overScope, outScope
	);
	if (oc_style.box_click_handler !== null)
		box.click( function (event) { oc_style.box_click_handler(event, box); } );

	// draw node title and subtitle
	var title_ypos = y0 + oc_style.inner_padding
					 + node.title_lines * oc_style.title_char_size[1] / 2
					 + (oc_max_title_lines - node.title_lines) * oc_style.title_char_size[1] / 2
					 - 2;
	var title = oc_paper.text(xc, title_ypos, node.title);
	title.attr('font-family', oc_style.text_font);
	title.attr('font-size', oc_style.title_font_size);
	title.attr('fill', oc_style.title_color);
	if (node.subtitle !== undefined) {
		var subtitle_ypos = y1 - oc_style.inner_padding
							- node.subtitle_lines * oc_style.subtitle_char_size[1] / 2;



		var subtitle = oc_paper.text(xc, subtitle_ypos, node.subtitle);
		subtitle.attr('font-family', oc_style.text_font);
		subtitle.attr('font-size', oc_style.subtitle_font_size);
		subtitle.attr('fill', oc_style.subtitle_color);
	}

	// GG 110712 draw optional images
	if (oc_style.use_images && node.image !== undefined) {
		var image = oc_paper.image(oc_style.images_base_url + node.image,
			xc - oc_style.images_size[0] / 2, y1 - oc_style.images_size[1] - oc_style.inner_padding,
			oc_style.images_size[0], oc_style.images_size[1]);
	}

	// draw line connectors
	if (parent != null) {
		var pxc = xc - node.xoffset - node.deltacorner[0] + parent.xoffset + (                    0 -                   0);
		var pyc = yc -            0 - node.deltacorner[1] +              0 + (parent.deltacenter[1] - node.deltacenter[1]);
		var px0 = pxc - oc_max_text_width  / 2 - oc_style.inner_padding;
		var px1 = pxc + oc_max_text_width  / 2 + oc_style.inner_padding;
		var py0 = pyc - oc_max_text_height / 2 - oc_style.inner_padding;
		var py1 = pyc + oc_max_text_height / 2 + oc_style.inner_padding;
		var line1, line2;
		if (node.type == 'collateral') {
			if (node.position == 'left') {
				var path = 'M ' + x1 + ' ' + yc + ' l ' + (2 * oc_style.hline) + ' 0';
				line1 = oc_paper.path(path);
				line2 = oc_paper.path(path);
			}
			else {   // right
				var path = 'M ' + x0 + ' ' + yc + ' l -' + (2 * oc_style.hline) + ' 0';
				line1 = oc_paper.path(path);
				line2 = oc_paper.path(path);
			}
		}
		else if (node.type == 'staff') {
			if (node.position == 'left') {
				var path = 'M ' + x1 + ' ' + yc + ' h ' + (pxc - x1) + ' v ' + (pyc - yc);
				line1 = oc_paper.path(path);
				line2 = oc_paper.path(path);
			}
			else {   // right
				var path = 'M ' + x0 + ' ' + yc + ' h ' + (pxc - x0) + ' v ' + (pyc - yc);
				line1 = oc_paper.path(path);
				line2 = oc_paper.path(path);
			}
		}
		else {   // subordinate
			if (node.is_root === undefined) {
				var path = 'M ' + xc + ' ' + y0 + ' v -' + oc_style.vline + ' h ' + (pxc - xc) + ' V ' + py1;
				line1 = oc_paper.path(path);
				line2 = oc_paper.path(path);
			}
		}
		line1.attr('stroke', oc_style.line_color);
		line2.attr('stroke', oc_style.line_color);
	}

	if (OC_DEBUG) {
		// draw the boundbox
		x0 = xoffset + node.deltacorner[0] + node.xoffset;
		x1 = xoffset + node.deltacorner[0] + node.xoffset + node.boundbox[0];
		y0 = yoffset + node.deltacorner[1];
		y1 = yoffset + node.deltacorner[1] + node.boundbox[1];
		var boundbox = oc_paper.rect(x0 + 4, y0 + 4, x1 - x0 - 8, y1 - y0 - 6);
		boundbox.attr({
			stroke : "#00f", 
			"stroke-width" : 0.4
		});
		// draw the fullbbox
		x0 = xoffset + node.deltacorner[0];
		x1 = xoffset + node.deltacorner[0] + node.fullbbox[0];
		y0 = yoffset + node.deltacorner[1];
		y1 = yoffset + node.deltacorner[1] + node.fullbbox[1];
		var fullbbox = oc_paper.rect(x0 + 2, y0 + 2, x1 - x0 - 4, y1 - y0 - 2);
		fullbbox.attr({
			stroke : "#f00", 
			"stroke-width" : 0.4
		});
	}

}

// END OF LIBRARY

/* donut */

/** from http://jsfiddle.net/EuMQ5/ */
Raphael.fn.donutChart = function (cx, cy, r, rin, values, labels, stroke) {
    var paper = this,
        rad = Math.PI / 180,
        chart = this.set();
    function sector(cx, cy, r, startAngle, endAngle, params) {
        //console.log(params.fill);
        var x1 = cx + r * Math.cos(-startAngle * rad),
            x2 = cx + r * Math.cos(-endAngle * rad),
            y1 = cy + r * Math.sin(-startAngle * rad),
            y2 = cy + r * Math.sin(-endAngle * rad),
            xx1 = cx + rin * Math.cos(-startAngle * rad),
            xx2 = cx + rin * Math.cos(-endAngle * rad),
            yy1 = cy + rin * Math.sin(-startAngle * rad),
            yy2 = cy + rin * Math.sin(-endAngle * rad);
        
        return paper.path(["M", xx1, yy1,
                           "L", x1, y1, 
                           "A", r, r, 0, +(endAngle - startAngle > 180), 0, x2, y2, 
                           "L", xx2, yy2, 
                           "A", rin, rin, 0, +(endAngle - startAngle > 180), 1, xx1, yy1, "z"]
                         ).attr(params);
        
    }
    var angle = 0,
        total = 0,
        start = 0,
        process = function (j) {
            var value = values[j],
                angleplus = 360 * value / total,
                popangle = angle + (angleplus / 2),
                color = Raphael.hsb(start, .75, 1),
                ms = 500,
                delta = 30,
                bcolor = Raphael.hsb(start, 1, 1),
                p = sector(cx, cy, r, angle, angle + angleplus, {fill: "90-" + bcolor + "-" + color, stroke: stroke, "stroke-width": 3}),
                txt = paper.text(cx + (r + delta + 55) * Math.cos(-popangle * rad), cy + (r + delta + 25) * Math.sin(-popangle * rad), labels[j]).attr({fill: bcolor, stroke: "none", opacity: 0, "font-size": 20});
            p.mouseover(function () {
                p.stop().animate({transform: "s1.1 1.1 " + cx + " " + cy}, ms, "elastic");
                txt.stop().animate({opacity: 1}, ms, "elastic");
            }).mouseout(function () {
                p.stop().animate({transform: ""}, ms, "elastic");
                txt.stop().animate({opacity: 0}, ms);
            });
            angle += angleplus;
            chart.push(p);
            chart.push(txt);
            start += .1;
        };
    for (var i = 0, ii = values.length; i < ii; i++) {
        total += values[i];
    }
    for (i = 0; i < ii; i++) {
        process(i);
    }
    return chart;
};
/* coxcomb */

/*!
 * Copyright (c) 2012 Guillermo Winkler
 * Licensed under the MIT (http://www.opensource.org/licenses/mit-license.php) license.
 */

 /*
 * coxcomb chart method on paper
 */
/*\
 * Paper.coxCombChart
 [ method ]
 **
 * Creates a coxcomb chart
 **
 > Parameters
 **
 - cx (number) x coordinate of the chart
 - cy (number) y coordinate of the chart
 - r (integer) radius of the chart
 - data
 - opts (object) options for the chart
 o {
     categoryFontSize (int)
     seriesFontSize (int)
     onClick (fn)
     categorySize (int)
 o }
 **
 > Usage
 | r.coxCombChart(cx, cy, r, data, opts)
 \*/
(function () {

    var currentColor = 0;
    var rad = Math.PI / 180;

    function positionLabel(paper, cx, cy, r, startAngle, endAngle, params) {
      //need to add text at the middle point between the two lower ones
      var labelAngle = startAngle + (endAngle - startAngle) / 2,
          xLabel = cx + r * Math.cos(-labelAngle * rad),
          yLabel = cy + r * Math.sin(-labelAngle * rad),
          label = paper.text(xLabel, yLabel, params.text).attr({fill: params.fontColor, "font-size": params.fontSize});
      //the label never should be bottom up in order for the
      //text to be read without turning your head or your screen
      if (labelAngle >= 90 && labelAngle < 270) {
          labelAngle += 180;
      }
      label.transform("r" + -labelAngle);
      return label;
    };
    
    function categorySlice(paper, cx, cy, r, startAngle, endAngle, params) {
      var x1 = cx + r * Math.cos(-startAngle * rad),
          x2 = cx + r * Math.cos(-endAngle * rad),
          y1 = cy + r * Math.sin(-startAngle * rad),
          y2 = cy + r * Math.sin(-endAngle * rad);
      var slice = paper.path(["M", cx, cy, 
                              "L", x1, y1, 
                              "A", r, r, 0, +(endAngle - startAngle > 180), 0, x2, y2, 
                              "z"]).attr(params);
      //position the category label in the middle of the slice
      positionLabel(paper, cx, cy, r/2, startAngle, endAngle, params);
      return slice;
    };

    /*
     * Creates a data bar inside a category
     * r1 radius of the category
     * r2 radius of the data bar
     */
    function coxCombBar(paper, cx, cy, r1, r2, startAngle, endAngle, params) {
      var x1 = cx + r1 * Math.cos(-startAngle * rad),
          y1 = cy + r1 * Math.sin(-startAngle * rad),
          x2 = cx + r2 * Math.cos(-startAngle * rad),
          y2 = cy + r2 * Math.sin(-startAngle * rad),
          x3 = cx + r2 * Math.cos(-endAngle * rad),
          y3 = cy + r2 * Math.sin(-endAngle * rad),
          x4 = cx + r1 * Math.cos(-endAngle * rad),
          y4 = cy + r1 * Math.sin(-endAngle * rad);
      
      var polygon = paper.path([ "M", x1, y1, 
                                 "L", x2, y2, 
                                 "A", r2, r2, 0, +(endAngle - startAngle > 180), 0, x3, y3, 
                                 "L", x4, y4, 
                                 "A", r1, r1, 0, +(endAngle - startAngle > 180), 0, x1, y1, 
                                 "z"]).attr(params);
      var label = positionLabel(paper, cx, cy, (r1 + r2) / 2, startAngle, endAngle, params); 
      var section = paper.set();
      section.push(polygon, label);
      var onClick = function() {
        if (typeof(params.onClick) === "function") {
            section.toFront();
            params.onClick(polygon, params.text);
        }
      };
      var onMouseOver = function() {
        polygon.attr({ "fill-opacity" : 0.2 });
      };
      var onMouseOut = function() {
        polygon.attr({ "fill-opacity": params["fill-opacity"] || 1 });
      };
      section.mouseover(onMouseOver)
           .mouseout(onMouseOut)
           .click(onClick);
      return section;
    };

    function getSeriesColor(category, serie, dataset) {
      if (dataset.colors) {
        if (dataset.colors.byCategory && dataset.colors.byCategory[category]) {
            return dataset.colors.byCategory[category];
        }
        if (dataset.colors.bySeries && dataset.colors.bySeries[serie]) {
            return dataset.colors.bySeries[serie];
        }
      }
      currentColor+=1;
      return {
         color: Raphael.hsb(currentColor, 1, 1)
      };
    };

    /*
     * {
     *  data: {
     *      jan : {
     *          disease : 80,
     *          battle : 20             
     *      },
     *      feb : {
     *          disease : 70,
     *          battle : 10
     *      }
     *  },
     *  colors : {
     *      category : #fff,
     *      opacity : 0.2,
     *      byCategory : {
     *          jan : {
     *              color : #fff,
     *              hover : #fff,
     *              opacity : 0.5
     *          },
     *          feb : {
     *              color: #fff
     *          }
     *      },
     *      bySeries : {
     *          disease : {
     *              color : #fff,
     *              hover : #fff
     *          },
     *          battle : {
     *              color : #fff
     *              hover : #fff
     *          }
     *      }
     *  }
     * }
     */
    function CoxCombChart(paper, cx, cy, r, dataset, opts) {
        var chart = paper.set();

        //categories and series should be counted in order
        //to set the angles properly
        var totalCategories = 0;
        var totalSeries = {};
        var maxValue;
        var cat, serie;
        for (cat in dataset.data) {
            if (dataset.data.hasOwnProperty(cat)) {
                totalCategories+=1;
                if (typeof(dataset.data[cat]) === "object") {
                    totalSeries[cat] = 0;
                    for (serie in dataset.data[cat]) {
                        if (dataset.data[cat].hasOwnProperty(serie)) {
                            totalSeries[cat]+=1;
                            //the maximum value of all the series is used
                            //for normalization of the radius
                            if (!maxValue || maxValue < dataset.data[cat][serie]) {
                                maxValue = dataset.data[cat][serie];
                            }
                        }
                    }
                }
            }
        }
        var catSize = (opts && opts.categorySize) || 0.30;
        var currentAngle = 0;
        var catRadius = r * catSize;
        var catAngle = 360 * (1 / totalCategories);
        for (cat in dataset.data) {
            if (typeof(dataset.data[cat]) === "object") {
                categorySlice(paper, cx, cy, catRadius, currentAngle, currentAngle + catAngle, 
                              {fill: dataset.colors.category, 
                               "fill-opacity": dataset.colors.opacity, 
                               text: cat,
                               fontSize: opts.categoryFontSize,
                               fontColor: dataset.colors.fontColor,
                               stroke: opts.stroke, 
                               "stroke-width": 3 });
                for (serie in dataset.data[cat]) {
                    var serieRadius = catRadius + (r * (1 - catSize) * (dataset.data[cat][serie] / maxValue));
                    var serieAngle = catAngle / totalSeries[cat];
                    var color = getSeriesColor(cat, serie, dataset);
                    coxCombBar(paper, cx, cy, catRadius, serieRadius, 
                               currentAngle, currentAngle + serieAngle, 
                               { fill: color.color, 
                                 stroke: opts.stroke,
                                 hoverColor : color.hover,    
                                 fontSize: opts.seriesFontSize,
                                 fontColor: color.fontColor,
                                 text: serie,
                                 "fill-opacity": color.opacity, 
                                 "stroke-width": 3,
                                 onClick: opts.onClick});
                    //when the last serie is finished for this category
                    //the angle is at the beginning of the next one
                    currentAngle += serieAngle;
                }
            }
        }
    }

    //public
    Raphael.fn.coxCombChart = function(cx, cy, r, dataset, opts) {
        return new CoxCombChart(this, cx, cy, r, dataset, opts);
    };
    
}());
