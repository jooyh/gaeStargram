package com.team.geaStargram.controller;

import com.team.geaStargram.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class AccountController {

    @Inject
    AccountService service;

    @RequestMapping(value = "/Login/loginOk", method = RequestMethod.POST)
    public void login(HttpServletResponse response, HttpServletRequest request,
                      @RequestParam(value = "userEmail", required = true) String email,
                      @RequestParam(value = "userPassword", required = true) String pw,
                      @RequestParam(value = "cookieCheck", required = false) String check) {

        switch (service.login(email, pw)) {
            case DONE:
                HttpSession session = request.getSession();
                session.setAttribute("sessionId", email);

                if (check == null) {
                    check = "";
                }
                cookieId(check, email, response);

                break;
            default:
                break;
        }

    }


    public void cookieId(String check, String email, HttpServletResponse response) {

        Cookie cookie = new Cookie("cookieId", email);

        if (check.equals("remember")) {
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24 * 30);
        } else {
            cookie.setPath("/");
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);
    }

    @ResponseBody
    @RequestMapping(value = "/Login/idCheck", method = RequestMethod.POST)
    public ResponseEntity<String> idCheck(String name) {

        ResponseEntity<String> entity = null;

        switch (service.isDuplicatedEmail(name)) {
            case NO_EMAIL:
                entity = new ResponseEntity<String>("사용가능한 닉네임입니다.", HttpStatus.OK);
                break;
            case DONE:
                entity = new ResponseEntity<String>("사용불가능한 닉네임입니다.", HttpStatus.BAD_REQUEST);
                break;
            default:
                break;
        }
        return entity;
    }
}
