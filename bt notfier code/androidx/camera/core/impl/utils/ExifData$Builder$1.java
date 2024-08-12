/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.utils.ExifData
 *  androidx.camera.core.impl.utils.ExifTag
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifTag;
import java.util.Enumeration;
import java.util.HashMap;

class ExifData.Builder.1
implements Enumeration<HashMap<String, ExifTag>> {
    int mIfdIndex = 0;

    ExifData.Builder.1() {
    }

    @Override
    public boolean hasMoreElements() {
        boolean bl = this.mIfdIndex < ExifData.EXIF_TAGS.length;
        return bl;
    }

    @Override
    public HashMap<String, ExifTag> nextElement() {
        HashMap<String, ExifTag> hashMap = new HashMap<String, ExifTag>();
        ExifTag[] exifTagArray = ExifData.EXIF_TAGS[this.mIfdIndex];
        int n = exifTagArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                ++this.mIfdIndex;
                return hashMap;
            }
            ExifTag exifTag = exifTagArray[n2];
            hashMap.put(exifTag.name, exifTag);
            ++n2;
        }
    }
}
