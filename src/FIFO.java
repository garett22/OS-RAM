import java.util.ArrayList;

public class FIFO{
	ArrayList<Strona> ramki=new ArrayList<>();
	int size;
	// int zegar=0;
	int err=0; // licznik b��d�w stron

	FIFO(int size){ // przeka� ile ramek ma by�
		this.size=size;
	}

	void wykonaj(int val){ // wykonaj odwo�anie, przeka� warto�� strony
		if(!ramki.contains(new Strona(val))){ // czy NIE zawiera?
			err++;
			if(ramki.size()==size) // zr�b miejsce
				ramki.remove(0); // usu� najwcze�niej dodan�
			ramki.add(new Strona(val,0)); // czas dodania nieistotny
		}
	}
}