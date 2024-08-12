/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.view;

public static final class PreviewView.ScaleType
extends Enum<PreviewView.ScaleType> {
    private static final PreviewView.ScaleType[] $VALUES;
    public static final /* enum */ PreviewView.ScaleType FILL_CENTER;
    public static final /* enum */ PreviewView.ScaleType FILL_END;
    public static final /* enum */ PreviewView.ScaleType FILL_START;
    public static final /* enum */ PreviewView.ScaleType FIT_CENTER;
    public static final /* enum */ PreviewView.ScaleType FIT_END;
    public static final /* enum */ PreviewView.ScaleType FIT_START;
    private final int mId;

    static {
        PreviewView.ScaleType scaleType;
        FILL_START = new PreviewView.ScaleType(0);
        FILL_CENTER = new PreviewView.ScaleType(1);
        FILL_END = new PreviewView.ScaleType(2);
        FIT_START = new PreviewView.ScaleType(3);
        FIT_CENTER = new PreviewView.ScaleType(4);
        FIT_END = scaleType = new PreviewView.ScaleType(5);
        $VALUES = new PreviewView.ScaleType[]{FILL_START, FILL_CENTER, FILL_END, FIT_START, FIT_CENTER, scaleType};
    }

    private PreviewView.ScaleType(int n2) {
        this.mId = n2;
    }

    static PreviewView.ScaleType fromId(int n) {
        Object object = PreviewView.ScaleType.values();
        int n2 = ((PreviewView.ScaleType[])object).length;
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Unknown scale type id ");
                ((StringBuilder)object).append(n);
                object = new IllegalArgumentException(((StringBuilder)object).toString());
                throw object;
            }
            PreviewView.ScaleType scaleType = object[n3];
            if (scaleType.mId == n) {
                return scaleType;
            }
            ++n3;
        }
    }

    public static PreviewView.ScaleType valueOf(String string) {
        return Enum.valueOf(PreviewView.ScaleType.class, string);
    }

    public static PreviewView.ScaleType[] values() {
        return (PreviewView.ScaleType[])$VALUES.clone();
    }

    int getId() {
        return this.mId;
    }
}
