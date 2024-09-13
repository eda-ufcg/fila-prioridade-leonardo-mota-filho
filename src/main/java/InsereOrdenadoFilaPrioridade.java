public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;
	private int size;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
		this.size = 0;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		last = (last+1)%fila.length;
		size++;
		fila[last] = new Pair(elemento, prioridade);
		int index = last;

		while(index != head && fila[index].getPrioridade() > fila[(index-1)%fila.length].getPrioridade()){
			Pair temp = fila[index];
			fila[index] = fila[(index-1)%fila.length];
			fila[(index-1)%fila.length] = temp;
		}
	}


	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		if(size == 0){
			return "";
		}
		String elem = fila[head].getElemento();
		head = (head+1)%fila.length;
		size--;
		if(size == 0){
			this.head = -1;
			this.last = -1;
		}
		return elem;
    }

}
