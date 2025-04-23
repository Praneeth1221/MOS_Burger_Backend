package edu.icet.service.Impl;

import edu.icet.dto.Order;
import edu.icet.dto.OrderDetail;
import edu.icet.entity.ItemEntity;
import edu.icet.entity.OrderDetailEntity;
import edu.icet.entity.OrderEntity;
import edu.icet.repository.ItemDao;
import edu.icet.repository.OrderDao;
import edu.icet.repository.OrderDetailDao;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    final ModelMapper mapper;
    final OrderDao orderDao;
    final OrderDetailDao detailDao;
    final ItemDao itemDao;

    private int updateStock;
    @Transactional
    public void add(Order orders) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(new Date());

        OrderEntity orderEntity = new OrderEntity(null, formattedDate, orders.getCusId(), null);
        orderEntity = orderDao.save(orderEntity);

        for (OrderDetail orderDetail : orders.getItems()) {
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity(
                    null,
                    orderEntity,
                    orderDetail.getItemId(),
                    orderDetail.getQty(),
                    orderDetail.getPrice(),
                    orderDetail.getTotal()
            );
            detailDao.save(orderDetailEntity);

            ItemEntity itemEntity = itemDao.findById(Integer.valueOf(orderDetail.getItemId()))
                    .orElseThrow(() -> new RuntimeException("Item not found"));
            int newStock = itemEntity.getStock() - orderDetail.getQty();
            itemEntity.setStock(newStock);
            itemDao.save(itemEntity);
        }
    }
}
