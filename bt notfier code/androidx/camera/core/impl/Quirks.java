/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Quirk
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Quirk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Quirks {
    private final List<Quirk> mQuirks;

    public Quirks(List<Quirk> list) {
        this.mQuirks = new ArrayList<Quirk>(list);
    }

    public boolean contains(Class<? extends Quirk> clazz) {
        Iterator<Quirk> iterator = this.mQuirks.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!clazz.isAssignableFrom(iterator.next().getClass()));
        return true;
    }

    public <T extends Quirk> T get(Class<T> clazz) {
        Quirk quirk;
        Iterator<Quirk> iterator = this.mQuirks.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while ((quirk = iterator.next()).getClass() != clazz);
        return (T)quirk;
    }
}
