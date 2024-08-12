/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.internal.PlatformImplementationsKt
 *  kotlin.io.CloseableKt
 *  kotlin.io.path.PathRelativizer
 *  kotlin.io.path.PathsKt
 *  kotlin.io.path.PathsKt__PathReadWriteKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.text.StringsKt
 */
package kotlin.io.path;

import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.CloseableKt;
import kotlin.io.path.PathRelativizer;
import kotlin.io.path.PathsKt;
import kotlin.io.path.PathsKt__PathReadWriteKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u00b2\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a*\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00012\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001a\"\u00020\u0001H\u0087\b\u00a2\u0006\u0002\u0010\u001b\u001a?\u0010\u001c\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007\u00a2\u0006\u0002\u0010!\u001a6\u0010\u001c\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b\u00a2\u0006\u0002\u0010\"\u001aK\u0010#\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007\u00a2\u0006\u0002\u0010%\u001aB\u0010#\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b\u00a2\u0006\u0002\u0010&\u001a\u001c\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u00022\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0001\u001a\r\u0010+\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010,\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a.\u0010-\u001a\u00020\u0002*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u0002000\u001a\"\u000200H\u0087\b\u00a2\u0006\u0002\u00101\u001a\u001f\u0010-\u001a\u00020\u0002*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u00102\u001a\u000203H\u0087\b\u001a.\u00104\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b\u00a2\u0006\u0002\u00105\u001a.\u00106\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b\u00a2\u0006\u0002\u00105\u001a.\u00107\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b\u00a2\u0006\u0002\u00105\u001a\u0015\u00108\u001a\u00020\u0002*\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0087\b\u001a6\u00109\u001a\u00020\u0002*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b\u00a2\u0006\u0002\u0010:\u001a\r\u0010;\u001a\u00020<*\u00020\u0002H\u0087\b\u001a\r\u0010=\u001a\u000203*\u00020\u0002H\u0087\b\u001a\u0015\u0010>\u001a\u00020\u0002*\u00020\u00022\u0006\u0010?\u001a\u00020\u0002H\u0087\n\u001a\u0015\u0010>\u001a\u00020\u0002*\u00020\u00022\u0006\u0010?\u001a\u00020\u0001H\u0087\n\u001a&\u0010@\u001a\u000203*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b\u00a2\u0006\u0002\u0010B\u001a2\u0010C\u001a\u0002HD\"\n\b\u0000\u0010D\u0018\u0001*\u00020E*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b\u00a2\u0006\u0002\u0010F\u001a4\u0010G\u001a\u0004\u0018\u0001HD\"\n\b\u0000\u0010D\u0018\u0001*\u00020E*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b\u00a2\u0006\u0002\u0010F\u001a\r\u0010H\u001a\u00020I*\u00020\u0002H\u0087\b\u001a\r\u0010J\u001a\u00020K*\u00020\u0002H\u0087\b\u001a.\u0010L\u001a\u00020<*\u00020\u00022\b\b\u0002\u0010M\u001a\u00020\u00012\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020<0OH\u0087\b\u00f8\u0001\u0000\u001a0\u0010P\u001a\u0004\u0018\u00010Q*\u00020\u00022\u0006\u0010R\u001a\u00020\u00012\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b\u00a2\u0006\u0002\u0010S\u001a&\u0010T\u001a\u00020U*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b\u00a2\u0006\u0002\u0010V\u001a(\u0010W\u001a\u0004\u0018\u00010X*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b\u00a2\u0006\u0002\u0010Y\u001a,\u0010Z\u001a\b\u0012\u0004\u0012\u00020\\0[*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b\u00a2\u0006\u0002\u0010]\u001a&\u0010^\u001a\u000203*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b\u00a2\u0006\u0002\u0010B\u001a\r\u0010_\u001a\u000203*\u00020\u0002H\u0087\b\u001a\r\u0010`\u001a\u000203*\u00020\u0002H\u0087\b\u001a\r\u0010a\u001a\u000203*\u00020\u0002H\u0087\b\u001a&\u0010b\u001a\u000203*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b\u00a2\u0006\u0002\u0010B\u001a\u0015\u0010c\u001a\u000203*\u00020\u00022\u0006\u0010?\u001a\u00020\u0002H\u0087\b\u001a\r\u0010d\u001a\u000203*\u00020\u0002H\u0087\b\u001a\r\u0010e\u001a\u000203*\u00020\u0002H\u0087\b\u001a\u001c\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00020g*\u00020\u00022\b\b\u0002\u0010M\u001a\u00020\u0001H\u0007\u001a.\u0010h\u001a\u00020\u0002*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u0002000\u001a\"\u000200H\u0087\b\u00a2\u0006\u0002\u00101\u001a\u001f\u0010h\u001a\u00020\u0002*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u00102\u001a\u000203H\u0087\b\u001a&\u0010i\u001a\u000203*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b\u00a2\u0006\u0002\u0010B\u001a2\u0010j\u001a\u0002Hk\"\n\b\u0000\u0010k\u0018\u0001*\u00020l*\u00020\u00022\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b\u00a2\u0006\u0002\u0010m\u001a<\u0010j\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010Q0n*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00012\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b\u00a2\u0006\u0002\u0010o\u001a\r\u0010p\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0016\u0010r\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0014\u0010s\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a8\u0010t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010R\u001a\u00020\u00012\b\u0010u\u001a\u0004\u0018\u00010Q2\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00020A0\u001a\"\u00020AH\u0087\b\u00a2\u0006\u0002\u0010v\u001a\u0015\u0010w\u001a\u00020\u0002*\u00020\u00022\u0006\u0010u\u001a\u00020UH\u0087\b\u001a\u0015\u0010x\u001a\u00020\u0002*\u00020\u00022\u0006\u0010u\u001a\u00020XH\u0087\b\u001a\u001b\u0010y\u001a\u00020\u0002*\u00020\u00022\f\u0010u\u001a\b\u0012\u0004\u0012\u00020\\0[H\u0087\b\u001a\r\u0010z\u001a\u00020\u0002*\u00020{H\u0087\b\u001a@\u0010|\u001a\u0002H}\"\u0004\b\u0000\u0010}*\u00020\u00022\b\b\u0002\u0010M\u001a\u00020\u00012\u0018\u0010~\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u007f\u0012\u0004\u0012\u0002H}0OH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u0080\u0001\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00028\u00c6\u0002X\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0081\u0001"}, d2={"extension", "", "Ljava/nio/file/Path;", "getExtension$annotations", "(Ljava/nio/file/Path;)V", "getExtension", "(Ljava/nio/file/Path;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "getInvariantSeparatorsPath", "invariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "getInvariantSeparatorsPathString", "name", "getName$annotations", "getName", "nameWithoutExtension", "getNameWithoutExtension$annotations", "getNameWithoutExtension", "pathString", "getPathString$annotations", "getPathString", "Path", "path", "base", "subpaths", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "createTempDirectory", "directory", "prefix", "attributes", "Ljava/nio/file/attribute/FileAttribute;", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempFile", "suffix", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "fileAttributeViewNotAvailable", "", "attributeViewClass", "Ljava/lang/Class;", "absolute", "absolutePathString", "copyTo", "target", "options", "Ljava/nio/file/CopyOption;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "overwrite", "", "createDirectories", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectory", "createFile", "createLinkPointingTo", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "deleteExisting", "", "deleteIfExists", "div", "other", "exists", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "fileAttributesView", "V", "Ljava/nio/file/attribute/FileAttributeView;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesViewOrNull", "fileSize", "", "fileStore", "Ljava/nio/file/FileStore;", "forEachDirectoryEntry", "glob", "action", "Lkotlin/Function1;", "getAttribute", "", "attribute", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "getLastModifiedTime", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "getOwner", "Ljava/nio/file/attribute/UserPrincipal;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "getPosixFilePermissions", "", "Ljava/nio/file/attribute/PosixFilePermission;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "isDirectory", "isExecutable", "isHidden", "isReadable", "isRegularFile", "isSameFileAs", "isSymbolicLink", "isWritable", "listDirectoryEntries", "", "moveTo", "notExists", "readAttributes", "A", "Ljava/nio/file/attribute/BasicFileAttributes;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "readSymbolicLink", "relativeTo", "relativeToOrNull", "relativeToOrSelf", "setAttribute", "value", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "setLastModifiedTime", "setOwner", "setPosixFilePermissions", "toPath", "Ljava/net/URI;", "useDirectoryEntries", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib-jdk7"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/io/path/PathsKt")
class PathsKt__PathUtilsKt
extends PathsKt__PathReadWriteKt {
    private static final Path Path(String object) {
        object = Paths.get((String)object, new String[0]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Paths.get(path)");
        return object;
    }

    private static final Path Path(String object, String ... stringArray) {
        object = Paths.get((String)object, Arrays.copyOf(stringArray, stringArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Paths.get(base, *subpaths)");
        return object;
    }

    private static final Path absolute(Path path) {
        path = path.toAbsolutePath();
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"toAbsolutePath()");
        return path;
    }

    private static final String absolutePathString(Path path) {
        return ((Object)path.toAbsolutePath()).toString();
    }

    private static final Path copyTo(Path path, Path path2, boolean bl) throws IOException {
        CopyOption[] copyOptionArray = bl ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[]{};
        path = Files.copy(path, path2, Arrays.copyOf(copyOptionArray, copyOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.copy(this, target, *options)");
        return path;
    }

    private static final Path copyTo(Path path, Path path2, CopyOption ... copyOptionArray) throws IOException {
        path = Files.copy(path, path2, Arrays.copyOf(copyOptionArray, copyOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.copy(this, target, *options)");
        return path;
    }

    static /* synthetic */ Path copyTo$default(Path path, Path path2, boolean bl, int n, Object copyOptionArray) throws IOException {
        if ((n & 2) != 0) {
            bl = false;
        }
        copyOptionArray = bl ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[]{};
        path = Files.copy(path, path2, Arrays.copyOf(copyOptionArray, copyOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.copy(this, target, *options)");
        return path;
    }

    private static final Path createDirectories(Path path, FileAttribute<?> ... fileAttributeArray) throws IOException {
        path = Files.createDirectories(path, Arrays.copyOf(fileAttributeArray, fileAttributeArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.createDirectories(this, *attributes)");
        return path;
    }

    private static final Path createDirectory(Path path, FileAttribute<?> ... fileAttributeArray) throws IOException {
        path = Files.createDirectory(path, Arrays.copyOf(fileAttributeArray, fileAttributeArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.createDirectory(this, *attributes)");
        return path;
    }

    private static final Path createFile(Path path, FileAttribute<?> ... fileAttributeArray) throws IOException {
        path = Files.createFile(path, Arrays.copyOf(fileAttributeArray, fileAttributeArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.createFile(this, *attributes)");
        return path;
    }

    private static final Path createLinkPointingTo(Path path, Path path2) throws IOException {
        path = Files.createLink(path, path2);
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.createLink(this, target)");
        return path;
    }

    private static final Path createSymbolicLinkPointingTo(Path path, Path path2, FileAttribute<?> ... fileAttributeArray) throws IOException {
        path = Files.createSymbolicLink(path, path2, Arrays.copyOf(fileAttributeArray, fileAttributeArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.createSymbolicLink\u2026his, target, *attributes)");
        return path;
    }

    private static final Path createTempDirectory(String object, FileAttribute<?> ... fileAttributeArray) throws IOException {
        object = Files.createTempDirectory((String)object, Arrays.copyOf(fileAttributeArray, fileAttributeArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Files.createTempDirectory(prefix, *attributes)");
        return object;
    }

    public static final Path createTempDirectory(Path path, String string, FileAttribute<?> ... fileAttributeArray) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArray, (String)"attributes");
        if (path != null) {
            path = Files.createTempDirectory(path, string, Arrays.copyOf(fileAttributeArray, fileAttributeArray.length));
            Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.createTempDirector\u2026ory, prefix, *attributes)");
        } else {
            path = Files.createTempDirectory(string, Arrays.copyOf(fileAttributeArray, fileAttributeArray.length));
            Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.createTempDirectory(prefix, *attributes)");
        }
        return path;
    }

    static /* synthetic */ Path createTempDirectory$default(String object, FileAttribute[] fileAttributeArray, int n, Object object2) throws IOException {
        if ((n & 1) != 0) {
            object = null;
        }
        object = Files.createTempDirectory((String)object, Arrays.copyOf(fileAttributeArray, fileAttributeArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Files.createTempDirectory(prefix, *attributes)");
        return object;
    }

    public static /* synthetic */ Path createTempDirectory$default(Path path, String string, FileAttribute[] fileAttributeArray, int n, Object object) throws IOException {
        if ((n & 2) == 0) return PathsKt.createTempDirectory((Path)path, (String)string, (FileAttribute[])fileAttributeArray);
        string = null;
        return PathsKt.createTempDirectory((Path)path, (String)string, (FileAttribute[])fileAttributeArray);
    }

    private static final Path createTempFile(String object, String string, FileAttribute<?> ... fileAttributeArray) throws IOException {
        object = Files.createTempFile((String)object, string, Arrays.copyOf(fileAttributeArray, fileAttributeArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Files.createTempFile(prefix, suffix, *attributes)");
        return object;
    }

    public static final Path createTempFile(Path path, String string, String string2, FileAttribute<?> ... fileAttributeArray) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArray, (String)"attributes");
        if (path != null) {
            path = Files.createTempFile(path, string, string2, Arrays.copyOf(fileAttributeArray, fileAttributeArray.length));
            Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.createTempFile(dir\u2026fix, suffix, *attributes)");
        } else {
            path = Files.createTempFile(string, string2, Arrays.copyOf(fileAttributeArray, fileAttributeArray.length));
            Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.createTempFile(prefix, suffix, *attributes)");
        }
        return path;
    }

    static /* synthetic */ Path createTempFile$default(String object, String string, FileAttribute[] fileAttributeArray, int n, Object object2) throws IOException {
        if ((n & 1) != 0) {
            object = null;
        }
        if ((n & 2) != 0) {
            string = null;
        }
        object = Files.createTempFile((String)object, string, Arrays.copyOf(fileAttributeArray, fileAttributeArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Files.createTempFile(prefix, suffix, *attributes)");
        return object;
    }

    public static /* synthetic */ Path createTempFile$default(Path path, String string, String string2, FileAttribute[] fileAttributeArray, int n, Object object) throws IOException {
        if ((n & 2) != 0) {
            string = null;
        }
        if ((n & 4) == 0) return PathsKt.createTempFile((Path)path, (String)string, (String)string2, (FileAttribute[])fileAttributeArray);
        string2 = null;
        return PathsKt.createTempFile((Path)path, (String)string, (String)string2, (FileAttribute[])fileAttributeArray);
    }

    private static final void deleteExisting(Path path) throws IOException {
        Files.delete(path);
    }

    private static final boolean deleteIfExists(Path path) throws IOException {
        return Files.deleteIfExists(path);
    }

    private static final Path div(Path path, String string) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"$this$div");
        path = path.resolve(string);
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"this.resolve(other)");
        return path;
    }

    private static final Path div(Path path, Path path2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"$this$div");
        path = path.resolve(path2);
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"this.resolve(other)");
        return path;
    }

    private static final boolean exists(Path path, LinkOption ... linkOptionArray) {
        return Files.exists(path, Arrays.copyOf(linkOptionArray, linkOptionArray.length));
    }

    public static final Void fileAttributeViewNotAvailable(Path path, Class<?> clazz) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter(clazz, (String)"attributeViewClass");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The desired attribute view type ");
        stringBuilder.append(clazz);
        stringBuilder.append(" is not available for the file ");
        stringBuilder.append(path);
        stringBuilder.append('.');
        throw (Throwable)new UnsupportedOperationException(stringBuilder.toString());
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesView(Path path, LinkOption ... object) {
        Intrinsics.reifiedOperationMarker((int)4, (String)"V");
        object = Files.getFileAttributeView(path, FileAttributeView.class, Arrays.copyOf(object, ((LinkOption[])object).length));
        if (object != null) {
            return (V)object;
        }
        Intrinsics.reifiedOperationMarker((int)4, (String)"V");
        PathsKt.fileAttributeViewNotAvailable((Path)path, FileAttributeView.class);
        throw new KotlinNothingValueException();
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesViewOrNull(Path path, LinkOption ... linkOptionArray) {
        Intrinsics.reifiedOperationMarker((int)4, (String)"V");
        return (V)Files.getFileAttributeView(path, FileAttributeView.class, Arrays.copyOf(linkOptionArray, linkOptionArray.length));
    }

    private static final long fileSize(Path path) throws IOException {
        return Files.size(path);
    }

    private static final FileStore fileStore(Path object) throws IOException {
        object = Files.getFileStore((Path)object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Files.getFileStore(this)");
        return object;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private static final void forEachDirectoryEntry(Path object, String object2, Function1<? super Path, Unit> unit) throws IOException {
        object = Files.newDirectoryStream((Path)object, (String)object2);
        object2 = null;
        try {
            Object object3 = (DirectoryStream)object;
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"it");
            object3 = ((Iterable)object3).iterator();
            while (object3.hasNext()) {
                unit.invoke(object3.next());
            }
            unit = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                block11: {
                    block10: {
                        InlineMarker.finallyStart((int)1);
                        if (PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) break block10;
                        if (object == null) break block11;
                        try {
                            object.close();
                        }
                        catch (Throwable throwable3) {}
                    }
                    CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                }
                InlineMarker.finallyEnd((int)1);
                throw throwable2;
            }
        }
        InlineMarker.finallyStart((int)1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        } else if (object != null) {
            object.close();
        }
        InlineMarker.finallyEnd((int)1);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    static /* synthetic */ void forEachDirectoryEntry$default(Path object, String object2, Function1 function1, int n, Object iterator) throws IOException {
        if ((n & 1) != 0) {
            object2 = "*";
        }
        object = Files.newDirectoryStream((Path)object, (String)object2);
        object2 = null;
        try {
            iterator = (DirectoryStream)object;
            Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)"it");
            iterator = ((Iterable)((Object)iterator)).iterator();
            while (iterator.hasNext()) {
                function1.invoke(iterator.next());
            }
            function1 = Unit.INSTANCE;
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                block12: {
                    block11: {
                        InlineMarker.finallyStart((int)1);
                        if (PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) break block11;
                        if (object == null) break block12;
                        try {
                            object.close();
                        }
                        catch (Throwable throwable3) {}
                    }
                    CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                }
                InlineMarker.finallyEnd((int)1);
                throw throwable2;
            }
        }
        InlineMarker.finallyStart((int)1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        } else if (object != null) {
            object.close();
        }
        InlineMarker.finallyEnd((int)1);
    }

    private static final Object getAttribute(Path path, String string, LinkOption ... linkOptionArray) throws IOException {
        return Files.getAttribute(path, string, Arrays.copyOf(linkOptionArray, linkOptionArray.length));
    }

    public static final String getExtension(Path object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$extension");
        Object object2 = object.getFileName();
        String string = "";
        object = string;
        if (object2 == null) return object;
        object2 = object2.toString();
        object = string;
        if (object2 == null) return object;
        object2 = StringsKt.substringAfterLast((String)object2, (char)'.', (String)"");
        object = string;
        if (object2 == null) return object;
        object = object2;
        return object;
    }

    public static /* synthetic */ void getExtension$annotations(Path path) {
    }

    private static final String getInvariantSeparatorsPath(Path path) {
        return PathsKt.getInvariantSeparatorsPathString((Path)path);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use invariantSeparatorsPathString property instead.", replaceWith=@ReplaceWith(expression="invariantSeparatorsPathString", imports={}))
    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(Path path) {
    }

    public static final String getInvariantSeparatorsPathString(Path object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$invariantSeparatorsPathString");
        Object object2 = object.getFileSystem();
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"fileSystem");
        object2 = ((FileSystem)object2).getSeparator();
        if (Intrinsics.areEqual((Object)object2, (Object)"/") ^ true) {
            object = object.toString();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"separator");
            object = StringsKt.replace$default((String)object, (String)object2, (String)"/", (boolean)false, (int)4, null);
        } else {
            object = object.toString();
        }
        return object;
    }

    public static /* synthetic */ void getInvariantSeparatorsPathString$annotations(Path path) {
    }

    private static final FileTime getLastModifiedTime(Path comparable, LinkOption ... linkOptionArray) throws IOException {
        comparable = Files.getLastModifiedTime(comparable, Arrays.copyOf(linkOptionArray, linkOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)comparable, (String)"Files.getLastModifiedTime(this, *options)");
        return comparable;
    }

    public static final String getName(Path object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$name");
        object = object.getFileName();
        object = object != null ? object.toString() : null;
        if (object != null) return object;
        object = "";
        return object;
    }

    public static /* synthetic */ void getName$annotations(Path path) {
    }

    public static final String getNameWithoutExtension(Path object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$nameWithoutExtension");
        object = object.getFileName();
        if (object != null && (object = object.toString()) != null && (object = StringsKt.substringBeforeLast$default((String)object, (String)".", null, (int)2, null)) != null) return object;
        object = "";
        return object;
    }

    public static /* synthetic */ void getNameWithoutExtension$annotations(Path path) {
    }

    private static final UserPrincipal getOwner(Path path, LinkOption ... linkOptionArray) throws IOException {
        return Files.getOwner(path, Arrays.copyOf(linkOptionArray, linkOptionArray.length));
    }

    private static final String getPathString(Path path) {
        return ((Object)path).toString();
    }

    public static /* synthetic */ void getPathString$annotations(Path path) {
    }

    private static final Set<PosixFilePermission> getPosixFilePermissions(Path iterable, LinkOption ... linkOptionArray) throws IOException {
        iterable = Files.getPosixFilePermissions(iterable, Arrays.copyOf(linkOptionArray, linkOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)"Files.getPosixFilePermissions(this, *options)");
        return iterable;
    }

    private static final boolean isDirectory(Path path, LinkOption ... linkOptionArray) {
        return Files.isDirectory(path, Arrays.copyOf(linkOptionArray, linkOptionArray.length));
    }

    private static final boolean isExecutable(Path path) {
        return Files.isExecutable(path);
    }

    private static final boolean isHidden(Path path) throws IOException {
        return Files.isHidden(path);
    }

    private static final boolean isReadable(Path path) {
        return Files.isReadable(path);
    }

    private static final boolean isRegularFile(Path path, LinkOption ... linkOptionArray) {
        return Files.isRegularFile(path, Arrays.copyOf(linkOptionArray, linkOptionArray.length));
    }

    private static final boolean isSameFileAs(Path path, Path path2) throws IOException {
        return Files.isSameFile(path, path2);
    }

    private static final boolean isSymbolicLink(Path path) {
        return Files.isSymbolicLink(path);
    }

    private static final boolean isWritable(Path path) {
        return Files.isWritable(path);
    }

    public static final List<Path> listDirectoryEntries(Path object, String object2) throws IOException {
        Iterable iterable;
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$listDirectoryEntries");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"glob");
        object = Files.newDirectoryStream((Path)object, (String)object2);
        object2 = null;
        try {
            iterable = (DirectoryStream)object;
            Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)"it");
            iterable = CollectionsKt.toList((Iterable)iterable);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                throw throwable2;
            }
        }
        CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        return iterable;
    }

    public static /* synthetic */ List listDirectoryEntries$default(Path path, String string, int n, Object object) throws IOException {
        if ((n & 1) == 0) return PathsKt.listDirectoryEntries((Path)path, (String)string);
        string = "*";
        return PathsKt.listDirectoryEntries((Path)path, (String)string);
    }

    private static final Path moveTo(Path path, Path path2, boolean bl) throws IOException {
        CopyOption[] copyOptionArray = bl ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[]{};
        path = Files.move(path, path2, Arrays.copyOf(copyOptionArray, copyOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.move(this, target, *options)");
        return path;
    }

    private static final Path moveTo(Path path, Path path2, CopyOption ... copyOptionArray) throws IOException {
        path = Files.move(path, path2, Arrays.copyOf(copyOptionArray, copyOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.move(this, target, *options)");
        return path;
    }

    static /* synthetic */ Path moveTo$default(Path path, Path path2, boolean bl, int n, Object copyOptionArray) throws IOException {
        if ((n & 2) != 0) {
            bl = false;
        }
        copyOptionArray = bl ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[]{};
        path = Files.move(path, path2, Arrays.copyOf(copyOptionArray, copyOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.move(this, target, *options)");
        return path;
    }

    private static final boolean notExists(Path path, LinkOption ... linkOptionArray) {
        return Files.notExists(path, Arrays.copyOf(linkOptionArray, linkOptionArray.length));
    }

    private static final /* synthetic */ <A extends BasicFileAttributes> A readAttributes(Path object, LinkOption ... linkOptionArray) throws IOException {
        Intrinsics.reifiedOperationMarker((int)4, (String)"A");
        object = Files.readAttributes((Path)object, BasicFileAttributes.class, Arrays.copyOf(linkOptionArray, linkOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Files.readAttributes(thi\u2026 A::class.java, *options)");
        return (A)object;
    }

    private static final Map<String, Object> readAttributes(Path object, String string, LinkOption ... linkOptionArray) throws IOException {
        object = Files.readAttributes((Path)object, string, Arrays.copyOf(linkOptionArray, linkOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Files.readAttributes(this, attributes, *options)");
        return object;
    }

    private static final Path readSymbolicLink(Path path) throws IOException {
        path = Files.readSymbolicLink(path);
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.readSymbolicLink(this)");
        return path;
    }

    public static final Path relativeTo(Path path, Path path2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"$this$relativeTo");
        Intrinsics.checkNotNullParameter((Object)path2, (String)"base");
        try {
            Path path3 = PathRelativizer.INSTANCE.tryRelativeTo(path, path2);
            return path3;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            String string = illegalArgumentException.getMessage();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\nthis path: ");
            stringBuilder.append(path);
            stringBuilder.append("\nbase path: ");
            stringBuilder.append(path2);
            throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)string, (Object)stringBuilder.toString()), illegalArgumentException);
        }
    }

    public static final Path relativeToOrNull(Path path, Path path2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"$this$relativeToOrNull");
        Intrinsics.checkNotNullParameter((Object)path2, (String)"base");
        try {
            path = PathRelativizer.INSTANCE.tryRelativeTo(path, path2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            path = null;
        }
        return path;
    }

    public static final Path relativeToOrSelf(Path path, Path path2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"$this$relativeToOrSelf");
        Intrinsics.checkNotNullParameter((Object)path2, (String)"base");
        path2 = PathsKt.relativeToOrNull((Path)path, (Path)path2);
        if (path2 == null) return path;
        path = path2;
        return path;
    }

    private static final Path setAttribute(Path path, String string, Object object, LinkOption ... linkOptionArray) throws IOException {
        path = Files.setAttribute(path, string, object, Arrays.copyOf(linkOptionArray, linkOptionArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.setAttribute(this,\u2026tribute, value, *options)");
        return path;
    }

    private static final Path setLastModifiedTime(Path path, FileTime fileTime) throws IOException {
        path = Files.setLastModifiedTime(path, fileTime);
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.setLastModifiedTime(this, value)");
        return path;
    }

    private static final Path setOwner(Path path, UserPrincipal userPrincipal) throws IOException {
        path = Files.setOwner(path, userPrincipal);
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.setOwner(this, value)");
        return path;
    }

    private static final Path setPosixFilePermissions(Path path, Set<? extends PosixFilePermission> set) throws IOException {
        path = Files.setPosixFilePermissions(path, set);
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"Files.setPosixFilePermissions(this, value)");
        return path;
    }

    private static final Path toPath(URI comparable) {
        comparable = Paths.get(comparable);
        Intrinsics.checkNotNullExpressionValue((Object)comparable, (String)"Paths.get(this)");
        return comparable;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private static final <T> T useDirectoryEntries(Path object, String object2, Function1<? super Sequence<? extends Path>, ? extends T> object3) throws IOException {
        Object object4;
        object = Files.newDirectoryStream((Path)object, (String)object2);
        object2 = null;
        try {
            DirectoryStream directoryStream = (DirectoryStream)object;
            Intrinsics.checkNotNullExpressionValue((Object)directoryStream, (String)"it");
            object4 = object3.invoke((Object)CollectionsKt.asSequence((Iterable)directoryStream));
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                block10: {
                    block9: {
                        InlineMarker.finallyStart((int)1);
                        if (PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) break block9;
                        if (object == null) break block10;
                        try {
                            object.close();
                        }
                        catch (Throwable throwable3) {}
                    }
                    CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                }
                InlineMarker.finallyEnd((int)1);
                throw throwable2;
            }
        }
        InlineMarker.finallyStart((int)1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        } else if (object != null) {
            object.close();
        }
        InlineMarker.finallyEnd((int)1);
        return (T)object4;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    static /* synthetic */ Object useDirectoryEntries$default(Path object, String object2, Function1 object3, int n, Object object4) throws IOException {
        Object object5;
        void var3_7;
        if ((var3_7 & 1) != 0) {
            object2 = "*";
        }
        object = Files.newDirectoryStream((Path)object, (String)object2);
        object2 = null;
        try {
            DirectoryStream directoryStream = (DirectoryStream)object;
            Intrinsics.checkNotNullExpressionValue((Object)directoryStream, (String)"it");
            object5 = object3.invoke((Object)CollectionsKt.asSequence((Iterable)directoryStream));
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                block11: {
                    block10: {
                        InlineMarker.finallyStart((int)1);
                        if (PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) break block10;
                        if (object == null) break block11;
                        try {
                            object.close();
                        }
                        catch (Throwable throwable3) {}
                    }
                    CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                }
                InlineMarker.finallyEnd((int)1);
                throw throwable2;
            }
        }
        InlineMarker.finallyStart((int)1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)1, (int)0)) {
            CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
        } else if (object != null) {
            object.close();
        }
        InlineMarker.finallyEnd((int)1);
        return object5;
    }
}
