package com.externshipproject.FoodOrderingSystemTeam110.controller;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CustomErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    private final ErrorAttributes errorAttributes;

    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(ERROR_PATH)
    public ModelAndView handleError(HttpServletRequest request, HttpServletResponse response, Model model) {
        Throwable error = errorAttributes.getError(new ServletWebRequest(request));
        HttpStatus status = getStatus(response);
        model.addAttribute("error", error);
        model.addAttribute("status", status);
        return new ModelAndView("error");
    }
    private HttpStatus getStatus(HttpServletResponse response) {
        int statusCode = response.getStatus();
        try {
            return HttpStatus.valueOf(statusCode);
        } catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}