package com.example.springhello.controller;

import com.example.springhello.utils.SearchParam;
import com.example.springhello.utils.Sex;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String name(@RequestParam("name") String name) {
        return name;
    }


    // 2. GET 요청이 (@PathVariable)
    // /person/sex/남
    // /person/sex/녀
    // 이때 성별을 출력하는 메서드를 여기다 정의히세요.

    @GetMapping("/person/sex/{sex}")
    @ResponseBody
    public String sex(@PathVariable("sex") Sex sex) {
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
    @PostMapping("/add/{숫자1}/{숫자2}")
    public int addPrint(@PathVariable("숫자1") int n1, @PathVariable("숫자2") int n2) {
        return n1 + n2;
    }

    // 5. My2Controller를 정의하고 방문 횟수를 Count하여 출력하는 메서드를 정의하세요.
}


// 6. ResponseBody의 의미를 알아세요. RestController, Controller의 차이

// 7. 리다이렉션을 다루는 방법을 공부하세요. (redirect::)

// 8. 쿠키 값을 다루는 방법을 공부하세요. (@Cookie)

// 9. 세션을 다루는 방법을 공부하세요. (@Session)

// 10. RequestBody, ResponseBody를 구글링해봐요. 안써도 되니까 읽어만 봐.
