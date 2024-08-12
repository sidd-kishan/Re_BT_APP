/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.lifecycle.SavedStateHandle
 *  androidx.savedstate.SavedStateRegistry$SavedStateProvider
 */
package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class SavedStateHandle.1
implements SavedStateRegistry.SavedStateProvider {
    final SavedStateHandle this$0;

    SavedStateHandle.1(SavedStateHandle savedStateHandle) {
        this.this$0 = savedStateHandle;
    }

    public Bundle saveState() {
        Object object;
        for (Map.Entry object22 : new HashMap(this.this$0.mSavedStateProviders).entrySet()) {
            object = ((SavedStateRegistry.SavedStateProvider)object22.getValue()).saveState();
            this.this$0.set((String)object22.getKey(), object);
        }
        object = this.this$0.mRegular.keySet();
        ArrayList arrayList = new ArrayList(object.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator iterator = object.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                object = new Bundle();
                object.putParcelableArrayList("keys", arrayList);
                object.putParcelableArrayList("values", arrayList2);
                return object;
            }
            object = (String)iterator.next();
            arrayList.add(object);
            arrayList2.add(this.this$0.mRegular.get(object));
        }
    }
}
