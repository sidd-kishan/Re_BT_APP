/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.RoomDatabase
 *  androidx.sqlite.db.SupportSQLiteStatement
 */
package androidx.room;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class SharedSQLiteStatement {
    private final RoomDatabase mDatabase;
    private final AtomicBoolean mLock = new AtomicBoolean(false);
    private volatile SupportSQLiteStatement mStmt;

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        this.mDatabase = roomDatabase;
    }

    private SupportSQLiteStatement createNewStatement() {
        String string = this.createQuery();
        return this.mDatabase.compileStatement(string);
    }

    private SupportSQLiteStatement getStmt(boolean bl) {
        SupportSQLiteStatement supportSQLiteStatement;
        if (bl) {
            if (this.mStmt == null) {
                this.mStmt = this.createNewStatement();
            }
            supportSQLiteStatement = this.mStmt;
        } else {
            supportSQLiteStatement = this.createNewStatement();
        }
        return supportSQLiteStatement;
    }

    public SupportSQLiteStatement acquire() {
        this.assertNotMainThread();
        return this.getStmt(this.mLock.compareAndSet(false, true));
    }

    protected void assertNotMainThread() {
        this.mDatabase.assertNotMainThread();
    }

    protected abstract String createQuery();

    public void release(SupportSQLiteStatement supportSQLiteStatement) {
        if (supportSQLiteStatement != this.mStmt) return;
        this.mLock.set(false);
    }
}
