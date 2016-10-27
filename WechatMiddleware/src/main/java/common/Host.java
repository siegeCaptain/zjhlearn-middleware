package common;

/**
 * Created by jiahao.zhang on 2016/10/27.
 */
public class Host {
    private String hostOrigin;

    public Host(String host) {
        hostOrigin = host;
    }

    public String getHost() {
        return format(hostOrigin);
    }

    private String format(String host) {
        if (host.startsWith("http://")) return host;
        return String.format("http://%s", host);
    }

    @Override
    public String toString() {
        return format(hostOrigin);
    }
}
