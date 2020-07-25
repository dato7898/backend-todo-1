package kz.turan.tasklist.backendtodo.to;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskTo {
    private String text;
    private Integer completed;
    private Long priorityId;
    private Long categoryId;
    // постраничность
    private Integer pageNumber;
    private Integer pageSize;
    // сортировка
    private String sortColumn;
    private String sortDirection;
}
