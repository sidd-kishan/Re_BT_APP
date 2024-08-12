/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.exceptions;

public final class OnErrorNotImplementedException
extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public OnErrorNotImplementedException(String string, Throwable throwable) {
        if (throwable == null) {
            throwable = new NullPointerException();
        }
        super(string, throwable);
    }

    public OnErrorNotImplementedException(Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | ");
        stringBuilder.append(throwable);
        this(stringBuilder.toString(), throwable);
    }
}
