/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentContainer
 */
package androidx.fragment.app;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;

class Fragment.4
extends FragmentContainer {
    final Fragment this$0;

    Fragment.4(Fragment fragment) {
        this.this$0 = fragment;
    }

    public View onFindViewById(int n) {
        if (this.this$0.mView != null) {
            return this.this$0.mView.findViewById(n);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this.this$0);
        stringBuilder.append(" does not have a view");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public boolean onHasView() {
        boolean bl = this.this$0.mView != null;
        return bl;
    }
}
