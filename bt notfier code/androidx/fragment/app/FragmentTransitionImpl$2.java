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
import java.util.Map;

/*
 * Exception performing whole class analysis ignored.
 */
class FragmentTransitionImpl.2
implements Runnable {
    final FragmentTransitionImpl this$0;
    final Map val$nameOverrides;
    final ArrayList val$sharedElementsIn;

    FragmentTransitionImpl.2(FragmentTransitionImpl fragmentTransitionImpl, ArrayList arrayList, Map map) {
        this.this$0 = fragmentTransitionImpl;
        this.val$sharedElementsIn = arrayList;
        this.val$nameOverrides = map;
    }

    @Override
    public void run() {
        int n = this.val$sharedElementsIn.size();
        int n2 = 0;
        while (n2 < n) {
            View view = (View)this.val$sharedElementsIn.get(n2);
            String string = ViewCompat.getTransitionName((View)view);
            if (string != null) {
                ViewCompat.setTransitionName((View)view, (String)FragmentTransitionImpl.findKeyForValue((Map)this.val$nameOverrides, (String)string));
            }
            ++n2;
        }
    }
}
