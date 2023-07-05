package cat.itacademy.barcelonactiva.herediamarengo.agustina.s05.t01.n01.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.herediamarengo.agustina.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.herediamarengo.agustina.s05.t01.n01.model.services.SucursalService;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {
    
    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSucursal(@RequestBody SucursalDTO sucursalDTO) {
        sucursalService.addSucursal(sucursalDTO);
        return ResponseEntity.ok("Sucursal añadida exitosamente");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateSucursal(@RequestBody SucursalDTO sucursalDTO) {
        sucursalService.updateSucursal(sucursalDTO);
        return ResponseEntity.ok("Sucursal actualizada exitosamente");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSucursal(@PathVariable Integer id) {
        sucursalService.deleteSucursal(id);
        return ResponseEntity.ok("Sucursal eliminada exitosamente");
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<SucursalDTO> getSucursal(@PathVariable Integer id) {
        SucursalDTO sucursalDTO = sucursalService.getSucursal(id);
        return ResponseEntity.ok(sucursalDTO);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SucursalDTO>> getAllSucursales() {
        List<SucursalDTO> sucursales = sucursalService.getAllSucursales();
        return ResponseEntity.ok(sucursales);
    }
}
