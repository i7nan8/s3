package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okhttp3.w;
import okhttp3.z;
import retrofit2.b.b;
import retrofit2.b.c;
import retrofit2.b.d;
import retrofit2.b.e;
import retrofit2.b.f;
import retrofit2.b.g;
import retrofit2.b.h;
import retrofit2.b.i;
import retrofit2.b.j;
import retrofit2.b.k;
import retrofit2.b.l;
import retrofit2.b.m;
import retrofit2.b.n;
import retrofit2.b.o;
import retrofit2.b.q;
import retrofit2.b.r;
import retrofit2.b.u;
import retrofit2.b.x;
import retrofit2.m;

/* access modifiers changed from: package-private */
public final class p {
    final String a;
    private final Method b;
    private final t c;
    @Nullable
    private final String d;
    @Nullable
    private final s e;
    @Nullable
    private final v f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final m<?>[] j;

    static p a(r rVar, Method method) {
        return new a(rVar, method).a();
    }

    p(a aVar) {
        this.b = aVar.b;
        this.c = aVar.a.b;
        this.a = aVar.n;
        this.d = aVar.r;
        this.e = aVar.s;
        this.f = aVar.t;
        this.g = aVar.o;
        this.h = aVar.p;
        this.i = aVar.q;
        this.j = aVar.v;
    }

    /* access modifiers changed from: package-private */
    public z a(Object[] objArr) throws IOException {
        m<?>[] mVarArr = this.j;
        int length = objArr.length;
        if (length == mVarArr.length) {
            o oVar = new o(this.a, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
            ArrayList arrayList = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(objArr[i2]);
                mVarArr[i2].a(oVar, objArr[i2]);
            }
            return oVar.a().a(j.class, new j(this.b, arrayList)).b();
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + mVarArr.length + ")");
    }

    static final class a {
        private static final Pattern w = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        private static final Pattern x = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
        final r a;
        final Method b;
        final Annotation[] c;
        final Annotation[][] d;
        final Type[] e;
        boolean f;
        boolean g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        @Nullable
        String n;
        boolean o;
        boolean p;
        boolean q;
        @Nullable
        String r;
        @Nullable
        s s;
        @Nullable
        v t;
        @Nullable
        Set<String> u;
        @Nullable
        m<?>[] v;

        a(r rVar, Method method) {
            this.a = rVar;
            this.b = method;
            this.c = method.getAnnotations();
            this.e = method.getGenericParameterTypes();
            this.d = method.getParameterAnnotations();
        }

