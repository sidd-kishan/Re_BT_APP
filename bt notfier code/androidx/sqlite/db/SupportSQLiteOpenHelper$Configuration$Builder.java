/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Callback
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration
 */
package androidx.sqlite.db;

import android.content.Context;
import android.text.TextUtils;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

public static class SupportSQLiteOpenHelper.Configuration.Builder {
    SupportSQLiteOpenHelper.Callback mCallback;
    Context mContext;
    String mName;
    boolean mUseNoBackUpDirectory;

    SupportSQLiteOpenHelper.Configuration.Builder(Context context) {
        this.mContext = context;
    }

    public SupportSQLiteOpenHelper.Configuration build() {
        if (this.mCallback == null) throw new IllegalArgumentException("Must set a callback to create the configuration.");
        if (this.mContext == null) throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
        if (!this.mUseNoBackUpDirectory) return new SupportSQLiteOpenHelper.Configuration(this.mContext, this.mName, this.mCallback, this.mUseNoBackUpDirectory);
        if (TextUtils.isEmpty((CharSequence)this.mName)) throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
        return new SupportSQLiteOpenHelper.Configuration(this.mContext, this.mName, this.mCallback, this.mUseNoBackUpDirectory);
    }

    public SupportSQLiteOpenHelper.Configuration.Builder callback(SupportSQLiteOpenHelper.Callback callback) {
        this.mCallback = callback;
        return this;
    }

    public SupportSQLiteOpenHelper.Configuration.Builder name(String string) {
        this.mName = string;
        return this;
    }

    public SupportSQLiteOpenHelper.Configuration.Builder noBackupDirectory(boolean bl) {
        this.mUseNoBackUpDirectory = bl;
        return this;
    }
}
