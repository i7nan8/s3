package retrofit2;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.aa;
import okhttp3.q;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okhttp3.w;
import okhttp3.z;
import okio.c;
import okio.d;

/* access modifiers changed from: package-private */
public final class o {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Pattern b = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    private final String c;
    private final t d;
    @Nullable
    private String e;
    @Nullable
    private t.a f;
    private final z.a g = new z.a();
    @Nullable
    private v h;
    private final boolean i;
    @Nullable
    private w.a j;
    @Nullable
    private q.a k;
    @Nullable
    private aa l;

    o(String str, t tVar, @Nullable String str2, @Nullable s sVar, @Nullable v vVar, boolean z, boolean z2, boolean z3) {
        this.c = str;
        this.d = tVar;
        this.e = str2;
        this.h = vVar;
        this.i = z;
        if (sVar != null) {
            this.g.a(sVar);
        }
        if (z2) {
            this.k = new q.a();
        } else if (z3) {
            this.j = new w.a();
            this.j.a(w.e);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Object obj) {
        this.e = obj.toString();
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                this.h = v.a(str2);
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Malformed content type: " + str2, e2);
            }
        } else {
            this.g.b(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2, boolean z) {
        if (this.e != null) {
            String a2 = a(str2, z);
            String str3 = this.e;
            String replace = str3.replace("{" + str + "}", a2);
            if (!b.matcher(replace).matches()) {
                this.e = replace;
                return;
            }
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
        }
        throw new AssertionError();
    }

    private static String a(String str, boolean z) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                c cVar = new c();
                cVar.a(str, 0, i2);
                a(cVar, str, i2, length, z);
                return cVar.q();
            }
            i2 += Character.charCount(codePointAt);
        }
        return str;
    }

    private static void a(c cVar, String str, int i2, int i3, boolean z) {
        c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (cVar2 == null) {
                        cVar2 = new c();
                    }
                    cVar2.a(codePointAt);
                    while (!cVar2.g()) {
                        int j2 = cVar2.j() & 255;
                        cVar.i(37);
                        cVar.i((int) a[(j2 >> 4) & 15]);
                        cVar.i((int) a[j2 & 15]);
                    }
                } else {
                    cVar.a(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(String str, @Nullable String str2, boolean z) {
        String str3 = this.e;
        if (str3 != null) {
            this.f = this.d.e(str3);
            if (this.f != null) {
                this.e = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.d + ", Relative: " + this.e);
            }
        }
        if (z) {
            this.f.b(str, str2);
        } else {
            this.f.a(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(String str, String str2, boolean z) {
        if (z) {
            this.k.b(str, str2);
        } else {
            this.k.a(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(s sVar, aa aaVar) {
        this.j.a(sVar, aaVar);
    }

    /* access modifiers changed from: package-private */
    public void a(w.b bVar) {
        this.j.a(bVar);
    }

    /* access modifiers changed from: package-private */
    public void a(aa aaVar) {
        this.l = aaVar;
    }

    /* access modifiers changed from: package-private */
    public z.a a() {
        t tVar;
        t.a aVar = this.f;
        if (aVar != null) {
            tVar = aVar.c();
        } else {
            tVar = this.d.d(this.e);
            if (tVar == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.d + ", Relative: " + this.e);
            }
        }
        a aVar2 = this.l;
        if (aVar2 == null) {
            q.a aVar3 = this.k;
            if (aVar3 != null) {
                aVar2 = aVar3.a();
            } else {
                w.a aVar4 = this.j;
                if (aVar4 != null) {
                    aVar2 = aVar4.a();
                } else if (this.i) {
                    aVar2 = aa.a((v) null, new byte[0]);
                }
            }
        }
        v vVar = this.h;
        if (vVar != null) {
            if (aVar2 != null) {
                aVar2 = new a(aVar2, vVar);
            } else {
                this.g.b("Content-Type", vVar.toString());
            }
        }
        return this.g.a(tVar).a(this.c, aVar2);
    }

    private static class a extends aa {
        private final aa a;
        private final v b;

        a(aa aaVar, v vVar) {
            this.a = aaVar;
            this.b = vVar;
        }

        @Override // okhttp3.aa
        public v a() {
            return this.b;
        }

        @Override // okhttp3.aa
        public long b() throws IOException {
            return this.a.b();
        }

        @Override // okhttp3.aa
        public void a(d dVar) throws IOException {
            this.a.a(dVar);
        }
    }
}
