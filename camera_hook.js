Java.perform(function(){

Java.use("com.lianhezhuli.btnotification.function.device.remotecamera.Preview$1").onPreviewFrame.overload('[B', 'android.hardware.Camera').implementation = function(bytearr,camera){
	console.log("onPreviewFrame called: "+bytearr.length);
	this.onPreviewFrame(bytearr,camera);
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


var type=Java.use("com.lianhezhuli.btnotification.mtk.btconnection.BluetoothManager");

type.sendCommandToRemote.overload('int','java.lang.String').implementation = function (n,cmd) {
		console.log(colors.blue("sendCommandToRemote n:"+n+" cmd:"+cmd));
		this.sendCommandToRemote(n,cmd);
return;
}
    });
	
