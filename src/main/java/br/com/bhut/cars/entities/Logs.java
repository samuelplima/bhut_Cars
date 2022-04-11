package br.com.bhut.cars.entities;

import br.com.bhut.cars.dto.LogsDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)

@Entity
@Table(name = "LOGS")
public class Logs {

    public Logs(LogsDTO logsDTO) {
    }

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "ID", nullable = false)
    private String id;

    @Column
    private Date data_hora;

    @Column
    private String car_id;


}
