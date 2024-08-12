/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  androidx.appcompat.app.AlertController
 *  androidx.appcompat.app.AlertController$AlertParams
 *  androidx.appcompat.app.AlertController$RecycleListView
 */
package androidx.appcompat.app;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

class AlertController.AlertParams.4
implements AdapterView.OnItemClickListener {
    final AlertController.AlertParams this$0;
    final AlertController val$dialog;
    final AlertController.RecycleListView val$listView;

    AlertController.AlertParams.4(AlertController.AlertParams alertParams, AlertController.RecycleListView recycleListView, AlertController alertController) {
        this.this$0 = alertParams;
        this.val$listView = recycleListView;
        this.val$dialog = alertController;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int n, long l) {
        if (this.this$0.mCheckedItems != null) {
            this.this$0.mCheckedItems[n] = this.val$listView.isItemChecked(n);
        }
        this.this$0.mOnCheckboxClickListener.onClick((DialogInterface)this.val$dialog.mDialog, n, this.val$listView.isItemChecked(n));
    }
}
