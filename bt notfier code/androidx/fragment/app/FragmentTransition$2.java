/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.FragmentTransition
 */
package androidx.fragment.app;

import androidx.fragment.app.FragmentTransition;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
class FragmentTransition.2
implements Runnable {
    final ArrayList val$exitingViews;

    FragmentTransition.2(ArrayList arrayList) {
        this.val$exitingViews = arrayList;
    }

    @Override
    public void run() {
        FragmentTransition.setViewVisibility((ArrayList)this.val$exitingViews, (int)4);
    }
}
