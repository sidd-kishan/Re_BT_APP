/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.ArrayIteratorKt
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.StringCompanionObject
 *  kotlin.jvm.internal.TypeIntrinsics
 *  kotlin.ranges.RangesKt
 *  kotlin.text.Charsets
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  okhttp3.Call
 *  okhttp3.EventListener
 *  okhttp3.EventListener$Factory
 *  okhttp3.Headers
 *  okhttp3.Headers$Builder
 *  okhttp3.HttpUrl
 *  okhttp3.OkHttpClient
 *  okhttp3.RequestBody
 *  okhttp3.RequestBody$Companion
 *  okhttp3.Response
 *  okhttp3.ResponseBody
 *  okhttp3.ResponseBody$Companion
 *  okhttp3.internal._$$Lambda$Util$HCtG_IMz5G4h_r4fydmtsti2nbM
 *  okhttp3.internal._$$Lambda$Util$OvjneDlA_Jy5aDflPUCwJHwCMTY
 *  okhttp3.internal.http2.Header
 *  okio.Buffer
 *  okio.BufferedSink
 *  okio.BufferedSource
 *  okio.ByteString
 *  okio.FileSystem
 *  okio.Options
 *  okio.Path
 *  okio.Source
 */
package okhttp3.internal;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal._$;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.FileSystem;
import okio.Options;
import okio.Path;
import okio.Source;

