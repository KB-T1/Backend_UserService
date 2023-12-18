package com.kbt1.ollilove.userservice.controller;


import com.kbt1.ollilove.userservice.domain.User;
import com.kbt1.ollilove.userservice.dto.UserRequestDTO;
import com.kbt1.ollilove.userservice.dto.UserResponseDTO;
import com.kbt1.ollilove.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "User", description = "유저API")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    @Operation(summary = "사용자 기본정보 가져오기")
    public ResponseEntity<UserResponseDTO> selectUserInfo(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findUserInfoById(userId));
    }

    @GetMapping("/family")
    @Operation(summary = "가족 정보 가져오기")
    public ResponseEntity<List<UserResponseDTO>> selectFamilyInfo(@RequestParam Long userId) {
        return ResponseEntity.ok(userService.findFamilyInfoByUserId(userId));
    }



}
