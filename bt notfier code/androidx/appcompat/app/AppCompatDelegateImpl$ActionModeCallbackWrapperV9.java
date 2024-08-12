/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  androidx.appcompat.app.AppCompatDelegateImpl
 *  androidx.appcompat.view.ActionMode
 *  androidx.appcompat.view.ActionMode$Callback
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewPropertyAnimatorListener
 */
package androidx.appcompat.app;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

class AppCompatDelegateImpl.ActionModeCallbackWrapperV9
implements ActionMode.Callback {
    private ActionMode.Callback mWrapped;
    final AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl.ActionModeCallbackWrapperV9(AppCompatDelegateImpl appCompatDelegateImpl, ActionMode.Callback callback) {
        this.this$0 = appCompatDelegateImpl;
        this.mWrapped = callback;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.mWrapped.onActionItemClicked(actionMode, menuItem);
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.mWrapped.onCreateActionMode(actionMode, menu);
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.mWrapped.onDestroyActionMode(actionMode);
        if (this.this$0.mActionModePopup != null) {
            this.this$0.mWindow.getDecorView().removeCallbacks(this.this$0.mShowActionModePopup);
        }
        if (this.this$0.mActionModeView != null) {
            this.this$0.endOnGoingFadeAnimation();
            actionMode = this.this$0;
            actionMode.mFadeAnim = ViewCompat.animate((View)actionMode.mActionModeView).alpha(0.0f);
            this.this$0.mFadeAnim.setListener((ViewPropertyAnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        }
        if (this.this$0.mAppCompatCallback != null) {
            this.this$0.mAppCompatCallback.onSupportActionModeFinished(this.this$0.mActionMode);
        }
        this.this$0.mActionMode = null;
        ViewCompat.requestApplyInsets((View)this.this$0.mSubDecor);
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        ViewCompat.requestApplyInsets((View)this.this$0.mSubDecor);
        return this.mWrapped.onPrepareActionMode(actionMode, menu);
    }
}
