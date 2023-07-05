package cat.itacademy.barcelonactiva.herediamarengo.agustina.s05.t01.n01.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_SucursalID")
    private Integer pk_SucursalID;

    @Column(name = "nombreSucursal")
    private String nombreSucursal;

    @Column(name = "paisSucursal")
    private String paisSucursal;

    public Sucursal() {
    }

    public Sucursal(String nombreSucursal, String paisSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.paisSucursal = paisSucursal;
    }

    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }
}
