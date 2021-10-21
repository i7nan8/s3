package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.e;

/* access modifiers changed from: package-private */
public final class i<ResponseT, ReturnT> extends s<ReturnT> {
    private final p a;
    private final e.a b;
    private final c<ResponseT, ReturnT> c;
    private final f<ac, ResponseT> d;

    static <ResponseT, ReturnT> i<ResponseT, ReturnT> a(r rVar, Method method, p pVar) {
        c b2 = b(rVar, method);
        Type a2 = b2.a();
        if (a2 == q.class || a2 == ab.class) {
            throw t.a(method, "'" + t.a(a2).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        } else if (!pVar.a.equals("HEAD") || Void.class.equals(a2)) {
            return new i<>(pVar, rVar.a, b2, a(rVar, method, a2));
        } else {
            throw t.a(method, "HEAD method must use Void as response type.", new Object[0]);
        }
    }

    private static <ResponseT, ReturnT> c<ResponseT, ReturnT> b(r rVar, Method method) {
        Type genericReturnType = method.getGenericReturnType();
        try {
            return (c<ResponseT, ReturnT>) rVar.a(genericReturnType, method.getAnnotations());
        } catch (RuntimeException e) {
            throw t.a(method, e, "Unable to create call adapter for %s", genericReturnType);
        }
    }

    private static <ResponseT> f<ac, ResponseT> a(r rVar, Method method, Type type) {
        try {
            return rVar.b(type, method.getAnnotations());
        } catch (RuntimeException e) {
            throw t.a(method, e, "Unable to create converter for %s", type);
        }
    }

    private i(p pVar, e.a aVar, c<ResponseT, ReturnT> cVar, f<ac, ResponseT> fVar) {
        this.a = pVar;
        this.b = aVar;
        this.c = cVar;
        this.d = fVar;
    }

    /* access modifiers changed from: package-private */
    @Override // retrofit2.s
    public ReturnT a(Object[] objArr) {
        return this.c.a(new k(this.a, objArr, this.b, this.d));
    }
}
