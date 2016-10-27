package pay;

/**
 * @author Dave.Wu
 * @version 2016/8/22.
 */
public class NativePayOutput {
    /**
     * 微信返回的支付地址信息
     */
    private String codeUrl;
    /**
     * 二维码地址，直接在页面显示
     */
    private String url;

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
