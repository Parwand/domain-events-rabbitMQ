package net.parwand.producer.controller;

import net.parwand.producer.applicationservice.ProductService;
import net.parwand.producer.configuration.MQConfig;
import net.parwand.producer.domain.Product;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @AUTHOR Parwand Alsino
 */
@Controller
public class WebController {

    private final RabbitTemplate rabbitTemplate;
    private final ProductService productService;

    private WebController(RabbitTemplate rabbitTemplate, ProductService productService) {
        this.rabbitTemplate = rabbitTemplate;
        this.productService = productService;
    }

    @GetMapping("/")
    public String showProducts(Model model){
        List<Product> products = productService.allProducts();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/product/{id}")
    private String productPublisher(@PathVariable Long id, Model model){
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/order")
    public String productPublisher(Product product){
        rabbitTemplate.convertAndSend(MQConfig.PRODUCT_QUEUE, product);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
