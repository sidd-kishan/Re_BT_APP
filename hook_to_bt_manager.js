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

function encodeHex(byteArray) {
    const HexClass = Java.use('org.apache.commons.codec.binary.Hex');
    const StringClass = Java.use('java.lang.String');
    const hexChars = HexClass.encodeHex(byteArray);
    return StringClass.$new(hexChars).toString();
}

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
/*
type.sendCAPCData.overload('[B').implementation = function (byarr) {
	//console.log(colors.green("sendCAPCData byteArr:"+byarr.length) )
	return this.sendCAPCData(byarr);
}
*/
type.setConnectedDeviceName.overload('java.lang.String').implementation = function (name) {
	console.log(colors.red("setConnectedDeviceName name:"+name));
	this.setConnectedDeviceName(name);
return;
}


});
