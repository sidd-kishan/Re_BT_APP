/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.subscribers.QueueDrainSubscriberPad2
 */
package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscribers.QueueDrainSubscriberPad2;
import java.util.concurrent.atomic.AtomicLong;

class QueueDrainSubscriberPad3
extends QueueDrainSubscriberPad2 {
    final AtomicLong requested = new AtomicLong();

    QueueDrainSubscriberPad3() {
    }
}
