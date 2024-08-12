/*
 * Decompiled with CFR 0.152.
 */
package com.qmuiteam.qmui.qqface;

public static final class QMUIQQFaceCompiler.ElementType
extends Enum<QMUIQQFaceCompiler.ElementType> {
    private static final QMUIQQFaceCompiler.ElementType[] $VALUES;
    public static final /* enum */ QMUIQQFaceCompiler.ElementType DRAWABLE;
    public static final /* enum */ QMUIQQFaceCompiler.ElementType NEXTLINE;
    public static final /* enum */ QMUIQQFaceCompiler.ElementType SPAN;
    public static final /* enum */ QMUIQQFaceCompiler.ElementType SPECIAL_BOUNDS_DRAWABLE;
    public static final /* enum */ QMUIQQFaceCompiler.ElementType TEXT;

    static {
        QMUIQQFaceCompiler.ElementType elementType;
        TEXT = new QMUIQQFaceCompiler.ElementType();
        DRAWABLE = new QMUIQQFaceCompiler.ElementType();
        SPECIAL_BOUNDS_DRAWABLE = new QMUIQQFaceCompiler.ElementType();
        SPAN = new QMUIQQFaceCompiler.ElementType();
        NEXTLINE = elementType = new QMUIQQFaceCompiler.ElementType();
        $VALUES = new QMUIQQFaceCompiler.ElementType[]{TEXT, DRAWABLE, SPECIAL_BOUNDS_DRAWABLE, SPAN, elementType};
    }

    public static QMUIQQFaceCompiler.ElementType valueOf(String string) {
        return Enum.valueOf(QMUIQQFaceCompiler.ElementType.class, string);
    }

    public static QMUIQQFaceCompiler.ElementType[] values() {
        return (QMUIQQFaceCompiler.ElementType[])$VALUES.clone();
    }
}
