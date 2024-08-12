/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.Window$Callback
 *  androidx.collection.SimpleArrayMap
 *  androidx.core.app.ComponentActivity$ExtraData
 *  androidx.core.view.KeyEventDispatcher
 *  androidx.core.view.KeyEventDispatcher$Component
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleRegistry
 *  androidx.lifecycle.ReportFragment
 */
package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ComponentActivity;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;

public class ComponentActivity
extends Activity
implements LifecycleOwner,
KeyEventDispatcher.Component {
    private SimpleArrayMap<Class<? extends ExtraData>, ExtraData> mExtraDataMap = new SimpleArrayMap();
    private LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry((LifecycleOwner)this);

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View view = this.getWindow().getDecorView();
        if (view == null) return KeyEventDispatcher.dispatchKeyEvent((KeyEventDispatcher.Component)this, (View)view, (Window.Callback)this, (KeyEvent)keyEvent);
        if (!KeyEventDispatcher.dispatchBeforeHierarchy((View)view, (KeyEvent)keyEvent)) return KeyEventDispatcher.dispatchKeyEvent((KeyEventDispatcher.Component)this, (View)view, (Window.Callback)this, (KeyEvent)keyEvent);
        return true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View view = this.getWindow().getDecorView();
        if (view == null) return super.dispatchKeyShortcutEvent(keyEvent);
        if (!KeyEventDispatcher.dispatchBeforeHierarchy((View)view, (KeyEvent)keyEvent)) return super.dispatchKeyShortcutEvent(keyEvent);
        return true;
    }

    @Deprecated
    public <T extends ExtraData> T getExtraData(Class<T> clazz) {
        return (T)((ExtraData)this.mExtraDataMap.get(clazz));
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.injectIfNeededIn((Activity)this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    public void putExtraData(ExtraData extraData) {
        this.mExtraDataMap.put(extraData.getClass(), (Object)extraData);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
