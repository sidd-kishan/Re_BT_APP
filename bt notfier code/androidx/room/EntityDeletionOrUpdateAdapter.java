/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.RoomDatabase
 *  androidx.room.SharedSQLiteStatement
 *  androidx.sqlite.db.SupportSQLiteStatement
 */
package androidx.room;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;

public abstract class EntityDeletionOrUpdateAdapter<T>
extends SharedSQLiteStatement {
    public EntityDeletionOrUpdateAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    protected abstract void bind(SupportSQLiteStatement var1, T var2);

    protected abstract String createQuery();

    public final int handle(T t) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            this.bind(supportSQLiteStatement, t);
            int n = supportSQLiteStatement.executeUpdateDelete();
            return n;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final int handleMultiple(Iterable<? extends T> object) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        int n = 0;
        try {
            object = object.iterator();
            while (object.hasNext()) {
                this.bind(supportSQLiteStatement, object.next());
                int n2 = supportSQLiteStatement.executeUpdateDelete();
                n += n2;
            }
            return n;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final int handleMultiple(T[] TArray) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            int n = TArray.length;
            int n2 = 0;
            int n3 = 0;
            while (n2 < n) {
                this.bind(supportSQLiteStatement, TArray[n2]);
                int n4 = supportSQLiteStatement.executeUpdateDelete();
                n3 += n4;
                ++n2;
            }
            return n3;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }
}
