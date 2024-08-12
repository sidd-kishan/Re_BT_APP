/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  androidx.recyclerview.widget.NestedAdapterWrapper
 *  androidx.recyclerview.widget.ViewTypeStorage$IsolatedViewTypeStorage
 *  androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
 */
package androidx.recyclerview.widget;

import android.util.SparseIntArray;
import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.ViewTypeStorage;

class ViewTypeStorage.IsolatedViewTypeStorage.WrapperViewTypeLookup
implements ViewTypeStorage.ViewTypeLookup {
    private SparseIntArray mGlobalToLocalMapping;
    private SparseIntArray mLocalToGlobalMapping;
    final NestedAdapterWrapper mWrapper;
    final ViewTypeStorage.IsolatedViewTypeStorage this$0;

    ViewTypeStorage.IsolatedViewTypeStorage.WrapperViewTypeLookup(ViewTypeStorage.IsolatedViewTypeStorage isolatedViewTypeStorage, NestedAdapterWrapper nestedAdapterWrapper) {
        this.this$0 = isolatedViewTypeStorage;
        this.mLocalToGlobalMapping = new SparseIntArray(1);
        this.mGlobalToLocalMapping = new SparseIntArray(1);
        this.mWrapper = nestedAdapterWrapper;
    }

    public void dispose() {
        this.this$0.removeWrapper(this.mWrapper);
    }

    public int globalToLocal(int n) {
        int n2 = this.mGlobalToLocalMapping.indexOfKey(n);
        if (n2 >= 0) {
            return this.mGlobalToLocalMapping.valueAt(n2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("requested global type ");
        stringBuilder.append(n);
        stringBuilder.append(" does not belong to the adapter:");
        stringBuilder.append(this.mWrapper.adapter);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public int localToGlobal(int n) {
        int n2 = this.mLocalToGlobalMapping.indexOfKey(n);
        if (n2 > -1) {
            return this.mLocalToGlobalMapping.valueAt(n2);
        }
        n2 = this.this$0.obtainViewType(this.mWrapper);
        this.mLocalToGlobalMapping.put(n, n2);
        this.mGlobalToLocalMapping.put(n2, n);
        return n2;
    }
}
