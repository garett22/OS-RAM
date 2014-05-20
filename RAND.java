import java.util.ArrayList;

public class RAND{
	ArrayList<Strona> ramki=new ArrayList<>();
	int size;
	int err=0; // licznik błędów stron

	RAND(int size){ // przekaż ile ramek ma być
		this.size=size;
	}

	void wykonaj(int val){ // wykonaj odwołanie, przekaż wartość strony
		if(!ramki.contains(new Strona(val))){ // czy NIE zawiera?
			err++;
			if(ramki.size()==size) // zrób miejsce
				ramki.remove((int)(Math.random()*(size-1))); // usuń losową
			ramki.add(new Strona(val));
		}
	}
}