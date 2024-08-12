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

public final class BlockList {
    private static final BlockList INSTANCE = new BlockList();
    private static final String LOG_TAG = "BlockList";
    private static final String SAVE_FILE_NAME = "BlockList";
    private HashSet<CharSequence> mBlockList = null;
    private Context mContext = null;

    private BlockList() {
        Logger.i((String)"BlockList(), BlockList created!", (Object[])new Object[0]);
        this.mContext = MApplication.getInstance().getApplicationContext();
    }

    public static BlockList getInstance() {
        return INSTANCE;
    }

    private void loadBlockListFromFile() {
        Logger.i((String)"loadIgnoreListFromFile(),  file_name= BlockList", (Object[])new Object[0]);
        if (this.mBlockList == null) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(this.mContext.openFileInput("BlockList"));
                this.mBlockList = (HashSet)objectInputStream.readObject();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        }
        if (this.mBlockList != null) return;
        this.mBlockList = new HashSet();
    }

    public HashSet<CharSequence> getBlockList() {
        if (this.mBlockList != null) return this.mBlockList;
        this.loadBlockListFromFile();
        return this.mBlockList;
    }

    public void saveBlockList(HashSet<CharSequence> serializable) {
        Logger.i((String)"setIgnoreList(),  file_name= BlockList", (Object[])new Object[0]);
        try {
            FileOutputStream fileOutputStream = this.mContext.openFileOutput("BlockList", 0);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            fileOutputStream.close();
            this.mBlockList = serializable;
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("setIgnoreList(),  mIgnoreList= ");
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
        ((StringBuilder)serializable).append(this.mBlockList);
        Logger.i((String)((StringBuilder)serializable).toString(), (Object[])new Object[0]);
    }
}
