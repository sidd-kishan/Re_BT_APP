/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Data
 *  androidx.work.Data$Builder
 *  androidx.work.InputMerger
 */
package androidx.work;

import androidx.work.Data;
import androidx.work.InputMerger;
import java.util.HashMap;
import java.util.List;

public final class OverwritingInputMerger
extends InputMerger {
    public Data merge(List<Data> object) {
        Data.Builder builder = new Data.Builder();
        HashMap hashMap = new HashMap();
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                builder.putAll(hashMap);
                return builder.build();
            }
            hashMap.putAll(((Data)object.next()).getKeyValueMap());
        }
    }
}
