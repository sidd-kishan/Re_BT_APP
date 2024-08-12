/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  com.google.android.gms.common.data.DataHolder$Builder
 */
package com.google.android.gms.common.data;

import android.content.ContentValues;
import com.google.android.gms.common.data.DataHolder;
import java.util.HashMap;

final class zab
extends DataHolder.Builder {
    zab(String[] stringArray, String string) {
        super(stringArray, null, null);
    }

    public final DataHolder.Builder withRow(ContentValues contentValues) {
        throw new UnsupportedOperationException("Cannot add data to empty builder");
    }

    public final DataHolder.Builder zaa(HashMap<String, Object> hashMap) {
        throw new UnsupportedOperationException("Cannot add data to empty builder");
    }
}
