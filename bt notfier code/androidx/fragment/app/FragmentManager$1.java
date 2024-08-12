/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.OnBackPressedCallback
 *  androidx.fragment.app.FragmentManager
 */
package androidx.fragment.app;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentManager;

class FragmentManager.1
extends OnBackPressedCallback {
    final FragmentManager this$0;

    FragmentManager.1(FragmentManager fragmentManager, boolean bl) {
        this.this$0 = fragmentManager;
        super(bl);
    }

    public void handleOnBackPressed() {
        this.this$0.handleOnBackPressed();
    }
}
