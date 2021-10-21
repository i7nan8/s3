package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.c;
import retrofit2.f;

/* access modifiers changed from: package-private */
public class n {
    private static final n a = e();

    /* access modifiers changed from: package-private */
    public boolean a(Method method) {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Executor b() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return 0;
    }

    n() {
    }

    static n a() {
        return a;
    }

    private static n e() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new b();
        } catch (ClassNotFoundException unused2) {
            return new n();
        }
    }

    /* access modifiers changed from: package-private */
    public List<? extends c.a> a(@Nullable Executor executor) {
        if (executor != null) {
            return Collections.singletonList(new h(executor));
        }
        return Collections.singletonList(g.a);
    }

    /* access modifiers changed from: package-private */
    public List<? extends f.a> c() {
        return Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Object a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    @IgnoreJRERequirement
    public static class b extends n {
        /* access modifiers changed from: package-private */
        @Override // retrofit2.n
        public int d() {
            return 1;
        }

        b() {
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.n
        public boolean a(Method method) {
            return method.isDefault();
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.n
        public Object a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.n
        public List<? extends c.a> a(@Nullable Executor executor) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(e.a);
            if (executor != null) {
                arrayList.add(new h(executor));
            } else {
                arrayList.add(g.a);
            }
            return Collections.unmodifiableList(arrayList);
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.n
        public List<? extends f.a> c() {
            return Collections.singletonList(l.a);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends n {
        a() {
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.n
        @IgnoreJRERequirement
        public boolean a(Method method) {
            if (Build.VERSION.SDK_INT < 24) {
                return false;
            }
            return method.isDefault();
        }

        @Override // retrofit2.n
        public Executor b() {
            return new ExecutorC0083a();
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.n
        public List<? extends c.a> a(@Nullable Executor executor) {
            if (executor != null) {
                h hVar = new h(executor);
                if (Build.VERSION.SDK_INT < 24) {
                    return Collections.singletonList(hVar);
                }
                return Arrays.asList(e.a, hVar);
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.n
        public List<? extends f.a> c() {
            if (Build.VERSION.SDK_INT >= 24) {
                return Collections.singletonList(l.a);
            }
            return Collections.emptyList();
        }

        /* access modifiers changed from: package-private */
        @Override // retrofit2.n
        public int d() {
            return Build.VERSION.SDK_INT >= 24 ? 1 : 0;
        }

        /* renamed from: retrofit2.n$a$a  reason: collision with other inner class name */
        static class ExecutorC0083a implements Executor {
            private final Handler a = new Handler(Looper.getMainLooper());

            ExecutorC0083a() {
            }

            public void execute(Runnable runnable) {
                this.a.post(runnable);
            }
        }
    }
}
