/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Lambda
 *  kotlin.jvm.internal.Ref$ObjectRef
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
static final class ZipKt.readOrSkipLocalHeader.1
extends Lambda
implements Function2<Integer, Long, Unit> {
    final Ref.ObjectRef<Long> $createdAtMillis;
    final Ref.ObjectRef<Long> $lastAccessedAtMillis;
    final Ref.ObjectRef<Long> $lastModifiedAtMillis;
    final BufferedSource $this_readOrSkipLocalHeader;

    ZipKt.readOrSkipLocalHeader.1(BufferedSource bufferedSource, Ref.ObjectRef<Long> objectRef, Ref.ObjectRef<Long> objectRef2, Ref.ObjectRef<Long> objectRef3) {
        this.$this_readOrSkipLocalHeader = bufferedSource;
        this.$lastModifiedAtMillis = objectRef;
        this.$lastAccessedAtMillis = objectRef2;
        this.$createdAtMillis = objectRef3;
        super(2);
    }

    public final void invoke(int n, long l) {
        if (n != 21589) return;
        long l2 = 1L;
        if (l < 1L) throw new IOException("bad zip: extended timestamp extra too short");
        int n2 = this.$this_readOrSkipLocalHeader.readByte() & 0xFF;
        boolean bl = false;
        n = (n2 & 1) == 1 ? 1 : 0;
        boolean bl2 = (n2 & 2) == 2;
        if ((n2 & 4) == 4) {
            bl = true;
        }
        if (n != 0) {
            l2 = 5L;
        }
        long l3 = l2;
        if (bl2) {
            l3 = l2 + 4L;
        }
        l2 = l3;
        if (bl) {
            l2 = l3 + 4L;
        }
        if (l < l2) throw new IOException("bad zip: extended timestamp extra too short");
        if (n != 0) {
            this.$lastModifiedAtMillis.element = (long)this.$this_readOrSkipLocalHeader.readIntLe() * 1000L;
        }
        if (bl2) {
            this.$lastAccessedAtMillis.element = (long)this.$this_readOrSkipLocalHeader.readIntLe() * 1000L;
        }
        if (!bl) return;
        this.$createdAtMillis.element = (long)this.$this_readOrSkipLocalHeader.readIntLe() * 1000L;
    }
}
