package com.ncu.bms.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.ncu.bms.bean.Orders;
import com.ncu.bms.bean.Reader;
import com.ncu.bms.service.IOrderService;
import com.ncu.bms.service.IReaderService;
import com.ncu.bms.util.AlipayConfig;
import com.ncu.bms.util.OrderStatusEnum;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping("/alipay")
public class AlipayController {

    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private IReaderService iReaderService;

    @Autowired
    private Sid sid;

    @RequestMapping(value = "/getFine")
    @ResponseBody
    public String getFine(HttpSession session){
        String who = (String)session.getAttribute("who");
        if(who==null||who.equals("")||who.equals("admin")){
            return "false";
        }
        else{
            String reader_id = (String) session.getAttribute("id");
            if(reader_id==null||reader_id.equals("")){
                return "false";
            }
            else{
                Reader reader = iReaderService.isExist(reader_id);
                if (reader==null){
                    return "false";
                }
                else{
                    if(reader.getReader_fine()==null){
                        return null;
                    }
                    else{
                        String reader_fine = reader.getReader_fine().toString();
                        return reader_fine;
                    }
                }
            }
        }
    }

    @RequestMapping(value = "/createOrder")
    @ResponseBody
    public Orders createOrder(HttpSession session,@RequestParam String reader_fine){
//        System.out.println("enter1");
        String who = (String)session.getAttribute("who");
        if(who==null||who.equals("")||who.equals("admin")){
//            System.out.println("enter2");
            return null;
        }
        else{
//            System.out.println("enter3");
            String reader_id = (String) session.getAttribute("id");
            if(reader_id==null||reader_id.equals("")){
//                System.out.println("enter4");
                return null;
            }
            else{
//                System.out.println("enter5");
                Orders order = new Orders();
//                System.out.println("enter1");
                String orderId = Sid.nextShort();
//                System.out.println("enter1");
//                System.out.println("orderId:"+orderId.trim());
                order.setId(orderId);
                order.setOrder_num(orderId);
                order.setCreate_time(new Date());
//                System.out.println("enter1");
//                System.out.println(reader_fine);
                order.setOrder_amount(reader_fine);
//                System.out.println("enter1");
                order.setOrder_status(OrderStatusEnum.WAIT_PAY.key);
//                System.out.println("enter1");
                if(iOrderService.isSaveOrder(order)){
//                    System.out.println("enter6");
                    return order;
                }
                else{
//                    System.out.println("enter7");
                    return null;
                }
            }
        }
    }

    /**
     * 前往支付宝网关进行支付
     * */
    @RequestMapping(value = "/goAlipay")
    @ResponseBody
    public String goAlipay(HttpSession session,@RequestParam String orderId, HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, UnsupportedEncodingException {
        String who = (String)session.getAttribute("who");
        if(who==null||who.equals("")||who.equals("admin")){
            return "false";
        }
        else{
            String reader_id = (String) session.getAttribute("id");
            if(reader_id==null||reader_id.equals("")){
                return "false";
            }
            else{
                Orders order = iOrderService.getOrderById(orderId);
                if(order==null){
                    return "false";
                }
                else{
                    AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,AlipayConfig.app_id,AlipayConfig.merchant_private_key,"json",AlipayConfig.charset,AlipayConfig.alipay_public_key,AlipayConfig.sign_type);
                    AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
                    alipayTradePagePayRequest.setReturnUrl(AlipayConfig.return_url);
                    alipayTradePagePayRequest.setNotifyUrl(AlipayConfig.notify_url);
                    //商户订单号，商户网站订单系统中唯一订单号，必填
                    String out_trade_no = orderId;
                    //付款金额，必填
                    String total_amount = order.getOrder_amount();
                    //订单名称，必填
//                    String subject = "罚款缴纳";
//                    subject = new String(subject.getBytes("utf-8"), "utf-8");
//                    System.out.println(subject);
                    String subject = "fine";
                    //商品描述，可空
//                    String body = "FP图书管理系统罚款缴纳："+reader_id+"\t"+order.getOrder_amount();
//                    body = new String(body.getBytes("utf-8"), "utf-8");
//                    System.out.println(body);
//                    System.out.println(Charset.defaultCharset());
                    String body = reader_id+"\t"+order.getOrder_amount();
                    // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
                    String timeout_express = "15m";
                    alipayTradePagePayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                            + "\"total_amount\":\""+ total_amount +"\","
                            + "\"subject\":\""+ subject +"\","
                            + "\"body\":\""+ body +"\","
                            + "\"timeout_express\":\""+ timeout_express +"\","
                            + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
                    String result = alipayClient.pageExecute(alipayTradePagePayRequest).getBody();
                    return result;
                }
            }
        }
    }

    /**
     * 支付宝同步通知页面
     * */
    @RequestMapping(value = "/alipayReturnNotice")
    @ResponseBody
    public String alipayReturnNotice(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException, AlipayApiException {
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV2(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        if(signVerified){
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
            // 修改叮当状态，改为 支付成功，已付款; 同时新增支付流水
            if(iOrderService.isUpdateOrderStatus(out_trade_no, trade_no, total_amount)){
                return "pay success";
            }
            else{
                return "update failed";
            }
        }
        else{
            return "sign failed";
        }
    }

    /**
     * 支付宝异步通知页面
     * */
    @RequestMapping(value = "/alipayNotifyNotice")
    @ResponseBody
    public String alipayNotifyNotice(HttpServletRequest request, HttpServletRequest response) throws AlipayApiException, UnsupportedEncodingException {
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
//			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
        if(signVerified){
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
            if(trade_status.equals("TRADE_FINISHED")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序
                //注意： 尚自习的订单没有退款功能, 这个条件判断是进不来的, 所以此处不必写代码
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                return "";
            }
            else if(trade_status.equals("TRADE_SUCCESS")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序
                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
                // 修改叮当状态，改为 支付成功，已付款; 同时新增支付流水
                if(iOrderService.isUpdateOrderStatus(out_trade_no, trade_no, total_amount)){
                    return "pay success";
                }
                else{
                    return "update failed";
                }
            }
            else{
                return "unknown error";
            }
        }
        else{
            return "sign failed";
        }
    }

}
