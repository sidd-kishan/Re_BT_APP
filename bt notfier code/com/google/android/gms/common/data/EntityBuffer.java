/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.data.AbstractDataBuffer
 *  com.google.android.gms.common.data.DataHolder
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.data;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public abstract class EntityBuffer<T>
extends AbstractDataBuffer<T> {
    private boolean zaa = false;
    private ArrayList<Integer> zab;

    protected EntityBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /*
     * Enabled force condition propagation
     */
    private final void zab() {
        synchronized (this) {
            block7: {
                int n;
                Object object;
                int n2;
                String string;
                Object object2;
                int n3;
                block8: {
                    if (this.zaa) return;
                    n3 = ((DataHolder)Preconditions.checkNotNull((Object)this.mDataHolder)).getCount();
                    object2 = new ArrayList();
                    this.zab = object2;
                    if (n3 <= 0) break block7;
                    ((ArrayList)object2).add(0);
                    string = this.getPrimaryDataMarkerColumn();
                    n2 = this.mDataHolder.getWindowIndex(0);
                    object = this.mDataHolder.getString(string, 0, n2);
                    for (n2 = 1; n2 < n3; ++n2) {
                        n = this.mDataHolder.getWindowIndex(n2);
                        String string2 = this.mDataHolder.getString(string, n2, n);
                        if (string2 != null) {
                            object2 = object;
                            if (!string2.equals(object)) {
                                this.zab.add(n2);
                                object2 = string2;
                            }
                            object = object2;
                            continue;
                        }
                        break block8;
                    }
                    break block7;
                }
                n3 = String.valueOf(string).length();
                object2 = new StringBuilder(n3 + 78);
                ((StringBuilder)object2).append("Missing value for markerColumn: ");
                ((StringBuilder)object2).append(string);
                ((StringBuilder)object2).append(", at row: ");
                ((StringBuilder)object2).append(n2);
                ((StringBuilder)object2).append(", for window: ");
                ((StringBuilder)object2).append(n);
                object = new NullPointerException(((StringBuilder)object2).toString());
                throw object;
            }
            this.zaa = true;
            return;
        }
    }

    public final T get(int n) {
        int n2;
        this.zab();
        int n3 = this.zaa(n);
        int n4 = n2 = 0;
        if (n < 0) return this.getEntry(n3, n4);
        if (n == this.zab.size()) {
            n4 = n2;
        } else {
            int n5;
            if (n == this.zab.size() - 1) {
                n5 = ((DataHolder)Preconditions.checkNotNull((Object)this.mDataHolder)).getCount();
                n4 = this.zab.get(n);
            } else {
                n5 = this.zab.get(n + 1);
                n4 = this.zab.get(n);
            }
            n4 = n5 - n4;
            if (n4 != 1) return this.getEntry(n3, n4);
            n = this.zaa(n);
            n4 = ((DataHolder)Preconditions.checkNotNull((Object)this.mDataHolder)).getWindowIndex(n);
            String string = this.getChildDataMarkerColumn();
            n4 = string != null && this.mDataHolder.getString(string, n, n4) == null ? n2 : 1;
        }
        return this.getEntry(n3, n4);
    }

    protected String getChildDataMarkerColumn() {
        return null;
    }

    public int getCount() {
        this.zab();
        return this.zab.size();
    }

    protected abstract T getEntry(int var1, int var2);

    protected abstract String getPrimaryDataMarkerColumn();

    final int zaa(int n) {
        if (n >= 0 && n < this.zab.size()) {
            return this.zab.get(n);
        }
        StringBuilder stringBuilder = new StringBuilder(53);
        stringBuilder.append("Position ");
        stringBuilder.append(n);
        stringBuilder.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
