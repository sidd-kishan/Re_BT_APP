const cat_pic = "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"

const lookup = []
const revLookup = []

const code = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/'
for (let i = 0, len = code.length; i < len; ++i) {
  lookup[i] = code[i]
  revLookup[code.charCodeAt(i)] = i
}

// Support decoding URL-safe base64 strings, as Node.js does.
// See: https://en.wikipedia.org/wiki/Base64#URL_applications
revLookup['-'.charCodeAt(0)] = 62
revLookup['_'.charCodeAt(0)] = 63

function tripletToBase64 (num) {
  return lookup[num >> 18 & 0x3F] +
    lookup[num >> 12 & 0x3F] +
    lookup[num >> 6 & 0x3F] +
    lookup[num & 0x3F]
}

function encodeChunk (uint8, start, end) {
  const output = []
  for (let i = start; i < end; i += 3) {
    const tmp =
      ((uint8[i] << 16) & 0xFF0000) +
      ((uint8[i + 1] << 8) & 0xFF00) +
      (uint8[i + 2] & 0xFF)
    output.push(tripletToBase64(tmp))
  }
  return output.join('')
}

function fromByteArray (uint8) {
  const len = uint8.length
  const extraBytes = len % 3 // if we have 1 byte left, pad 2 bytes
  const parts = []
  const maxChunkLength = 16383 // must be multiple of 3

  // go through the array every three bytes, we'll deal with trailing stuff later
  for (let i = 0, len2 = len - extraBytes; i < len2; i += maxChunkLength) {
    parts.push(encodeChunk(uint8, i, (i + maxChunkLength) > len2 ? len2 : (i + maxChunkLength)))
  }

  // pad the end with zeros, but make sure to not forget the extra bytes
  if (extraBytes === 1) {
    const tmp = uint8[len - 1]
    parts.push(
      lookup[tmp >> 2] +
      lookup[(tmp << 4) & 0x3F] +
      '=='
    )
  } else if (extraBytes === 2) {
    const tmp = (uint8[len - 2] << 8) + uint8[len - 1]
    parts.push(
      lookup[tmp >> 10] +
      lookup[(tmp >> 4) & 0x3F] +
      lookup[(tmp << 2) & 0x3F] +
      '='
    )
  }

  return parts.join('')
}


function getLens (b64) {
  const len = b64.length

  if (len % 4 > 0) {
    throw new Error('Invalid string. Length must be a multiple of 4')
  }

  // Trim off extra bytes after placeholder bytes are found
  // See: https://github.com/beatgammit/base64-js/issues/42
  let validLen = b64.indexOf('=')
  if (validLen === -1) validLen = len

  const placeHoldersLen = validLen === len
    ? 0
    : 4 - (validLen % 4)

  return [validLen, placeHoldersLen]
}

// base64 is 4/3 + up to two characters of the original data
function byteLength (b64) {
  const lens = getLens(b64)
  const validLen = lens[0]
  const placeHoldersLen = lens[1]
  return ((validLen + placeHoldersLen) * 3 / 4) - placeHoldersLen
}

function _byteLength (b64, validLen, placeHoldersLen) {
  return ((validLen + placeHoldersLen) * 3 / 4) - placeHoldersLen
}

function toByteArray (b64) {
  const lens = getLens(b64)
  const validLen = lens[0]
  const placeHoldersLen = lens[1]

  const arr = new Uint8Array(_byteLength(b64, validLen, placeHoldersLen))

  let curByte = 0

  // if there are placeholders, only get up to the last complete 4 chars
  const len = placeHoldersLen > 0
    ? validLen - 4
    : validLen

  let i
  for (i = 0; i < len; i += 4) {
    const tmp =
      (revLookup[b64.charCodeAt(i)] << 18) |
      (revLookup[b64.charCodeAt(i + 1)] << 12) |
      (revLookup[b64.charCodeAt(i + 2)] << 6) |
      revLookup[b64.charCodeAt(i + 3)]
    arr[curByte++] = (tmp >> 16) & 0xFF
    arr[curByte++] = (tmp >> 8) & 0xFF
    arr[curByte++] = tmp & 0xFF
  }

  if (placeHoldersLen === 2) {
    const tmp =
      (revLookup[b64.charCodeAt(i)] << 2) |
      (revLookup[b64.charCodeAt(i + 1)] >> 4)
    arr[curByte++] = tmp & 0xFF
  }

  if (placeHoldersLen === 1) {
    const tmp =
      (revLookup[b64.charCodeAt(i)] << 10) |
      (revLookup[b64.charCodeAt(i + 1)] << 4) |
      (revLookup[b64.charCodeAt(i + 2)] >> 2)
    arr[curByte++] = (tmp >> 8) & 0xFF
    arr[curByte++] = tmp & 0xFF
  }

  return arr
}
var cmd_split = "";
Java.perform(function(){

const colors = {
    colorize: (str, cc) => `\x1b${cc}${str}\x1b[0m`,
    red: str => colors.colorize(str, '[31m'),
    green: str => colors.colorize(str, '[32m'),
    yellow: str => colors.colorize(str, '[33m'),
    blue: str => colors.colorize(str, '[34m'),
    cyan: str => colors.colorize(str, '[36m'),
    white: str => colors.colorize(str, '[37m'),
};


var type=Java.use("com.lianhezhuli.btnotification.mtk.btconnection.BluetoothManager");

type.getCommand.overload('java.lang.String').implementation = function (cmd) {
	console.log(colors.yellow("getCommand "+cmd));
	this.getCommand(cmd);
return;
}

type.sendCommandToRemote.overload('int','java.lang.String').implementation = function (n,cmd) {
		console.log(colors.blue("sendCommandToRemote n:"+n+" cmd:"+cmd));
		this.sendCommandToRemote(n,cmd);
return;
}

type.sendCAPCData.overload('[B').implementation = function (byarr) {
	//console.log(colors.green("sendCAPCData byteArr:"+"data:image/png;base64," + (fromByteArray(byarr))))
	var ret = this.sendCAPCData.overload('[B').call(this,toByteArray(cat_pic));
	console.log(colors.green("sendCAPCData cat len:"+ (toByteArray(cat_pic)).length))
	return ret;
}

type.setConnectedDeviceName.overload('java.lang.String').implementation = function (name) {
	console.log(colors.red("setConnectedDeviceName name:"+name));
	this.setConnectedDeviceName(name);
return;
}


});
