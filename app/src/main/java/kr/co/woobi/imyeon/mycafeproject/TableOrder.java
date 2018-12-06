package kr.co.woobi.imyeon.mycafeproject;

public class TableOrder {
    public String tablenum;
    public String order;
    public String total;

    public TableOrder(String tablenum, String order, String total) {
        this.tablenum = tablenum;
        this.order = order;
        this.total = total;
    }

    public String getTablenum() {
        return tablenum;
    }

    public void setTablenum(String tablenum) {
        this.tablenum = tablenum;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
