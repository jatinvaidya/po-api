package com.jv.techex.poapi;

import com.jv.techex.poapi.model.PurchaseOrder;
import com.jv.techex.poapi.repository.PurchaseOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@SpringBootApplication
public class PoApiApplication {

    Logger logger = LoggerFactory.getLogger(PoApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PoApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadDemoData(PurchaseOrderRepository purchaseOrderRepository) {
        return (args) -> loadData(purchaseOrderRepository);
    }

    private void loadData(PurchaseOrderRepository purchaseOrderRepository) {
	    PurchaseOrder purchaseOrder = new PurchaseOrder("Canister Pump Filter", 2, "only 4 left in stock");
	    purchaseOrderRepository.save(purchaseOrder);
	    logger.info("added purchase order: {}", purchaseOrder);
	    purchaseOrder = new PurchaseOrder("Trickle Filter", 4, "please follow-up daily");
        purchaseOrderRepository.save(purchaseOrder);
        logger.info("added purchase order: {}", purchaseOrder);
    }

}
