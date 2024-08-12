/*
 * Decompiled with CFR 0.152.
 */
package com.contrarywind.view;

public static final class WheelView.ACTION
extends Enum<WheelView.ACTION> {
    private static final WheelView.ACTION[] $VALUES;
    public static final /* enum */ WheelView.ACTION CLICK;
    public static final /* enum */ WheelView.ACTION DAGGLE;
    public static final /* enum */ WheelView.ACTION FLING;

    static {
        WheelView.ACTION aCTION;
        CLICK = new WheelView.ACTION();
        FLING = new WheelView.ACTION();
        DAGGLE = aCTION = new WheelView.ACTION();
        $VALUES = new WheelView.ACTION[]{CLICK, FLING, aCTION};
    }

    public static WheelView.ACTION valueOf(String string) {
        return Enum.valueOf(WheelView.ACTION.class, string);
    }

    public static WheelView.ACTION[] values() {
        return (WheelView.ACTION[])$VALUES.clone();
    }
}
