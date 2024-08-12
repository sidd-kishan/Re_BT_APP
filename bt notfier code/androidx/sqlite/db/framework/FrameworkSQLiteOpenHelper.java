/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  androidx.sqlite.db.SupportSQLiteDatabase
 *  androidx.sqlite.db.SupportSQLiteOpenHelper
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Callback
 *  androidx.sqlite.db.framework.FrameworkSQLiteDatabase
 *  androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper
 */
package androidx.sqlite.db.framework;

import android.content.Context;
import android.os.Build;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import java.io.File;

class FrameworkSQLiteOpenHelper
implements SupportSQLiteOpenHelper {
    private final SupportSQLiteOpenHelper.Callback mCallback;
    private final Context mContext;
    private OpenHelper mDelegate;
    private final Object mLock;
    private final String mName;
    private final boolean mUseNoBackupDirectory;
    private boolean mWriteAheadLoggingEnabled;

    FrameworkSQLiteOpenHelper(Context context, String string, SupportSQLiteOpenHelper.Callback callback) {
        this(context, string, callback, false);
    }

    FrameworkSQLiteOpenHelper(Context context, String string, SupportSQLiteOpenHelper.Callback callback, boolean bl) {
        this.mContext = context;
        this.mName = string;
        this.mCallback = callback;
        this.mUseNoBackupDirectory = bl;
        this.mLock = new Object();
    }

    private OpenHelper getDelegate() {
        Object object = this.mLock;
        synchronized (object) {
            OpenHelper openHelper;
            if (this.mDelegate == null) {
                openHelper = new FrameworkSQLiteDatabase[1];
                if (Build.VERSION.SDK_INT >= 23 && this.mName != null && this.mUseNoBackupDirectory) {
                    OpenHelper openHelper2;
                    File file = new File(this.mContext.getNoBackupFilesDir(), this.mName);
                    this.mDelegate = openHelper2 = new OpenHelper(this.mContext, file.getAbsolutePath(), (FrameworkSQLiteDatabase[])openHelper, this.mCallback);
                } else {
                    OpenHelper openHelper3;
                    this.mDelegate = openHelper3 = new OpenHelper(this.mContext, this.mName, (FrameworkSQLiteDatabase[])openHelper, this.mCallback);
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    this.mDelegate.setWriteAheadLoggingEnabled(this.mWriteAheadLoggingEnabled);
                }
            }
            openHelper = this.mDelegate;
            return openHelper;
        }
    }

    public void close() {
        this.getDelegate().close();
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        return this.getDelegate().getReadableSupportDatabase();
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        return this.getDelegate().getWritableSupportDatabase();
    }

    public void setWriteAheadLoggingEnabled(boolean bl) {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mDelegate != null) {
                this.mDelegate.setWriteAheadLoggingEnabled(bl);
            }
            this.mWriteAheadLoggingEnabled = bl;
            return;
        }
    }
}
