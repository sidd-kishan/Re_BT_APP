/*
 * Decompiled with CFR 0.152.
 */
package butterknife.internal;

import java.util.AbstractList;
import java.util.RandomAccess;

final class ImmutableList<T>
extends AbstractList<T>
implements RandomAccess {
    private final T[] views;

    ImmutableList(T[] TArray) {
        this.views = TArray;
    }

    @Override
    public boolean contains(Object object) {
        T[] TArray = this.views;
        int n = TArray.length;
        int n2 = 0;
        while (n2 < n) {
            if (TArray[n2] == object) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    @Override
    public T get(int n) {
        return this.views[n];
    }

    @Override
    public int size() {
        return this.views.length;
    }
}
