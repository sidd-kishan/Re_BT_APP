/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.BitSet;

class TypeAdapters.2
extends TypeAdapter<BitSet> {
    TypeAdapters.2() {
    }

    @Override
    public BitSet read(JsonReader object) throws IOException {
        BitSet bitSet = new BitSet();
        ((JsonReader)object).beginArray();
        Object object2 = ((JsonReader)object).peek();
        int n = 0;
        while (true) {
            boolean bl;
            block15: {
                block13: {
                    block14: {
                        if (object2 == JsonToken.END_ARRAY) {
                            ((JsonReader)object).endArray();
                            return bitSet;
                        }
                        int n2 = TypeAdapters.34.$SwitchMap$com$google$gson$stream$JsonToken[object2.ordinal()];
                        bl = true;
                        if (n2 == 1) break block14;
                        if (n2 != 2) {
                            if (n2 != 3) {
                                object = new StringBuilder();
                                ((StringBuilder)object).append("Invalid bitset value type: ");
                                ((StringBuilder)object).append(object2);
                                throw new JsonSyntaxException(((StringBuilder)object).toString());
                            }
                            object2 = ((JsonReader)object).nextString();
                            try {
                                n2 = Integer.parseInt((String)object2);
                                if (n2 != 0) {
                                }
                                break block13;
                            }
                            catch (NumberFormatException numberFormatException) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Error: Expecting: bitset number value (1, 0), Found: ");
                                stringBuilder.append((String)object2);
                                throw new JsonSyntaxException(stringBuilder.toString());
                            }
                        }
                        bl = ((JsonReader)object).nextBoolean();
                        break block15;
                    }
                    if (((JsonReader)object).nextInt() != 0) break block15;
                }
                bl = false;
            }
            if (bl) {
                bitSet.set(n);
            }
            ++n;
            object2 = ((JsonReader)object).peek();
        }
    }

    @Override
    public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
        jsonWriter.beginArray();
        int n = bitSet.length();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                jsonWriter.endArray();
                return;
            }
            jsonWriter.value((long)bitSet.get(n2));
            ++n2;
        }
    }
}
