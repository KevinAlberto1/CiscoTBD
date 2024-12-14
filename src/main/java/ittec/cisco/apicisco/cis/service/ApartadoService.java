package ittec.cisco.apicisco.cis.service;

import org.springframework.stereotype.Service;
import ittec.cisco.apicisco.cis.model.Apartado;
import ittec.cisco.apicisco.cis.repository.ApartadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApartadoService {

    private final ApartadoRepository apartadoRepository;

    public ApartadoService(ApartadoRepository apartadoRepository) {
        this.apartadoRepository = apartadoRepository;
    }

    public List<Apartado> findAll() {
        return (List<Apartado>) apartadoRepository.findAll();
    }

    public Optional<Apartado> findById(Integer id) {
        return apartadoRepository.findById(id);
    }

    public Apartado save(Apartado apartado) {
        return apartadoRepository.save(apartado);
    }

    public void deleteById(Integer id) {
        apartadoRepository.deleteById(id);
    }
}
