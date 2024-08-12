/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.view;

public static final class PreviewView.ImplementationMode
extends Enum<PreviewView.ImplementationMode> {
    private static final PreviewView.ImplementationMode[] $VALUES;
    public static final /* enum */ PreviewView.ImplementationMode COMPATIBLE;
    public static final /* enum */ PreviewView.ImplementationMode PERFORMANCE;
    private final int mId;

    static {
        PreviewView.ImplementationMode implementationMode;
        PERFORMANCE = new PreviewView.ImplementationMode(0);
        COMPATIBLE = implementationMode = new PreviewView.ImplementationMode(1);
        $VALUES = new PreviewView.ImplementationMode[]{PERFORMANCE, implementationMode};
    }

    private PreviewView.ImplementationMode(int n2) {
        this.mId = n2;
    }

    static PreviewView.ImplementationMode fromId(int n) {
        Object object = PreviewView.ImplementationMode.values();
        int n2 = ((PreviewView.ImplementationMode[])object).length;
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Unknown implementation mode id ");
                ((StringBuilder)object).append(n);
                object = new IllegalArgumentException(((StringBuilder)object).toString());
                throw object;
            }
            PreviewView.ImplementationMode implementationMode = object[n3];
            if (implementationMode.mId == n) {
                return implementationMode;
            }
            ++n3;
        }
    }

    public static PreviewView.ImplementationMode valueOf(String string) {
        return Enum.valueOf(PreviewView.ImplementationMode.class, string);
    }

    public static PreviewView.ImplementationMode[] values() {
        return (PreviewView.ImplementationMode[])$VALUES.clone();
    }

    int getId() {
        return this.mId;
    }
}
