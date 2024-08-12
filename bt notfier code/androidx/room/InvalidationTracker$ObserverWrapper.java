/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.InvalidationTracker$Observer
 */
package androidx.room;

import androidx.room.InvalidationTracker;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

static class InvalidationTracker.ObserverWrapper {
    final InvalidationTracker.Observer mObserver;
    private final Set<String> mSingleTableSet;
    final int[] mTableIds;
    private final String[] mTableNames;

    InvalidationTracker.ObserverWrapper(InvalidationTracker.Observer object, int[] nArray, String[] stringArray) {
        this.mObserver = object;
        this.mTableIds = nArray;
        this.mTableNames = stringArray;
        if (nArray.length == 1) {
            object = new HashSet();
            ((HashSet)object).add(this.mTableNames[0]);
            this.mSingleTableSet = Collections.unmodifiableSet(object);
        } else {
            this.mSingleTableSet = null;
        }
    }

    void notifyByTableInvalidStatus(Set<Integer> set) {
        int n = this.mTableIds.length;
        Set<String> set2 = null;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                if (set2 == null) return;
                this.mObserver.onInvalidated(set2);
                return;
            }
            Set<String> set3 = set2;
            if (set.contains(this.mTableIds[n2])) {
                if (n == 1) {
                    set3 = this.mSingleTableSet;
                } else {
                    set3 = set2;
                    if (set2 == null) {
                        set3 = new HashSet<String>(n);
                    }
                    set3.add(this.mTableNames[n2]);
                }
            }
            ++n2;
            set2 = set3;
        }
    }

    void notifyByTableNames(String[] stringArray) {
        Set<String> set;
        block7: {
            int n = this.mTableNames.length;
            String string = null;
            if (n == 1) {
                int n2 = stringArray.length;
                n = 0;
                while (true) {
                    set = string;
                    if (n >= n2) break block7;
                    if (stringArray[n].equalsIgnoreCase(this.mTableNames[0])) {
                        set = this.mSingleTableSet;
                        break block7;
                    }
                    ++n;
                }
            }
            HashSet<String> hashSet = new HashSet<String>();
            int n3 = stringArray.length;
            n = 0;
            while (true) {
                int n4;
                String[] stringArray2;
                if (n < n3) {
                    set = stringArray[n];
                    stringArray2 = this.mTableNames;
                    n4 = stringArray2.length;
                } else {
                    set = string;
                    if (hashSet.size() <= 0) break;
                    set = hashSet;
                    break;
                }
                for (int i = 0; i < n4; ++i) {
                    String string2 = stringArray2[i];
                    if (!string2.equalsIgnoreCase((String)((Object)set))) continue;
                    hashSet.add(string2);
                    break;
                }
                ++n;
            }
        }
        if (set == null) return;
        this.mObserver.onInvalidated(set);
    }
}
