package com.jv.techex.poapi.controller;

import com.jv.techex.poapi.model.PurchaseOrder;
import com.jv.techex.poapi.repository.PurchaseOrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class PurchaseOrderController {

    private PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderController(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    @PreAuthorize("#oauth2.hasScope('po:write')")
    @PostMapping("/po")
    public ResponseEntity<PurchaseOrder> create(final @RequestBody PurchaseOrder purchaseOrder) {
        PurchaseOrder createdPurchaseOrder = purchaseOrderRepository.save(purchaseOrder);
        return ResponseEntity.ok(createdPurchaseOrder);
    }

    @PreAuthorize("#oauth2.hasScope('po:read')")
    @GetMapping("/po/{id}")
    public ResponseEntity<PurchaseOrder> readPurchaseOrder(final @PathVariable Long id) {

        PurchaseOrder purchaseOrder = purchaseOrderRepository
                                                .findById(id)
                                                .orElseThrow(() -> new RuntimeException("order not found"));
        return ResponseEntity.ok(purchaseOrder);
    }

    @PreAuthorize("#oauth2.hasScope('po:read')")
    @GetMapping("/pos")
    public ResponseEntity<List<PurchaseOrder>> listPurchaseOrders() {

        List<PurchaseOrder> purchaseOrders = new ArrayList<>();
        purchaseOrderRepository
                .findAll()
                .forEach(purchaseOrders::add);

        return ResponseEntity.ok(purchaseOrders);
    }

    @PreAuthorize("#oauth2.hasScope('po:write')")
    @PutMapping("/po/{id}")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(final @PathVariable Long id, final @RequestBody PurchaseOrder purchaseOrder) {

        purchaseOrder.setId(id);
        PurchaseOrder updatedPurchaseOrder = purchaseOrderRepository.save(purchaseOrder);
        return ResponseEntity.ok(updatedPurchaseOrder);
    }

    @PreAuthorize("#oauth2.hasScope('po:delete')")
    @DeleteMapping("/po/{id}")
    public ResponseEntity<Void> deletePurchaseOrder(@PathVariable Long id) {

        purchaseOrderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
