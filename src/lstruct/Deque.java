package lstruct;

public class Deque {
	int nElems; //текущее кол-во элементов
	int maxNum; //максимальный размер дека
	DoubleLinkedList dlList;
	Deque(int maxNum){
		dlList = new DoubleLinkedList();
		nElems = 0;
		this.maxNum = maxNum;
	}
	public void insertLeft(int data){
		dlList.insertFirst(data);
		nElems++;
	}
	public void insertRight(int data){
		dlList.insertLast(data);
		nElems++;
	}
	public int removeLeft(){
		int iData = dlList.deleteFirst();
		nElems--;
		return iData;
	}
	
	public int removeRight(){
		int iData = dlList.deleteLast();
		nElems--;
		return iData;
	}
	
	public boolean isFull(){
		return nElems>=maxNum;
	}
	
	public boolean isEmpty(){
		return dlList.isEmpty();
	}
	
	
	
	
	//Двусвязный двусторонний список
	class DoubleLinkedList{
		Link first;
		Link last;
		DoubleLinkedList(){
			first = last = null;
		}
		public void insertFirst(int data){
			Link newFirst = new Link(data);
			newFirst.next = first;
			if(isEmpty()){
				last = newFirst;
			}else{
				newFirst.next = first;
				first.prev = newFirst;
			}
			first = newFirst;
		}
		public void insertLast(int data){
			Link newLast = new Link(data);
			if(isEmpty()){
				first = newLast;
			}else{
				newLast.prev = last;
				last.next = newLast;
			}
			last = newLast;
		}
		
		public int deleteFirst(){
			Link temp = first;
			first = temp.next;
			return temp.iData;
		}
		public int deleteLast(){
			Link temp = last;
			last = temp.prev;
			if(last == null) first = null;
			return temp.iData;			
		}
		
		public boolean isEmpty(){
			return first == null;
		}
	}
	
	class Link{
		Link(int iData){
			this.iData = iData;
		}
		Link prev;
		Link next;
		int iData;
	}

	public static void main(String[] args) {
		Deque deque = new Deque(10);
		deque.insertLeft(10);
		deque.insertLeft(20);
		deque.insertLeft(30);
		deque.insertLeft(100);
		deque.insertLeft(200);
		deque.insertLeft(300);
		while(!deque.isEmpty()){
			System.out.print("["+deque.removeRight()+"] ");
		}

	}

}
