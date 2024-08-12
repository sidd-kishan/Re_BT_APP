/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.sqlite.db.SupportSQLiteOpenHelper
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration$Builder
 *  androidx.sqlite.db.SupportSQLiteOpenHelper$Factory
 *  androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
 */
package androidx.work.impl;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;

class WorkDatabase.1
implements SupportSQLiteOpenHelper.Factory {
    final Context val$context;

    WorkDatabase.1(Context context) {
        this.val$context = context;
    }

    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        SupportSQLiteOpenHelper.Configuration.Builder builder = SupportSQLiteOpenHelper.Configuration.builder((Context)this.val$context);
        builder.name(configuration.name).callback(configuration.callback).noBackupDirectory(true);
        return new FrameworkSQLiteOpenHelperFactory().create(builder.build());
    }
}
