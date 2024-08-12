/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  androidx.fragment.app.DefaultSpecialEffectsController
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.SpecialEffectsController
 *  androidx.fragment.app.SpecialEffectsControllerFactory
 */
package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.SpecialEffectsControllerFactory;

class FragmentManager.4
implements SpecialEffectsControllerFactory {
    final FragmentManager this$0;

    FragmentManager.4(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    public SpecialEffectsController createController(ViewGroup viewGroup) {
        return new DefaultSpecialEffectsController(viewGroup);
    }
}
