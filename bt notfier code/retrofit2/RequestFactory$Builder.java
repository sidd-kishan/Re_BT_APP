/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.coroutines.Continuation
 *  okhttp3.Headers
 *  okhttp3.Headers$Builder
 *  okhttp3.HttpUrl
 *  okhttp3.MediaType
 *  okhttp3.MultipartBody$Part
 *  retrofit2.Converter
 *  retrofit2.ParameterHandler
 *  retrofit2.ParameterHandler$Body
 *  retrofit2.ParameterHandler$Field
 *  retrofit2.ParameterHandler$FieldMap
 *  retrofit2.ParameterHandler$Header
 *  retrofit2.ParameterHandler$HeaderMap
 *  retrofit2.ParameterHandler$Headers
 *  retrofit2.ParameterHandler$Part
 *  retrofit2.ParameterHandler$PartMap
 *  retrofit2.ParameterHandler$Path
 *  retrofit2.ParameterHandler$Query
 *  retrofit2.ParameterHandler$QueryMap
 *  retrofit2.ParameterHandler$QueryName
 *  retrofit2.ParameterHandler$RawPart
 *  retrofit2.ParameterHandler$RelativeUrl
 *  retrofit2.ParameterHandler$Tag
 *  retrofit2.RequestFactory
 *  retrofit2.Retrofit
 *  retrofit2.Utils
 *  retrofit2.http.Body
 *  retrofit2.http.DELETE
 *  retrofit2.http.Field
 *  retrofit2.http.FieldMap
 *  retrofit2.http.FormUrlEncoded
 *  retrofit2.http.GET
 *  retrofit2.http.HEAD
 *  retrofit2.http.HTTP
 *  retrofit2.http.Header
 *  retrofit2.http.HeaderMap
 *  retrofit2.http.Headers
 *  retrofit2.http.Multipart
 *  retrofit2.http.OPTIONS
 *  retrofit2.http.PATCH
 *  retrofit2.http.POST
 *  retrofit2.http.PUT
 *  retrofit2.http.Part
 *  retrofit2.http.PartMap
 *  retrofit2.http.Path
 *  retrofit2.http.Query
 *  retrofit2.http.QueryMap
 *  retrofit2.http.QueryName
 *  retrofit2.http.Tag
 *  retrofit2.http.Url
 */
package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import retrofit2.Converter;
import retrofit2.ParameterHandler;
import retrofit2.RequestFactory;
import retrofit2.Retrofit;
import retrofit2.Utils;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Tag;
import retrofit2.http.Url;

static final class RequestFactory.Builder {
    private static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
    private static final Pattern PARAM_NAME_REGEX;
    private static final Pattern PARAM_URL_REGEX;
    @Nullable
    MediaType contentType;
    boolean gotBody;
    boolean gotField;
    boolean gotPart;
    boolean gotPath;
    boolean gotQuery;
    boolean gotQueryMap;
    boolean gotQueryName;
    boolean gotUrl;
    boolean hasBody;
    @Nullable
    okhttp3.Headers headers;
    @Nullable
    String httpMethod;
    boolean isFormEncoded;
    boolean isKotlinSuspendFunction;
    boolean isMultipart;
    final Method method;
    final Annotation[] methodAnnotations;
    final Annotation[][] parameterAnnotationsArray;
    @Nullable
    ParameterHandler<?>[] parameterHandlers;
    final Type[] parameterTypes;
    @Nullable
    String relativeUrl;
    @Nullable
    Set<String> relativeUrlParamNames;
    final Retrofit retrofit;

    static {
        PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        PARAM_NAME_REGEX = Pattern.compile(PARAM);
    }

    RequestFactory.Builder(Retrofit retrofit, Method method) {
        this.retrofit = retrofit;
        this.method = method;
        this.methodAnnotations = method.getAnnotations();
        this.parameterTypes = method.getGenericParameterTypes();
        this.parameterAnnotationsArray = method.getParameterAnnotations();
    }

