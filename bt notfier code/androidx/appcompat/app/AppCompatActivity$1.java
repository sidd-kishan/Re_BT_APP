/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.appcompat.app.AppCompatActivity
 *  androidx.savedstate.SavedStateRegistry$SavedStateProvider
 */
package androidx.appcompat.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.savedstate.SavedStateRegistry;

class AppCompatActivity.1
implements SavedStateRegistry.SavedStateProvider {
    final AppCompatActivity this$0;

    AppCompatActivity.1(AppCompatActivity appCompatActivity) {
        this.this$0 = appCompatActivity;
    }

    public Bundle saveState() {
        Bundle bundle = new Bundle();
        this.this$0.getDelegate().onSaveInstanceState(bundle);
        return bundle;
    }
}