        /* access modifiers changed from: package-private */
        public p a() {
            for (Annotation annotation : this.c) {
                a(annotation);
            }
            if (this.n != null) {
                if (!this.o) {
                    if (this.q) {
                        throw t.a(this.b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    } else if (this.p) {
                        throw t.a(this.b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.d.length;
                this.v = new m[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.v[i2] = a(i2, this.e[i2], this.d[i2]);
                }
                if (this.r == null && !this.m) {
                    throw t.a(this.b, "Missing either @%s URL or @Url parameter.", this.n);
                } else if (!this.p && !this.q && !this.o && this.h) {
                    throw t.a(this.b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                } else if (this.p && !this.f) {
                    throw t.a(this.b, "Form-encoded method must contain at least one @Field.", new Object[0]);
                } else if (!this.q || this.g) {
                    return new p(this);
                } else {
                    throw t.a(this.b, "Multipart method must contain at least one @Part.", new Object[0]);
                }
            } else {
                throw t.a(this.b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
        }

        private void a(Annotation annotation) {
            if (annotation instanceof b) {
                a("DELETE", ((b) annotation).a(), false);
            } else if (annotation instanceof f) {
                a("GET", ((f) annotation).a(), false);
            } else if (annotation instanceof g) {
                a("HEAD", ((g) annotation).a(), false);
            } else if (annotation instanceof n) {
                a("PATCH", ((n) annotation).a(), true);
            } else if (annotation instanceof o) {
                a("POST", ((o) annotation).a(), true);
            } else if (annotation instanceof retrofit2.b.p) {
                a("PUT", ((retrofit2.b.p) annotation).a(), true);
            } else if (annotation instanceof m) {
                a("OPTIONS", ((m) annotation).a(), false);
            } else if (annotation instanceof h) {
                h hVar = (h) annotation;
                a(hVar.a(), hVar.b(), hVar.c());
            } else if (annotation instanceof k) {
                String[] a2 = ((k) annotation).a();
                if (a2.length != 0) {
                    this.s = a(a2);
                    return;
                }
                throw t.a(this.b, "@Headers annotation is empty.", new Object[0]);
            } else if (annotation instanceof l) {
                if (!this.p) {
                    this.q = true;
                    return;
                }
                throw t.a(this.b, "Only one encoding annotation is allowed.", new Object[0]);
            } else if (!(annotation instanceof e)) {
            } else {
                if (!this.q) {
                    this.p = true;
                    return;
                }
                throw t.a(this.b, "Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        private void a(String str, String str2, boolean z) {
            String str3 = this.n;
            if (str3 == null) {
                this.n = str;
                this.o = z;
                if (!str2.isEmpty()) {
                    int indexOf = str2.indexOf(63);
                    if (indexOf != -1 && indexOf < str2.length() - 1) {
                        String substring = str2.substring(indexOf + 1);
                        if (w.matcher(substring).find()) {
                            throw t.a(this.b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                        }
                    }
                    this.r = str2;
                    this.u = a(str2);
                    return;
                }
                return;
            }
            throw t.a(this.b, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        private s a(String[] strArr) {
            s.a aVar = new s.a();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw t.a(this.b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    try {
                        this.t = v.a(trim);
                    } catch (IllegalArgumentException e2) {
                        throw t.a(this.b, e2, "Malformed content type: %s", trim);
                    }
                } else {
                    aVar.a(substring, trim);
                }
            }
            return aVar.a();
        }

        private m<?> a(int i2, Type type, @Nullable Annotation[] annotationArr) {
            m<?> mVar = null;
            if (annotationArr != null) {
                m<?> mVar2 = null;
                for (Annotation annotation : annotationArr) {
                    m<?> a2 = a(i2, type, annotationArr, annotation);
                    if (a2 != null) {
                        if (mVar2 == null) {
                            mVar2 = a2;
                        } else {
                            throw t.a(this.b, i2, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                    }
                }
                mVar = mVar2;
            }
            if (mVar != null) {
                return mVar;
            }
            throw t.a(this.b, i2, "No Retrofit annotation found.", new Object[0]);
        }

        @Nullable
        private m<?> a(int i2, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof x) {
                a(i2, type);
                if (this.m) {
                    throw t.a(this.b, i2, "Multiple @Url method annotations found.", new Object[0]);
                } else if (this.i) {
                    throw t.a(this.b, i2, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.j) {
                    throw t.a(this.b, i2, "A @Url parameter must not come after a @Query.", new Object[0]);
                } else if (this.k) {
                    throw t.a(this.b, i2, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                } else if (this.l) {
                    throw t.a(this.b, i2, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                } else if (this.r == null) {
                    this.m = true;
                    if (type == t.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                        return new m.C0082m();
                    }
                    throw t.a(this.b, i2, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                } else {
                    throw t.a(this.b, i2, "@Url cannot be used with @%s URL", this.n);
                }
            } else if (annotation instanceof retrofit2.b.s) {
                a(i2, type);
                if (this.j) {
                    throw t.a(this.b, i2, "A @Path parameter must not come after a @Query.", new Object[0]);
                } else if (this.k) {
                    throw t.a(this.b, i2, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                } else if (this.l) {
                    throw t.a(this.b, i2, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                } else if (this.m) {
                    throw t.a(this.b, i2, "@Path parameters may not be used with @Url.", new Object[0]);
                } else if (this.r != null) {
                    this.i = true;
                    retrofit2.b.s sVar = (retrofit2.b.s) annotation;
                    String a2 = sVar.a();
                    a(i2, a2);
                    return new m.h(a2, this.a.c(type, annotationArr), sVar.b());
                } else {
                    throw t.a(this.b, i2, "@Path can only be used with relative url on @%s", this.n);
                }
            } else if (annotation instanceof retrofit2.b.t) {
                a(i2, type);
                retrofit2.b.t tVar = (retrofit2.b.t) annotation;
                String a3 = tVar.a();
                boolean b2 = tVar.b();
                Class<?> a4 = t.a(type);
                this.j = true;
                if (Iterable.class.isAssignableFrom(a4)) {
                    if (type instanceof ParameterizedType) {
                        return new m.i(a3, this.a.c(t.a(0, (ParameterizedType) type), annotationArr), b2).a();
                    }
                    Method method = this.b;
                    throw t.a(method, i2, a4.getSimpleName() + " must include generic type (e.g., " + a4.getSimpleName() + "<String>)", new Object[0]);
                } else if (!a4.isArray()) {
                    return new m.i(a3, this.a.c(type, annotationArr), b2);
                } else {
                    return new m.i(a3, this.a.c(a(a4.getComponentType()), annotationArr), b2).b();
                }
            } else if (annotation instanceof retrofit2.b.v) {
                a(i2, type);
                boolean a5 = ((retrofit2.b.v) annotation).a();
                Class<?> a6 = t.a(type);
                this.k = true;
                if (Iterable.class.isAssignableFrom(a6)) {
                    if (type instanceof ParameterizedType) {
                        return new m.k(this.a.c(t.a(0, (ParameterizedType) type), annotationArr), a5).a();
                    }
                    Method method2 = this.b;
                    throw t.a(method2, i2, a6.getSimpleName() + " must include generic type (e.g., " + a6.getSimpleName() + "<String>)", new Object[0]);
                } else if (!a6.isArray()) {
                    return new m.k(this.a.c(type, annotationArr), a5);
                } else {
                    return new m.k(this.a.c(a(a6.getComponentType()), annotationArr), a5).b();
                }
            } else if (annotation instanceof u) {
                a(i2, type);
                Class<?> a7 = t.a(type);
                this.l = true;
                if (Map.class.isAssignableFrom(a7)) {
                    Type b3 = t.b(type, a7, Map.class);
                    if (b3 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) b3;
                        Type a8 = t.a(0, parameterizedType);
                        if (String.class == a8) {
                            return new m.j(this.a.c(t.a(1, parameterizedType), annotationArr), ((u) annotation).a());
                        }
                        Method method3 = this.b;
                        throw t.a(method3, i2, "@QueryMap keys must be of type String: " + a8, new Object[0]);
                    }
                    throw t.a(this.b, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw t.a(this.b, i2, "@QueryMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof i) {
                a(i2, type);
                String a9 = ((i) annotation).a();
                Class<?> a10 = t.a(type);
                if (Iterable.class.isAssignableFrom(a10)) {
                    if (type instanceof ParameterizedType) {
                        return new m.d(a9, this.a.c(t.a(0, (ParameterizedType) type), annotationArr)).a();
                    }
                    Method method4 = this.b;
                    throw t.a(method4, i2, a10.getSimpleName() + " must include generic type (e.g., " + a10.getSimpleName() + "<String>)", new Object[0]);
                } else if (!a10.isArray()) {
                    return new m.d(a9, this.a.c(type, annotationArr));
                } else {
                    return new m.d(a9, this.a.c(a(a10.getComponentType()), annotationArr)).b();
                }
            } else if (annotation instanceof j) {
                a(i2, type);
                Class<?> a11 = t.a(type);
                if (Map.class.isAssignableFrom(a11)) {
                    Type b4 = t.b(type, a11, Map.class);
                    if (b4 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) b4;
                        Type a12 = t.a(0, parameterizedType2);
                        if (String.class == a12) {
                            return new m.e(this.a.c(t.a(1, parameterizedType2), annotationArr));
                        }
                        Method method5 = this.b;
                        throw t.a(method5, i2, "@HeaderMap keys must be of type String: " + a12, new Object[0]);
                    }
                    throw t.a(this.b, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw t.a(this.b, i2, "@HeaderMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof c) {
                a(i2, type);
                if (this.p) {
                    c cVar = (c) annotation;
                    String a13 = cVar.a();
                    boolean b5 = cVar.b();
                    this.f = true;
                    Class<?> a14 = t.a(type);
                    if (Iterable.class.isAssignableFrom(a14)) {
                        if (type instanceof ParameterizedType) {
                            return new m.b(a13, this.a.c(t.a(0, (ParameterizedType) type), annotationArr), b5).a();
                        }
                        Method method6 = this.b;
                        throw t.a(method6, i2, a14.getSimpleName() + " must include generic type (e.g., " + a14.getSimpleName() + "<String>)", new Object[0]);
                    } else if (!a14.isArray()) {
                        return new m.b(a13, this.a.c(type, annotationArr), b5);
                    } else {
                        return new m.b(a13, this.a.c(a(a14.getComponentType()), annotationArr), b5).b();
                    }
                } else {
                    throw t.a(this.b, i2, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
            } else if (annotation instanceof d) {
                a(i2, type);
                if (this.p) {
                    Class<?> a15 = t.a(type);
                    if (Map.class.isAssignableFrom(a15)) {
                        Type b6 = t.b(type, a15, Map.class);
                        if (b6 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) b6;
                            Type a16 = t.a(0, parameterizedType3);
                            if (String.class == a16) {
                                f c2 = this.a.c(t.a(1, parameterizedType3), annotationArr);
                                this.f = true;
                                return new m.c(c2, ((d) annotation).a());
                            }
                            Method method7 = this.b;
                            throw t.a(method7, i2, "@FieldMap keys must be of type String: " + a16, new Object[0]);
                        }
                        throw t.a(this.b, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw t.a(this.b, i2, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw t.a(this.b, i2, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof q) {
                a(i2, type);
                if (this.q) {
                    q qVar = (q) annotation;
                    this.g = true;
                    String a17 = qVar.a();
                    Class<?> a18 = t.a(type);
                    if (!a17.isEmpty()) {
                        s a19 = s.a("Content-Disposition", "form-data; name=\"" + a17 + "\"", "Content-Transfer-Encoding", qVar.b());
                        if (Iterable.class.isAssignableFrom(a18)) {
                            if (type instanceof ParameterizedType) {
                                Type a20 = t.a(0, (ParameterizedType) type);
                                if (!w.b.class.isAssignableFrom(t.a(a20))) {
                                    return new m.f(a19, this.a.a(a20, annotationArr, this.c)).a();
                                }
                                throw t.a(this.b, i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                            }
                            Method method8 = this.b;
                            throw t.a(method8, i2, a18.getSimpleName() + " must include generic type (e.g., " + a18.getSimpleName() + "<String>)", new Object[0]);
                        } else if (a18.isArray()) {
                            Class<?> a21 = a(a18.getComponentType());
                            if (!w.b.class.isAssignableFrom(a21)) {
                                return new m.f(a19, this.a.a(a21, annotationArr, this.c)).b();
                            }
                            throw t.a(this.b, i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        } else if (!w.b.class.isAssignableFrom(a18)) {
                            return new m.f(a19, this.a.a(type, annotationArr, this.c));
                        } else {
                            throw t.a(this.b, i2, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                    } else if (Iterable.class.isAssignableFrom(a18)) {
                        if (!(type instanceof ParameterizedType)) {
                            Method method9 = this.b;
                            throw t.a(method9, i2, a18.getSimpleName() + " must include generic type (e.g., " + a18.getSimpleName() + "<String>)", new Object[0]);
                        } else if (w.b.class.isAssignableFrom(t.a(t.a(0, (ParameterizedType) type)))) {
                            return m.l.a.a();
                        } else {
                            throw t.a(this.b, i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                    } else if (a18.isArray()) {
                        if (w.b.class.isAssignableFrom(a18.getComponentType())) {
                            return m.l.a.b();
                        }
                        throw t.a(this.b, i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    } else if (w.b.class.isAssignableFrom(a18)) {
                        return m.l.a;
                    } else {
                        throw t.a(this.b, i2, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                } else {
                    throw t.a(this.b, i2, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
            } else if (annotation instanceof r) {
                a(i2, type);
                if (this.q) {
                    this.g = true;
                    Class<?> a22 = t.a(type);
                    if (Map.class.isAssignableFrom(a22)) {
                        Type b7 = t.b(type, a22, Map.class);
                        if (b7 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType4 = (ParameterizedType) b7;
                            Type a23 = t.a(0, parameterizedType4);
                            if (String.class == a23) {
                                Type a24 = t.a(1, parameterizedType4);
                                if (!w.b.class.isAssignableFrom(t.a(a24))) {
                                    return new m.g(this.a.a(a24, annotationArr, this.c), ((r) annotation).a());
                                }
                                throw t.a(this.b, i2, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            Method method10 = this.b;
                            throw t.a(method10, i2, "@PartMap keys must be of type String: " + a23, new Object[0]);
                        }
                        throw t.a(this.b, i2, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw t.a(this.b, i2, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw t.a(this.b, i2, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            } else if (!(annotation instanceof retrofit2.b.a)) {
                return null;
            } else {
                a(i2, type);
                if (this.p || this.q) {
                    throw t.a(this.b, i2, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                } else if (!this.h) {
                    try {
                        f a25 = this.a.a(type, annotationArr, this.c);
                        this.h = true;
                        return new m.a(a25);
                    } catch (RuntimeException e2) {
                        throw t.a(this.b, e2, i2, "Unable to create @Body converter for %s", type);
                    }
                } else {
                    throw t.a(this.b, i2, "Multiple @Body method annotations found.", new Object[0]);
                }
            }
        }

        private void a(int i2, Type type) {
            if (t.d(type)) {
                throw t.a(this.b, i2, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        private void a(int i2, String str) {
            if (!x.matcher(str).matches()) {
                throw t.a(this.b, i2, "@Path parameter name must match %s. Found: %s", w.pattern(), str);
            } else if (!this.u.contains(str)) {
                throw t.a(this.b, i2, "URL \"%s\" does not contain \"{%s}\".", this.r, str);
            }
        }

        static Set<String> a(String str) {
            Matcher matcher = w.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private static Class<?> a(Class<?> cls) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            return Short.TYPE == cls ? Short.class : cls;
        }
    }
}
