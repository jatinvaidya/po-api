package com.jv.techex.poapi.repository;

import com.jv.techex.poapi.model.PurchaseOrder;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Long> {

}
