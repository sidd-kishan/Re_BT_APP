/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcelable
 *  androidx.activity.contextaware.OnContextAvailableListener
 *  androidx.fragment.app.FragmentActivity
 */
package androidx.fragment.app;

import android.content.Context;
import android.os.Parcelable;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.fragment.app.FragmentActivity;

class FragmentActivity.2
implements OnContextAvailableListener {
    final FragmentActivity this$0;

    FragmentActivity.2(FragmentActivity fragmentActivity) {
        this.this$0 = fragmentActivity;
    }

    public void onContextAvailable(Context context) {
        this.this$0.mFragments.attachHost(null);
        context = this.this$0.getSavedStateRegistry().consumeRestoredStateForKey("android:support:fragments");
        if (context == null) return;
        context = context.getParcelable("android:support:fragments");
        this.this$0.mFragments.restoreSaveState((Parcelable)context);
    }
}
