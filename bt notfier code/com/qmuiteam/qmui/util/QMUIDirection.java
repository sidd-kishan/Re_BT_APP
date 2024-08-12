/*
 * Decompiled with CFR 0.152.
 */
package com.qmuiteam.qmui.util;

public final class QMUIDirection
extends Enum<QMUIDirection> {
    private static final QMUIDirection[] $VALUES;
    public static final /* enum */ QMUIDirection BOTTOM_TO_TOP;
    public static final /* enum */ QMUIDirection LEFT_TO_RIGHT;
    public static final /* enum */ QMUIDirection RIGHT_TO_LEFT;
    public static final /* enum */ QMUIDirection TOP_TO_BOTTOM;

    static {
        QMUIDirection qMUIDirection;
        LEFT_TO_RIGHT = new QMUIDirection();
        TOP_TO_BOTTOM = new QMUIDirection();
        RIGHT_TO_LEFT = new QMUIDirection();
        BOTTOM_TO_TOP = qMUIDirection = new QMUIDirection();
        $VALUES = new QMUIDirection[]{LEFT_TO_RIGHT, TOP_TO_BOTTOM, RIGHT_TO_LEFT, qMUIDirection};
    }

    public static QMUIDirection valueOf(String string) {
        return Enum.valueOf(QMUIDirection.class, string);
    }

    public static QMUIDirection[] values() {
        return (QMUIDirection[])$VALUES.clone();
    }
}
