package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.c;

@IgnoreJRERequirement
final class e extends c.a {
    static final c.a a = new e();

    e() {
    }

    @Override // retrofit2.c.a
    @Nullable
    public c<?, ?> a(Type type, Annotation[] annotationArr, r rVar) {
        if (a(type) != CompletableFuture.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type a2 = a(0, (ParameterizedType) type);
            if (a(a2) != q.class) {
                return new a(a2);
            }
            if (a2 instanceof ParameterizedType) {
                return new b(a(0, (ParameterizedType) a2));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }

    @IgnoreJRERequirement
    private static final class a<R> implements c<R, CompletableFuture<R>> {
        private final Type a;

        a(Type type) {
            this.a = type;
        }

        @Override // retrofit2.c
        public Type a() {
            return this.a;
        }

        /* renamed from: b */
        public CompletableFuture<R> a(final b<R> bVar) {
            final AnonymousClass1 r0 = new CompletableFuture<R>() {
                /* class retrofit2.e.a.AnonymousClass1 */

                public boolean cancel(boolean z) {
                    if (z) {
                        bVar.a();
                    }
                    return super.cancel(z);
                }
            };
            bVar.a(new d<R>() {
                /* class retrofit2.e.a.AnonymousClass2 */

                @Override // retrofit2.d
                public void a(b<R> bVar, q<R> qVar) {
                    if (qVar.c()) {
                        r0.complete(qVar.d());
                    } else {
                        r0.completeExceptionally(new HttpException(qVar));
                    }
                }

                @Override // retrofit2.d
                public void a(b<R> bVar, Throwable th) {
                    r0.completeExceptionally(th);
                }
            });
            return r0;
        }
    }

    @IgnoreJRERequirement
    private static final class b<R> implements c<R, CompletableFuture<q<R>>> {
        private final Type a;

        b(Type type) {
            this.a = type;
        }

        @Override // retrofit2.c
        public Type a() {
            return this.a;
        }

        /* renamed from: b */
        public CompletableFuture<q<R>> a(final b<R> bVar) {
            final AnonymousClass1 r0 = new CompletableFuture<q<R>>() {
                /* class retrofit2.e.b.AnonymousClass1 */

                public boolean cancel(boolean z) {
                    if (z) {
                        bVar.a();
                    }
                    return super.cancel(z);
                }
            };
            bVar.a(new d<R>() {
                /* class retrofit2.e.b.AnonymousClass2 */

                @Override // retrofit2.d
                public void a(b<R> bVar, q<R> qVar) {
                    r0.complete(qVar);
                }

                @Override // retrofit2.d
                public void a(b<R> bVar, Throwable th) {
                    r0.completeExceptionally(th);
                }
            });
            return r0;
        }
    }
}
