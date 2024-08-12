/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.engine.executor;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

class RuntimeCompat.1
implements FilenameFilter {
    final Pattern val$cpuNamePattern;

    RuntimeCompat.1(Pattern pattern) {
        this.val$cpuNamePattern = pattern;
    }

    @Override
    public boolean accept(File file, String string) {
        return this.val$cpuNamePattern.matcher(string).matches();
    }
}
