/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.app.AlertController
 *  androidx.core.widget.NestedScrollView
 *  androidx.core.widget.NestedScrollView$OnScrollChangeListener
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.AlertController;
import androidx.core.widget.NestedScrollView;

/*
 * Exception performing whole class analysis ignored.
 */
class AlertController.2
implements NestedScrollView.OnScrollChangeListener {
    final AlertController this$0;
    final View val$bottom;
    final View val$top;

    AlertController.2(AlertController alertController, View view, View view2) {
        this.this$0 = alertController;
        this.val$top = view;
        this.val$bottom = view2;
    }

    public void onScrollChange(NestedScrollView nestedScrollView, int n, int n2, int n3, int n4) {
        AlertController.manageScrollIndicators((View)nestedScrollView, (View)this.val$top, (View)this.val$bottom);
    }
}
