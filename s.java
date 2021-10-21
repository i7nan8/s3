package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* access modifiers changed from: package-private */
public abstract class s<T> {
    /* access modifiers changed from: package-private */
    public abstract T a(Object[] objArr);

    s() {
    }

    static <T> s<T> a(r rVar, Method method) {
        p a = p.a(rVar, method);
        Type genericReturnType = method.getGenericReturnType();
        if (t.d(genericReturnType)) {
            throw t.a(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        } else if (genericReturnType != Void.TYPE) {
            return i.a(rVar, method, a);
        } else {
            throw t.a(method, "Service methods cannot return void.", new Object[0]);
        }
    }
}
