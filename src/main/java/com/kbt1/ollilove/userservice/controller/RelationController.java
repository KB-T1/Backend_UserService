package com.kbt1.ollilove.userservice.controller;

import com.kbt1.ollilove.userservice.dto.FamilyDTO;
import com.kbt1.ollilove.userservice.dto.RelationDTO;
import com.kbt1.ollilove.userservice.dto.ResultDTO;
import com.kbt1.ollilove.userservice.service.RelationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "Relation", description = "관계API")
@CrossOrigin("http://localhost:3000")
public class RelationController {

    private final RelationService relationService;
    @PostMapping("/relation")
    @Operation(summary = "별명 정하기")
    public ResponseEntity<ResultDTO> saveNickname(@RequestBody RelationDTO relationDTO){
        return ResponseEntity.ok(relationService.saveRelation(relationDTO));
    }

    @GetMapping("/{userId}/family")
    @Operation(summary = "가족 정보 가져오기")
    public ResponseEntity<ResultDTO<FamilyDTO>> selectFamilyInfo(@PathVariable Long userId) {
        return ResponseEntity.ok(relationService.findFamilyInfoByUserId(userId));
    }



}
