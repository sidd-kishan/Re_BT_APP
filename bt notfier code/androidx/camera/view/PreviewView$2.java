/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.view.PreviewView$ImplementationMode
 *  androidx.camera.view.PreviewView$ScaleType
 */
package androidx.camera.view;

import androidx.camera.view.PreviewView;

/*
 * Exception performing whole class analysis ignored.
 */
static class PreviewView.2 {
    static final int[] $SwitchMap$androidx$camera$view$PreviewView$ImplementationMode;
    static final int[] $SwitchMap$androidx$camera$view$PreviewView$ScaleType;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[PreviewView.ImplementationMode.values().length];
        $SwitchMap$androidx$camera$view$PreviewView$ImplementationMode = nArray;
        try {
            nArray[PreviewView.ImplementationMode.COMPATIBLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            PreviewView.2.$SwitchMap$androidx$camera$view$PreviewView$ImplementationMode[PreviewView.ImplementationMode.PERFORMANCE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        nArray = new int[PreviewView.ScaleType.values().length];
        $SwitchMap$androidx$camera$view$PreviewView$ScaleType = nArray;
        try {
            nArray[PreviewView.ScaleType.FILL_END.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            PreviewView.2.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_CENTER.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            PreviewView.2.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FILL_START.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            PreviewView.2.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FIT_END.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            PreviewView.2.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FIT_CENTER.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            PreviewView.2.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[PreviewView.ScaleType.FIT_START.ordinal()] = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
