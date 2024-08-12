/*
 * Decompiled with CFR 0.152.
 */
package androidx.room.util;

static class TableInfo.ForeignKeyWithSequence
implements Comparable<TableInfo.ForeignKeyWithSequence> {
    final String mFrom;
    final int mId;
    final int mSequence;
    final String mTo;

    TableInfo.ForeignKeyWithSequence(int n, int n2, String string, String string2) {
        this.mId = n;
        this.mSequence = n2;
        this.mFrom = string;
        this.mTo = string2;
    }

    @Override
    public int compareTo(TableInfo.ForeignKeyWithSequence foreignKeyWithSequence) {
        int n;
        int n2 = n = this.mId - foreignKeyWithSequence.mId;
        if (n != 0) return n2;
        n2 = this.mSequence - foreignKeyWithSequence.mSequence;
        return n2;
    }
}
