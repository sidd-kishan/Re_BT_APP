/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.data.DataBuffer
 *  com.google.android.gms.common.data.Freezable
 */
package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.Freezable;
import java.util.ArrayList;
import java.util.Iterator;

public final class DataBufferUtils {
    public static final String KEY_NEXT_PAGE_TOKEN = "next_page_token";
    public static final String KEY_PREV_PAGE_TOKEN = "prev_page_token";

    private DataBufferUtils() {
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> dataBuffer) {
        ArrayList<Object> arrayList = new ArrayList<Object>(dataBuffer.getCount());
        try {
            Iterator iterator = dataBuffer.iterator();
            while (iterator.hasNext()) {
                arrayList.add(((Freezable)iterator.next()).freeze());
            }
            return arrayList;
        }
        finally {
            dataBuffer.close();
        }
    }

    public static boolean hasData(DataBuffer<?> dataBuffer) {
        if (dataBuffer == null) return false;
        if (dataBuffer.getCount() <= 0) return false;
        return true;
    }

    public static boolean hasNextPage(DataBuffer<?> bundle) {
        if ((bundle = bundle.getMetadata()) == null) return false;
        if (bundle.getString(KEY_NEXT_PAGE_TOKEN) == null) return false;
        return true;
    }

    public static boolean hasPrevPage(DataBuffer<?> bundle) {
        if ((bundle = bundle.getMetadata()) == null) return false;
        if (bundle.getString(KEY_PREV_PAGE_TOKEN) == null) return false;
        return true;
    }
}
