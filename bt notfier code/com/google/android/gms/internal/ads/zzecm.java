/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteOpenHelper
 */
package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class zzecm
extends SQLiteOpenHelper {
    public zzecm(Context context) {
        super(context, "OfflineUpload.db", null, 1);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_signal_contents (timestamp INTEGER PRIMARY_KEY, serialized_proto_data BLOB)");
        sQLiteDatabase.execSQL("CREATE TABLE offline_signal_statistics (statistic_name TEXT PRIMARY_KEY, value INTEGER)");
        ContentValues contentValues = new ContentValues();
        contentValues.put("statistic_name", "failed_requests");
        Integer n = 0;
        contentValues.put("value", n);
        sQLiteDatabase.insert("offline_signal_statistics", null, contentValues);
        contentValues = new ContentValues();
        contentValues.put("statistic_name", "total_requests");
        contentValues.put("value", n);
        sQLiteDatabase.insert("offline_signal_statistics", null, contentValues);
        n = new ContentValues();
        n.put("statistic_name", "last_successful_request_time");
        n.put("value", 0L);
        sQLiteDatabase.insert("offline_signal_statistics", null, (ContentValues)n);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int n, int n2) {
        this.onUpgrade(sQLiteDatabase, n, n2);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int n, int n2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_signal_contents");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_signal_statistics");
    }
}
