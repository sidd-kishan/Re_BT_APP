/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteException
 *  android.util.Log
 *  androidx.room.InvalidationTracker
 *  androidx.room.InvalidationTracker$ObserverWrapper
 *  androidx.sqlite.db.SimpleSQLiteQuery
 *  androidx.sqlite.db.SupportSQLiteQuery
 */
package androidx.room;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class InvalidationTracker.1
implements Runnable {
    final InvalidationTracker this$0;

    InvalidationTracker.1(InvalidationTracker invalidationTracker) {
        this.this$0 = invalidationTracker;
    }

    private Set<Integer> checkUpdatedTable() {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        Cursor cursor = this.this$0.mDatabase.query((SupportSQLiteQuery)new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
        try {
            while (cursor.moveToNext()) {
                hashSet.add(cursor.getInt(0));
            }
        }
        finally {
            cursor.close();
        }
        if (hashSet.isEmpty()) return hashSet;
        this.this$0.mCleanupStatement.executeUpdateDelete();
        return hashSet;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    @Override
    public void run() {
        block20: {
            block19: {
                block18: {
                    block17: {
                        var7_1 = this.this$0.mDatabase.getCloseLock();
                        var5_2 = null;
                        var4_4 = null;
                        var6_7 = null;
                        var3_8 = var5_2;
                        var2_9 = var4_4;
                        try {
                            var7_1.lock();
                            var3_8 = var5_2;
                            var2_9 = var4_4;
                            var1_12 = this.this$0.ensureInitialization();
                            if (var1_12) break block17;
                        }
                        catch (SQLiteException var4_5) {
                            var2_9 = var3_8;
                            break block18;
                        }
                        catch (IllegalStateException var4_6) {
                            // empty catch block
                            break block18;
                        }
                        var7_1.unlock();
                        return;
                    }
                    var3_8 = var5_2;
                    var2_9 = var4_4;
                    try {
                        var1_12 = this.this$0.mPendingRefresh.compareAndSet(true, false);
                        if (!var1_12) {
                            var7_1.unlock();
                            return;
                        }
                        var3_8 = var5_2;
                        var2_9 = var4_4;
                    }
                    catch (Throwable var2_10) {}
                    var1_12 = this.this$0.mDatabase.inTransaction();
                    if (var1_12) {
                        var7_1.unlock();
                        return;
                    }
                    var3_8 = var5_2;
                    var2_9 = var4_4;
                    if (!this.this$0.mDatabase.mWriteAheadLoggingEnabled) ** GOTO lbl65
                    var3_8 = var5_2;
                    var2_9 = var4_4;
                    var8_13 = this.this$0.mDatabase.getOpenHelper().getWritableDatabase();
                    var3_8 = var5_2;
                    var2_9 = var4_4;
                    var8_13.beginTransaction();
                    var4_4 = var6_7;
                    var4_4 = var5_2 = this.checkUpdatedTable();
                    var8_13.setTransactionSuccessful();
                    var3_8 = var5_2;
                    var2_9 = var5_2;
                    {
                        catch (Throwable var5_3) {
                            var3_8 = var4_4;
                            var2_9 = var4_4;
                            var8_13.endTransaction();
                            var3_8 = var4_4;
                            var2_9 = var4_4;
                            throw var5_3;
                        }
                        var8_13.endTransaction();
                        var2_9 = var5_2;
                        break block19;
lbl65:
                        // 1 sources

                        var3_8 = var5_2;
                        var2_9 = var4_4;
                        var2_9 = var4_4 = this.checkUpdatedTable();
                        break block19;
                    }
                    break block20;
                }
                Log.e((String)"ROOM", (String)"Cannot run invalidation tracker. Is the db closed?", var4_4);
            }
            var7_1.unlock();
            if (var2_9 == null) return;
            if (var2_9.isEmpty() != false) return;
            var3_8 = this.this$0.mObserverMap;
            synchronized (var3_8) {
                var4_4 = this.this$0.mObserverMap.iterator();
                while (var4_4.hasNext() != false) {
                    ((InvalidationTracker.ObserverWrapper)((Map.Entry)var4_4.next()).getValue()).notifyByTableInvalidStatus((Set)var2_9);
                }
                return;
            }
        }
        var7_1.unlock();
        throw var2_10;
    }
}
