/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.util.Xml
 *  com.lianhezhuli.btnotification.MApplication
 *  com.lianhezhuli.btnotification.mtk.map.MapConstants
 *  com.lianhezhuli.btnotification.mtk.map.MessageList
 *  com.lianhezhuli.btnotification.mtk.map.MessageListItem
 *  com.lianhezhuli.btnotification.mtk.map.SmsController
 *  com.lianhezhuli.btnotification.mtk.service.MainService
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.map;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Xml;
import com.lianhezhuli.btnotification.MApplication;
import com.lianhezhuli.btnotification.mtk.map.MapConstants;
import com.lianhezhuli.btnotification.mtk.map.MessageList;
import com.lianhezhuli.btnotification.mtk.map.MessageListItem;
import com.lianhezhuli.btnotification.mtk.map.SmsController;
import com.lianhezhuli.btnotification.mtk.service.MainService;
import com.orhanobut.logger.Logger;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlSerializer;

public class BTMapService
extends BroadcastReceiver {
    private static final String TAG = "BTMapService";
    private static final String TELECOM_MSG_INBOX = "telecom/msg/inbox";
    private static final Context mContext = MApplication.getInstance().getApplicationContext();
    public static final ArrayList<Long> mKeys;
    private static final SmsController mSmsController;
    private String mFolder = "telecom/msg/inbox";
    private String mMapCommand = null;
    private String mMapDisconnect = null;

    static {
        mSmsController = new SmsController(mContext);
        mKeys = new ArrayList();
    }

    public BTMapService() {
        Logger.e((String)"BTMapReceiver(), BTMapReceiver created!", (Object[])new Object[0]);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    private byte[] genXmlBufferOfMsgList(MessageList object) {
        int n;
        MessageListItem[] messageListItemArray;
        StringWriter stringWriter;
        XmlSerializer xmlSerializer = Xml.newSerializer();
        try {
            stringWriter = new StringWriter();
            xmlSerializer.setOutput(stringWriter);
            xmlSerializer.startDocument("UTF-8", false);
            xmlSerializer.startTag(null, "MAP-msg-listing");
            xmlSerializer.attribute(null, "version", "1.0");
            messageListItemArray = object.generateMessageItemArray();
            n = messageListItemArray.length;
        }
        catch (Exception exception) {
            Logger.e((String)"error occurred while creating xml file", (Object[])new Object[0]);
            return null;
        }
        for (int i = 0; i < n; ++i) {
            object = messageListItemArray[i];
            {
                xmlSerializer.startTag(null, "msg");
                ArrayList arrayList = object.getMessageItem();
                for (int j = 0; j < arrayList.size(); ++j) {
                    String string = (String)arrayList.get(j);
                    object = string;
                    if (string == null) {
                        object = "";
                    }
                    xmlSerializer.attribute(null, (String)MapConstants.messageItemField.get(j), (String)object);
                }
            }
            {
                xmlSerializer.endTag(null, "msg");
                continue;
            }
        }
        {
            xmlSerializer.endTag(null, "MAP-msg-listing");
            xmlSerializer.endDocument();
            xmlSerializer.flush();
            object = stringWriter.toString().getBytes("UTF-8");
            return object;
        }
    }

    private void handleGetList(MainService mainService, String[] object) {
        int n = Integer.valueOf(object[2]);
        int n2 = Integer.valueOf(object[4]);
        object = this.mFolder.equals("outbox") ? mSmsController.getMessageList(n, n2, "failed") : mSmsController.getMessageList(n, n2, this.mFolder);
        object = this.genXmlBufferOfMsgList((MessageList)object);
        n2 = 0;
        if (object != null) {
            n2 = ((MessageList)object).length;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("3 2 0 ");
        stringBuilder.append(n2);
        stringBuilder.append(" ");
        mainService.sendMapDResult(stringBuilder.toString());
        if (object == null) {
            object = new byte[1];
        }
        mainService.sendMapData((byte[])object);
    }

    /*
     * Enabled force condition propagation
     */
    private void handleGetMsg(MainService mainService, String[] object) {
        if ((object = mSmsController.getMessage(Long.valueOf((String)object[2]).longValue())) == null) {
            mainService.sendMapResult(String.valueOf(-4));
            return;
        }
        try {
            byte[] byArray = object.toString().getBytes("UTF-8");
            object = new StringBuilder();
            ((StringBuilder)object).append(String.valueOf(4));
            ((StringBuilder)object).append(" 2 1 ");
            ((StringBuilder)object).append(String.valueOf(byArray.length));
            ((StringBuilder)object).append(" ");
            mainService.sendMapDResult(((StringBuilder)object).toString());
            mainService.sendMapData(byArray);
            return;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return;
        }
    }

    private void handlePushMsg(MainService mainService, String string) {
        String string2;
        String string3 = this.parse(string);
        int n = string.indexOf("BEGIN:MSG\r\n") + 11;
        int n2 = string.indexOf("\r\nEND:MSG");
        Logger.e((String)"send msg result success", (Object[])new Object[0]);
        if (n > n2) {
            mainService.sendMapResult(String.valueOf(-6));
            return;
        }
        string = string2 = string.substring(n, n2);
        if (string2.equals("")) {
            string = "\n";
        }
        Logger.e((String)"send msg result success", (Object[])new Object[0]);
        mainService.sendMapResult(String.valueOf(6));
        mSmsController.pushMessage(string3, string);
    }

    private void handleSetFolder(MainService mainService, String[] stringArray) {
        this.mFolder = stringArray[3];
        SmsController.mAddress = null;
        SmsController.mPerson = null;
        mKeys.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Set Folder the folder is :");
        stringBuilder.append(stringArray[3]);
        Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        mainService.sendMapResult(String.valueOf(1));
    }

    private void handleSetStatus(MainService mainService, String[] stringArray) {
        if (stringArray.length < 3) {
            return;
        }
        int n = Integer.valueOf(stringArray[1]);
        long l = Long.valueOf(stringArray[2]) & 0xFFFFFFFFFFFFFFFL;
        if (n != 1 && n != 0) {
            if (mKeys.contains(l)) {
                Logger.e((String)"BTMapReceiver(), The message has been deleted!", (Object[])new Object[0]);
                mainService.sendMapResult(String.valueOf(5));
                return;
            }
            mSmsController.deleteMessage(l);
        } else {
            mSmsController.setMessageStatus(l, n);
        }
    }

    private String parse(String string) {
        String[] stringArray = string.split("\r\n");
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            Object object = stringArray[n2].split(":");
            if (((String[])object).length >= 2) {
                string = object[0].trim();
                object = object[1].trim();
                if (string.equals("TEL")) {
                    return object;
                }
            }
            ++n2;
        }
        return null;
    }

    public void onReceive(Context object, Intent intent) {
        if (!"com.lianhezhuli.map.BT_MAP_COMMAND_ARRIVE".equals(intent.getAction())) return;
        if (intent.hasExtra("DISCONNECT")) {
            object = intent.getStringExtra("DISCONNECT");
            this.mMapDisconnect = object;
            if (((String)object).equals("DISCONNECT")) {
                mSmsController.onStop();
                return;
            }
        }
        try {
            this.mMapCommand = object = new String(intent.getByteArrayExtra("EXTRA_DATA"), "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
        intent = MainService.getInstance();
        object = this.mMapCommand.split(" ");
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("BTMapService onReceive(), commands :");
            stringBuilder.append(this.mMapCommand);
            Logger.e((String)stringBuilder.toString(), (Object[])new Object[0]);
        }
        catch (Exception exception) {
            exception.getStackTrace();
        }
        int n = Integer.valueOf((String)object[0]);
        if (n != 1) {
            if (n != 3) {
                if (n != 4) {
                    if (n != 5) {
                        if (n != 6) return;
                        this.handlePushMsg((MainService)intent, this.mMapCommand);
                    } else {
                        this.handleSetStatus((MainService)intent, (String[])object);
                    }
                } else {
                    this.handleGetMsg((MainService)intent, (String[])object);
                }
            } else {
                this.handleGetList((MainService)intent, (String[])object);
            }
        } else {
            this.handleSetFolder((MainService)intent, (String[])object);
        }
    }
}
