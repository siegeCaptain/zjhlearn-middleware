import common.HttpAccessProvider;

/**
 * Created by jiahao.zhang on 2016/10/27.
 */
public class WechatClient {

    private HttpAccessProvider httpAccessProvider;

    public WechatClient(String host) {
        this.httpAccessProvider = new HttpAccessProvider(host);
    }

//    public TemplateMessageResult sendTemplate(String accessToken, TemplateMessage message) {
//        return httpAccessProvider.post(ServiceUrl.WECHAT_TEMPLATE, accessToken, message, TemplateMessageResult.class);
//    }
}
