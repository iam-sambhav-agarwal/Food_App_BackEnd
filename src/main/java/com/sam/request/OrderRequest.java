package com.sam.request;


import com.sam.model.Address;
import lombok.Data;

@Data
public class OrderRequest {

    private Long restaurantId;
    private Address deliveryAddress;
}