@Metadata(d1={"\u0000\u00bc\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u001a\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017\u001a'\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"\u00a2\u0006\u0002\u0010#\u001a\u001a\u0010$\u001a\u00020\u001b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&H\u0086\b\u00f8\u0001\u0000\u001a-\u0010'\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u0002H)0!\"\u0002H)H\u0007\u00a2\u0006\u0002\u0010+\u001a\u000e\u0010,\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0011\u001a1\u0010-\u001a\u0004\u0018\u0001H)\"\u0004\b\u0000\u0010)2\u0006\u0010.\u001a\u00020\"2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H)002\u0006\u00101\u001a\u00020\u0011\u00a2\u0006\u0002\u00102\u001a\u0016\u00103\u001a\u0002042\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u000f\u001a\"\u00106\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00112\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&H\u0086\b\u00f8\u0001\u0000\u001a%\u00107\u001a\u00020\u001b\"\u0004\b\u0000\u00108*\b\u0012\u0004\u0012\u0002H8092\u0006\u0010:\u001a\u0002H8H\u0000\u00a2\u0006\u0002\u0010;\u001a\u0015\u0010<\u001a\u00020\u0014*\u00020=2\u0006\u0010>\u001a\u00020\u0014H\u0086\u0004\u001a\u0015\u0010<\u001a\u00020\u0017*\u00020\u00142\u0006\u0010>\u001a\u00020\u0017H\u0086\u0004\u001a\u0015\u0010<\u001a\u00020\u0014*\u00020?2\u0006\u0010>\u001a\u00020\u0014H\u0086\u0004\u001a\n\u0010@\u001a\u00020A*\u00020B\u001a\r\u0010C\u001a\u00020\u001b*\u00020\"H\u0080\b\u001a\r\u0010D\u001a\u00020\u001b*\u00020\"H\u0080\b\u001a\n\u0010E\u001a\u00020\u000f*\u00020\u0011\u001a\u0012\u0010F\u001a\u00020\u000f*\u00020G2\u0006\u0010H\u001a\u00020G\u001a\n\u0010I\u001a\u00020\u001b*\u00020J\u001a\n\u0010I\u001a\u00020\u001b*\u00020K\u001a\n\u0010I\u001a\u00020\u001b*\u00020L\u001a#\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00110!*\b\u0012\u0004\u0012\u00020\u00110!2\u0006\u0010N\u001a\u00020\u0011\u00a2\u0006\u0002\u0010O\u001a\u0012\u0010P\u001a\u00020\u001b*\u00020Q2\u0006\u0010R\u001a\u00020S\u001a\u0012\u0010T\u001a\u00020\u001b*\u00020Q2\u0006\u0010U\u001a\u00020S\u001a&\u0010V\u001a\u00020\u0014*\u00020\u00112\u0006\u0010W\u001a\u00020X2\b\b\u0002\u0010Y\u001a\u00020\u00142\b\b\u0002\u0010Z\u001a\u00020\u0014\u001a&\u0010V\u001a\u00020\u0014*\u00020\u00112\u0006\u0010[\u001a\u00020\u00112\b\b\u0002\u0010Y\u001a\u00020\u00142\b\b\u0002\u0010Z\u001a\u00020\u0014\u001a\u001a\u0010\\\u001a\u00020\u000f*\u00020]2\u0006\u0010^\u001a\u00020\u00142\u0006\u0010_\u001a\u00020\u0019\u001a;\u0010`\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0a2\u0017\u0010b\u001a\u0013\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u00020\u000f0c\u00a2\u0006\u0002\bdH\u0080\b\u00f8\u0001\u0000\u001aA\u0010e\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00110!2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010!2\u001a\u0010f\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00110gj\n\u0012\u0006\b\u0000\u0012\u00020\u0011`h\u00a2\u0006\u0002\u0010i\u001a\f\u0010j\u001a\u00020\u0017*\u00020kH\u0000\u001a5\u0010l\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00110!2\u0006\u0010N\u001a\u00020\u00112\u0016\u0010f\u001a\u0012\u0012\u0004\u0012\u00020\u00110gj\b\u0012\u0004\u0012\u00020\u0011`h\u00a2\u0006\u0002\u0010m\u001a\n\u0010n\u001a\u00020\u0014*\u00020\u0011\u001a\u001e\u0010o\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010Y\u001a\u00020\u00142\b\b\u0002\u0010Z\u001a\u00020\u0014\u001a\u001e\u0010p\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010Y\u001a\u00020\u00142\b\b\u0002\u0010Z\u001a\u00020\u0014\u001a\u0016\u0010q\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010Y\u001a\u00020\u0014H\u0000\u001aE\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00110!*\b\u0012\u0004\u0012\u00020\u00110!2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00110!2\u001a\u0010f\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00110gj\n\u0012\u0006\b\u0000\u0012\u00020\u0011`h\u00a2\u0006\u0002\u0010s\u001a\u0012\u0010t\u001a\u00020\u000f*\u00020Q2\u0006\u0010u\u001a\u00020S\u001a\u0012\u0010v\u001a\u00020\u000f*\u00020L2\u0006\u0010w\u001a\u00020x\u001a\r\u0010y\u001a\u00020\u001b*\u00020\"H\u0080\b\u001a\r\u0010z\u001a\u00020\u001b*\u00020\"H\u0080\b\u001a\n\u0010{\u001a\u00020\u0014*\u00020X\u001a\n\u0010|\u001a\u00020\u0011*\u00020L\u001a\u0012\u0010}\u001a\u00020~*\u00020x2\u0006\u0010\u007f\u001a\u00020~\u001a\u000b\u0010\u0080\u0001\u001a\u00020\u0014*\u00020x\u001a\u0015\u0010\u0081\u0001\u001a\u00020\u0014*\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020=\u001a\u001b\u0010\u0081\u0001\u001a\u00020\u000f*\u00020]2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010_\u001a\u00020\u0019\u001a\u0012\u0010\u0084\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010(*\u00020\u0003\u001a\u0012\u0010\u0086\u0001\u001a\u00020\u0003*\t\u0012\u0005\u0012\u00030\u0085\u00010(\u001a\r\u0010\u0087\u0001\u001a\u00020\u0011*\u00020\u0014H\u0000\u001a\r\u0010\u0087\u0001\u001a\u00020\u0011*\u00020\u0017H\u0000\u001a\u0016\u0010\u0088\u0001\u001a\u00020\u0011*\u00020G2\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u000f\u001a\u001d\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0(\u001a7\u0010\u008b\u0001\u001a\u0011\u0012\u0005\u0012\u0003H\u008d\u0001\u0012\u0005\u0012\u0003H\u008e\u00010\u008c\u0001\"\u0005\b\u0000\u0010\u008d\u0001\"\u0005\b\u0001\u0010\u008e\u0001*\u0011\u0012\u0005\u0012\u0003H\u008d\u0001\u0012\u0005\u0012\u0003H\u008e\u00010\u008c\u0001\u001a\u0014\u0010\u008f\u0001\u001a\u00020\u0017*\u00020\u00112\u0007\u0010\u0090\u0001\u001a\u00020\u0017\u001a\u0018\u0010\u0091\u0001\u001a\u00020\u0014*\u0004\u0018\u00010\u00112\u0007\u0010\u0090\u0001\u001a\u00020\u0014H\u0000\u001a\u001f\u0010\u0092\u0001\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010Y\u001a\u00020\u00142\b\b\u0002\u0010Z\u001a\u00020\u0014\u001a\u000e\u0010\u0093\u0001\u001a\u00020\u001b*\u00020\"H\u0080\b\u001a)\u0010\u0094\u0001\u001a\u00030\u0095\u0001*\b0\u0096\u0001j\u0003`\u0097\u00012\u0013\u0010\u0098\u0001\u001a\u000e\u0012\n\u0012\b0\u0096\u0001j\u0003`\u0097\u00010(H\u0000\u001a\u0015\u0010\u0099\u0001\u001a\u00020\u001b*\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u0014\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u00118\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u009c\u0001"}, d2={"EMPTY_BYTE_ARRAY", "", "EMPTY_HEADERS", "Lokhttp3/Headers;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "UNICODE_BOMS", "Lokio/Options;", "UTC", "Ljava/util/TimeZone;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "assertionsEnabled", "", "okHttpName", "", "userAgent", "checkDuration", "", "name", "duration", "", "unit", "Ljava/util/concurrent/TimeUnit;", "checkOffsetAndCount", "", "arrayLength", "offset", "count", "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "ignoreIoExceptions", "block", "Lkotlin/Function0;", "immutableListOf", "", "T", "elements", "([Ljava/lang/Object;)Ljava/util/List;", "isSensitiveHeader", "readFieldOrNull", "instance", "fieldType", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "daemon", "threadName", "addIfAbsent", "E", "", "element", "(Ljava/util/List;Ljava/lang/Object;)V", "and", "", "mask", "", "asFactory", "Lokhttp3/EventListener$Factory;", "Lokhttp3/EventListener;", "assertThreadDoesntHoldLock", "assertThreadHoldsLock", "canParseAsIpAddress", "canReuseConnectionFor", "Lokhttp3/HttpUrl;", "other", "closeQuietly", "Ljava/io/Closeable;", "Ljava/net/ServerSocket;", "Ljava/net/Socket;", "concat", "value", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "deleteContents", "Lokio/FileSystem;", "directory", "Lokio/Path;", "deleteIfExists", "path", "delimiterOffset", "delimiter", "", "startIndex", "endIndex", "delimiters", "discard", "Lokio/Source;", "timeout", "timeUnit", "filterList", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "hasIntersection", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "headersContentLength", "Lokhttp3/Response;", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "indexOfControlOrNonAscii", "indexOfFirstNonAsciiWhitespace", "indexOfLastNonAsciiWhitespace", "indexOfNonWhitespace", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "isCivilized", "file", "isHealthy", "source", "Lokio/BufferedSource;", "notify", "notifyAll", "parseHexDigit", "peerName", "readBomAsCharset", "Ljava/nio/charset/Charset;", "default", "readMedium", "skipAll", "Lokio/Buffer;", "b", "toHeaderList", "Lokhttp3/internal/http2/Header;", "toHeaders", "toHexString", "toHostHeader", "includeDefaultPort", "toImmutableList", "toImmutableMap", "", "K", "V", "toLongOrDefault", "defaultValue", "toNonNegativeInt", "trimSubstring", "wait", "withSuppressed", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "writeMedium", "Lokio/BufferedSink;", "medium", "okhttp"}, k=2, mv={1, 5, 1}, xi=48)
public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    private static final Options UNICODE_BOMS;
    public static final TimeZone UTC;
    private static final Regex VERIFY_AS_IP_ADDRESS;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;
    public static final String userAgent = "okhttp/5.0.0-alpha.3";

    static {
        EMPTY_RESPONSE = ResponseBody.Companion.create$default((ResponseBody.Companion)ResponseBody.Companion, (byte[])EMPTY_BYTE_ARRAY, null, (int)1, null);
        EMPTY_REQUEST = RequestBody.Companion.create$default((RequestBody.Companion)RequestBody.Companion, (byte[])EMPTY_BYTE_ARRAY, null, (int)0, (int)0, (int)7, null);
        UNICODE_BOMS = Options.Companion.of(new ByteString[]{ByteString.Companion.decodeHex("efbbbf"), ByteString.Companion.decodeHex("feff"), ByteString.Companion.decodeHex("fffe"), ByteString.Companion.decodeHex("0000ffff"), ByteString.Companion.decodeHex("ffff0000")});
        Object object = TimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull((Object)object);
        UTC = object;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = OkHttpClient.class.desiredAssertionStatus();
        object = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"OkHttpClient::class.java.name");
        okHttpName = StringsKt.removeSuffix((String)StringsKt.removePrefix((String)object, (CharSequence)"okhttp3."), (CharSequence)"Client");
    }

    public static final <E> void addIfAbsent(List<E> list, E e) {
        Intrinsics.checkNotNullParameter(list, (String)"<this>");
        if (list.contains(e)) return;
        list.add(e);
    }

    public static final int and(byte by, int n) {
        return by & n;
    }

    public static final int and(short s, int n) {
        return s & n;
    }

    public static final long and(int n, long l) {
        return l & (long)n;
    }

    public static final EventListener.Factory asFactory(EventListener eventListener) {
        Intrinsics.checkNotNullParameter((Object)eventListener, (String)"<this>");
        return new _$.Lambda.Util.OvjneDlA_Jy5aDflPUCwJHwCMTY(eventListener);
    }

    private static final EventListener asFactory$lambda_8(EventListener eventListener, Call call) {
        Intrinsics.checkNotNullParameter((Object)eventListener, (String)"$this_asFactory");
        Intrinsics.checkNotNullParameter((Object)call, (String)"it");
        return eventListener;
    }

    public static final void assertThreadDoesntHoldLock(Object object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        if (!assertionsEnabled) return;
        if (!Thread.holdsLock(object)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Thread ");
        stringBuilder.append((Object)Thread.currentThread().getName());
        stringBuilder.append(" MUST NOT hold lock on ");
        stringBuilder.append(object);
        throw new AssertionError((Object)stringBuilder.toString());
    }

    public static final void assertThreadHoldsLock(Object object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        if (!assertionsEnabled) return;
        if (Thread.holdsLock(object)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Thread ");
        stringBuilder.append((Object)Thread.currentThread().getName());
        stringBuilder.append(" MUST hold lock on ");
        stringBuilder.append(object);
        throw new AssertionError((Object)stringBuilder.toString());
    }

    public static final boolean canParseAsIpAddress(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        return VERIFY_AS_IP_ADDRESS.matches((CharSequence)string);
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl httpUrl2) {
        Intrinsics.checkNotNullParameter((Object)httpUrl, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)httpUrl2, (String)"other");
        boolean bl = Intrinsics.areEqual((Object)httpUrl.host(), (Object)httpUrl2.host()) && httpUrl.port() == httpUrl2.port() && Intrinsics.areEqual((Object)httpUrl.scheme(), (Object)httpUrl2.scheme());
        return bl;
    }

    public static final int checkDuration(String string, long l, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        boolean bl = true;
        boolean bl2 = l >= 0L;
        if (!bl2) throw (Throwable)new IllegalStateException(Intrinsics.stringPlus((String)string, (Object)" < 0").toString());
        bl2 = timeUnit != null;
        if (!bl2) throw (Throwable)new IllegalStateException("unit == null".toString());
        long l2 = timeUnit.toMillis(l);
        bl2 = l2 <= Integer.MAX_VALUE;
        if (!bl2) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)string, (Object)" too large.").toString());
        bl2 = bl;
        if (l2 == 0L) {
            bl2 = l <= 0L ? bl : false;
        }
        if (!bl2) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)string, (Object)" too small.").toString());
        return (int)l2;
    }

    public static final void checkOffsetAndCount(long l, long l2, long l3) {
        if ((l2 | l3) < 0L) throw new ArrayIndexOutOfBoundsException();
        if (l2 > l) throw new ArrayIndexOutOfBoundsException();
        if (l - l2 < l3) throw new ArrayIndexOutOfBoundsException();
    }

    /*
     * Enabled force condition propagation
     */
    public static final void closeQuietly(Closeable closeable) {
        Intrinsics.checkNotNullParameter((Object)closeable, (String)"<this>");
        try {
            closeable.close();
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public static final void closeQuietly(ServerSocket serverSocket) {
        Intrinsics.checkNotNullParameter((Object)serverSocket, (String)"<this>");
        try {
            serverSocket.close();
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public static final void closeQuietly(Socket socket) {
        Intrinsics.checkNotNullParameter((Object)socket, (String)"<this>");
        try {
            socket.close();
            return;
        }
        catch (RuntimeException runtimeException) {
            if (!Intrinsics.areEqual((Object)runtimeException.getMessage(), (Object)"bio == null")) throw runtimeException;
            return;
        }
        catch (AssertionError assertionError) {
            throw assertionError;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static final String[] concat(String[] stringArray, String string) {
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string, (String)"value");
        stringArray = Arrays.copyOf(stringArray, stringArray.length + 1);
        Intrinsics.checkNotNullExpressionValue((Object)stringArray, (String)"java.util.Arrays.copyOf(this, newSize)");
        stringArray[ArraysKt.getLastIndex((Object[])stringArray)] = string;
        return stringArray;
    }

    public static final void deleteContents(FileSystem fileSystem, Path object) {
        Iterator iterator;
        Intrinsics.checkNotNullParameter((Object)fileSystem, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)object, (String)"directory");
        try {
            object = fileSystem.list((Path)object);
            iterator = object.iterator();
            object = null;
        }
        catch (FileNotFoundException fileNotFoundException) {
            return;
        }
        while (true) {
            if (!iterator.hasNext()) {
                if (object != null) throw object;
                return;
            }
            Path path = (Path)iterator.next();
            try {
                if (fileSystem.metadata(path).isDirectory()) {
                    Util.deleteContents(fileSystem, path);
                }
                fileSystem.delete(path);
            }
            catch (IOException iOException) {
                if (object != null) continue;
                object = iOException;
                continue;
            }
            break;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public static final void deleteIfExists(FileSystem fileSystem, Path path) {
        Intrinsics.checkNotNullParameter((Object)fileSystem, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        try {
            fileSystem.delete(path);
            return;
        }
        catch (FileNotFoundException fileNotFoundException) {
            return;
        }
    }

    public static final int delimiterOffset(String string, char c, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        if (n >= n2) return n2;
        while (true) {
            int n3 = n + 1;
            if (string.charAt(n) == c) {
                return n;
            }
            if (n3 >= n2) {
                return n2;
            }
            n = n3;
        }
    }

    public static final int delimiterOffset(String string, String string2, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"delimiters");
        if (n >= n2) return n2;
        while (true) {
            int n3 = n + 1;
            if (StringsKt.contains$default((CharSequence)string2, (char)string.charAt(n), (boolean)false, (int)2, null)) {
                return n;
            }
            if (n3 >= n2) {
                return n2;
            }
            n = n3;
        }
    }

    public static /* synthetic */ int delimiterOffset$default(String string, char c, int n, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) == 0) return Util.delimiterOffset(string, c, n, n2);
        n2 = string.length();
        return Util.delimiterOffset(string, c, n, n2);
    }

    public static /* synthetic */ int delimiterOffset$default(String string, String string2, int n, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) == 0) return Util.delimiterOffset(string, string2, n, n2);
        n2 = string.length();
        return Util.delimiterOffset(string, string2, n, n2);
    }

    public static final boolean discard(Source source, int n, TimeUnit timeUnit) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)source, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"timeUnit");
        try {
            bl = Util.skipAll(source, n, timeUnit);
        }
        catch (IOException iOException) {
            bl = false;
        }
        return bl;
    }

    public static final <T> List<T> filterList(Iterable<? extends T> list, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, (String)"<this>");
        Intrinsics.checkNotNullParameter(function1, (String)"predicate");
        List list2 = CollectionsKt.emptyList();
        Iterator<T> iterator = list.iterator();
        list = list2;
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (!((Boolean)function1.invoke(t)).booleanValue()) continue;
            list2 = list;
            if (list.isEmpty()) {
                list2 = new ArrayList();
            }
            TypeIntrinsics.asMutableList((Object)list2).add(t);
            list = list2;
        }
        return list;
    }

    public static final String format(String string, Object ... objectArray) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"format");
        Intrinsics.checkNotNullParameter((Object)objectArray, (String)"args");
        Object object = StringCompanionObject.INSTANCE;
        object = Locale.US;
        objectArray = Arrays.copyOf(objectArray, objectArray.length);
        string = String.format((Locale)object, string, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.String.format(locale, format, *args)");
        return string;
    }

    public static final boolean hasIntersection(String[] stringArray, String[] stringArray2, Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"<this>");
        Intrinsics.checkNotNullParameter(comparator, (String)"comparator");
        int n = stringArray.length == 0 ? 1 : 0;
        if (n != 0) return false;
        if (stringArray2 == null) return false;
        n = stringArray2.length == 0 ? 1 : 0;
        if (n != 0) {
            return false;
        }
        int n2 = stringArray.length;
        n = 0;
        block0: while (true) {
            if (n >= n2) return false;
            String string = stringArray[n];
            int n3 = n + 1;
            Iterator iterator = ArrayIteratorKt.iterator((Object[])stringArray2);
            do {
                n = n3;
                if (!iterator.hasNext()) continue block0;
            } while (comparator.compare(string, (String)iterator.next()) != 0);
            break;
        }
        return true;
    }

    public static final long headersContentLength(Response object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        object = object.headers().get("Content-Length");
        long l = -1L;
        if (object == null) return l;
        l = Util.toLongOrDefault((String)object, -1L);
        return l;
    }

    /*
     * Enabled force condition propagation
     */
    public static final void ignoreIoExceptions(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, (String)"block");
        try {
            function0.invoke();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T ... object) {
        Intrinsics.checkNotNullParameter(object, (String)"elements");
        object = (Object[])object.clone();
        object = Collections.unmodifiableList(CollectionsKt.listOf((Object[])Arrays.copyOf(object, ((T[])object).length)));
        Intrinsics.checkNotNullExpressionValue(object, (String)"unmodifiableList(listOf(*elements.clone()))");
        return object;
    }

    public static final int indexOf(String[] stringArray, String string, Comparator<String> comparator) {
        int n;
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string, (String)"value");
        Intrinsics.checkNotNullParameter(comparator, (String)"comparator");
        int n2 = stringArray.length;
        for (n = 0; n < n2; ++n) {
            boolean bl = comparator.compare(stringArray[n], string) == 0;
            if (bl) return n;
        }
        n = -1;
        return n;
    }

    public static final int indexOfControlOrNonAscii(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        int n = string.length();
        if (n <= 0) return -1;
        int n2 = 0;
        while (true) {
            int n3 = n2 + 1;
            char c = string.charAt(n2);
            if (Intrinsics.compare((int)c, (int)31) <= 0) return n2;
            if (Intrinsics.compare((int)c, (int)127) >= 0) {
                return n2;
            }
            if (n3 >= n) {
                return -1;
            }
            n2 = n3;
        }
    }

    public static final int indexOfFirstNonAsciiWhitespace(String string, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        if (n >= n2) return n2;
        while (true) {
            boolean bl;
            int n3;
            block6: {
                block5: {
                    n3 = n + 1;
                    char c = string.charAt(n);
                    boolean bl2 = false;
                    bl = c == '\t' || c == '\n';
                    bl = bl || c == '\f';
                    if (bl = bl || c == '\r') break block5;
                    bl = bl2;
                    if (c != ' ') break block6;
                }
                bl = true;
            }
            if (!bl) return n;
            if (n3 >= n2) {
                return n2;
            }
            n = n3;
        }
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String string, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) == 0) return Util.indexOfFirstNonAsciiWhitespace(string, n, n2);
        n2 = string.length();
        return Util.indexOfFirstNonAsciiWhitespace(string, n, n2);
    }

    public static final int indexOfLastNonAsciiWhitespace(String string, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        if (n > --n2) return n;
        while (true) {
            boolean bl;
            block6: {
                block5: {
                    char c = string.charAt(n2);
                    boolean bl2 = false;
                    bl = c == '\t' || c == '\n';
                    bl = bl || c == '\f';
                    if (bl = bl || c == '\r') break block5;
                    bl = bl2;
                    if (c != ' ') break block6;
                }
                bl = true;
            }
            if (!bl) return n2 + 1;
            if (n2 == n) {
                return n;
            }
            --n2;
        }
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String string, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) == 0) return Util.indexOfLastNonAsciiWhitespace(string, n, n2);
        n2 = string.length();
        return Util.indexOfLastNonAsciiWhitespace(string, n, n2);
    }

    public static final int indexOfNonWhitespace(String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        int n2 = string.length();
        if (n >= n2) return string.length();
        while (true) {
            int n3 = n + 1;
            char c = string.charAt(n);
            if (c != ' ' && c != '\t') {
                return n;
            }
            if (n3 >= n2) {
                return string.length();
            }
            n = n3;
        }
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String string, int n, int n2, Object object) {
        if ((n2 & 1) == 0) return Util.indexOfNonWhitespace(string, n);
        n = 0;
        return Util.indexOfNonWhitespace(string, n);
    }

    public static final String[] intersect(String[] object, String[] stringArray, Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"other");
        Intrinsics.checkNotNullParameter(comparator, (String)"comparator");
        List list = new ArrayList();
        int n = ((String[])object).length;
        int n2 = 0;
        block0: while (n2 < n) {
            String string;
            String string2 = object[n2];
            int n3 = n2 + 1;
            int n4 = stringArray.length;
            int n5 = 0;
            do {
                n2 = n3;
                if (n5 >= n4) continue block0;
                string = stringArray[n5];
                ++n5;
            } while (comparator.compare(string2, string) != 0);
            list.add(string2);
            n2 = n3;
        }
        object = ((Collection)list).toArray(new String[0]);
        if (object != null) {
            return object;
        }
        object = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        throw object;
    }

    /*
     * Exception decompiling
     */
    public static final boolean isCivilized(FileSystem var0, Path var1_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[CATCHBLOCK]
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

    /*
     * Enabled unnecessary exception pruning
     */
    public static final boolean isHealthy(Socket socket, BufferedSource bufferedSource) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)socket, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"source");
        boolean bl2 = true;
        int n = socket.getSoTimeout();
        try {
            socket.setSoTimeout(1);
            bl = bufferedSource.exhausted();
        }
        catch (Throwable throwable) {
            try {
                socket.setSoTimeout(n);
                throw throwable;
            }
            catch (IOException iOException) {
                return false;
            }
            catch (SocketTimeoutException socketTimeoutException) {
                return bl2;
            }
        }
        socket.setSoTimeout(n);
        return bl ^ true;
    }

    public static final boolean isSensitiveHeader(String string) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        boolean bl2 = bl = true;
        if (StringsKt.equals((String)string, (String)"Authorization", (boolean)true)) return bl2;
        bl2 = bl;
        if (StringsKt.equals((String)string, (String)"Cookie", (boolean)true)) return bl2;
        bl2 = bl;
        if (StringsKt.equals((String)string, (String)"Proxy-Authorization", (boolean)true)) return bl2;
        bl2 = StringsKt.equals((String)string, (String)"Set-Cookie", (boolean)true) ? bl : false;
        return bl2;
    }

    public static /* synthetic */ Thread lambda$HCtG_IMz5G4h_r4fydmtsti2nbM(String string, boolean bl, Runnable runnable) {
        return Util.threadFactory$lambda_1(string, bl, runnable);
    }

    public static /* synthetic */ EventListener lambda$OvjneDlA_Jy5aDflPUCwJHwCMTY(EventListener eventListener, Call call) {
        return Util.asFactory$lambda_8(eventListener, call);
    }

    public static final void notify(Object object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        object.notify();
    }

    public static final void notifyAll(Object object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        object.notifyAll();
    }

    /*
     * Enabled force condition propagation
     */
    public static final int parseHexDigit(char c) {
        int n = 1;
        int n2 = '0' <= c && c <= '9' ? 1 : 0;
        if (n2 != 0) {
            return (char)(c - 48);
        }
        int n3 = 97;
        n2 = 'a' <= c && c <= 'f' ? 1 : 0;
        if (n2 != 0) {
            n2 = n3;
            return (char)(c - n2 + 10);
        } else {
            n3 = 65;
            n2 = 'A' <= c && c <= 'F' ? n : 0;
            if (n2 == 0) {
                return (char)-1;
            }
            n2 = n3;
        }
        return (char)(c - n2 + 10);
    }

    public static final String peerName(Socket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        object = ((Socket)object).getRemoteSocketAddress();
        if (object instanceof InetSocketAddress) {
            object = ((InetSocketAddress)object).getHostName();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"address.hostName");
        } else {
            object = object.toString();
        }
        return object;
    }

    public static final Charset readBomAsCharset(BufferedSource bufferedSource, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)charset, (String)"default");
        int n = bufferedSource.select(UNICODE_BOMS);
        if (n == -1) return charset;
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n != 4) throw new AssertionError();
                        charset = Charsets.INSTANCE.UTF32_LE();
                    } else {
                        charset = Charsets.INSTANCE.UTF32_BE();
                    }
                } else {
                    charset = StandardCharsets.UTF_16LE;
                    Intrinsics.checkNotNullExpressionValue((Object)charset, (String)"UTF_16LE");
                }
            } else {
                charset = StandardCharsets.UTF_16BE;
                Intrinsics.checkNotNullExpressionValue((Object)charset, (String)"UTF_16BE");
            }
        } else {
            charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue((Object)charset, (String)"UTF_8");
        }
        return charset;
    }

    public static final <T> T readFieldOrNull(Object object, Class<T> clazz, String string) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"instance");
        Intrinsics.checkNotNullParameter(clazz, (String)"fieldType");
        Intrinsics.checkNotNullParameter((Object)string, (String)"fieldName");
        Class<?> clazz2 = object.getClass();
        while (true) {
            boolean bl = Intrinsics.areEqual(clazz2, Object.class);
            Object var5_6 = null;
            if (bl) {
                if (Intrinsics.areEqual((Object)string, (Object)"delegate")) return null;
                if ((object = Util.readFieldOrNull(object, Object.class, "delegate")) == null) return null;
                return Util.readFieldOrNull(object, clazz, string);
            }
            try {
                Object object2 = clazz2.getDeclaredField(string);
                ((AccessibleObject)object2).setAccessible(true);
                object2 = ((Field)object2).get(object);
                if (!clazz.isInstance(object2)) {
                    object = var5_6;
                    break;
                }
                var5_6 = clazz.cast(object2);
                object = var5_6;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                clazz2 = clazz2.getSuperclass();
                Intrinsics.checkNotNullExpressionValue(clazz2, (String)"c.superclass");
                continue;
            }
            break;
        }
        return (T)object;
    }

    public static final int readMedium(BufferedSource bufferedSource) throws IOException {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"<this>");
        int n = Util.and(bufferedSource.readByte(), 255);
        int n2 = Util.and(bufferedSource.readByte(), 255);
        return Util.and(bufferedSource.readByte(), 255) | (n << 16 | n2 << 8);
    }

    public static final int skipAll(Buffer buffer, byte by) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        int n = 0;
        while (!buffer.exhausted()) {
            if (buffer.getByte(0L) != by) return n;
            ++n;
            buffer.readByte();
        }
        return n;
    }

    public static final boolean skipAll(Source source, int n, TimeUnit timeUnit) throws IOException {
        boolean bl;
        block7: {
            long l;
            long l2;
            block6: {
                Intrinsics.checkNotNullParameter((Object)source, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"timeUnit");
                l2 = System.nanoTime();
                l = source.timeout().hasDeadline() ? source.timeout().deadlineNanoTime() - l2 : Long.MAX_VALUE;
                source.timeout().deadlineNanoTime(Math.min(l, timeUnit.toNanos(n)) + l2);
                try {
                    timeUnit = new Buffer();
                    while (source.read((Buffer)timeUnit, 8192L) != -1L) {
                        timeUnit.clear();
                    }
                    bl = true;
                    boolean bl2 = true;
                    if (l != Long.MAX_VALUE) break block6;
                    bl = bl2;
                }
                catch (Throwable throwable) {
                    if (l == Long.MAX_VALUE) {
                        source.timeout().clearDeadline();
                    } else {
                        source.timeout().deadlineNanoTime(l2 + l);
                    }
                    throw throwable;
                }
                catch (InterruptedIOException interruptedIOException) {
                    bl = false;
                    boolean bl3 = false;
                    if (l != Long.MAX_VALUE) break block6;
                    bl = bl3;
                }
                source.timeout().clearDeadline();
                break block7;
            }
            source.timeout().deadlineNanoTime(l2 + l);
        }
        return bl;
    }

    public static final ThreadFactory threadFactory(String string, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        return new _$.Lambda.Util.HCtG_IMz5G4h_r4fydmtsti2nbM(string, bl);
    }

    private static final Thread threadFactory$lambda_1(String object, boolean bl, Runnable runnable) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$name");
        object = new Thread(runnable, (String)object);
        ((Thread)object).setDaemon(bl);
        return object;
    }

    public static final void threadName(String string, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter(function0, (String)"block");
        Thread thread = Thread.currentThread();
        String string2 = thread.getName();
        thread.setName(string);
        try {
            function0.invoke();
            return;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            thread.setName(string2);
            InlineMarker.finallyEnd((int)1);
        }
    }

    public static final List<Header> toHeaderList(Headers headers) {
        Intrinsics.checkNotNullParameter((Object)headers, (String)"<this>");
        Object object = (Iterable)RangesKt.until((int)0, (int)headers.size());
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object, (int)10));
        object = object.iterator();
        while (object.hasNext()) {
            int n = ((IntIterator)object).nextInt();
            collection.add(new Header(headers.name(n), headers.value(n)));
        }
        return (List)collection;
    }

    public static final Headers toHeaders(List<Header> byteString) {
        Intrinsics.checkNotNullParameter(byteString, (String)"<this>");
        Headers.Builder builder = new Headers.Builder();
        Iterator<Header> iterator = byteString.iterator();
        while (iterator.hasNext()) {
            Header header = iterator.next();
            byteString = header.component1();
            header = header.component2();
            builder.addLenient$okhttp(byteString.utf8(), header.utf8());
        }
        return builder.build();
    }

    public static final String toHexString(int n) {
        String string = Integer.toHexString(n);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toHexString(this)");
        return string;
    }

    public static final String toHexString(long l) {
        String string = Long.toHexString(l);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toHexString(this)");
        return string;
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean bl) {
        CharSequence charSequence;
        CharSequence charSequence2;
        Intrinsics.checkNotNullParameter((Object)httpUrl, (String)"<this>");
        if (StringsKt.contains$default((CharSequence)httpUrl.host(), (CharSequence)":", (boolean)false, (int)2, null)) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append('[');
            ((StringBuilder)charSequence2).append(httpUrl.host());
            ((StringBuilder)charSequence2).append(']');
            charSequence2 = ((StringBuilder)charSequence2).toString();
        } else {
            charSequence2 = httpUrl.host();
        }
        if (!bl) {
            charSequence = charSequence2;
            if (httpUrl.port() == HttpUrl.Companion.defaultPort(httpUrl.scheme())) return charSequence;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append(':');
        ((StringBuilder)charSequence).append(httpUrl.port());
        charSequence = ((StringBuilder)charSequence).toString();
        return charSequence;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean bl, int n, Object object) {
        if ((n & 1) == 0) return Util.toHostHeader(httpUrl, bl);
        bl = false;
        return Util.toHostHeader(httpUrl, bl);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<this>");
        list = Collections.unmodifiableList(CollectionsKt.toMutableList((Collection)list));
        Intrinsics.checkNotNullExpressionValue(list, (String)"unmodifiableList(toMutableList())");
        return list;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, (String)"<this>");
        if (map.isEmpty()) {
            map = MapsKt.emptyMap();
        } else {
            map = Collections.unmodifiableMap(new LinkedHashMap(map));
            Intrinsics.checkNotNullExpressionValue(map, (String)"{\n    Collections.unmodi\u2026(LinkedHashMap(this))\n  }");
        }
        return map;
    }

    /*
     * Enabled force condition propagation
     */
    public static final long toLongOrDefault(String string, long l) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        try {
            long l2 = Long.parseLong(string);
            return l2;
        }
        catch (NumberFormatException numberFormatException) {
            return l;
        }
    }

    /*
     * Unable to fully structure code
     */
    public static final int toNonNegativeInt(String var0, int var1_2) {
        block3: {
            if (var0 != null) break block3;
            var0 = null;
            ** GOTO lbl7
        }
        try {
            var0 = Long.parseLong((String)var0);
lbl7:
            // 2 sources

            if (var0 == null) {
                return var1_2;
            }
            var2_3 = var0.longValue();
            var1_2 = var2_3 > 0x7FFFFFFFL ? 0x7FFFFFFF : (var2_3 < 0L ? 0 : (int)var2_3);
        }
        catch (NumberFormatException var0_1) {
            return var1_2;
        }
        return var1_2;
    }

    public static final String trimSubstring(String string, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        n = Util.indexOfFirstNonAsciiWhitespace(string, n, n2);
        string = string.substring(n, Util.indexOfLastNonAsciiWhitespace(string, n, n2));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string;
    }

    public static /* synthetic */ String trimSubstring$default(String string, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = 0;
        }
        if ((n3 & 2) == 0) return Util.trimSubstring(string, n, n2);
        n2 = string.length();
        return Util.trimSubstring(string, n, n2);
    }

    public static final void wait(Object object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        object.wait();
    }

    public static final Throwable withSuppressed(Exception exception, List<? extends Exception> object) {
        Intrinsics.checkNotNullParameter((Object)exception, (String)"<this>");
        Intrinsics.checkNotNullParameter(object, (String)"suppressed");
        object = object.iterator();
        while (object.hasNext()) {
            Exception exception2 = (Exception)object.next();
            ExceptionsKt.addSuppressed((Throwable)exception, (Throwable)exception2);
        }
        return exception;
    }

    public static final void writeMedium(BufferedSink bufferedSink, int n) throws IOException {
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"<this>");
        bufferedSink.writeByte(n >>> 16 & 0xFF);
        bufferedSink.writeByte(n >>> 8 & 0xFF);
        bufferedSink.writeByte(n & 0xFF);
    }
}
