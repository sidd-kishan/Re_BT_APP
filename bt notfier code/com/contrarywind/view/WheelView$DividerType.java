/*
 * Decompiled with CFR 0.152.
 */
package com.contrarywind.view;

public static final class WheelView.DividerType
extends Enum<WheelView.DividerType> {
    private static final WheelView.DividerType[] $VALUES;
    public static final /* enum */ WheelView.DividerType FILL;
    public static final /* enum */ WheelView.DividerType WRAP;

    static {
        WheelView.DividerType dividerType;
        FILL = new WheelView.DividerType();
        WRAP = dividerType = new WheelView.DividerType();
        $VALUES = new WheelView.DividerType[]{FILL, dividerType};
    }

    public static WheelView.DividerType valueOf(String string) {
        return Enum.valueOf(WheelView.DividerType.class, string);
    }

    public static WheelView.DividerType[] values() {
        return (WheelView.DividerType[])$VALUES.clone();
    }
}
