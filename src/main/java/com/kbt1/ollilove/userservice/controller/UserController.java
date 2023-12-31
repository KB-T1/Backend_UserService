package com.kbt1.ollilove.userservice.controller;


import com.kbt1.ollilove.userservice.dto.FamilyDTO;
import com.kbt1.ollilove.userservice.dto.ResultDTO;
import com.kbt1.ollilove.userservice.dto.SignupDTO;
import com.kbt1.ollilove.userservice.dto.UserDTO;
import com.kbt1.ollilove.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "User", description = "유저API")
@CrossOrigin({"http://localhost:3000","http://ollilove.165.192.105.60.nip.io"})
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @Operation(summary = "회원가입")
    public ResponseEntity<ResultDTO<UserDTO>> signup(@RequestBody SignupDTO signupDTO) {

        return ResponseEntity.ok(userService.signup(signupDTO));
    }

    @GetMapping("/{userId}")
    @Operation(summary = "사용자 기본정보 가져오기")
    public ResponseEntity<ResultDTO<UserDTO>> selectUserInfo(@PathVariable @Min(value = 1) Long userId) {
        return ResponseEntity.ok(userService.findUserInfoById(userId));
    }



}
