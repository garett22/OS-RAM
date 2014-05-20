import java.util.ArrayList;

public class FIFO{
	ArrayList<Strona> ramki=new ArrayList<>();
	int size;
	int err=0; // licznik błędów stron

	FIFO(int size){ // przekaż ile ramek ma być
		this.size=size;
	}

	void wykonaj(int val){ // wykonaj odwołanie, przekaż wartość strony
		if(!ramki.contains(new Strona(val))){ // czy NIE zawiera?
			err++;
			if(ramki.size()==size) // zrób miejsce
				ramki.remove(0); // usuń stronę najwcześniej dodaną
			ramki.add(new Strona(val));
		}
	}
}