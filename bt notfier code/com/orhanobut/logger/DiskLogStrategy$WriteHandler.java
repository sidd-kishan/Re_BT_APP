/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  com.orhanobut.logger.Utils
 */
package com.orhanobut.logger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.orhanobut.logger.Utils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

static class DiskLogStrategy.WriteHandler
extends Handler {
    private final String folder;
    private final int maxFileSize;

    DiskLogStrategy.WriteHandler(Looper looper, String string, int n) {
        super((Looper)Utils.checkNotNull((Object)looper));
        this.folder = (String)Utils.checkNotNull((Object)string);
        this.maxFileSize = n;
    }

    private File getLogFile(String object, String string) {
        Utils.checkNotNull((Object)object);
        Utils.checkNotNull((Object)string);
        File file = new File((String)object);
        if (!file.exists()) {
            file.mkdirs();
        }
        Object object2 = null;
        object = new File(file, String.format("%s_%s.csv", string, 0));
        int n = 0;
        while (true) {
            Object object3 = object2;
            object2 = object;
            if (!((File)object2).exists()) {
                if (object3 == null) return object2;
                if (((File)object3).length() < (long)this.maxFileSize) return object3;
                return object2;
            }
            object = new File(file, String.format("%s_%s.csv", string, ++n));
        }
    }

    private void writeLog(FileWriter fileWriter, String string) throws IOException {
        Utils.checkNotNull((Object)fileWriter);
        Utils.checkNotNull((Object)string);
        fileWriter.append(string);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    public void handleMessage(Message object) {
        void var1_5;
        block6: {
            FileWriter fileWriter;
            String string = (String)object.obj;
            File file = this.getLogFile(this.folder, "logs");
            Object var1_2 = null;
            try {
                fileWriter = new FileWriter(file, true);
            }
            catch (IOException iOException) {
                // empty catch block
                break block6;
            }
            try {
                this.writeLog(fileWriter, string);
                fileWriter.flush();
                fileWriter.close();
                return;
            }
            catch (IOException iOException) {
                FileWriter fileWriter2 = fileWriter;
            }
        }
        if (var1_5 == null) return;
        try {
            var1_5.flush();
            var1_5.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }
}
