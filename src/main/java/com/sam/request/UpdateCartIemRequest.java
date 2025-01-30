package com.sam.request;


import lombok.Data;

@Data
public class UpdateCartIemRequest {

    private Long cartItemId;
    private int quantity;


}
