package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    private Integer orderId;
    private String date;
    private String cusId;
    List<OrderDetail> items;
}
