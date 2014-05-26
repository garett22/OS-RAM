import java.util.ArrayList;
import java.util.Scanner;

public class Main{

	public static void main(String[] args){
		ArrayList<Integer> arr=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Podaj liczbę ramek, odwołań i ich zakres");
		System.out.println("rekomendowane: 10 80 30");
		// zakres nie jest ograniczeniem, tylko stopniem rozrzutu
		int size=sc.nextInt();
		int n=sc.nextInt();
		int zakres=sc.nextInt();
		sc.close();

		RAND alg0=new RAND(size);
		FIFO alg1=new FIFO(size);
		LRU alg2=new LRU(size);
		ALRU alg3=new ALRU(size);
		OPT alg4=new OPT(size);

		arr.add(0); // program rozpoczyna się od początku było nie było
		for(int i=1;i<n;i++){
			// 90/9/1 lokalne/skoki-lokalne/skoki-globalne
			// tutaj dla wzbogacenia zrobiłem 70/25/5
			int rodzaj=(int)(Math.random()*100);
			if(rodzaj>10)
				arr.add(arr.get(i-1)+(int)(Math.random()*4)-1);
			// lokalne +[-1,2]
			else if(rodzaj>1)
				arr.add((int)(Math.random()*8)-3);
			// skok lokalny +[-3,+5]
			else
				arr.add((int)(Math.random()*zakres));
			// skok globalny
		}

		System.out.println("lista odwołań:");
		for(int i=0;i<arr.size();i++){
			alg4.wiedzaTajemna.add(new Strona(arr.get(i)));
			System.out.print(arr.get(i)+" ");
		}

		while(!arr.isEmpty()){
			alg0.wykonaj(arr.get(0));
			alg1.wykonaj(arr.get(0));
			alg2.wykonaj(arr.get(0));
			alg3.wykonaj(arr.get(0));
			alg4.wykonaj(arr.get(0));
			arr.remove(0);
		}

		System.out.println("\n\nBłędy strony:");
		System.out.println("RAND: "+alg0.err);
		System.out.println("FIFO: "+alg1.err);
		System.out.println("LRU: "+alg2.err);
		System.out.println("ALRU: "+alg3.err);
		System.out.println("OPT: "+alg4.err);
	}
}
