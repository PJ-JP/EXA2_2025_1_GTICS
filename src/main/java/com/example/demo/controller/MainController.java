package com.example.demo.controller;
import com.example.demo.entity.Juegos;
import com.example.demo.repository.JuegosRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/orders")
public class MainController {
    @Autowired
    private JuegosRepository juegosRepository;

    //LISTAR
    @GetMapping(value = {"/list", ""})
    public ResponseEntity<HashMap<String, Object>> listaJuegos() {
        //Change access modifier
        HashMap<String,Object> respuesta = new HashMap<>();
        respuesta.put("result", "success");
        respuesta.put("data", juegosRepository.findAll());
        return ResponseEntity.ok(respuesta);
        //return juegosRepository.findAll();
    }

    // CREAR
    @PostMapping(value = {"", "/"})
    public ResponseEntity<HashMap<String, Object>> guardarJuego(
            @RequestBody Juegos juego,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {

        HashMap<String, Object> responseJson = new HashMap<>();

        juegosRepository.save(juego);
        if (fetchId) {
            responseJson.put("id", juego.getId());
        }
        responseJson.put("result", "success");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseJson);
    }

    /* ACTUALIZAR
    @PutMapping(value = {"", "/"}, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<HashMap<String, Object>> actualizar(Product productRecibido) {

        HashMap<String, Object> rpta = new HashMap<>();

        if (productRecibido.getId() != null && productRecibido.getId() > 0) {

            Optional<Product> byId = productRepository.findById(productRecibido.getId());
            if (byId.isPresent()) {
                Product productFromDb = byId.get();

                if (productRecibido.getProductName() != null)
                    productFromDb.setProductName(productRecibido.getProductName());

                if (productRecibido.getUnitPrice() != null)
                    productFromDb.setUnitPrice(productRecibido.getUnitPrice());

                if (productRecibido.getUnitsInStock() != null)
                    productFromDb.setUnitsInStock(productRecibido.getUnitsInStock());

                if (productRecibido.getUnitsOnOrder() != null)
                    productFromDb.setUnitsOnOrder(productRecibido.getUnitsOnOrder());

                if (productRecibido.getSupplier() != null)
                    productFromDb.setSupplier(productRecibido.getSupplier());

                if (productRecibido.getCategory() != null)
                    productFromDb.setCategory(productRecibido.getCategory());

                if (productRecibido.getQuantityPerUnit() != null)
                    productFromDb.setQuantityPerUnit(productRecibido.getQuantityPerUnit());

                if (productRecibido.getReorderLevel() != null)
                    productFromDb.setReorderLevel(productRecibido.getReorderLevel());

                if (productRecibido.getDiscontinued() != null)
                    productFromDb.setDiscontinued(productRecibido.getDiscontinued());

                productRepository.save(productFromDb);
                rpta.put("result", "ok");
                return ResponseEntity.ok(rpta);
            } else {
                rpta.put("result", "error");
                rpta.put("msg", "El ID del producto enviado no existe");
                return ResponseEntity.badRequest().body(rpta);
            }
        } else {
            rpta.put("result", "error");
            rpta.put("msg", "debe enviar un producto con ID");
            return ResponseEntity.badRequest().body(rpta);
        }
    }*/

}
