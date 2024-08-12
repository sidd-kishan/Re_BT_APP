/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ViewModel
 */
package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ViewModelStore {
    private final HashMap<String, ViewModel> mMap = new HashMap();

    public final void clear() {
        Iterator<ViewModel> iterator = this.mMap.values().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.mMap.clear();
                return;
            }
            iterator.next().clear();
        }
    }

    final ViewModel get(String string) {
        return this.mMap.get(string);
    }

    Set<String> keys() {
        return new HashSet<String>(this.mMap.keySet());
    }

    final void put(String string, ViewModel viewModel) {
        if ((string = this.mMap.put(string, viewModel)) == null) return;
        string.onCleared();
    }
}
