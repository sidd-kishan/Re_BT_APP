/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.reflect.ReflectionAccessor
 */
package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class ConstructorConstructor {
    private final ReflectionAccessor accessor = ReflectionAccessor.getInstance();
    private final Map<Type, InstanceCreator<?>> instanceCreators;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        this.instanceCreators = map;
    }

    private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> object) {
        try {
            object = ((Class)object).getDeclaredConstructor(new Class[0]);
            if (!((AccessibleObject)object).isAccessible()) {
                this.accessor.makeAccessible((AccessibleObject)object);
            }
            object = new ObjectConstructor<T>(this, (Constructor)object){
                final /* synthetic */ String val$exceptionMessage;
                {
                    this.val$exceptionMessage = string;
                }

                @Override
                public T construct() {
                    throw new JsonIOException(this.val$exceptionMessage);
                }
            };
            return object;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return null;
        }
    }

    private <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type type, Class<? super T> clazz) {
        if (Collection.class.isAssignableFrom(clazz)) {
            if (SortedSet.class.isAssignableFrom(clazz)) {
                return new ObjectConstructor<T>(this){
                    final /* synthetic */ String val$message;
                    {
                        this.val$message = string;
                    }

                    @Override
                    public T construct() {
                        throw new JsonIOException(this.val$message);
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(clazz)) {
                return new ObjectConstructor<T>(this, type){
                    final /* synthetic */ Type val$type;
                    {
                        this.val$type = type;
                    }

                    @Override
                    public T construct() {
                        if (!(this.val$type instanceof ParameterizedType)) throw new JsonIOException("Invalid EnumSet type: " + this.val$type.toString());
                        Type elementType = ((ParameterizedType)this.val$type).getActualTypeArguments()[0];
                        if (!(elementType instanceof Class)) throw new JsonIOException("Invalid EnumSet type: " + this.val$type.toString());
                        EnumSet set = EnumSet.noneOf((Class)elementType);
                        return set;
                    }
                };
            }
            if (Set.class.isAssignableFrom(clazz)) {
                return new ObjectConstructor<T>(this){

                    @Override
                    public T construct() {
                        if (!(this instanceof ParameterizedType)) throw new JsonIOException("Invalid EnumMap type: " + this.toString());
                        Type elementType = ((ParameterizedType)this).getActualTypeArguments()[0];
                        if (!(elementType instanceof Class)) throw new JsonIOException("Invalid EnumMap type: " + this.toString());
                        EnumMap map = new EnumMap((Class)elementType);
                        return map;
                    }
                };
            }
            if (!Queue.class.isAssignableFrom(clazz)) return new ObjectConstructor<T>(this){

                @Override
                public T construct() {
                    throw new JsonIOException(this);
                }
            };
            return new ObjectConstructor<T>(this){

                @Override
                public T construct() {
                    throw new JsonIOException(this);
                }
            };
        }
        if (!Map.class.isAssignableFrom(clazz)) return null;
        if (ConcurrentNavigableMap.class.isAssignableFrom(clazz)) {
            return new ObjectConstructor<T>(this){

                @Override
                public T construct() {
                    try {
                        Object newInstance = this.newInstance(new Object[0]);
                        return newInstance;
                    }
                    catch (InstantiationException e) {
                        throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this) + "' with no args", e);
                    }
                    catch (InvocationTargetException e) {
                        throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(this) + "' with no args", e.getCause());
                    }
                    catch (IllegalAccessException e) {
                        throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
                    }
                }
            };
        }
        if (ConcurrentMap.class.isAssignableFrom(clazz)) {
            return new ObjectConstructor<T>(this){

                @Override
                public T construct() {
                    return new TreeSet();
                }
            };
        }
        if (SortedMap.class.isAssignableFrom(clazz)) {
            return new ObjectConstructor<T>(this){

                @Override
                public T construct() {
                    return new LinkedHashSet();
                }
            };
        }
        if (!(type instanceof ParameterizedType)) return new ObjectConstructor<T>(this){

            @Override
            public T construct() {
                return new ArrayList();
            }
        };
        if (String.class.isAssignableFrom(TypeToken.get(((ParameterizedType)type).getActualTypeArguments()[0]).getRawType())) return new /* invalid duplicate definition of identical inner class */;
        return new ObjectConstructor<T>(this){

            @Override
            public T construct() {
                return new ArrayDeque();
            }
        };
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(Type type, Class<? super T> clazz) {
        return new ObjectConstructor<T>(this, clazz, type){

            @Override
            public T construct() {
                return new ConcurrentSkipListMap();
            }
        };
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> object) {
        Type type = ((TypeToken)object).getType();
        object = ((TypeToken)object).getRawType();
        ObjectConstructor<T> objectConstructor = this.instanceCreators.get(type);
        if (objectConstructor != null) {
            return new ObjectConstructor<T>((InstanceCreator)objectConstructor, type){
                final /* synthetic */ InstanceCreator val$typeCreator;
                final /* synthetic */ Type val$type;
                {
                    this.val$typeCreator = instanceCreator;
                    this.val$type = type;
                }

                @Override
                public T construct() {
                    return this.val$typeCreator.createInstance(this.val$type);
                }
            };
        }
        objectConstructor = this.instanceCreators.get(object);
        if (objectConstructor != null) {
            return new ObjectConstructor<T>((InstanceCreator)objectConstructor, type){
                final /* synthetic */ InstanceCreator val$rawTypeCreator;
                final /* synthetic */ Type val$type;
                {
                    this.val$rawTypeCreator = instanceCreator;
                    this.val$type = type;
                }

                @Override
                public T construct() {
                    return this.val$rawTypeCreator.createInstance(this.val$type);
                }
            };
        }
        objectConstructor = this.newDefaultConstructor((Class<? super T>)object);
        if (objectConstructor != null) {
            return objectConstructor;
        }
        objectConstructor = this.newDefaultImplementationConstructor(type, (Class<? super T>)object);
        if (objectConstructor == null) return this.newUnsafeAllocator(type, (Class<? super T>)object);
        return objectConstructor;
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
