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
import java.util.HashMap;
import java.util.Map;

public final class AppList {
    public static final CharSequence BETTRYLOW_APPID = "com.lianhezhuli.btnotification.batterylow";
    public static final int CREATE_LENTH = 3;
    private static final AppList INSTANCE;
    private static final String LOG_TAG = "AppList";
    public static final String MAX_APP = "MaxApp";
    private static final String SAVE_FILE_NAME = "AppList";
    public static final CharSequence SMSRESULT_APPID;
    private Map<Object, Object> mAppList = null;
    private Context mContext = null;

    static {
        SMSRESULT_APPID = "com.lianhezhuli.btnotification.smsresult";
        INSTANCE = new AppList();
    }

    private AppList() {
        Logger.i((String)"AppList(), AppList created!", (Object[])new Object[0]);
        this.mContext = MApplication.getInstance().getApplicationContext();
    }

    public static AppList getInstance() {
        return INSTANCE;
    }

    private void loadAppListFromFile() {
        Logger.i((String)"loadIgnoreListFromFile(),  file_name= AppList", (Object[])new Object[0]);
        if (this.mAppList == null) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(this.mContext.openFileInput("AppList"));
                this.mAppList = (Map)objectInputStream.readObject();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        }
        if (this.mAppList != null) return;
        this.mAppList = new HashMap<Object, Object>();
    }

    public Map<Object, Object> getAppList() {
        if (this.mAppList != null) return this.mAppList;
        this.loadAppListFromFile();
        return this.mAppList;
    }

    public void saveAppList(Map<Object, Object> object) {
        Logger.i((String)"setIgnoreList(),  file_name= AppList", (Object[])new Object[0]);
        try {
            FileOutputStream fileOutputStream = this.mContext.openFileOutput("AppList", 0);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.mAppList);
            objectOutputStream.close();
            fileOutputStream.close();
            this.mAppList = object;
            object = new StringBuilder();
            ((StringBuilder)object).append("setIgnoreList(),  mIgnoreList= ");
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
        ((StringBuilder)object).append(this.mAppList);
        Logger.i((String)((StringBuilder)object).toString(), (Object[])new Object[0]);
    }
}
