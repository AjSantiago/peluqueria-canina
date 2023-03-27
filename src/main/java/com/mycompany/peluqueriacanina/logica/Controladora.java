package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();

    public void guardar(String nombreMascota, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
        Duenio duenio = new Duenio();
        duenio.setNombreDuenio(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        Mascota mascota = new Mascota();
        mascota.setNombre(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencion_especial(atenEsp);
        mascota.setObservaciones(observaciones);
        mascota.setUnDuenio(duenio);
        
        controlPersistencia.guardar(duenio, mascota);
    }

    public List<Mascota> traerMascotas() {
        return controlPersistencia.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersistencia.borrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersistencia.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota mascota, String nombreMascota, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
        mascota.setNombre(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setObservaciones(observaciones);
        mascota.setAlergico(alergico);
        mascota.setAtencion_especial(atenEsp);
        
        controlPersistencia.modificarMascota(mascota);
        
        Duenio duenio = this.buscarDuenio(mascota.getUnDuenio().getId_duenio());
        duenio.setNombreDuenio(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        this.modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersistencia.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersistencia.modificarDuenio(duenio);
    }
    
}
