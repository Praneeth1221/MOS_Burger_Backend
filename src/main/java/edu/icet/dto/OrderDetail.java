package edu.icet.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    private String itemId;
    private Integer qty;
    private Double price;
    private Double total;
}
