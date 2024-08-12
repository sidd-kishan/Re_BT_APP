/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  androidx.appcompat.widget.ActivityChooserModel
 *  androidx.appcompat.widget.ActivityChooserModel$OnChooseActivityListener
 *  androidx.appcompat.widget.ShareActionProvider
 */
package androidx.appcompat.widget;

import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.ShareActionProvider;

private class ShareActionProvider.ShareActivityChooserModelPolicy
implements ActivityChooserModel.OnChooseActivityListener {
    final ShareActionProvider this$0;

    ShareActionProvider.ShareActivityChooserModelPolicy(ShareActionProvider shareActionProvider) {
        this.this$0 = shareActionProvider;
    }

    public boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent) {
        if (this.this$0.mOnShareTargetSelectedListener == null) return false;
        this.this$0.mOnShareTargetSelectedListener.onShareTargetSelected(this.this$0, intent);
        return false;
    }
}
