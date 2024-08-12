/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.subscribers.QueueDrainSubscriberPad0
 */
package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscribers.QueueDrainSubscriberPad0;
import java.util.concurrent.atomic.AtomicInteger;

class QueueDrainSubscriberWip
extends QueueDrainSubscriberPad0 {
    final AtomicInteger wip = new AtomicInteger();

    QueueDrainSubscriberWip() {
    }
}
