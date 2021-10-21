package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.e;
import okhttp3.t;
import okhttp3.x;
import retrofit2.a;
import retrofit2.c;
import retrofit2.f;

public final class r {
    final e.a a;
    final t b;
    final List<f.a> c;
    final List<c.a> d;
    @Nullable
    final Executor e;
    final boolean f;
    private final Map<Method, s<?>> g = new ConcurrentHashMap();

    r(e.a aVar, t tVar, List<f.a> list, List<c.a> list2, @Nullable Executor executor, boolean z) {
        this.a = aVar;
        this.b = tVar;
        this.c = list;
        this.d = list2;
        this.e = executor;
        this.f = z;
    }

    public <T> T a(final Class<T> cls) {
        t.a((Class) cls);
        if (this.f) {
            b(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
            /* class retrofit2.r.AnonymousClass1 */
            private final n c = n.a();
            private final Object[] d = new Object[0];

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (this.c.a(method)) {
                    return this.c.a(method, cls, obj, objArr);
                }
                s<?> a2 = r.this.a(method);
                if (objArr == null) {
                    objArr = this.d;
                }
                return a2.a(objArr);
            }
        });
    }

    private void b(Class<?> cls) {
        n a2 = n.a();
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (!a2.a(method)) {
                a(method);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public s<?> a(Method method) {
        s<?> sVar;
        s<?> sVar2 = this.g.get(method);
        if (sVar2 != null) {
            return sVar2;
        }
        synchronized (this.g) {
            sVar = this.g.get(method);
            if (sVar == null) {
                sVar = s.a(this, method);
                this.g.put(method, sVar);
            }
        }
        return sVar;
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr) {
        return a((c.a) null, type, annotationArr);
    }

    public c<?, ?> a(@Nullable c.a aVar, Type type, Annotation[] annotationArr) {
        t.a(type, "returnType == null");
        t.a((Object) annotationArr, "annotations == null");
        int indexOf = this.d.indexOf(aVar) + 1;
        int size = this.d.size();
        for (int i = indexOf; i < size; i++) {
            c<?, ?> a2 = this.d.get(i).a(type, annotationArr, this);
            if (a2 != null) {
                return a2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.d.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> f<T, aa> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return a(null, type, annotationArr, annotationArr2);
    }

    public <T> f<T, aa> a(@Nullable f.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        t.a(type, "type == null");
        t.a((Object) annotationArr, "parameterAnnotations == null");
        t.a((Object) annotationArr2, "methodAnnotations == null");
        int indexOf = this.c.indexOf(aVar) + 1;
        int size = this.c.size();
        for (int i = indexOf; i < size; i++) {
            f<T, aa> fVar = (f<T, aa>) this.c.get(i).a(type, annotationArr, annotationArr2, this);
            if (fVar != null) {
                return fVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.c.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.c.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.c.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> f<ac, T> b(Type type, Annotation[] annotationArr) {
        return a((f.a) null, type, annotationArr);
    }

    public <T> f<ac, T> a(@Nullable f.a aVar, Type type, Annotation[] annotationArr) {
        t.a(type, "type == null");
        t.a((Object) annotationArr, "annotations == null");
        int indexOf = this.c.indexOf(aVar) + 1;
        int size = this.c.size();
        for (int i = indexOf; i < size; i++) {
            f<ac, T> fVar = (f<ac, T>) this.c.get(i).a(type, annotationArr, this);
            if (fVar != null) {
                return fVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.c.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.c.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.c.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> f<T, String> c(Type type, Annotation[] annotationArr) {
        t.a(type, "type == null");
        t.a((Object) annotationArr, "annotations == null");
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            f<T, String> fVar = (f<T, String>) this.c.get(i).b(type, annotationArr, this);
            if (fVar != null) {
                return fVar;
            }
        }
        return a.d.a;
    }

    public static final class a {
        private final n a;
        @Nullable
        private e.a b;
        @Nullable
        private t c;
        private final List<f.a> d;
        private final List<c.a> e;
        @Nullable
        private Executor f;
        private boolean g;

        a(n nVar) {
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.a = nVar;
        }

        public a() {
            this(n.a());
        }

        public a a(x xVar) {
            return a((e.a) t.a(xVar, "client == null"));
        }

        public a a(e.a aVar) {
            this.b = (e.a) t.a(aVar, "factory == null");
            return this;
        }

        public a a(String str) {
            t.a(str, "baseUrl == null");
            return a(t.g(str));
        }

        public a a(t tVar) {
            t.a(tVar, "baseUrl == null");
            List<String> k = tVar.k();
            if ("".equals(k.get(k.size() - 1))) {
                this.c = tVar;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + tVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.List<retrofit2.f$a> */
        /* JADX WARN: Multi-variable type inference failed */
        public a a(f.a aVar) {
            this.d.add(t.a(aVar, "factory == null"));
            return this;
        }

        public r a() {
            if (this.c != null) {
                e.a aVar = this.b;
                x xVar = aVar == null ? new x() : aVar;
                Executor executor = this.f;
                Executor b2 = executor == null ? this.a.b() : executor;
                ArrayList arrayList = new ArrayList(this.e);
                arrayList.addAll(this.a.a(b2));
                ArrayList arrayList2 = new ArrayList(this.d.size() + 1 + this.a.d());
                arrayList2.add(new a());
                arrayList2.addAll(this.d);
                arrayList2.addAll(this.a.c());
                return new r(xVar, this.c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), b2, this.g);
            }
            throw new IllegalStateException("Base URL required.");
        }
    }
}
