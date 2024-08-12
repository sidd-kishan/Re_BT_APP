/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.arch.core.internal.SafeIterableMap
 *  androidx.arch.core.internal.SafeIterableMap$IteratorWithAdditions
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.savedstate.Recreator$SavedStateProvider
 *  androidx.savedstate.SavedStateRegistry$AutoRecreated
 *  androidx.savedstate.SavedStateRegistry$SavedStateProvider
 */
package androidx.savedstate;

import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry;
import java.util.Map;

public final class SavedStateRegistry {
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    boolean mAllowingSavingState = true;
    private SafeIterableMap<String, SavedStateProvider> mComponents = new SafeIterableMap();
    private Recreator.SavedStateProvider mRecreatorProvider;
    private boolean mRestored;
    private Bundle mRestoredState;

    SavedStateRegistry() {
    }

    public Bundle consumeRestoredStateForKey(String string) {
        if (!this.mRestored) throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        Bundle bundle = this.mRestoredState;
        if (bundle == null) return null;
        bundle = bundle.getBundle(string);
        this.mRestoredState.remove(string);
        if (!this.mRestoredState.isEmpty()) return bundle;
        this.mRestoredState = null;
        return bundle;
    }

    public boolean isRestored() {
        return this.mRestored;
    }

    void performRestore(Lifecycle lifecycle, Bundle bundle) {
        if (this.mRestored) throw new IllegalStateException("SavedStateRegistry was already restored.");
        if (bundle != null) {
            this.mRestoredState = bundle.getBundle(SAVED_COMPONENTS_KEY);
        }
        lifecycle.addObserver((LifecycleObserver)new /* Unavailable Anonymous Inner Class!! */);
        this.mRestored = true;
    }

    void performSave(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Object object = this.mRestoredState;
        if (object != null) {
            bundle2.putAll((Bundle)object);
        }
        SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = this.mComponents.iteratorWithAdditions();
        while (true) {
            if (!iteratorWithAdditions.hasNext()) {
                bundle.putBundle(SAVED_COMPONENTS_KEY, bundle2);
                return;
            }
            object = (Map.Entry)iteratorWithAdditions.next();
            bundle2.putBundle((String)object.getKey(), ((SavedStateProvider)object.getValue()).saveState());
        }
    }

    public void registerSavedStateProvider(String string, SavedStateProvider savedStateProvider) {
        if ((SavedStateProvider)this.mComponents.putIfAbsent((Object)string, (Object)savedStateProvider) != null) throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
    }

    public void runOnNextRecreation(Class<? extends AutoRecreated> clazz) {
        if (!this.mAllowingSavingState) throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        if (this.mRecreatorProvider == null) {
            this.mRecreatorProvider = new Recreator.SavedStateProvider(this);
        }
        try {
            clazz.getDeclaredConstructor(new Class[0]);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Class");
            stringBuilder.append(clazz.getSimpleName());
            stringBuilder.append(" must have default constructor in order to be automatically recreated");
            throw new IllegalArgumentException(stringBuilder.toString(), noSuchMethodException);
        }
        this.mRecreatorProvider.add(clazz.getName());
    }

    public void unregisterSavedStateProvider(String string) {
        this.mComponents.remove((Object)string);
    }
}
