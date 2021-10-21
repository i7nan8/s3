package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import okhttp3.ac;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.f;

@IgnoreJRERequirement
final class l extends f.a {
    static final f.a a = new l();

    l() {
    }

    @Override // retrofit2.f.a
    @Nullable
    public f<ac, ?> a(Type type, Annotation[] annotationArr, r rVar) {
        if (a(type) != Optional.class) {
            return null;
        }
        return new a(rVar.b(a(0, (ParameterizedType) type), annotationArr));
    }

    @IgnoreJRERequirement
    static final class a<T> implements f<ac, Optional<T>> {
        final f<ac, T> a;

        a(f<ac, T> fVar) {
            this.a = fVar;
        }

        public Optional<T> a(ac acVar) throws IOException {
            return Optional.ofNullable(this.a.a(acVar));
        }
    }
}
