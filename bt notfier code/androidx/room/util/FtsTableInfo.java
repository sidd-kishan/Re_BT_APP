/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.sqlite.db.SupportSQLiteDatabase
 */
package androidx.room.util;

import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FtsTableInfo {
    private static final String[] FTS_OPTIONS = new String[]{"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    public final Set<String> columns;
    public final String name;
    public final Set<String> options;

    public FtsTableInfo(String string, Set<String> set, String string2) {
        this.name = string;
        this.columns = set;
        this.options = FtsTableInfo.parseOptions(string2);
    }

    public FtsTableInfo(String string, Set<String> set, Set<String> set2) {
        this.name = string;
        this.columns = set;
        this.options = set2;
    }

    static Set<String> parseOptions(String object) {
        int n;
        if (((String)object).isEmpty()) {
            return new HashSet<String>();
        }
        object = ((String)object).substring(((String)object).indexOf(40) + 1, ((String)object).lastIndexOf(41));
        String[] stringArray = new ArrayList();
        Object object2 = new ArrayDeque<Character>();
        int n2 = -1;
        for (n = 0; n < ((String)object).length(); ++n) {
            int n3;
            block16: {
                char c;
                block12: {
                    block13: {
                        block14: {
                            block15: {
                                c = ((String)object).charAt(n);
                                if (c == '\"' || c == '\'') break block12;
                                if (c == ',') break block13;
                                if (c == '[') break block14;
                                if (c == ']') break block15;
                                if (c == '`') break block12;
                                n3 = n2;
                                break block16;
                            }
                            n3 = n2;
                            if (!((ArrayDeque)object2).isEmpty()) {
                                n3 = n2;
                                if (((Character)((ArrayDeque)object2).peek()).charValue() == '[') {
                                    ((ArrayDeque)object2).pop();
                                    n3 = n2;
                                }
                            }
                            break block16;
                        }
                        n3 = n2;
                        if (((ArrayDeque)object2).isEmpty()) {
                            ((ArrayDeque)object2).push(Character.valueOf(c));
                            n3 = n2;
                        }
                        break block16;
                    }
                    n3 = n2;
                    if (((ArrayDeque)object2).isEmpty()) {
                        stringArray.add(((String)object).substring(n2 + 1, n).trim());
                        n3 = n;
                    }
                    break block16;
                }
                if (((ArrayDeque)object2).isEmpty()) {
                    ((ArrayDeque)object2).push(Character.valueOf(c));
                    n3 = n2;
                } else {
                    n3 = n2;
                    if (((Character)((ArrayDeque)object2).peek()).charValue() == c) {
                        ((ArrayDeque)object2).pop();
                        n3 = n2;
                    }
                }
            }
            n2 = n3;
        }
        stringArray.add(((String)object).substring(n2 + 1).trim());
        object = new HashSet();
        Iterator iterator = stringArray.iterator();
        block1: while (iterator.hasNext()) {
            object2 = (String)iterator.next();
            stringArray = FTS_OPTIONS;
            n2 = stringArray.length;
            n = 0;
            while (true) {
                if (n >= n2) continue block1;
                if (((String)object2).startsWith(stringArray[n])) {
                    ((HashSet)object).add(object2);
                }
                ++n;
            }
            break;
        }
        return object;
    }

    public static FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String string) {
        return new FtsTableInfo(string, FtsTableInfo.readColumns(supportSQLiteDatabase, string), FtsTableInfo.readOptions(supportSQLiteDatabase, string));
    }

    private static Set<String> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PRAGMA table_info(`");
        stringBuilder.append((String)object);
        stringBuilder.append("`)");
        supportSQLiteDatabase = supportSQLiteDatabase.query(stringBuilder.toString());
        object = new HashSet();
        try {
            if (supportSQLiteDatabase.getColumnCount() <= 0) return object;
            int n = supportSQLiteDatabase.getColumnIndex("name");
            while (supportSQLiteDatabase.moveToNext()) {
                object.add(supportSQLiteDatabase.getString(n));
            }
            return object;
        }
        finally {
            supportSQLiteDatabase.close();
        }
    }

    private static Set<String> readOptions(SupportSQLiteDatabase object, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM sqlite_master WHERE `name` = '");
        stringBuilder.append(string);
        stringBuilder.append("'");
        string = object.query(stringBuilder.toString());
        try {
            object = string.moveToFirst() ? string.getString(string.getColumnIndexOrThrow("sql")) : "";
        }
        finally {
            string.close();
        }
        return FtsTableInfo.parseOptions((String)object);
    }

    public boolean equals(Object set) {
        boolean bl = true;
        if (this == set) {
            return true;
        }
        if (set == null) return false;
        if (this.getClass() != set.getClass()) {
            return false;
        }
        set = (FtsTableInfo)((Object)set);
        Set<String> set2 = this.name;
        if (set2 != null ? !((String)((Object)set2)).equals(((FtsTableInfo)((Object)set)).name) : ((FtsTableInfo)((Object)set)).name != null) {
            return false;
        }
        set2 = this.columns;
        if (set2 != null ? !set2.equals(((FtsTableInfo)((Object)set)).columns) : ((FtsTableInfo)((Object)set)).columns != null) {
            return false;
        }
        set2 = this.options;
        set = ((FtsTableInfo)((Object)set)).options;
        if (set2 != null) {
            bl = set2.equals(set);
        } else {
            if (set == null) return bl;
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        Set<String> set = this.name;
        int n = 0;
        int n2 = set != null ? ((String)((Object)set)).hashCode() : 0;
        set = this.columns;
        int n3 = set != null ? set.hashCode() : 0;
        set = this.options;
        if (set == null) return (n2 * 31 + n3) * 31 + n;
        n = set.hashCode();
        return (n2 * 31 + n3) * 31 + n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FtsTableInfo{name='");
        stringBuilder.append(this.name);
        stringBuilder.append('\'');
        stringBuilder.append(", columns=");
        stringBuilder.append(this.columns);
        stringBuilder.append(", options=");
        stringBuilder.append(this.options);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
