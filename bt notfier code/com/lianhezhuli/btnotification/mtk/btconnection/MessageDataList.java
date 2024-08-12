/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.btconnection;

import android.content.Context;
import com.orhanobut.logger.Logger;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

public class MessageDataList {
    private static final String Logger_TAG = "MessageDataList";
    private static final int MAX_MSG_COUNT = 5;
    private static final String SAVE_FILE_NAME = "MessageDataList";
    private Context mContext = null;
    private LinkedList<byte[]> mMsgList = null;

    public MessageDataList(Context context) {
        Logger.i((String)"MessageList(), MessageList created!", (Object[])new Object[0]);
        this.mContext = context;
        this.loadMessageDataList();
    }

    private void loadMessageDataList() {
        Logger.i((String)"loadMessageDataList(),  file_name= MessageDataList", (Object[])new Object[0]);
        try {
            Object object = new ObjectInputStream(this.mContext.openFileInput("MessageDataList"));
            object = ((ObjectInputStream)object).readObject();
            if (object instanceof LinkedList) {
                this.mMsgList = (LinkedList)object;
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        if (this.mMsgList != null) return;
        this.mMsgList = new LinkedList();
    }

    public List<byte[]> getMessageDataList() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getMessageDataList(), msgData=");
        stringBuilder.append(this.mMsgList);
        Logger.i((String)stringBuilder.toString(), (Object[])new Object[0]);
        if (this.mMsgList != null) return this.mMsgList;
        this.loadMessageDataList();
        return this.mMsgList;
    }

    public void saveMessageData(byte[] byArray) {
        if (this.mMsgList.size() >= 5) {
            this.mMsgList.remove(0);
        }
        this.mMsgList.add(byArray);
    }

    public void saveMessageDataList() {
        Object object;
        Logger.i((String)"saveMessageDataList(),  file_name= MessageDataList", (Object[])new Object[0]);
        if (this.mMsgList == null) {
            return;
        }
        try {
            object = this.mContext.openFileOutput("MessageDataList", 0);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream((OutputStream)object);
            objectOutputStream.writeObject(this.mMsgList);
            objectOutputStream.close();
            ((FileOutputStream)object).close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("saveMessageDataList(),  mMsgList= ");
        ((StringBuilder)object).append(this.mMsgList);
        Logger.i((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
    }
}
