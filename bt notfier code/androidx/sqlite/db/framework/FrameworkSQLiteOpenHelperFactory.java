/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.sqlite.db.SupportSQLiteOpenHelper
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Factory
 *  androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper
 */
package androidx.sqlite.db.framework;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;

public final class FrameworkSQLiteOpenHelperFactory
implements SupportSQLiteOpenHelper.Factory {
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new FrameworkSQLiteOpenHelper(configuration.context, configuration.name, configuration.callback, configuration.useNoBackupDirectory);
    }
}
