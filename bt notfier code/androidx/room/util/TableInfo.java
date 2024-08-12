/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  androidx.room.util.TableInfo$Column
 *  androidx.room.util.TableInfo$ForeignKey
 *  androidx.room.util.TableInfo$ForeignKeyWithSequence
 *  androidx.room.util.TableInfo$Index
 *  androidx.sqlite.db.SupportSQLiteDatabase
 */
package androidx.room.util;

import android.database.Cursor;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    public final Set<Index> indices;
    public final String name;

    public TableInfo(String string, Map<String, Column> map, Set<ForeignKey> set) {
        this(string, map, set, Collections.emptySet());
    }

    public TableInfo(String object, Map<String, Column> map, Set<ForeignKey> set, Set<Index> set2) {
        this.name = object;
        this.columns = Collections.unmodifiableMap(map);
        this.foreignKeys = Collections.unmodifiableSet(set);
        object = set2 == null ? null : Collections.unmodifiableSet(set2);
        this.indices = object;
    }

    public static TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String string) {
        return new TableInfo(string, TableInfo.readColumns(supportSQLiteDatabase, string), TableInfo.readForeignKeys(supportSQLiteDatabase, string), TableInfo.readIndices(supportSQLiteDatabase, string));
    }

    private static Map<String, Column> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String object) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("PRAGMA table_info(`");
        charSequence.append((String)object);
        charSequence.append("`)");
        supportSQLiteDatabase = supportSQLiteDatabase.query(charSequence.toString());
        object = new HashMap();
        try {
            if (supportSQLiteDatabase.getColumnCount() <= 0) return object;
            int n = supportSQLiteDatabase.getColumnIndex("name");
            int n2 = supportSQLiteDatabase.getColumnIndex("type");
            int n3 = supportSQLiteDatabase.getColumnIndex("notnull");
            int n4 = supportSQLiteDatabase.getColumnIndex("pk");
            int n5 = supportSQLiteDatabase.getColumnIndex("dflt_value");
            while (supportSQLiteDatabase.moveToNext()) {
                String string = supportSQLiteDatabase.getString(n);
                String string2 = supportSQLiteDatabase.getString(n2);
                boolean bl = supportSQLiteDatabase.getInt(n3) != 0;
                int n6 = supportSQLiteDatabase.getInt(n4);
                charSequence = supportSQLiteDatabase.getString(n5);
                Column column = new Column(string, string2, bl, n6, (String)charSequence, 2);
                object.put(string, column);
            }
            return object;
        }
        finally {
            supportSQLiteDatabase.close();
        }
    }

    private static List<ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor cursor) {
        int n = cursor.getColumnIndex("id");
        int n2 = cursor.getColumnIndex("seq");
        int n3 = cursor.getColumnIndex("from");
        int n4 = cursor.getColumnIndex("to");
        int n5 = cursor.getCount();
        ArrayList<ForeignKeyWithSequence> arrayList = new ArrayList<ForeignKeyWithSequence>();
        int n6 = 0;
        while (true) {
            if (n6 >= n5) {
                Collections.sort(arrayList);
                return arrayList;
            }
            cursor.moveToPosition(n6);
            arrayList.add(new ForeignKeyWithSequence(cursor.getInt(n), cursor.getInt(n2), cursor.getString(n3), cursor.getString(n4)));
            ++n6;
        }
    }

    private static Set<ForeignKey> readForeignKeys(SupportSQLiteDatabase supportSQLiteDatabase, String object) {
        HashSet<ForeignKey> hashSet = new HashSet<ForeignKey>();
        Serializable serializable = new StringBuilder();
        ((StringBuilder)serializable).append("PRAGMA foreign_key_list(`");
        ((StringBuilder)serializable).append((String)object);
        ((StringBuilder)serializable).append("`)");
        supportSQLiteDatabase = supportSQLiteDatabase.query(((StringBuilder)serializable).toString());
        try {
            int n = supportSQLiteDatabase.getColumnIndex("id");
            int n2 = supportSQLiteDatabase.getColumnIndex("seq");
            int n3 = supportSQLiteDatabase.getColumnIndex("table");
            int n4 = supportSQLiteDatabase.getColumnIndex("on_delete");
            int n5 = supportSQLiteDatabase.getColumnIndex("on_update");
            object = TableInfo.readForeignKeyFieldMappings((Cursor)supportSQLiteDatabase);
            int n6 = supportSQLiteDatabase.getCount();
            int n7 = 0;
            while (n7 < n6) {
                supportSQLiteDatabase.moveToPosition(n7);
                if (supportSQLiteDatabase.getInt(n2) == 0) {
                    int n8 = supportSQLiteDatabase.getInt(n);
                    ArrayList<String> arrayList = new ArrayList<String>();
                    serializable = new ArrayList();
                    ForeignKey foreignKey = object.iterator();
                    while (foreignKey.hasNext()) {
                        ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence)foreignKey.next();
                        if (foreignKeyWithSequence.mId != n8) continue;
                        arrayList.add(foreignKeyWithSequence.mFrom);
                        serializable.add(foreignKeyWithSequence.mTo);
                    }
                    foreignKey = new ForeignKey(supportSQLiteDatabase.getString(n3), supportSQLiteDatabase.getString(n4), supportSQLiteDatabase.getString(n5), arrayList, (List)((Object)serializable));
                    hashSet.add(foreignKey);
                }
                ++n7;
            }
            return hashSet;
        }
        finally {
            supportSQLiteDatabase.close();
        }
    }

    private static Index readIndex(SupportSQLiteDatabase supportSQLiteDatabase, String string, boolean bl) {
        block5: {
            Serializable serializable = new StringBuilder();
            ((StringBuilder)serializable).append("PRAGMA index_xinfo(`");
            ((StringBuilder)serializable).append(string);
            ((StringBuilder)serializable).append("`)");
            supportSQLiteDatabase = supportSQLiteDatabase.query(((StringBuilder)serializable).toString());
            try {
                int n = supportSQLiteDatabase.getColumnIndex("seqno");
                int n2 = supportSQLiteDatabase.getColumnIndex("cid");
                int n3 = supportSQLiteDatabase.getColumnIndex("name");
                if (n == -1) return null;
                if (n2 == -1) return null;
                if (n3 == -1) {
                    break block5;
                }
                serializable = new TreeMap();
                while (supportSQLiteDatabase.moveToNext()) {
                    if (supportSQLiteDatabase.getInt(n2) < 0) continue;
                    ((TreeMap)serializable).put(supportSQLiteDatabase.getInt(n), supportSQLiteDatabase.getString(n3));
                }
                ArrayList arrayList = new ArrayList(((TreeMap)serializable).size());
                arrayList.addAll(((TreeMap)serializable).values());
                string = new Index(string, bl, arrayList);
            }
            finally {
                supportSQLiteDatabase.close();
            }
            return string;
        }
        return null;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private static Set<Index> readIndices(SupportSQLiteDatabase supportSQLiteDatabase, String string) {
        Serializable serializable = new StringBuilder();
        ((StringBuilder)serializable).append("PRAGMA index_list(`");
        ((StringBuilder)serializable).append(string);
        ((StringBuilder)serializable).append("`)");
        string = supportSQLiteDatabase.query(((StringBuilder)serializable).toString());
        try {
            int n = string.getColumnIndex("name");
            int n2 = string.getColumnIndex("origin");
            int n3 = string.getColumnIndex("unique");
            if (n == -1 || n2 == -1 || n3 == -1) {
                string.close();
                return null;
            }
            serializable = new HashSet();
            while (string.moveToNext()) {
                if (!"c".equals(string.getString(n2))) continue;
                String string2 = string.getString(n);
                int n4 = string.getInt(n3);
                boolean bl = true;
                if (n4 != 1) {
                    bl = false;
                }
                string2 = TableInfo.readIndex(supportSQLiteDatabase, string2, bl);
                if (string2 == null) {
                    return null;
                }
                ((HashSet)serializable).add(string2);
            }
            return serializable;
        }
        finally {
            string.close();
        }
    }

    public boolean equals(Object set) {
        if (this == set) {
            return true;
        }
        if (set == null) return false;
        if (this.getClass() != set.getClass()) {
            return false;
        }
        set = (TableInfo)((Object)set);
        Set<Index> set2 = this.name;
        if (set2 != null ? !((String)((Object)set2)).equals(((TableInfo)((Object)set)).name) : ((TableInfo)((Object)set)).name != null) {
            return false;
        }
        set2 = this.columns;
        if (set2 != null ? !set2.equals(((TableInfo)((Object)set)).columns) : ((TableInfo)((Object)set)).columns != null) {
            return false;
        }
        set2 = this.foreignKeys;
        if (set2 != null ? !set2.equals(((TableInfo)((Object)set)).foreignKeys) : ((TableInfo)((Object)set)).foreignKeys != null) {
            return false;
        }
        set2 = this.indices;
        if (set2 == null) return true;
        set = ((TableInfo)((Object)set)).indices;
        if (set != null) return set2.equals(set);
        return true;
    }

    public int hashCode() {
        Set<ForeignKey> set = this.name;
        int n = 0;
        int n2 = set != null ? ((String)((Object)set)).hashCode() : 0;
        set = this.columns;
        int n3 = set != null ? set.hashCode() : 0;
        set = this.foreignKeys;
        if (set == null) return (n2 * 31 + n3) * 31 + n;
        n = set.hashCode();
        return (n2 * 31 + n3) * 31 + n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TableInfo{name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", columns=");
        stringBuilder.append(this.columns);
        stringBuilder.append(", foreignKeys=");
        stringBuilder.append(this.foreignKeys);
        stringBuilder.append(", indices=");
        stringBuilder.append(this.indices);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
