/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.GenericLifecycleObserver
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.savedstate.SavedStateRegistry$AutoRecreated
 *  androidx.savedstate.SavedStateRegistryOwner
 */
package androidx.savedstate;

import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

final class Recreator
implements GenericLifecycleObserver {
    static final String CLASSES_KEY = "classes_to_restore";
    static final String COMPONENT_KEY = "androidx.savedstate.Restarter";
    private final SavedStateRegistryOwner mOwner;

    Recreator(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.mOwner = savedStateRegistryOwner;
    }

    private void reflectiveNew(String charSequence) {
        Object object;
        SavedStateRegistry.AutoRecreated autoRecreated;
        try {
            autoRecreated = Class.forName((String)charSequence, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Class ");
            stringBuilder.append((String)charSequence);
            stringBuilder.append(" wasn't found");
            throw new RuntimeException(stringBuilder.toString(), classNotFoundException);
        }
        try {
            object = autoRecreated.getDeclaredConstructor(new Class[0]);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Class");
            ((StringBuilder)charSequence).append(autoRecreated.getSimpleName());
            ((StringBuilder)charSequence).append(" must have default constructor in order to be automatically recreated");
            throw new IllegalStateException(((StringBuilder)charSequence).toString(), noSuchMethodException);
        }
        ((AccessibleObject)object).setAccessible(true);
        try {
            autoRecreated = ((Constructor)object).newInstance(new Object[0]);
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Failed to instantiate ");
            ((StringBuilder)object).append((String)charSequence);
            throw new RuntimeException(((StringBuilder)object).toString(), exception);
        }
        autoRecreated.onRecreated(this.mOwner);
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_CREATE) {
            object = new AssertionError((Object)"Next event must be ON_CREATE");
            throw object;
        }
        object.getLifecycle().removeObserver((LifecycleObserver)this);
        object = this.mOwner.getSavedStateRegistry().consumeRestoredStateForKey(COMPONENT_KEY);
        if (object == null) {
            return;
        }
        if ((object = object.getStringArrayList(CLASSES_KEY)) == null) throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        object = ((ArrayList)object).iterator();
        while (object.hasNext()) {
            this.reflectiveNew((String)object.next());
        }
    }
}
