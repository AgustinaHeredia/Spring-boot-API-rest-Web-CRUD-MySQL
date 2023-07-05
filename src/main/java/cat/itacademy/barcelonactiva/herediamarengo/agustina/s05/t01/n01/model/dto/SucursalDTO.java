package cat.itacademy.barcelonactiva.herediamarengo.agustina.s05.t01.n01.model.dto;

import java.util.List;
import java.util.ArrayList;


import cat.itacademy.barcelonactiva.herediamarengo.agustina.s05.t01.n01.model.domain.Sucursal;

public class SucursalDTO extends Sucursal {
    private String tipoSucursal;
    private List<String> paises;

    public SucursalDTO() {
        super();
        this.paises = new ArrayList<>();
    }

    public SucursalDTO(String nombreSucursal, String paisSucursal, String tipoSucursal, List<String> paises) {
        super(nombreSucursal, paisSucursal);
        this.tipoSucursal = tipoSucursal;
        this.paises = paises;
    }

    public String getTipoSucursal() {
        return tipoSucursal;
    }

    public void setTipoSucursal(String tipoSucursal) {
        this.tipoSucursal = tipoSucursal;
    }

    public List<String> getPaises() {
        return paises;
    }

    public void setPaises(List<String> list) {
        this.paises = list;
    }
}
