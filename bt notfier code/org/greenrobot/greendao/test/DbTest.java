/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Instrumentation
 *  android.content.Context
 *  android.database.sqlite.SQLiteDatabase
 *  android.test.AndroidTestCase
 *  org.greenrobot.greendao.DaoLog
 *  org.greenrobot.greendao.DbUtils
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.database.StandardDatabase
 */
package org.greenrobot.greendao.test;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import java.util.Random;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.DbUtils;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.StandardDatabase;

public abstract class DbTest
extends AndroidTestCase {
    public static final String DB_NAME = "greendao-unittest-db.temp";
    private Application application;
    protected Database db;
    protected final boolean inMemory;
    protected final Random random;

    public DbTest() {
        this(true);
    }

    public DbTest(boolean bl) {
        this.inMemory = bl;
        this.random = new Random();
    }

    public <T extends Application> T createApplication(Class<T> clazz) {
        Application application;
        DbTest.assertNull((String)"Application already created", (Object)this.application);
        try {
            application = Instrumentation.newApplication(clazz, (Context)this.getContext());
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not create application ");
            stringBuilder.append(clazz);
            throw new RuntimeException(stringBuilder.toString(), exception);
        }
        application.onCreate();
        this.application = application;
        return (T)application;
    }

    protected Database createDatabase() {
        SQLiteDatabase sQLiteDatabase;
        if (this.inMemory) {
            sQLiteDatabase = SQLiteDatabase.create(null);
        } else {
            this.getContext().deleteDatabase(DB_NAME);
            sQLiteDatabase = this.getContext().openOrCreateDatabase(DB_NAME, 0, null);
        }
        return new StandardDatabase(sQLiteDatabase);
    }

    public <T extends Application> T getApplication() {
        DbTest.assertNotNull((String)"Application not yet created", (Object)this.application);
        return (T)this.application;
    }

    protected void logTableDump(String charSequence) {
        Database database = this.db;
        if (database instanceof StandardDatabase) {
            DbUtils.logTableDump((SQLiteDatabase)((StandardDatabase)database).getSQLiteDatabase(), (String)charSequence);
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Table dump unsupported for ");
            ((StringBuilder)charSequence).append(this.db);
            DaoLog.w((String)((StringBuilder)charSequence).toString());
        }
    }

    protected void setUp() throws Exception {
        super.setUp();
        this.db = this.createDatabase();
    }

    protected void tearDown() throws Exception {
        if (this.application != null) {
            this.terminateApplication();
        }
        this.db.close();
        if (!this.inMemory) {
            this.getContext().deleteDatabase(DB_NAME);
        }
        super.tearDown();
    }

    public void terminateApplication() {
        DbTest.assertNotNull((String)"Application not yet created", (Object)this.application);
        this.application.onTerminate();
        this.application = null;
    }
}
