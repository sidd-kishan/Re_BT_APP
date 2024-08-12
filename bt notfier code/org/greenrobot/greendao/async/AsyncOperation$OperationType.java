/*
 * Decompiled with CFR 0.152.
 */
package org.greenrobot.greendao.async;

public static final class AsyncOperation.OperationType
extends Enum<AsyncOperation.OperationType> {
    private static final AsyncOperation.OperationType[] $VALUES;
    public static final /* enum */ AsyncOperation.OperationType Count;
    public static final /* enum */ AsyncOperation.OperationType Delete;
    public static final /* enum */ AsyncOperation.OperationType DeleteAll;
    public static final /* enum */ AsyncOperation.OperationType DeleteByKey;
    public static final /* enum */ AsyncOperation.OperationType DeleteInTxArray;
    public static final /* enum */ AsyncOperation.OperationType DeleteInTxIterable;
    public static final /* enum */ AsyncOperation.OperationType Insert;
    public static final /* enum */ AsyncOperation.OperationType InsertInTxArray;
    public static final /* enum */ AsyncOperation.OperationType InsertInTxIterable;
    public static final /* enum */ AsyncOperation.OperationType InsertOrReplace;
    public static final /* enum */ AsyncOperation.OperationType InsertOrReplaceInTxArray;
    public static final /* enum */ AsyncOperation.OperationType InsertOrReplaceInTxIterable;
    public static final /* enum */ AsyncOperation.OperationType Load;
    public static final /* enum */ AsyncOperation.OperationType LoadAll;
    public static final /* enum */ AsyncOperation.OperationType QueryList;
    public static final /* enum */ AsyncOperation.OperationType QueryUnique;
    public static final /* enum */ AsyncOperation.OperationType Refresh;
    public static final /* enum */ AsyncOperation.OperationType TransactionCallable;
    public static final /* enum */ AsyncOperation.OperationType TransactionRunnable;
    public static final /* enum */ AsyncOperation.OperationType Update;
    public static final /* enum */ AsyncOperation.OperationType UpdateInTxArray;
    public static final /* enum */ AsyncOperation.OperationType UpdateInTxIterable;

    static {
        AsyncOperation.OperationType operationType;
        Insert = new AsyncOperation.OperationType();
        InsertInTxIterable = new AsyncOperation.OperationType();
        InsertInTxArray = new AsyncOperation.OperationType();
        InsertOrReplace = new AsyncOperation.OperationType();
        InsertOrReplaceInTxIterable = new AsyncOperation.OperationType();
        InsertOrReplaceInTxArray = new AsyncOperation.OperationType();
        Update = new AsyncOperation.OperationType();
        UpdateInTxIterable = new AsyncOperation.OperationType();
        UpdateInTxArray = new AsyncOperation.OperationType();
        Delete = new AsyncOperation.OperationType();
        DeleteInTxIterable = new AsyncOperation.OperationType();
        DeleteInTxArray = new AsyncOperation.OperationType();
        DeleteByKey = new AsyncOperation.OperationType();
        DeleteAll = new AsyncOperation.OperationType();
        TransactionRunnable = new AsyncOperation.OperationType();
        TransactionCallable = new AsyncOperation.OperationType();
        QueryList = new AsyncOperation.OperationType();
        QueryUnique = new AsyncOperation.OperationType();
        Load = new AsyncOperation.OperationType();
        LoadAll = new AsyncOperation.OperationType();
        Count = new AsyncOperation.OperationType();
        Refresh = operationType = new AsyncOperation.OperationType();
        $VALUES = new AsyncOperation.OperationType[]{Insert, InsertInTxIterable, InsertInTxArray, InsertOrReplace, InsertOrReplaceInTxIterable, InsertOrReplaceInTxArray, Update, UpdateInTxIterable, UpdateInTxArray, Delete, DeleteInTxIterable, DeleteInTxArray, DeleteByKey, DeleteAll, TransactionRunnable, TransactionCallable, QueryList, QueryUnique, Load, LoadAll, Count, operationType};
    }

    public static AsyncOperation.OperationType valueOf(String string) {
        return Enum.valueOf(AsyncOperation.OperationType.class, string);
    }

    public static AsyncOperation.OperationType[] values() {
        return (AsyncOperation.OperationType[])$VALUES.clone();
    }
}
