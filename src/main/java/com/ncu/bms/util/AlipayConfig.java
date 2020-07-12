package com.ncu.bms.util;

public class AlipayConfig {

    //在后台获取（必须配置）
    public static String app_id = "";

    //应用私钥
    public static String merchant_private_key = "";//教程查看获取方式（必须配置）

    //支付宝公钥
    public static String alipay_public_key = "";//教程查看获取方式（必须配置）

    public static String notify_url = "http://localhost:8080/alipay/alipayNotifyNotice";

    public static String return_url = "http://localhost:8080/alipay/alipayReturnNotice";

    public static String sign_type = "RSA2";

    public static String charset = "utf-8";

    //注意：沙箱测试环境，正式环境为：https://openapi.alipay.com/gateway.do
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

}
