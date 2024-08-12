/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.operators.flowable.FlowableGroupBy$GroupedUnicast
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.flowable.FlowableGroupBy;
import java.util.Queue;

static final class FlowableGroupBy.EvictionAction<K, V>
implements Consumer<FlowableGroupBy.GroupedUnicast<K, V>> {
    final Queue<FlowableGroupBy.GroupedUnicast<K, V>> evictedGroups;

    FlowableGroupBy.EvictionAction(Queue<FlowableGroupBy.GroupedUnicast<K, V>> queue) {
        this.evictedGroups = queue;
    }

    public void accept(FlowableGroupBy.GroupedUnicast<K, V> groupedUnicast) {
        this.evictedGroups.offer(groupedUnicast);
    }
}
