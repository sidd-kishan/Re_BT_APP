/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageReaderFormatRecommender$FormatCombo
 */
package androidx.camera.core;

import androidx.camera.core.ImageReaderFormatRecommender;

final class AutoValue_ImageReaderFormatRecommender_FormatCombo
extends ImageReaderFormatRecommender.FormatCombo {
    private final int imageAnalysisFormat;
    private final int imageCaptureFormat;

    AutoValue_ImageReaderFormatRecommender_FormatCombo(int n, int n2) {
        this.imageCaptureFormat = n;
        this.imageAnalysisFormat = n2;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof ImageReaderFormatRecommender.FormatCombo)) return false;
        if (this.imageCaptureFormat == (object = (ImageReaderFormatRecommender.FormatCombo)object).imageCaptureFormat() && this.imageAnalysisFormat == object.imageAnalysisFormat()) return bl;
        bl = false;
        return bl;
    }

    public int hashCode() {
        return (this.imageCaptureFormat ^ 0xF4243) * 1000003 ^ this.imageAnalysisFormat;
    }

    int imageAnalysisFormat() {
        return this.imageAnalysisFormat;
    }

    int imageCaptureFormat() {
        return this.imageCaptureFormat;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FormatCombo{imageCaptureFormat=");
        stringBuilder.append(this.imageCaptureFormat);
        stringBuilder.append(", imageAnalysisFormat=");
        stringBuilder.append(this.imageAnalysisFormat);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
