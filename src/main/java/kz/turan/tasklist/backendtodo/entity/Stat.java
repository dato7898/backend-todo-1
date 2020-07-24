package kz.turan.tasklist.backendtodo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@EqualsAndHashCode
public class Stat {
    @Id
    private Long id;
    private Long completedTotal;
    private Long uncompletedTotal;
}
