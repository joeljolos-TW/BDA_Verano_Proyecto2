/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRUEBAS;


import DTOs.AlumnoDTO;
import DTOs.BloqueoDTO;
import DTOs.CentroLaboratorioDTO;
import DTOs.ComputadoraDTO;
import DTOs.ReservaDTO;
import DTOs.SoftwareDTO;
import Dominio.AlumnoDominio;
import Dominio.BloqueoDominio;
import Dominio.CarreraDominio;
import Dominio.CentroLaboratorioDominio;
import Dominio.ComputadoraDominio;
import Dominio.ReservaDominio;
import Dominio.SoftwareDominio;
import Dominio.UnidadDominio;
import Enumeradores.EstadosAlumno;
import Enumeradores.EstadosComputadora;
import Negocio.AlumnoNegocio;
import Negocio.BloqueoNegocio;
import Negocio.CentroLaboratorioNegocio;
import Negocio.ComputadorasNegocio;
import Negocio.ReservasNegocio;
import Negocio.SoftwareNegocio;
import NegocioException.NegocioException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class MainAlumno {

    public static void main(String[] args) {
        try {
            // ALUMNO
            AlumnoNegocio alumnoNegocio = new AlumnoNegocio();

            CarreraDominio carrera = new CarreraDominio();
            carrera.setId(1L);
            carrera.setNombre("Ingeniería en Software");
            carrera.setTiempoLimite(3.5f);

            AlumnoDTO alumno = new AlumnoDTO();
            alumno.setNombre("Andrea");
            alumno.setApellidoPaterno("Montoya");
            alumno.setApellidoMaterno("Guzmán");
            alumno.setEstado(EstadosAlumno.ESTUDIANDO);
            alumno.setContraseña("secreta456");
            alumno.setCarrera(carrera);

            AlumnoDominio registrado = alumnoNegocio.registrar(alumno);
            AlumnoDominio buscadoPorId = alumnoNegocio.buscarPorId(registrado.getId().intValue());
            AlumnoDominio buscadoPorDTO = alumnoNegocio.buscar(alumno);
            AlumnoDominio actualizado = alumnoNegocio.actualizar(alumno);

            // BLOQUEO
            BloqueoNegocio bloqueoNegocio = new BloqueoNegocio();

            BloqueoDTO bloqueo = new BloqueoDTO();
            bloqueo.setFechaInicio(new Date());
            bloqueo.setFechaFin(new Date(System.currentTimeMillis() + 86400000));
            bloqueo.setMotivo("Conducta inapropiada en el laboratorio");
            bloqueo.setAlumno(alumno.getDominio());

            BloqueoDominio nuevoBloqueo = bloqueoNegocio.registrarBloqueo(bloqueo);
            BloqueoDominio bloqueoPorId = bloqueoNegocio.buscarBloqueoPorId(nuevoBloqueo.getId().intValue());
            BloqueoDominio bloqueoPorDTO = bloqueoNegocio.buscarBloqueo(bloqueo);
                    
//List<BloqueoDominio> bloqueosDelAlumno = bloqueoNegocio.buscarBloqueosDeAlumno(alumno.getDominio().getId().intValue());

            // CENTRO DE LABORATORIO
            CentroLaboratorioNegocio centroNegocio = new CentroLaboratorioNegocio();

            UnidadDominio unidad = new UnidadDominio();
            unidad.setId(1L);
            unidad.setNombre("Unidad Nainari");

            CentroLaboratorioDTO centro = new CentroLaboratorioDTO();
            centro.setNombre("LAB C-201");
            centro.setContraseñaMaster("admin987");
            centro.setFechaInicio(new Date());
            centro.setFechaFin(new Date(System.currentTimeMillis() + 3600000));
            centro.setUnidad(unidad);

            CentroLaboratorioDominio centroRegistrado = centroNegocio.registrarCentro(centro);
            Long totalComputadoras = centroNegocio.totalComputadorasEnCentro(centroRegistrado);
            List<CentroLaboratorioDominio> centrosPorUnidad = centroNegocio.buscarCentrosPorUnidad(unidad.getId().intValue());

            // COMPUTADORA
            ComputadorasNegocio computadoraNegocio = new ComputadorasNegocio();

            ComputadoraDTO compu = new ComputadoraDTO();
            compu.setDireccionIP("192.168.0.99");
            compu.setNumMaquina(9);
            compu.setEstado(EstadosComputadora.DISPONIBLE);
            

            ComputadoraDominio compuRegistrada = computadoraNegocio.registrarComputadora(compu);
            List<ComputadoraDominio> activas = computadoraNegocio.buscarComputadorasActivas();
            List<ComputadoraDominio> inactivas = computadoraNegocio.buscarComputadorasInactivas();
            ComputadoraDominio compuPorId = computadoraNegocio.buscarComputadoraPorId(compuRegistrada.getId().intValue());
            ComputadoraDominio compuPorDTO = computadoraNegocio.buscarComputadora(compu);
            List<SoftwareDominio> softwaresInstalados = computadoraNegocio.obtenerSoftwareEnComputadora(compuRegistrada.getId().intValue());

            // RESERVA
            ReservasNegocio reservaNegocio = new ReservasNegocio();

            ReservaDTO reserva = new ReservaDTO();
            reserva.setFechaHoraInicio(new Date());
            reserva.setFechaHoraFin(new Date(System.currentTimeMillis() + 7200000));
            reserva.setAlumno(alumno.getDominio());
            reserva.setComputadora(compu.getDominio());

            ReservaDominio reservaHecha = reservaNegocio.registrarReserva(reserva);
            ReservaDominio reservaPorId = reservaNegocio.buscarReservaPorId(reservaHecha.getId().intValue());
            ReservaDominio reservaPorDTO = reservaNegocio.buscarReserva(reserva);
            List<ReservaDominio> reservasCompu = reservaNegocio.buscarReservasPorComputadora(compu);

            // SOFTWARE
            SoftwareNegocio softwareNegocio = new SoftwareNegocio();

            SoftwareDTO software = new SoftwareDTO();
            software.setNombre("Eclipse IDE");

            SoftwareDominio softwareGuardado = softwareNegocio.registrarSoftware(software);
            SoftwareDominio softwarePorDTO = softwareNegocio.buscarSoftware(software);
            SoftwareDominio softwarePorId = softwareNegocio.buscarSoftwarePorId(softwareGuardado.getId().intValue());
            List<ComputadoraDominio> computadorasConSoftware = softwareNegocio.obtenerComputadorasConSoftware(softwareGuardado.getId().intValue());

            // 🎉 RESULTADO GLOBAL
            System.out.println("✔️ Todos los métodos fueron invocados correctamente.");

        } catch (NegocioException e) {
            System.err.println("❌ Ocurrió un error de negocio: " + e.getMessage());
        } catch (Exception ex) {
            System.err.println("❗ Error inesperado: " + ex.getMessage());
        }
    }
}

