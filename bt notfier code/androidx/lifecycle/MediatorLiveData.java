/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.internal.SafeIterableMap
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.MediatorLiveData$Source
 *  androidx.lifecycle.MutableLiveData
 *  androidx.lifecycle.Observer
 */
package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.Iterator;
import java.util.Map;

public class MediatorLiveData<T>
extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> mSources = new SafeIterableMap();

    public <S> void addSource(LiveData<S> source, Observer<? super S> observer) {
        Source source2 = new Source(source, observer);
        if ((source = (Source)this.mSources.putIfAbsent(source, (Object)source2)) != null) {
            if (source.mObserver != observer) throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (source != null) {
            return;
        }
        if (!this.hasActiveObservers()) return;
        source2.plug();
    }

    protected void onActive() {
        Iterator iterator = this.mSources.iterator();
        while (iterator.hasNext()) {
            ((Source)((Map.Entry)iterator.next()).getValue()).plug();
        }
    }

    protected void onInactive() {
        Iterator iterator = this.mSources.iterator();
        while (iterator.hasNext()) {
            ((Source)((Map.Entry)iterator.next()).getValue()).unplug();
        }
    }

    public <S> void removeSource(LiveData<S> source) {
        if ((source = (Source)this.mSources.remove(source)) == null) return;
        source.unplug();
    }
}
