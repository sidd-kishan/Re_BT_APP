/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.fuseable.QueueFuseable
 */
package io.reactivex.internal.fuseable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.QueueFuseable;

public interface QueueDisposable<T>
extends QueueFuseable<T>,
Disposable {
}
