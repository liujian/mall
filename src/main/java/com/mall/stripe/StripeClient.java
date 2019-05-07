package com.mall.stripe;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: mall
 * @description:
 * @author: liu.j
 * @create: 2019-05-06 16:52
 **/
@Component
public class StripeClient {


    @Value("${stripe.currency}")
    private String currency;

    @Value("${stripe.apiKey}")
    private String apiKey;

    @Autowired
    StripeClient() {
        Stripe.apiKey = apiKey;
    }

    /**
     * 注：我们把金额乘以100，因为条纹不需要美元，而需要美分。因此，如果我们必须支付100美元，那么我们应该通过100000美元的条纹。此外，该值应始终为整数。
     * @param token
     * @param amount
     * @return
     * @throws Exception
     */
    public Charge chargeCreditCard(String token, double amount) throws Exception {
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", (int)(amount * 100));
        chargeParams.put("currency", currency);
        chargeParams.put("source", token);
        Charge charge = Charge.create(chargeParams);
        return charge;
    }

    /**
     * 如果要将用户的信用卡保存在条带侧，则应使用以下方法创建客户：
     * 方法将返回Customer对象，而良好的做法是将CustomerID保存到用户的数据库中，以避免其丢失。
     * @param token
     * @param email
     * @return
     * @throws Exception
     */
    public Customer createCustomer(String token, String email) throws Exception {
        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("email", email);
        customerParams.put("source", token);
        return Customer.create(customerParams);
    }

    /**
     * 如果您使用信用卡创建了客户，则无需创建令牌并提示用户输入其信用卡。您可以使用这种方法向现有客户收费，例如：
     * @param customerId
     * @param amount
     * @return
     * @throws Exception
     */
    public Charge chargeCustomerCard(String customerId, int amount) throws Exception {
        String sourceCard =     Customer.retrieve(customerId).getDefaultSource();
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", amount);
        chargeParams.put("currency", "USD");
        chargeParams.put("customer", customerId);
        chargeParams.put("source", sourceCard);
        Charge charge = Charge.create(chargeParams);
        return charge;
    }


}

