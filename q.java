package retrofit2;

import javax.annotation.Nullable;
import okhttp3.ab;
import okhttp3.ac;

public final class q<T> {
    private final ab a;
    @Nullable
    private final T b;
    @Nullable
    private final ac c;

    public static <T> q<T> a(@Nullable T t, ab abVar) {
        t.a(abVar, "rawResponse == null");
        if (abVar.c()) {
            return new q<>(abVar, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> q<T> a(ac acVar, ab abVar) {
        t.a(acVar, "body == null");
        t.a(abVar, "rawResponse == null");
        if (!abVar.c()) {
            return new q<>(abVar, null, acVar);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    private q(ab abVar, @Nullable T t, @Nullable ac acVar) {
        this.a = abVar;
        this.b = t;
        this.c = acVar;
    }

    public int a() {
        return this.a.b();
    }

    public String b() {
        return this.a.d();
    }

    public boolean c() {
        return this.a.c();
    }

    @Nullable
    public T d() {
        return this.b;
    }

    @Nullable
    public ac e() {
        return this.c;
    }

    public String toString() {
        return this.a.toString();
    }
}
