/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.SQLiteCopyOpenHelper
 *  androidx.sqlite.db.SupportSQLiteOpenHelper
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Factory
 */
package androidx.room;

import androidx.room.SQLiteCopyOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;

class SQLiteCopyOpenHelperFactory
implements SupportSQLiteOpenHelper.Factory {
    private final String mCopyFromAssetPath;
    private final File mCopyFromFile;
    private final SupportSQLiteOpenHelper.Factory mDelegate;

    SQLiteCopyOpenHelperFactory(String string, File file, SupportSQLiteOpenHelper.Factory factory) {
        this.mCopyFromAssetPath = string;
        this.mCopyFromFile = file;
        this.mDelegate = factory;
    }

    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new SQLiteCopyOpenHelper(configuration.context, this.mCopyFromAssetPath, this.mCopyFromFile, configuration.callback.version, this.mDelegate.create(configuration));
    }
}
