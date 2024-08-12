/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.widget;

public static final class ConstraintAttribute.AttributeType
extends Enum<ConstraintAttribute.AttributeType> {
    private static final ConstraintAttribute.AttributeType[] $VALUES;
    public static final /* enum */ ConstraintAttribute.AttributeType BOOLEAN_TYPE;
    public static final /* enum */ ConstraintAttribute.AttributeType COLOR_DRAWABLE_TYPE;
    public static final /* enum */ ConstraintAttribute.AttributeType COLOR_TYPE;
    public static final /* enum */ ConstraintAttribute.AttributeType DIMENSION_TYPE;
    public static final /* enum */ ConstraintAttribute.AttributeType FLOAT_TYPE;
    public static final /* enum */ ConstraintAttribute.AttributeType INT_TYPE;
    public static final /* enum */ ConstraintAttribute.AttributeType STRING_TYPE;

    static {
        ConstraintAttribute.AttributeType attributeType;
        INT_TYPE = new ConstraintAttribute.AttributeType();
        FLOAT_TYPE = new ConstraintAttribute.AttributeType();
        COLOR_TYPE = new ConstraintAttribute.AttributeType();
        COLOR_DRAWABLE_TYPE = new ConstraintAttribute.AttributeType();
        STRING_TYPE = new ConstraintAttribute.AttributeType();
        BOOLEAN_TYPE = new ConstraintAttribute.AttributeType();
        DIMENSION_TYPE = attributeType = new ConstraintAttribute.AttributeType();
        $VALUES = new ConstraintAttribute.AttributeType[]{INT_TYPE, FLOAT_TYPE, COLOR_TYPE, COLOR_DRAWABLE_TYPE, STRING_TYPE, BOOLEAN_TYPE, attributeType};
    }

    public static ConstraintAttribute.AttributeType valueOf(String string) {
        return Enum.valueOf(ConstraintAttribute.AttributeType.class, string);
    }

    public static ConstraintAttribute.AttributeType[] values() {
        return (ConstraintAttribute.AttributeType[])$VALUES.clone();
    }
}
