package api.sabores.peruanos.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class notificacion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificacionId;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private cliente cliente;

    private String mensaje;
    private Timestamp fecha;
    
    // Getters y Setters
	public Integer getNotificacionId() {
		return notificacionId;
	}
	public void setNotificacionId(Integer notificacionId) {
		this.notificacionId = notificacionId;
	}
	public cliente getCliente() {
		return cliente;
	}
	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
}
