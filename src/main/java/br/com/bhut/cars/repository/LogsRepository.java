package br.com.bhut.cars.repository;


import br.com.bhut.cars.entities.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsRepository extends JpaRepository<Logs, String> {


}
