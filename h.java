package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.c;

/* access modifiers changed from: package-private */
public final class h extends c.a {
    final Executor a;

    h(Executor executor) {
        this.a = executor;
    }

    @Override // retrofit2.c.a
    @Nullable
    public c<?, ?> a(Type type, Annotation[] annotationArr, r rVar) {
        if (a(type) != b.class) {
            return null;
        }
        final Type e = t.e(type);
        return new c<Object, b<?>>() {
            /* class retrofit2.h.AnonymousClass1 */

            @Override // retrofit2.c
            public Type a() {
                return e;
            }

            /* renamed from: b */
            public b<Object> a(b<Object> bVar) {
                return new a(h.this.a, bVar);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static final class a<T> implements b<T> {
        final Executor a;
        final b<T> b;

        a(Executor executor, b<T> bVar) {
            this.a = executor;
            this.b = bVar;
        }

        @Override // retrofit2.b
        public void a(final d<T> dVar) {
            t.a(dVar, "callback == null");
            this.b.a(new d<T>() {
                /* class retrofit2.h.a.AnonymousClass1 */

                @Override // retrofit2.d
                public void a(b<T> bVar, final q<T> qVar) {
                    a.this.a.execute(new Runnable() {
                        /* class retrofit2.h.a.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            if (a.this.b.b()) {
                                dVar.a(a.this, new IOException("Canceled"));
                            } else {
                                dVar.a(a.this, qVar);
                            }
                        }
                    });
                }

                @Override // retrofit2.d
                public void a(b<T> bVar, final Throwable th) {
                    a.this.a.execute(new Runnable() {
                        /* class retrofit2.h.a.AnonymousClass1.AnonymousClass2 */

                        public void run() {
                            dVar.a(a.this, th);
                        }
                    });
                }
            });
        }

        @Override // retrofit2.b
        public void a() {
            this.b.a();
        }

        @Override // retrofit2.b
        public boolean b() {
            return this.b.b();
        }

        @Override // retrofit2.b
        /* renamed from: c */
        public b<T> clone() {
            return new a(this.a, this.b.c());
        }
    }
}
