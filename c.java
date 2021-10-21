package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

public interface c<R, T> {
    T a(b<R> bVar);

    Type a();

    public static abstract class a {
        @Nullable
        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, r rVar);

        protected static Type a(int i, ParameterizedType parameterizedType) {
            return t.a(i, parameterizedType);
        }

        protected static Class<?> a(Type type) {
            return t.a(type);
        }
    }
}
