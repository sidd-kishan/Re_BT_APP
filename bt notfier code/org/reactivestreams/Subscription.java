/*
 * Decompiled with CFR 0.152.
 */
package org.reactivestreams;

public interface Subscription {
    public void cancel();

    public void request(long var1);
}
