/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

class Gson.5
extends TypeAdapter<AtomicLongArray> {
    final TypeAdapter val$longAdapter;

    Gson.5(TypeAdapter typeAdapter) {
        this.val$longAdapter = typeAdapter;
    }

    @Override
    public AtomicLongArray read(JsonReader object) throws IOException {
        ArrayList<Long> arrayList = new ArrayList<Long>();
        ((JsonReader)object).beginArray();
        while (((JsonReader)object).hasNext()) {
            arrayList.add(((Number)this.val$longAdapter.read((JsonReader)object)).longValue());
        }
        ((JsonReader)object).endArray();
        int n = arrayList.size();
        object = new AtomicLongArray(n);
        int n2 = 0;
        while (n2 < n) {
            ((AtomicLongArray)object).set(n2, (Long)arrayList.get(n2));
            ++n2;
        }
        return object;
    }

    @Override
    public void write(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) throws IOException {
        jsonWriter.beginArray();
        int n = atomicLongArray.length();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                jsonWriter.endArray();
                return;
            }
            this.val$longAdapter.write(jsonWriter, atomicLongArray.get(n2));
            ++n2;
        }
    }
}
