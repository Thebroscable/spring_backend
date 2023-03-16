package com.example.demo.controller;

import com.example.demo.dto.request.DiscountRequest;
import com.example.demo.dto.response.DiscountResponse;
import com.example.demo.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/discount")
public class DiscountController {

    private final DiscountService discountService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{discountId}")
    public ResponseEntity<DiscountResponse> getDiscountById(@PathVariable Long discountId) {
        return ResponseEntity.ok(discountService.getDiscountById(discountId));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/")
    public ResponseEntity<List<DiscountResponse>> getAllDiscount() {
        return ResponseEntity.ok(discountService.getAllDiscount());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/")
    public ResponseEntity<DiscountResponse> createDiscount(@RequestBody DiscountRequest discountRequest) {
        return ResponseEntity.ok(discountService.createDiscount(discountRequest));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{discountId}")
    public ResponseEntity<DiscountResponse> updateDiscount(@RequestBody DiscountRequest discountRequest,
                                                           @PathVariable Long discountId) {
        return ResponseEntity.ok(discountService.updateDiscount(discountRequest, discountId));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{discountId}")
    public ResponseEntity<Void> deleteDiscount(@PathVariable Long discountId) {
        discountService.deleteDiscount(discountId);
        return ResponseEntity.ok().build();
    }
}
