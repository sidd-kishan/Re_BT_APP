/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Call
 *  okhttp3.internal.Util
 *  okhttp3.internal.connection.RealCall
 *  okhttp3.internal.connection.RealCall$AsyncCall
 */
package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0019\u0010 \u001a\u00020\u001f2\n\u0010!\u001a\u00060\u001aR\u00020\u001bH\u0000\u00a2\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001bH\u0000\u00a2\u0006\u0002\b$J\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b%J\u0016\u0010&\u001a\b\u0018\u00010\u001aR\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0002J)\u0010)\u001a\u00020\u001f\"\u0004\b\u0000\u0010*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0,2\u0006\u0010!\u001a\u0002H*H\u0002\u00a2\u0006\u0002\u0010-J\u0015\u0010)\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001bH\u0000\u00a2\u0006\u0002\b.J\u0019\u0010)\u001a\u00020\u001f2\n\u0010!\u001a\u00060\u001aR\u00020\u001bH\u0000\u00a2\u0006\u0002\b.J\b\u0010/\u001a\u000200H\u0002J\f\u00101\u001a\b\u0012\u0004\u0012\u00020302J\u0006\u00104\u001a\u00020\u0010J\f\u00105\u001a\b\u0012\u0004\u0012\u00020302J\u0006\u00106\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00108F@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u001aR\u00020\u001b0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u001aR\u00020\u001b0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2={"Lokhttp3/Dispatcher;", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "(Ljava/util/concurrent/ExecutorService;)V", "()V", "()Ljava/util/concurrent/ExecutorService;", "executorServiceOrNull", "<set-?>", "Ljava/lang/Runnable;", "idleCallback", "getIdleCallback", "()Ljava/lang/Runnable;", "setIdleCallback", "(Ljava/lang/Runnable;)V", "maxRequests", "", "getMaxRequests", "()I", "setMaxRequests", "(I)V", "maxRequestsPerHost", "getMaxRequestsPerHost", "setMaxRequestsPerHost", "readyAsyncCalls", "Ljava/util/ArrayDeque;", "Lokhttp3/internal/connection/RealCall$AsyncCall;", "Lokhttp3/internal/connection/RealCall;", "runningAsyncCalls", "runningSyncCalls", "cancelAll", "", "enqueue", "call", "enqueue$okhttp", "executed", "executed$okhttp", "-deprecated_executorService", "findExistingCallWithHost", "host", "", "finished", "T", "calls", "Ljava/util/Deque;", "(Ljava/util/Deque;Ljava/lang/Object;)V", "finished$okhttp", "promoteAndExecute", "", "queuedCalls", "", "Lokhttp3/Call;", "queuedCallsCount", "runningCalls", "runningCallsCount", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Dispatcher {
    private ExecutorService executorServiceOrNull;
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;
    private final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;
    private final ArrayDeque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
    }

    public Dispatcher(ExecutorService executorService) {
        Intrinsics.checkNotNullParameter((Object)executorService, (String)"executorService");
        this();
        this.executorServiceOrNull = executorService;
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String string) {
        RealCall.AsyncCall asyncCall2;
        for (RealCall.AsyncCall asyncCall2 : this.runningAsyncCalls) {
            if (!Intrinsics.areEqual((Object)asyncCall2.getHost(), (Object)string)) continue;
            return asyncCall2;
        }
        Iterator<RealCall.AsyncCall> iterator = this.readyAsyncCalls.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!Intrinsics.areEqual((Object)(asyncCall2 = iterator.next()).getHost(), (Object)string));
        return asyncCall2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    private final <T> void finished(Deque<T> object, T object2) {
        synchronized (this) {
            if (object.remove(object2)) {
                object = this.getIdleCallback();
                object2 = Unit.INSTANCE;
                // MONITOREXIT @DISABLED, blocks:[0, 2, 4] lbl6 : MonitorExitStatement: MONITOREXIT : this
                if (this.promoteAndExecute()) return;
                if (object == null) return;
                object.run();
                return;
            }
            {
                object = new AssertionError((Object)"Call wasn't in-flight!");
                throw object;
            }
        }
    }

    private final boolean promoteAndExecute() {
        int n;
        boolean bl;
        int n2;
        int n3;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(this);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        List list = new ArrayList();
        synchronized (this) {
            Unit unit = this.readyAsyncCalls.iterator();
            Intrinsics.checkNotNullExpressionValue(unit, (String)"readyAsyncCalls.iterator()");
            while (unit.hasNext()) {
                RealCall.AsyncCall asyncCall = unit.next();
                if (this.runningAsyncCalls.size() >= this.getMaxRequests()) break;
                if (asyncCall.getCallsPerHost().get() >= this.getMaxRequestsPerHost()) continue;
                unit.remove();
                asyncCall.getCallsPerHost().incrementAndGet();
                Intrinsics.checkNotNullExpressionValue((Object)asyncCall, (String)"asyncCall");
                list.add(asyncCall);
                this.runningAsyncCalls.add(asyncCall);
            }
            n3 = this.runningCallsCount();
            n2 = 0;
            bl = n3 > 0;
            unit = Unit.INSTANCE;
            // MONITOREXIT @DISABLED, blocks:[0, 1] lbl34 : MonitorExitStatement: MONITOREXIT : this
            n = list.size();
            if (n <= 0) return bl;
        }
        while (true) {
            n3 = n2 + 1;
            ((RealCall.AsyncCall)list.get(n2)).executeOn(this.executorService());
            if (n3 >= n) {
                return bl;
            }
            n2 = n3;
        }
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="executorService", imports={}))
    public final ExecutorService _deprecated_executorService() {
        return this.executorService();
    }

    public final void cancelAll() {
        synchronized (this) {
            try {
                Iterator<RealCall.AsyncCall> iterator = this.readyAsyncCalls.iterator();
                while (iterator.hasNext()) {
                    iterator.next().getCall().cancel();
                }
                iterator = this.runningAsyncCalls.iterator();
                while (iterator.hasNext()) {
                    iterator.next().getCall().cancel();
                }
                iterator = this.runningSyncCalls.iterator();
                while (iterator.hasNext()) {
                    ((RealCall)iterator.next()).cancel();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final void enqueue$okhttp(RealCall.AsyncCall asyncCall) {
        Intrinsics.checkNotNullParameter((Object)asyncCall, (String)"call");
        synchronized (this) {
            RealCall.AsyncCall asyncCall2;
            this.readyAsyncCalls.add(asyncCall);
            if (!asyncCall.getCall().getForWebSocket() && (asyncCall2 = this.findExistingCallWithHost(asyncCall.getHost())) != null) {
                asyncCall.reuseCallsPerHostFrom(asyncCall2);
            }
            asyncCall = Unit.INSTANCE;
            // MONITOREXIT @DISABLED, blocks:[0, 1] lbl9 : MonitorExitStatement: MONITOREXIT : this
            this.promoteAndExecute();
        }
    }

    public final void executed$okhttp(RealCall realCall) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)realCall, (String)"call");
            this.runningSyncCalls.add(realCall);
            return;
        }
    }

    public final ExecutorService executorService() {
        synchronized (this) {
            SynchronousQueue synchronousQueue;
            if (this.executorServiceOrNull == null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                synchronousQueue = new SynchronousQueue();
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, (BlockingQueue<Runnable>)synchronousQueue, Util.threadFactory((String)Intrinsics.stringPlus((String)Util.okHttpName, (Object)" Dispatcher"), (boolean)false));
                this.executorServiceOrNull = threadPoolExecutor;
            }
            synchronousQueue = this.executorServiceOrNull;
            Intrinsics.checkNotNull((Object)synchronousQueue);
            return synchronousQueue;
        }
    }

    public final void finished$okhttp(RealCall.AsyncCall asyncCall) {
        Intrinsics.checkNotNullParameter((Object)asyncCall, (String)"call");
        asyncCall.getCallsPerHost().decrementAndGet();
        this.finished((Deque)this.runningAsyncCalls, asyncCall);
    }

    public final void finished$okhttp(RealCall realCall) {
        Intrinsics.checkNotNullParameter((Object)realCall, (String)"call");
        this.finished((Deque)this.runningSyncCalls, realCall);
    }

    public final Runnable getIdleCallback() {
        synchronized (this) {
            Runnable runnable = this.idleCallback;
            return runnable;
        }
    }

    public final int getMaxRequests() {
        synchronized (this) {
            int n = this.maxRequests;
            return n;
        }
    }

    public final int getMaxRequestsPerHost() {
        synchronized (this) {
            int n = this.maxRequestsPerHost;
            return n;
        }
    }

    public final List<Call> queuedCalls() {
        synchronized (this) {
            try {
                List<Call> list = this.readyAsyncCalls;
                Collection<RealCall> collection = new Collection<RealCall>(CollectionsKt.collectionSizeOrDefault((Iterable)list, (int)10));
                collection = collection;
                list = list.iterator();
                while (true) {
                    if (!list.hasNext()) {
                        list = Collections.unmodifiableList((List)collection);
                        Intrinsics.checkNotNullExpressionValue(list, (String)"unmodifiableList(readyAsyncCalls.map { it.call })");
                        return list;
                    }
                    collection.add(((RealCall.AsyncCall)list.next()).getCall());
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final int queuedCallsCount() {
        synchronized (this) {
            int n = this.readyAsyncCalls.size();
            return n;
        }
    }

    public final List<Call> runningCalls() {
        synchronized (this) {
            try {
                List<Call> list = (List<Call>)((Object)this.runningSyncCalls);
                Object object = this.runningAsyncCalls;
                Collection<RealCall> collection = new Collection<RealCall>(CollectionsKt.collectionSizeOrDefault((Iterable)object, (int)10));
                collection = collection;
                object = object.iterator();
                while (true) {
                    if (!object.hasNext()) {
                        list = Collections.unmodifiableList(CollectionsKt.plus((Collection)list, (Iterable)((List)collection)));
                        Intrinsics.checkNotNullExpressionValue(list, (String)"unmodifiableList(running\u2026yncCalls.map { it.call })");
                        return list;
                    }
                    collection.add(((RealCall.AsyncCall)object.next()).getCall());
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final int runningCallsCount() {
        synchronized (this) {
            int n = this.runningAsyncCalls.size();
            int n2 = this.runningSyncCalls.size();
            return n + n2;
        }
    }

    public final void setIdleCallback(Runnable runnable) {
        synchronized (this) {
            this.idleCallback = runnable;
            return;
        }
    }

    public final void setMaxRequests(int n) {
        boolean bl = true;
        if (n < 1) {
            bl = false;
        }
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"max < 1: ", (Object)n).toString());
        synchronized (this) {
            this.maxRequests = n;
            Unit unit = Unit.INSTANCE;
            // MONITOREXIT @DISABLED, blocks:[0, 1] lbl9 : MonitorExitStatement: MONITOREXIT : this
            this.promoteAndExecute();
        }
    }

    public final void setMaxRequestsPerHost(int n) {
        boolean bl = true;
        if (n < 1) {
            bl = false;
        }
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"max < 1: ", (Object)n).toString());
        synchronized (this) {
            this.maxRequestsPerHost = n;
            Unit unit = Unit.INSTANCE;
            // MONITOREXIT @DISABLED, blocks:[0, 1] lbl9 : MonitorExitStatement: MONITOREXIT : this
            this.promoteAndExecute();
        }
    }
}
