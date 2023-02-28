package com.example.springhello.controller;

import com.example.springhello.utils.SearchParam;
import com.example.springhello.utils.Sex;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class MyController {

    @GetMapping("/hi")
    @ResponseBody
    public String hi() {
        return "hi";
    }

    // 1. GET 요청이 (@RequestParam)
    // /person?name=진환
    // /person?name=something
    // /person?name=용관
    // 이때 이름을 출력하는 메서드를 여기다 정의하세요.
    @ResponseBody
    @GetMapping("/person")
    public String name(@RequestParam String name) {
        return name;
    }

    // 2. GET 요청이 (@PathVariable)
    // /person/sex/남
    // /person/sex/녀
    // 이때 성별을 출력하는 메서드를 여기다 정의히세요.
    @GetMapping("/person/sex/{sex}")
    @ResponseBody
    public String sex(@PathVariable Sex sex) {
        return sex.toString();
    }

    // 3. PostMan으로 POST "hi" 를 요청했을때
    // hi를 출력하는 메서드를 정의하세요.
    @ResponseBody
    @PostMapping("/post")
    public String postPrint(@RequestBody SearchParam searchParam) {
        return searchParam.getHi();
    }

    // 4. PUT /add/{숫자1}/{숫자2}
    // 숫자1+숫자2를 반환하는 메서드를 정의하세요.
    @ResponseBody
    @PostMapping("/add/{숫자1}/{숫자2}")
    public int addPrint(@PathVariable("숫자1") int n1, @PathVariable("숫자2") int n2) {
        return n1 + n2;
    }

   // 7. GET Mapping 의 hi로 리다이렉트 시켜서 hi를 반환하도록 해보세요;.
    @GetMapping("/redirect")
    public String redirectToHi() {
        return "redirect:/hi";
    }

    @GetMapping("/forward")
    public String forwardToHi() {
        return "forward:/hi";
    }

    @GetMapping("/view/hello")
    public String viewHello(){
        return "/hello";
    }

    @GetMapping("/view/thymeleaf/sample")
    public String thymeleafHello(Model model) {
        model.addAttribute("hello","서버에서 보내준 값입니다");
        return "/thymeleaf_sample";
    }

    @GetMapping("/cookie")
    public void cookie(HttpServletResponse response) {
        String data = URLEncoder.encode("ygwan", StandardCharsets.UTF_8);
        Cookie cookie = new Cookie("cookie",data);
        cookie.setMaxAge(24 * 60 * 60); //초단위
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}

// 6. RequestBody, ResponseBody의 의미를 알아세요. RestController, Controller의 차이

// 7. 리다이렉션, Forward을 다루는 방법을 공부하세요. (redirect와 forward의 차이를 공부해봐바)

// 8. 쿠키 값을 다루는 방법을 공부하세요. (@Cookie)

// 9. 세션을 다루는 방법을 공부하세요. (@Session)