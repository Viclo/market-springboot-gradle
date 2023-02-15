package com.backend.market.web.controller;

import com.backend.market.domain.Purchase;
import com.backend.market.domain.service.PurchaseService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

  @Autowired
  private PurchaseService purchaseService;

  @GetMapping()
  public ResponseEntity<List<Purchase>> getAll() {
    return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Purchase> getPurchase(@PathVariable("id") Long idPurchase) {
    return purchaseService.getPurchase(idPurchase)
        .map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/customer/{id}")
  public ResponseEntity<List<Purchase>> getPurchasesByIdCustomer(@PathVariable("id") String idCustomer) {
    return purchaseService.getByCustomer(idCustomer)
        .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/date/{date}")
  public ResponseEntity<List<Purchase>> getPurchasesByDate(@PathVariable("date")LocalDateTime date) {
    return purchaseService.getByDate(date)
        .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping()
  public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
    return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
  }
}
