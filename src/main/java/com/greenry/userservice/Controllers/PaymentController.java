package com.greenry.userservice.Controllers;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class PaymentController {

    //Creating order for payment
    @PostMapping("/create_order")
    @ResponseBody
    public String createOrder(@RequestBody Map<String,Object> data) throws RazorpayException {

        System.out.println(data);
        int amt=Integer.parseInt(data.get("amount").toString());

        var client = new RazorpayClient("rzp_test_KYnH2a0rayjTOA","rR6UofJKSWIxJyC8TfSS70GU");

        JSONObject ob = new JSONObject();
        ob.put("amount",amt*100);
        ob.put("currency","INR");
        ob.put("receipt","txn_235425");

        //creating new order

        Order order = client.orders.create(ob);

        System.out.println(order);

        return "";
    }
}
