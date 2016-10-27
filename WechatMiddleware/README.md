彪洋科技沟通消息中间件
====

- - -

引用方式
---

    <dependency>
        <groupId>com.boldseas</groupId>
        <artifactId>boldseas-communicate</artifactId>
        <version>1.2</version>
    </dependency>
    

发送短信示例
----

    SmsClient client = new SmsClient("http://192.168.2.225");
    SmsMessageResult result = client.send("f7574cbb1c17b0f47d9b254d1ea78db0", "18500292156", "test message from boldseas middleware!【Jeep商城】");
    
短信返回值及token等实现方式请参考[彪洋基础服务-短信](http://wiki.boldseas.com/pages/viewpage.action?pageId=4789479)
- - -
  
发送邮件示例
----

    MailMessage message = new MailMessage("dave.wu@boldseas.com", "彪洋科技消息中间件", "彪洋科技消息中间件正式上线啦！");
    MailClient client = new MailClient("192.168.2.225");
    MailSendResult result = client.send("b03300650c386abbd27f5253a13a13b1", message);
    
邮件返回值及token等实现方式请参考[彪洋基础服务-邮件](http://wiki.boldseas.com/pages/viewpage.action?pageId=4789670)
    
      
微信模板消息示例
----

    WechatClient client = new WechatClient("192.168.2.225");
    Map<String, String> map = new HashMap<>();
    map.put("first", "尊敬的客户:\\n您的车辆已出库，预计2016/6/12可到店");
    map.put("keyword1", "12345678912");
    map.put("keyword2", "全新Jeep自由侠1.4T 劲能版+");
    map.put("remark", "如有任何问题，欢迎拨打400-6500-118咨询热线");

    TemplateMessage message = new TemplateMessage("oRGinjrbGdANnqyUvU0rYlpYMbss", "bWk7-rz6MlbV0bB7X1JBUDmwZXH5l854b43WlO6AFDI", "http://www.boldseas.com", map);

    TemplateMessageResult result = client.sendTemplate("d926ac230e31cb6b08ee9c6109a05386", message);
    
微信模板消息返回值及token等实现方式请参考[彪洋基础服务-微信-模板消息](http://wiki.boldseas.com/pages/viewpage.action?pageId=4790341)

微信扫码支付（模式二）
----

    PayClient client = new PayClient("http://192.168.2.225");
    NativePayInput input = new NativePayInput();
    input.setBody("body");
    input.setNotifyUrl("http://pay.boldseas.com");
    input.setProductId("productid");
    input.setTotalFee("123");
    input.setTradeNumber("12132154521");
    input.setIp("192.168.2.155");
    NativePayOutput output = client.nativePay("bf3cebbfe4fd348b5b0fc2cab9478cdc", input);
    
微信模板消息返回值及token等实现方式请参考[彪洋基础服务-微信-扫码支付](http://wiki.boldseas.com/pages/viewpage.action?pageId=9504198)

微信支付结果通知
----

    PayClient client = new PayClient("http://192.168.2.225");
    InputStream inputStream = request.InputStream;//这个流为微信通知的流内容
    client.nativePayVerify("bf3cebbfe4fd348b5b0fc2cab9478cdc", inputStream, c -> {
         System.out.println(JSON.toJSONString(c));
    });
    
微信模板消息返回值及token等实现方式请参考[彪洋基础服务-微信-扫码支付](http://wiki.boldseas.com/pages/viewpage.action?pageId=9504198)