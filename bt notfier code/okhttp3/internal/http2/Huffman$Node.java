/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package okhttp3.internal.http2;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0006R\u001d\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0010"}, d2={"Lokhttp3/internal/http2/Huffman$Node;", "", "()V", "symbol", "", "bits", "(II)V", "children", "", "getChildren", "()[Lokhttp3/internal/http2/Huffman$Node;", "[Lokhttp3/internal/http2/Huffman$Node;", "getSymbol", "()I", "terminalBitCount", "getTerminalBitCount", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
private static final class Huffman.Node {
    private final Huffman.Node[] children;
    private final int symbol;
    private final int terminalBitCount;

    public Huffman.Node() {
        this.children = new Huffman.Node[256];
        this.symbol = 0;
        this.terminalBitCount = 0;
    }

    public Huffman.Node(int n, int n2) {
        this.children = null;
        this.symbol = n;
        n = n2 &= 7;
        if (n2 == 0) {
            n = 8;
        }
        this.terminalBitCount = n;
    }

    public final Huffman.Node[] getChildren() {
        return this.children;
    }

    public final int getSymbol() {
        return this.symbol;
    }

    public final int getTerminalBitCount() {
        return this.terminalBitCount;
    }
}
