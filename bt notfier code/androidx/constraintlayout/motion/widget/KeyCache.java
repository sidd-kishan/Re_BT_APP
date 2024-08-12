/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.motion.widget;

import java.util.Arrays;
import java.util.HashMap;

public class KeyCache {
    HashMap<Object, HashMap<String, float[]>> map = new HashMap();

    float getFloatValue(Object object, String string, int n) {
        if (!this.map.containsKey(object)) {
            return Float.NaN;
        }
        if (!((HashMap)(object = this.map.get(object))).containsKey(string)) {
            return Float.NaN;
        }
        if (((Object)(object = (Object)((HashMap)object).get(string))).length <= n) return Float.NaN;
        return (float)object[n];
    }

    void setFloatValue(Object object, String string, int n, float f) {
        if (!this.map.containsKey(object)) {
            HashMap<String, float[]> hashMap = new HashMap<String, float[]>();
            float[] fArray = new float[n + 1];
            fArray[n] = f;
            hashMap.put(string, fArray);
            this.map.put(object, hashMap);
        } else {
            HashMap<String, float[]> hashMap = this.map.get(object);
            if (!hashMap.containsKey(string)) {
                float[] fArray = new float[n + 1];
                fArray[n] = f;
                hashMap.put(string, fArray);
                this.map.put(object, hashMap);
            } else {
                float[] fArray = hashMap.get(string);
                object = fArray;
                if (fArray.length <= n) {
                    object = Arrays.copyOf(fArray, n + 1);
                }
                object[n] = f;
                hashMap.put(string, (float[])object);
            }
        }
    }
}
