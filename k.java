package retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.e;
import okhttp3.f;
import okhttp3.v;
import okio.c;
import okio.h;
import okio.l;

/* access modifiers changed from: package-private */
public final class k<T> implements b<T> {
    private final p a;
    private final Object[] b;
    private final e.a c;
    private final f<ac, T> d;
    private volatile boolean e;
    @GuardedBy("this")
    @Nullable
    private e f;
    @GuardedBy("this")
    @Nullable
    private Throwable g;
    @GuardedBy("this")
    private boolean h;

    k(p pVar, Object[] objArr, e.a aVar, f<ac, T> fVar) {
        this.a = pVar;
        this.b = objArr;
        this.c = aVar;
        this.d = fVar;
    }

    /* renamed from: d */
    public k<T> clone() {
        return new k<>(this.a, this.b, this.c, this.d);
    }

    @Override // retrofit2.b
    public void a(final d<T> dVar) {
        e eVar;
        Throwable th;
        t.a(dVar, "callback == null");
        synchronized (this) {
            if (!this.h) {
                this.h = true;
                eVar = this.f;
                th = this.g;
                if (eVar == null && th == null) {
                    try {
                        e e2 = e();
                        this.f = e2;
                        eVar = e2;
                    } catch (Throwable th2) {
                        th = th2;
                        t.a(th);
                        this.g = th;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            dVar.a(this, th);
            return;
        }
        if (this.e) {
            eVar.b();
        }
        eVar.a(new f() {
            /* class retrofit2.k.AnonymousClass1 */

            @Override // okhttp3.f
            public void a(e eVar, ab abVar) {
                try {
                    try {
                        dVar.a(k.this, k.this.a(abVar));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    t.a(th2);
                    a(th2);
                }
            }

            @Override // okhttp3.f
            public void a(e eVar, IOException iOException) {
                a(iOException);
            }

            private void a(Throwable th) {
                try {
                    dVar.a(k.this, th);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    private e e() throws IOException {
        e a2 = this.c.a(this.a.a(this.b));
        if (a2 != null) {
            return a2;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    /* access modifiers changed from: package-private */
    public q<T> a(ab abVar) throws IOException {
        ac g2 = abVar.g();
        ab a2 = abVar.h().a(new b(g2.a(), g2.b())).a();
        int b2 = a2.b();
        if (b2 < 200 || b2 >= 300) {
            try {
                return q.a(t.a(g2), a2);
            } finally {
                g2.close();
            }
        } else if (b2 == 204 || b2 == 205) {
            g2.close();
            return q.a((Object) null, a2);
        } else {
            a aVar = new a(g2);
            try {
                return q.a((Object) this.d.a(aVar), a2);
            } catch (RuntimeException e2) {
                aVar.g();
                throw e2;
            }
        }
    }

    @Override // retrofit2.b
    public void a() {
        e eVar;
        this.e = true;
        synchronized (this) {
            eVar = this.f;
        }
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // retrofit2.b
    public boolean b() {
        boolean z = true;
        if (this.e) {
            return true;
        }
        synchronized (this) {
            if (this.f == null || !this.f.c()) {
                z = false;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public static final class b extends ac {
        @Nullable
        private final v a;
        private final long b;

        b(@Nullable v vVar, long j) {
            this.a = vVar;
            this.b = j;
        }

        @Override // okhttp3.ac
        public v a() {
            return this.a;
        }

        @Override // okhttp3.ac
        public long b() {
            return this.b;
        }

        @Override // okhttp3.ac
        public okio.e d() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a extends ac {
        @Nullable
        IOException a;
        private final ac b;

        a(ac acVar) {
            this.b = acVar;
        }

        @Override // okhttp3.ac
        public v a() {
            return this.b.a();
        }

        @Override // okhttp3.ac
        public long b() {
            return this.b.b();
        }

        @Override // okhttp3.ac
        public okio.e d() {
            return l.a(new h(this.b.d()) {
                /* class retrofit2.k.a.AnonymousClass1 */

                @Override // okio.h, okio.r
                public long a(c cVar, long j) throws IOException {
                    try {
                        return super.a(cVar, j);
                    } catch (IOException e) {
                        a.this.a = e;
                        throw e;
                    }
                }
            });
        }

        @Override // okhttp3.ac, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.b.close();
        }

        /* access modifiers changed from: package-private */
        public void g() throws IOException {
            IOException iOException = this.a;
            if (iOException != null) {
                throw iOException;
            }
        }
    }
}
