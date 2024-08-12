/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  androidx.fragment.app.DialogFragment
 *  androidx.fragment.app.FragmentManager
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.Observer
 */
package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

/*
 * Exception performing whole class analysis ignored.
 */
class DialogFragment.4
implements Observer<LifecycleOwner> {
    final DialogFragment this$0;

    DialogFragment.4(DialogFragment dialogFragment) {
        this.this$0 = dialogFragment;
    }

    public void onChanged(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null) return;
        if (!DialogFragment.access$200((DialogFragment)this.this$0)) return;
        lifecycleOwner = this.this$0.requireView();
        if (lifecycleOwner.getParent() != null) throw new IllegalStateException("DialogFragment can not be attached to a container view");
        if (DialogFragment.access$000((DialogFragment)this.this$0) == null) return;
        if (FragmentManager.isLoggingEnabled((int)3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DialogFragment ");
            stringBuilder.append(this);
            stringBuilder.append(" setting the content view on ");
            stringBuilder.append(DialogFragment.access$000((DialogFragment)this.this$0));
            Log.d((String)"FragmentManager", (String)stringBuilder.toString());
        }
        DialogFragment.access$000((DialogFragment)this.this$0).setContentView((View)lifecycleOwner);
    }
}
