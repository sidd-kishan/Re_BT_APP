/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Address
 *  okhttp3.Route
 *  okhttp3.internal.Util
 *  okhttp3.internal.concurrent.Task
 *  okhttp3.internal.concurrent.TaskQueue
 *  okhttp3.internal.concurrent.TaskRunner
 *  okhttp3.internal.connection.RealCall
 *  okhttp3.internal.connection.RealCall$CallReference
 *  okhttp3.internal.connection.RealConnection
 *  okhttp3.internal.connection.RealConnectionPool$Companion
 *  okhttp3.internal.connection.RealConnectionPool$cleanupTask$1
 *  okhttp3.internal.platform.Platform
 */
package okhttp3.internal.connection;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.platform.Platform;

@Metadata(d1={"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u000e\u0018\u0000 (2\u00020\u0001:\u0001(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ.\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0005J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u000e\u0010'\u001a\u00020$2\u0006\u0010!\u001a\u00020\u0012R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2={"Lokhttp3/internal/connection/RealConnectionPool;", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "maxIdleConnections", "", "keepAliveDuration", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(Lokhttp3/internal/concurrent/TaskRunner;IJLjava/util/concurrent/TimeUnit;)V", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "okhttp3/internal/connection/RealConnectionPool$cleanupTask$1", "Lokhttp3/internal/connection/RealConnectionPool$cleanupTask$1;", "connections", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lokhttp3/internal/connection/RealConnection;", "keepAliveDurationNs", "callAcquirePooledConnection", "", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "routes", "", "Lokhttp3/Route;", "requireMultiplexed", "cleanup", "now", "connectionBecameIdle", "connection", "connectionCount", "evictAll", "", "idleConnectionCount", "pruneAndGetAllocationCount", "put", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class RealConnectionPool {
    public static final Companion Companion = new Companion(null);
    private final TaskQueue cleanupQueue;
    private final cleanupTask.1 cleanupTask;
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    public RealConnectionPool(TaskRunner taskRunner, int n, long l, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)taskRunner, (String)"taskRunner");
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"timeUnit");
        this.maxIdleConnections = n;
        this.keepAliveDurationNs = timeUnit.toNanos(l);
        this.cleanupQueue = taskRunner.newQueue();
        this.cleanupTask = new /* Unavailable Anonymous Inner Class!! */;
        this.connections = new ConcurrentLinkedQueue();
        n = l > 0L ? 1 : 0;
        if (n == 0) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"keepAliveDuration <= 0: ", (Object)l).toString());
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection, long l) {
        block4: {
            if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Thread ");
                stringBuilder.append((Object)Thread.currentThread().getName());
                stringBuilder.append(" MUST hold lock on ");
                stringBuilder.append(realConnection);
                throw new AssertionError((Object)stringBuilder.toString());
            }
            List list = realConnection.getCalls();
            int n = 0;
            while (n < list.size()) {
                Reference reference = (Reference)list.get(n);
                if (reference.get() != null) {
                    ++n;
                    continue;
                }
                reference = (RealCall.CallReference)reference;
                CharSequence charSequence = new StringBuilder();
                charSequence.append("A connection to ");
                charSequence.append(realConnection.route().address().url());
                charSequence.append(" was leaked. Did you forget to close a response body?");
                charSequence = charSequence.toString();
                Platform.Companion.get().logCloseableLeak((String)charSequence, reference.getCallStackTrace());
                list.remove(n);
                realConnection.setNoNewExchanges(true);
                if (!list.isEmpty()) {
                    continue;
                }
                break block4;
            }
            return list.size();
        }
        realConnection.setIdleAtNs(l - this.keepAliveDurationNs);
        return 0;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final boolean callAcquirePooledConnection(Address address, RealCall realCall, List<Route> list, boolean bl) {
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)address, (String)"address");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"call");
        Iterator<RealConnection> iterator = this.connections.iterator();
        while (iterator.hasNext()) {
            RealConnection realConnection = iterator.next();
            Intrinsics.checkNotNullExpressionValue((Object)realConnection, (String)"connection");
            synchronized (realConnection) {
                void var3_3;
                void var4_4;
                if ((var4_4 == false || realConnection.isMultiplexed$okhttp()) && realConnection.isEligible$okhttp(address, (List)var3_3)) {
                    var2_2.acquireConnectionNoEvents(realConnection);
                    return true;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return false;
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final long cleanup(long l) {
        RealConnection realConnection;
        block15: {
            long l2;
            long l3;
            block14: {
                Iterator<RealConnection> iterator = this.connections.iterator();
                int n = 0;
                l3 = Long.MIN_VALUE;
                realConnection = null;
                int n2 = 0;
                while (iterator.hasNext()) {
                    RealConnection realConnection2 = iterator.next();
                    Intrinsics.checkNotNullExpressionValue((Object)realConnection2, (String)"connection");
                    // MONITORENTER : realConnection2
                    if (this.pruneAndGetAllocationCount(realConnection2, l) > 0) {
                        ++n2;
                    } else {
                        ++n;
                        long l4 = l - realConnection2.getIdleAtNs();
                        l2 = l3;
                        if (l4 > l3) {
                            realConnection = realConnection2;
                            l2 = l4;
                        }
                        Unit unit = Unit.INSTANCE;
                        l3 = l2;
                    }
                    // MONITOREXIT : realConnection2
                }
                l2 = this.keepAliveDurationNs;
                if (l3 < l2 && n <= this.maxIdleConnections) {
                    if (n > 0) {
                        return l2 - l3;
                    }
                    if (n2 <= 0) return -1L;
                    return l2;
                }
                Intrinsics.checkNotNull(realConnection);
                // MONITORENTER : realConnection
                boolean bl = ((Collection)realConnection.getCalls()).isEmpty();
                if (!(bl ^ true)) break block14;
                return 0L;
            }
            l2 = realConnection.getIdleAtNs();
            if (l2 + l3 == l) break block15;
            // MONITOREXIT : realConnection
            return 0L;
        }
        realConnection.setNoNewExchanges(true);
        this.connections.remove(realConnection);
        // MONITOREXIT : realConnection
        Util.closeQuietly((Socket)realConnection.socket());
        if (!this.connections.isEmpty()) return 0L;
        this.cleanupQueue.cancelAll();
        return 0L;
    }

    public final boolean connectionBecameIdle(RealConnection realConnection) {
        Intrinsics.checkNotNullParameter((Object)realConnection, (String)"connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(realConnection);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        boolean bl = realConnection.getNoNewExchanges();
        boolean bl2 = true;
        if (!bl && this.maxIdleConnections != 0) {
            TaskQueue.schedule$default((TaskQueue)this.cleanupQueue, (Task)((Task)this.cleanupTask), (long)0L, (int)2, null);
            bl = false;
        } else {
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            bl = bl2;
            if (!this.connections.isEmpty()) return bl;
            this.cleanupQueue.cancelAll();
            bl = bl2;
        }
        return bl;
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void evictAll() {
        Iterator<RealConnection> iterator = this.connections.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator, (String)"connections.iterator()");
        while (true) {
            Socket socket;
            if (!iterator.hasNext()) {
                if (!this.connections.isEmpty()) return;
                this.cleanupQueue.cancelAll();
                return;
            }
            RealConnection realConnection = iterator.next();
            Intrinsics.checkNotNullExpressionValue((Object)realConnection, (String)"connection");
            synchronized (realConnection) {
                if (realConnection.getCalls().isEmpty()) {
                    iterator.remove();
                    realConnection.setNoNewExchanges(true);
                    socket = realConnection.socket();
                } else {
                    socket = null;
                }
                if (socket == null) continue;
            }
            Util.closeQuietly((Socket)socket);
        }
    }

    public final int idleConnectionCount() {
        Iterable iterable = this.connections;
        boolean bl = iterable instanceof Collection;
        int n = 0;
        int n2 = 0;
        if (bl && ((Collection)iterable).isEmpty()) {
            return n;
        }
        Iterator iterator = iterable.iterator();
        while (true) {
            n = n2;
            if (!iterator.hasNext()) return n;
            iterable = (RealConnection)iterator.next();
            Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)"it");
            synchronized (iterable) {
                bl = iterable.getCalls().isEmpty();
                // MONITOREXIT @DISABLED, blocks:[0, 1, 3] lbl16 : MonitorExitStatement: MONITOREXIT : var4_1
                if (!bl) continue;
                n2 = n = n2 + 1;
                if (n >= 0) continue;
            }
            CollectionsKt.throwCountOverflow();
            n2 = n;
        }
    }

    public final void put(RealConnection realConnection) {
        Intrinsics.checkNotNullParameter((Object)realConnection, (String)"connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(realConnection);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        this.connections.add(realConnection);
        TaskQueue.schedule$default((TaskQueue)this.cleanupQueue, (Task)((Task)this.cleanupTask), (long)0L, (int)2, null);
    }
}
