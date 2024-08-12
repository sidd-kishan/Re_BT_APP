/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  androidx.camera.core.impl.SurfaceSizeDefinition
 */
package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.impl.SurfaceSizeDefinition;

final class AutoValue_SurfaceSizeDefinition
extends SurfaceSizeDefinition {
    private final Size analysisSize;
    private final Size previewSize;
    private final Size recordSize;

    AutoValue_SurfaceSizeDefinition(Size size, Size size2, Size size3) {
        if (size == null) throw new NullPointerException("Null analysisSize");
        this.analysisSize = size;
        if (size2 == null) throw new NullPointerException("Null previewSize");
        this.previewSize = size2;
        if (size3 == null) throw new NullPointerException("Null recordSize");
        this.recordSize = size3;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof SurfaceSizeDefinition)) return false;
        if (this.analysisSize.equals((Object)(object = (SurfaceSizeDefinition)object).getAnalysisSize()) && this.previewSize.equals((Object)object.getPreviewSize()) && this.recordSize.equals((Object)object.getRecordSize())) return bl;
        bl = false;
        return bl;
    }

    public Size getAnalysisSize() {
        return this.analysisSize;
    }

    public Size getPreviewSize() {
        return this.previewSize;
    }

    public Size getRecordSize() {
        return this.recordSize;
    }

    public int hashCode() {
        return ((this.analysisSize.hashCode() ^ 0xF4243) * 1000003 ^ this.previewSize.hashCode()) * 1000003 ^ this.recordSize.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SurfaceSizeDefinition{analysisSize=");
        stringBuilder.append(this.analysisSize);
        stringBuilder.append(", previewSize=");
        stringBuilder.append(this.previewSize);
        stringBuilder.append(", recordSize=");
        stringBuilder.append(this.recordSize);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
