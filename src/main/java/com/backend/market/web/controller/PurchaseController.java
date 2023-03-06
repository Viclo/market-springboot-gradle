package com.backend.market.web.controller;

import com.backend.market.domain.Product;
import com.backend.market.domain.Purchase;
import com.backend.market.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {

  private final PurchaseService purchaseService;

  @GetMapping()
  @Operation(summary = "Get all purchases.", responses = {
      @ApiResponse(responseCode = "200", description = "Successful Operation.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Purchase.class)))}),
      @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content(schema = @Schema(hidden = true))),
      @ApiResponse(responseCode = "404", description = "Purchase not found.", content = @Content)
  })
  public ResponseEntity<List<Purchase>> getAll() {
    return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get a purchase by ID.", responses = {
      @ApiResponse(responseCode = "200", description = "Successful Operation.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class))),
      @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content(schema = @Schema(hidden = true))),
      @ApiResponse(responseCode = "404", description = "Purchase not found.", content = @Content)
  })
  public ResponseEntity<Purchase> getPurchase(@PathVariable("id") Long idPurchase) {
    return purchaseService.getPurchase(idPurchase)
        .map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/customer/{id}")
  @Operation(summary = "Get all purchases by customer.", responses = {
      @ApiResponse(responseCode = "200", description = "Successful Operation.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Purchase.class)))}),
      @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content(schema = @Schema(hidden = true))),
      @ApiResponse(responseCode = "404", description = "Customer not found.", content = @Content)
  })
  public ResponseEntity<List<Purchase>> getPurchasesByIdCustomer(@PathVariable("id") String idCustomer) {
    return purchaseService.getByCustomer(idCustomer)
        .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/date/{date}")
  @Operation(summary = "Get all purchases by date.", responses = {
      @ApiResponse(responseCode = "200", description = "Successful Operation.", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Purchase.class)))}),
      @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content(schema = @Schema(hidden = true))),
      @ApiResponse(responseCode = "404", description = "Date not found.", content = @Content)
  })
  public ResponseEntity<List<Purchase>> getPurchasesByDate(@PathVariable("date")LocalDateTime date) {
    return purchaseService.getByDate(date)
        .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping()
  @Operation(summary = "Add a purchase.", responses = {
      @ApiResponse(responseCode = "200", description = "Successful Operation.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Purchase.class))),
      @ApiResponse(responseCode = "403", description = "Access denied.", content = @Content(schema = @Schema(hidden = true))),
  })
  public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
    return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
  }
}
