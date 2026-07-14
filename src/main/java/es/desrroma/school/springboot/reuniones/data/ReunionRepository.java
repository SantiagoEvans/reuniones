package es.desrroma.school.springboot.reuniones.data;

import org.springframework.data.jpa.repository.JpaRepository;

import es.desrroma.school.springboot.reuniones.models.Reunion;

public interface ReunionRepository extends JpaRepository<Reunion, Long> {


}
