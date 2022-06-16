package ec.edu.espe.arquitectura.escolastico.seguridad.service;


import ec.edu.espe.arquitectura.escolastico.seguridad.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.FuncionalidadRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.PerfilFuncionalidadRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.PerfilRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.NoEncontradoException;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionalidadService {
    private final FuncionalidadRepository funcionalidadRepository;

    private final PerfilFuncionalidadRepository perfilFuncionalidadRepository;

    private final PerfilRepository perfilRepository;

    private final UsuarioRepository usuarioRepository;

    public Funcionalidad obtenerPorCodigo(Integer codigo) {
        Optional<Funcionalidad> funcionalidadOpt = this.funcionalidadRepository.findById(codigo);
        if (funcionalidadOpt.isPresent()) {
            return funcionalidadOpt.get();
        } else {
            return null;
        }
    }

    public List<Funcionalidad> obtenerPorModuloYEstado(String modulo, String estado){
        return this.funcionalidadRepository.findByCodModuloAndEstado(modulo,estado);
    }
    public List<Funcionalidad> obtenerPorEstado(){
        return this.funcionalidadRepository.findByEstado(EstadosEnum.ACTIVO.getValor());
    }


    public void crear(Funcionalidad funcionalidad) {
        funcionalidad.setEstado(EstadosEnum.INACTIVO.getValor());
        this.funcionalidadRepository.save(funcionalidad);

    }
    public void modificar(Funcionalidad funcionalidad) {
        Funcionalidad funcionalidadBD = this.obtenerPorCodigo(funcionalidad.getCodFuncionalidad());
        funcionalidadBD.setNombre(funcionalidad.getNombre());
        funcionalidadBD.setEstado(funcionalidad.getEstado());
        this.funcionalidadRepository.save(funcionalidadBD);
    }
    public void asignarFuncionalidad(String codPerfil, String mailAud, Integer codFuncionalidad) throws UnknownHostException {

        Usuario usuarioAud = this.usuarioRepository.findByMail(mailAud);
        String ip = InetAddress.getLocalHost().getHostAddress();
        PerfilFuncionalidad perfilFuncionalidadTmp = new PerfilFuncionalidad();
        PerfilFuncionalidadPK perfilFuncionalidadPK = new PerfilFuncionalidadPK();



        Funcionalidad funcionalidad = this.funcionalidadRepository.findByCodFuncionalidadAndEstado(codFuncionalidad,EstadosEnum.ACTIVO.getValor())
                .orElseThrow(() -> new NoEncontradoException("La funcionalidad no esta Activa"));


        perfilFuncionalidadPK.setCodFuncionalidad(funcionalidad.getCodFuncionalidad());
        perfilFuncionalidadPK.setCodPerfil(codPerfil);

        perfilFuncionalidadTmp.setPerfilFuncionalidadPK(perfilFuncionalidadPK);
        perfilFuncionalidadTmp.setAudUsuario(usuarioAud.getCodUsuario());
        perfilFuncionalidadTmp.setVersion(0);
        perfilFuncionalidadTmp.setAudFecha(new Date());
        perfilFuncionalidadTmp.setAudIp(ip);


        this.perfilFuncionalidadRepository.save(perfilFuncionalidadTmp);


    }



}
