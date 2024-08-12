/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class UnsafeAllocator {
    static void assertInstantiable(Class<?> clazz) {
        int n = clazz.getModifiers();
        if (Modifier.isInterface(n)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Interface can't be instantiated! Interface name: ");
            stringBuilder.append(clazz.getName());
            throw new UnsupportedOperationException(stringBuilder.toString());
        }
        if (!Modifier.isAbstract(n)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Abstract class can't be instantiated! Class name: ");
        stringBuilder.append(clazz.getName());
        throw new UnsupportedOperationException(stringBuilder.toString());
    }

    public static UnsafeAllocator create() {
        try {
            Object object = Class.forName("sun.misc.Unsafe");
            Object object2 = ((Class)object).getDeclaredField("theUnsafe");
            ((AccessibleObject)object2).setAccessible(true);
            object2 = ((Field)object2).get(null);
            object = new UnsafeAllocator(((Class)object).getMethod("allocateInstance", Class.class), object2){
                final /* synthetic */ Method val$allocateInstance;
                final /* synthetic */ Object val$unsafe;
                {
                    this.val$allocateInstance = method;
                    this.val$unsafe = object;
                }

                @Override
                public <T> T newInstance(Class<T> c) throws Exception {
                    UnsafeAllocator.access$000(c);
                    return (T)this.val$allocateInstance.invoke(this.val$unsafe, c);
                }
            };
            return object;
        }
        catch (Exception exception) {
            try {
                Object object = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                ((AccessibleObject)object).setAccessible(true);
                int n = (Integer)((Method)object).invoke(null, Object.class);
                object = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                ((AccessibleObject)object).setAccessible(true);
                object = new UnsafeAllocator((Method)object, n){
                    final /* synthetic */ Method val$newInstance;
                    final /* synthetic */ int val$constructorId;
                    {
                        this.val$newInstance = method;
                        this.val$constructorId = n;
                    }

                    @Override
                    public <T> T newInstance(Class<T> c) throws Exception {
                        UnsafeAllocator.access$000(c);
                        return (T)this.val$newInstance.invoke(null, c, this.val$constructorId);
                    }
                };
                return object;
            }
            catch (Exception exception2) {
                try {
                    Object object = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    ((AccessibleObject)object).setAccessible(true);
                    object = new UnsafeAllocator((Method)object){
                        final /* synthetic */ Method val$newInstance;
                        {
                            this.val$newInstance = method;
                        }

                        @Override
                        public <T> T newInstance(Class<T> c) throws Exception {
                            UnsafeAllocator.access$000(c);
                            return (T)this.val$newInstance.invoke(null, c, Object.class);
                        }
                    };
                    return object;
                }
                catch (Exception exception3) {
                    return new UnsafeAllocator(){

                        @Override
                        public <T> T newInstance(Class<T> c) {
                            throw new UnsupportedOperationException("Cannot allocate " + c + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
                        }
                    };
                }
            }
        }
    }

    public abstract <T> T newInstance(Class<T> var1) throws Exception;
}
