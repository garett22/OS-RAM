import java.util.ArrayList;

public class OPT{
	ArrayList<Strona> ramki=new ArrayList<>();
	int size;
	int err=0; // licznik błędów stron
	ArrayList<Strona> wiedzaTajemna=new ArrayList<>();

	OPT(int size){ // przekaż ile ramek ma być
		this.size=size;
	}

	void wykonaj(int val){ // wykonaj odwołanie, przekaż wartość strony
		wiedzaTajemna.remove(0);
		if(!ramki.contains(new Strona(val))){ // czy NIE zawiera?
			err++;
			if(ramki.size()==size) // zrób miejsce
				ramki.remove(kandydat());
			ramki.add(new Strona(val));
		}
	}

	int kandydat(){ // daj stronę do której najdłużej nie będzie odwołania
		int index=0;
		int n=0;
		int k=0;
		for(int i=0;i<size;i++){
			k=-1;
			for(int j=0;j<wiedzaTajemna.size();j++){
				// nie działa indexOf, stąd pętla
				//System.out.println(i+" "+j);
				if(ramki.get(i).equals(wiedzaTajemna.get(j))){
					k=j;
					break;
				}}
			if(k==-1)
				return i;
			if(k>n){
				n=k;
				index=i;
			}
		}
		return index;
	}
}