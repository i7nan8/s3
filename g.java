package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.c;

/* access modifiers changed from: package-private */
public final class g extends c.a {
    static final c.a a = new g();

    g() {
    }

    @Override // retrofit2.c.a
    @Nullable
    public c<?, ?> a(Type type, Annotation[] annotationArr, r rVar) {
        if (a(type) != b.class) {
            return null;
        }
        final Type e = t.e(type);
        return new c<Object, b<?>>() {
            /* class retrofit2.g.AnonymousClass1 */

            /* renamed from: b */
            public b<Object> a(b<Object> bVar) {
                return bVar;
            }

            @Override // retrofit2.c
            public Type a() {
                return e;
            }
        };
    }
}
