/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.manager.LifecycleListener
 *  com.bumptech.glide.request.target.Target
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.manager;

import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class TargetTracker
implements LifecycleListener {
    private final Set<Target<?>> targets = Collections.newSetFromMap(new WeakHashMap());

    public void clear() {
        this.targets.clear();
    }

    public List<Target<?>> getAll() {
        return Util.getSnapshot(this.targets);
    }

    public void onDestroy() {
        Iterator iterator = Util.getSnapshot(this.targets).iterator();
        while (iterator.hasNext()) {
            ((Target)iterator.next()).onDestroy();
        }
    }

    public void onStart() {
        Iterator iterator = Util.getSnapshot(this.targets).iterator();
        while (iterator.hasNext()) {
            ((Target)iterator.next()).onStart();
        }
    }

    public void onStop() {
        Iterator iterator = Util.getSnapshot(this.targets).iterator();
        while (iterator.hasNext()) {
            ((Target)iterator.next()).onStop();
        }
    }

    public void track(Target<?> target) {
        this.targets.add(target);
    }

    public void untrack(Target<?> target) {
        this.targets.remove(target);
    }
}
