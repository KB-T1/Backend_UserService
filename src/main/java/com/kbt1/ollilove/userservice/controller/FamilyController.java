package com.kbt1.ollilove.userservice.controller;

import com.kbt1.ollilove.userservice.domain.User;
import com.kbt1.ollilove.userservice.dto.UserRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/family")
@Tag(name = "Family",description = "가족 API")
public class FamilyController {

//    @PostMapping("")
//    @Operation(summary = "가족 정보 가져오기")
//    public ResponseEntity<List<>> selectFamilyInfo(@RequestBody UserRequestDTO userRequestDTO) {
//        return ResponseEntity.ok();
//    }
}
