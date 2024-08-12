/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.sqlite.db.SupportSQLiteDatabase
 */
package androidx.sqlite.db;

import androidx.sqlite.db.SupportSQLiteDatabase;
import java.io.Closeable;

public interface SupportSQLiteOpenHelper
extends Closeable {
    @Override
    public void close();

    public String getDatabaseName();

    public SupportSQLiteDatabase getReadableDatabase();

    public SupportSQLiteDatabase getWritableDatabase();

    public void setWriteAheadLoggingEnabled(boolean var1);
}
