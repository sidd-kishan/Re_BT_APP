/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.reactivestreams.Subscriber
 */
package org.reactivestreams;

import org.reactivestreams.Subscriber;

public interface Publisher<T> {
    public void subscribe(Subscriber<? super T> var1);
}
