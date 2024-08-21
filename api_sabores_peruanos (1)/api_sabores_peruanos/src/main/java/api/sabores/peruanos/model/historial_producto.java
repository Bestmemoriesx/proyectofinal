package api.sabores.peruanos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity
public class historial_producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer historialId;

    @ManyToOne
    @JoinColumn(name = "productoId")
    private Producto Producto;

    private String cambio;
    private Timestamp fecha;
    
    // Getters y Setters
	public Integer getHistorialId() {
		return historialId;
	}
	public void setHistorialId(Integer historialId) {
		this.historialId = historialId;
	}
	public Producto getProductos() {
		return Producto;
	}
	public void setProductos(Producto Producto) {
		this.Producto = Producto;
	}
	public String getCambio() {
		return cambio;
	}
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
}
