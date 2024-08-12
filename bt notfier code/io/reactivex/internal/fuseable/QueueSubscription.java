/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.fuseable.QueueFuseable
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.fuseable;

import io.reactivex.internal.fuseable.QueueFuseable;
import org.reactivestreams.Subscription;

public interface QueueSubscription<T>
extends QueueFuseable<T>,
Subscription {
}
