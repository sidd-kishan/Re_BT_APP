/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.multidex.MultiDexExtractor
 */
package androidx.multidex;

import androidx.multidex.MultiDexExtractor;
import java.io.File;
import java.io.FileFilter;

class MultiDexExtractor.1
implements FileFilter {
    final MultiDexExtractor this$0;

    MultiDexExtractor.1(MultiDexExtractor multiDexExtractor) {
        this.this$0 = multiDexExtractor;
    }

    @Override
    public boolean accept(File file) {
        return file.getName().equals("MultiDex.lock") ^ true;
    }
}
