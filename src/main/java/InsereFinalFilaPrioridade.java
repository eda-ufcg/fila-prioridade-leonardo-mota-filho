import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		fila.add(new Pair(elemento,prioridade));
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		if(fila.isEmpty()){
			return "";
		} else{
			Pair max = new Pair("",-1);
			for(Pair i : fila){
				if(i.getPrioridade() > max.getPrioridade()){
					max = i;
				}
			}
			return max.getElemento();
		}

	}

}
