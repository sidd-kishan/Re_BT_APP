/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.ArrayMap
 *  android.util.Pair
 */
package androidx.camera.core.impl;

import android.util.ArrayMap;
import android.util.Pair;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TagBundle {
    private static final TagBundle EMPTY_TAGBUNDLE = new TagBundle((Map<String, Integer>)new ArrayMap());
    protected final Map<String, Integer> mTagMap;

    protected TagBundle(Map<String, Integer> map) {
        this.mTagMap = map;
    }

    public static TagBundle create(Pair<String, Integer> pair) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put((String)pair.first, (Integer)pair.second);
        return new TagBundle((Map<String, Integer>)arrayMap);
    }

    public static TagBundle emptyBundle() {
        return EMPTY_TAGBUNDLE;
    }

    public static TagBundle from(TagBundle tagBundle) {
        ArrayMap arrayMap = new ArrayMap();
        Iterator<String> iterator = tagBundle.listKeys().iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            arrayMap.put(string, tagBundle.getTag(string));
        }
        return new TagBundle((Map<String, Integer>)arrayMap);
    }

    public Integer getTag(String string) {
        return this.mTagMap.get(string);
    }

    public Set<String> listKeys() {
        return this.mTagMap.keySet();
    }
}
