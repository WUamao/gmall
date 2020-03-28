package com.amao.gmall.shopportal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSON;
import com.amao.gmall.constant.SysCacheConstant;
import com.amao.gmall.oms.service.OrderService;
import com.amao.gmall.to.CommonResult;
import com.amao.gmall.ums.entity.Member;
import com.amao.gmall.vo.order.OrderConfirmVo;
import com.amao.gmall.vo.order.OrderCreateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author amao
 * @date 2020/3/28 11:18
 */
@Slf4j
@Api(tags = "订单服务")
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Reference
    OrderService orderService;

    @ApiOperation("订单确认")
    @GetMapping("/confirm")
    public CommonResult confirmOrder(@RequestParam("accessToken")String accessToken){
        //0、检查用户是否存在
        String memberJson = redisTemplate.opsForValue().get(SysCacheConstant.LOGIN_MEMBER + accessToken);
        if (StringUtils.isEmpty(accessToken)  || StringUtils.isEmpty(memberJson)){
            CommonResult failed = new CommonResult().failed();
            failed.setMessage("用户未登录，请先登录");
            //用户未登录
            return failed;
        }

        //1、登录的用户
        Member member = JSON.parseObject(memberJson, Member.class);
        /**
         * 返回如下数据；
         * 1、当前用户的可选地址列表
         * 2、当前购物车选中的商品信息
         * 3、可用的优惠卷信息
         * 4、支付、配送、发票方式信息
         */
        //dubbo的rpc隐式传参，setAttachment保存一下下一个远程服务需要的参数
        RpcContext.getContext().setAttachment("accessToken",accessToken);
        //调用下一个远程服务
        OrderConfirmVo confirm = orderService.orderConfirm(member.getId());

        return new CommonResult().success(confirm);
    }

    /**
     * 创建订单的时候必须用到确认订单的那些数据
     * @param totalPrice  为了比价；
     * @param accessToken
     * @return
     */
    @ApiOperation("下单")
    @PostMapping("/create")
    public CommonResult createOrder(@RequestParam("totalPrice") BigDecimal totalPrice,
                                    @RequestParam("accessToken") String accessToken,
                                    @RequestParam("addressId") Long addressId,
                                    @RequestParam(value = "note",required = false) String note,
                                    @RequestParam("orderToken") String orderToken){

        RpcContext.getContext().setAttachment("accessToken", accessToken);
        RpcContext.getContext().setAttachment("orderToken", orderToken);
        //1、创建订单要生成订单（总额）和订单项（购物车中的商品）；
        //防重复
        OrderCreateVo orderCreateVo = orderService.createOrder(totalPrice,addressId,note);

        if(!StringUtils.isEmpty(orderCreateVo.getTokenError())){
            CommonResult result = new CommonResult().failed();
            result.setMessage(orderCreateVo.getTokenError());
            return result;
        }
        //
        return new CommonResult().success(orderCreateVo);
    }

    /**
     * 去支付
     * @return
     */
    @GetMapping(value = "/pay",produces = {"text/html"})
    public String pay(@RequestParam("orderSn") String orderSn,
                      @RequestParam("accessToken") String accessToken){
        String string = orderService.pay(orderSn,accessToken);
        return string;
    }

    /**
     * 接收支付宝异步通知
     */
    @RequestMapping("/pay/success/async")
    public String paySuccessAsync(HttpServletRequest request){
        //封装支付宝数据
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        log.debug("订单【{}】===支付宝支付异步通知进来....",params.get("out_trade_no"));

        String result = orderService.resolvePayResult(params);
        return result;

    }

    @RequestMapping("/pay/success")
    public Map paySuccess(HttpServletRequest request){
//        //封装支付宝数据
//        Map<String, String> params = new HashMap<>();
//        Map<String, String[]> requestParams = request.getParameterMap();
//        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
//            }
//            // 乱码解决，这段代码在出现乱码时使用
//            try {
//                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
//                params.put(name, valueStr);
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
//
//        log.debug("订单【{}】===支付宝支付异步通知进来....",params.get("out_trade_no"));
//
//        String result = orderService.resolvePayResult(params);
        return request.getParameterMap();

    }

}
