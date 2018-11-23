package com.jv.techex.poapi.controller;

import com.jv.techex.poapi.exception.DataNotFoundException;
import com.jv.techex.poapi.model.PurchaseOrder;
import com.jv.techex.poapi.repository.PurchaseOrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PurchaseOrderController {

    private PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderController(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    @PostMapping("/po")
    public ResponseEntity<PurchaseOrder> create(final @RequestBody PurchaseOrder purchaseOrder) {
        PurchaseOrder createdPurchaseOrder = purchaseOrderRepository.save(purchaseOrder);
        return ResponseEntity.ok(createdPurchaseOrder);
    }

    @GetMapping("/po/{id}")
    public ResponseEntity<PurchaseOrder> readPurchaseOrder(final @PathVariable Long id) {

        PurchaseOrder purchaseOrder = purchaseOrderRepository
                                                .findById(id)
                                                .orElseThrow(() -> new DataNotFoundException());
        return ResponseEntity.ok(purchaseOrder);
    }

    @GetMapping("/pos")
    public ResponseEntity<List<PurchaseOrder>> listPurchaseOrders() {

        List<PurchaseOrder> purchaseOrders = new ArrayList<>();
        purchaseOrderRepository
                .findAll()
                .forEach(purchaseOrders::add);

        return ResponseEntity.ok(purchaseOrders);
    }

    @PutMapping("/po/{id}")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(final @PathVariable Long id, final @RequestBody PurchaseOrder purchaseOrder) {

        purchaseOrder.setId(id);
        PurchaseOrder updatedPurchaseOrder = purchaseOrderRepository.save(purchaseOrder);
        return ResponseEntity.ok(updatedPurchaseOrder);
    }

    @DeleteMapping("/po/{id}")
    public ResponseEntity<Void> deletePurchaseOrder(@PathVariable Long id) {

        purchaseOrderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
