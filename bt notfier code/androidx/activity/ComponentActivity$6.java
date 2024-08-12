/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.activity.ComponentActivity
 *  androidx.savedstate.SavedStateRegistry$SavedStateProvider
 */
package androidx.activity;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.savedstate.SavedStateRegistry;

/*
 * Exception performing whole class analysis ignored.
 */
class ComponentActivity.6
implements SavedStateRegistry.SavedStateProvider {
    final ComponentActivity this$0;

    ComponentActivity.6(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    public Bundle saveState() {
        Bundle bundle = new Bundle();
        ComponentActivity.access$100((ComponentActivity)this.this$0).onSaveInstanceState(bundle);
        return bundle;
    }
}
