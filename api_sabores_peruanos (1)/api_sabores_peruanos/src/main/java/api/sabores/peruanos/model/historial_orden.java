package api.sabores.peruanos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity
public class historial_orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer historialId;

    @ManyToOne
    @JoinColumn(name = "ordenId")
    private orden_producto orden;

    private String estado;
    private Timestamp fecha;
    
    // Getters y Setters
	public Integer getHistorialId() {
		return historialId;
	}
	public void setHistorialId(Integer historialId) {
		this.historialId = historialId;
	}
	public orden_producto getOrden() {
		return orden;
	}
	public void setOrden(orden_producto orden) {
		this.orden = orden;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
}
