package com.example.main.controller.login;

import com.example.main.dto.login.GrowthTrackingDTO;
import com.example.main.dao.login.GrowthTracking;
import com.example.main.service.login.GrowthTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/babies")
public class GrowthTrackingController {
    @Autowired
    private GrowthTrackingService growthTrackingService;

    @PostMapping("/{babyId}/growth")
    public ResponseEntity<GrowthTracking> addGrowthTracking(
            @PathVariable Long babyId,
            @RequestBody GrowthTrackingDTO growthTrackingDTO) {

        GrowthTracking growthTracking = growthTrackingService.addGrowthTracking(
                babyId,
                growthTrackingDTO.getWeight(),
                growthTrackingDTO.getHeight(),
                growthTrackingDTO.getMeasurementDate());
        return ResponseEntity.ok(growthTracking);
    }

    @GetMapping("/{babyId}/growth")
    public ResponseEntity<List<GrowthTracking>> getGrowthTracking(@PathVariable Long babyId) {
        List<GrowthTracking> growthTrackings = growthTrackingService.getGrowthTrackingByBabyId(babyId);
        return ResponseEntity.ok(growthTrackings);
    }
}

