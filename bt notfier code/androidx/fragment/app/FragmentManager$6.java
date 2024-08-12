/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentResultListener
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.fragment.app;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/*
 * Exception performing whole class analysis ignored.
 */
class FragmentManager.6
implements LifecycleEventObserver {
    final FragmentManager this$0;
    final Lifecycle val$lifecycle;
    final FragmentResultListener val$listener;
    final String val$requestKey;

    FragmentManager.6(FragmentManager fragmentManager, String string, FragmentResultListener fragmentResultListener, Lifecycle lifecycle) {
        this.this$0 = fragmentManager;
        this.val$requestKey = string;
        this.val$listener = fragmentResultListener;
        this.val$lifecycle = lifecycle;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_START && (lifecycleOwner = (Bundle)FragmentManager.access$000((FragmentManager)this.this$0).get(this.val$requestKey)) != null) {
            this.val$listener.onFragmentResult(this.val$requestKey, (Bundle)lifecycleOwner);
            this.this$0.clearFragmentResult(this.val$requestKey);
        }
        if (event != Lifecycle.Event.ON_DESTROY) return;
        this.val$lifecycle.removeObserver((LifecycleObserver)this);
        FragmentManager.access$100((FragmentManager)this.this$0).remove(this.val$requestKey);
    }
}
