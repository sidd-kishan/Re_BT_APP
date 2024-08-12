/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 */
package com.google.android.material.animation;

import android.animation.TypeEvaluator;

public class ArgbEvaluatorCompat
implements TypeEvaluator<Integer> {
    private static final ArgbEvaluatorCompat instance = new ArgbEvaluatorCompat();

    public static ArgbEvaluatorCompat getInstance() {
        return instance;
    }

    public Integer evaluate(float f, Integer n, Integer n2) {
        int n3 = n;
        float f2 = (float)(n3 >> 24 & 0xFF) / 255.0f;
        float f3 = (float)(n3 >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(n3 >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(n3 & 0xFF) / 255.0f;
        n3 = n2;
        float f6 = (float)(n3 >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n3 >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n3 >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n3 & 0xFF) / 255.0f;
        f3 = (float)Math.pow(f3, 2.2);
        f4 = (float)Math.pow(f4, 2.2);
        f5 = (float)Math.pow(f5, 2.2);
        f7 = (float)Math.pow(f7, 2.2);
        f8 = (float)Math.pow(f8, 2.2);
        f9 = (float)Math.pow(f9, 2.2);
        f3 = (float)Math.pow(f3 + (f7 - f3) * f, 0.45454545454545453);
        f4 = (float)Math.pow(f4 + (f8 - f4) * f, 0.45454545454545453);
        f5 = (float)Math.pow(f5 + f * (f9 - f5), 0.45454545454545453);
        n3 = Math.round((f2 + (f6 - f2) * f) * 255.0f);
        return Math.round(f3 * 255.0f) << 16 | n3 << 24 | Math.round(f4 * 255.0f) << 8 | Math.round(f5 * 255.0f);
    }
}
