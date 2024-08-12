/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.ListPreloader$PreloadTarget
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide;

import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.util.Util;
import java.util.Queue;

private static final class ListPreloader.PreloadTargetQueue {
    private final Queue<ListPreloader.PreloadTarget> queue;

    ListPreloader.PreloadTargetQueue(int n) {
        this.queue = Util.createQueue((int)n);
        int n2 = 0;
        while (n2 < n) {
            this.queue.offer(new ListPreloader.PreloadTarget());
            ++n2;
        }
    }

    public ListPreloader.PreloadTarget next(int n, int n2) {
        ListPreloader.PreloadTarget preloadTarget = this.queue.poll();
        this.queue.offer(preloadTarget);
        preloadTarget.photoWidth = n;
        preloadTarget.photoHeight = n2;
        return preloadTarget;
    }
}
