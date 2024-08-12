/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.AsyncListDiffer$ListListener
 *  androidx.recyclerview.widget.ListAdapter
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.ListAdapter;
import java.util.List;

class ListAdapter.1
implements AsyncListDiffer.ListListener<T> {
    final ListAdapter this$0;

    ListAdapter.1(ListAdapter listAdapter) {
        this.this$0 = listAdapter;
    }

    public void onCurrentListChanged(List<T> list, List<T> list2) {
        this.this$0.onCurrentListChanged(list, list2);
    }
}
