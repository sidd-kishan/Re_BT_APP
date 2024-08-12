/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.sqlite.SQLiteException
 *  android.util.Log
 *  androidx.arch.core.internal.SafeIterableMap
 *  androidx.lifecycle.LiveData
 *  androidx.room.InvalidationLiveDataContainer
 *  androidx.room.InvalidationTracker$ObservedTableTracker
 *  androidx.room.InvalidationTracker$Observer
 *  androidx.room.InvalidationTracker$ObserverWrapper
 *  androidx.room.InvalidationTracker$WeakObserver
 *  androidx.room.MultiInstanceInvalidationClient
 *  androidx.room.RoomDatabase
 *  androidx.sqlite.db.SupportSQLiteDatabase
 *  androidx.sqlite.db.SupportSQLiteStatement
 */
package androidx.room;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationLiveDataContainer;
import androidx.room.InvalidationTracker;
import androidx.room.MultiInstanceInvalidationClient;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ";
    static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String[] TRIGGERS = new String[]{"UPDATE", "DELETE", "INSERT"};
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    volatile SupportSQLiteStatement mCleanupStatement;
    final RoomDatabase mDatabase;
    private volatile boolean mInitialized = false;
    private final InvalidationLiveDataContainer mInvalidationLiveDataContainer;
    private MultiInstanceInvalidationClient mMultiInstanceInvalidationClient;
    private ObservedTableTracker mObservedTableTracker;
    final SafeIterableMap<Observer, ObserverWrapper> mObserverMap;
    AtomicBoolean mPendingRefresh = new AtomicBoolean(false);
    Runnable mRefreshRunnable;
    final HashMap<String, Integer> mTableIdLookup;
    final String[] mTableNames;
    private Map<String, Set<String>> mViewTables;

    public InvalidationTracker(RoomDatabase object, Map<String, String> object2, Map<String, Set<String>> object3, String ... object4) {
        this.mObserverMap = new SafeIterableMap();
        this.mRefreshRunnable = new /* Unavailable Anonymous Inner Class!! */;
        this.mDatabase = object;
        this.mObservedTableTracker = new ObservedTableTracker(((String[])object4).length);
        this.mTableIdLookup = new HashMap();
        this.mViewTables = object3;
        this.mInvalidationLiveDataContainer = new InvalidationLiveDataContainer(this.mDatabase);
        int n = ((String[])object4).length;
        this.mTableNames = new String[n];
        for (int i = 0; i < n; ++i) {
            object = object4[i].toLowerCase(Locale.US);
            this.mTableIdLookup.put((String)object, i);
            object3 = object2.get(object4[i]);
            this.mTableNames[i] = object3 != null ? ((String)object3).toLowerCase(Locale.US) : object;
        }
        object = object2.entrySet().iterator();
        while (object.hasNext()) {
            object3 = (Map.Entry)object.next();
            object2 = ((String)object3.getValue()).toLowerCase(Locale.US);
            if (!this.mTableIdLookup.containsKey(object2)) continue;
            object4 = ((String)object3.getKey()).toLowerCase(Locale.US);
            object3 = this.mTableIdLookup;
            ((HashMap)object3).put((String)object4, (Integer)((HashMap)object3).get(object2));
        }
    }

    public InvalidationTracker(RoomDatabase roomDatabase, String ... stringArray) {
        this(roomDatabase, new HashMap<String, String>(), Collections.emptyMap(), stringArray);
    }

    private static void appendTriggerName(StringBuilder stringBuilder, String string, String string2) {
        stringBuilder.append("`");
        stringBuilder.append("room_table_modification_trigger_");
        stringBuilder.append(string);
        stringBuilder.append("_");
        stringBuilder.append(string2);
        stringBuilder.append("`");
    }

    private String[] resolveViews(String[] stringArray) {
        HashSet<String> hashSet = new HashSet<String>();
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            String string = stringArray[n2];
            String string2 = string.toLowerCase(Locale.US);
            if (this.mViewTables.containsKey(string2)) {
                hashSet.addAll((Collection)this.mViewTables.get(string2));
            } else {
                hashSet.add(string);
            }
            ++n2;
        }
        return hashSet.toArray(new String[hashSet.size()]);
    }

    private void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int n) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("INSERT OR IGNORE INTO room_table_modification_log VALUES(");
        charSequence.append(n);
        charSequence.append(", 0)");
        supportSQLiteDatabase.execSQL(charSequence.toString());
        charSequence = this.mTableNames[n];
        StringBuilder stringBuilder = new StringBuilder();
        String[] stringArray = TRIGGERS;
        int n2 = stringArray.length;
        int n3 = 0;
        while (n3 < n2) {
            String string = stringArray[n3];
            stringBuilder.setLength(0);
            stringBuilder.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            InvalidationTracker.appendTriggerName(stringBuilder, (String)charSequence, string);
            stringBuilder.append(" AFTER ");
            stringBuilder.append(string);
            stringBuilder.append(" ON `");
            stringBuilder.append((String)charSequence);
            stringBuilder.append("` BEGIN UPDATE ");
            stringBuilder.append(UPDATE_TABLE_NAME);
            stringBuilder.append(" SET ");
            stringBuilder.append(INVALIDATED_COLUMN_NAME);
            stringBuilder.append(" = 1");
            stringBuilder.append(" WHERE ");
            stringBuilder.append(TABLE_ID_COLUMN_NAME);
            stringBuilder.append(" = ");
            stringBuilder.append(n);
            stringBuilder.append(" AND ");
            stringBuilder.append(INVALIDATED_COLUMN_NAME);
            stringBuilder.append(" = 0");
            stringBuilder.append("; END");
            supportSQLiteDatabase.execSQL(stringBuilder.toString());
            ++n3;
        }
    }

    private void stopTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int n) {
        String string = this.mTableNames[n];
        StringBuilder stringBuilder = new StringBuilder();
        String[] stringArray = TRIGGERS;
        int n2 = stringArray.length;
        n = 0;
        while (n < n2) {
            String string2 = stringArray[n];
            stringBuilder.setLength(0);
            stringBuilder.append("DROP TRIGGER IF EXISTS ");
            InvalidationTracker.appendTriggerName(stringBuilder, string, string2);
            supportSQLiteDatabase.execSQL(stringBuilder.toString());
            ++n;
        }
    }

    private String[] validateAndResolveTableNames(String[] object) {
        Object object2 = this.resolveViews((String[])object);
        int n = ((String[])object2).length;
        int n2 = 0;
        while (n2 < n) {
            object = object2[n2];
            if (!this.mTableIdLookup.containsKey(((String)object).toLowerCase(Locale.US))) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("There is no table with name ");
                ((StringBuilder)object2).append((String)object);
                throw new IllegalArgumentException(((StringBuilder)object2).toString());
            }
            ++n2;
        }
        return object2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public void addObserver(Observer object) {
        Object object2;
        SafeIterableMap<Observer, ObserverWrapper> safeIterableMap = this.resolveViews(((Observer)object).mTables);
        int[] nArray = new int[((String[])safeIterableMap).length];
        int n = ((String[])safeIterableMap).length;
        for (int i = 0; i < n; ++i) {
            object2 = this.mTableIdLookup.get(safeIterableMap[i].toLowerCase(Locale.US));
            if (object2 == null) {
                object = new StringBuilder();
                ((StringBuilder)object).append("There is no table with name ");
                ((StringBuilder)object).append((String)safeIterableMap[i]);
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            nArray[i] = (Integer)object2;
        }
        object2 = new ObserverWrapper((Observer)object, nArray, (String[])safeIterableMap);
        safeIterableMap = this.mObserverMap;
        synchronized (safeIterableMap) {
            object = (ObserverWrapper)this.mObserverMap.putIfAbsent(object, object2);
            // MONITOREXIT @DISABLED, blocks:[0, 2] lbl20 : MonitorExitStatement: MONITOREXIT : var5_3
            if (object != null) return;
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        if (!this.mObservedTableTracker.onAdded(nArray)) return;
        this.syncTriggers();
    }

    public void addWeakObserver(Observer observer) {
        this.addObserver((Observer)new WeakObserver(this, observer));
    }

    @Deprecated
    public <T> LiveData<T> createLiveData(String[] stringArray, Callable<T> callable) {
        return this.createLiveData(stringArray, false, callable);
    }

    public <T> LiveData<T> createLiveData(String[] stringArray, boolean bl, Callable<T> callable) {
        return this.mInvalidationLiveDataContainer.create(this.validateAndResolveTableNames(stringArray), bl, callable);
    }

    boolean ensureInitialization() {
        if (!this.mDatabase.isOpen()) {
            return false;
        }
        if (!this.mInitialized) {
            this.mDatabase.getOpenHelper().getWritableDatabase();
        }
        if (this.mInitialized) return true;
        Log.e((String)"ROOM", (String)"database is not initialized even though it is open");
        return false;
    }

    void internalInit(SupportSQLiteDatabase supportSQLiteDatabase) {
        synchronized (this) {
            if (this.mInitialized) {
                Log.e((String)"ROOM", (String)"Invalidation tracker is initialized twice :/.");
                return;
            }
            supportSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
            supportSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
            supportSQLiteDatabase.execSQL(CREATE_TRACKING_TABLE_SQL);
            this.syncTriggers(supportSQLiteDatabase);
            this.mCleanupStatement = supportSQLiteDatabase.compileStatement(RESET_UPDATED_TABLES_SQL);
            this.mInitialized = true;
            return;
        }
    }

    public void notifyObserversByTableNames(String ... stringArray) {
        SafeIterableMap<Observer, ObserverWrapper> safeIterableMap = this.mObserverMap;
        synchronized (safeIterableMap) {
            try {
                Iterator iterator = this.mObserverMap.iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry)iterator.next();
                    if (((Observer)entry.getKey()).isRemote()) continue;
                    ((ObserverWrapper)entry.getValue()).notifyByTableNames(stringArray);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void refreshVersionsAsync() {
        if (!this.mPendingRefresh.compareAndSet(false, true)) return;
        this.mDatabase.getQueryExecutor().execute(this.mRefreshRunnable);
    }

    public void refreshVersionsSync() {
        this.syncTriggers();
        this.mRefreshRunnable.run();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void removeObserver(Observer observer) {
        SafeIterableMap<Observer, ObserverWrapper> safeIterableMap = this.mObserverMap;
        synchronized (safeIterableMap) {
            observer = (ObserverWrapper)this.mObserverMap.remove((Object)observer);
        }
        if (observer == null) return;
        if (!this.mObservedTableTracker.onRemoved(observer.mTableIds)) return;
        this.syncTriggers();
    }

    void startMultiInstanceInvalidation(Context context, String string) {
        this.mMultiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, string, this, this.mDatabase.getQueryExecutor());
    }

    void stopMultiInstanceInvalidation() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.mMultiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient == null) return;
        multiInstanceInvalidationClient.stop();
        this.mMultiInstanceInvalidationClient = null;
    }

    void syncTriggers() {
        if (!this.mDatabase.isOpen()) {
            return;
        }
        this.syncTriggers(this.mDatabase.getOpenHelper().getWritableDatabase());
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    void syncTriggers(SupportSQLiteDatabase var1_1) {
        if (var1_1.inTransaction()) {
            return;
        }
        while (true) {
            block17: {
                var5_9 = this.mDatabase.getCloseLock();
                var5_9.lock();
                var6_10 = this.mObservedTableTracker.getTablesToSync();
                if (var6_10 != null) break block17;
                var5_9.unlock();
                return;
            }
            var3_7 = var6_10.length;
            var1_1.beginTransaction();
            for (var2_6 = 0; var2_6 < var3_7; ++var2_6) {
                var4_8 = var6_10[var2_6];
                if (var4_8 == 1) ** GOTO lbl24
                if (var4_8 != 2) continue;
                this.stopTrackingTable(var1_1, var2_6);
                continue;
lbl24:
                // 1 sources

                this.startTrackingTable(var1_1, var2_6);
            }
            var1_1.setTransactionSuccessful();
            var1_1.endTransaction();
            this.mObservedTableTracker.onSyncCompleted();
            var5_9.unlock();
            continue;
            break;
        }
        catch (Throwable var6_11) {
            try {
                var1_1.endTransaction();
                throw var6_11;
            }
            catch (Throwable var1_2) {
                try {
                    var5_9.unlock();
                    throw var1_2;
                }
                catch (SQLiteException var1_3) {
                }
                catch (IllegalStateException var1_4) {
                    // empty catch block
                }
            }
        }
        Log.e((String)"ROOM", (String)"Cannot run invalidation tracker. Is the db closed?", (Throwable)var1_5);
    }
}
