package model.SQLserver;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produktuak database table.
 * 
 */
@Entity
@NamedQuery(name="Produktuak.findAll", query="SELECT p FROM Produktuak p")
public class Produktuak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int bolumena;

	private String deskripzioa;

	private String izena;

	private int pisua;

	private int prezioa;

	//bi-directional many-to-one association to Erosketak
	@OneToMany(mappedBy="produktuak")
	private List<Erosketak> erosketaks;

	public Produktuak() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBolumena() {
		return this.bolumena;
	}

	public void setBolumena(int bolumena) {
		this.bolumena = bolumena;
	}

	public String getDeskripzioa() {
		return this.deskripzioa;
	}

	public void setDeskripzioa(String deskripzioa) {
		this.deskripzioa = deskripzioa;
	}

	public String getIzena() {
		return this.izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public int getPisua() {
		return this.pisua;
	}

	public void setPisua(int pisua) {
		this.pisua = pisua;
	}

	public int getPrezioa() {
		return this.prezioa;
	}

	public void setPrezioa(int prezioa) {
		this.prezioa = prezioa;
	}

	public List<Erosketak> getErosketaks() {
		return this.erosketaks;
	}

	public void setErosketaks(List<Erosketak> erosketaks) {
		this.erosketaks = erosketaks;
	}

	public Erosketak addErosketak(Erosketak erosketak) {
		getErosketaks().add(erosketak);
		erosketak.setProduktuak(this);

		return erosketak;
	}

	public Erosketak removeErosketak(Erosketak erosketak) {
		getErosketaks().remove(erosketak);
		erosketak.setProduktuak(null);

		return erosketak;
	}

}