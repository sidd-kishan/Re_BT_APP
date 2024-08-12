/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle$Event
 *  com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
 *  com.uber.autodispose.lifecycle.CorrespondingEventsFunction
 */
package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import com.uber.autodispose.lifecycle.CorrespondingEventsFunction;

public final class _$$Lambda$AndroidLifecycleScopeProvider$uFMlIgTptYb7BCfIVGpgOzYAiAs
implements CorrespondingEventsFunction {
    public static final _$$Lambda$AndroidLifecycleScopeProvider$uFMlIgTptYb7BCfIVGpgOzYAiAs INSTANCE = new _$$Lambda$AndroidLifecycleScopeProvider$uFMlIgTptYb7BCfIVGpgOzYAiAs();

    private /* synthetic */ _$$Lambda$AndroidLifecycleScopeProvider$uFMlIgTptYb7BCfIVGpgOzYAiAs() {
    }

    public final Object apply(Object object) {
        return AndroidLifecycleScopeProvider.lambda$static$0((Lifecycle.Event)((Lifecycle.Event)object));
    }
}
