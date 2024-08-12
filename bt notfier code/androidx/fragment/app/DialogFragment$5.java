/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.fragment.app.DialogFragment
 *  androidx.fragment.app.FragmentContainer
 */
package androidx.fragment.app;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentContainer;

class DialogFragment.5
extends FragmentContainer {
    final DialogFragment this$0;
    final FragmentContainer val$fragmentContainer;

    DialogFragment.5(DialogFragment dialogFragment, FragmentContainer fragmentContainer) {
        this.this$0 = dialogFragment;
        this.val$fragmentContainer = fragmentContainer;
    }

    public View onFindViewById(int n) {
        if (!this.val$fragmentContainer.onHasView()) return this.this$0.onFindViewById(n);
        return this.val$fragmentContainer.onFindViewById(n);
    }

    public boolean onHasView() {
        boolean bl = this.val$fragmentContainer.onHasView() || this.this$0.onHasView();
        return bl;
    }
}
