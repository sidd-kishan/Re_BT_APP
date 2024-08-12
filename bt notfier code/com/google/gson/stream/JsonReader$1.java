/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.stream.JsonReader;
import java.io.IOException;

class JsonReader.1
extends JsonReaderInternalAccess {
    JsonReader.1() {
    }

    @Override
    public void promoteNameToValue(JsonReader jsonReader) throws IOException {
        int n;
        if (jsonReader instanceof JsonTreeReader) {
            ((JsonTreeReader)jsonReader).promoteNameToValue();
            return;
        }
        int n2 = n = jsonReader.peeked;
        if (n == 0) {
            n2 = jsonReader.doPeek();
        }
        if (n2 == 13) {
            jsonReader.peeked = 9;
        } else if (n2 == 12) {
            jsonReader.peeked = 8;
        } else {
            if (n2 != 14) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected a name but was ");
                stringBuilder.append((Object)jsonReader.peek());
                stringBuilder.append(jsonReader.locationString());
                throw new IllegalStateException(stringBuilder.toString());
            }
            jsonReader.peeked = 10;
        }
    }
}
