package com.example.demo.service;

import com.example.demo.dto.request.DiscountRequest;
import com.example.demo.dto.response.DiscountResponse;
import com.example.demo.entity.Discount;
import com.example.demo.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountService {

    @Autowired
    DiscountRepository discountRepository;

    public DiscountResponse getDiscountById(Long discountId) {
        Discount discount = discountRepository.getReferenceById(discountId);
        return new DiscountResponse(discount);
    }

    public List<DiscountResponse> getAllDiscount() {
        List<Discount> discounts = discountRepository.findAll();
        List<DiscountResponse> discountResponses = new ArrayList<DiscountResponse>();
        for (Discount discount : discounts) {
            discountResponses.add(new DiscountResponse(discount));
        }
        return discountResponses;
    }

    public DiscountResponse createDiscount(DiscountRequest discountRequest) {
        Discount discount = new Discount();
        discount.setVariablesByRequest(discountRequest);

        Discount savedDiscount = discountRepository.save(discount);
        return new DiscountResponse(savedDiscount);
    }

    public DiscountResponse updateDiscount(DiscountRequest discountRequest,
                                           Long discountId) {
        Discount discount = discountRepository.getReferenceById(discountId);
        discount.setVariablesByRequest(discountRequest);

        Discount savedDiscount = discountRepository.save(discount);
        return new DiscountResponse(savedDiscount);
    }

    public void deleteDiscount(Long discountId) {
        Discount discount = discountRepository.getReferenceById(discountId);
        discountRepository.delete(discount);
    }
}
