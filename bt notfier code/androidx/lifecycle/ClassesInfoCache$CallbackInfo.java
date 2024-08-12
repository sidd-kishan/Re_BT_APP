/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ClassesInfoCache$MethodReference
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.lifecycle;

import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

static class ClassesInfoCache.CallbackInfo {
    final Map<Lifecycle.Event, List<ClassesInfoCache.MethodReference>> mEventToHandlers;
    final Map<ClassesInfoCache.MethodReference, Lifecycle.Event> mHandlerToEvent;

    ClassesInfoCache.CallbackInfo(Map<ClassesInfoCache.MethodReference, Lifecycle.Event> arrayList) {
        this.mHandlerToEvent = arrayList;
        this.mEventToHandlers = new HashMap<Lifecycle.Event, List<ClassesInfoCache.MethodReference>>();
        Iterator<Map.Entry<ClassesInfoCache.MethodReference, Lifecycle.Event>> iterator = arrayList.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<ClassesInfoCache.MethodReference, Lifecycle.Event> entry = iterator.next();
            Lifecycle.Event event = entry.getValue();
            List<ClassesInfoCache.MethodReference> list = this.mEventToHandlers.get(event);
            arrayList = list;
            if (list == null) {
                arrayList = new ArrayList<ClassesInfoCache.MethodReference>();
                this.mEventToHandlers.put(event, arrayList);
            }
            arrayList.add(entry.getKey());
        }
    }

    private static void invokeMethodsForEvent(List<ClassesInfoCache.MethodReference> list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object object) {
        if (list == null) return;
        int n = list.size() - 1;
        while (n >= 0) {
            list.get(n).invokeCallback(lifecycleOwner, event, object);
            --n;
        }
    }

    void invokeCallbacks(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object object) {
        ClassesInfoCache.CallbackInfo.invokeMethodsForEvent(this.mEventToHandlers.get(event), lifecycleOwner, event, object);
        ClassesInfoCache.CallbackInfo.invokeMethodsForEvent(this.mEventToHandlers.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, object);
    }
}
