import java.util.ArrayList;

public class FIFO{
	ArrayList<Strona> ramki=new ArrayList<>();
	int size;
	// int zegar=0;
	int err=0; // licznik b³êdów stron

	FIFO(int size){ // przeka¿ ile ramek ma byæ
		this.size=size;
	}

	void wykonaj(int val){ // wykonaj odwo³anie, przeka¿ wartoœæ strony
		if(!ramki.contains(new Strona(val))){ // czy NIE zawiera?
			err++;
			if(ramki.size()==size) // zrób miejsce
				ramki.remove(0); // usuñ najwczeœniej dodan¹
			ramki.add(new Strona(val,0)); // czas dodania nieistotny
		}
	}
}