public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int tail;
	private int size;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.tail = -1;
		this.head = -1;
		this.size = 0;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		if(this.size == 0){
			head = 0;
		}
		this.size++;
		this.tail = (this.tail+1)%fila.length;
		this.fila[this.tail] = new Pair(elemento,prioridade);
		for(int i = 0;i<this.size-1;i++){
			if(fila[(tail-i-1+fila.length)%fila.length].getPrioridade() > fila[(tail-i+fila.length)%fila.length].getPrioridade()){
				break;
			}
			Pair temp = fila[(tail-i)%fila.length];
			fila[(tail-i)%fila.length] = fila[(tail-i-1)%fila.length];
			fila[(tail-i-1)%fila.length] = temp;
		}
	}


	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		if(this.size == 0){
			return "";
		}
		String elem = fila[head].getElemento();
		if(this.head == this.tail){
			this.head = -1;
			this.tail = -1;
		}
		this.head = (this.head+1)%fila.length;
		this.size--;
		return elem;
	}

}
