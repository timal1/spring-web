package com.timal1.spring.web.core.paypal;

import com.paypal.core.PayPalHttpClient;
import com.timal1.spring.web.core.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/paypal")
@RequiredArgsConstructor
public class PayPalController {
    private final PayPalHttpClient payPalHttpClient;
    private final OrderService orderService;
    private final PayPalService payPalService;

}
