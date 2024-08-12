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
 */
package androidx.appcompat.app;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

class AlertController.AlertParams.3
implements AdapterView.OnItemClickListener {
    final AlertController.AlertParams this$0;
    final AlertController val$dialog;

    AlertController.AlertParams.3(AlertController.AlertParams alertParams, AlertController alertController) {
        this.this$0 = alertParams;
        this.val$dialog = alertController;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int n, long l) {
        this.this$0.mOnClickListener.onClick((DialogInterface)this.val$dialog.mDialog, n);
        if (this.this$0.mIsSingleChoice) return;
        this.val$dialog.mDialog.dismiss();
    }
}
