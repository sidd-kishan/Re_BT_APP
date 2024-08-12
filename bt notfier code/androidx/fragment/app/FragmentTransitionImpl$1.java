/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  androidx.fragment.app.FragmentTransitionImpl
 */
package androidx.fragment.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;

class FragmentTransitionImpl.1
implements Runnable {
    final FragmentTransitionImpl this$0;
    final ArrayList val$inNames;
    final int val$numSharedElements;
    final ArrayList val$outNames;
    final ArrayList val$sharedElementsIn;
    final ArrayList val$sharedElementsOut;

    FragmentTransitionImpl.1(FragmentTransitionImpl fragmentTransitionImpl, int n, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.this$0 = fragmentTransitionImpl;
        this.val$numSharedElements = n;
        this.val$sharedElementsIn = arrayList;
        this.val$inNames = arrayList2;
        this.val$sharedElementsOut = arrayList3;
        this.val$outNames = arrayList4;
    }

    @Override
    public void run() {
        int n = 0;
        while (n < this.val$numSharedElements) {
            ViewCompat.setTransitionName((View)((View)this.val$sharedElementsIn.get(n)), (String)((String)this.val$inNames.get(n)));
            ViewCompat.setTransitionName((View)((View)this.val$sharedElementsOut.get(n)), (String)((String)this.val$outNames.get(n)));
            ++n;
        }
    }
}
