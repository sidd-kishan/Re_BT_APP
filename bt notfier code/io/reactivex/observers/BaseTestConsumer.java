/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Notification
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.internal.util.VolatileSizeArrayList
 *  io.reactivex.observers.BaseTestConsumer$TestWaitStrategy
 */
package io.reactivex.observers;

import io.reactivex.Notification;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>>
implements Disposable {
    protected boolean checkSubscriptionOnce;
    protected long completions;
    protected final CountDownLatch done;
    protected final List<Throwable> errors;
    protected int establishedFusionMode;
    protected int initialFusionMode;
    protected Thread lastThread;
    protected CharSequence tag;
    protected boolean timeout;
    protected final List<T> values = new VolatileSizeArrayList();

    public BaseTestConsumer() {
        this.errors = new VolatileSizeArrayList();
        this.done = new CountDownLatch(1);
    }

    public static String valueAndClass(Object object) {
        if (object == null) return "null";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(object);
        stringBuilder.append(" (class: ");
        stringBuilder.append(object.getClass().getSimpleName());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final U assertComplete() {
        long l = this.completions;
        if (l == 0L) throw this.fail("Not completed");
        if (l <= 1L) {
            return (U)this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Multiple completions: ");
        stringBuilder.append(l);
        throw this.fail(stringBuilder.toString());
    }

    public final U assertEmpty() {
        return ((BaseTestConsumer)((BaseTestConsumer)((BaseTestConsumer)this.assertSubscribed()).assertNoValues()).assertNoErrors()).assertNotComplete();
    }

    /*
     * Exception decompiling
     */
    public final U assertError(Predicate<Throwable> var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[DOLOOP]], but top level block is 0[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public final U assertError(Class<? extends Throwable> clazz) {
        return this.assertError((Predicate<Throwable>)Functions.isInstanceOf(clazz));
    }

    public final U assertError(Throwable throwable) {
        return this.assertError((Predicate<Throwable>)Functions.equalsWith((Object)throwable));
    }

    public final U assertErrorMessage(String string) {
        int n = this.errors.size();
        if (n == 0) throw this.fail("No errors");
        if (n != 1) throw this.fail("Multiple errors");
        String string2 = this.errors.get(0).getMessage();
        if (ObjectHelper.equals((Object)string, (Object)string2)) {
            return (U)this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error message differs; exptected: ");
        stringBuilder.append(string);
        stringBuilder.append(" but was: ");
        stringBuilder.append(string2);
        throw this.fail(stringBuilder.toString());
    }

    public final U assertFailure(Predicate<Throwable> predicate, T ... TArray) {
        return ((BaseTestConsumer)((BaseTestConsumer)((BaseTestConsumer)this.assertSubscribed()).assertValues(TArray)).assertError(predicate)).assertNotComplete();
    }

    public final U assertFailure(Class<? extends Throwable> clazz, T ... TArray) {
        return ((BaseTestConsumer)((BaseTestConsumer)((BaseTestConsumer)this.assertSubscribed()).assertValues(TArray)).assertError(clazz)).assertNotComplete();
    }

    public final U assertFailureAndMessage(Class<? extends Throwable> clazz, String string, T ... TArray) {
        return ((BaseTestConsumer)((BaseTestConsumer)((BaseTestConsumer)((BaseTestConsumer)this.assertSubscribed()).assertValues(TArray)).assertError(clazz)).assertErrorMessage(string)).assertNotComplete();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public final U assertNever(Predicate<? super T> var1_1) {
        var3_3 = this.values.size();
        var2_4 = 0;
        while (var2_4 < var3_3) {
            var4_5 = this.values.get(var2_4);
            try {
                if (!var1_1.test(var4_5)) {
                    ++var2_4;
                    continue;
                }
                ** GOTO lbl-1000
            }
            catch (Exception var1_2) {
                throw ExceptionHelper.wrapOrThrow((Throwable)var1_2);
            }
        }
        return (U)this;
lbl-1000:
        // 1 sources

        {
            var4_5 = new StringBuilder();
            var4_5.append("Value at position ");
            var4_5.append(var2_4);
            var4_5.append(" matches predicate ");
            var4_5.append(var1_1.toString());
            var4_5.append(", which was not expected.");
            throw this.fail(var4_5.toString());
        }
    }

    public final U assertNever(T t) {
        int n = this.values.size();
        int n2 = 0;
        while (n2 < n) {
            if (ObjectHelper.equals(this.values.get(n2), t)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Value at position ");
                stringBuilder.append(n2);
                stringBuilder.append(" is equal to ");
                stringBuilder.append(BaseTestConsumer.valueAndClass(t));
                stringBuilder.append("; Expected them to be different");
                throw this.fail(stringBuilder.toString());
            }
            ++n2;
        }
        return (U)this;
    }

    public final U assertNoErrors() {
        if (this.errors.size() == 0) {
            return (U)this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error(s) present: ");
        stringBuilder.append(this.errors);
        throw this.fail(stringBuilder.toString());
    }

    public final U assertNoTimeout() {
        if (this.timeout) throw this.fail("Timeout?!");
        return (U)this;
    }

    public final U assertNoValues() {
        return this.assertValueCount(0);
    }

    public final U assertNotComplete() {
        long l = this.completions;
        if (l == 1L) throw this.fail("Completed!");
        if (l <= 1L) {
            return (U)this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Multiple completions: ");
        stringBuilder.append(l);
        throw this.fail(stringBuilder.toString());
    }

    public abstract U assertNotSubscribed();

    public final U assertNotTerminated() {
        if (this.done.getCount() == 0L) throw this.fail("Subscriber terminated!");
        return (U)this;
    }

    public final U assertResult(T ... TArray) {
        return ((BaseTestConsumer)((BaseTestConsumer)((BaseTestConsumer)this.assertSubscribed()).assertValues(TArray)).assertNoErrors()).assertComplete();
    }

    public abstract U assertSubscribed();

    public final U assertTerminated() {
        if (this.done.getCount() != 0L) throw this.fail("Subscriber still running!");
        long l = this.completions;
        if (l > 1L) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Terminated with multiple completions: ");
            stringBuilder.append(l);
            throw this.fail(stringBuilder.toString());
        }
        int n = this.errors.size();
        if (n > 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Terminated with multiple errors: ");
            stringBuilder.append(n);
            throw this.fail(stringBuilder.toString());
        }
        if (l == 0L) return (U)this;
        if (n == 0) {
            return (U)this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Terminated with multiple completions and errors: ");
        stringBuilder.append(l);
        throw this.fail(stringBuilder.toString());
    }

    public final U assertTimeout() {
        if (!this.timeout) throw this.fail("No timeout?!");
        return (U)this;
    }

    public final U assertValue(Predicate<T> predicate) {
        this.assertValueAt(0, (T)predicate);
        if (this.values.size() > 1) throw this.fail("Value present but other values as well");
        return (U)this;
    }

    public final U assertValue(T t) {
        if (this.values.size() != 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected: ");
            stringBuilder.append(BaseTestConsumer.valueAndClass(t));
            stringBuilder.append(" but was: ");
            stringBuilder.append(this.values);
            throw this.fail(stringBuilder.toString());
        }
        T t2 = this.values.get(0);
        if (ObjectHelper.equals(t, t2)) {
            return (U)this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected: ");
        stringBuilder.append(BaseTestConsumer.valueAndClass(t));
        stringBuilder.append(" but was: ");
        stringBuilder.append(BaseTestConsumer.valueAndClass(t2));
        throw this.fail(stringBuilder.toString());
    }

    public final U assertValueAt(int n, Predicate<T> object) {
        if (this.values.size() == 0) throw this.fail("No values");
        if (n >= this.values.size()) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Invalid index: ");
            ((StringBuilder)object).append(n);
            throw this.fail(((StringBuilder)object).toString());
        }
        try {
            boolean bl = object.test(this.values.get(n));
            if (!bl) throw this.fail("Value not present");
        }
        catch (Exception exception) {
            throw ExceptionHelper.wrapOrThrow((Throwable)exception);
        }
        return (U)this;
    }

    public final U assertValueAt(int n, T object) {
        int n2 = this.values.size();
        if (n2 == 0) throw this.fail("No values");
        if (n >= n2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Invalid index: ");
            ((StringBuilder)object).append(n);
            throw this.fail(((StringBuilder)object).toString());
        }
        T t = this.values.get(n);
        if (ObjectHelper.equals((Object)object, t)) {
            return (U)this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expected: ");
        stringBuilder.append(BaseTestConsumer.valueAndClass(object));
        stringBuilder.append(" but was: ");
        stringBuilder.append(BaseTestConsumer.valueAndClass(t));
        throw this.fail(stringBuilder.toString());
    }

    public final U assertValueCount(int n) {
        int n2 = this.values.size();
        if (n2 == n) {
            return (U)this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Value counts differ; expected: ");
        stringBuilder.append(n);
        stringBuilder.append(" but was: ");
        stringBuilder.append(n2);
        throw this.fail(stringBuilder.toString());
    }

    public final U assertValueSequence(Iterable<? extends T> object) {
        boolean bl;
        boolean bl2;
        Object object2 = this.values.iterator();
        Iterator<T> iterator = object.iterator();
        int n = 0;
        while (true) {
            T t;
            bl2 = iterator.hasNext();
            bl = object2.hasNext();
            if (!bl || !bl2) break;
            object = iterator.next();
            if (!ObjectHelper.equals((Object)object, t = object2.next())) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Values at position ");
                ((StringBuilder)object2).append(n);
                ((StringBuilder)object2).append(" differ; expected: ");
                ((StringBuilder)object2).append(BaseTestConsumer.valueAndClass(object));
                ((StringBuilder)object2).append(" but was: ");
                ((StringBuilder)object2).append(BaseTestConsumer.valueAndClass(t));
                throw this.fail(((StringBuilder)object2).toString());
            }
            ++n;
        }
        if (bl) {
            object = new StringBuilder();
            ((StringBuilder)object).append("More values received than expected (");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(")");
            object = this.fail(((StringBuilder)object).toString());
            throw object;
        }
        if (!bl2) {
            return (U)this;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fewer values received than expected (");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(")");
        throw this.fail(((StringBuilder)object).toString());
    }

    public final U assertValueSequenceOnly(Iterable<? extends T> iterable) {
        return ((BaseTestConsumer)((BaseTestConsumer)((BaseTestConsumer)this.assertSubscribed()).assertValueSequence(iterable)).assertNoErrors()).assertNotComplete();
    }

    public final U assertValueSet(Collection<? extends T> object) {
        T t;
        if (object.isEmpty()) {
            this.assertNoValues();
            return (U)this;
        }
        Iterator<T> iterator = this.values.iterator();
        do {
            if (!iterator.hasNext()) return (U)this;
        } while (object.contains(t = iterator.next()));
        object = new StringBuilder();
        ((StringBuilder)object).append("Value not in the expected collection: ");
        ((StringBuilder)object).append(BaseTestConsumer.valueAndClass(t));
        throw this.fail(((StringBuilder)object).toString());
    }

    public final U assertValueSetOnly(Collection<? extends T> collection) {
        return ((BaseTestConsumer)((BaseTestConsumer)((BaseTestConsumer)this.assertSubscribed()).assertValueSet(collection)).assertNoErrors()).assertNotComplete();
    }

    public final U assertValues(T ... object) {
        int n = this.values.size();
        if (n != ((T[])object).length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Value count differs; expected: ");
            stringBuilder.append(((T[])object).length);
            stringBuilder.append(" ");
            stringBuilder.append(Arrays.toString((Object[])object));
            stringBuilder.append(" but was: ");
            stringBuilder.append(n);
            stringBuilder.append(" ");
            stringBuilder.append(this.values);
            object = this.fail(stringBuilder.toString());
            throw object;
        }
        int n2 = 0;
        while (n2 < n) {
            T t = object[n2];
            T t2 = this.values.get(n2);
            if (!ObjectHelper.equals(t, t2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Values at position ");
                ((StringBuilder)object).append(n2);
                ((StringBuilder)object).append(" differ; expected: ");
                ((StringBuilder)object).append(BaseTestConsumer.valueAndClass(t));
                ((StringBuilder)object).append(" but was: ");
                ((StringBuilder)object).append(BaseTestConsumer.valueAndClass(t2));
                throw this.fail(((StringBuilder)object).toString());
            }
            ++n2;
        }
        return (U)this;
    }

    public final U assertValuesOnly(T ... TArray) {
        return ((BaseTestConsumer)((BaseTestConsumer)((BaseTestConsumer)this.assertSubscribed()).assertValues(TArray)).assertNoErrors()).assertNotComplete();
    }

    public final U await() throws InterruptedException {
        if (this.done.getCount() == 0L) {
            return (U)this;
        }
        this.done.await();
        return (U)this;
    }

    public final boolean await(long l, TimeUnit timeUnit) throws InterruptedException {
        boolean bl = this.done.getCount() == 0L || this.done.await(l, timeUnit);
        this.timeout = bl ^ true;
        return bl;
    }

    public final U awaitCount(int n) {
        return this.awaitCount(n, (Runnable)TestWaitStrategy.SLEEP_10MS, 5000L);
    }

    public final U awaitCount(int n, Runnable runnable) {
        return this.awaitCount(n, runnable, 5000L);
    }

    public final U awaitCount(int n, Runnable runnable, long l) {
        long l2 = System.currentTimeMillis();
        while (true) {
            if (l > 0L && System.currentTimeMillis() - l2 >= l) {
                this.timeout = true;
                break;
            }
            if (this.done.getCount() == 0L) return (U)this;
            if (this.values.size() >= n) return (U)this;
            runnable.run();
        }
        return (U)this;
    }

    public final U awaitDone(long l, TimeUnit timeUnit) {
        try {
            if (this.done.await(l, timeUnit)) return (U)this;
            this.timeout = true;
            this.dispose();
        }
        catch (InterruptedException interruptedException) {
            this.dispose();
            throw ExceptionHelper.wrapOrThrow((Throwable)interruptedException);
        }
        return (U)this;
    }

    public final boolean awaitTerminalEvent() {
        try {
            this.await();
            return true;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final boolean awaitTerminalEvent(long l, TimeUnit timeUnit) {
        try {
            boolean bl = this.await(l, timeUnit);
            return bl;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U clearTimeout() {
        this.timeout = false;
        return (U)this;
    }

    public final long completions() {
        return this.completions;
    }

    public final int errorCount() {
        return this.errors.size();
    }

    public final List<Throwable> errors() {
        return this.errors;
    }

    protected final AssertionError fail(String object) {
        StringBuilder stringBuilder = new StringBuilder(((String)object).length() + 64);
        stringBuilder.append((String)object);
        stringBuilder.append(" (");
        stringBuilder.append("latch = ");
        stringBuilder.append(this.done.getCount());
        stringBuilder.append(", ");
        stringBuilder.append("values = ");
        stringBuilder.append(this.values.size());
        stringBuilder.append(", ");
        stringBuilder.append("errors = ");
        stringBuilder.append(this.errors.size());
        stringBuilder.append(", ");
        stringBuilder.append("completions = ");
        stringBuilder.append(this.completions);
        if (this.timeout) {
            stringBuilder.append(", timeout!");
        }
        if (this.isDisposed()) {
            stringBuilder.append(", disposed!");
        }
        if ((object = this.tag) != null) {
            stringBuilder.append(", tag = ");
            stringBuilder.append((CharSequence)object);
        }
        stringBuilder.append(')');
        object = new AssertionError((Object)stringBuilder.toString());
        if (this.errors.isEmpty()) return object;
        if (this.errors.size() == 1) {
            ((Throwable)object).initCause(this.errors.get(0));
        } else {
            ((Throwable)object).initCause((Throwable)new CompositeException(this.errors));
        }
        return object;
    }

    public final List<List<Object>> getEvents() {
        ArrayList<List<Object>> arrayList = new ArrayList<List<Object>>();
        arrayList.add(this.values());
        arrayList.add(this.errors());
        ArrayList<Notification> arrayList2 = new ArrayList<Notification>();
        long l = 0L;
        while (true) {
            if (l >= this.completions) {
                arrayList.add(arrayList2);
                return arrayList;
            }
            arrayList2.add(Notification.createOnComplete());
            ++l;
        }
    }

    public final boolean isTerminated() {
        boolean bl = this.done.getCount() == 0L;
        return bl;
    }

    public final boolean isTimeout() {
        return this.timeout;
    }

    public final Thread lastThread() {
        return this.lastThread;
    }

    public final int valueCount() {
        return this.values.size();
    }

    public final List<T> values() {
        return this.values;
    }

    public final U withTag(CharSequence charSequence) {
        this.tag = charSequence;
        return (U)this;
    }
}
