# Re_BT_APP setup

Taking Inspiration from [frida-gadget-injection](https://github.com/ksg97031/frida-gadget/tree/trunk?tab=readme-ov-file#how-do-i-begin)

## apktools should also be in path

`frida-gadget United\ Power\ BT\ Notification_frida.apk --arch arm64`

[8. Sign APK.](https://fadeevab.com/frida-gadget-injection-on-android-no-root-2-methods/)
I used [Uber APK signer](https://github.com/patrickfav/uber-apk-signer)

`java -jar uber-apk-signer-1.3.0.jar -a ./mt-app/United\ Power\ BT\ Notification_frida/dist/United\ Power\ BT\ Notification_frida.apk`

## Push APK to Downloads of sdcard

`adb push United\ Power\ BT\ Notification_frida/dist/United\ Power\ BT\ Notification_frida-aligned-debugSigned.apk /sdcard/Download`

## xz decompress frida server for android

`xz -d -v frida-server-16.4.8-android-arm64.xz`

## rename frida-server 
`mv frida-server-16.4.8-android-arm64 frida-server`

## adb push frida-server

`adb push frida-server /data/local/tmp/`

# On rooted android phone install busybox in /system/bin path
# Open terminal emulator on the rooted android phone

`su`
`busybox chmod 777 /data/local/tmp/frida-server`
`./frida-server &`

# Back to the computer to check connection with the frida-server
`frida-ls-devices`

## check trace logs

`frida-trace -U -i open -i strcmp -f com.lianhezhuli.btnotification`

## frida-server needs to be restarted upon phone restart

# Trace the frame send methods in java with frida-trace

`frida-trace -U -j '*!*sendCAPC*' -f com.lianhezhuli.btnotification`

bellow send frame?

`frida-trace -U -j '*!*sendCaptureData*' -f com.lianhezhuli.btnotification`

## to hook with scripts

`frida -U -l privacy-view-hook.js -f com.lianhezhuli.btnotification`
