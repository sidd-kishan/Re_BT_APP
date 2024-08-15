
/* w:156 h:160 */
const col_pat = "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";

/* w:190 h:160 */
const col_pat_2 = "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";


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

const colors = {
    colorize: (str, cc) => `\x1b${cc}${str}\x1b[0m`,
    red: str => colors.colorize(str, '[31m'),
    green: str => colors.colorize(str, '[32m'),
    yellow: str => colors.colorize(str, '[33m'),
    blue: str => colors.colorize(str, '[34m'),
    cyan: str => colors.colorize(str, '[36m'),
    white: str => colors.colorize(str, '[37m'),
};


Java.perform(function(){
	Java.use("com.lianhezhuli.btnotification.function.device.remotecamera.Preview$1").onPreviewFrame.overload('[B', 'android.hardware.Camera').implementation = function(bytearr,camera){
		console.log("onPreviewFrame called: "+bytearr.length);
		this.onPreviewFrame(bytearr,camera);
	}

	var type=Java.use("com.lianhezhuli.btnotification.mtk.btconnection.BluetoothManager");
	type.sendCommandToRemote.overload('int','java.lang.String').implementation = function (n,cmd) {
		console.log(colors.blue("sendCommandToRemote n:"+n+" cmd:"+cmd));
		this.sendCommandToRemote(n,cmd);
		return;
	}

	type.sendDataToRemote.overload('int','[B').implementation = function (n,data) {
		console.log(colors.green("sendDataToRemote n:"+n+" data:"+data.length));
		this.sendDataToRemote(n,data);
		return;
	}

	type.sendCAPCData.overload('[B').implementation = function (data) {
		console.log(colors.cyan("sendCAPCData data:"+data.length));
		var ret = this.sendCAPCData.overload('[B').call(this,data);
		return ret;
	}


	var trigg = Java.use("com.lianhezhuli.btnotification.mtk.service.RemoteCameraService");
	trigg.onReceive.overload('android.content.Context', 'android.content.Intent').implementation = function (con,inti) {
		var ext_dat = inti.getByteArrayExtra("EXTRA_DATA")
		if(ext_dat[0]==49) {
			console.log("Action: "+ext_dat[0])
			var main_service = 0
			Java.choose("com.lianhezhuli.btnotification.mtk.service.MainService", {
				onMatch:function(instance){
					main_service = instance
					console.log("Found instance" + main_service);
				},
				onComplete:function() {
					console.log("search done");
				}
			});
			main_service.sendCAPCResult("1 0 ")
			var btman_insta = 0
			Java.choose("com.lianhezhuli.btnotification.mtk.btconnection.BluetoothManager", {
				onMatch:function(instance){
					btman_insta = instance
					console.log("Found instance" + btman_insta);
				},
				onComplete:function() {
					console.log("search done");
				}
			});
			const delay = ms => new Promise(resolve => setTimeout(resolve, ms))
			//while(1){
			btman_insta.sendCommandToRemote(7,"4 1 "+(toByteArray(col_pat_2).length));
			//main_service.sendCAPCData(toByteArray(col_pat_2));
			var ret = main_service.sendCAPCData.overload('[B').call(main_service,toByteArray(col_pat_2));
			delay(1000)
			//}
		} else if(ext_dat[0]==51) {
			console.log("Action: "+ext_dat[0])
			console.log(this.needPreview.value)
			this.needPreview.value = true
		} else if(ext_dat[0]==52){
			console.log("Action: "+ext_dat[0])
			const intentClass = Java.use("android.content.Intent");
			var intent_c = intentClass.$new();
			intent_c.setAction("com.lianhezhuli.RemoteCamera.CAPTURE");
			con.sendBroadcast(intent_c)
		} 
		return;
	}
});
	
