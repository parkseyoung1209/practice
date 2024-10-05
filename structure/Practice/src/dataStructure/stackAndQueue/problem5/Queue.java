package dataStructure.stackAndQueue.problem5;
/*
 * 큐(Queue)는 **선입선출(FIFO, First In First Out)** 원칙을 따르는 자료 구조로, 가장 먼저 삽입된 데이터가 가장 먼저 제거되는 방식입니다. 큐는 일상에서 줄을 서서 기다리는 상황과 비슷하게 동작하며, 먼저 들어온 데이터가 먼저 나가는 형식입니다. 주로 데이터 처리, 네트워크 트래픽 관리, CPU 작업 스케줄링 등 다양한 분야에서 사용됩니다.

### 큐의 기본 개념
큐는 **삽입**과 **삭제**를 각각 다른 끝에서 수행하는 자료 구조입니다. 삽입은 큐의 **뒤(rear)**에서 이루어지고, 삭제는 큐의 **앞(front)**에서 이루어집니다.

1. **enqueue(item)**: 큐의 뒤에 새로운 데이터를 추가하는 연산입니다.
   - 데이터를 큐의 끝부분에 추가하며, 큐가 가득 찼을 경우에는 **오버플로우(overflow)** 오류가 발생할 수 있습니다.

2. **dequeue()**: 큐의 앞에 있는 데이터를 제거하고 반환하는 연산입니다.
   - 큐가 비어 있을 때 `dequeue` 연산을 시도하면 **언더플로우(underflow)** 오류가 발생합니다.

3. **peek()**: 큐의 앞에 있는 데이터를 제거하지 않고 확인하는 연산입니다.
   - 데이터를 제거하지 않으며, 큐가 비어 있는 경우에는 예외가 발생할 수 있습니다.

4. **isEmpty()**: 큐가 비어 있는지 확인하는 연산입니다.
   - 큐가 비어 있으면 `true`, 그렇지 않으면 `false`를 반환합니다.

5. **isFull()** (배열 기반 큐에서 사용): 큐가 가득 찼는지 확인하는 연산입니다. 

---

### 큐의 동작 원리
**큐(Queue)**는 두 개의 포인터, 즉 front와 rear 포인터를 사용하여 데이터를 관리합니다. 이 두 포인터는 각각 큐에서 데이터를 삽입하고 제거할 위치를 추적하는 역할을 합니다.

큐의 포인터 역할
front 포인터:
큐에서 데이터를 제거할 위치를 가리킵니다.
dequeue 연산(데이터 제거)을 할 때, front가 가리키는 위치에서 데이터를 제거하고, 제거 후에는 front가 다음 위치로 이동합니다.
rear 포인터:
큐에서 데이터를 삽입할 위치를 가리킵니다.
enqueue 연산(데이터 삽입)을 할 때, rear가 가리키는 위치에 데이터를 삽입하고, 삽입 후에는 rear가 다음 위치로 이동합니다.
큐의 동작 예시:
큐는 선입선출(FIFO, First In First Out) 원칙을 따르기 때문에, 먼저 들어온 데이터가 먼저 나가야 합니다. 이때 front와 rear 두 포인터를 이용해 데이터를 삽입하거나 제거할 위치를 추적합니다.

1. **큐에 데이터 추가 (enqueue)**  
   ```
   큐: []
   enqueue(1)
   큐: [1]
   enqueue(2)
   큐: [1, 2]
   enqueue(3)
   큐: [1, 2, 3]
   ```

2. **큐에서 데이터 제거 (dequeue)**  
   ```
   큐: [1, 2, 3]
   dequeue() -> 1 반환
   큐: [2, 3]
   dequeue() -> 2 반환
   큐: [3]
   ```

3. **큐에서 데이터 확인 (peek)**  
   ```
   큐: [3, 4, 5]
   peek() -> 3 반환 (큐 상태는 변하지 않음: [3, 4, 5])
   ```

---

### 큐의 구현 방식

큐는 주로 두 가지 방식으로 구현됩니다.

#### 1. **배열 기반 큐**
   - **고정 크기의 배열**을 사용하여 큐를 구현하며, 큐의 앞과 뒤를 추적하는 변수가 필요합니다. 하지만 데이터를 제거할 때마다 나머지 데이터를 앞으로 이동시켜야 하기 때문에 **효율성이 떨어질 수 있습니다.**
   
   - 이를 보완한 방식으로 **원형 큐(Circular Queue)**가 있습니다. 원형 큐에서는 배열의 처음과 끝이 연결되어 있어 데이터를 제거할 때 배열 내에서 이동할 필요가 없으며, 메모리를 효율적으로 사용할 수 있습니다.

   ```java
   class Queue {
       private int[] queue;
       private int front, rear, capacity;

       public Queue(int size) {
           queue = new int[size];
           capacity = size;
           front = 0;
           rear = -1;
       }

       public void enqueue(int item) {
           if (isFull()) {
               throw new RuntimeException("큐가 가득 찼습니다.");
           }
           queue[++rear] = item;
       }

       public int dequeue() {
           if (isEmpty()) {
               throw new RuntimeException("큐가 비어 있습니다.");
           }
           int item = queue[front];
           front++;
           return item;
       }

       public int peek() {
           if (isEmpty()) {
               throw new RuntimeException("큐가 비어 있습니다.");
           }
           return queue[front];
       }

       public boolean isFull() {
           return rear == capacity - 1;
       }

       public boolean isEmpty() {
           return front > rear;
       }
   }
   ```

#### 2. **연결 리스트(Linked List) 기반 큐**
   - 연결 리스트 기반 큐는 데이터의 크기에 제한이 없으며, 동적으로 크기를 조절할 수 있습니다. 연결 리스트의 앞에서 데이터를 제거하고, 뒤에서 데이터를 추가하는 방식으로 구현됩니다.

   ```java
   class Node {
       int data;
       Node next;

       public Node(int data) {
           this.data = data;
           this.next = null;
       }
   }

   class Queue {
       private Node front, rear;

       public Queue() {
           this.front = this.rear = null;
       }

       public void enqueue(int item) {
           Node newNode = new Node(item);
           if (rear == null) {
               front = rear = newNode;
               return;
           }
           rear.next = newNode;
           rear = newNode;
       }

       public int dequeue() {
           if (front == null) {
               throw new RuntimeException("큐가 비어 있습니다.");
           }
           int item = front.data;
           front = front.next;
           if (front == null) {
               rear = null;
           }
           return item;
       }

       public int peek() {
           if (front == null) {
               throw new RuntimeException("큐가 비어 있습니다.");
           }
           return front.data;
       }

       public boolean isEmpty() {
           return front == null;
       }
   }
   ```

---

### 큐의 응용 분야

1. **작업 스케줄링**:
   - 운영 체제에서 CPU 작업 스케줄링에 큐가 사용됩니다. 각 프로세스는 큐에 들어가고, 순서대로 처리됩니다. 특히, **라운드 로빈 스케줄링(Round Robin Scheduling)** 같은 방식에서는 큐가 필수적입니다.

2. **네트워크 데이터 관리**:
   - 네트워크에서 패킷을 전송할 때 패킷은 큐에 쌓여서 전송됩니다. 패킷들이 들어오는 순서대로 처리되기 때문에, 데이터 전송 지연이나 손실을 방지하는 데 큐가 사용됩니다.

3. **프린터 작업 대기열**:
   - 프린터는 작업이 대기열에 쌓여서 먼저 요청된 작업부터 순차적으로 처리합니다. 이 때, 큐가 사용됩니다.

4. **이벤트 처리**:
   - 사용자 인터페이스(UI)에서 발생하는 이벤트나 요청도 큐에 쌓여 처리됩니다. 예를 들어, 키보드나 마우스 입력이 발생하면 큐에 들어가고, 입력된 순서대로 처리됩니다.

5. **그래프 탐색 (BFS, 너비 우선 탐색)**:
   - 큐는 그래프 탐색 알고리즘인 **너비 우선 탐색(BFS)**에서 사용됩니다. BFS에서는 큐를 이용해 탐색할 노드를 순서대로 관리하며, 먼저 들어온 노드부터 탐색합니다.

6. **캐시(Cache) 구현**:
   - 데이터 캐싱에서 **LRU(Least Recently Used)** 알고리즘을 구현할 때 큐가 사용됩니다. 최근에 사용된 데이터를 큐에서 삭제하고, 새로운 데이터를 큐에 추가하는 방식으로 동작합니다.

---

### 원형 큐(Circular Queue)
원형 큐는 배열 기반 큐의 단점을 보완한 자료 구조로, 배열의 양 끝을 연결하여 배열이 끝에 도달해도 앞쪽으로 다시 돌아가서 빈 공간을 사용할 수 있게 합니다. 배열이 가득 차기 전에 비어 있는 공간을 활용할 수 있기 때문에, 메모리 사용 효율이 높습니다.

#### 원형 큐의 동작
원형 큐에서는 인덱스가 배열의 끝에 도달하면 다시 배열의 시작 부분으로 돌아갑니다. 이를 위해 **모듈러 연산**(%)을 사용하여 인덱스를 계산합니다.

```java
class CircularQueue {
    private int[] queue;
    private int front, rear, capacity;

    public CircularQueue(int size) {
        queue = new int[size];
        capacity = size;
        front = rear = -1;
    }

    public void enqueue(int item) {
        if ((rear + 1) % capacity == front) {
            throw new RuntimeException("큐가 가득 찼습니다.");
        } else if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        queue[rear] = item;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("큐가 비어 있습니다.");
        }
        int item = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }


        return item;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}
```

---

### 큐의 시간 복잡도

큐의 주요 연산은 대부분 상수 시간에 수행됩니다:
- **삽입(enqueue)**: O(1)
- **삭제(dequeue)**: O(1)
- **조회(peek)**: O(1)

이는 큐가 매우 효율적인 자료 구조임을 보여줍니다.

---

### 큐의 장단점 요약

#### 장점:
- 선입선출(FIFO) 구조로, 데이터를 순차적으로 처리하는 데 적합.
- 상수 시간 내에 삽입 및 삭제 연산이 가능.
- 원형 큐를 사용하면 배열의 공간을 효율적으로 사용할 수 있음.

#### 단점:
- 배열 기반 큐에서는 고정된 크기 때문에 메모리 낭비 또는 오버플로우 발생 가능.
- 연결 리스트 기반 큐에서는 추가적인 포인터가 필요하여 메모리 사용량이 다소 증가.

큐는 간단한 구조이지만 여러 분야에서 매우 유용하게 활용되는 자료 구조입니다. `enqueue`와 `dequeue` 같은 연산은 데이터를 처리할 때 효율적이며, 특히 순차적으로 처리해야 하는 작업에서 강력한 도구입니다.
 * */
public class Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution1 sol = new Solution1();
		
		sol.push(1);
		sol.push(2);
		sol.push(3);
		
		
		System.out.println(sol.peek());
		System.out.println(sol.pop());
		System.out.println(sol.peek());
		System.out.println(sol.empty());
	}
	
}
