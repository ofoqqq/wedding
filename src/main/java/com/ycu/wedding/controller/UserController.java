package com.ycu.wedding.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/marry/user")
public class UserController {
    private static final Logger log = LogManager.getLogger(UserController.class);

    @PostMapping("/add")
    public ApiResponse<Object> addTemplates(@RequestBody Aobj aobj) {
        try {
            templateService.addTemplates(aobj.getTemplateList());
            return ApiResponse.success();
        } catch (Exception e) {
            log.error("\nqqq,TemplateController addErr:\n", e);
            return ApiResponse.failure(500, "请求失败：" + e.getMessage());
        }
    }
}
