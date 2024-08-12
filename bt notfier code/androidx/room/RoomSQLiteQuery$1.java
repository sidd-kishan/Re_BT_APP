/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.RoomSQLiteQuery
 *  androidx.sqlite.db.SupportSQLiteProgram
 */
package androidx.room;

import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteProgram;

static final class RoomSQLiteQuery.1
implements SupportSQLiteProgram {
    final RoomSQLiteQuery val$query;

    RoomSQLiteQuery.1(RoomSQLiteQuery roomSQLiteQuery) {
        this.val$query = roomSQLiteQuery;
    }

    public void bindBlob(int n, byte[] byArray) {
        this.val$query.bindBlob(n, byArray);
    }

    public void bindDouble(int n, double d) {
        this.val$query.bindDouble(n, d);
    }

    public void bindLong(int n, long l) {
        this.val$query.bindLong(n, l);
    }

    public void bindNull(int n) {
        this.val$query.bindNull(n);
    }

    public void bindString(int n, String string) {
        this.val$query.bindString(n, string);
    }

    public void clearBindings() {
        this.val$query.clearBindings();
    }

    public void close() {
    }
}
