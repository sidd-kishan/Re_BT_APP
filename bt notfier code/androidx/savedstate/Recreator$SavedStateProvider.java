/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.savedstate.SavedStateRegistry
 *  androidx.savedstate.SavedStateRegistry$SavedStateProvider
 */
package androidx.savedstate;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

static final class Recreator.SavedStateProvider
implements SavedStateRegistry.SavedStateProvider {
    final Set<String> mClasses = new HashSet<String>();

    Recreator.SavedStateProvider(SavedStateRegistry savedStateRegistry) {
        savedStateRegistry.registerSavedStateProvider("androidx.savedstate.Restarter", (SavedStateRegistry.SavedStateProvider)this);
    }

    void add(String string) {
        this.mClasses.add(string);
    }

    public Bundle saveState() {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("classes_to_restore", new ArrayList<String>(this.mClasses));
        return bundle;
    }
}
