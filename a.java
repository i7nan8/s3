package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.Unit;
import okhttp3.aa;
import okhttp3.ac;
import retrofit2.b.w;
import retrofit2.f;

/* access modifiers changed from: package-private */
public final class a extends f.a {
    private boolean a = true;

    a() {
    }

    @Override // retrofit2.f.a
    @Nullable
    public f<ac, ?> a(Type type, Annotation[] annotationArr, r rVar) {
        if (type == ac.class) {
            if (t.a(annotationArr, (Class<? extends Annotation>) w.class)) {
                return c.a;
            }
            return C0081a.a;
        } else if (type == Void.class) {
            return f.a;
        } else {
            if (!this.a || type != Unit.class) {
                return null;
            }
            try {
                return e.a;
            } catch (NoClassDefFoundError unused) {
                this.a = false;
                return null;
            }
        }
    }

    @Override // retrofit2.f.a
    @Nullable
    public f<?, aa> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, r rVar) {
        if (aa.class.isAssignableFrom(t.a(type))) {
            return b.a;
        }
        return null;
    }

    static final class f implements f<ac, Void> {
        static final f a = new f();

        f() {
        }

        public Void a(ac acVar) {
            acVar.close();
            return null;
        }
    }

    static final class e implements f<ac, Unit> {
        static final e a = new e();

        e() {
        }

        public Unit a(ac acVar) {
            acVar.close();
            return Unit.INSTANCE;
        }
    }

    static final class b implements f<aa, aa> {
        static final b a = new b();

        public aa a(aa aaVar) {
            return aaVar;
        }

        b() {
        }
    }

    static final class c implements f<ac, ac> {
        static final c a = new c();

        public ac a(ac acVar) {
            return acVar;
        }

        c() {
        }
    }

    /* renamed from: retrofit2.a$a  reason: collision with other inner class name */
    static final class C0081a implements f<ac, ac> {
        static final C0081a a = new C0081a();

        C0081a() {
        }

        public ac a(ac acVar) throws IOException {
            try {
                return t.a(acVar);
            } finally {
                acVar.close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d implements f<Object, String> {
        static final d a = new d();

        d() {
        }

        /* renamed from: b */
        public String a(Object obj) {
            return obj.toString();
        }
    }
}
