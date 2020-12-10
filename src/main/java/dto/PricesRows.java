package dto;

public class PricesRows {
    public String subTotal;
    public String total;
    public String taxes;

    public PricesRows(String subTotal, String total, String taxes) {
        this.subTotal = subTotal;
        this.total = total;
        this.taxes= taxes;

    }

}
