/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  androidx.activity.ComponentActivity
 *  androidx.activity.contextaware.OnContextAvailableListener
 */
package androidx.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.OnContextAvailableListener;

/*
 * Exception performing whole class analysis ignored.
 */
class ComponentActivity.7
implements OnContextAvailableListener {
    final ComponentActivity this$0;

    ComponentActivity.7(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    public void onContextAvailable(Context context) {
        context = this.this$0.getSavedStateRegistry().consumeRestoredStateForKey("android:support:activity-result");
        if (context == null) return;
        ComponentActivity.access$100((ComponentActivity)this.this$0).onRestoreInstanceState((Bundle)context);
    }
}
