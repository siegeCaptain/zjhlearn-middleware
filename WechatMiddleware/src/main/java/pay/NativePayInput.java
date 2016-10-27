package pay;

/**
 * @author Dave.Wu
 * @version 2016/8/22.
 */
public class NativePayInput {
    /**
     * 示例：腾讯充值中心-QQ会员充值
     */
    private String body;
    /**
     * 回调通知地址：全路径
     */
    private String notifyUrl;
    /**
     * 产品id
     */
    private String productId;
    /**
     * 总价，单位（分）
     */
    private String totalFee;
    /**
     * 订单号
     */
    private String tradeNumber;

    private String ip;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getTradeNumber() {
        return tradeNumber;
    }

    public void setTradeNumber(String tradeNumber) {
        this.tradeNumber = tradeNumber;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
