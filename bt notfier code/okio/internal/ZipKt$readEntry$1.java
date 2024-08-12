/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Lambda
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  kotlin.jvm.internal.Ref$LongRef
 *  okio.BufferedSource
 */
package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import okio.BufferedSource;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2={"<anonymous>", "", "headerId", "", "dataSize", ""}, k=3, mv={1, 5, 1}, xi=48)
static final class ZipKt.readEntry.1
extends Lambda
implements Function2<Integer, Long, Unit> {
    final Ref.LongRef $compressedSize;
    final Ref.BooleanRef $hasZip64Extra;
    final Ref.LongRef $offset;
    final long $requiredZip64ExtraSize;
    final Ref.LongRef $size;
    final BufferedSource $this_readEntry;

    ZipKt.readEntry.1(Ref.BooleanRef booleanRef, long l, Ref.LongRef longRef, BufferedSource bufferedSource, Ref.LongRef longRef2, Ref.LongRef longRef3) {
        this.$hasZip64Extra = booleanRef;
        this.$requiredZip64ExtraSize = l;
        this.$size = longRef;
        this.$this_readEntry = bufferedSource;
        this.$compressedSize = longRef2;
        this.$offset = longRef3;
        super(2);
    }

    public final void invoke(int n, long l) {
        if (n != 1) return;
        if (this.$hasZip64Extra.element) throw new IOException("bad zip: zip64 extra repeated");
        this.$hasZip64Extra.element = true;
        if (l < this.$requiredZip64ExtraSize) throw new IOException("bad zip: zip64 extra too short");
        Ref.LongRef longRef = this.$size;
        l = longRef.element == 0xFFFFFFFFL ? this.$this_readEntry.readLongLe() : this.$size.element;
        longRef.element = l;
        longRef = this.$compressedSize;
        l = longRef.element;
        long l2 = 0L;
        l = l == 0xFFFFFFFFL ? this.$this_readEntry.readLongLe() : 0L;
        longRef.element = l;
        longRef = this.$offset;
        l = l2;
        if (longRef.element == 0xFFFFFFFFL) {
            l = this.$this_readEntry.readLongLe();
        }
        longRef.element = l;
    }
}
