/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle$Event
 *  com.uber.autodispose.OutsideScopeException
 *  com.uber.autodispose.lifecycle.CorrespondingEventsFunction
 */
package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.uber.autodispose.OutsideScopeException;
import com.uber.autodispose.lifecycle.CorrespondingEventsFunction;

private static class AndroidLifecycleScopeProvider.UntilEventFunction
implements CorrespondingEventsFunction<Lifecycle.Event> {
    private final Lifecycle.Event untilEvent;

    AndroidLifecycleScopeProvider.UntilEventFunction(Lifecycle.Event event) {
        this.untilEvent = event;
    }

    public Lifecycle.Event apply(Lifecycle.Event event) throws OutsideScopeException {
        return this.untilEvent;
    }
}
