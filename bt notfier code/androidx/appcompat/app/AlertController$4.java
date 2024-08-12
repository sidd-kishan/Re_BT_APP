/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AbsListView
 *  android.widget.AbsListView$OnScrollListener
 *  androidx.appcompat.app.AlertController
 */
package androidx.appcompat.app;

import android.view.View;
import android.widget.AbsListView;
import androidx.appcompat.app.AlertController;

/*
 * Exception performing whole class analysis ignored.
 */
class AlertController.4
implements AbsListView.OnScrollListener {
    final AlertController this$0;
    final View val$bottom;
    final View val$top;

    AlertController.4(AlertController alertController, View view, View view2) {
        this.this$0 = alertController;
        this.val$top = view;
        this.val$bottom = view2;
    }

    public void onScroll(AbsListView absListView, int n, int n2, int n3) {
        AlertController.manageScrollIndicators((View)absListView, (View)this.val$top, (View)this.val$bottom);
    }

    public void onScrollStateChanged(AbsListView absListView, int n) {
    }
}
