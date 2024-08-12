/*
 * Decompiled with CFR 0.152.
 */
package androidx.annotation;

public static final class InspectableProperty.ValueType
extends Enum<InspectableProperty.ValueType> {
    private static final InspectableProperty.ValueType[] $VALUES;
    public static final /* enum */ InspectableProperty.ValueType COLOR;
    public static final /* enum */ InspectableProperty.ValueType GRAVITY;
    public static final /* enum */ InspectableProperty.ValueType INFERRED;
    public static final /* enum */ InspectableProperty.ValueType INT_ENUM;
    public static final /* enum */ InspectableProperty.ValueType INT_FLAG;
    public static final /* enum */ InspectableProperty.ValueType NONE;
    public static final /* enum */ InspectableProperty.ValueType RESOURCE_ID;

    static {
        InspectableProperty.ValueType valueType;
        NONE = new InspectableProperty.ValueType();
        INFERRED = new InspectableProperty.ValueType();
        INT_ENUM = new InspectableProperty.ValueType();
        INT_FLAG = new InspectableProperty.ValueType();
        COLOR = new InspectableProperty.ValueType();
        GRAVITY = new InspectableProperty.ValueType();
        RESOURCE_ID = valueType = new InspectableProperty.ValueType();
        $VALUES = new InspectableProperty.ValueType[]{NONE, INFERRED, INT_ENUM, INT_FLAG, COLOR, GRAVITY, valueType};
    }

    public static InspectableProperty.ValueType valueOf(String string) {
        return Enum.valueOf(InspectableProperty.ValueType.class, string);
    }

    public static InspectableProperty.ValueType[] values() {
        return (InspectableProperty.ValueType[])$VALUES.clone();
    }
}
