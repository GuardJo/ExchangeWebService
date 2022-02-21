package com.wire.test.controller;

import com.wire.test.model.ExchangeInfo;
import com.wire.test.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    @GetMapping
    public String home(@ModelAttribute("info") ExchangeInfo exchangeInfo) {
        return "home";
    }

    @PostMapping
    public String submit(@ModelAttribute("info") ExchangeInfo exchangeInfo, Model model) {
        if (exchangeInfo.getRemittanceAmount() > 0) {
            String result = exchangeService.calculateResult(exchangeInfo.getExchangeValue(), exchangeInfo.getRemittanceAmount(), exchangeInfo.getSelectCountry());
            model.addAttribute("result", result);
        }

        if (exchangeInfo.getSelectCountry() != null) {
            exchangeInfo.setExchangeValue(exchangeService.getExchangeValue(exchangeInfo.getSelectCountry()));
            exchangeInfo.setMoneyType(exchangeService.transformMoneyType(exchangeInfo.getSelectCountry()));
        }

        return "home";
    }
}
