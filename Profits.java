package application.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Profits {
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleIntegerProperty amount;
	private SimpleStringProperty date;
	private SimpleIntegerProperty freq;
	
	public Profits(int id, String name, int amount, String date, int freq) {
		this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.amount = new SimpleIntegerProperty(amount);
        this.date = new SimpleStringProperty(date);
        this.freq = new SimpleIntegerProperty(freq);
     
    }


	
	public int getId() {
		return id.get();
	}
	public void setId(int id) {
		this.id = new SimpleIntegerProperty(id);
	}



	public String getName() {
		return name.get();
	}
	

	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}

	public int getAmount() {
		return amount.get();
	}

	public void setAmount(int amount) {
		this.amount = new SimpleIntegerProperty(amount);
	}

	public String getDate() {
		return date.get();
	}

	public void setDate(String date) {
		this.date = new SimpleStringProperty(date);
	}

	public int getFreq() {
		return freq.get();
	}

	public void setFreq(int freq) {
		this.freq = new SimpleIntegerProperty(freq);
	}


}
