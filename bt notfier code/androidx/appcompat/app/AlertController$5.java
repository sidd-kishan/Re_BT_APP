/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.app.AlertController
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.AlertController;

/*
 * Exception performing whole class analysis ignored.
 */
class AlertController.5
implements Runnable {
    final AlertController this$0;
    final View val$bottom;
    final View val$top;

    AlertController.5(AlertController alertController, View view, View view2) {
        this.this$0 = alertController;
        this.val$top = view;
        this.val$bottom = view2;
    }

    @Override
    public void run() {
        AlertController.manageScrollIndicators((View)this.this$0.mListView, (View)this.val$top, (View)this.val$bottom);
    }
}
