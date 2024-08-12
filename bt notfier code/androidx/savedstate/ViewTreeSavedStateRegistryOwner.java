/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.savedstate.R$id
 *  androidx.savedstate.SavedStateRegistryOwner
 */
package androidx.savedstate;

import android.view.View;
import androidx.savedstate.R;
import androidx.savedstate.SavedStateRegistryOwner;

public final class ViewTreeSavedStateRegistryOwner {
    private ViewTreeSavedStateRegistryOwner() {
    }

    public static SavedStateRegistryOwner get(View view) {
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner)view.getTag(R.id.view_tree_saved_state_registry_owner);
        if (savedStateRegistryOwner != null) {
            return savedStateRegistryOwner;
        }
        view = view.getParent();
        while (savedStateRegistryOwner == null) {
            if (!(view instanceof View)) return savedStateRegistryOwner;
            savedStateRegistryOwner = (SavedStateRegistryOwner)view.getTag(R.id.view_tree_saved_state_registry_owner);
            view = view.getParent();
        }
        return savedStateRegistryOwner;
    }

    public static void set(View view, SavedStateRegistryOwner savedStateRegistryOwner) {
        view.setTag(R.id.view_tree_saved_state_registry_owner, (Object)savedStateRegistryOwner);
    }
}
