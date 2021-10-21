package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.aa;
import okhttp3.s;
import okhttp3.w;

/* access modifiers changed from: package-private */
public abstract class m<T> {
    /* access modifiers changed from: package-private */
    public abstract void a(o oVar, @Nullable T t) throws IOException;

    m() {
    }

    /* access modifiers changed from: package-private */
    public final m<Iterable<T>> a() {
        return new m<Iterable<T>>() {
            /* class retrofit2.m.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            @Override // retrofit2.m
            public /* bridge */ /* synthetic */ void a(o oVar, @Nullable Object obj) throws IOException {
                a(oVar, (Iterable) ((Iterable) obj));
            }

            /* access modifiers changed from: package-private */
            public void a(o oVar, @Nullable Iterable<T> iterable) throws IOException {
                if (iterable != null) {
                    for (T t : iterable) {
                        m.this.a(oVar, t);
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final m<Object> b() {
        return new m<Object>() {
            /* class retrofit2.m.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: retrofit2.m */
            /* JADX WARN: Multi-variable type inference failed */
            /* access modifiers changed from: package-private */
            @Override // retrofit2.m
            public void a(o oVar, @Nullable Object obj) throws IOException {
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i = 0; i < length; i++) {
                        m.this.a(oVar, Array.get(obj, i));
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: retrofit2.m$m  reason: collision with other inner class name */
    public static final class C0082m extends m<Object> {
        C0082m() {
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.m
        public void a(o oVar, @Nullable Object obj) {
            t.a(obj, "@Url parameter is null.");
            oVar.a(obj);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d<T> extends m<T> {
        private final String a;
        private final f<T, String> b;

        d(String str, f<T, String> fVar) {
            this.a = (String) t.a(str, "name == null");
            this.b = fVar;
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.m
        public void a(o oVar, @Nullable T t) throws IOException {
            String a2;
            if (t != null && (a2 = this.b.a(t)) != null) {
                oVar.a(this.a, a2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class h<T> extends m<T> {
        private final String a;
        private final f<T, String> b;
        private final boolean c;

        h(String str, f<T, String> fVar, boolean z) {
            this.a = (String) t.a(str, "name == null");
            this.b = fVar;
            this.c = z;
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.m
        public void a(o oVar, @Nullable T t) throws IOException {
            if (t != null) {
                oVar.a(this.a, this.b.a(t), this.c);
                return;
            }
            throw new IllegalArgumentException("Path parameter \"" + this.a + "\" value must not be null.");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class i<T> extends m<T> {
        private final String a;
        private final f<T, String> b;
        private final boolean c;

        i(String str, f<T, String> fVar, boolean z) {
            this.a = (String) t.a(str, "name == null");
            this.b = fVar;
            this.c = z;
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.m
        public void a(o oVar, @Nullable T t) throws IOException {
            String a2;
            if (t != null && (a2 = this.b.a(t)) != null) {
                oVar.b(this.a, a2, this.c);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class k<T> extends m<T> {
        private final f<T, String> a;
        private final boolean b;

        k(f<T, String> fVar, boolean z) {
            this.a = fVar;
            this.b = z;
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.m
        public void a(o oVar, @Nullable T t) throws IOException {
            if (t != null) {
                oVar.b(this.a.a(t), null, this.b);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class j<T> extends m<Map<String, T>> {
        private final f<T, String> a;
        private final boolean b;

        /* access modifiers changed from: package-private */
        @Override // retrofit2.m
        public /* bridge */ /* synthetic */ void a(o oVar, @Nullable Object obj) throws IOException {
            a(oVar, (Map) ((Map) obj));
        }

        j(f<T, String> fVar, boolean z) {
            this.a = fVar;
            this.b = z;
        }

        /* access modifiers changed from: package-private */
        public void a(o oVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String a2 = this.a.a(value);
                            if (a2 != null) {
                                oVar.b(key, a2, this.b);
                            } else {
                                throw new IllegalArgumentException("Query map value '" + ((Object) value) + "' converted to null by " + this.a.getClass().getName() + " for key '" + key + "'.");
                            }
                        } else {
                            throw new IllegalArgumentException("Query map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Query map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Query map was null.");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class e<T> extends m<Map<String, T>> {
        private final f<T, String> a;

        /* access modifiers changed from: package-private */
        @Override // retrofit2.m
        public /* bridge */ /* synthetic */ void a(o oVar, @Nullable Object obj) throws IOException {
            a(oVar, (Map) ((Map) obj));
        }

        e(f<T, String> fVar) {
            this.a = fVar;
        }

        /* access modifiers changed from: package-private */
        public void a(o oVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            oVar.a(key, this.a.a(value));
                        } else {
                            throw new IllegalArgumentException("Header map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Header map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Header map was null.");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b<T> extends m<T> {
        private final String a;
        private final f<T, String> b;
        private final boolean c;

        b(String str, f<T, String> fVar, boolean z) {
            this.a = (String) t.a(str, "name == null");
            this.b = fVar;
            this.c = z;
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.m
        public void a(o oVar, @Nullable T t) throws IOException {
            String a2;
            if (t != null && (a2 = this.b.a(t)) != null) {
                oVar.c(this.a, a2, this.c);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c<T> extends m<Map<String, T>> {
        private final f<T, String> a;
        private final boolean b;

        /* access modifiers changed from: package-private */
        @Override // retrofit2.m
        public /* bridge */ /* synthetic */ void a(o oVar, @Nullable Object obj) throws IOException {
            a(oVar, (Map) ((Map) obj));
        }

        c(f<T, String> fVar, boolean z) {
            this.a = fVar;
            this.b = z;
        }

        /* access modifiers changed from: package-private */
        public void a(o oVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String a2 = this.a.a(value);
                            if (a2 != null) {
                                oVar.c(key, a2, this.b);
                            } else {
                                throw new IllegalArgumentException("Field map value '" + ((Object) value) + "' converted to null by " + this.a.getClass().getName() + " for key '" + key + "'.");
                            }
                        } else {
                            throw new IllegalArgumentException("Field map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Field map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class f<T> extends m<T> {
        private final s a;
        private final f<T, aa> b;

        f(s sVar, f<T, aa> fVar) {
            this.a = sVar;
            this.b = fVar;
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.m
        public void a(o oVar, @Nullable T t) {
            if (t != null) {
                try {
                    oVar.a(this.a, this.b.a(t));
                } catch (IOException e) {
                    throw new RuntimeException("Unable to convert " + ((Object) t) + " to RequestBody", e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class l extends m<w.b> {
        static final l a = new l();

        private l() {
        }

        /* access modifiers changed from: package-private */
        public void a(o oVar, @Nullable w.b bVar) {
            if (bVar != null) {
                oVar.a(bVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class g<T> extends m<Map<String, T>> {
        private final f<T, aa> a;
        private final String b;

        /* access modifiers changed from: package-private */
        @Override // retrofit2.m
        public /* bridge */ /* synthetic */ void a(o oVar, @Nullable Object obj) throws IOException {
            a(oVar, (Map) ((Map) obj));
        }

        g(f<T, aa> fVar, String str) {
            this.a = fVar;
            this.b = str;
        }

        /* access modifiers changed from: package-private */
        public void a(o oVar, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            oVar.a(s.a("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.b), this.a.a(value));
                        } else {
                            throw new IllegalArgumentException("Part map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Part map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a<T> extends m<T> {
        private final f<T, aa> a;

        a(f<T, aa> fVar) {
            this.a = fVar;
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.m
        public void a(o oVar, @Nullable T t) {
            if (t != null) {
                try {
                    oVar.a(this.a.a(t));
                } catch (IOException e) {
                    throw new RuntimeException("Unable to convert " + ((Object) t) + " to RequestBody", e);
                }
            } else {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
        }
    }
}
