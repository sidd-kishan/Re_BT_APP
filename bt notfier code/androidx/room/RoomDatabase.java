/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.os.Looper
 *  androidx.room.DatabaseConfiguration
 *  androidx.room.InvalidationTracker
 *  androidx.room.RoomDatabase$Callback
 *  androidx.room.RoomDatabase$JournalMode
 *  androidx.room.SQLiteCopyOpenHelper
 *  androidx.room.TransactionExecutor
 *  androidx.sqlite.db.SimpleSQLiteQuery
 *  androidx.sqlite.db.SupportSQLiteDatabase
 *  androidx.sqlite.db.SupportSQLiteOpenHelper
 *  androidx.sqlite.db.SupportSQLiteQuery
 *  androidx.sqlite.db.SupportSQLiteStatement
 */
package androidx.room;

import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Looper;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.SQLiteCopyOpenHelper;
import androidx.room.TransactionExecutor;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class RoomDatabase {
    private static final String DB_IMPL_SUFFIX = "_Impl";
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;
    private final Map<String, Object> mBackingFieldMap;
    @Deprecated
    protected List<Callback> mCallbacks;
    private final ReentrantReadWriteLock mCloseLock = new ReentrantReadWriteLock();
    @Deprecated
    protected volatile SupportSQLiteDatabase mDatabase;
    private final InvalidationTracker mInvalidationTracker;
    private SupportSQLiteOpenHelper mOpenHelper;
    private Executor mQueryExecutor;
    private final ThreadLocal<Integer> mSuspendingTransactionId = new ThreadLocal();
    private Executor mTransactionExecutor;
    boolean mWriteAheadLoggingEnabled;

    public RoomDatabase() {
        this.mBackingFieldMap = new ConcurrentHashMap<String, Object>();
        this.mInvalidationTracker = this.createInvalidationTracker();
    }

    private static boolean isMainThread() {
        boolean bl = Looper.getMainLooper().getThread() == Thread.currentThread();
        return bl;
    }

    public void assertNotMainThread() {
        if (this.mAllowMainThreadQueries) {
            return;
        }
        if (RoomDatabase.isMainThread()) throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
    }

    public void assertNotSuspendingTransaction() {
        if (this.inTransaction()) return;
        if (this.mSuspendingTransactionId.get() != null) throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
    }

    @Deprecated
    public void beginTransaction() {
        this.assertNotMainThread();
        SupportSQLiteDatabase supportSQLiteDatabase = this.mOpenHelper.getWritableDatabase();
        this.mInvalidationTracker.syncTriggers(supportSQLiteDatabase);
        supportSQLiteDatabase.beginTransaction();
    }

    public abstract void clearAllTables();

    public void close() {
        if (!this.isOpen()) return;
        ReentrantReadWriteLock.WriteLock writeLock = this.mCloseLock.writeLock();
        try {
            writeLock.lock();
            this.mInvalidationTracker.stopMultiInstanceInvalidation();
            this.mOpenHelper.close();
        }
        finally {
            writeLock.unlock();
        }
    }

    public SupportSQLiteStatement compileStatement(String string) {
        this.assertNotMainThread();
        this.assertNotSuspendingTransaction();
        return this.mOpenHelper.getWritableDatabase().compileStatement(string);
    }

    protected abstract InvalidationTracker createInvalidationTracker();

    protected abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration var1);

    @Deprecated
    public void endTransaction() {
        this.mOpenHelper.getWritableDatabase().endTransaction();
        if (this.inTransaction()) return;
        this.mInvalidationTracker.refreshVersionsAsync();
    }

    Map<String, Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    public InvalidationTracker getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        return this.mOpenHelper;
    }

    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    public boolean inTransaction() {
        return this.mOpenHelper.getWritableDatabase().inTransaction();
    }

    public void init(DatabaseConfiguration databaseConfiguration) {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper;
        this.mOpenHelper = supportSQLiteOpenHelper = this.createOpenHelper(databaseConfiguration);
        if (supportSQLiteOpenHelper instanceof SQLiteCopyOpenHelper) {
            ((SQLiteCopyOpenHelper)supportSQLiteOpenHelper).setDatabaseConfiguration(databaseConfiguration);
        }
        int n = Build.VERSION.SDK_INT;
        boolean bl = false;
        boolean bl2 = false;
        if (n >= 16) {
            bl = bl2;
            if (databaseConfiguration.journalMode == JournalMode.WRITE_AHEAD_LOGGING) {
                bl = true;
            }
            this.mOpenHelper.setWriteAheadLoggingEnabled(bl);
        }
        this.mCallbacks = databaseConfiguration.callbacks;
        this.mQueryExecutor = databaseConfiguration.queryExecutor;
        this.mTransactionExecutor = new TransactionExecutor(databaseConfiguration.transactionExecutor);
        this.mAllowMainThreadQueries = databaseConfiguration.allowMainThreadQueries;
        this.mWriteAheadLoggingEnabled = bl;
        if (!databaseConfiguration.multiInstanceInvalidation) return;
        this.mInvalidationTracker.startMultiInstanceInvalidation(databaseConfiguration.context, databaseConfiguration.name);
    }

    protected void internalInitInvalidationTracker(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.mInvalidationTracker.internalInit(supportSQLiteDatabase);
    }

    public boolean isOpen() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.mDatabase;
        boolean bl = supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen();
        return bl;
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        return this.query(supportSQLiteQuery, null);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        this.assertNotMainThread();
        this.assertNotSuspendingTransaction();
        if (cancellationSignal == null) return this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery);
        if (Build.VERSION.SDK_INT < 16) return this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery);
        return this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery, cancellationSignal);
    }

    public Cursor query(String string, Object[] objectArray) {
        return this.mOpenHelper.getWritableDatabase().query((SupportSQLiteQuery)new SimpleSQLiteQuery(string, objectArray));
    }

    /*
     * Exception decompiling
     */
    public <V> V runInTransaction(Callable<V> var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [3 : 26->30)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void runInTransaction(Runnable runnable) {
        this.beginTransaction();
        try {
            runnable.run();
            this.setTransactionSuccessful();
            return;
        }
        finally {
            this.endTransaction();
        }
    }

    @Deprecated
    public void setTransactionSuccessful() {
        this.mOpenHelper.getWritableDatabase().setTransactionSuccessful();
    }
}
