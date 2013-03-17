// moment.js
// version : 2.0.0
// author : Tim Wood
// license : MIT
// momentjs.com

(function (undefined) {

    /************************************
        Constants
    ************************************/

    var moment,
        VERSION = "2.0.0",
        round = Math.round, i,
        // internal storage for language config files
        languages = {},

        // check for nodeJS
        hasModule = (typeof module !== 'undefined' && module.exports),

        // ASP.NET json date format regex
        aspNetJsonRegex = /^\/?Date\((\-?\d+)/i,

        // format tokens
        formattingTokens = /(\[[^\[]*\])|(\\)?(Mo|MM?M?M?|Do|DDDo|DD?D?D?|ddd?d?|do?|w[o|w]?|W[o|W]?|YYYYY|YYYY|YY|a|A|hh?|HH?|mm?|ss?|SS?S?|X|zz?|ZZ?|.)/g,
        localFormattingTokens = /(\[[^\[]*\])|(\\)?(LT|LL?L?L?|l{1,4})/g,

        // parsing tokens
        parseMultipleFormatChunker = /([0-9a-zA-Z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+)/gi,

        // parsing token regexes
        parseTokenOneOrTwoDigits = /\d\d?/, // 0 - 99
        parseTokenOneToThreeDigits = /\d{1,3}/, // 0 - 999
        parseTokenThreeDigits = /\d{3}/, // 000 - 999
        parseTokenFourDigits = /\d{1,4}/, // 0 - 9999
        parseTokenSixDigits = /[+\-]?\d{1,6}/, // -999,999 - 999,999
        parseTokenWord = /[0-9]*[a-z\u00A0-\u05FF\u0700-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+|[\u0600-\u06FF]+\s*?[\u0600-\u06FF]+/i, // any word (or two) characters or numbers including two word month in arabic.
        parseTokenTimezone = /Z|[\+\-]\d\d:?\d\d/i, // +00:00 -00:00 +0000 -0000 or Z
        parseTokenT = /T/i, // T (ISO seperator)
        parseTokenTimestampMs = /[\+\-]?\d+(\.\d{1,3})?/, // 123456789 123456789.123

        // preliminary iso regex
        // 0000-00-00 + T + 00 or 00:00 or 00:00:00 or 00:00:00.000 + +00:00 or +0000
        isoRegex = /^\s*\d{4}-\d\d-\d\d((T| )(\d\d(:\d\d(:\d\d(\.\d\d?\d?)?)?)?)?([\+\-]\d\d:?\d\d)?)?/,
        isoFormat = 'YYYY-MM-DDTHH:mm:ssZ',

        // iso time formats and regexes
        isoTimes = [
            ['HH:mm:ss.S', /(T| )\d\d:\d\d:\d\d\.\d{1,3}/],
            ['HH:mm:ss', /(T| )\d\d:\d\d:\d\d/],
            ['HH:mm', /(T| )\d\d:\d\d/],
            ['HH', /(T| )\d\d/]
        ],

        // timezone chunker "+10:00" > ["10", "00"] or "-1530" > ["-15", "30"]
        parseTimezoneChunker = /([\+\-]|\d\d)/gi,

        // getter and setter names
        proxyGettersAndSetters = 'Month|Date|Hours|Minutes|Seconds|Milliseconds'.split('|'),
        unitMillisecondFactors = {
            'Milliseconds' : 1,
            'Seconds' : 1e3,
            'Minutes' : 6e4,
            'Hours' : 36e5,
            'Days' : 864e5,
            'Months' : 2592e6,
            'Years' : 31536e6
        },

        // format function strings
        formatFunctions = {},

        // tokens to ordinalize and pad
        ordinalizeTokens = 'DDD w W M D d'.split(' '),
        paddedTokens = 'M D H h m s w W'.split(' '),

        formatTokenFunctions = {
            M    : function () {
                return this.month() + 1;
            },
            MMM  : function (format) {
                return this.lang().monthsShort(this, format);
            },
            MMMM : function (format) {
                return this.lang().months(this, format);
            },
            D    : function () {
                return this.date();
            },
            DDD  : function () {
                return this.dayOfYear();
            },
            d    : function () {
                return this.day();
            },
            dd   : function (format) {
                return this.lang().weekdaysMin(this, format);
            },
            ddd  : function (format) {
                return this.lang().weekdaysShort(this, format);
            },
            dddd : function (format) {
                return this.lang().weekdays(this, format);
            },
            w    : function () {
                return this.week();
            },
            W    : function () {
                return this.isoWeek();
            },
            YY   : function () {
                return leftZeroFill(this.year() % 100, 2);
            },
            YYYY : function () {
                return leftZeroFill(this.year(), 4);
            },
            YYYYY : function () {
                return leftZeroFill(this.year(), 5);
            },
            a    : function () {
                return this.lang().meridiem(this.hours(), this.minutes(), true);
            },
            A    : function () {
                return this.lang().meridiem(this.hours(), this.minutes(), false);
            },
            H    : function () {
                return this.hours();
            },
            h    : function () {
                return this.hours() % 12 || 12;
            },
            m    : function () {
                return this.minutes();
            },
            s    : function () {
                return this.seconds();
            },
            S    : function () {
                return ~~(this.milliseconds() / 100);
            },
            SS   : function () {
                return leftZeroFill(~~(this.milliseconds() / 10), 2);
            },
            SSS  : function () {
                return leftZeroFill(this.milliseconds(), 3);
            },
            Z    : function () {
                var a = -this.zone(),
                    b = "+";
                if (a < 0) {
                    a = -a;
                    b = "-";
                }
                return b + leftZeroFill(~~(a / 60), 2) + ":" + leftZeroFill(~~a % 60, 2);
            },
            ZZ   : function () {
                var a = -this.zone(),
                    b = "+";
                if (a < 0) {
                    a = -a;
                    b = "-";
                }
                return b + leftZeroFill(~~(10 * a / 6), 4);
            },
            X    : function () {
                return this.unix();
            }
        };

    function padToken(func, count) {
        return function (a) {
            return leftZeroFill(func.call(this, a), count);
        };
    }
    function ordinalizeToken(func) {
        return function (a) {
            return this.lang().ordinal(func.call(this, a));
        };
    }

    while (ordinalizeTokens.length) {
        i = ordinalizeTokens.pop();
        formatTokenFunctions[i + 'o'] = ordinalizeToken(formatTokenFunctions[i]);
    }
    while (paddedTokens.length) {
        i = paddedTokens.pop();
        formatTokenFunctions[i + i] = padToken(formatTokenFunctions[i], 2);
    }
    formatTokenFunctions.DDDD = padToken(formatTokenFunctions.DDD, 3);


    /************************************
        Constructors
    ************************************/

    function Language() {

    }

    // Moment prototype object
    function Moment(config) {
        extend(this, config);
    }

    // Duration Constructor
    function Duration(duration) {
        var data = this._data = {},
            years = duration.years || duration.year || duration.y || 0,
            months = duration.months || duration.month || duration.M || 0,
            weeks = duration.weeks || duration.week || duration.w || 0,
            days = duration.days || duration.day || duration.d || 0,
            hours = duration.hours || duration.hour || duration.h || 0,
            minutes = duration.minutes || duration.minute || duration.m || 0,
            seconds = duration.seconds || duration.second || duration.s || 0,
            milliseconds = duration.milliseconds || duration.millisecond || duration.ms || 0;

        // representation for dateAddRemove
        this._milliseconds = milliseconds +
            seconds * 1e3 + // 1000
            minutes * 6e4 + // 1000 * 60
            hours * 36e5; // 1000 * 60 * 60
        // Because of dateAddRemove treats 24 hours as different from a
        // day when working around DST, we need to store them separately
        this._days = days +
            weeks * 7;
        // It is impossible translate months into days without knowing
        // which months you are are talking about, so we have to store
        // it separately.
        this._months = months +
            years * 12;

        // The following code bubbles up values, see the tests for
        // examples of what that means.
        data.milliseconds = milliseconds % 1000;
        seconds += absRound(milliseconds / 1000);

        data.seconds = seconds % 60;
        minutes += absRound(seconds / 60);

        data.minutes = minutes % 60;
        hours += absRound(minutes / 60);

        data.hours = hours % 24;
        days += absRound(hours / 24);

        days += weeks * 7;
        data.days = days % 30;

        months += absRound(days / 30);

        data.months = months % 12;
        years += absRound(months / 12);

        data.years = years;
    }


    /************************************
        Helpers
    ************************************/


    function extend(a, b) {
        for (var i in b) {
            if (b.hasOwnProperty(i)) {
                a[i] = b[i];
            }
        }
        return a;
    }

    function absRound(number) {
        if (number < 0) {
            return Math.ceil(number);
        } else {
            return Math.floor(number);
        }
    }

    // left zero fill a number
    // see http://jsperf.com/left-zero-filling for performance comparison
    function leftZeroFill(number, targetLength) {
        var output = number + '';
        while (output.length < targetLength) {
            output = '0' + output;
        }
        return output;
    }

    // helper function for _.addTime and _.subtractTime
    function addOrSubtractDurationFromMoment(mom, duration, isAdding) {
        var ms = duration._milliseconds,
            d = duration._days,
            M = duration._months,
            currentDate;

        if (ms) {
            mom._d.setTime(+mom + ms * isAdding);
        }
        if (d) {
            mom.date(mom.date() + d * isAdding);
        }
        if (M) {
            currentDate = mom.date();
            mom.date(1)
                .month(mom.month() + M * isAdding)
                .date(Math.min(currentDate, mom.daysInMonth()));
        }
    }

    // check if is an array
    function isArray(input) {
        return Object.prototype.toString.call(input) === '[object Array]';
    }

    // compare two arrays, return the number of differences
    function compareArrays(array1, array2) {
        var len = Math.min(array1.length, array2.length),
            lengthDiff = Math.abs(array1.length - array2.length),
            diffs = 0,
            i;
        for (i = 0; i < len; i++) {
            if (~~array1[i] !== ~~array2[i]) {
                diffs++;
            }
        }
        return diffs + lengthDiff;
    }


    /************************************
        Languages
    ************************************/


    Language.prototype = {
        set : function (config) {
            var prop, i;
            for (i in config) {
                prop = config[i];
                if (typeof prop === 'function') {
                    this[i] = prop;
                } else {
                    this['_' + i] = prop;
                }
            }
        },

        _months : "January_February_March_April_May_June_July_August_September_October_November_December".split("_"),
        months : function (m) {
            return this._months[m.month()];
        },

        _monthsShort : "Jan_Feb_Mar_Apr_May_Jun_Jul_Aug_Sep_Oct_Nov_Dec".split("_"),
        monthsShort : function (m) {
            return this._monthsShort[m.month()];
        },

        monthsParse : function (monthName) {
            var i, mom, regex, output;

            if (!this._monthsParse) {
                this._monthsParse = [];
            }

            for (i = 0; i < 12; i++) {
                // make the regex if we don't have it already
                if (!this._monthsParse[i]) {
                    mom = moment([2000, i]);
                    regex = '^' + this.months(mom, '') + '|^' + this.monthsShort(mom, '');
                    this._monthsParse[i] = new RegExp(regex.replace('.', ''), 'i');
                }
                // test the regex
                if (this._monthsParse[i].test(monthName)) {
                    return i;
                }
            }
        },

        _weekdays : "Sunday_Monday_Tuesday_Wednesday_Thursday_Friday_Saturday".split("_"),
        weekdays : function (m) {
            return this._weekdays[m.day()];
        },

        _weekdaysShort : "Sun_Mon_Tue_Wed_Thu_Fri_Sat".split("_"),
        weekdaysShort : function (m) {
            return this._weekdaysShort[m.day()];
        },

        _weekdaysMin : "Su_Mo_Tu_We_Th_Fr_Sa".split("_"),
        weekdaysMin : function (m) {
            return this._weekdaysMin[m.day()];
        },

        _longDateFormat : {
            LT : "h:mm A",
            L : "MM/DD/YYYY",
            LL : "MMMM D YYYY",
            LLL : "MMMM D YYYY LT",
            LLLL : "dddd, MMMM D YYYY LT"
        },
        longDateFormat : function (key) {
            var output = this._longDateFormat[key];
            if (!output && this._longDateFormat[key.toUpperCase()]) {
                output = this._longDateFormat[key.toUpperCase()].replace(/MMMM|MM|DD|dddd/g, function (val) {
                    return val.slice(1);
                });
                this._longDateFormat[key] = output;
            }
            return output;
        },

        meridiem : function (hours, minutes, isLower) {
            if (hours > 11) {
                return isLower ? 'pm' : 'PM';
            } else {
                return isLower ? 'am' : 'AM';
            }
        },

        _calendar : {
            sameDay : '[Today at] LT',
            nextDay : '[Tomorrow at] LT',
            nextWeek : 'dddd [at] LT',
            lastDay : '[Yesterday at] LT',
            lastWeek : '[last] dddd [at] LT',
            sameElse : 'L'
        },
        calendar : function (key, mom) {
            var output = this._calendar[key];
            return typeof output === 'function' ? output.apply(mom) : output;
        },

        _relativeTime : {
            future : "in %s",
            past : "%s ago",
            s : "a few seconds",
            m : "a minute",
            mm : "%d minutes",
            h : "an hour",
            hh : "%d hours",
            d : "a day",
            dd : "%d days",
            M : "a month",
            MM : "%d months",
            y : "a year",
            yy : "%d years"
        },
        relativeTime : function (number, withoutSuffix, string, isFuture) {
            var output = this._relativeTime[string];
            return (typeof output === 'function') ?
                output(number, withoutSuffix, string, isFuture) :
                output.replace(/%d/i, number);
        },
        pastFuture : function (diff, output) {
            var format = this._relativeTime[diff > 0 ? 'future' : 'past'];
            return typeof format === 'function' ? format(output) : format.replace(/%s/i, output);
        },

        ordinal : function (number) {
            return this._ordinal.replace("%d", number);
        },
        _ordinal : "%d",

        preparse : function (string) {
            return string;
        },

        postformat : function (string) {
            return string;
        },

        week : function (mom) {
            return weekOfYear(mom, this._week.dow, this._week.doy);
        },
        _week : {
            dow : 0, // Sunday is the first day of the week.
            doy : 6  // The week that contains Jan 1st is the first week of the year.
        }
    };

    // Loads a language definition into the `languages` cache.  The function
    // takes a key and optionally values.  If not in the browser and no values
    // are provided, it will load the language file module.  As a convenience,
    // this function also returns the language values.
    function loadLang(key, values) {
        values.abbr = key;
        if (!languages[key]) {
            languages[key] = new Language();
        }
        languages[key].set(values);
        return languages[key];
    }

    // Determines which language definition to use and returns it.
    //
    // With no parameters, it will return the global language.  If you
    // pass in a language key, such as 'en', it will return the
    // definition for 'en', so long as 'en' has already been loaded using
    // moment.lang.
    function getLangDefinition(key) {
        if (!key) {
            return moment.fn._lang;
        }
        if (!languages[key] && hasModule) {
            require('./lang/' + key);
        }
        return languages[key];
    }


    /************************************
        Formatting
    ************************************/


    function removeFormattingTokens(input) {
        if (input.match(/\[.*\]/)) {
            return input.replace(/^\[|\]$/g, "");
        }
        return input.replace(/\\/g, "");
    }

    function makeFormatFunction(format) {
        var array = format.match(formattingTokens), i, length;

        for (i = 0, length = array.length; i < length; i++) {
            if (formatTokenFunctions[array[i]]) {
                array[i] = formatTokenFunctions[array[i]];
            } else {
                array[i] = removeFormattingTokens(array[i]);
            }
        }

        return function (mom) {
            var output = "";
            for (i = 0; i < length; i++) {
                output += typeof array[i].call === 'function' ? array[i].call(mom, format) : array[i];
            }
            return output;
        };
    }

    // format date using native date object
    function formatMoment(m, format) {
        var i = 5;

        function replaceLongDateFormatTokens(input) {
            return m.lang().longDateFormat(input) || input;
        }

        while (i-- && localFormattingTokens.test(format)) {
            format = format.replace(localFormattingTokens, replaceLongDateFormatTokens);
        }

        if (!formatFunctions[format]) {
            formatFunctions[format] = makeFormatFunction(format);
        }

        return formatFunctions[format](m);
    }


    /************************************
        Parsing
    ************************************/


    // get the regex to find the next token
    function getParseRegexForToken(token) {
        switch (token) {
        case 'DDDD':
            return parseTokenThreeDigits;
        case 'YYYY':
            return parseTokenFourDigits;
        case 'YYYYY':
            return parseTokenSixDigits;
        case 'S':
        case 'SS':
        case 'SSS':
        case 'DDD':
            return parseTokenOneToThreeDigits;
        case 'MMM':
        case 'MMMM':
        case 'dd':
        case 'ddd':
        case 'dddd':
        case 'a':
        case 'A':
            return parseTokenWord;
        case 'X':
            return parseTokenTimestampMs;
        case 'Z':
        case 'ZZ':
            return parseTokenTimezone;
        case 'T':
            return parseTokenT;
        case 'MM':
        case 'DD':
        case 'YY':
        case 'HH':
        case 'hh':
        case 'mm':
        case 'ss':
        case 'M':
        case 'D':
        case 'd':
        case 'H':
        case 'h':
        case 'm':
        case 's':
            return parseTokenOneOrTwoDigits;
        default :
            return new RegExp(token.replace('\\', ''));
        }
    }

    // function to convert string input to date
    function addTimeToArrayFromToken(token, input, config) {
        var a, b,
            datePartArray = config._a;

        switch (token) {
        // MONTH
        case 'M' : // fall through to MM
        case 'MM' :
            datePartArray[1] = (input == null) ? 0 : ~~input - 1;
            break;
        case 'MMM' : // fall through to MMMM
        case 'MMMM' :
            a = getLangDefinition(config._l).monthsParse(input);
            // if we didn't find a month name, mark the date as invalid.
            if (a != null) {
                datePartArray[1] = a;
            } else {
                config._isValid = false;
            }
            break;
        // DAY OF MONTH
        case 'D' : // fall through to DDDD
        case 'DD' : // fall through to DDDD
        case 'DDD' : // fall through to DDDD
        case 'DDDD' :
            if (input != null) {
                datePartArray[2] = ~~input;
            }
            break;
        // YEAR
        case 'YY' :
            datePartArray[0] = ~~input + (~~input > 68 ? 1900 : 2000);
            break;
        case 'YYYY' :
        case 'YYYYY' :
            datePartArray[0] = ~~input;
            break;
        // AM / PM
        case 'a' : // fall through to A
        case 'A' :
            config._isPm = ((input + '').toLowerCase() === 'pm');
            break;
        // 24 HOUR
        case 'H' : // fall through to hh
        case 'HH' : // fall through to hh
        case 'h' : // fall through to hh
        case 'hh' :
            datePartArray[3] = ~~input;
            break;
        // MINUTE
        case 'm' : // fall through to mm
        case 'mm' :
            datePartArray[4] = ~~input;
            break;
        // SECOND
        case 's' : // fall through to ss
        case 'ss' :
            datePartArray[5] = ~~input;
            break;
        // MILLISECOND
        case 'S' :
        case 'SS' :
        case 'SSS' :
            datePartArray[6] = ~~ (('0.' + input) * 1000);
            break;
        // UNIX TIMESTAMP WITH MS
        case 'X':
            config._d = new Date(parseFloat(input) * 1000);
            break;
        // TIMEZONE
        case 'Z' : // fall through to ZZ
        case 'ZZ' :
            config._useUTC = true;
            a = (input + '').match(parseTimezoneChunker);
            if (a && a[1]) {
                config._tzh = ~~a[1];
            }
            if (a && a[2]) {
                config._tzm = ~~a[2];
            }
            // reverse offsets
            if (a && a[0] === '+') {
                config._tzh = -config._tzh;
                config._tzm = -config._tzm;
            }
            break;
        }

        // if the input is null, the date is not valid
        if (input == null) {
            config._isValid = false;
        }
    }

    // convert an array to a date.
    // the array should mirror the parameters below
    // note: all values past the year are optional and will default to the lowest possible value.
    // [year, month, day , hour, minute, second, millisecond]
    function dateFromArray(config) {
        var i, date, input = [];

        if (config._d) {
            return;
        }

        for (i = 0; i < 7; i++) {
            config._a[i] = input[i] = (config._a[i] == null) ? (i === 2 ? 1 : 0) : config._a[i];
        }

        // add the offsets to the time to be parsed so that we can have a clean array for checking isValid
        input[3] += config._tzh || 0;
        input[4] += config._tzm || 0;

        date = new Date(0);

        if (config._useUTC) {
            date.setUTCFullYear(input[0], input[1], input[2]);
            date.setUTCHours(input[3], input[4], input[5], input[6]);
        } else {
            date.setFullYear(input[0], input[1], input[2]);
            date.setHours(input[3], input[4], input[5], input[6]);
        }

        config._d = date;
    }

    // date from string and format string
    function makeDateFromStringAndFormat(config) {
        // This array is used to make a Date, either with `new Date` or `Date.UTC`
        var tokens = config._f.match(formattingTokens),
            string = config._i,
            i, parsedInput;

        config._a = [];

        for (i = 0; i < tokens.length; i++) {
            parsedInput = (getParseRegexForToken(tokens[i]).exec(string) || [])[0];
            if (parsedInput) {
                string = string.slice(string.indexOf(parsedInput) + parsedInput.length);
            }
            // don't parse if its not a known token
            if (formatTokenFunctions[tokens[i]]) {
                addTimeToArrayFromToken(tokens[i], parsedInput, config);
            }
        }
        // handle am pm
        if (config._isPm && config._a[3] < 12) {
            config._a[3] += 12;
        }
        // if is 12 am, change hours to 0
        if (config._isPm === false && config._a[3] === 12) {
            config._a[3] = 0;
        }
        // return
        dateFromArray(config);
    }

    // date from string and array of format strings
    function makeDateFromStringAndArray(config) {
        var tempConfig,
            tempMoment,
            bestMoment,

            scoreToBeat = 99,
            i,
            currentDate,
            currentScore;

        while (config._f.length) {
            tempConfig = extend({}, config);
            tempConfig._f = config._f.pop();
            makeDateFromStringAndFormat(tempConfig);
            tempMoment = new Moment(tempConfig);

            if (tempMoment.isValid()) {
                bestMoment = tempMoment;
                break;
            }

            currentScore = compareArrays(tempConfig._a, tempMoment.toArray());

            if (currentScore < scoreToBeat) {
                scoreToBeat = currentScore;
                bestMoment = tempMoment;
            }
        }

        extend(config, bestMoment);
    }

    // date from iso format
    function makeDateFromString(config) {
        var i,
            string = config._i;
        if (isoRegex.exec(string)) {
            config._f = 'YYYY-MM-DDT';
            for (i = 0; i < 4; i++) {
                if (isoTimes[i][1].exec(string)) {
                    config._f += isoTimes[i][0];
                    break;
                }
            }
            if (parseTokenTimezone.exec(string)) {
                config._f += " Z";
            }
            makeDateFromStringAndFormat(config);
        } else {
            config._d = new Date(string);
        }
    }

    function makeDateFromInput(config) {
        var input = config._i,
            matched = aspNetJsonRegex.exec(input);

        if (input === undefined) {
            config._d = new Date();
        } else if (matched) {
            config._d = new Date(+matched[1]);
        } else if (typeof input === 'string') {
            makeDateFromString(config);
        } else if (isArray(input)) {
            config._a = input.slice(0);
            dateFromArray(config);
        } else {
            config._d = input instanceof Date ? new Date(+input) : new Date(input);
        }
    }


    /************************************
        Relative Time
    ************************************/


    // helper function for moment.fn.from, moment.fn.fromNow, and moment.duration.fn.humanize
    function substituteTimeAgo(string, number, withoutSuffix, isFuture, lang) {
        return lang.relativeTime(number || 1, !!withoutSuffix, string, isFuture);
    }

    function relativeTime(milliseconds, withoutSuffix, lang) {
        var seconds = round(Math.abs(milliseconds) / 1000),
            minutes = round(seconds / 60),
            hours = round(minutes / 60),
            days = round(hours / 24),
            years = round(days / 365),
            args = seconds < 45 && ['s', seconds] ||
                minutes === 1 && ['m'] ||
                minutes < 45 && ['mm', minutes] ||
                hours === 1 && ['h'] ||
                hours < 22 && ['hh', hours] ||
                days === 1 && ['d'] ||
                days <= 25 && ['dd', days] ||
                days <= 45 && ['M'] ||
                days < 345 && ['MM', round(days / 30)] ||
                years === 1 && ['y'] || ['yy', years];
        args[2] = withoutSuffix;
        args[3] = milliseconds > 0;
        args[4] = lang;
        return substituteTimeAgo.apply({}, args);
    }


    /************************************
        Week of Year
    ************************************/


    // firstDayOfWeek       0 = sun, 6 = sat
    //                      the day of the week that starts the week
    //                      (usually sunday or monday)
    // firstDayOfWeekOfYear 0 = sun, 6 = sat
    //                      the first week is the week that contains the first
    //                      of this day of the week
    //                      (eg. ISO weeks use thursday (4))
    function weekOfYear(mom, firstDayOfWeek, firstDayOfWeekOfYear) {
        var end = firstDayOfWeekOfYear - firstDayOfWeek,
            daysToDayOfWeek = firstDayOfWeekOfYear - mom.day();


        if (daysToDayOfWeek > end) {
            daysToDayOfWeek -= 7;
        }

        if (daysToDayOfWeek < end - 7) {
            daysToDayOfWeek += 7;
        }

        return Math.ceil(moment(mom).add('d', daysToDayOfWeek).dayOfYear() / 7);
    }


    /************************************
        Top Level Functions
    ************************************/

    function makeMoment(config) {
        var input = config._i,
            format = config._f;

        if (input === null || input === '') {
            return null;
        }

        if (typeof input === 'string') {
            config._i = input = getLangDefinition().preparse(input);
        }

        if (moment.isMoment(input)) {
            config = extend({}, input);
            config._d = new Date(+input._d);
        } else if (format) {
            if (isArray(format)) {
                makeDateFromStringAndArray(config);
            } else {
                makeDateFromStringAndFormat(config);
            }
        } else {
            makeDateFromInput(config);
        }

        return new Moment(config);
    }

    moment = function (input, format, lang) {
        return makeMoment({
            _i : input,
            _f : format,
            _l : lang,
            _isUTC : false
        });
    };

    // creating with utc
    moment.utc = function (input, format, lang) {
        return makeMoment({
            _useUTC : true,
            _isUTC : true,
            _l : lang,
            _i : input,
            _f : format
        });
    };

    // creating with unix timestamp (in seconds)
    moment.unix = function (input) {
        return moment(input * 1000);
    };

    // duration
    moment.duration = function (input, key) {
        var isDuration = moment.isDuration(input),
            isNumber = (typeof input === 'number'),
            duration = (isDuration ? input._data : (isNumber ? {} : input)),
            ret;

        if (isNumber) {
            if (key) {
                duration[key] = input;
            } else {
                duration.milliseconds = input;
            }
        }

        ret = new Duration(duration);

        if (isDuration && input.hasOwnProperty('_lang')) {
            ret._lang = input._lang;
        }

        return ret;
    };

    // version number
    moment.version = VERSION;

    // default format
    moment.defaultFormat = isoFormat;

    // This function will load languages and then set the global language.  If
    // no arguments are passed in, it will simply return the current global
    // language key.
    moment.lang = function (key, values) {
        var i;

        if (!key) {
            return moment.fn._lang._abbr;
        }
        if (values) {
            loadLang(key, values);
        } else if (!languages[key]) {
            getLangDefinition(key);
        }
        moment.duration.fn._lang = moment.fn._lang = getLangDefinition(key);
    };

    // returns language data
    moment.langData = function (key) {
        if (key && key._lang && key._lang._abbr) {
            key = key._lang._abbr;
        }
        return getLangDefinition(key);
    };

    // compare moment object
    moment.isMoment = function (obj) {
        return obj instanceof Moment;
    };

    // for typechecking Duration objects
    moment.isDuration = function (obj) {
        return obj instanceof Duration;
    };


    /************************************
        Moment Prototype
    ************************************/


    moment.fn = Moment.prototype = {

        clone : function () {
            return moment(this);
        },

        valueOf : function () {
            return +this._d;
        },

        unix : function () {
            return Math.floor(+this._d / 1000);
        },

        toString : function () {
            return this.format("ddd MMM DD YYYY HH:mm:ss [GMT]ZZ");
        },

        toDate : function () {
            return this._d;
        },

        toJSON : function () {
            return moment.utc(this).format('YYYY-MM-DD[T]HH:mm:ss.SSS[Z]');
        },

        toArray : function () {
            var m = this;
            return [
                m.year(),
                m.month(),
                m.date(),
                m.hours(),
                m.minutes(),
                m.seconds(),
                m.milliseconds()
            ];
        },

        isValid : function () {
            if (this._isValid == null) {
                if (this._a) {
                    this._isValid = !compareArrays(this._a, (this._isUTC ? moment.utc(this._a) : moment(this._a)).toArray());
                } else {
                    this._isValid = !isNaN(this._d.getTime());
                }
            }
            return !!this._isValid;
        },

        utc : function () {
            this._isUTC = true;
            return this;
        },

        local : function () {
            this._isUTC = false;
            return this;
        },

        format : function (inputString) {
            var output = formatMoment(this, inputString || moment.defaultFormat);
            return this.lang().postformat(output);
        },

        add : function (input, val) {
            var dur;
            // switch args to support add('s', 1) and add(1, 's')
            if (typeof input === 'string') {
                dur = moment.duration(+val, input);
            } else {
                dur = moment.duration(input, val);
            }
            addOrSubtractDurationFromMoment(this, dur, 1);
            return this;
        },

        subtract : function (input, val) {
            var dur;
            // switch args to support subtract('s', 1) and subtract(1, 's')
            if (typeof input === 'string') {
                dur = moment.duration(+val, input);
            } else {
                dur = moment.duration(input, val);
            }
            addOrSubtractDurationFromMoment(this, dur, -1);
            return this;
        },

        diff : function (input, units, asFloat) {
            var that = this._isUTC ? moment(input).utc() : moment(input).local(),
                zoneDiff = (this.zone() - that.zone()) * 6e4,
                diff, output;

            if (units) {
                // standardize on singular form
                units = units.replace(/s$/, '');
            }

            if (units === 'year' || units === 'month') {
                diff = (this.daysInMonth() + that.daysInMonth()) * 432e5; // 24 * 60 * 60 * 1000 / 2
                output = ((this.year() - that.year()) * 12) + (this.month() - that.month());
                output += ((this - moment(this).startOf('month')) - (that - moment(that).startOf('month'))) / diff;
                if (units === 'year') {
                    output = output / 12;
                }
            } else {
                diff = (this - that) - zoneDiff;
                output = units === 'second' ? diff / 1e3 : // 1000
                    units === 'minute' ? diff / 6e4 : // 1000 * 60
                    units === 'hour' ? diff / 36e5 : // 1000 * 60 * 60
                    units === 'day' ? diff / 864e5 : // 1000 * 60 * 60 * 24
                    units === 'week' ? diff / 6048e5 : // 1000 * 60 * 60 * 24 * 7
                    diff;
            }
            return asFloat ? output : absRound(output);
        },

        from : function (time, withoutSuffix) {
            return moment.duration(this.diff(time)).lang(this.lang()._abbr).humanize(!withoutSuffix);
        },

        fromNow : function (withoutSuffix) {
            return this.from(moment(), withoutSuffix);
        },

        calendar : function () {
            var diff = this.diff(moment().startOf('day'), 'days', true),
                format = diff < -6 ? 'sameElse' :
                diff < -1 ? 'lastWeek' :
                diff < 0 ? 'lastDay' :
                diff < 1 ? 'sameDay' :
                diff < 2 ? 'nextDay' :
                diff < 7 ? 'nextWeek' : 'sameElse';
            return this.format(this.lang().calendar(format, this));
        },

        isLeapYear : function () {
            var year = this.year();
            return (year % 4 === 0 && year % 100 !== 0) || year % 400 === 0;
        },

        isDST : function () {
            return (this.zone() < moment([this.year()]).zone() ||
                this.zone() < moment([this.year(), 5]).zone());
        },

        day : function (input) {
            var day = this._isUTC ? this._d.getUTCDay() : this._d.getDay();
            return input == null ? day :
                this.add({ d : input - day });
        },

        startOf: function (units) {
            units = units.replace(/s$/, '');
            // the following switch intentionally omits break keywords
            // to utilize falling through the cases.
            switch (units) {
            case 'year':
                this.month(0);
                /* falls through */
            case 'month':
                this.date(1);
                /* falls through */
            case 'week':
            case 'day':
                this.hours(0);
                /* falls through */
            case 'hour':
                this.minutes(0);
                /* falls through */
            case 'minute':
                this.seconds(0);
                /* falls through */
            case 'second':
                this.milliseconds(0);
                /* falls through */
            }

            // weeks are a special case
            if (units === 'week') {
                this.day(0);
            }

            return this;
        },

        endOf: function (units) {
            return this.startOf(units).add(units.replace(/s?$/, 's'), 1).subtract('ms', 1);
        },

        isAfter: function (input, units) {
            units = typeof units !== 'undefined' ? units : 'millisecond';
            return +this.clone().startOf(units) > +moment(input).startOf(units);
        },

        isBefore: function (input, units) {
            units = typeof units !== 'undefined' ? units : 'millisecond';
            return +this.clone().startOf(units) < +moment(input).startOf(units);
        },

        isSame: function (input, units) {
            units = typeof units !== 'undefined' ? units : 'millisecond';
            return +this.clone().startOf(units) === +moment(input).startOf(units);
        },

        zone : function () {
            return this._isUTC ? 0 : this._d.getTimezoneOffset();
        },

        daysInMonth : function () {
            return moment.utc([this.year(), this.month() + 1, 0]).date();
        },

        dayOfYear : function (input) {
            var dayOfYear = round((moment(this).startOf('day') - moment(this).startOf('year')) / 864e5) + 1;
            return input == null ? dayOfYear : this.add("d", (input - dayOfYear));
        },

        isoWeek : function (input) {
            var week = weekOfYear(this, 1, 4);
            return input == null ? week : this.add("d", (input - week) * 7);
        },

        week : function (input) {
            var week = this.lang().week(this);
            return input == null ? week : this.add("d", (input - week) * 7);
        },

        // If passed a language key, it will set the language for this
        // instance.  Otherwise, it will return the language configuration
        // variables for this instance.
        lang : function (key) {
            if (key === undefined) {
                return this._lang;
            } else {
                this._lang = getLangDefinition(key);
                return this;
            }
        }
    };

    // helper for adding shortcuts
    function makeGetterAndSetter(name, key) {
        moment.fn[name] = moment.fn[name + 's'] = function (input) {
            var utc = this._isUTC ? 'UTC' : '';
            if (input != null) {
                this._d['set' + utc + key](input);
                return this;
            } else {
                return this._d['get' + utc + key]();
            }
        };
    }

    // loop through and add shortcuts (Month, Date, Hours, Minutes, Seconds, Milliseconds)
    for (i = 0; i < proxyGettersAndSetters.length; i ++) {
        makeGetterAndSetter(proxyGettersAndSetters[i].toLowerCase().replace(/s$/, ''), proxyGettersAndSetters[i]);
    }

    // add shortcut for year (uses different syntax than the getter/setter 'year' == 'FullYear')
    makeGetterAndSetter('year', 'FullYear');

    // add plural methods
    moment.fn.days = moment.fn.day;
    moment.fn.weeks = moment.fn.week;
    moment.fn.isoWeeks = moment.fn.isoWeek;

    /************************************
        Duration Prototype
    ************************************/


    moment.duration.fn = Duration.prototype = {
        weeks : function () {
            return absRound(this.days() / 7);
        },

        valueOf : function () {
            return this._milliseconds +
              this._days * 864e5 +
              this._months * 2592e6;
        },

        humanize : function (withSuffix) {
            var difference = +this,
                output = relativeTime(difference, !withSuffix, this.lang());

            if (withSuffix) {
                output = this.lang().pastFuture(difference, output);
            }

            return this.lang().postformat(output);
        },

        lang : moment.fn.lang
    };

    function makeDurationGetter(name) {
        moment.duration.fn[name] = function () {
            return this._data[name];
        };
    }

    function makeDurationAsGetter(name, factor) {
        moment.duration.fn['as' + name] = function () {
            return +this / factor;
        };
    }

    for (i in unitMillisecondFactors) {
        if (unitMillisecondFactors.hasOwnProperty(i)) {
            makeDurationAsGetter(i, unitMillisecondFactors[i]);
            makeDurationGetter(i.toLowerCase());
        }
    }

    makeDurationAsGetter('Weeks', 6048e5);


    /************************************
        Default Lang
    ************************************/


    // Set default language, other languages will inherit from English.
    moment.lang('en', {
        ordinal : function (number) {
            var b = number % 10,
                output = (~~ (number % 100 / 10) === 1) ? 'th' :
                (b === 1) ? 'st' :
                (b === 2) ? 'nd' :
                (b === 3) ? 'rd' : 'th';
            return number + output;
        }
    });


    /************************************
        Exposing Moment
    ************************************/


    // CommonJS module is defined
    if (hasModule) {
        module.exports = moment;
    }
    /*global ender:false */
    if (typeof ender === 'undefined') {
        // here, `this` means `window` in the browser, or `global` on the server
        // add `moment` as a global object via a string identifier,
        // for Closure Compiler "advanced" mode
        this['moment'] = moment;
    }
    /*global define:false */
    if (typeof define === "function" && define.amd) {
        define("moment", [], function () {
            return moment;
        });
    }
}).call(this);
function GanttChart(elementId){
  this.elementId = elementId;
  this.height = 500;
  this.width = 500;
  this.gridSize = 25;
  this.labelAreaSize = 250;
  this.currentRow = 1; // Starts at 1 so there is an empty row for headers
  this.phaseColor = "#AAA";
  this.taskColors = ["#C24704","#D9CC3C","#FFEB79","#A0E0A9","#00ADA7"];
  this.cellpadding = 4;

  var colorCounter = 0;

  this.loadData = function(payload){
    this.project = payload;
  }

  this.draw = function(){
    // Get the list of dates for the project duration
    var dates = this.getDates();
    // Calculate total graph width
    width = this.labelAreaSize + dates.length * this.gridSize;
    var rows = this.getRows();
    height = rows*this.gridSize;

    // Generate the chart area
    this.paper = Raphael(this.elementId, width, height);

    this.grid();
    this.headers(dates);

    // Iterate through all the phases, print labels and child tasks
    var phases = this.project[0].phases;
    for(p in phases){
      var caption = this.paper.text(5,(this.currentRow*this.gridSize)+(this.gridSize/2),phases[p].name);
      caption.attr({"font-size":14 , "stroke":"none" , "fill":"black", "text-anchor":"start"});

      //TODO print phase bounds
      this.phaseLine(phases[p]);

      this.currentRow++;

      var tasks = phases[p].tasks;
      for(t in tasks){
        this.bar(tasks[t]);
        this.currentRow++;
      }

      // Cycle the selected color, tasks under a phase will have the same color
      if(colorCounter < this.taskColors.length){
        colorCounter++;
      }else{
        colorCounter = 0;
      }
    }

  }

  // Gets the total number of rows
  this.getRows = function(){
    var phases = this.project[0].phases;
    var rows = 1;
    for (p in phases){
      rows++;
      var tasks = phases[p].tasks;
      for(t in tasks){
        rows++;
      }
    }
    return rows;
  }

  // Draw the grid
  this.grid = function(){
    // Draw horizontal grid lines
    for(var y=this.gridSize; y < height; y+=this.gridSize){
      var pathExp = "M0," + y + "L" + width + "," + y;
      var gridLine = this.paper.path(pathExp);
      gridLine.attr({"stroke":"#000"});
    }

    //Draw vertical grid lines (starts at the edge of the space allotted for phase/task labels)
    for(var x=this.labelAreaSize; x < width; x+=this.gridSize){
      var pathExp = "M" + x + ",0L" + x + "," + height;
      var gridLine = this.paper.path(pathExp);
    }
  }

  // Draws column headers, currently using M-D formatting
  this.headers = function(dates){
    var currentCol = 0;
    for(d in dates){
      var heading = this.paper.text(this.labelAreaSize + currentCol*this.gridSize + .5*this.gridSize, .5*this.gridSize,dates[d].format("M-D"));
      heading.attr({"text-anchor":"middle"});
      currentCol++;
    }
  }

  // Draw phase bounding shape
  this.phaseLine = function(phase){
    var dates = this.getDates();
    var startDate = moment(phase.startDate);
    var endDate = moment(phase.endDate);
    endDate.add("days",1); // Add an extra day so that the bar actually encompasses the end date

    var offset = moment.duration(startDate - dates[0]);

    var x = offset.asDays()*this.gridSize+this.labelAreaSize+this.cellpadding;
    var y = this.currentRow*this.gridSize+.25*this.gridSize;
    var duration = moment.duration(endDate-startDate);
    var barWidth = (duration.asDays())*this.gridSize-(2*this.cellpadding);
    var barHeight = this.gridSize/4;

    var bar = this.paper.rect(x, y, barWidth, barHeight);
    bar.attr({"stroke":this.phaseColor});
    bar.attr({"fill":this.phaseColor});

    // Draw the starting bound triangle
    var p1 = x+","+y;
    var p2 = x+","+((y+.75*this.gridSize)-this.cellpadding);
    var p3 = (x+.5*this.gridSize)+","+y;
    var startTriangle = this.paper.path("M"+p1+"L"+p2+"L"+p3+"Z");
    startTriangle.attr({"stroke":this.phaseColor,"fill":this.phaseColor});

    // Draw the ending bound triangle
    var p1 = x+barWidth+","+y;
    var p2 = x+barWidth+","+((y+.75*this.gridSize)-this.cellpadding);
    var p3 = ((x+barWidth)-.5*this.gridSize)+","+y;
    var endTriangle = this.paper.path("M"+p1+"L"+p2+"L"+p3+"Z");
    endTriangle.attr({"stroke":this.phaseColor,"fill":this.phaseColor});

  }

  // Draws a task bar
  this.bar = function(task){
    var dates = this.getDates();
    var startDate = moment(task.startDate);
    var endDate = moment(task.endDate);
    endDate.add("days",1); // Add an extra day so that the bar actually encompasses the end date

    var offset = moment.duration(startDate - dates[0]);

    var x = offset.asDays()*this.gridSize+this.labelAreaSize;
    var y = this.currentRow*this.gridSize;
    var duration = moment.duration(endDate-startDate);
    var barWidth = (duration.asDays())*this.gridSize;
    var barHeight = this.gridSize;

    var bar = this.paper.rect(x+this.cellpadding, y+this.cellpadding, barWidth-(2*this.cellpadding), barHeight-(2*this.cellpadding));
    var caption = this.paper.text(10,y+(barHeight/2),task.name);
    caption.attr({"font-size":14 , "stroke":"none" , "fill":"black", "text-anchor":"start"});

    var colorString = this.taskColors[colorCounter];
    var fill = Raphael.color(colorString);
    bar.attr({"fill":fill});

    // Add glow effect on mouseover
    var glow;
    var glowRadius = this.cellpadding;
    bar.hover(function(){
      glow = bar.glow({"width":glowRadius,"opacity":0.75,"color":fill});
    }, function(){ // Remove glow on mouseout
      glow.remove();
    });

  }

  // Returns an array of dates for the duration of the project
  this.getDates = function(){
    //TODO Parse start/end dates from data
    var startDate = moment(this.project[0].startDate);
    var endDate = moment(this.project[0].endDate);

    var dates = [];

    while(startDate <= endDate){
      dates.push(startDate.clone());
      startDate.add("days",1);
    }

    return dates;
  }

}    var global =  window

if (global.module == undefined) {
  global.module = function(name, body) {
    var exports = global[name]
    if (exports == undefined) {
    global[name] = exports = {}
    }
    body(exports)
  }
}


    module('Charts', function(exports) {
      var LineChartOptions;

LineChartOptions = (function() {

  LineChartOptions.DEFAULTS = {
    dot_size: 5,
    dot_color: "#00aadd",
    dot_stroke_color: "#fff",
    dot_stroke_size: 2,
    line_width: 3,
    line_color: "#00aadd",
    smoothing: 0.4,
    fill_area: true,
    area_color: "#00aadd",
    area_opacity: 0.2,
    show_x_labels: true,
    show_y_labels: true,
    label_max: true,
    label_min: true,
    max_x_labels: 10,
    max_y_labels: 3,
    font_family: "Helvetica, Arial, sans-serif",
    x_label_size: 14,
    y_label_size: 14,
    label_format: "%m/%d",
    show_grid: false,
    x_padding: 45,
    y_padding: 40,
    multi_axis: false,
    scale: "linear",
    y_axis_scale: [],
    render: "line",
    bar_width: 20
  };

  LineChartOptions.merge = function(from, to) {
    var option, opts, value;
    if (from == null) {
      from = {};
    }
    if (to == null) {
      to = {};
    }
    opts = {};
    for (option in from) {
      value = from[option];
      opts[option] = value;
    }
    for (option in to) {
      value = to[option];
      if (to.hasOwnProperty(option)) {
        opts[option] = value;
      }
    }
    return opts;
  };

  function LineChartOptions(options) {
    var option, opts, value, _ref;
    opts = {};
    _ref = LineChartOptions.DEFAULTS;
    for (option in _ref) {
      value = _ref[option];
      opts[option] = value;
    }
    for (option in options) {
      value = options[option];
      if (options.hasOwnProperty(option)) {
        opts[option] = value;
      }
    }
    return opts;
  }

  return LineChartOptions;

})();
var Util;

Util = (function() {

  function Util() {}

  Util.clone = function(obj) {
    var copy, key;
    if (!((obj != null) && typeof obj === 'object')) {
      return obj;
    }
    copy = new obj.constructor();
    for (key in obj) {
      copy[key] = Util.clone(obj[key]);
    }
    return copy;
  };

  Util.comma = function(value) {
    var formatted, i, j, str;
    str = value.toString();
    formatted = "";
    i = 0;
    j = str.length - 1;
    while (j >= 0) {
      formatted += str.charAt(i);
      if (j % 3 === 0 && j !== 0) {
        formatted += ",";
      }
      i++;
      j--;
    }
    return formatted;
  };

  Util.commas = function(value) {
    var parts;
    parts = value.toString().split(".");
    if (parts.length === 1) {
      return this.comma(parts[0]);
    } else {
      return this.comma(parts[0]) + "." + parts[1];
    }
  };

  return Util;

})();
var Label, LabelSet, dateint_to_abbreviation, format_number, format_number_commas;

dateint_to_abbreviation = function(dateint) {
  switch (dateint) {
    case 1:
      return "Jan";
    case 2:
      return "Feb";
    case 3:
      return "Mar";
    case 4:
      return "Apr";
    case 5:
      return "May";
    case 6:
      return "Jun";
    case 7:
      return "Jul";
    case 8:
      return "Aug";
    case 9:
      return "Sep";
    case 10:
      return "Oct";
    case 11:
      return "Nov";
    case 12:
      return "Dec";
  }
};

format_number_commas = function(number, percision) {
  var rounding, value;
  if (percision == null) {
    percision = 2;
  }
  rounding = percision > 0 ? Math.pow(10, percision) : 1;
  value = Math.round(number * rounding) / rounding;
  return Util.commas(value);
};

format_number = function(number, percision) {
  var millions, rounding, thousands;
  if (percision == null) {
    percision = 2;
  }
  rounding = percision > 0 ? Math.pow(10, percision) : 1;
  if (number > 1000000) {
    millions = number / 1000000;
    millions = Math.round(millions * rounding) / rounding;
    return millions + "m";
  } else if (number > 1000) {
    thousands = number / 1000;
    return Math.round(thousands * rounding) / rounding + "k";
  } else {
    return Math.round(number * rounding) / rounding;
  }
};

LabelSet = (function() {

  function LabelSet(r, format) {
    this.r = r;
    this.format = format != null ? format : "";
    this.num = 0;
    this.font_family = "Helvetica, Arial, sans-serif";
    this.color = "#333";
  }

  LabelSet.prototype.x = function(x_func) {
    this.x_func = x_func;
    return this;
  };

  LabelSet.prototype.y = function(y_func) {
    this.y_func = y_func;
    return this;
  };

  LabelSet.prototype.size = function(size) {
    this.size = size;
    return this;
  };

  LabelSet.prototype.attr = function(options) {
    this.options = options;
    return this;
  };

  LabelSet.prototype.draw = function(text) {
    var label;
    label = new Label(this.r, this.x_func(this.num), this.y_func(this.num), text, this.format, this.size, this.font_family, this.color, this.options);
    this.num += 1;
    return label.draw();
  };

  return LabelSet;

})();

Label = (function() {

  function Label(r, x, y, text, format, size, font_family, color, options) {
    this.r = r;
    this.x = x;
    this.y = y;
    this.text = text;
    this.format = format != null ? format : "";
    this.size = size != null ? size : 14;
    this.font_family = font_family != null ? font_family : "Helvetica, Arial, sans-serif";
    this.color = color != null ? color : "#333";
    this.options = options != null ? options : void 0;
  }

  Label.prototype.is_date = function(potential_date) {
    return Object.prototype.toString.call(potential_date) === '[object Date]';
  };

  Label.prototype.parse_date = function(date) {
    var formatted, groups, item, _i, _len;
    groups = this.format.match(/%([a-zA-Z])/g);
    formatted = this.format;
    for (_i = 0, _len = groups.length; _i < _len; _i++) {
      item = groups[_i];
      formatted = formatted.replace(item, this.parse_format(item));
    }
    return formatted;
  };

  Label.prototype.meridian_indicator = function(date) {
    var hour;
    hour = date.getHours();
    if (hour >= 12) {
      return "pm";
    } else {
      return "am";
    }
  };

  Label.prototype.to_12_hour_clock = function(date) {
    var fmt_hour, hour;
    hour = date.getHours();
    fmt_hour = hour % 12;
    if (fmt_hour === 0) {
      return 12;
    } else {
      return fmt_hour;
    }
  };

  Label.prototype.fmt_minutes = function(date) {
    var minutes;
    minutes = date.getMinutes();
    if (minutes < 10) {
      return "0" + minutes;
    } else {
      return minutes;
    }
  };

  Label.prototype.parse_format = function(format) {
    switch (format) {
      case "%m":
        return this.text.getMonth() + 1;
      case "%b":
        return dateint_to_abbreviation(this.text.getMonth() + 1);
      case "%d":
        return this.text.getDate();
      case "%Y":
        return this.text.getFullYear();
      case "%H":
        return this.text.getHours();
      case "%M":
        return this.fmt_minutes(this.text);
      case "%I":
        return this.to_12_hour_clock(this.text);
      case "%p":
        return this.meridian_indicator(this.text);
    }
  };

  Label.prototype.draw = function() {
    var margin, text, width, x;
    text = "";
    if (this.is_date(this.text)) {
      text = this.parse_date(this.text);
    } else if (typeof this.text === "number") {
      text = format_number_commas(this.text);
    } else {
      text = this.text;
    }
    this.element = this.r.text(this.x, this.y, text);
    width = this.element.getBBox().width;
    margin = 5;
    this.element.attr({
      "fill": this.color,
      "font-size": this.size,
      "font-weight": "normal",
      "text-anchor": "middle",
      "font-family": this.font_family
    });
    if (this.options != null) {
      this.element.attr(this.options);
    } else {
      x = this.x < width ? (width / 2) + margin : this.x;
      this.element.attr({
        "x": x
      });
    }
    return this.element;
  };

  return Label;

})();
var Grid;

Grid = (function() {

  function Grid(r, width, height, points, options) {
    this.r = r;
    this.width = width;
    this.height = height;
    this.points = points;
    this.options = options;
  }

  Grid.prototype.draw = function() {
    var grid_lines, height, i, paths, point, width, x, x_step_size, y, y_step_size, _i, _j, _len, _ref;
    grid_lines = Math.round(this.points.length / this.options.step_size);
    height = this.height - this.options.y_padding;
    width = this.width - this.options.x_padding;
    x_step_size = Math.round(width / grid_lines);
    y_step_size = Math.round(height / grid_lines);
    y = this.options.y_padding;
    paths = this.r.set();
    _ref = this.points;
    for (i = _i = 0, _len = _ref.length; _i < _len; i = ++_i) {
      point = _ref[i];
      if (!(i % this.options.step_size === 0)) {
        continue;
      }
      x = this.points[i].x;
      paths.push(this.r.path("M " + x + ", " + this.options.y_padding + " L " + x + ", " + height + " Z"));
    }
    for (i = _j = 0; 0 <= grid_lines ? _j <= grid_lines : _j >= grid_lines; i = 0 <= grid_lines ? ++_j : --_j) {
      if (y <= height) {
        paths.push(this.r.path("M " + this.options.x_padding + ", " + y + " L " + width + ", " + y + " Z"));
      }
      y += y_step_size;
    }
    return paths.attr({
      stroke: "#ccc",
      "stroke-width": 1
    }).toBack();
  };

  return Grid;

})();
var Dot;

Dot = (function() {

  function Dot(r, point, opts, scale_factor) {
    this.r = r;
    this.point = point;
    this.opts = opts;
    this.scale_factor = scale_factor != null ? scale_factor : 1.5;
    this.element = this.r.circle(point.x, point.y, this.opts.dot_size);
    this.style_dot();
    if (this.opts.hover_enabled) {
      this.attach_handlers();
    }
  }

  Dot.prototype.style_dot = function() {
    this.element.attr({
      "fill": this.opts.dot_color,
      "stroke": this.opts.dot_stroke_color,
      "stroke-width": this.opts.dot_stroke_size
    });
    return this.element.toFront();
  };

  Dot.prototype.activate = function() {
    this.element.attr({
      "fill": "#333"
    });
    return this.element.animate({
      "r": this.opts.dot_size * this.scale_factor
    }, 200);
  };

  Dot.prototype.deactivate = function() {
    var shrink_factor;
    shrink_factor = 1 / this.scale_factor;
    this.element.attr({
      "fill": this.opts.dot_color
    });
    return this.element.animate({
      "r": this.opts.dot_size
    }, 200);
  };

  Dot.prototype.attach_handlers = function() {
    var _this = this;
    this.element.mouseover(function() {
      return _this.activate();
    });
    return this.element.mouseout(function() {
      return _this.deactivate();
    });
  };

  Dot.prototype.hide = function() {
    return this.element.hide();
  };

  return Dot;

})();
var BulletChartOptions;

BulletChartOptions = (function() {

  BulletChartOptions.DEFAULTS = {
    line_width: 4,
    line_color: "#000",
    area_color: "#00aadd",
    area_width: 20,
    area_opacity: 0.2,
    bar_margin: 8,
    show_average: true,
    average_width: 4,
    average_height: 8,
    average_color: "#000",
    font_family: "Helvetica, Arial, sans-serif",
    x_label_size: 14,
    y_label_size: 14,
    x_padding: 45,
    y_padding: 40
  };

  BulletChartOptions.merge = function(from, to) {
    var option, opts, value;
    if (from == null) {
      from = {};
    }
    if (to == null) {
      to = {};
    }
    opts = {};
    for (option in from) {
      value = from[option];
      opts[option] = value;
    }
    for (option in to) {
      value = to[option];
      if (to.hasOwnProperty(option)) {
        opts[option] = value;
      }
    }
    return opts;
  };

  function BulletChartOptions(options) {
    var option, opts, value, _ref;
    opts = {};
    _ref = BulletChartOptions.DEFAULTS;
    for (option in _ref) {
      value = _ref[option];
      opts[option] = value;
    }
    for (option in options) {
      value = options[option];
      if (options.hasOwnProperty(option)) {
        opts[option] = value;
      }
    }
    return opts;
  }

  return BulletChartOptions;

})();
var BaseChartOptions;

BaseChartOptions = (function() {

  BaseChartOptions.merge = function(from, to) {
    var option, opts, value;
    if (from == null) {
      from = {};
    }
    if (to == null) {
      to = {};
    }
    opts = {};
    for (option in from) {
      value = from[option];
      opts[option] = value;
    }
    for (option in to) {
      value = to[option];
      if (to.hasOwnProperty(option)) {
        opts[option] = value;
      }
    }
    return opts;
  };

  function BaseChartOptions(options, defaults) {
    var option, opts, value;
    opts = {};
    for (option in defaults) {
      value = defaults[option];
      opts[option] = value;
    }
    for (option in options) {
      value = options[option];
      if (options.hasOwnProperty(option)) {
        opts[option] = value;
      }
    }
    return opts;
  }

  return BaseChartOptions;

})();
var IndexChartOptions,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

IndexChartOptions = (function(_super) {

  __extends(IndexChartOptions, _super);

  IndexChartOptions.DEFAULTS = {
    bar_margin: 30,
    bar_bg_color: "#bdced3",
    bar1_color: "90-#2f5e78-#4284a8",
    bar2_color: "90-#173e53-#225d7c",
    raw_value_bar_color: "#9eb7bf",
    x_padding: 160,
    x_padding_right: 100,
    y_padding: 50,
    bg_bar_padding: 14,
    rounding: 3,
    dash_width: 3,
    label_size: 14,
    font_family: "Helvetica, Arial, sans-serif"
  };

  function IndexChartOptions(options) {
    return IndexChartOptions.__super__.constructor.call(this, options, IndexChartOptions.DEFAULTS);
  }

  return IndexChartOptions;

})(BaseChartOptions);
var BarChartOptions;

BarChartOptions = (function() {

  BarChartOptions.DEFAULTS = {
    bar_width: 20,
    bar_spacing: 20,
    bar_color: "#00aadd",
    rounding: 0,
    font_family: "Helvetica, Arial, sans-serif",
    show_x_labels: true,
    show_y_labels: true,
    x_label_size: 14,
    x_label_color: "#333",
    y_label_size: 14,
    y_label_color: "#333",
    show_grid: false,
    x_padding: 25,
    y_padding: 40
  };

  BarChartOptions.merge = function(from, to) {
    var option, opts, value;
    if (from == null) {
      from = {};
    }
    if (to == null) {
      to = {};
    }
    opts = {};
    for (option in from) {
      value = from[option];
      opts[option] = value;
    }
    for (option in to) {
      value = to[option];
      if (to.hasOwnProperty(option)) {
        opts[option] = value;
      }
    }
    return opts;
  };

  function BarChartOptions(options) {
    var option, opts, value, _ref;
    opts = {};
    _ref = BarChartOptions.DEFAULTS;
    for (option in _ref) {
      value = _ref[option];
      opts[option] = value;
    }
    for (option in options) {
      value = options[option];
      if (options.hasOwnProperty(option)) {
        opts[option] = value;
      }
    }
    return opts;
  }

  return BarChartOptions;

})();
var LogScaler, Scaler, Scaling,
  __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };

Scaler = (function() {

  function Scaler() {
    this.scale = __bind(this.scale, this);

  }

  Scaler.prototype.domain = function(points) {
    this.domain_min = Math.min.apply(Math.min, points);
    this.domain_max = Math.max.apply(Math.max, points);
    return this;
  };

  Scaler.prototype.range = function(points) {
    this.range_min = Math.min.apply(Math.min, points);
    this.range_max = Math.max.apply(Math.max, points);
    return this.scale;
  };

  Scaler.prototype.scale = function(value) {
    var domain_span, range_span, term1, term2;
    domain_span = this.domain_max - this.domain_min;
    range_span = this.range_max - this.range_min;
    term1 = (this.domain_max * this.range_min - this.domain_min * this.range_max) / domain_span;
    term2 = term1 + value * (range_span / domain_span);
    if (domain_span === 0) {
      return this.range_min;
    } else {
      return term2;
    }
  };

  return Scaler;

})();

LogScaler = (function() {

  function LogScaler(base) {
    this.base = base != null ? base : 10;
    this.scale = __bind(this.scale, this);

    return this.scale;
  }

  LogScaler.prototype.scale = function(value) {
    var log;
    log = Math.log;
    return log(value) / log(this.base);
  };

  return LogScaler;

})();

Scaling = (function() {

  function Scaling() {}

  Scaling.get_ranges_for_points = function(points) {
    var max_x, max_y, min_x, min_y, point, xs, ys, _i, _len;
    xs = [];
    ys = [];
    for (_i = 0, _len = points.length; _i < _len; _i++) {
      point = points[_i];
      xs.push(point.x);
      ys.push(point.y);
    }
    max_x = Math.max.apply(Math.max, xs);
    max_y = Math.max.apply(Math.max, ys);
    min_x = Math.min.apply(Math.min, xs);
    min_y = Math.min.apply(Math.min, ys);
    return [max_x, min_x, max_y, min_y];
  };

  Scaling.threshold = function(value, threshold) {
    if (value > threshold) {
      return threshold;
    } else {
      return value;
    }
  };

  return Scaling;

})();

exports.Scaling = Scaling;

exports.Scaler = Scaler;
var Point;

Point = (function() {

  function Point(x, y, options) {
    this.y = y;
    this.options = options != null ? options : {};
    if (this.is_date(x)) {
      this.x = x.getTime();
      this.is_date_type = true;
    } else {
      this.x = x;
    }
    return;
  }

  Point.prototype.is_date = function(potential_date) {
    return Object.prototype.toString.call(potential_date) === '[object Date]';
  };

  return Point;

})();

exports.Point = Point;
var Effects;

Raphael.fn.triangle = function(cx, cy, r) {
  r *= 1.75;
  return this.path("M".concat(cx, ",", cy, "m0-", r * .58, "l", r * .5, ",", r * .87, "-", r, ",0z"));
};

Effects = (function() {

  function Effects(r) {
    this.r = r;
  }

  Effects.prototype.black_nub = function(target, h_padding, v_padding, offset, rounding) {
    var box, box_height, box_midpoint, box_width, height, popup, width, x, y;
    if (h_padding == null) {
      h_padding = 10;
    }
    if (v_padding == null) {
      v_padding = 8;
    }
    if (offset == null) {
      offset = 0;
    }
    if (rounding == null) {
      rounding = 0;
    }
    box = target.getBBox();
    x = box.x;
    y = box.y;
    box_width = box.width;
    box_height = box.height;
    box_midpoint = x + box_width / 2;
    width = box_width + (2 * h_padding);
    height = box_height + (2 * v_padding);
    popup = this.r.set();
    popup.push(this.r.rect(box_midpoint - width / 2, y - v_padding, width, height, rounding));
    popup.push(this.r.triangle(x + box_width + h_padding + 2, y + 2 + (0.5 * box_height), 4).rotate(90));
    return popup.attr({
      "fill": "#333",
      "stroke": "none"
    }).toBack();
  };

  Effects.prototype.straight_line = function(start_point, end_point) {
    return this.r.path("M" + start_point.x + "," + start_point.y + "L" + end_point.x + "," + end_point.y);
  };

  Effects.prototype.vertical_dashed_line = function(start_point, end_point, dash_width, spacing) {
    var dashes, height, i, rect, ticks, _i, _ref;
    if (dash_width == null) {
      dash_width = 3;
    }
    if (spacing == null) {
      spacing = 10;
    }
    height = end_point.y - start_point.y;
    ticks = Math.floor(height / spacing);
    dashes = this.r.set();
    for (i = _i = 0, _ref = ticks - 1; 0 <= _ref ? _i <= _ref : _i >= _ref; i = 0 <= _ref ? ++_i : --_i) {
      if (i % 2 !== 0) {
        continue;
      }
      rect = this.r.rect(start_point.x - (0.5 * dash_width), i * spacing + start_point.y, dash_width, spacing);
      dashes.push(rect);
    }
    return dashes;
  };

  Effects.prototype.get_points_along_top_of_bbox = function(rect, y_offset) {
    var bounding_box, x1, x2, y1, y2;
    if (y_offset == null) {
      y_offset = 0;
    }
    bounding_box = rect.getBBox();
    x1 = bounding_box.x;
    x2 = bounding_box.x + bounding_box.width;
    y1 = bounding_box.y + y_offset;
    y2 = y1;
    return [new Point(x1, y1), new Point(x2, y2)];
  };

  Effects.prototype.one_px_highlight = function(rect) {
    var end, start, _ref;
    _ref = this.get_points_along_top_of_bbox(rect, 2), start = _ref[0], end = _ref[1];
    this.straight_line(start, end).attr({
      "stroke-width": 1,
      "stroke": "rgba(255,255,255,0.3)"
    });
    return this.straight_line;
  };

  Effects.prototype.one_px_shadow = function(rect) {
    var end, start, _ref;
    _ref = this.get_points_along_top_of_bbox(rect), start = _ref[0], end = _ref[1];
    this.straight_line(start, end).attr({
      "stroke-width": 0.5,
      "stroke": "rgba(0,0,0,0.5)"
    });
    return this.straight_line;
  };

  return Effects;

})();

exports.Effects = Effects;
var Tooltip;

Tooltip = (function() {

  function Tooltip(r, target, text, hover_enabled) {
    var box, box_height, box_midpoint, box_width, height, offset, padding, rounding, size, width, x, y,
      _this = this;
    this.r = r;
    if (hover_enabled == null) {
      hover_enabled = true;
    }
    size = 30;
    height = 25;
    offset = 10;
    rounding = 5;
    if (typeof text === "number") {
      text = Util.commas(Math.round(text * 100) / 100);
    }
    box = target.getBBox();
    x = box.x;
    y = box.y;
    box_width = box.width;
    box_height = box.height;
    box_midpoint = x + box_width / 2;
    this.text = this.r.text(box_midpoint, y - (height / 2 + offset), text);
    this.text.attr({
      "fill": "#fff",
      "font-size": 14,
      "text-anchor": "middle",
      "opacity": 0,
      "font-weight": "bold"
    });
    padding = 10;
    width = this.text.getBBox().width + padding * 2;
    this.popup = this.r.set();
    this.popup.push(this.r.rect(box_midpoint - width / 2, y - (height + offset), width, height, rounding));
    this.triangle = this.r.triangle(box_midpoint, y - offset + 4, 4).rotate(180);
    this.popup.push(this.triangle);
    this.popup.attr({
      "fill": "rgba(0,0,0,.4)",
      "opacity": 0,
      "stroke": "none"
    });
    this.popup.toFront();
    this.text.toFront();
    if (hover_enabled === true) {
      target.mouseover(function() {
        return _this.show();
      });
      target.mouseout(function() {
        return _this.hide();
      });
    }
  }

  Tooltip.prototype.animate_opacity = function(element, value, time) {
    var _this = this;
    if (time == null) {
      time = 200;
    }
    return element.animate({
      "opacity": value,
      "fill-opacity": value
    }, time, function() {
      if (value === 0) {
        _this.text.toBack();
        return _this.popup.toBack();
      }
    });
  };

  Tooltip.prototype.hide = function() {
    this.animate_opacity(this.popup, 0);
    return this.animate_opacity(this.text, 0);
  };

  Tooltip.prototype.show = function() {
    this.popup.toFront();
    this.text.toFront();
    this.animate_opacity(this.popup, 0.9);
    return this.animate_opacity(this.text, 1);
  };

  Tooltip.prototype.translate = function(x, y) {
    this.popup.translate(x, y);
    this.text.translate(x, y);
    return this.triangle.translate(-2 * x, y);
  };

  return Tooltip;

})();

exports.Tooltip = Tooltip;
var LineBar;

LineBar = (function() {

  function LineBar(r, raw_points, scaled_points, height, width, options) {
    this.r = r;
    this.raw_points = raw_points;
    this.scaled_points = scaled_points;
    this.height = height;
    this.width = width;
    this.options = options != null ? options : {};
    this.effective_height = this.height - this.options.y_padding;
    this.x_offset = this.options.bar_width / 2;
  }

  LineBar.prototype.draw = function() {
    return this.draw_bars();
  };

  LineBar.prototype.draw_bars = function() {
    var i, max_point, min_point, point, rect, set, tooltips, x, _i, _len, _ref;
    set = this.r.set();
    tooltips = [];
    max_point = 0;
    min_point = 0;
    _ref = this.scaled_points;
    for (i = _i = 0, _len = _ref.length; _i < _len; i = ++_i) {
      point = _ref[i];
      x = point.x - this.x_offset;
      rect = this.r.rect(x, point.y, this.options.bar_width, this.effective_height - point.y);
      set.push(rect);
      tooltips.push(new Tooltip(this.r, rect, this.raw_points[i].y));
      if (this.raw_points[i].y >= this.raw_points[max_point].y) {
        max_point = i;
      }
      if (this.raw_points[i].y < this.raw_points[min_point].y) {
        min_point = i;
      }
    }
    set.attr({
      "fill": this.options.line_color,
      "stroke": "none"
    });
    if (this.options.label_max) {
      tooltips[max_point].show();
    }
    if (this.options.label_min) {
      return tooltips[min_point].show();
    }
  };

  return LineBar;

})();
var Bezier;

Bezier = (function() {

  function Bezier() {}

  Bezier.create_path = function(points, smoothing) {
    var b1, b2, i, path, point, _i, _len, _ref;
    if (smoothing == null) {
      smoothing = 0.5;
    }
    path = "M" + points[0].x + ", " + points[0].y;
    for (i = _i = 0, _len = points.length; _i < _len; i = ++_i) {
      point = points[i];
      if (i === 0) {
        continue;
      }
      _ref = Bezier.get_control_points(points, i - 1, smoothing), b1 = _ref[0], b2 = _ref[1];
      path += "C" + b1.x + "," + b1.y + " " + b2.x + "," + b2.y + " " + points[i].x + "," + points[i].y;
    }
    return path;
  };

  Bezier.get_control_points = function(points, i, smoothing, divisor) {
    var b1, b1_x, b1_y, b2, b2_x, b2_y, p0, p1, p2, p3, tan1_x, tan1_y, tan2_x, tan2_y, _ref, _ref1, _ref2, _ref3;
    if (divisor == null) {
      divisor = 3;
    }
    _ref = this.get_prev_and_next_points(points, i), p0 = _ref[0], p2 = _ref[1];
    _ref1 = this.get_prev_and_next_points(points, i + 1), p1 = _ref1[0], p3 = _ref1[1];
    _ref2 = this.get_tangent(p0, p2), tan1_x = _ref2[0], tan1_y = _ref2[1];
    _ref3 = this.get_tangent(p1, p3), tan2_x = _ref3[0], tan2_y = _ref3[1];
    b1_x = p1.x + (tan1_x * smoothing) / divisor;
    b1_y = p1.y + (tan1_y * smoothing) / divisor;
    b2_x = p2.x - (tan2_x * smoothing) / divisor;
    b2_y = p2.y - (tan2_y * smoothing) / divisor;
    b1 = new Point(b1_x, b1_y);
    b2 = new Point(b2_x, b2_y);
    return [b1, b2];
  };

  Bezier.get_prev_and_next_points = function(points, i) {
    var next, prev;
    prev = i - 1;
    next = i + 1;
    if (prev < 0) {
      prev = 0;
    }
    if (next >= points.length) {
      next = points.length - 1;
    }
    return [points[prev], points[next]];
  };

  Bezier.get_tangent = function(p0, p1) {
    var tan_x, tan_y;
    tan_x = p1.x - p0.x;
    tan_y = p1.y - p0.y;
    return [tan_x, tan_y];
  };

  return Bezier;

})();

exports.Bezier = Bezier;
var Line;

Line = (function() {

  function Line(r, raw_points, scaled_points, height, width, options) {
    this.r = r;
    this.raw_points = raw_points;
    this.scaled_points = scaled_points;
    this.height = height;
    this.width = width;
    this.options = options != null ? options : {};
  }

  Line.prototype.draw = function() {
    var path;
    path = Bezier.create_path(this.scaled_points, this.options.smoothing);
    if (this.options.fill_area) {
      this.draw_area(path);
    }
    this.draw_curve(path);
    if (this.options.dot_size > 0) {
      this.draw_dots_and_tooltips(this.scaled_points, this.raw_points);
    }
  };

  Line.prototype.draw_curve = function(path) {
    var curve;
    curve = this.r.path(path);
    return curve.attr({
      "stroke": this.options.line_color,
      "stroke-width": this.options.line_width
    }).toFront();
  };

  Line.prototype.draw_area = function(path) {
    var area, final_point, first_point, padded_height, points;
    points = this.scaled_points;
    padded_height = this.height - this.options.y_padding;
    final_point = points[points.length - 1];
    first_point = points[0];
    path += "L " + final_point.x + ", " + padded_height + " ";
    path += "L " + first_point.x + ", " + padded_height + " ";
    path += "Z";
    area = this.r.path(path);
    area.attr({
      "fill": this.options.area_color,
      "fill-opacity": this.options.area_opacity,
      "stroke": "none"
    });
    return area.toBack();
  };

  Line.prototype.draw_dots_and_tooltips = function() {
    var dot, dots, i, max_point, min_point, options, point, raw_point, raw_points, scaled_points, tooltip, tooltips, _i, _len;
    scaled_points = this.scaled_points;
    raw_points = this.raw_points;
    tooltips = [];
    dots = [];
    max_point = 0;
    min_point = 0;
    for (i = _i = 0, _len = scaled_points.length; _i < _len; i = ++_i) {
      point = scaled_points[i];
      raw_point = raw_points[i];
      if (raw_point.y >= raw_points[max_point].y) {
        max_point = i;
      }
      if (raw_point.y < raw_points[min_point].y) {
        min_point = i;
      }
      options = Util.clone(this.options);
      options.hover_enabled = !raw_point.options.show_dot;
      dot = new Dot(this.r, point, options);
      tooltip = new Tooltip(this.r, dot.element, raw_point.options.tooltip || raw_point.y, options.hover_enabled);
      dots.push(dot);
      tooltips.push(tooltip);
      if (raw_point.options.no_dot === true) {
        dot.hide();
      }
      if (raw_point.options.show_dot === true) {
        dot.activate();
        tooltip.show();
      }
    }
    if (this.options.label_max) {
      tooltips[max_point].show();
      dots[max_point].activate();
    }
    if (this.options.label_min) {
      tooltips[min_point].show();
      return dots[min_point].activate();
    }
  };

  return Line;

})();
var BaseChart, is_element;

is_element = function(o) {
  if (o.tagName !== void 0) {
    return true;
  } else {
    return false;
  }
};

BaseChart = (function() {

  function BaseChart(dom_container, options) {
    var container, _ref;
    container = is_element(dom_container) ? dom_container : document.getElementById(dom_container);
    _ref = this.get_dimensions(container), this.width = _ref[0], this.height = _ref[1];
    this.r = Raphael(container, this.width, this.height);
    this.options = options;
  }

  BaseChart.prototype.get_dimensions = function(container) {
    var height, width;
    width = parseInt(container.style.width);
    height = parseInt(container.style.height);
    return [width, height];
  };

  BaseChart.prototype.clear = function() {
    return this.r.clear();
  };

  return BaseChart;

})();
var PathMenu, PathMenuOptions, bounce_to_and_back, draw_circle, point_on_circle,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

PathMenuOptions = (function(_super) {

  __extends(PathMenuOptions, _super);

  PathMenuOptions.DEFAULTS = {
    main_circle_radius: 70,
    child_radius_multiplier: 0.15,
    hover_scale_multiplier: 1.2,
    inactive_opacity: 0.4,
    outer_radius_multiplier: 1.35,
    outer_radius2_multiplier: 1.5,
    bounce_radius: 1.2,
    fill_color: "#00a6dd"
  };

  function PathMenuOptions(options) {
    return PathMenuOptions.__super__.constructor.call(this, options, PathMenuOptions.DEFAULTS);
  }

  return PathMenuOptions;

})(BaseChartOptions);

point_on_circle = function(center_point, r, theta) {
  var x, y;
  x = r * Math.cos(theta) + center_point.x;
  y = r * Math.sin(theta) + center_point.y;
  return new Point(x, y);
};

bounce_to_and_back = function(shape, bounce_point, final_point, bounce_time, return_time) {
  var translate;
  translate = function(shape, point, time, callback) {
    if (callback == null) {
      callback = void 0;
    }
    return shape.animate({
      "x": point.x,
      "y": point.y,
      "cx": point.x,
      "cy": point.y
    }, time, "<", callback);
  };
  return translate(shape, bounce_point, bounce_time, function() {
    return translate(shape, final_point, return_time);
  });
};

draw_circle = function(x, y, r, text_size) {
  var attrs, set;
  attrs = {
    fill: this.options.fill_color,
    stroke: "none"
  };
  set = this.r.set();
  set.push(this.r.circle(x, y, r).attr(attrs));
  set.push(this.r.text(x, y, "+").attr({
    "font-size": text_size,
    "fill": "#fff"
  }));
  return set.attr({
    cursor: "pointer"
  }).toFront();
};

PathMenu = (function(_super) {

  __extends(PathMenu, _super);

  function PathMenu(dom_id, options) {
    if (options == null) {
      options = {};
    }
    PathMenu.__super__.constructor.call(this, dom_id, new PathMenuOptions(options));
    this.center_point = new Point(this.width / 2, this.height / 2);
    this.main_radius = this.options.main_circle_radius;
    this.child_radius = this.main_radius * this.options.child_radius_multiplier;
    this.outer_radius = this.main_radius * this.options.outer_radius_multiplier;
    this.outer_radius2 = this.outer_radius * this.options.outer_radius2_multiplier;
    this.bounce_radius = this.outer_radius * this.options.bounce_radius;
    this.children = [];
  }

  PathMenu.prototype.add_hover = function(circle) {
    var hover_in, hover_out,
      _this = this;
    hover_in = function(e) {
      circle[0].animate({
        "r": _this.options.hover_scale_multiplier * _this.child_radius,
        "opacity": 1,
        "stroke-width": 2,
        "stroke": "rgba(0,0,0,.4)"
      }, 200);
      circle[1].animate({
        "font-size": 22,
        "opacity": 1,
        "fill": "#fff"
      }, 200);
      return circle._label.animate({
        "opacity": 1
      }, 200);
    };
    hover_out = function(e) {
      circle[0].animate({
        r: _this.child_radius,
        opacity: _this.options.inactive_opacity,
        stroke: "none",
        "stroke-width": 0
      }, 200);
      circle[1].animate({
        opacity: 0
      }, 200);
      return circle._label.animate({
        "opacity": 0
      }, 200);
    };
    circle._activate = hover_in;
    circle._deactivate = hover_out;
    return circle.hover(hover_in, hover_out);
  };

  PathMenu.prototype.add = function(data) {
    return this.children.push(data);
  };

  PathMenu.prototype.create_circles_along_radius = function(items, circle_radius, outer_radius, callback) {
    var circle, i, item, radians, step_size, x, y, _i, _len, _ref, _results;
    step_size = (2 * Math.PI) / 24;
    _results = [];
    for (i = _i = 0, _len = items.length; _i < _len; i = ++_i) {
      item = items[i];
      radians = i * step_size;
      _ref = point_on_circle(this.center_point, outer_radius, radians), x = _ref.x, y = _ref.y;
      circle = this.draw_circle(this.center_point.x, this.center_point.y, circle_radius, 16);
      circle._realx = x;
      circle._realy = y;
      circle._radians = radians;
      circle.attr({
        opacity: this.options.inactive_opacity
      }).toFront();
      circle[1].attr({
        opacity: 0
      });
      this.add_label_to_circle(item, circle);
      this.add_hover(circle);
      _results.push(callback(item, circle));
    }
    return _results;
  };

  PathMenu.prototype.bounce_circles = function(parent_circle, circles) {
    var base, bounce_time, bounce_to, circle, i, index, interval, radians, return_time, return_to, x, y, _i, _len, _ref, _results;
    if (!circles) {
      return;
    }
    base = 100;
    interval = 10;
    return_time = 100;
    _results = [];
    for (i = _i = 0, _len = circles.length; _i < _len; i = ++_i) {
      circle = circles[i];
      radians = circle._radians;
      _ref = point_on_circle(this.center_point, this.bounce_radius, radians), x = _ref.x, y = _ref.y;
      bounce_to = new Point(x, y);
      index = void 0;
      return_to = void 0;
      if (parent_circle._active) {
        index = circles.length - i;
        return_to = this.center_point;
        circle.toBack();
      } else {
        index = i;
        return_to = new Point(circle._realx, circle._realy);
        circle.toFront();
      }
      bounce_time = base + index * interval;
      _results.push(bounce_to_and_back(circle, bounce_to, return_to, bounce_time, return_time));
    }
    return _results;
  };

  PathMenu.prototype.add_click_to_circle = function(circle, is_root) {
    var handler,
      _this = this;
    if (is_root == null) {
      is_root = false;
    }
    handler = function(e) {
      var child, degrees, _i, _len, _ref;
      if (circle._active) {
        circle.hover(circle._activate, circle._deactivate);
        degrees = 0;
        if (circle._children) {
          _ref = circle._children;
          for (_i = 0, _len = _ref.length; _i < _len; _i++) {
            child = _ref[_i];
            if (!child._active) {
              continue;
            }
            child._deactivate();
            child._click_handler();
          }
        }
      } else {
        circle.unhover(circle._activate, circle._deactivate);
        degrees = 45;
      }
      _this.bounce_circles(circle, circle._children);
      circle.animate({
        transform: "r" + degrees
      }, 200);
      return circle._active = !circle._active;
    };
    circle._click_handler = handler;
    return circle.click(handler);
  };

  PathMenu.prototype.add_label_to_circle = function(data, circle) {
    var anchor, label, label2, labels, offset;
    label = this.r.text(circle._realx, circle._realy, data.label).attr({
      "font-size": 14
    });
    label2 = this.r.text(circle._realx, circle._realy + 15, format_number(data.value)).attr({
      "font-size": 12,
      "fill": this.options.fill_color
    }).toBack();
    labels = this.r.set();
    labels.push(label);
    labels.push(label2);
    if (circle._realx > this.center_point.x) {
      anchor = "start";
      offset = 30;
    } else {
      anchor = "end";
      offset = -30;
    }
    labels.attr({
      "text-anchor": anchor,
      "x": circle._realx + offset,
      "opacity": 0
    });
    return circle._label = labels;
  };

  PathMenu.prototype.add_grandchildren = function(data, circle) {
    var _this = this;
    if (!data.children) {
      return;
    }
    circle._children = [];
    return this.create_circles_along_radius(data.children, this.child_radius, this.outer_radius2, function(grandchild, grandchild_circle) {
      circle._active = false;
      return circle._children.push(grandchild_circle);
    });
  };

  PathMenu.prototype.draw_circle = function(x, y, r, text_size) {
    var attrs, set;
    attrs = {
      fill: this.options.fill_color,
      stroke: "none"
    };
    set = this.r.set();
    set.push(this.r.circle(x, y, r).attr(attrs));
    set.push(this.r.text(x, y, "+").attr({
      "font-size": text_size,
      "fill": "#fff"
    }));
    return set.attr({
      cursor: "pointer"
    }).toFront();
  };

  PathMenu.prototype.draw = function() {
    var children, main_circle, step_size,
      _this = this;
    main_circle = this.draw_circle(this.center_point.x, this.center_point.y, this.main_radius, 100);
    main_circle._active = false;
    main_circle._children = [];
    this.add_click_to_circle(main_circle, true);
    children = this.children.length;
    step_size = (2 * Math.PI) / children;
    this.create_circles_along_radius(this.children, this.child_radius, this.outer_radius, function(child, circle) {
      _this.add_grandchildren(child, circle);
      _this.add_click_to_circle(circle);
      return main_circle._children.push(circle);
    });
    return main_circle.toFront();
  };

  return PathMenu;

})(BaseChart);

exports.PathMenu = PathMenu;
var CircleProgress, CircleProgressOptions, arc,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

arc = function(xloc, yloc, value, total, R) {
  var a, alpha, path, x, y;
  alpha = 360 / total * value;
  a = (90 - alpha) * Math.PI / 180;
  x = xloc + R * Math.cos(a);
  y = yloc - R * Math.sin(a);
  path = void 0;
  if (total === value) {
    path = [["M", xloc, yloc - R], ["A", R, R, 0, 1, 1, xloc - 0.01, yloc - R]];
  } else {
    path = [["M", xloc, yloc - R], ["A", R, R, 0, +(alpha > 180), 1, x, y]];
  }
  return {
    path: path
  };
};

CircleProgressOptions = (function(_super) {

  __extends(CircleProgressOptions, _super);

  CircleProgressOptions.DEFAULTS = {
    radius: 55,
    stroke_width: 30,
    font_color: "#333333",
    label_color: "#333333",
    fill_color: "#fff",
    stroke_color: "#81ae14",
    background_color: "#222222",
    text_shadow: false
  };

  function CircleProgressOptions(options) {
    return CircleProgressOptions.__super__.constructor.call(this, options, CircleProgressOptions.DEFAULTS);
  }

  return CircleProgressOptions;

})(BaseChartOptions);

CircleProgress = (function(_super) {

  __extends(CircleProgress, _super);

  function CircleProgress(dom_id, label, value, options) {
    this.label = label;
    this.value = value;
    if (options == null) {
      options = {};
    }
    CircleProgress.__super__.constructor.call(this, dom_id, new CircleProgressOptions(options));
    this.center_point = new Point(this.width / 2, this.height / 2);
    this.r.customAttributes.arc = arc;
  }

  CircleProgress.prototype.draw = function() {
    var label, path, percent;
    path = this.r.path().attr({
      "stroke-width": this.options.stroke_width,
      "stroke": this.options.stroke_color,
      arc: [this.center_point.x, this.center_point.y, 0, 100, this.options.radius]
    });
    this.r.circle(this.center_point.x, this.center_point.y, this.options.radius).attr({
      "fill": this.options.fill_color,
      "stroke": "none",
      "stroke-width": 0
    });
    percent = Math.round(this.value * 100 / 100) + "%";
    this.r.text(this.center_point.x, this.center_point.y, percent).attr({
      'font-size': this.options.radius / 2.5,
      'fill': this.options.font_color,
      'font-weight': 'bold'
    });
    label = this.r.text(this.center_point.x, this.center_point.y + 1.8 * this.options.radius, this.label).attr({
      'font-size': this.options.radius / 2.5,
      'font-weight': 'bold',
      'fill': this.options.label_color
    });
    if (this.options.text_shadow) {
      this.r.text(this.center_point.x, this.center_point.y + 1.8 * this.options.radius + 1, this.label).attr({
        'font-size': this.options.radius / 2.5,
        'font-weight': 'bold',
        'fill': this.options.text_shadow
      }).toBack();
    }
    return path.animate({
      arc: [this.center_point.x, this.center_point.y, this.value, 100, this.options.radius]
    }, 1500, '<');
  };

  return CircleProgress;

})(BaseChart);

exports.CircleProgress = CircleProgress;
var LineChart,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

LineChart = (function(_super) {

  __extends(LineChart, _super);

  function LineChart(dom_id, options) {
    if (options == null) {
      options = {};
    }
    LineChart.__super__.constructor.call(this, dom_id, new LineChartOptions(options));
    this.padding = 26;
    this.all_points = [];
    this.line_indices = [];
    this.line_options = [];
  }

  LineChart.prototype.add_line = function(args) {
    var data, item, points, points_count, _i, _len;
    data = args.data;
    if (data.length < 1) {
      return;
    }
    points = [];
    for (_i = 0, _len = data.length; _i < _len; _i++) {
      item = data[_i];
      if (item.length === 3) {
        points.push(new Point(item[0], item[1], item[2]));
      } else {
        points.push(new Point(item[0], item[1]));
      }
    }
    points_count = this.all_points.length;
    this.line_indices.push([points_count, points_count + points.length - 1]);
    this.all_points.push.apply(this.all_points, points);
    this.line_options.push(LineChartOptions.merge(this.options, args.options));
  };

  LineChart.prototype.draw_grid = function(x_coordinates, y_coordinates) {
    var height, left_side, left_stroke, paths, right_side, right_stroke, stroke, val, width, x_offset, _i, _j, _len, _len1;
    if (x_coordinates == null) {
      x_coordinates = [];
    }
    if (y_coordinates == null) {
      y_coordinates = [];
    }
    stroke = function(path, color, width) {
      return path.attr({
        stroke: color,
        "stroke-width": width
      });
    };
    x_offset = this.options.multi_axis ? this.options.x_padding * 2 : this.options.x_padding;
    height = this.height - this.options.y_padding;
    width = this.width - x_offset;
    paths = this.r.set();
    for (_i = 0, _len = x_coordinates.length; _i < _len; _i++) {
      val = x_coordinates[_i];
      paths.push(this.r.path("M " + val + ", " + this.options.y_padding + " L " + val + ", " + height + " Z"));
    }
    for (_j = 0, _len1 = y_coordinates.length; _j < _len1; _j++) {
      val = y_coordinates[_j];
      paths.push(this.r.path("M " + this.options.x_padding + ", " + val + " L " + width + ", " + val + " Z"));
    }
    if (this.options.multi_axis === true && this.line_options.length === 2) {
      left_side = this.options.x_padding;
      left_stroke = this.r.path("M " + left_side + ", " + this.options.y_padding + " L " + left_side + ", " + height + " Z");
      right_side = this.width - this.options.x_padding * 2;
      right_stroke = this.r.path("M " + right_side + ", " + this.options.y_padding + " L " + right_side + ", " + height + " Z");
      stroke(left_stroke, this.line_options[0].line_color, 2).toBack();
      stroke(right_stroke, this.line_options[1].line_color, 2).toBack();
    }
    return stroke(paths, "#ddd", 1).toBack();
  };

  LineChart.prototype.create_scalers = function(points) {
    var linear, log, log_points, max_x, max_y, min_x, min_y, p, x, x_offset, y, y_scaler, _ref, _ref1, _ref2,
      _this = this;
    y = void 0;
    max_x = void 0;
    min_x = void 0;
    max_y = void 0;
    min_y = void 0;
    if (this.options.scale === 'log') {
      log = new LogScaler();
      log_points = (function() {
        var _i, _len, _results;
        _results = [];
        for (_i = 0, _len = points.length; _i < _len; _i++) {
          p = points[_i];
          _results.push(new Point(p.x, log(p.y)));
        }
        return _results;
      })();
      _ref = Scaling.get_ranges_for_points(log_points), max_x = _ref[0], min_x = _ref[1], max_y = _ref[2], min_y = _ref[3];
    } else {
      _ref1 = Scaling.get_ranges_for_points(points), max_x = _ref1[0], min_x = _ref1[1], max_y = _ref1[2], min_y = _ref1[3];
    }
    if (this.options.y_axis_scale.length === 2) {
      _ref2 = this.options.y_axis_scale, min_y = _ref2[0], max_y = _ref2[1];
    }
    x_offset = this.options.multi_axis ? this.options.x_padding * 2 : this.options.x_padding;
    x = new Scaler().domain([min_x, max_x]).range([this.options.x_padding, this.width - x_offset]);
    y_scaler = new Scaler().domain([min_y, max_y]).range([this.options.y_padding, this.height - this.options.y_padding]);
    linear = function(i) {
      return _this.height - y_scaler(i);
    };
    if (this.options.scale === 'log') {
      y = function(i) {
        return linear(log(i));
      };
    } else {
      y = linear;
    }
    return [x, y];
  };

  LineChart.prototype.create_scalers_for_single_point = function() {
    var x, y,
      _this = this;
    y = function(i) {
      return 0.5 * (_this.height - _this.options.y_padding);
    };
    x = function(i) {
      return 0.5 * (_this.width - _this.options.x_padding);
    };
    return [x, y];
  };

  LineChart.prototype._draw_y_labels = function(labels, x_offset) {
    var axis, fmt, font_family, label, label_coordinates, offset, padding, size, x, y, _i, _len, _ref, _ref1;
    if (x_offset == null) {
      x_offset = 0;
    }
    fmt = this.options.label_format;
    size = this.options.y_label_size;
    font_family = this.options.font_family;
    padding = size + 5;
    offset = this.options.multi_axis && x_offset > 0 ? x_offset : x_offset + padding;
    if (labels.length === 1) {
      _ref = this.create_scalers_for_single_point(), x = _ref[0], y = _ref[1];
    } else {
      _ref1 = this.create_scalers(labels), x = _ref1[0], y = _ref1[1];
    }
    label_coordinates = [];
    axis = new LabelSet(this.r, fmt).x(function(i) {
      return offset;
    }).y(function(i) {
      return y(labels[i].y);
    }).size(size);
    for (_i = 0, _len = labels.length; _i < _len; _i++) {
      label = labels[_i];
      axis.draw(label.y);
      label_coordinates.push(y(label.y));
    }
    return label_coordinates;
  };

  LineChart.prototype.calc_y_label_step_size = function(min_y, max_y, max_labels) {
    var step_size;
    if (max_labels == null) {
      max_labels = this.options.max_y_labels;
    }
    step_size = (max_y - min_y) / (max_labels - 1);
    if (max_y > 1) {
      step_size = Math.round(step_size);
      if (step_size === 0) {
        step_size = 1;
      }
    }
    return step_size;
  };

  LineChart.prototype.draw_y_labels = function(points, x_offset) {
    var end, label, labels, log, max_x, max_y, min_x, min_y, n, start, step_size, y, _ref, _ref1;
    if (x_offset == null) {
      x_offset = 0;
    }
    _ref = Scaling.get_ranges_for_points(points), max_x = _ref[0], min_x = _ref[1], max_y = _ref[2], min_y = _ref[3];
    if (this.options.y_axis_scale.length === 2) {
      _ref1 = this.options.y_axis_scale, min_y = _ref1[0], max_y = _ref1[1];
    }
    if (max_y === min_y) {
      return this._draw_y_labels([new Point(0, max_y)], x_offset);
    }
    labels = [];
    if (this.options.scale === 'log') {
      log = new LogScaler();
      start = log(min_y);
      end = log(max_y);
      step_size = (end - start) / (this.options.max_y_labels - 1);
      label = min_y;
      n = 0;
      while (label <= max_y && n < this.options.max_y_labels) {
        label = Math.pow(10, start + step_size * n);
        labels.push(new Point(0, label));
        n += 1;
      }
    } else {
      y = min_y;
      step_size = this.calc_y_label_step_size(min_y, max_y);
      while (y <= max_y) {
        labels.push(new Point(0, y));
        y += step_size;
      }
    }
    if (max_y > 1) {
      labels[labels.length - 1].y = Math.round(max_y);
    }
    return this._draw_y_labels(labels, x_offset);
  };

  LineChart.prototype.draw_x_label = function(raw_point, point) {
    var fmt, font_family, label, size;
    fmt = this.options.label_format;
    size = this.options.x_label_size;
    font_family = this.options.font_family;
    label = raw_point.is_date_type === true ? new Date(raw_point.x) : Math.round(raw_point.x);
    return new Label(this.r, point.x, this.height - size, label, fmt, size, font_family).draw();
  };

  LineChart.prototype.draw_x_labels = function(raw_points, points) {
    var i, label_coordinates, last, len, max_labels, point, raw_point, rounded_step_size, step_size;
    label_coordinates = [];
    max_labels = this.options.max_x_labels;
    this.draw_x_label(raw_points[0], points[0]);
    label_coordinates.push(points[0].x);
    if (max_labels < 2) {
      return;
    }
    last = points.length - 1;
    this.draw_x_label(raw_points[last], points[last]);
    label_coordinates.push(points[last].x);
    if (max_labels < 3) {
      return;
    }
    len = points.length - 2;
    step_size = len / (max_labels - 1);
    rounded_step_size = Math.round(step_size);
    if (step_size !== rounded_step_size) {
      step_size = rounded_step_size + 1;
    }
    i = step_size;
    while (i < len) {
      raw_point = raw_points[i];
      point = points[i];
      this.draw_x_label(raw_point, point);
      label_coordinates.push(point.x);
      i += step_size;
    }
    return label_coordinates;
  };

  LineChart.prototype.draw_line = function(raw_points, points, options) {
    if (this.options.render === "bar") {
      return new LineBar(this.r, raw_points, points, this.height, this.width, options).draw();
    } else {
      return new Line(this.r, raw_points, points, this.height, this.width, options).draw();
    }
  };

  LineChart.prototype.clear = function() {
    LineChart.__super__.clear.call(this);
    this.all_points = [];
    this.line_indices = [];
    return this.line_options = [];
  };

  LineChart.prototype.draw = function() {
    var begin, end, i, line_indices, line_x, line_y, options, point, points, raw_points, x, y, _i, _len, _ref, _ref1, _ref2;
    if (this.all_points.length < 1) {
      return;
    }
    this.r.clear();
    _ref = this.all_points.length > 1 ? this.create_scalers(this.all_points) : this.create_scalers_for_single_point(), x = _ref[0], y = _ref[1];
    _ref1 = this.line_indices;
    for (i = _i = 0, _len = _ref1.length; _i < _len; i = ++_i) {
      line_indices = _ref1[i];
      begin = line_indices[0], end = line_indices[1];
      raw_points = this.all_points.slice(begin, end + 1 || 9e9);
      if (this.options.multi_axis) {
        _ref2 = this.all_points.length > 2 ? this.create_scalers(raw_points) : this.create_scalers_for_single_point(), line_x = _ref2[0], line_y = _ref2[1];
      } else {
        line_x = x;
        line_y = y;
      }
      points = (function() {
        var _j, _len1, _results;
        _results = [];
        for (_j = 0, _len1 = raw_points.length; _j < _len1; _j++) {
          point = raw_points[_j];
          _results.push(new Point(line_x(point.x), line_y(point.y)));
        }
        return _results;
      })();
      options = this.line_options[i];
      this.draw_line(raw_points, points, options);
      if (i === 0) {
        if (this.options.show_x_labels === true) {
          this.x_label_coordinates = this.draw_x_labels(raw_points, points);
        }
        if (this.options.multi_axis && this.options.show_y_labels === true) {
          this.y_label_coordinates = this.draw_y_labels(raw_points);
        } else if (this.options.show_y_labels === true) {
          this.y_label_coordinates = this.draw_y_labels(this.all_points);
        }
        if (this.options.show_grid === true) {
          this.draw_grid(this.x_label_coordinates, this.y_label_coordinates);
        }
      } else if (i === 1 && this.options.multi_axis) {
        if (this.options.show_y_labels === true) {
          this.draw_y_labels(raw_points, this.width - this.options.x_padding);
        }
      }
    }
  };

  return LineChart;

})(BaseChart);

exports.LineChart = LineChart;
var IndexChart, bar_struct, guide_struct,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

bar_struct = function(label, raw_value, index_value) {
  return {
    label: label,
    raw_value: raw_value,
    index_value: index_value
  };
};

guide_struct = function(label, index_value, opacity) {
  return {
    label: label,
    index_value: index_value,
    opacity: opacity
  };
};

IndexChart = (function(_super) {

  __extends(IndexChart, _super);

  function IndexChart(dom_id, options) {
    if (options == null) {
      options = {};
    }
    IndexChart.__super__.constructor.call(this, dom_id, new IndexChartOptions(options));
    this.effects = new Effects(this.r);
    this.bars = [];
    this.guides = [];
    this.index = 100;
  }

  IndexChart.prototype.add = function(label, raw_value, index_value) {
    return this.bars.push(bar_struct(label, raw_value, index_value));
  };

  IndexChart.prototype.add_guide_line = function(label, index_value, opacity) {
    if (opacity == null) {
      opacity = 1;
    }
    return this.guides.push(guide_struct(label, index_value, opacity));
  };

  IndexChart.prototype.add_raw_label = function(label) {
    var labels,
      _this = this;
    labels = new LabelSet(this.r).x(function(num) {
      return _this.width - 10;
    }).y(function(i) {
      return i * 15 + 15;
    }).size(this.options.label_size).attr({
      "fill": "#333",
      "text-anchor": "end",
      "font-weight": "bold"
    });
    labels.draw(label);
    return labels.draw("(raw value)").attr({
      "font-weight": "normal",
      "font-size": 10
    });
  };

  IndexChart.prototype.set_bar_height = function() {
    var effective_height, margin, num_bars;
    num_bars = this.bars.length;
    margin = this.options.bar_margin;
    effective_height = this.height - this.options.y_padding;
    return this.bar_height = (effective_height / num_bars) - margin;
  };

  IndexChart.prototype.set_threshold = function() {
    var guide, thresholds;
    thresholds = (function() {
      var _i, _len, _ref, _results;
      _ref = this.guides;
      _results = [];
      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
        guide = _ref[_i];
        _results.push(guide.index_value);
      }
      return _results;
    }).call(this);
    return this.threshold = Math.max.apply(Math.max, thresholds);
  };

  IndexChart.prototype.format_tooltip = function(raw_value) {
    return (raw_value / 100) + "x";
  };

  IndexChart.prototype.draw_raw_bar = function(raw_value, y) {
    var margin, offset, padding, rect, width;
    padding = 14;
    offset = Math.floor(padding / 2);
    margin = 10;
    width = this.options.x_padding_right - margin;
    rect = this.r.rect(this.width - width, y - offset, this.width - this.options.x_padding_right, this.bar_height + padding, this.options.rounding);
    rect.attr({
      fill: this.options.raw_value_bar_color,
      "stroke": "none"
    });
    return this.effects.straight_line(new Point(this.width - width, this.options.y_padding - 10), new Point(this.width - width, this.height)).attr({
      stroke: "rgba(0,0,0,0.25)",
      "stroke-width": 0.1
    });
  };

  IndexChart.prototype.draw_bg_bar = function(raw_value, scaler, y) {
    var offset, padding, rect, x;
    x = scaler(raw_value);
    padding = this.options.bg_bar_padding;
    offset = Math.floor(padding / 2);
    rect = this.r.rect(this.options.x_padding - offset, y - offset, this.width, this.bar_height + padding, this.options.rounding);
    return rect.attr({
      fill: this.options.bar_bg_color,
      "stroke": "none"
    }).toBack();
  };

  IndexChart.prototype.shade_bar = function(bar, color) {
    if (color == null) {
      color = this.options.bar1_color;
    }
    bar.attr({
      fill: color,
      "stroke": "none"
    });
    this.effects.one_px_shadow(bar);
    return this.effects.one_px_highlight(bar);
  };

  IndexChart.prototype.render_bar = function(startx, starty, width, color) {
    var rect;
    if (color == null) {
      color = this.options.bar1_color;
    }
    rect = this.r.rect(startx, starty, width, this.bar_height, this.options.rounding);
    this.shade_bar(rect, color);
    return rect;
  };

  IndexChart.prototype.draw_bar = function(raw_value, x_scaler, y) {
    var index_x, rect, rect1, rect2, tooltip, x;
    x = x_scaler(Scaling.threshold(raw_value, this.threshold));
    if (raw_value > this.index) {
      index_x = x_scaler(this.index);
      rect1 = this.render_bar(this.options.x_padding, y, index_x - this.options.x_padding);
      rect2 = this.render_bar(index_x, y, x - index_x, this.options.bar2_color);
      tooltip = new Tooltip(this.r, rect2, this.format_tooltip(raw_value));
      tooltip.translate(rect2.getBBox().width / 2, 0);
      rect1.mouseover(function() {
        return tooltip.show();
      });
      return rect1.mouseout(function() {
        return tooltip.hide();
      });
    } else {
      rect = this.render_bar(this.options.x_padding, y, x - this.options.x_padding);
      tooltip = new Tooltip(this.r, rect, this.format_tooltip(raw_value));
      return tooltip.translate(rect.getBBox().width / 2, 0);
    }
  };

  IndexChart.prototype.draw_guide_line = function(label, index_value, x, opacity) {
    var end, labels, start;
    if (opacity == null) {
      opacity = 1;
    }
    start = new Point(x, this.options.y_padding);
    end = new Point(x, this.height);
    this.effects.vertical_dashed_line(start, end, this.options.dash_width).attr({
      fill: "rgba(0,0,0," + opacity + ")",
      "stroke": "none"
    });
    labels = new LabelSet(this.r).x(function() {
      return x;
    }).y(function(i) {
      return i * 15 + 15;
    }).size(this.options.label_size).attr({
      fill: "rgba(0,0,0," + opacity + ")"
    });
    labels.draw(label).attr({
      "font-weight": "bold"
    });
    return labels.draw(index_value).attr({
      "font-size": 10
    });
  };

  IndexChart.prototype.sort_bars_by_index = function() {
    var bar, bar_copy;
    bar_copy = (function() {
      var _i, _len, _ref, _results;
      _ref = this.bars;
      _results = [];
      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
        bar = _ref[_i];
        _results.push(bar);
      }
      return _results;
    }).call(this);
    bar_copy.sort(function(a, b) {
      return b.index_value - a.index_value;
    });
    return bar_copy;
  };

  IndexChart.prototype.clear = function() {
    IndexChart.__super__.clear.call(this);
    this.bars = [];
    return this.guides = [];
  };

  IndexChart.prototype.draw = function() {
    var bar, guide, half_bar_height, i, label, labels, raw_label, raw_value_labels, spacing_factor, x, x_padding, y, y_padding, _i, _j, _len, _len1, _ref, _ref1, _results,
      _this = this;
    this.set_bar_height();
    this.set_threshold();
    spacing_factor = this.bar_height + this.options.bar_margin;
    half_bar_height = this.bar_height / 2;
    y_padding = this.options.y_padding;
    x_padding = this.options.x_padding;
    labels = new LabelSet(this.r).y(function(num) {
      return (num * spacing_factor) + y_padding + half_bar_height;
    }).x(function(num) {
      return x_padding - 30;
    }).size(12).attr({
      "fill": "#fff",
      "text-anchor": "end"
    });
    raw_value_labels = new LabelSet(this.r).y(function(num) {
      return (num * spacing_factor) + y_padding + half_bar_height;
    }).x(function(num) {
      return _this.width - 10;
    }).size(this.options.label_size).attr({
      "fill": "#333",
      "text-anchor": "end"
    });
    x = new Scaler().domain([0, this.threshold]).range([this.options.x_padding, this.width - this.options.x_padding_right]);
    y = function(i) {
      return i * (_this.bar_height + _this.options.bar_margin) + _this.options.y_padding;
    };
    _ref = this.sort_bars_by_index();
    for (i = _i = 0, _len = _ref.length; _i < _len; i = ++_i) {
      bar = _ref[i];
      this.draw_bg_bar(bar.index_value, x, y(i));
      this.draw_raw_bar(bar.raw_value, y(i));
      this.draw_bar(bar.index_value, x, y(i));
      raw_label = raw_value_labels.draw(bar.raw_value);
      label = labels.draw(bar.label);
      this.effects.black_nub(label);
    }
    _ref1 = this.guides;
    _results = [];
    for (_j = 0, _len1 = _ref1.length; _j < _len1; _j++) {
      guide = _ref1[_j];
      _results.push(this.draw_guide_line(guide.label, guide.index_value, x(guide.index_value), guide.opacity));
    }
    return _results;
  };

  return IndexChart;

})(BaseChart);

exports.IndexChart = function(container, options) {
  return new IndexChart(container, options);
};
var BulletChart, bar,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

bar = function(label, value, average, comparison) {
  return {
    label: label,
    value: value,
    average: average,
    comparison: comparison
  };
};

BulletChart = (function(_super) {

  __extends(BulletChart, _super);

  function BulletChart(dom_id, options) {
    if (options == null) {
      options = {};
    }
    BulletChart.__super__.constructor.call(this, dom_id, new BulletChartOptions(options));
    this.bars = [];
  }

  BulletChart.prototype.add = function(label, value, average, comparison) {
    return this.bars.push(bar.apply(bar, arguments));
  };

  BulletChart.prototype.draw_background = function(point, y_offset) {
    var rect;
    rect = this.r.rect(this.options.x_padding, y_offset, point.x, this.options.area_width);
    return rect.attr({
      fill: this.options.area_color,
      "stroke": "none"
    });
  };

  BulletChart.prototype.draw_line = function(point, background_midpoint) {
    var rect, y;
    y = background_midpoint.y - this.options.line_width / 2;
    rect = this.r.rect(this.options.x_padding, y, point.x, this.options.line_width);
    return rect.attr({
      fill: this.options.line_color,
      "stroke": "none"
    });
  };

  BulletChart.prototype.draw_average = function(point, midpoint_y) {
    var rect;
    rect = this.r.rect(point.x - (this.options.average_width / 2), midpoint_y - this.options.average_height / 2, this.options.average_width, this.options.average_height);
    return rect.attr({
      fill: this.options.average_color,
      "stroke": "none"
    });
  };

  BulletChart.prototype.draw_label = function(text, offset) {};

  BulletChart.prototype.clear = function() {
    BulletChart.__super__.clear.call(this);
    return this.bars = [];
  };

  BulletChart.prototype.draw = function() {
    var i, max_x, max_y, midpoint_y, min_x, min_y, p, point, points, x, y_offset, _i, _len, _ref, _ref1, _results;
    _ref = this.bars;
    _results = [];
    for (i = _i = 0, _len = _ref.length; _i < _len; i = ++_i) {
      bar = _ref[i];
      p = [new Point(bar.comparison, 0), new Point(bar.value, 0), new Point(bar.average, 0), new Point(0, 0)];
      _ref1 = Scaling.get_ranges_for_points(p), max_x = _ref1[0], min_x = _ref1[1], max_y = _ref1[2], min_y = _ref1[3];
      x = new Scaler().domain([min_x, max_x]).range([this.options.x_padding, this.width - this.options.x_padding]);
      points = (function() {
        var _j, _len1, _results1;
        _results1 = [];
        for (_j = 0, _len1 = p.length; _j < _len1; _j++) {
          point = p[_j];
          _results1.push(new Point(x(point.x), 0));
        }
        return _results1;
      })();
      y_offset = i * (this.options.area_width + this.options.bar_margin);
      this.draw_background(points[0], y_offset);
      midpoint_y = y_offset + this.options.area_width / 2;
      this.draw_line(points[1], new Point(points[0].x, midpoint_y));
      this.draw_average(points[2], midpoint_y);
      _results.push(new Label(this.r, 0, y_offset + this.options.area_width / 2, bar.label, "", this.size = 14, this.options.font_family).draw());
    }
    return _results;
  };

  return BulletChart;

})(BaseChart);

exports.BulletChart = BulletChart;
var BarChart,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

BarChart = (function(_super) {

  __extends(BarChart, _super);

  function BarChart(dom_id, options) {
    if (options == null) {
      options = {};
    }
    BarChart.__super__.constructor.call(this, dom_id, new BarChartOptions(options));
    this.effective_height = this.height - this.options.y_padding;
    this.bar_options = [];
    this.bars = [];
    this.values = [];
  }

  BarChart.prototype.add = function(args) {
    var label, value;
    label = args.label, value = args.value;
    this.bar_options.push(BarChartOptions.merge(this.options, args.options));
    this.values.push(value);
    return this.bars.push({
      label: label,
      value: value
    });
  };

  BarChart.prototype.render_bar = function(x_label, y_label, topleft_corner, options) {
    var rect;
    rect = this.r.rect(topleft_corner.x, topleft_corner.y, this.options.bar_width, this.effective_height - topleft_corner.y, this.options.rounding);
    rect.attr({
      "fill": options.bar_color,
      "stroke": "none"
    });
    new Label(this.r, topleft_corner.x + this.options.bar_width / 2, this.height - (this.options.x_label_size + 5), x_label, "", this.options.x_label_size, this.options.font_family, this.options.x_label_color).draw();
    return new Label(this.r, topleft_corner.x + this.options.bar_width / 2, topleft_corner.y - this.options.y_label_size - 5, y_label, "", this.options.y_label_size, this.options.font_family, this.options.y_label_color).draw();
  };

  BarChart.prototype.clear = function() {
    BarChart.__super__.clear.call(this);
    this.bars = [];
    return this.values = [];
  };

  BarChart.prototype.draw = function() {
    var bar, i, max_x, max_y, min_x, min_y, points, scaled_x, scaled_y, tl_bar_corner, value, y, y_scaler, _i, _len, _ref, _ref1, _results,
      _this = this;
    points = (function() {
      var _i, _len, _ref, _results;
      _ref = this.values;
      _results = [];
      for (i = _i = 0, _len = _ref.length; _i < _len; i = ++_i) {
        value = _ref[i];
        _results.push(new Point(i, value));
      }
      return _results;
    }).call(this);
    points.push(new Point(0, 0));
    _ref = Scaling.get_ranges_for_points(points), max_x = _ref[0], min_x = _ref[1], max_y = _ref[2], min_y = _ref[3];
    y_scaler = new Scaler().domain([min_y, max_y]).range([this.options.y_padding, this.height - this.options.y_padding]);
    y = function(i) {
      return _this.height - y_scaler(i);
    };
    _ref1 = this.bars;
    _results = [];
    for (i = _i = 0, _len = _ref1.length; _i < _len; i = ++_i) {
      bar = _ref1[i];
      scaled_x = i * (this.options.bar_width + this.options.bar_spacing) + this.options.x_padding;
      scaled_y = y(points[i].y);
      tl_bar_corner = new Point(scaled_x, scaled_y);
      _results.push(this.render_bar(bar.label, bar.value, tl_bar_corner, this.bar_options[i]));
    }
    return _results;
  };

  return BarChart;

})(BaseChart);

exports.BarChart = BarChart;

    })
