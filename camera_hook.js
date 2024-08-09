Java.perform(function(){
 	Java.use("com/lianhezhuli/btnotification/function/device/remotecamera/Preview$TakePictureCallback").sendCaptureData.overload("[B")
        .implementation = function(paramArrayOfByte) {
            // first we cast to list
            //var list = Java.cast(paramArrayOfCallConnection, ArrayList);
            // iterating the list
            //for (var i = 0, l = list.size(); i < l; i++) {
                // casting each element to the object we created earlier
                //var currentElement = Java.cast(list.get(i), CallConnection);
                // printing to terminal
            console.log(paramArrayOfByte.length);
            //}
            // executing original c'tor 
            this.sendCaptureData(paramArrayOfByte);
        }	
    });
