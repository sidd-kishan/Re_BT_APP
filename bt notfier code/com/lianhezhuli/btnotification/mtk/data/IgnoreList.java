/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.lianhezhuli.btnotification.MApplication
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.mtk.data;

import android.content.Context;
import com.lianhezhuli.btnotification.MApplication;
import com.orhanobut.logger.Logger;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

public final class IgnoreList {
    private static final String[] EXCLUSION_LIST = new String[]{"android", "com.android.mms", "com.android.phone", "com.android.providers.downloads", "com.android.bluetooth", "com.mediatek.bluetooth", "com.htc.music", "com.lge.music", "com.sec.android.app.music", "com.sonyericsson.music", "com.ijinshan.mguard"};
    private static final IgnoreList INSTANCE = new IgnoreList();
    private static final String LOG_TAG = "IgnoreList";
    private static final String SAVE_FILE_NAME = "IgnoreList";
    private Context mContext = null;
    private HashSet<String> mIgnoreList = null;

    private IgnoreList() {
        Logger.i((String)"IgnoreList(), IgnoreList created!", (Object[])new Object[0]);
        this.mContext = MApplication.getInstance().getApplicationContext();
    }

    public static IgnoreList getInstance() {
        return INSTANCE;
    }

    private void loadIgnoreListFromFile() {
        Logger.i((String)"loadIgnoreListFromFile(),  file_name= IgnoreList", (Object[])new Object[0]);
        if (this.mIgnoreList == null) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(this.mContext.openFileInput("IgnoreList"));
                this.mIgnoreList = (HashSet)objectInputStream.readObject();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        }
        if (this.mIgnoreList != null) return;
        this.mIgnoreList = new HashSet();
    }

    public HashSet<String> getExclusionList() {
        HashSet<String> hashSet = new HashSet<String>();
        String[] stringArray = EXCLUSION_LIST;
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            hashSet.add(stringArray[n2]);
            ++n2;
        }
        return hashSet;
    }

    public HashSet<String> getIgnoreList() {
        if (this.mIgnoreList != null) return this.mIgnoreList;
        this.loadIgnoreListFromFile();
        return this.mIgnoreList;
    }

    public void saveIgnoreList(HashSet<String> serializable) {
        Logger.i((String)"setIgnoreList(),  file_name= IgnoreList", (Object[])new Object[0]);
        try {
            FileOutputStream fileOutputStream = this.mContext.openFileOutput("IgnoreList", 0);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            fileOutputStream.close();
            this.mIgnoreList = serializable;
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("setIgnoreList(),  mIgnoreList= ");
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
        ((StringBuilder)serializable).append(this.mIgnoreList);
        Logger.i((String)((StringBuilder)serializable).toString(), (Object[])new Object[0]);
    }
}
