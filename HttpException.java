package retrofit2;

public class HttpException extends RuntimeException {
    private final transient q<?> a;
    private final int code;
    private final String message;

    private static String a(q<?> qVar) {
        t.a(qVar, "response == null");
        return "HTTP " + qVar.a() + " " + qVar.b();
    }

    public HttpException(q<?> qVar) {
        super(a(qVar));
        this.code = qVar.a();
        this.message = qVar.b();
        this.a = qVar;
    }
}
