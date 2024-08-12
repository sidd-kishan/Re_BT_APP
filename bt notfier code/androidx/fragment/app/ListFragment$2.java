/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ListView
 *  androidx.fragment.app.ListFragment
 */
package androidx.fragment.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.fragment.app.ListFragment;

class ListFragment.2
implements AdapterView.OnItemClickListener {
    final ListFragment this$0;

    ListFragment.2(ListFragment listFragment) {
        this.this$0 = listFragment;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int n, long l) {
        this.this$0.onListItemClick((ListView)adapterView, view, n, l);
    }
}
