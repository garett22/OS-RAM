import java.util.ArrayList;

public class ALRU{
	ArrayList<Strona> ramki=new ArrayList<>();
	int size;
	int err=0; // licznik błędów stron

	ALRU(int size){ // przekaż ile ramek ma być
		this.size=size;
	}

	void wykonaj(int val){ // wykonaj odwołanie, przekaż wartość strony
		if(!ramki.contains(new Strona(val))){ // czy NIE zawiera?
			err++;
			if(ramki.size()==size){ // zrób miejsce
				int i=0;
				while(ramki.get(i).bit==0)
					ramki.add(new Strona(ramki.remove(0).val,1));
				// bit==0 ? na koniec & bit=1 : wyjdź z pętli
				ramki.remove(i); // i usuń darmozjada
			}
			ramki.add(new Strona(val));
		} else{ // !!! jeśli jest, to użyj i przenieś na koniec
			ramki.remove(new Strona(val)); // usuń
			ramki.add(new Strona(val,0)); // i dodaj na koniec z bitem=0
		}
	}
}