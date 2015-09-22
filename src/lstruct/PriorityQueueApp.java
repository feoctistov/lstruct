package lstruct;

import static java.lang.Math.*;

import java.util.Random;

public class PriorityQueueApp {
	class Link{
		Link(int iData){
			this.next = null;
			this.iData = iData;
		}
		Link next;
		int iData;
		
	}
	class OrderedLinkList{
		Link first;
		
		public void insert(Link link){
			if(first == null){
				first = link;
			}else if(first.iData > link.iData){
				link.next = first;
				first = link;
			}else{
				Link current = first;
				Link prev = null;
				while(current != null && current.iData < link.iData){
					prev = current;
					current = current.next;
				}
				if(prev != null) prev.next = link;
				if(current != null) link.next = current;
			}
		}
		public Link deleteFirst(){
			Link temp = first;
			first = temp.next;
			return temp;
		}
		
		public void reset(){
			first = null;
		}
		
		public boolean isEmpty(){
			return first == null;
		}
		
		public void display(){
			Link current = first;
			while(current != null){
				System.out.print("["+current.iData+"] ");
				current = current.next;
			}
			System.out.println();
		}
		
	}
	class PriorityQueue{
		PriorityQueue(OrderedLinkList olList){
			this.olList = olList;
		}
		private OrderedLinkList olList;
		public void insert(Link link){
			olList.insert(link);
		}
		public Link remove(){
			if(olList.isEmpty())
				return null;
			else
				return olList.deleteFirst();
		}
		public void display(){
			olList.display();
		}
		public boolean isEmpty(){
			return olList.isEmpty();
		}
	}

	public static void main(String[] args) {
		PriorityQueueApp app = new PriorityQueueApp();
		OrderedLinkList olList = app.new OrderedLinkList();
		for(int i=0; i<10; i++){
			int n = new Random().nextInt(99);
			olList.insert(app.new Link(n));
			//System.out.println(n);
		}
		olList.display();
		PriorityQueue queue = app.new PriorityQueue(olList);
		queue.insert(app.new Link(99));
		queue.insert(app.new Link(1));
		queue.display();
		System.out.println("removing...");
		while(!queue.isEmpty()){
			System.out.println(queue.remove().iData);
		}
		
		
	}

}
