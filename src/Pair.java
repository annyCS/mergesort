
public class Pair implements Comparable<Pair>{
	private String name;
	private int score;
	
	public Pair(String n, int s){
		name = n;
		score = s;
	}
	
	public String getName(){
		return name;
	}
	
	public int getScore(){
		return score;
	}

	@Override
	public int compareTo(Pair pair) {
		if(this.score < pair.getScore()) return -1;
		if(this.score > pair.getScore()) return 1;
		else return 0;
	}
}
