package entity;

import java.util.List;

/*
分页
 */
public class PageResult<T> {
    private Long total;
    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public List<T> getRows() {
        return rows;
    }
}
