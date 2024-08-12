/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 */
package kotlin.concurrent;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2={"kotlin/concurrent/ThreadsKt$thread$thread$1", "Ljava/lang/Thread;", "run", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class ThreadsKt.thread.thread.1
extends Thread {
    final Function0 $block;

    ThreadsKt.thread.thread.1(Function0 function0) {
        this.$block = function0;
    }

    @Override
    public void run() {
        this.$block.invoke();
    }
}
