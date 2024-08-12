/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.content.res;

import java.util.List;

static final class GradientColorInflaterCompat.ColorStops {
    final int[] mColors;
    final float[] mOffsets;

    GradientColorInflaterCompat.ColorStops(int n, int n2) {
        this.mColors = new int[]{n, n2};
        this.mOffsets = new float[]{0.0f, 1.0f};
    }

    GradientColorInflaterCompat.ColorStops(int n, int n2, int n3) {
        this.mColors = new int[]{n, n2, n3};
        this.mOffsets = new float[]{0.0f, 0.5f, 1.0f};
    }

    GradientColorInflaterCompat.ColorStops(List<Integer> list, List<Float> list2) {
        int n = list.size();
        this.mColors = new int[n];
        this.mOffsets = new float[n];
        int n2 = 0;
        while (n2 < n) {
            this.mColors[n2] = list.get(n2);
            this.mOffsets[n2] = list2.get(n2).floatValue();
            ++n2;
        }
    }
}
