/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.FullLifecycleObserver
 *  androidx.lifecycle.FullLifecycleObserverAdapter$1
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.lifecycle;

import androidx.lifecycle.FullLifecycleObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

class FullLifecycleObserverAdapter
implements LifecycleEventObserver {
    private final FullLifecycleObserver mFullLifecycleObserver;
    private final LifecycleEventObserver mLifecycleEventObserver;

    FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver, LifecycleEventObserver lifecycleEventObserver) {
        this.mFullLifecycleObserver = fullLifecycleObserver;
        this.mLifecycleEventObserver = lifecycleEventObserver;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[event.ordinal()]) {
            default: {
                break;
            }
            case 7: {
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            }
            case 6: {
                this.mFullLifecycleObserver.onDestroy(lifecycleOwner);
                break;
            }
            case 5: {
                this.mFullLifecycleObserver.onStop(lifecycleOwner);
                break;
            }
            case 4: {
                this.mFullLifecycleObserver.onPause(lifecycleOwner);
                break;
            }
            case 3: {
                this.mFullLifecycleObserver.onResume(lifecycleOwner);
                break;
            }
            case 2: {
                this.mFullLifecycleObserver.onStart(lifecycleOwner);
                break;
            }
            case 1: {
                this.mFullLifecycleObserver.onCreate(lifecycleOwner);
            }
        }
        LifecycleEventObserver lifecycleEventObserver = this.mLifecycleEventObserver;
        if (lifecycleEventObserver == null) return;
        lifecycleEventObserver.onStateChanged(lifecycleOwner, event);
    }
}
