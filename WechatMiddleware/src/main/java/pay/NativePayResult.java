package pay;

import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author Dave.Wu
 * @version 2016/8/23.
 */
public class NativePayResult {
    /**
     * 支付结果
     * 1 支付成功
     * 2 签名错误
     * 3 支付失败
     * 4 异常
     */
    private Integer result;
    /**
     * 订单号
     */
    private String orderNumber;
    /**
     * 客户的openid
     */
    private String openId;

    private PayVerifyInfo info;

    //region getter and setter

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public PayVerifyInfo getInfo() {
        return info;
    }

    public void setInfo(PayVerifyInfo info) {
        this.info = info;
    }

    //endregion

}
