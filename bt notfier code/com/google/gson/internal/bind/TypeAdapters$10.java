/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

class TypeAdapters.10
extends TypeAdapter<AtomicIntegerArray> {
    TypeAdapters.10() {
    }

    @Override
    public AtomicIntegerArray read(JsonReader object) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ((JsonReader)object).beginArray();
        while (((JsonReader)object).hasNext()) {
            try {
                arrayList.add(((JsonReader)object).nextInt());
            }
            catch (NumberFormatException numberFormatException) {
                throw new JsonSyntaxException(numberFormatException);
            }
        }
        ((JsonReader)object).endArray();
        int n = arrayList.size();
        object = new AtomicIntegerArray(n);
        int n2 = 0;
        while (n2 < n) {
            ((AtomicIntegerArray)object).set(n2, (Integer)arrayList.get(n2));
            ++n2;
        }
        return object;
    }

    @Override
    public void write(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) throws IOException {
        jsonWriter.beginArray();
        int n = atomicIntegerArray.length();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                jsonWriter.endArray();
                return;
            }
            jsonWriter.value(atomicIntegerArray.get(n2));
            ++n2;
        }
    }
}
