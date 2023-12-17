package com.kbt1.ollilove.userservice.controller;


import com.kbt1.ollilove.userservice.domain.User;
import com.kbt1.ollilove.userservice.dto.UserRequestDTO;
import com.kbt1.ollilove.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "User", description = "유저API")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    @Operation(summary = "사용자 기본정보 가져오기")
    public ResponseEntity<User> selectMyDjList(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.findUserById(userRequestDTO));
    }


}
