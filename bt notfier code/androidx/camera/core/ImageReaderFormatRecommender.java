/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageReaderFormatRecommender$FormatCombo
 */
package androidx.camera.core;

import androidx.camera.core.ImageReaderFormatRecommender;

/*
 * Exception performing whole class analysis ignored.
 */
final class ImageReaderFormatRecommender {
    private ImageReaderFormatRecommender() {
    }

    static FormatCombo chooseCombo() {
        return FormatCombo.create((int)256, (int)35);
    }
}
