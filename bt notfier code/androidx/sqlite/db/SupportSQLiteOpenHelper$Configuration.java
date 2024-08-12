/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Callback
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration$Builder
 */
package androidx.sqlite.db;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

public static class SupportSQLiteOpenHelper.Configuration {
    public final SupportSQLiteOpenHelper.Callback callback;
    public final Context context;
    public final String name;
    public final boolean useNoBackupDirectory;

    SupportSQLiteOpenHelper.Configuration(Context context, String string, SupportSQLiteOpenHelper.Callback callback) {
        this(context, string, callback, false);
    }

    SupportSQLiteOpenHelper.Configuration(Context context, String string, SupportSQLiteOpenHelper.Callback callback, boolean bl) {
        this.context = context;
        this.name = string;
        this.callback = callback;
        this.useNoBackupDirectory = bl;
    }

    public static Builder builder(Context context) {
        return new Builder(context);
    }
}
