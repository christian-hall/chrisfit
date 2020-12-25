import java.time.LocalDate;

public class Entry {
	int id;
	LocalDate date;
	double weight;
	double recommendation;
	double calories;
	
	public Entry(int id, LocalDate date, double weight, double recommendation, double calories) {
		super();
		this.id = id;
		this.date = date;
		this.recommendation = recommendation;
		this.calories = calories;
	}
	
	public Entry() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(double recommendation) {
		this.recommendation = recommendation;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return id + " " + date + " " + weight + " " + recommendation + " " + calories;
				
	}
	
	
}
