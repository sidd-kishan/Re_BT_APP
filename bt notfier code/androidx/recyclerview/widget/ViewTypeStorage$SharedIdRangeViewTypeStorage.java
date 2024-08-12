/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  androidx.recyclerview.widget.NestedAdapterWrapper
 *  androidx.recyclerview.widget.ViewTypeStorage
 *  androidx.recyclerview.widget.ViewTypeStorage$SharedIdRangeViewTypeStorage$WrapperViewTypeLookup
 *  androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
 */
package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.ViewTypeStorage;
import java.util.List;

public static class ViewTypeStorage.SharedIdRangeViewTypeStorage
implements ViewTypeStorage {
    SparseArray<List<NestedAdapterWrapper>> mGlobalTypeToWrapper = new SparseArray();

    public ViewTypeStorage.ViewTypeLookup createViewTypeWrapper(NestedAdapterWrapper nestedAdapterWrapper) {
        return new WrapperViewTypeLookup(this, nestedAdapterWrapper);
    }

    public NestedAdapterWrapper getWrapperForGlobalType(int n) {
        Object object = (List)this.mGlobalTypeToWrapper.get(n);
        if (object != null && !object.isEmpty()) {
            return (NestedAdapterWrapper)object.get(0);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Cannot find the wrapper for global view type ");
        ((StringBuilder)object).append(n);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    void removeWrapper(NestedAdapterWrapper nestedAdapterWrapper) {
        int n = this.mGlobalTypeToWrapper.size() - 1;
        while (n >= 0) {
            List list = (List)this.mGlobalTypeToWrapper.valueAt(n);
            if (list.remove(nestedAdapterWrapper) && list.isEmpty()) {
                this.mGlobalTypeToWrapper.removeAt(n);
            }
            --n;
        }
    }
}
