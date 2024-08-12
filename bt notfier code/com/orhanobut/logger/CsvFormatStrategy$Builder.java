/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 *  android.os.Handler
 *  android.os.HandlerThread
 *  com.orhanobut.logger.CsvFormatStrategy
 *  com.orhanobut.logger.DiskLogStrategy
 *  com.orhanobut.logger.DiskLogStrategy$WriteHandler
 *  com.orhanobut.logger.LogStrategy
 */
package com.orhanobut.logger;

import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import com.orhanobut.logger.CsvFormatStrategy;
import com.orhanobut.logger.DiskLogStrategy;
import com.orhanobut.logger.LogStrategy;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public static final class CsvFormatStrategy.Builder {
    private static final int MAX_BYTES = 512000;
    Date date;
    SimpleDateFormat dateFormat;
    LogStrategy logStrategy;
    String tag = "PRETTY_LOGGER";

    private CsvFormatStrategy.Builder() {
    }

    public CsvFormatStrategy build() {
        if (this.date == null) {
            this.date = new Date();
        }
        if (this.dateFormat == null) {
            this.dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS", Locale.UK);
        }
        if (this.logStrategy != null) return new CsvFormatStrategy(this, null);
        String string = Environment.getExternalStorageDirectory().getAbsolutePath();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(File.separatorChar);
        stringBuilder.append("logger");
        string = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("AndroidFileLogger.");
        stringBuilder.append(string);
        stringBuilder = new HandlerThread(stringBuilder.toString());
        stringBuilder.start();
        this.logStrategy = new DiskLogStrategy((Handler)new DiskLogStrategy.WriteHandler(stringBuilder.getLooper(), string, 512000));
        return new CsvFormatStrategy(this, null);
    }

    public CsvFormatStrategy.Builder date(Date date) {
        this.date = date;
        return this;
    }

    public CsvFormatStrategy.Builder dateFormat(SimpleDateFormat simpleDateFormat) {
        this.dateFormat = simpleDateFormat;
        return this;
    }

    public CsvFormatStrategy.Builder logStrategy(LogStrategy logStrategy) {
        this.logStrategy = logStrategy;
        return this;
    }

    public CsvFormatStrategy.Builder tag(String string) {
        this.tag = string;
        return this;
    }
}
