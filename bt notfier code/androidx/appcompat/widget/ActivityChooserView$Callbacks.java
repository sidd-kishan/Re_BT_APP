/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.content.pm.ResolveInfo
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.PopupWindow$OnDismissListener
 *  androidx.appcompat.widget.ActivityChooserView
 *  androidx.appcompat.widget.ActivityChooserView$ActivityChooserViewAdapter
 */
package androidx.appcompat.widget;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActivityChooserView;

private class ActivityChooserView.Callbacks
implements AdapterView.OnItemClickListener,
View.OnClickListener,
View.OnLongClickListener,
PopupWindow.OnDismissListener {
    final ActivityChooserView this$0;

    ActivityChooserView.Callbacks(ActivityChooserView activityChooserView) {
        this.this$0 = activityChooserView;
    }

    private void notifyOnDismissListener() {
        if (this.this$0.mOnDismissListener == null) return;
        this.this$0.mOnDismissListener.onDismiss();
    }

    public void onClick(View view) {
        if (view == this.this$0.mDefaultActivityButton) {
            this.this$0.dismissPopup();
            view = this.this$0.mAdapter.getDefaultActivity();
            int n = this.this$0.mAdapter.getDataModel().getActivityIndex((ResolveInfo)view);
            view = this.this$0.mAdapter.getDataModel().chooseActivity(n);
            if (view == null) return;
            view.addFlags(524288);
            this.this$0.getContext().startActivity((Intent)view);
        } else {
            if (view != this.this$0.mExpandActivityOverflowButton) throw new IllegalArgumentException();
            this.this$0.mIsSelectingDefaultActivity = false;
            view = this.this$0;
            view.showPopupUnchecked(view.mInitialActivityCount);
        }
    }

    public void onDismiss() {
        this.notifyOnDismissListener();
        if (this.this$0.mProvider == null) return;
        this.this$0.mProvider.subUiVisibilityChanged(false);
    }

    public void onItemClick(AdapterView<?> intent, View view, int n, long l) {
        int n2 = ((ActivityChooserView.ActivityChooserViewAdapter)intent.getAdapter()).getItemViewType(n);
        if (n2 != 0) {
            if (n2 != 1) throw new IllegalArgumentException();
            this.this$0.showPopupUnchecked(Integer.MAX_VALUE);
        } else {
            this.this$0.dismissPopup();
            if (this.this$0.mIsSelectingDefaultActivity) {
                if (n <= 0) return;
                this.this$0.mAdapter.getDataModel().setDefaultActivity(n);
            } else {
                if (!this.this$0.mAdapter.getShowDefaultActivity()) {
                    ++n;
                }
                intent = this.this$0.mAdapter.getDataModel().chooseActivity(n);
                if (intent == null) return;
                intent.addFlags(524288);
                this.this$0.getContext().startActivity(intent);
            }
        }
    }

    public boolean onLongClick(View view) {
        if (view != this.this$0.mDefaultActivityButton) throw new IllegalArgumentException();
        if (this.this$0.mAdapter.getCount() <= 0) return true;
        this.this$0.mIsSelectingDefaultActivity = true;
        view = this.this$0;
        view.showPopupUnchecked(view.mInitialActivityCount);
        return true;
    }
}
