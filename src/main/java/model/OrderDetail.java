package model;

public class OrderDetail {

	private int id_od;
	private int id_c;
	private int id_p;
	private int pieces;
	
	public OrderDetail(int id_od, int id_c, int id_p, int pieces) {
		super();
		this.id_od = id_od;
		this.id_c = id_c;
		this.id_p = id_p;
		this.pieces = pieces;
	}
	public int getId_od() {
		return id_od;
	}
	public void setId_od(int id_od) {
		this.id_od = id_od;
	}
	public int getId_c() {
		return id_c;
	}
	public void setId_c(int id_c) {
		this.id_c = id_c;
	}
	public int getId_p() {
		return id_p;
	}
	public void setId_p(int id_p) {
		this.id_p = id_p;
	}
	public int getPieces() {
		return pieces;
	}
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	@Override
	public String toString() {
		//return "OrderDetail [id_od=" + id_od + ", id_c=" + id_c + ", id_p=" + id_p + ", pieces=" + pieces + "]";
		return ("Order_number: "+id_od+ "\r\nClient_id: "+id_c+"\r\nProduct_id: "+id_p+"\r\nNumber of pieces: "+pieces);
	}
	
	
}
