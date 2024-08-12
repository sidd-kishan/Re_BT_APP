/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.ArrayMap
 *  androidx.camera.core.impl.TagBundle
 */
package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.camera.core.impl.TagBundle;
import java.util.Iterator;
import java.util.Map;

public class MutableTagBundle
extends TagBundle {
    private MutableTagBundle(Map<String, Integer> map) {
        super(map);
    }

    public static MutableTagBundle create() {
        return new MutableTagBundle((Map<String, Integer>)new ArrayMap());
    }

    public static MutableTagBundle from(TagBundle tagBundle) {
        ArrayMap arrayMap = new ArrayMap();
        Iterator iterator = tagBundle.listKeys().iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            arrayMap.put(string, tagBundle.getTag(string));
        }
        return new MutableTagBundle((Map<String, Integer>)arrayMap);
    }

    public void addTagBundle(TagBundle tagBundle) {
        if (this.mTagMap == null) return;
        if (tagBundle.mTagMap == null) return;
        this.mTagMap.putAll(tagBundle.mTagMap);
    }

    public void putTag(String string, Integer n) {
        this.mTagMap.put(string, n);
    }
}
