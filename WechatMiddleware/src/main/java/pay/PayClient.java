package pay;

import common.HttpAccessProvider;
import org.springframework.http.HttpMethod;

import java.io.InputStream;
import java.util.function.Consumer;

/**
 * Created by 11501 on 2016/10/27.
 */
public class PayClient {

    private HttpAccessProvider httpAccessProvider;

    public PayClient(String host) {
        this.httpAccessProvider = new HttpAccessProvider(host);
    }

    /**
     * 微信扫码支付（模式2）
     *
     * @param input 订单信息
     * @return 返回二维码信息
     */
    public NativePayOutput nativePay(String accessToken, NativePayInput input) {
        String url = String.format("/api/wechat/pay/native?body=%s&ip=%s&notifyUrl=%s&productId=%s&totalFee=%s&tradeNumber=%s"
                , input.getBody()
                , input.getIp()
                , input.getNotifyUrl()
                , input.getProductId()
                , input.getTotalFee()
                , input.getTradeNumber());
        return httpAccessProvider.exchange(url, accessToken, input, NativePayOutput.class, HttpMethod.GET);
    }

    public void nativePayVerify(String accessToken, InputStream stream, Consumer<NativePayResult> consumer) {
        NativePayResult result = httpAccessProvider.upload(accessToken, stream, "/api/wechat/pay/native/verify", NativePayResult.class);
        if (consumer != null) consumer.accept(result);
    }

    public JsApiPayInfo getJsApiPayInfo(String accessToken, JsApiPayInfoInputDto input) {
        String url = "/api/wechat/pay/jsapi";
        return httpAccessProvider.post(url, accessToken, input, JsApiPayInfo.class);
    }

}
