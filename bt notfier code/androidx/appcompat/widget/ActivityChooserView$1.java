/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 *  androidx.appcompat.widget.ActivityChooserView
 */
package androidx.appcompat.widget;

import android.database.DataSetObserver;
import androidx.appcompat.widget.ActivityChooserView;

class ActivityChooserView.1
extends DataSetObserver {
    final ActivityChooserView this$0;

    ActivityChooserView.1(ActivityChooserView activityChooserView) {
        this.this$0 = activityChooserView;
    }

    public void onChanged() {
        super.onChanged();
        this.this$0.mAdapter.notifyDataSetChanged();
    }

    public void onInvalidated() {
        super.onInvalidated();
        this.this$0.mAdapter.notifyDataSetInvalidated();
    }
}
