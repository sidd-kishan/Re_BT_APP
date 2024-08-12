/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.view.PreviewView$ScaleType
 */
package androidx.camera.view;

import androidx.camera.view.PreviewView;

static class PreviewTransformation.1 {
    static final int[] $SwitchMap$androidx$camera$view$PreviewView$ScaleType;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[PreviewView.ScaleType.values().length];
        $SwitchMap$androidx$camera$view$PreviewView$ScaleType = nArray;
        try {
            nArray[PreviewView.ScaleType.FIT_CENTER.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            PreviewTransformation.1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_CENTER.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            PreviewTransformation.1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FIT_END.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            PreviewTransformation.1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_END.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            PreviewTransformation.1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FIT_START.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            PreviewTransformation.1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_START.ordinal()] = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
