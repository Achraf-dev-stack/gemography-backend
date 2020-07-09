package gemographybackend.demo;

import java.util.ArrayList;
import java.util.List;

public class LanguageStats {	
	
	private int number;
	private List<item> items;
	public LanguageStats()
	{
		number=0;
		items=new ArrayList<item>();
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public List<item> getItems() {
		return items;
	}
	public void setItems(List<item> items) {
		this.items = items;
	}
	public void addItem(item i) {
		items.add(i);
		number++;
	}
	@Override
	public String toString() {
		return "LanguageStats [number=" + number + ", items=\n" + items + "]";
	}

}
