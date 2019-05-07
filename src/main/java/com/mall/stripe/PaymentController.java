package com.mall.stripe;

import com.mall.common.param.BasicData;
import com.stripe.model.Charge;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-05-06 16:51
 **/
@Controller
@RequestMapping(value = "/mobile")
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
public class PaymentController {


    private StripeClient stripeClient;

    @Autowired
    PaymentController(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @PostMapping("payment/charge")
    public BasicData chargeCard(HttpServletRequest request)  {
        try{
            String token = request.getHeader("token");
            Double amount = Double.parseDouble(request.getHeader("amount"));
            return BasicData.CreateSucess(this.stripeClient.chargeCreditCard(token, amount));
        }catch (Exception e){
            e.printStackTrace();
            return BasicData.CreateErrorMsg(e.getMessage());

        }

    }




}

