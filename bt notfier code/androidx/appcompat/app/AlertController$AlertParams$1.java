/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ArrayAdapter
 *  androidx.appcompat.app.AlertController$AlertParams
 *  androidx.appcompat.app.AlertController$RecycleListView
 */
package androidx.appcompat.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController;

class AlertController.AlertParams.1
extends ArrayAdapter<CharSequence> {
    final AlertController.AlertParams this$0;
    final AlertController.RecycleListView val$listView;

    AlertController.AlertParams.1(AlertController.AlertParams alertParams, Context context, int n, int n2, CharSequence[] charSequenceArray, AlertController.RecycleListView recycleListView) {
        this.this$0 = alertParams;
        this.val$listView = recycleListView;
        super(context, n, n2, (Object[])charSequenceArray);
    }

    public View getView(int n, View view, ViewGroup viewGroup) {
        view = super.getView(n, view, viewGroup);
        if (this.this$0.mCheckedItems == null) return view;
        if (!this.this$0.mCheckedItems[n]) return view;
        this.val$listView.setItemChecked(n, true);
        return view;
    }
}
