package com.mall.stripe;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-05-06 14:12
 **/

public class stripe {


    public static void main(String[] args) {
        Stripe.apiKey = "pk_test_9w5Xf3e7kEac1lBylhz7GrBq00p8PkG9uD";

        Map<String, Object> chargeMap = new HashMap<String, Object>();
        chargeMap.put("amount", 100);
        chargeMap.put("currency", "usd");
        chargeMap.put("source", "R3JNKrBH2Dqtw0Fa"); // obtained via Stripe.js

        try {
            Charge charge = Charge.create(chargeMap);
            System.out.println(charge);
        } catch (StripeException e) {
            e.printStackTrace();
        }
    }
}

