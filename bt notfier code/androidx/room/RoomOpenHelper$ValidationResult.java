/*
 * Decompiled with CFR 0.152.
 */
package androidx.room;

public static class RoomOpenHelper.ValidationResult {
    public final String expectedFoundMsg;
    public final boolean isValid;

    public RoomOpenHelper.ValidationResult(boolean bl, String string) {
        this.isValid = bl;
        this.expectedFoundMsg = string;
    }
}
