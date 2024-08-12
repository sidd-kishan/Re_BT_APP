/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  androidx.appcompat.widget.ActivityChooserView
 */
package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import androidx.appcompat.widget.ActivityChooserView;

class ActivityChooserView.2
implements ViewTreeObserver.OnGlobalLayoutListener {
    final ActivityChooserView this$0;

    ActivityChooserView.2(ActivityChooserView activityChooserView) {
        this.this$0 = activityChooserView;
    }

    public void onGlobalLayout() {
        if (!this.this$0.isShowingPopup()) return;
        if (!this.this$0.isShown()) {
            this.this$0.getListPopupWindow().dismiss();
        } else {
            this.this$0.getListPopupWindow().show();
            if (this.this$0.mProvider == null) return;
            this.this$0.mProvider.subUiVisibilityChanged(true);
        }
    }
}
