// Assign our class to Array class
var StringBuilderEx = Array;

// Using prototype I link function append to push
Array.prototype.append=Array.prototype.push;

// Used to convert arguments in array
Array.prototype._convertToArray=function(arguments)
{
    if (!arguments)
        return new Array();

    if (arguments.toArray)
        return arguments.toArray();

    var len = arguments.length
    var results = new Array(len);

    while (len--)
    {
        results[len] = arguments[len];
    }

    return results;
};

// First solution using regular expression
Array.prototype.appendFormat=function(pattern)
{
    var args = this._convertToArray(arguments).slice(1);

    this[this.length]=pattern.replace(/\{(\d+)\}/g,
        function(pattern, index)
        {
            return args[index].toString();
        });
};

// Second solution using split and join
Array.prototype.appendFormatEx=function(pattern)
{
    if (this._parameters==null)
        this._parameters = new Array();

    var args = this._convertToArray(arguments).slice(1);

    for (var t=0,len=args.length;t<len;t++)
    {
        this._parameters[this._parameters.length]=args[t];
    }

    this[this.length]=pattern;
};

// Concatenate the strings using join
// (some lines of code are relay with second solution)
Array.prototype.toString=function()
{
    var hasParameters = this._parameters!=null;
    hasParameters = hasParameters && this._parameters.length>0;

    if (hasParameters)
    {
        var values = this.join("").split('?');
        var tempBuffer = new Array();

        for (var t=0,len=values.length;t<len;t++)
        {
            tempBuffer[tempBuffer.length]=values[t];
            tempBuffer[tempBuffer.length]=this._parameters[t];
        }

        return tempBuffer.join("");
    }
    else
    {
        return this.join("");
    }
};