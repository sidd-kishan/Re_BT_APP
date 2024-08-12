/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleOwner
 *  com.uber.autodispose.OutsideScopeException
 *  com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider$1
 *  com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider$UntilEventFunction
 *  com.uber.autodispose.android.lifecycle.LifecycleEventsObservable
 *  com.uber.autodispose.android.lifecycle._$$Lambda$AndroidLifecycleScopeProvider$uFMlIgTptYb7BCfIVGpgOzYAiAs
 *  com.uber.autodispose.lifecycle.CorrespondingEventsFunction
 *  com.uber.autodispose.lifecycle.LifecycleEndedException
 *  com.uber.autodispose.lifecycle.LifecycleScopeProvider
 *  com.uber.autodispose.lifecycle.LifecycleScopes
 *  io.reactivex.CompletableSource
 *  io.reactivex.Observable
 */
package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.uber.autodispose.OutsideScopeException;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import com.uber.autodispose.android.lifecycle.LifecycleEventsObservable;
import com.uber.autodispose.android.lifecycle._$;
import com.uber.autodispose.lifecycle.CorrespondingEventsFunction;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import com.uber.autodispose.lifecycle.LifecycleScopeProvider;
import com.uber.autodispose.lifecycle.LifecycleScopes;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;

public final class AndroidLifecycleScopeProvider
implements LifecycleScopeProvider<Lifecycle.Event> {
    private static final CorrespondingEventsFunction<Lifecycle.Event> DEFAULT_CORRESPONDING_EVENTS = _$.Lambda.AndroidLifecycleScopeProvider.uFMlIgTptYb7BCfIVGpgOzYAiAs.INSTANCE;
    private final CorrespondingEventsFunction<Lifecycle.Event> boundaryResolver;
    private final LifecycleEventsObservable lifecycleObservable;

    private AndroidLifecycleScopeProvider(Lifecycle lifecycle, CorrespondingEventsFunction<Lifecycle.Event> correspondingEventsFunction) {
        this.lifecycleObservable = new LifecycleEventsObservable(lifecycle);
        this.boundaryResolver = correspondingEventsFunction;
    }

    public static AndroidLifecycleScopeProvider from(Lifecycle lifecycle) {
        return AndroidLifecycleScopeProvider.from(lifecycle, DEFAULT_CORRESPONDING_EVENTS);
    }

    public static AndroidLifecycleScopeProvider from(Lifecycle lifecycle, Lifecycle.Event event) {
        return AndroidLifecycleScopeProvider.from(lifecycle, (CorrespondingEventsFunction<Lifecycle.Event>)new UntilEventFunction(event));
    }

    public static AndroidLifecycleScopeProvider from(Lifecycle lifecycle, CorrespondingEventsFunction<Lifecycle.Event> correspondingEventsFunction) {
        return new AndroidLifecycleScopeProvider(lifecycle, correspondingEventsFunction);
    }

    public static AndroidLifecycleScopeProvider from(LifecycleOwner lifecycleOwner) {
        return AndroidLifecycleScopeProvider.from(lifecycleOwner.getLifecycle());
    }

    public static AndroidLifecycleScopeProvider from(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        return AndroidLifecycleScopeProvider.from(lifecycleOwner.getLifecycle(), event);
    }

    public static AndroidLifecycleScopeProvider from(LifecycleOwner lifecycleOwner, CorrespondingEventsFunction<Lifecycle.Event> correspondingEventsFunction) {
        return AndroidLifecycleScopeProvider.from(lifecycleOwner.getLifecycle(), correspondingEventsFunction);
    }

    static /* synthetic */ Lifecycle.Event lambda$static$0(Lifecycle.Event event) throws OutsideScopeException {
        int n = 1.$SwitchMap$android$arch$lifecycle$Lifecycle$Event[event.ordinal()];
        if (n == 1) return Lifecycle.Event.ON_DESTROY;
        if (n == 2) return Lifecycle.Event.ON_STOP;
        if (n == 3) return Lifecycle.Event.ON_PAUSE;
        if (n == 4) {
            return Lifecycle.Event.ON_STOP;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lifecycle has ended! Last event was ");
        stringBuilder.append(event);
        throw new LifecycleEndedException(stringBuilder.toString());
    }

    public CorrespondingEventsFunction<Lifecycle.Event> correspondingEvents() {
        return this.boundaryResolver;
    }

    public Observable<Lifecycle.Event> lifecycle() {
        return this.lifecycleObservable;
    }

    public Lifecycle.Event peekLifecycle() {
        this.lifecycleObservable.backfillEvents();
        return this.lifecycleObservable.getValue();
    }

    public CompletableSource requestScope() {
        return LifecycleScopes.resolveScopeFromLifecycle((LifecycleScopeProvider)this);
    }
}
