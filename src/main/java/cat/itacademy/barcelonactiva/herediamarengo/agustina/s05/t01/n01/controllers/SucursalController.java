package cat.itacademy.barcelonactiva.herediamarengo.agustina.s05.t01.n01.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cat.itacademy.barcelonactiva.herediamarengo.agustina.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.herediamarengo.agustina.s05.t01.n01.model.services.SucursalService;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
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

    @GetMapping(value = { "", "/" })
    public ModelAndView mostrarSucursales() {
        List<SucursalDTO> sucursales = sucursalService.getAllSucursales();
        ModelAndView modelAndView = new ModelAndView("sucursal");
        modelAndView.addObject("sucursales", sucursales);
        return modelAndView;
    }

    @GetMapping("/add")
    public String mostrarFormularioAgregar() {
        return "sucursal";
    }

    @PostMapping("/addForm")
    public ResponseEntity<?> addSucursalForm(@RequestParam String nombre, @RequestParam String pais) {
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setNombreSucursal(nombre);
        sucursalDTO.setPaisSucursal(pais);
        sucursalService.addSucursal(sucursalDTO);
        return ResponseEntity.ok("Sucursal añadida exitosamente");
    }


    @GetMapping("/update/{id}")
    public ModelAndView mostrarFormularioEditar(@PathVariable Integer id) {
        SucursalDTO sucursalDTO = sucursalService.getSucursal(id);
        ModelAndView modelAndView = new ModelAndView("sucursal");
        modelAndView.addObject("sucursal", sucursalDTO);
        return modelAndView;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizarSucursal(@PathVariable Integer id, @RequestParam String nombre,
            @RequestParam String pais) {
        SucursalDTO sucursalDTO = sucursalService.getSucursal(id);
        sucursalDTO.setNombreSucursal(nombre);
        sucursalDTO.setPaisSucursal(pais);
        sucursalService.updateSucursal(sucursalDTO);
        return ResponseEntity.ok("Sucursal actualizada exitosamente");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView mostrarConfirmacionEliminar(@PathVariable Integer id) {
        SucursalDTO sucursalDTO = sucursalService.getSucursal(id);
        ModelAndView modelAndView = new ModelAndView("sucursal");
        modelAndView.addObject("sucursal", sucursalDTO);
        return modelAndView;
    }

    @DeleteMapping("/deleteForm/{id}")
    public ResponseEntity<?> deleteSucursalForm(@PathVariable Integer id) {
        sucursalService.deleteSucursal(id);
        return ResponseEntity.ok("Sucursal eliminada exitosamente");
    }

    @GetMapping("/getOneForm/{id}")
    public ModelAndView mostrarDetalleSucursalForm(@PathVariable Integer id) {
        SucursalDTO sucursalDTO = sucursalService.getSucursal(id);
        ModelAndView modelAndView = new ModelAndView("sucursal");
        modelAndView.addObject("sucursal", sucursalDTO);
        return modelAndView;
    }

}