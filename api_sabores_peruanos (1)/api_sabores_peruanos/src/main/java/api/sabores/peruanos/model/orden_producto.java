package api.sabores.peruanos.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class orden_producto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordenId;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private cliente cliente;

    @ManyToOne
    @JoinColumn(name = "productoId")
    private Producto Producto;

    private Integer cantidad;
    private Date fecha;
    
    // Getters y Setters
	public Integer getOrdenId() {
		return ordenId;
	}
	public void setOrdenId(Integer ordenId) {
		this.ordenId = ordenId;
	}
	public cliente getCliente() {
		return cliente;
	}
	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}
	public Producto getProductos() {
		return Producto;
	}
	public void setProductos(Producto Producto) {
		this.Producto = Producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}