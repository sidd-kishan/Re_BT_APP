/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.os.Bundle
 *  com.google.android.gms.common.data.DataHolder
 *  com.google.android.gms.common.data.zab
 *  com.google.android.gms.common.internal.Asserts
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zab;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public static class DataHolder.Builder {
    private final String[] zaa;
    private final ArrayList<HashMap<String, Object>> zab;
    private final HashMap<Object, Integer> zac;

    /* synthetic */ DataHolder.Builder(String[] stringArray, String string, zab zab2) {
        this.zaa = (String[])Preconditions.checkNotNull((Object)stringArray);
        this.zab = new ArrayList();
        this.zac = new HashMap();
    }

    static /* synthetic */ String[] zab(DataHolder.Builder builder) {
        return builder.zaa;
    }

    static /* synthetic */ ArrayList zac(DataHolder.Builder builder) {
        return builder.zab;
    }

    public DataHolder build(int n) {
        return new DataHolder(this, n, null, null);
    }

    public DataHolder build(int n, Bundle bundle) {
        return new DataHolder(this, n, bundle, -1, null);
    }

    public DataHolder.Builder withRow(ContentValues object) {
        Asserts.checkNotNull((Object)object);
        HashMap<String, Object> hashMap = new HashMap<String, Object>(object.size());
        object = object.valueSet().iterator();
        while (object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            hashMap.put((String)entry.getKey(), entry.getValue());
        }
        return this.zaa(hashMap);
    }

    public DataHolder.Builder zaa(HashMap<String, Object> hashMap) {
        Asserts.checkNotNull(hashMap);
        this.zab.add(hashMap);
        return this;
    }
}
