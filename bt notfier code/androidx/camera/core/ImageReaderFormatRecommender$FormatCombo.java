/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.AutoValue_ImageReaderFormatRecommender_FormatCombo
 */
package androidx.camera.core;

import androidx.camera.core.AutoValue_ImageReaderFormatRecommender_FormatCombo;

static abstract class ImageReaderFormatRecommender.FormatCombo {
    ImageReaderFormatRecommender.FormatCombo() {
    }

    static ImageReaderFormatRecommender.FormatCombo create(int n, int n2) {
        return new AutoValue_ImageReaderFormatRecommender_FormatCombo(n, n2);
    }

    abstract int imageAnalysisFormat();

    abstract int imageCaptureFormat();
}
