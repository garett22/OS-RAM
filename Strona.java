public class Strona{
	int time=0; // czas dodania do ramki;
	int val=0; // id strony
	int bit=0; // bit odniesienia

	public Strona(int val){
		this.val=val;
	}
	
	public Strona(int val,int zegar){
		this(val);
		time=zegar;
	}
	
	public boolean equals(Strona s){
		return val==s.val;
	}
}
