package lstruct;

//queue.java
//������ � ��������
//������ ���������: C>java QueueApp
////////////////////////////////////////////////////////////////
class Queue
{
private int maxSize;
private long[] queArray;
private int front;
private int rear;
private int nItems;
//--------------------------------------------------------------
public Queue(int s) // �����������
{
maxSize = s;
queArray = new long[maxSize];
front = 0;
rear = -1;
nItems = 0;
}
//--------------------------------------------------------------
public void insert(long j) // ������� �������� � ����� �������
{
if(rear == maxSize-1) // ����������� �������
rear = -1;
queArray[++rear] = j; // ���������� rear � �������
nItems++; // ���������� ���������� ���������
}
//--------------------------------------------------------------
public long remove() // ���������� �������� � ������ �������
{
long temp = queArray[front++]; // ������� � ���������� front
if(front == maxSize) // ����������� �������
front = 0;
nItems--; // ���������� ���������� ���������
return temp;
}
//--------------------------------------------------------------
public long peekFront() // ������ �������� � ������ �������
{
return queArray[front];
}
//--------------------------------------------------------------
public boolean isEmpty() // true, ���� ������� �����
{
return (nItems==0);
}
//--------------------------------------------------------------
public boolean isFull() // true, ���� ������� ���������

{
return (nItems==maxSize);
}
//--------------------------------------------------------------
public int size() // ���������� ��������� � �������
{
return nItems;
}
public static void main(String[] args)
{
Queue theQueue = new Queue(5); // ������� �� 5 �����
theQueue.insert(10); // ������� 4 ���������
theQueue.insert(20);
theQueue.insert(30);
theQueue.insert(40);
theQueue.remove(); // ���������� 3 ���������
theQueue.remove(); // (10, 20, 30)
theQueue.remove();
theQueue.insert(50); // ������� ��� 4 ���������
theQueue.insert(60); // (� ����������� ���������)
theQueue.insert(70);
theQueue.insert(80);
while( !theQueue.isEmpty() ) // ���������� � �����
{ // ���� ���������
long n = theQueue.remove(); // (40, 50, 60, 70, 80)
System.out.print(n);
System.out.print(" ");
}
System.out.println("");
}
//--------------------------------------------------------------
} // ����� ������ Queue
