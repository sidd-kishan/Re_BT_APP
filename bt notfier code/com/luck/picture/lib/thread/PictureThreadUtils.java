/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task
 *  com.luck.picture.lib.thread.PictureThreadUtils$ThreadPoolExecutor4Util
 */
package com.luck.picture.lib.thread;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.luck.picture.lib.thread.PictureThreadUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * Exception performing whole class analysis ignored.
 */
public final class PictureThreadUtils {
    private static final int CPU_COUNT;
    private static final Handler HANDLER;
    private static final Map<Task, ExecutorService> TASK_POOL_MAP;
    private static final Timer TIMER;
    private static final byte TYPE_CACHED = -2;
    private static final byte TYPE_CPU = -8;
    private static final byte TYPE_IO = -4;
    private static final Map<Integer, Map<Integer, ExecutorService>> TYPE_PRIORITY_POOLS;
    private static final byte TYPE_SINGLE = -1;
    private static Executor sDeliver;

    static {
        HANDLER = new Handler(Looper.getMainLooper());
        TYPE_PRIORITY_POOLS = new HashMap<Integer, Map<Integer, ExecutorService>>();
        TASK_POOL_MAP = new ConcurrentHashMap<Task, ExecutorService>();
        CPU_COUNT = Runtime.getRuntime().availableProcessors();
        TIMER = new Timer();
    }

    static /* synthetic */ int access$200() {
        return CPU_COUNT;
    }

    static /* synthetic */ Executor access$600() {
        return PictureThreadUtils.getGlobalDeliver();
    }

    static /* synthetic */ Map access$700() {
        return TASK_POOL_MAP;
    }

    public static void cancel(Task task) {
        if (task == null) {
            return;
        }
        task.cancel();
    }

    public static void cancel(List<Task> object) {
        if (object == null) return;
        if (object.size() == 0) {
            return;
        }
        object = object.iterator();
        while (object.hasNext()) {
            Task task = (Task)object.next();
            if (task == null) continue;
            task.cancel();
        }
    }

    public static void cancel(ExecutorService executorService) {
        if (!(executorService instanceof ThreadPoolExecutor4Util)) {
            Log.e((String)"ThreadUtils", (String)"The executorService is not ThreadUtils's pool.");
            return;
        }
        Iterator<Map.Entry<Task, ExecutorService>> iterator = TASK_POOL_MAP.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Task, ExecutorService> entry = iterator.next();
            if (entry.getValue() != executorService) continue;
            PictureThreadUtils.cancel(entry.getKey());
        }
    }

    public static void cancel(Task ... taskArray) {
        if (taskArray == null) return;
        if (taskArray.length == 0) {
            return;
        }
        int n = taskArray.length;
        int n2 = 0;
        while (n2 < n) {
            Task task = taskArray[n2];
            if (task != null) {
                task.cancel();
            }
            ++n2;
        }
    }

    private static <T> void execute(ExecutorService executorService, Task<T> task) {
        PictureThreadUtils.execute(executorService, task, 0L, 0L, null);
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    private static <T> void execute(ExecutorService executorService, Task<T> task, long l, long l2, TimeUnit timeUnit) {
        Map<Task, ExecutorService> map = TASK_POOL_MAP;
        // MONITORENTER : map
        if (TASK_POOL_MAP.get(task) != null) {
            Log.e((String)"ThreadUtils", (String)"Task can only be executed once.");
            // MONITOREXIT : map
            return;
        }
        TASK_POOL_MAP.put(task, executorService);
        // MONITOREXIT : map
        if (l2 != 0L) {
            Task.access$000(task, (boolean)true);
            executorService = new /* Unavailable Anonymous Inner Class!! */;
            TIMER.scheduleAtFixedRate((TimerTask)((Object)executorService), timeUnit.toMillis(l), timeUnit.toMillis(l2));
            return;
        }
        if (l == 0L) {
            executorService.execute((Runnable)task);
            return;
        }
        executorService = new /* Unavailable Anonymous Inner Class!! */;
        TIMER.schedule((TimerTask)((Object)executorService), timeUnit.toMillis(l));
    }

    public static <T> void executeByIo(Task<T> task) {
        PictureThreadUtils.execute(PictureThreadUtils.getPoolByTypeAndPriority(-4), task);
    }

    public static <T> void executeByIo(Task<T> task, int n) {
        PictureThreadUtils.execute(PictureThreadUtils.getPoolByTypeAndPriority(-4, n), task);
    }

    public static <T> void executeBySingle(Task<T> task) {
        PictureThreadUtils.execute(PictureThreadUtils.getPoolByTypeAndPriority(-1), task);
    }

    public static <T> void executeBySingle(Task<T> task, int n) {
        PictureThreadUtils.execute(PictureThreadUtils.getPoolByTypeAndPriority(-1, n), task);
    }

    private static Executor getGlobalDeliver() {
        if (sDeliver != null) return sDeliver;
        sDeliver = new /* Unavailable Anonymous Inner Class!! */;
        return sDeliver;
    }

    public static ExecutorService getIoPool() {
        return PictureThreadUtils.getPoolByTypeAndPriority(-4);
    }

    private static ExecutorService getPoolByTypeAndPriority(int n) {
        return PictureThreadUtils.getPoolByTypeAndPriority(n, 5);
    }

    private static ExecutorService getPoolByTypeAndPriority(int n, int n2) {
        Map<Integer, Map<Integer, ExecutorService>> map = TYPE_PRIORITY_POOLS;
        synchronized (map) {
            ExecutorService executorService;
            Map<Integer, ExecutorService> map2 = TYPE_PRIORITY_POOLS.get(n);
            if (map2 == null) {
                ConcurrentHashMap<Integer, ExecutorService> concurrentHashMap = new ConcurrentHashMap<Integer, ExecutorService>();
                executorService = ThreadPoolExecutor4Util.access$100((int)n, (int)n2);
                concurrentHashMap.put(n2, executorService);
                TYPE_PRIORITY_POOLS.put(n, concurrentHashMap);
            } else {
                ExecutorService executorService2;
                executorService = executorService2 = map2.get(n2);
                if (executorService2 != null) return executorService;
                executorService = ThreadPoolExecutor4Util.access$100((int)n, (int)n2);
                map2.put(n2, executorService);
            }
            return executorService;
        }
    }

    public static ExecutorService getSinglePool() {
        return PictureThreadUtils.getPoolByTypeAndPriority(-1);
    }

    public static ExecutorService getSinglePool(int n) {
        return PictureThreadUtils.getPoolByTypeAndPriority(-1, n);
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            HANDLER.post(runnable);
        }
    }
}
