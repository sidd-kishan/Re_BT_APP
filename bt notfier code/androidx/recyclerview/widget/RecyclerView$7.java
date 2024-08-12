/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/*
 * Exception performing whole class analysis ignored.
 */
static class RecyclerView.7 {
    static final int[] $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[RecyclerView.Adapter.StateRestorationPolicy.values().length];
        $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy = nArray;
        try {
            nArray[RecyclerView.Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            RecyclerView.7.$SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy[RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
