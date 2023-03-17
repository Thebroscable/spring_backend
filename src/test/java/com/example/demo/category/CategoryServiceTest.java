package com.example.demo.category;

import com.example.demo.dto.request.ProductCategoryRequest;
import com.example.demo.dto.response.ProductCategoryResponse;
import com.example.demo.entity.ProductCategory;
import com.example.demo.repository.ProductCategoryRepository;
import com.example.demo.service.ProductCategoryService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private ProductCategoryRepository productCategoryRepository;
    private ProductCategoryService underTest;

    @BeforeEach
    void setUp() {
        underTest = new ProductCategoryService(productCategoryRepository);
    }

    @Test
    void getProductCategoryById_PassValueProperly() {
        when(productCategoryRepository.getReferenceById(any())).thenReturn(new ProductCategory());
        underTest.getProductCategoryById(1L);

        ArgumentCaptor<Long> argumentCaptor =
                ArgumentCaptor.forClass(Long.class);
        verify(productCategoryRepository).getReferenceById(argumentCaptor.capture());
        Long capturedValue = argumentCaptor.getValue();

        Assertions.assertThat(capturedValue).isEqualTo(1L);
    }

    @Test
    void getProductCategoryById_ReturnValueProperly() {
        ProductCategory productCategory = ProductCategory.builder()
                .id(1L)
                .name("test")
                .description("desc")
                .build();
        ProductCategoryResponse baseResponse = new ProductCategoryResponse(productCategory);

        when(productCategoryRepository.getReferenceById(any())).thenReturn(productCategory);
        ProductCategoryResponse response = underTest.getProductCategoryById(1L);

        Assertions.assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(baseResponse);
    }

    @Test
    void getAllProductCategory() {
        ProductCategory productCategory = ProductCategory.builder()
                .id(1L)
                .name("test")
                .description("desc")
                .build();
        List<ProductCategory> categories = new ArrayList<>();
        categories.add(productCategory);

        ProductCategoryResponse baseResponse = new ProductCategoryResponse(productCategory);
        when(productCategoryRepository.findAll()).thenReturn(categories);

        List<ProductCategoryResponse> responses = underTest.getAllProductCategory();
        verify(productCategoryRepository).findAll();

        Assertions.assertThat(!responses.isEmpty()).isTrue();
        Assertions.assertThat(responses.get(0))
                .usingRecursiveComparison()
                .isEqualTo(baseResponse);
    }

    @Test
    void createProductCategory_PassValueProperly() {
        ProductCategoryRequest productCategoryRequest = ProductCategoryRequest.builder()
                .name("test")
                .description("desc")
                .build();
        when(productCategoryRepository.save(any())).thenReturn(new ProductCategory());

        underTest.createProductCategory(productCategoryRequest);

        ArgumentCaptor<ProductCategory> argumentCaptor =
                ArgumentCaptor.forClass(ProductCategory.class);
        verify(productCategoryRepository).save(argumentCaptor.capture());

        ProductCategory capturedCategory = argumentCaptor.getValue();

        Assertions.assertThat(capturedCategory.getName()).isEqualTo("test");
        Assertions.assertThat(capturedCategory.getDescription()).isEqualTo("desc");
    }

    @Test
    void createProductCategory_ReturnValueProperly() {
        ProductCategory productCategory = ProductCategory.builder()
                .id(null)
                .name("test")
                .description("desc")
                .build();
        ProductCategoryResponse baseResponse = new ProductCategoryResponse(productCategory);

        when(productCategoryRepository.save(any())).thenReturn(productCategory);
        ProductCategoryResponse response = underTest.createProductCategory(new ProductCategoryRequest());

        Assertions.assertThat(baseResponse)
                .usingRecursiveComparison()
                .isEqualTo(response);
    }

    @Test
    void updateProductCategory_PassValueToGetById() {
        when(productCategoryRepository.getReferenceById(any())).thenReturn(new ProductCategory());
        when(productCategoryRepository.save(any())).thenReturn(new ProductCategory());
        underTest.updateProductCategory(new ProductCategoryRequest(),1L);

        ArgumentCaptor<Long> argumentCaptor =
                ArgumentCaptor.forClass(Long.class);
        verify(productCategoryRepository).getReferenceById(argumentCaptor.capture());
        Long capturedValue = argumentCaptor.getValue();

        Assertions.assertThat(capturedValue).isEqualTo(1L);
    }

    @Test
    void updateProductCategory_PassValueToSave() {
        ProductCategoryRequest productCategoryRequest = ProductCategoryRequest.builder()
                .name("new test")
                .description("new desc")
                .build();
        ProductCategory productCategory = ProductCategory.builder()
                .id(1L)
                .name("test")
                .description("desc")
                .build();
        when(productCategoryRepository.getReferenceById(any())).thenReturn(productCategory);
        when(productCategoryRepository.save(any())).thenReturn(new ProductCategory());

        underTest.updateProductCategory(productCategoryRequest, 1L);

        ArgumentCaptor<ProductCategory> argumentCaptor =
                ArgumentCaptor.forClass(ProductCategory.class);
        verify(productCategoryRepository).save(argumentCaptor.capture());

        ProductCategory capturedCategory = argumentCaptor.getValue();

        productCategory.setName("new test");
        productCategory.setDescription("new desc");
        Assertions.assertThat(capturedCategory).usingRecursiveComparison().isEqualTo(productCategory);
    }

    @Test
    void updateProductCategory_ReturnValueProperly() {
        ProductCategory productCategory = ProductCategory.builder()
                .id(1L)
                .name("test")
                .description("desc")
                .build();
        when(productCategoryRepository.getReferenceById(any())).thenReturn(new ProductCategory());
        when(productCategoryRepository.save(any())).thenReturn(productCategory);

        ProductCategoryResponse response =
                underTest.updateProductCategory(new ProductCategoryRequest(), 1L);

        ProductCategoryResponse baseResponse = new ProductCategoryResponse(productCategory);

        Assertions.assertThat(baseResponse).usingRecursiveComparison().isEqualTo(response);
    }

    @Test
    void deleteProductCategory_PassValueProperly() {
        ProductCategory productCategory = ProductCategory.builder()
                .id(null)
                .name("test")
                .description("desc")
                .build();
        when(productCategoryRepository.getReferenceById(any())).thenReturn(productCategory);

        underTest.deleteProductCategory(1L);

        ArgumentCaptor<Long> argumentCaptorLong =
                ArgumentCaptor.forClass(Long.class);
        ArgumentCaptor<ProductCategory> argumentCaptorObj =
                ArgumentCaptor.forClass(ProductCategory.class);

        verify(productCategoryRepository).getReferenceById(argumentCaptorLong.capture());
        verify(productCategoryRepository).delete(argumentCaptorObj.capture());

        Long capturedValue = argumentCaptorLong.getValue();
        ProductCategory capturedObj = argumentCaptorObj.getValue();

        Assertions.assertThat(capturedValue).isEqualTo(1L);
        Assertions.assertThat(capturedObj).usingRecursiveComparison().isEqualTo(productCategory);
    }

}
