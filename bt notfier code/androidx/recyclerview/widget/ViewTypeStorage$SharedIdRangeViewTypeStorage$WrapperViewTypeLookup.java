/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.NestedAdapterWrapper
 *  androidx.recyclerview.widget.ViewTypeStorage$SharedIdRangeViewTypeStorage
 *  androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.ViewTypeStorage;
import java.util.ArrayList;

class ViewTypeStorage.SharedIdRangeViewTypeStorage.WrapperViewTypeLookup
implements ViewTypeStorage.ViewTypeLookup {
    final NestedAdapterWrapper mWrapper;
    final ViewTypeStorage.SharedIdRangeViewTypeStorage this$0;

    ViewTypeStorage.SharedIdRangeViewTypeStorage.WrapperViewTypeLookup(ViewTypeStorage.SharedIdRangeViewTypeStorage sharedIdRangeViewTypeStorage, NestedAdapterWrapper nestedAdapterWrapper) {
        this.this$0 = sharedIdRangeViewTypeStorage;
        this.mWrapper = nestedAdapterWrapper;
    }

    public void dispose() {
        this.this$0.removeWrapper(this.mWrapper);
    }

    public int globalToLocal(int n) {
        return n;
    }

    public int localToGlobal(int n) {
        ArrayList<NestedAdapterWrapper> arrayList;
        ArrayList<NestedAdapterWrapper> arrayList2 = arrayList = (ArrayList<NestedAdapterWrapper>)this.this$0.mGlobalTypeToWrapper.get(n);
        if (arrayList == null) {
            arrayList2 = new ArrayList<NestedAdapterWrapper>();
            this.this$0.mGlobalTypeToWrapper.put(n, arrayList2);
        }
        if (arrayList2.contains(this.mWrapper)) return n;
        arrayList2.add(this.mWrapper);
        return n;
    }
}
