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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class EntityInsertionAdapter<T>
extends SharedSQLiteStatement {
    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    protected abstract void bind(SupportSQLiteStatement var1, T var2);

    public final void insert(Iterable<? extends T> object) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            object = object.iterator();
            while (object.hasNext()) {
                this.bind(supportSQLiteStatement, object.next());
                supportSQLiteStatement.executeInsert();
            }
            return;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final void insert(T t) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            this.bind(supportSQLiteStatement, t);
            supportSQLiteStatement.executeInsert();
            return;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final void insert(T[] TArray) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            int n = TArray.length;
            int n2 = 0;
            while (n2 < n) {
                this.bind(supportSQLiteStatement, TArray[n2]);
                supportSQLiteStatement.executeInsert();
                ++n2;
            }
            return;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final long insertAndReturnId(T t) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            this.bind(supportSQLiteStatement, t);
            long l = supportSQLiteStatement.executeInsert();
            return l;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> object) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            long[] lArray = new long[object.size()];
            int n = 0;
            object = object.iterator();
            while (object.hasNext()) {
                this.bind(supportSQLiteStatement, object.next());
                lArray[n] = supportSQLiteStatement.executeInsert();
                ++n;
            }
            return lArray;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] TArray) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            long[] lArray = new long[TArray.length];
            int n = TArray.length;
            int n2 = 0;
            int n3 = 0;
            while (n2 < n) {
                this.bind(supportSQLiteStatement, TArray[n2]);
                lArray[n3] = supportSQLiteStatement.executeInsert();
                ++n3;
                ++n2;
            }
            return lArray;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> object) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            Long[] longArray = new Long[object.size()];
            int n = 0;
            object = object.iterator();
            while (object.hasNext()) {
                this.bind(supportSQLiteStatement, object.next());
                longArray[n] = supportSQLiteStatement.executeInsert();
                ++n;
            }
            return longArray;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] TArray) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            Long[] longArray = new Long[TArray.length];
            int n = TArray.length;
            int n2 = 0;
            int n3 = 0;
            while (n2 < n) {
                this.bind(supportSQLiteStatement, TArray[n2]);
                longArray[n3] = supportSQLiteStatement.executeInsert();
                ++n3;
                ++n2;
            }
            return longArray;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> object) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            ArrayList<Long> arrayList = new ArrayList<Long>(object.size());
            int n = 0;
            object = object.iterator();
            while (object.hasNext()) {
                this.bind(supportSQLiteStatement, object.next());
                arrayList.add(n, supportSQLiteStatement.executeInsert());
                ++n;
            }
            return arrayList;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] TArray) {
        SupportSQLiteStatement supportSQLiteStatement = this.acquire();
        try {
            ArrayList<Long> arrayList = new ArrayList<Long>(TArray.length);
            int n = TArray.length;
            int n2 = 0;
            int n3 = 0;
            while (n2 < n) {
                this.bind(supportSQLiteStatement, TArray[n2]);
                arrayList.add(n3, supportSQLiteStatement.executeInsert());
                ++n3;
                ++n2;
            }
            return arrayList;
        }
        finally {
            this.release(supportSQLiteStatement);
        }
    }
}
