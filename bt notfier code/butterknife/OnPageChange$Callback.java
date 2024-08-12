/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  butterknife.internal.ListenerMethod
 */
package butterknife;

import butterknife.internal.ListenerMethod;

public static final class OnPageChange.Callback
extends Enum<OnPageChange.Callback> {
    private static final OnPageChange.Callback[] $VALUES;
    @ListenerMethod(name="onPageScrolled", parameters={"int", "float", "int"})
    public static final /* enum */ OnPageChange.Callback PAGE_SCROLLED;
    @ListenerMethod(name="onPageScrollStateChanged", parameters={"int"})
    public static final /* enum */ OnPageChange.Callback PAGE_SCROLL_STATE_CHANGED;
    @ListenerMethod(name="onPageSelected", parameters={"int"})
    public static final /* enum */ OnPageChange.Callback PAGE_SELECTED;

    static {
        OnPageChange.Callback callback;
        PAGE_SELECTED = new OnPageChange.Callback();
        PAGE_SCROLLED = new OnPageChange.Callback();
        PAGE_SCROLL_STATE_CHANGED = callback = new OnPageChange.Callback();
        $VALUES = new OnPageChange.Callback[]{PAGE_SELECTED, PAGE_SCROLLED, callback};
    }

    public static OnPageChange.Callback valueOf(String string) {
        return Enum.valueOf(OnPageChange.Callback.class, string);
    }

    public static OnPageChange.Callback[] values() {
        return (OnPageChange.Callback[])$VALUES.clone();
    }
}
