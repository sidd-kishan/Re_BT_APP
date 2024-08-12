/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnUnhandledKeyEventListener
 *  androidx.collection.SimpleArrayMap
 *  androidx.core.R$id
 *  androidx.core.view.ViewCompat$OnUnhandledKeyEventListenerCompat
 */
package androidx.core.view;

import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.R;
import androidx.core.view.ViewCompat;

static class ViewCompat.CompatImplApi28 {
    private ViewCompat.CompatImplApi28() {
    }

    static void addOnUnhandledKeyEventListener(View view, ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        SimpleArrayMap simpleArrayMap;
        SimpleArrayMap simpleArrayMap2 = simpleArrayMap = (SimpleArrayMap)view.getTag(R.id.tag_unhandled_key_listeners);
        if (simpleArrayMap == null) {
            simpleArrayMap2 = new SimpleArrayMap();
            view.setTag(R.id.tag_unhandled_key_listeners, (Object)simpleArrayMap2);
        }
        simpleArrayMap = new /* Unavailable Anonymous Inner Class!! */;
        simpleArrayMap2.put((Object)onUnhandledKeyEventListenerCompat, (Object)simpleArrayMap);
        view.addOnUnhandledKeyEventListener((View.OnUnhandledKeyEventListener)simpleArrayMap);
    }

    static void removeOnUnhandledKeyEventListener(View view, ViewCompat.OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap)view.getTag(R.id.tag_unhandled_key_listeners);
        if (simpleArrayMap == null) {
            return;
        }
        if ((onUnhandledKeyEventListenerCompat = (View.OnUnhandledKeyEventListener)simpleArrayMap.get((Object)onUnhandledKeyEventListenerCompat)) == null) return;
        view.removeOnUnhandledKeyEventListener((View.OnUnhandledKeyEventListener)onUnhandledKeyEventListenerCompat);
    }
}
