package jsonCompiler;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class NullHostnameVerifier implements HostnameVerifier {
    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
}
