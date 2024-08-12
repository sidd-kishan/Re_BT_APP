/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.room.migration.Migration
 */
package androidx.room;

import android.util.Log;
import androidx.room.migration.Migration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public static class RoomDatabase.MigrationContainer {
    private HashMap<Integer, TreeMap<Integer, Migration>> mMigrations = new HashMap();

    private void addMigration(Migration migration) {
        int n = migration.startVersion;
        int n2 = migration.endVersion;
        Migration migration2 = this.mMigrations.get(n);
        Object object = migration2;
        if (migration2 == null) {
            object = new TreeMap();
            this.mMigrations.put(n, (TreeMap<Integer, Migration>)object);
        }
        if ((migration2 = ((TreeMap)object).get(n2)) != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Overriding migration ");
            stringBuilder.append(migration2);
            stringBuilder.append(" with ");
            stringBuilder.append(migration);
            Log.w((String)"ROOM", (String)stringBuilder.toString());
        }
        ((TreeMap)object).put(n2, migration);
    }

    private List<Migration> findUpMigrationPath(List<Migration> list, boolean bl, int n, int n2) {
        boolean bl2;
        do {
            block7: {
                int n3;
                boolean bl3;
                if (bl) {
                    if (n >= n2) return list;
                } else if (n <= n2) return list;
                TreeMap<Integer, Migration> treeMap = this.mMigrations.get(n);
                if (treeMap == null) {
                    return null;
                }
                Set<Integer> set = bl ? treeMap.descendingKeySet() : treeMap.keySet();
                set = set.iterator();
                do {
                    boolean bl4 = set.hasNext();
                    bl3 = true;
                    boolean bl5 = false;
                    if (!bl4) break block7;
                    n3 = (Integer)set.next();
                    if (bl) {
                        bl2 = bl5;
                        if (n3 > n2) continue;
                        bl2 = bl5;
                        if (n3 <= n) continue;
                    } else {
                        bl2 = bl5;
                        if (n3 < n2) continue;
                        bl2 = bl5;
                        if (n3 >= n) continue;
                    }
                    bl2 = true;
                } while (!bl2);
                list.add(treeMap.get(n3));
                n = n3;
                bl2 = bl3;
                continue;
            }
            bl2 = false;
        } while (bl2);
        return null;
    }

    public void addMigrations(Migration ... migrationArray) {
        int n = migrationArray.length;
        int n2 = 0;
        while (n2 < n) {
            this.addMigration(migrationArray[n2]);
            ++n2;
        }
    }

    public List<Migration> findMigrationPath(int n, int n2) {
        if (n == n2) {
            return Collections.emptyList();
        }
        boolean bl = n2 > n;
        return this.findUpMigrationPath(new ArrayList<Migration>(), bl, n, n2);
    }
}
