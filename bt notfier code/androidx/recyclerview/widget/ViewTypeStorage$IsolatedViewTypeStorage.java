/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  androidx.recyclerview.widget.NestedAdapterWrapper
 *  androidx.recyclerview.widget.ViewTypeStorage
 *  androidx.recyclerview.widget.ViewTypeStorage$IsolatedViewTypeStorage$WrapperViewTypeLookup
 *  androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
 */
package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.ViewTypeStorage;

public static class ViewTypeStorage.IsolatedViewTypeStorage
implements ViewTypeStorage {
    SparseArray<NestedAdapterWrapper> mGlobalTypeToWrapper = new SparseArray();
    int mNextViewType = 0;

    public ViewTypeStorage.ViewTypeLookup createViewTypeWrapper(NestedAdapterWrapper nestedAdapterWrapper) {
        return new WrapperViewTypeLookup(this, nestedAdapterWrapper);
    }

    public NestedAdapterWrapper getWrapperForGlobalType(int n) {
        Object object = (NestedAdapterWrapper)this.mGlobalTypeToWrapper.get(n);
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Cannot find the wrapper for global view type ");
        ((StringBuilder)object).append(n);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    int obtainViewType(NestedAdapterWrapper nestedAdapterWrapper) {
        int n = this.mNextViewType;
        this.mNextViewType = n + 1;
        this.mGlobalTypeToWrapper.put(n, (Object)nestedAdapterWrapper);
        return n;
    }

    void removeWrapper(NestedAdapterWrapper nestedAdapterWrapper) {
        int n = this.mGlobalTypeToWrapper.size() - 1;
        while (n >= 0) {
            if ((NestedAdapterWrapper)this.mGlobalTypeToWrapper.valueAt(n) == nestedAdapterWrapper) {
                this.mGlobalTypeToWrapper.removeAt(n);
            }
            --n;
        }
    }
}
