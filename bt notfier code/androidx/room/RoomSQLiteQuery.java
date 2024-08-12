/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.sqlite.db.SupportSQLiteProgram
 *  androidx.sqlite.db.SupportSQLiteQuery
 */
package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

public class RoomSQLiteQuery
implements SupportSQLiteQuery,
SupportSQLiteProgram {
    private static final int BLOB = 5;
    static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    static final TreeMap<Integer, RoomSQLiteQuery> sQueryPool = new TreeMap();
    int mArgCount;
    private final int[] mBindingTypes;
    final byte[][] mBlobBindings;
    final int mCapacity;
    final double[] mDoubleBindings;
    final long[] mLongBindings;
    private volatile String mQuery;
    final String[] mStringBindings;

    private RoomSQLiteQuery(int n) {
        this.mCapacity = n++;
        this.mBindingTypes = new int[n];
        this.mLongBindings = new long[n];
        this.mDoubleBindings = new double[n];
        this.mStringBindings = new String[n];
        this.mBlobBindings = new byte[n][];
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static RoomSQLiteQuery acquire(String string, int n) {
        Object object = sQueryPool;
        synchronized (object) {
            Object object2 = sQueryPool.ceilingEntry(n);
            if (object2 != null) {
                sQueryPool.remove(object2.getKey());
                object2 = object2.getValue();
                ((RoomSQLiteQuery)object2).init(string, n);
                return object2;
            }
        }
        object = new RoomSQLiteQuery(n);
        ((RoomSQLiteQuery)object).init(string, n);
        return object;
    }

    public static RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
        supportSQLiteQuery.bindTo((SupportSQLiteProgram)new /* Unavailable Anonymous Inner Class!! */);
        return roomSQLiteQuery;
    }

    private static void prunePoolLocked() {
        if (sQueryPool.size() <= 15) return;
        int n = sQueryPool.size() - 10;
        Iterator<Integer> iterator = sQueryPool.descendingKeySet().iterator();
        while (n > 0) {
            iterator.next();
            iterator.remove();
            --n;
        }
    }

    public void bindBlob(int n, byte[] byArray) {
        this.mBindingTypes[n] = 5;
        this.mBlobBindings[n] = byArray;
    }

    public void bindDouble(int n, double d) {
        this.mBindingTypes[n] = 3;
        this.mDoubleBindings[n] = d;
    }

    public void bindLong(int n, long l) {
        this.mBindingTypes[n] = 2;
        this.mLongBindings[n] = l;
    }

    public void bindNull(int n) {
        this.mBindingTypes[n] = 1;
    }

    public void bindString(int n, String string) {
        this.mBindingTypes[n] = 4;
        this.mStringBindings[n] = string;
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        int n = 1;
        while (n <= this.mArgCount) {
            int n2 = this.mBindingTypes[n];
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            if (n2 == 5) {
                                supportSQLiteProgram.bindBlob(n, this.mBlobBindings[n]);
                            }
                        } else {
                            supportSQLiteProgram.bindString(n, this.mStringBindings[n]);
                        }
                    } else {
                        supportSQLiteProgram.bindDouble(n, this.mDoubleBindings[n]);
                    }
                } else {
                    supportSQLiteProgram.bindLong(n, this.mLongBindings[n]);
                }
            } else {
                supportSQLiteProgram.bindNull(n);
            }
            ++n;
        }
    }

    public void clearBindings() {
        Arrays.fill(this.mBindingTypes, 1);
        Arrays.fill(this.mStringBindings, null);
        Arrays.fill((Object[])this.mBlobBindings, null);
        this.mQuery = null;
    }

    public void close() {
    }

    public void copyArgumentsFrom(RoomSQLiteQuery roomSQLiteQuery) {
        int n = roomSQLiteQuery.getArgCount() + 1;
        System.arraycopy(roomSQLiteQuery.mBindingTypes, 0, this.mBindingTypes, 0, n);
        System.arraycopy(roomSQLiteQuery.mLongBindings, 0, this.mLongBindings, 0, n);
        System.arraycopy(roomSQLiteQuery.mStringBindings, 0, this.mStringBindings, 0, n);
        System.arraycopy(roomSQLiteQuery.mBlobBindings, 0, this.mBlobBindings, 0, n);
        System.arraycopy(roomSQLiteQuery.mDoubleBindings, 0, this.mDoubleBindings, 0, n);
    }

    public int getArgCount() {
        return this.mArgCount;
    }

    public String getSql() {
        return this.mQuery;
    }

    void init(String string, int n) {
        this.mQuery = string;
        this.mArgCount = n;
    }

    public void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = sQueryPool;
        synchronized (treeMap) {
            sQueryPool.put(this.mCapacity, this);
            RoomSQLiteQuery.prunePoolLocked();
            return;
        }
    }
}