    private static Class<?> boxIfPrimitive(Class<?> clazz) {
        if (Boolean.TYPE == clazz) {
            return Boolean.class;
        }
        if (Byte.TYPE == clazz) {
            return Byte.class;
        }
        if (Character.TYPE == clazz) {
            return Character.class;
        }
        if (Double.TYPE == clazz) {
            return Double.class;
        }
        if (Float.TYPE == clazz) {
            return Float.class;
        }
        if (Integer.TYPE == clazz) {
            return Integer.class;
        }
        if (Long.TYPE == clazz) {
            return Long.class;
        }
        Class<Object> clazz2 = clazz;
        if (Short.TYPE != clazz) return clazz2;
        clazz2 = Short.class;
        return clazz2;
    }

    private okhttp3.Headers parseHeaders(String[] stringArray) {
        Headers.Builder builder = new Headers.Builder();
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            String string = stringArray[n2];
            int n3 = string.indexOf(58);
            if (n3 == -1 || n3 == 0 || n3 == string.length() - 1) throw Utils.methodError((Method)this.method, (String)"@Headers value must be in the form \"Name: Value\". Found: \"%s\"", (Object[])new Object[]{string});
            String string2 = string.substring(0, n3);
            string = string.substring(n3 + 1).trim();
            if ("Content-Type".equalsIgnoreCase(string2)) {
                try {
                    this.contentType = MediaType.get((String)string);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    throw Utils.methodError((Method)this.method, (Throwable)illegalArgumentException, (String)"Malformed content type: %s", (Object[])new Object[]{string});
                }
            } else {
                builder.add(string2, string);
            }
            ++n2;
        }
        return builder.build();
    }

    private void parseHttpMethodAndPath(String string, String string2, boolean bl) {
        String string3 = this.httpMethod;
        if (string3 != null) {
            throw Utils.methodError((Method)this.method, (String)"Only one HTTP method is allowed. Found: %s and %s.", (Object[])new Object[]{string3, string});
        }
        this.httpMethod = string;
        this.hasBody = bl;
        if (string2.isEmpty()) {
            return;
        }
        int n = string2.indexOf(63);
        if (n != -1 && n < string2.length() - 1 && PARAM_URL_REGEX.matcher(string = string2.substring(n + 1)).find()) {
            throw Utils.methodError((Method)this.method, (String)"URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", (Object[])new Object[]{string});
        }
        this.relativeUrl = string2;
        this.relativeUrlParamNames = RequestFactory.Builder.parsePathParameters(string2);
    }

    private void parseMethodAnnotation(Annotation stringArray) {
        if (stringArray instanceof DELETE) {
            this.parseHttpMethodAndPath("DELETE", ((DELETE)stringArray).value(), false);
        } else if (stringArray instanceof GET) {
            this.parseHttpMethodAndPath("GET", ((GET)stringArray).value(), false);
        } else if (stringArray instanceof HEAD) {
            this.parseHttpMethodAndPath("HEAD", ((HEAD)stringArray).value(), false);
        } else if (stringArray instanceof PATCH) {
            this.parseHttpMethodAndPath("PATCH", ((PATCH)stringArray).value(), true);
        } else if (stringArray instanceof POST) {
            this.parseHttpMethodAndPath("POST", ((POST)stringArray).value(), true);
        } else if (stringArray instanceof PUT) {
            this.parseHttpMethodAndPath("PUT", ((PUT)stringArray).value(), true);
        } else if (stringArray instanceof OPTIONS) {
            this.parseHttpMethodAndPath("OPTIONS", ((OPTIONS)stringArray).value(), false);
        } else if (stringArray instanceof HTTP) {
            stringArray = (HTTP)stringArray;
            this.parseHttpMethodAndPath(stringArray.method(), stringArray.path(), stringArray.hasBody());
        } else if (stringArray instanceof Headers) {
            if ((stringArray = ((Headers)stringArray).value()).length == 0) throw Utils.methodError((Method)this.method, (String)"@Headers annotation is empty.", (Object[])new Object[0]);
            this.headers = this.parseHeaders(stringArray);
        } else if (stringArray instanceof Multipart) {
            if (this.isFormEncoded) throw Utils.methodError((Method)this.method, (String)"Only one encoding annotation is allowed.", (Object[])new Object[0]);
            this.isMultipart = true;
        } else {
            if (!(stringArray instanceof FormUrlEncoded)) return;
            if (this.isMultipart) throw Utils.methodError((Method)this.method, (String)"Only one encoding annotation is allowed.", (Object[])new Object[0]);
            this.isFormEncoded = true;
        }
    }

    @Nullable
    private ParameterHandler<?> parseParameter(int n, Type type, @Nullable Annotation[] annotationArray, boolean bl) {
        ParameterHandler<?> parameterHandler;
        if (annotationArray == null) {
            parameterHandler = null;
        } else {
            int n2 = annotationArray.length;
            ParameterHandler<?> parameterHandler2 = null;
            int n3 = 0;
            while (true) {
                parameterHandler = parameterHandler2;
                if (n3 >= n2) break;
                parameterHandler = this.parseParameterAnnotation(n, type, annotationArray, annotationArray[n3]);
                if (parameterHandler != null) {
                    if (parameterHandler2 != null) throw Utils.parameterError((Method)this.method, (int)n, (String)"Multiple Retrofit annotations found, only one allowed.", (Object[])new Object[0]);
                    parameterHandler2 = parameterHandler;
                }
                ++n3;
            }
        }
        if (parameterHandler != null) return parameterHandler;
        if (!bl) throw Utils.parameterError((Method)this.method, (int)n, (String)"No Retrofit annotation found.", (Object[])new Object[0]);
        try {
            if (Utils.getRawType((Type)type) != Continuation.class) throw Utils.parameterError((Method)this.method, (int)n, (String)"No Retrofit annotation found.", (Object[])new Object[0]);
            this.isKotlinSuspendFunction = true;
            return null;
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
        }
        throw Utils.parameterError((Method)this.method, (int)n, (String)"No Retrofit annotation found.", (Object[])new Object[0]);
    }

    @Nullable
    private ParameterHandler<?> parseParameterAnnotation(int n, Type type, Annotation[] object, Annotation object2) {
        if (object2 instanceof Url) {
            this.validateResolvableType(n, type);
            if (this.gotUrl) throw Utils.parameterError((Method)this.method, (int)n, (String)"Multiple @Url method annotations found.", (Object[])new Object[0]);
            if (this.gotPath) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Path parameters may not be used with @Url.", (Object[])new Object[0]);
            if (this.gotQuery) throw Utils.parameterError((Method)this.method, (int)n, (String)"A @Url parameter must not come after a @Query.", (Object[])new Object[0]);
            if (this.gotQueryName) throw Utils.parameterError((Method)this.method, (int)n, (String)"A @Url parameter must not come after a @QueryName.", (Object[])new Object[0]);
            if (this.gotQueryMap) throw Utils.parameterError((Method)this.method, (int)n, (String)"A @Url parameter must not come after a @QueryMap.", (Object[])new Object[0]);
            if (this.relativeUrl != null) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Url cannot be used with @%s URL", (Object[])new Object[]{this.httpMethod});
            this.gotUrl = true;
            if (type == HttpUrl.class) return new ParameterHandler.RelativeUrl(this.method, n);
            if (type == String.class) return new ParameterHandler.RelativeUrl(this.method, n);
            if (type == URI.class) return new ParameterHandler.RelativeUrl(this.method, n);
            if (!(type instanceof Class)) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", (Object[])new Object[0]);
            if (!"android.net.Uri".equals(type.getName())) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", (Object[])new Object[0]);
            return new ParameterHandler.RelativeUrl(this.method, n);
        }
        if (object2 instanceof Path) {
            this.validateResolvableType(n, type);
            if (this.gotQuery) throw Utils.parameterError((Method)this.method, (int)n, (String)"A @Path parameter must not come after a @Query.", (Object[])new Object[0]);
            if (this.gotQueryName) throw Utils.parameterError((Method)this.method, (int)n, (String)"A @Path parameter must not come after a @QueryName.", (Object[])new Object[0]);
            if (this.gotQueryMap) throw Utils.parameterError((Method)this.method, (int)n, (String)"A @Path parameter must not come after a @QueryMap.", (Object[])new Object[0]);
            if (this.gotUrl) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Path parameters may not be used with @Url.", (Object[])new Object[0]);
            if (this.relativeUrl == null) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Path can only be used with relative url on @%s", (Object[])new Object[]{this.httpMethod});
            this.gotPath = true;
            Path path = (Path)object2;
            object2 = path.value();
            this.validatePathName(n, (String)object2);
            type = this.retrofit.stringConverter(type, (Annotation[])object);
            return new ParameterHandler.Path(this.method, n, (String)object2, (Converter)type, path.encoded());
        }
        if (object2 instanceof Query) {
            this.validateResolvableType(n, type);
            Object object3 = (Query)object2;
            object2 = object3.value();
            boolean bl = object3.encoded();
            object3 = Utils.getRawType((Type)type);
            this.gotQuery = true;
            if (!Iterable.class.isAssignableFrom((Class<?>)object3)) {
                if (!((Class)object3).isArray()) return new ParameterHandler.Query((String)object2, this.retrofit.stringConverter(type, (Annotation[])object), bl);
                type = RequestFactory.Builder.boxIfPrimitive(((Class)object3).getComponentType());
                return new ParameterHandler.Query((String)object2, this.retrofit.stringConverter(type, (Annotation[])object), bl).array();
            }
            if (type instanceof ParameterizedType) {
                type = Utils.getParameterUpperBound((int)0, (ParameterizedType)((ParameterizedType)type));
                return new ParameterHandler.Query((String)object2, this.retrofit.stringConverter(type, (Annotation[])object), bl).iterable();
            }
            type = this.method;
            object = new StringBuilder();
            ((StringBuilder)object).append(((Class)object3).getSimpleName());
            ((StringBuilder)object).append(" must include generic type (e.g., ");
            ((StringBuilder)object).append(((Class)object3).getSimpleName());
            ((StringBuilder)object).append("<String>)");
            throw Utils.parameterError(type, (int)n, (String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        }
        if (object2 instanceof QueryName) {
            this.validateResolvableType(n, type);
            boolean bl = ((QueryName)object2).encoded();
            object2 = Utils.getRawType((Type)type);
            this.gotQueryName = true;
            if (!Iterable.class.isAssignableFrom((Class<?>)object2)) {
                if (!((Class)object2).isArray()) return new ParameterHandler.QueryName(this.retrofit.stringConverter(type, (Annotation[])object), bl);
                type = RequestFactory.Builder.boxIfPrimitive(((Class)object2).getComponentType());
                return new ParameterHandler.QueryName(this.retrofit.stringConverter(type, (Annotation[])object), bl).array();
            }
            if (type instanceof ParameterizedType) {
                type = Utils.getParameterUpperBound((int)0, (ParameterizedType)((ParameterizedType)type));
                return new ParameterHandler.QueryName(this.retrofit.stringConverter(type, (Annotation[])object), bl).iterable();
            }
            type = this.method;
            object = new StringBuilder();
            ((StringBuilder)object).append(((Class)object2).getSimpleName());
            ((StringBuilder)object).append(" must include generic type (e.g., ");
            ((StringBuilder)object).append(((Class)object2).getSimpleName());
            ((StringBuilder)object).append("<String>)");
            throw Utils.parameterError(type, (int)n, (String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        }
        if (object2 instanceof QueryMap) {
            this.validateResolvableType(n, type);
            Type type2 = Utils.getRawType((Type)type);
            this.gotQueryMap = true;
            if (!Map.class.isAssignableFrom((Class<?>)type2)) throw Utils.parameterError((Method)this.method, (int)n, (String)"@QueryMap parameter type must be Map.", (Object[])new Object[0]);
            if (!((type = Utils.getSupertype((Type)type, (Class)type2, Map.class)) instanceof ParameterizedType)) throw Utils.parameterError((Method)this.method, (int)n, (String)"Map must include generic types (e.g., Map<String, String>)", (Object[])new Object[0]);
            type2 = (ParameterizedType)type;
            if (String.class == (type = Utils.getParameterUpperBound((int)0, (ParameterizedType)type2))) {
                type = Utils.getParameterUpperBound((int)1, (ParameterizedType)type2);
                type = this.retrofit.stringConverter(type, (Annotation[])object);
                return new ParameterHandler.QueryMap(this.method, n, (Converter)type, ((QueryMap)object2).encoded());
            }
            object2 = this.method;
            object = new StringBuilder();
            ((StringBuilder)object).append("@QueryMap keys must be of type String: ");
            ((StringBuilder)object).append(type);
            throw Utils.parameterError((Method)object2, (int)n, (String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        }
        if (object2 instanceof Header) {
            this.validateResolvableType(n, type);
            object2 = ((Header)object2).value();
            Class clazz = Utils.getRawType((Type)type);
            if (!Iterable.class.isAssignableFrom(clazz)) {
                if (!clazz.isArray()) return new ParameterHandler.Header((String)object2, this.retrofit.stringConverter(type, (Annotation[])object));
                type = RequestFactory.Builder.boxIfPrimitive(clazz.getComponentType());
                return new ParameterHandler.Header((String)object2, this.retrofit.stringConverter(type, (Annotation[])object)).array();
            }
            if (type instanceof ParameterizedType) {
                type = Utils.getParameterUpperBound((int)0, (ParameterizedType)((ParameterizedType)type));
                return new ParameterHandler.Header((String)object2, this.retrofit.stringConverter(type, (Annotation[])object)).iterable();
            }
            type = this.method;
            object = new StringBuilder();
            ((StringBuilder)object).append(clazz.getSimpleName());
            ((StringBuilder)object).append(" must include generic type (e.g., ");
            ((StringBuilder)object).append(clazz.getSimpleName());
            ((StringBuilder)object).append("<String>)");
            throw Utils.parameterError(type, (int)n, (String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        }
        if (object2 instanceof HeaderMap) {
            if (type == okhttp3.Headers.class) {
                return new ParameterHandler.Headers(this.method, n);
            }
            this.validateResolvableType(n, type);
            object2 = Utils.getRawType((Type)type);
            if (!Map.class.isAssignableFrom((Class<?>)object2)) throw Utils.parameterError((Method)this.method, (int)n, (String)"@HeaderMap parameter type must be Map.", (Object[])new Object[0]);
            if (!((type = Utils.getSupertype(type, (Class)object2, Map.class)) instanceof ParameterizedType)) throw Utils.parameterError((Method)this.method, (int)n, (String)"Map must include generic types (e.g., Map<String, String>)", (Object[])new Object[0]);
            object2 = (ParameterizedType)type;
            if (String.class == (type = Utils.getParameterUpperBound((int)0, (ParameterizedType)object2))) {
                type = Utils.getParameterUpperBound((int)1, (ParameterizedType)object2);
                type = this.retrofit.stringConverter(type, (Annotation[])object);
                return new ParameterHandler.HeaderMap(this.method, n, (Converter)type);
            }
            object2 = this.method;
            object = new StringBuilder();
            ((StringBuilder)object).append("@HeaderMap keys must be of type String: ");
            ((StringBuilder)object).append(type);
            throw Utils.parameterError((Method)object2, (int)n, (String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        }
        if (object2 instanceof Field) {
            this.validateResolvableType(n, type);
            if (!this.isFormEncoded) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Field parameters can only be used with form encoding.", (Object[])new Object[0]);
            Object object4 = (Field)object2;
            object2 = object4.value();
            boolean bl = object4.encoded();
            this.gotField = true;
            object4 = Utils.getRawType((Type)type);
            if (!Iterable.class.isAssignableFrom((Class<?>)object4)) {
                if (!((Class)object4).isArray()) return new ParameterHandler.Field((String)object2, this.retrofit.stringConverter(type, (Annotation[])object), bl);
                type = RequestFactory.Builder.boxIfPrimitive(((Class)object4).getComponentType());
                return new ParameterHandler.Field((String)object2, this.retrofit.stringConverter(type, (Annotation[])object), bl).array();
            }
            if (type instanceof ParameterizedType) {
                type = Utils.getParameterUpperBound((int)0, (ParameterizedType)((ParameterizedType)type));
                return new ParameterHandler.Field((String)object2, this.retrofit.stringConverter(type, (Annotation[])object), bl).iterable();
            }
            type = this.method;
            object = new StringBuilder();
            ((StringBuilder)object).append(((Class)object4).getSimpleName());
            ((StringBuilder)object).append(" must include generic type (e.g., ");
            ((StringBuilder)object).append(((Class)object4).getSimpleName());
            ((StringBuilder)object).append("<String>)");
            throw Utils.parameterError((Method)((Object)type), (int)n, (String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        }
        if (object2 instanceof FieldMap) {
            this.validateResolvableType(n, type);
            if (!this.isFormEncoded) throw Utils.parameterError((Method)this.method, (int)n, (String)"@FieldMap parameters can only be used with form encoding.", (Object[])new Object[0]);
            Type type3 = Utils.getRawType((Type)type);
            if (!Map.class.isAssignableFrom((Class<?>)type3)) throw Utils.parameterError((Method)this.method, (int)n, (String)"@FieldMap parameter type must be Map.", (Object[])new Object[0]);
            if (!((type = Utils.getSupertype((Type)type, (Class)type3, Map.class)) instanceof ParameterizedType)) throw Utils.parameterError((Method)this.method, (int)n, (String)"Map must include generic types (e.g., Map<String, String>)", (Object[])new Object[0]);
            type3 = (ParameterizedType)type;
            if (String.class == (type = Utils.getParameterUpperBound((int)0, (ParameterizedType)type3))) {
                type = Utils.getParameterUpperBound((int)1, (ParameterizedType)type3);
                type = this.retrofit.stringConverter(type, (Annotation[])object);
                this.gotField = true;
                return new ParameterHandler.FieldMap(this.method, n, (Converter)type, ((FieldMap)object2).encoded());
            }
            object2 = this.method;
            object = new StringBuilder();
            ((StringBuilder)object).append("@FieldMap keys must be of type String: ");
            ((StringBuilder)object).append(type);
            throw Utils.parameterError((Method)object2, (int)n, (String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        }
        if (object2 instanceof Part) {
            this.validateResolvableType(n, type);
            if (!this.isMultipart) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Part parameters can only be used with multipart encoding.", (Object[])new Object[0]);
            Part part = (Part)object2;
            this.gotPart = true;
            String string = part.value();
            object2 = Utils.getRawType((Type)type);
            if (string.isEmpty()) {
                if (Iterable.class.isAssignableFrom((Class<?>)object2)) {
                    if (type instanceof ParameterizedType) {
                        if (!MultipartBody.Part.class.isAssignableFrom(Utils.getRawType((Type)Utils.getParameterUpperBound((int)0, (ParameterizedType)((ParameterizedType)type))))) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Part annotation must supply a name or use MultipartBody.Part parameter type.", (Object[])new Object[0]);
                        return ParameterHandler.RawPart.INSTANCE.iterable();
                    }
                    type = this.method;
                    object = new StringBuilder();
                    ((StringBuilder)object).append(((Class)object2).getSimpleName());
                    ((StringBuilder)object).append(" must include generic type (e.g., ");
                    ((StringBuilder)object).append(((Class)object2).getSimpleName());
                    ((StringBuilder)object).append("<String>)");
                    throw Utils.parameterError((Method)((Object)type), (int)n, (String)((StringBuilder)object).toString(), (Object[])new Object[0]);
                }
                if (((Class)object2).isArray()) {
                    if (!MultipartBody.Part.class.isAssignableFrom(((Class)object2).getComponentType())) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Part annotation must supply a name or use MultipartBody.Part parameter type.", (Object[])new Object[0]);
                    return ParameterHandler.RawPart.INSTANCE.array();
                }
                if (!MultipartBody.Part.class.isAssignableFrom((Class<?>)object2)) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Part annotation must supply a name or use MultipartBody.Part parameter type.", (Object[])new Object[0]);
                return ParameterHandler.RawPart.INSTANCE;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("form-data; name=\"");
            stringBuilder.append(string);
            stringBuilder.append("\"");
            stringBuilder = okhttp3.Headers.of((String[])new String[]{"Content-Disposition", stringBuilder.toString(), "Content-Transfer-Encoding", part.encoding()});
            if (Iterable.class.isAssignableFrom((Class<?>)object2)) {
                if (type instanceof ParameterizedType) {
                    if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType(type = Utils.getParameterUpperBound((int)0, (ParameterizedType)((ParameterizedType)type))))) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", (Object[])new Object[0]);
                    type = this.retrofit.requestBodyConverter(type, (Annotation[])object, this.methodAnnotations);
                    return new ParameterHandler.Part(this.method, n, (okhttp3.Headers)stringBuilder, (Converter)type).iterable();
                }
                object = this.method;
                type = new StringBuilder();
                ((StringBuilder)((Object)type)).append(((Class)object2).getSimpleName());
                ((StringBuilder)((Object)type)).append(" must include generic type (e.g., ");
                ((StringBuilder)((Object)type)).append(((Class)object2).getSimpleName());
                ((StringBuilder)((Object)type)).append("<String>)");
                throw Utils.parameterError((Method)object, (int)n, (String)((StringBuilder)((Object)type)).toString(), (Object[])new Object[0]);
            }
            if (((Class)object2).isArray()) {
                type = RequestFactory.Builder.boxIfPrimitive(((Class)object2).getComponentType());
                if (MultipartBody.Part.class.isAssignableFrom((Class<?>)type)) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", (Object[])new Object[0]);
                type = this.retrofit.requestBodyConverter(type, (Annotation[])object, this.methodAnnotations);
                return new ParameterHandler.Part(this.method, n, (okhttp3.Headers)stringBuilder, (Converter)type).array();
            }
            if (MultipartBody.Part.class.isAssignableFrom((Class<?>)object2)) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", (Object[])new Object[0]);
            type = this.retrofit.requestBodyConverter(type, (Annotation[])object, this.methodAnnotations);
            return new ParameterHandler.Part(this.method, n, (okhttp3.Headers)stringBuilder, (Converter)type);
        }
        if (object2 instanceof PartMap) {
            this.validateResolvableType(n, type);
            if (!this.isMultipart) throw Utils.parameterError((Method)this.method, (int)n, (String)"@PartMap parameters can only be used with multipart encoding.", (Object[])new Object[0]);
            this.gotPart = true;
            Type type4 = Utils.getRawType((Type)type);
            if (!Map.class.isAssignableFrom((Class<?>)type4)) throw Utils.parameterError((Method)this.method, (int)n, (String)"@PartMap parameter type must be Map.", (Object[])new Object[0]);
            if (!((type = Utils.getSupertype((Type)type, (Class)type4, Map.class)) instanceof ParameterizedType)) throw Utils.parameterError((Method)this.method, (int)n, (String)"Map must include generic types (e.g., Map<String, String>)", (Object[])new Object[0]);
            type4 = (ParameterizedType)type;
            if (String.class == (type = Utils.getParameterUpperBound((int)0, (ParameterizedType)type4))) {
                type = Utils.getParameterUpperBound((int)1, (ParameterizedType)type4);
                if (MultipartBody.Part.class.isAssignableFrom(Utils.getRawType((Type)type))) throw Utils.parameterError((Method)this.method, (int)n, (String)"@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", (Object[])new Object[0]);
                type = this.retrofit.requestBodyConverter(type, (Annotation[])object, this.methodAnnotations);
                object = (PartMap)object2;
                return new ParameterHandler.PartMap(this.method, n, (Converter)type, object.encoding());
            }
            object2 = this.method;
            object = new StringBuilder();
            ((StringBuilder)object).append("@PartMap keys must be of type String: ");
            ((StringBuilder)object).append(type);
            throw Utils.parameterError((Method)object2, (int)n, (String)((StringBuilder)object).toString(), (Object[])new Object[0]);
        }
        if (object2 instanceof Body) {
            this.validateResolvableType(n, type);
            if (this.isFormEncoded) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Body parameters cannot be used with form or multi-part encoding.", (Object[])new Object[0]);
            if (this.isMultipart) throw Utils.parameterError((Method)this.method, (int)n, (String)"@Body parameters cannot be used with form or multi-part encoding.", (Object[])new Object[0]);
            if (this.gotBody) throw Utils.parameterError((Method)this.method, (int)n, (String)"Multiple @Body method annotations found.", (Object[])new Object[0]);
            try {
                object = this.retrofit.requestBodyConverter(type, (Annotation[])object, this.methodAnnotations);
                this.gotBody = true;
            }
            catch (RuntimeException runtimeException) {
                throw Utils.parameterError((Method)this.method, (Throwable)runtimeException, (int)n, (String)"Unable to create @Body converter for %s", (Object[])new Object[]{type});
            }
            return new ParameterHandler.Body(this.method, n, (Converter)object);
        }
        if (!(object2 instanceof Tag)) return null;
        this.validateResolvableType(n, type);
        type = Utils.getRawType((Type)type);
        int n2 = n - 1;
        while (n2 >= 0) {
            object = this.parameterHandlers[n2];
            if (object instanceof ParameterHandler.Tag && ((ParameterHandler.Tag)object).cls.equals(type)) {
                object2 = this.method;
                object = new StringBuilder();
                ((StringBuilder)object).append("@Tag type ");
                ((StringBuilder)object).append(type.getName());
                ((StringBuilder)object).append(" is duplicate of parameter #");
                ((StringBuilder)object).append(n2 + 1);
                ((StringBuilder)object).append(" and would always overwrite its value.");
                throw Utils.parameterError((Method)object2, (int)n, (String)((StringBuilder)object).toString(), (Object[])new Object[0]);
            }
            --n2;
        }
        return new ParameterHandler.Tag((Class)type);
    }

    static Set<String> parsePathParameters(String object) {
        Matcher matcher = PARAM_URL_REGEX.matcher((CharSequence)object);
        object = new LinkedHashSet();
        while (matcher.find()) {
            object.add(matcher.group(1));
        }
        return object;
    }

    private void validatePathName(int n, String string) {
        if (!PARAM_NAME_REGEX.matcher(string).matches()) {
            throw Utils.parameterError((Method)this.method, (int)n, (String)"@Path parameter name must match %s. Found: %s", (Object[])new Object[]{PARAM_URL_REGEX.pattern(), string});
        }
        if (!this.relativeUrlParamNames.contains(string)) throw Utils.parameterError((Method)this.method, (int)n, (String)"URL \"%s\" does not contain \"{%s}\".", (Object[])new Object[]{this.relativeUrl, string});
    }

    private void validateResolvableType(int n, Type type) {
        if (Utils.hasUnresolvableType((Type)type)) throw Utils.parameterError((Method)this.method, (int)n, (String)"Parameter type must not include a type variable or wildcard: %s", (Object[])new Object[]{type});
    }

    RequestFactory build() {
        int n;
        Object object = this.methodAnnotations;
        int n2 = ((Annotation[])object).length;
        for (n = 0; n < n2; ++n) {
            this.parseMethodAnnotation(object[n]);
        }
        if (this.httpMethod == null) {
            object = Utils.methodError((Method)this.method, (String)"HTTP method annotation is required (e.g., @GET, @POST, etc.).", (Object[])new Object[0]);
            throw object;
        }
        if (!this.hasBody) {
            if (this.isMultipart) throw Utils.methodError((Method)this.method, (String)"Multipart can only be specified on HTTP methods with request body (e.g., @POST).", (Object[])new Object[0]);
            if (this.isFormEncoded) throw Utils.methodError((Method)this.method, (String)"FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", (Object[])new Object[0]);
        }
        n2 = this.parameterAnnotationsArray.length;
        this.parameterHandlers = new ParameterHandler[n2];
        n = 0;
        while (true) {
            boolean bl = true;
            if (n >= n2) break;
            ParameterHandler<?>[] parameterHandlerArray = this.parameterHandlers;
            object = this.parameterTypes[n];
            Annotation[] annotationArray = this.parameterAnnotationsArray[n];
            if (n != n2 - 1) {
                bl = false;
            }
            parameterHandlerArray[n] = this.parseParameter(n, (Type)object, annotationArray, bl);
            ++n;
        }
        if (this.relativeUrl == null && !this.gotUrl) {
            throw Utils.methodError((Method)this.method, (String)"Missing either @%s URL or @Url parameter.", (Object[])new Object[]{this.httpMethod});
        }
        if (!(this.isFormEncoded || this.isMultipart || this.hasBody)) {
            if (this.gotBody) throw Utils.methodError((Method)this.method, (String)"Non-body HTTP method cannot contain @Body.", (Object[])new Object[0]);
        }
        if (this.isFormEncoded) {
            if (!this.gotField) throw Utils.methodError((Method)this.method, (String)"Form-encoded method must contain at least one @Field.", (Object[])new Object[0]);
        }
        if (!this.isMultipart) return new RequestFactory(this);
        if (!this.gotPart) throw Utils.methodError((Method)this.method, (String)"Multipart method must contain at least one @Part.", (Object[])new Object[0]);
        return new RequestFactory(this);
    }
}
