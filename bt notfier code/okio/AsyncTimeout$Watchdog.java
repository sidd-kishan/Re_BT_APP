/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  okio.AsyncTimeout
 */
package okio;

import kotlin.Metadata;
import kotlin.Unit;
import okio.AsyncTimeout;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2={"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "()V", "run", "", "okio"}, k=1, mv={1, 5, 1}, xi=48)
private static final class AsyncTimeout.Watchdog
extends Thread {
    public AsyncTimeout.Watchdog() {
        super("Okio Watchdog");
        this.setDaemon(true);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    @Override
    public void run() {
        while (true) {
            try {
                synchronized (AsyncTimeout.class) {
                }
            }
            catch (InterruptedException var1_3) {
                continue;
            }
            {
                var1_1 = AsyncTimeout.Companion.awaitTimeout$okio();
                if (var1_1 == AsyncTimeout.access$getHead$cp()) {
                    var1_1 = AsyncTimeout.Companion;
                    AsyncTimeout.access$setHead$cp(null);
                }
                ** GOTO lbl-1000
                {
                    catch (Throwable var1_2) {
                        throw var1_2;
                    }
                    return;
lbl-1000:
                    // 1 sources

                    {
                        var2_4 = Unit.INSTANCE;
                    }
                    // MONITOREXIT @DISABLED, blocks:[2, 4, 7] lbl19 : MonitorExitStatement: MONITOREXIT : okio.AsyncTimeout.class
                    if (var1_1 == null) continue;
                    var1_1.timedOut();
                    continue;
                }
            }
            break;
        }
    }
}
