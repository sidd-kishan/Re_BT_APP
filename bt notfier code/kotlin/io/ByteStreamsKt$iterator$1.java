/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ByteIterator
 */
package kotlin.io;

import java.io.BufferedInputStream;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;

@Metadata(d1={"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007\u00a8\u0006\u0015"}, d2={"kotlin/io/ByteStreamsKt$iterator$1", "Lkotlin/collections/ByteIterator;", "finished", "", "getFinished", "()Z", "setFinished", "(Z)V", "nextByte", "", "getNextByte", "()I", "setNextByte", "(I)V", "nextPrepared", "getNextPrepared", "setNextPrepared", "hasNext", "", "prepareNext", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class ByteStreamsKt.iterator.1
extends ByteIterator {
    final BufferedInputStream $this_iterator;
    private boolean finished;
    private int nextByte;
    private boolean nextPrepared;

    ByteStreamsKt.iterator.1(BufferedInputStream bufferedInputStream) {
        this.$this_iterator = bufferedInputStream;
        this.nextByte = -1;
    }

    private final void prepareNext() {
        int n;
        if (this.nextPrepared) return;
        if (this.finished) return;
        this.nextByte = n = this.$this_iterator.read();
        boolean bl = true;
        this.nextPrepared = true;
        if (n != -1) {
            bl = false;
        }
        this.finished = bl;
    }

    public final boolean getFinished() {
        return this.finished;
    }

    public final int getNextByte() {
        return this.nextByte;
    }

    public final boolean getNextPrepared() {
        return this.nextPrepared;
    }

    public boolean hasNext() {
        this.prepareNext();
        return this.finished ^ true;
    }

    public byte nextByte() {
        this.prepareNext();
        if (this.finished) throw (Throwable)new NoSuchElementException("Input stream is over.");
        byte by = (byte)this.nextByte;
        this.nextPrepared = false;
        return by;
    }

    public final void setFinished(boolean bl) {
        this.finished = bl;
    }

    public final void setNextByte(int n) {
        this.nextByte = n;
    }

    public final void setNextPrepared(boolean bl) {
        this.nextPrepared = bl;
    }
}
