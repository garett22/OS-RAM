import java.util.ArrayList;

public class RAND{
	ArrayList<Strona> ramki=new ArrayList<>();
	int size;
	// int zegar=0;
	int err=0; // licznik b��d�w stron

	RAND(int size){ // przeka� ile ramek ma by�
		this.size=size;
	}

	void wykonaj(int val){ // wykonaj odwo�anie, przeka� warto�� strony
		if(!ramki.contains(new Strona(val))){ // czy NIE zawiera?
			err++;
			if(ramki.size()==size) // zr�b miejsce
				ramki.remove(((int)Math.random()*size)-1); // usu� losow�
			ramki.add(new Strona(val,0)); // czas dodania nieistotny
		}
	}
}