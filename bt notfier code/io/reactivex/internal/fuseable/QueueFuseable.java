/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.fuseable.SimpleQueue
 */
package io.reactivex.internal.fuseable;

import io.reactivex.internal.fuseable.SimpleQueue;

public interface QueueFuseable<T>
extends SimpleQueue<T> {
    public static final int ANY = 3;
    public static final int ASYNC = 2;
    public static final int BOUNDARY = 4;
    public static final int NONE = 0;
    public static final int SYNC = 1;

    public int requestFusion(int var1);
}
