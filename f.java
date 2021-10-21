package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.aa;
import okhttp3.ac;

public interface f<F, T> {
    @Nullable
    T a(F f) throws IOException;

    public static abstract class a {
        @Nullable
        public f<ac, ?> a(Type type, Annotation[] annotationArr, r rVar) {
            return null;
        }

        @Nullable
        public f<?, aa> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, r rVar) {
            return null;
        }

        @Nullable
        public f<?, String> b(Type type, Annotation[] annotationArr, r rVar) {
            return null;
        }

        protected static Type a(int i, ParameterizedType parameterizedType) {
            return t.a(i, parameterizedType);
        }

        protected static Class<?> a(Type type) {
            return t.a(type);
        }
    }
}
