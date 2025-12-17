package eca;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;

/**
 * A small shim subclass to expose protected fields in Authenticator
 * so that Clojure proxies can access them.
 */
public abstract class AuthShim extends Authenticator {

    /** Expose the protected getRequestorType() */
    public RequestorType reqType() {
      System.err.println("AuthShim.reqType() was called");

        return getRequestorType();
    }

    /** Expose the protected getRequestingURL() */
    public URL reqURL() {
        return getRequestingURL();
    }

    /** Optionally, expose other protected final getters */
    public String reqHost() { return getRequestingHost(); }
    public int reqPort() { return getRequestingPort(); }
    public String reqScheme() { return getRequestingScheme(); }
    public String reqProtocol() { return getRequestingProtocol(); }
}
