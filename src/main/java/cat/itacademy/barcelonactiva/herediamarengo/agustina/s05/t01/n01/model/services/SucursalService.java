package cat.itacademy.barcelonactiva.herediamarengo.agustina.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.herediamarengo.agustina.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.herediamarengo.agustina.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.herediamarengo.agustina.s05.t01.n01.model.repository.SucursalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    private final SucursalRepository sucursalRepository;

    @Autowired
    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    public SucursalDTO convertToDto(Sucursal sucursal) {
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
        sucursalDTO.setNombreSucursal(sucursal.getNombreSucursal());
        sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
        sucursalDTO.setTipoSucursal(getTipoSucursal(sucursal.getPaisSucursal()));
        sucursalDTO.setPaises(getPaisesUE());
        return sucursalDTO;
    }

    public Sucursal convertToEntity(SucursalDTO sucursalDTO) {
        Sucursal sucursal = new Sucursal();
        sucursal.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
        sucursal.setNombreSucursal(sucursalDTO.getNombreSucursal());
        sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
        return sucursal;
    }

    private String getTipoSucursal(String pais) {
        // Lista de países que forman parte de la Unión Europea (UE)
        String[] paisesUE = {"Austria", "Bélgica", "Bulgaria", "Chipre", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia",
                "España", "Estonia", "Finlandia", "Francia", "Grecia", "Hungría", "Irlanda", "Italia", "Letonia",
                "Lituania", "Luxemburgo", "Malta", "Países Bajos", "Polonia", "Portugal", "República Checa",
                "Rumanía", "Suecia"};

        for (String paisUE : paisesUE) {
            if (paisUE.equalsIgnoreCase(pais)) {
                return "UE";
            }
        }
        return "Fuera UE";
    }

    private List<String> getPaisesUE() {
        // Lista de países que forman parte de la Unión Europea (UE)
        return List.of("Austria", "Bélgica", "Bulgaria", "Chipre", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia",
                "España", "Estonia", "Finlandia", "Francia", "Grecia", "Hungría", "Irlanda", "Italia", "Letonia",
                "Lituania", "Luxemburgo", "Malta", "Países Bajos", "Polonia", "Portugal", "República Checa",
                "Rumanía", "Suecia");
    }

    public SucursalDTO addSucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal = convertToEntity(sucursalDTO);
        Sucursal savedSucursal = sucursalRepository.save(sucursal);
        return convertToDto(savedSucursal);
    }

    public SucursalDTO updateSucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal = convertToEntity(sucursalDTO);
        Sucursal updatedSucursal = sucursalRepository.save(sucursal);
        return convertToDto(updatedSucursal);
    }

    public void deleteSucursal(Integer id) {
        sucursalRepository.deleteById(id);
    }

    public SucursalDTO getSucursal(Integer id) {
        Optional<Sucursal> optionalSucursal = sucursalRepository.findById(id);
        if (optionalSucursal.isPresent()) {
            Sucursal sucursal = optionalSucursal.get();
            return convertToDto(sucursal);
        }
        return null;
    }

    public List<SucursalDTO> getAllSucursales() {
        List<Sucursal> sucursales = sucursalRepository.findAll();
        List<SucursalDTO> sucursalDTOs = new ArrayList<>();
        for (Sucursal sucursal : sucursales) {
            SucursalDTO sucursalDTO = convertToDto(sucursal);
            sucursalDTOs.add(sucursalDTO);
        }
        return sucursalDTOs;
    }
}


