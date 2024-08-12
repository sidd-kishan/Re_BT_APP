/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 *  androidx.fragment.app.FragmentActivity
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.savedstate.SavedStateRegistry$SavedStateProvider
 */
package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;

class FragmentActivity.1
implements SavedStateRegistry.SavedStateProvider {
    final FragmentActivity this$0;

    FragmentActivity.1(FragmentActivity fragmentActivity) {
        this.this$0 = fragmentActivity;
    }

    public Bundle saveState() {
        Bundle bundle = new Bundle();
        this.this$0.markFragmentsCreated();
        this.this$0.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        Parcelable parcelable = this.this$0.mFragments.saveAllState();
        if (parcelable == null) return bundle;
        bundle.putParcelable("android:support:fragments", parcelable);
        return bundle;
    }
}
