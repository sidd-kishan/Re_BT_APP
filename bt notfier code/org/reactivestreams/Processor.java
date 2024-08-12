/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package org.reactivestreams;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public interface Processor<T, R>
extends Subscriber<T>,
Publisher<R> {
}
