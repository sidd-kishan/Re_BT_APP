/*
 * Decompiled with CFR 0.152.
 */
package androidx.room;

import java.util.Arrays;
import java.util.Set;

public static abstract class InvalidationTracker.Observer {
    final String[] mTables;

    protected InvalidationTracker.Observer(String string, String ... stringArray) {
        String[] stringArray2 = Arrays.copyOf(stringArray, stringArray.length + 1);
        this.mTables = stringArray2;
        stringArray2[stringArray.length] = string;
    }

    public InvalidationTracker.Observer(String[] stringArray) {
        this.mTables = Arrays.copyOf(stringArray, stringArray.length);
    }

    boolean isRemote() {
        return false;
    }

    public abstract void onInvalidated(Set<String> var1);
}
