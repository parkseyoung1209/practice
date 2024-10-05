package dataStructure.stackAndQueue.problem1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
/*
 * 스택(Stack)은 **후입선출(LIFO, Last In First Out)** 자료 구조의 한 형태로, 나중에 삽입된 데이터가 먼저 나오는 방식으로 동작합니다. 흔히 접시를 쌓는 것에 비유되며, 가장 나중에 쌓인 접시가 먼저 꺼내지는 방식입니다. 스택은 컴퓨터 과학과 프로그래밍에서 매우 중요한 자료 구조로, 메모리 관리, 재귀 호출, 수식 계산, 알고리즘 설계 등 다양한 분야에서 사용됩니다.

### 스택의 기본 개념
스택은 **단일 포인터인 'top'**을 사용하여 데이터의 삽입과 삭제를 관리하는 후입선출(LIFO) 방식의 자료 구조입니다. 큐와는 달리 하나의 끝에서만 모든 연산이 이루어지며, 이로 인해 구조가 단순하지만 강력한 기능을 제공합니다
스택은 크게 **push**, **pop**, **peek** 세 가지 주요 연산을 통해 동작합니다.

1. **push(item)**: 스택의 맨 위에 새로운 데이터를 삽입하는 연산입니다.
   - 스택의 크기가 허용하는 한 데이터를 계속 쌓을 수 있습니다.
   
2. **pop()**: 스택의 맨 위에 있는 데이터를 제거하고 반환하는 연산입니다.
   - 스택이 비어 있는 상태에서 `pop` 연산을 시도하면, 대부분의 구현에서는 **언더플로우(underflow)** 에러가 발생합니다.
   
3. **peek()**: 스택의 맨 위에 있는 데이터를 제거하지 않고 조회만 하는 연산입니다.
   - `pop`과 달리 데이터는 스택에 그대로 유지됩니다.

4. **isEmpty()**: 스택이 비어 있는지 확인하는 연산입니다.
   - 스택이 비어 있으면 `true`, 그렇지 않으면 `false`를 반환합니다.

5. **isFull()** (Array 기반 스택의 경우): 스택이 가득 찼는지 확인하는 연산입니다. 배열로 스택을 구현했을 때 유한한 크기의 배열에서만 사용할 수 있습니다.

---

### 스택의 동작 원리
스택은 데이터가 삽입될 때마다 스택의 **맨 위(top)**에 쌓입니다. 이때 가장 나중에 삽입된 데이터가 가장 먼저 제거되며, 이를 **후입선출(LIFO)** 라고 부릅니다.

1. **스택에 데이터 추가 (push)**  
   ``` 
   스택: []
   push(1)
   스택: [1]
   push(2)
   스택: [1, 2]
   ```

2. **스택에서 데이터 제거 (pop)**  
   ``` 
   스택: [1, 2]
   pop() -> 2 반환
   스택: [1]
   pop() -> 1 반환
   스택: []
   ```

3. **스택 조회 (peek)**  
   ``` 
   스택: [1, 2]
   peek() -> 2 반환 (스택 유지: [1, 2])
   ```

---

### 스택의 구현 방식

스택은 두 가지 방식으로 구현할 수 있습니다:

1. **배열(Array) 기반 스택**: 
   - 고정된 크기를 가지며, 배열의 한쪽 끝에서 데이터를 삽입(push)하고 제거(pop)합니다.
   - **장점**: 구현이 간단하고, 메모리 상의 데이터 접근이 빠릅니다.
   - **단점**: 배열의 크기가 고정되어 있기 때문에, 스택의 크기를 동적으로 변경할 수 없습니다.
   
   ```java
   class Stack {
       private int[] stack;
       private int top;
       private int capacity;

       public Stack(int size) {
           stack = new int[size];
           capacity = size;
           top = -1;
       }

       public void push(int item) {
           if (isFull()) {
               System.out.println("스택이 가득 찼습니다.");
               return;
           }
           stack[++top] = item;
       }

       public int pop() {
           if (isEmpty()) {
               throw new RuntimeException("스택이 비어 있습니다.");
           }
           return stack[top--];
       }

       public int peek() {
           if (isEmpty()) {
               throw new RuntimeException("스택이 비어 있습니다.");
           }
           return stack[top];
       }

       public boolean isFull() {
           return top == capacity - 1;
       }

       public boolean isEmpty() {
           return top == -1;
       }
   }
   ```

2. **연결 리스트(Linked List) 기반 스택**:
   - 스택의 크기를 동적으로 관리할 수 있으며, 크기에 제한이 없습니다.
   - **장점**: 크기를 동적으로 조정할 수 있어 메모리 낭비가 없습니다.
   - **단점**: 배열 기반 스택에 비해 데이터 접근 속도가 느릴 수 있습니다.
   
   ```java
   class Node {
       int data;
       Node next;

       public Node(int data) {
           this.data = data;
           this.next = null;
       }
   }

   class Stack {
       private Node top;

       public Stack() {
           this.top = null;
       }

       public void push(int item) {
           Node newNode = new Node(item);
           newNode.next = top;
           top = newNode;
       }

       public int pop() {
           if (isEmpty()) {
               throw new RuntimeException("스택이 비어 있습니다.");
           }
           int item = top.data;
           top = top.next;
           return item;
       }

       public int peek() {
           if (isEmpty()) {
               throw new RuntimeException("스택이 비어 있습니다.");
           }
           return top.data;
       }

       public boolean isEmpty() {
           return top == null;
       }
   }
   ```

---

### 스택의 응용 분야

1. **함수 호출 관리**:
   - 프로그램에서 함수 호출은 스택을 사용하여 관리됩니다. 하나의 함수가 호출될 때마다 함수의 정보(매개변수, 지역 변수, 리턴 주소 등)가 스택에 저장되며, 함수 호출이 끝나면 그 함수의 정보는 스택에서 제거됩니다. 이를 **함수 호출 스택(Call Stack)**이라고 합니다.
   
2. **재귀 호출**:
   - 재귀 함수는 내부적으로 스택을 사용하여 구현됩니다. 재귀 호출이 깊어질수록 함수의 상태가 스택에 저장되고, 재귀가 끝날 때는 그 상태가 다시 복원됩니다.
   
3. **괄호 짝 검사**:
   - 수학식이나 프로그램 코드에서 괄호의 짝을 검사할 때 스택이 사용됩니다. 여는 괄호가 나올 때 스택에 넣고, 닫는 괄호가 나올 때 스택에서 꺼내는 방식으로 짝을 맞춥니다.
   
4. **수식 계산**:
   - **후위 표기법(Postfix Notation)**을 계산하는 데 스택이 자주 사용됩니다. 수식을 중위 표기법에서 후위 표기법으로 변환할 때도 스택을 사용합니다.

5. **웹 브라우저의 뒤로 가기 기능**:
   - 웹 브라우저에서 뒤로 가기 버튼을 누르면 이전 페이지로 돌아가는 기능도 스택을 사용합니다. 방문한 페이지를 스택에 쌓아두고, 뒤로 가기를 누를 때마다 스택에서 페이지를 꺼내서 보여줍니다.

---

### 스택의 한계와 문제점

1. **언더플로우(Underflow)**: 스택이 비어 있는 상태에서 데이터를 꺼내려고 할 때 발생하는 문제입니다. 이런 경우 프로그램이 예외를 발생시키거나 비정상적으로 종료될 수 있습니다.

2. **오버플로우(Overflow)**: 스택이 꽉 찬 상태에서 데이터를 추가하려고 할 때 발생하는 문제입니다. 특히, 배열 기반 스택에서 고정된 크기를 초과하는 데이터를 넣으려고 하면 오버플로우가 발생할 수 있습니다. 연결 리스트 기반 스택에서는 이 문제가 발생하지 않지만, 메모리 부족으로 인해 문제를 겪을 수 있습니다.

---

### 스택의 시간 복잡도

스택에서 주요 연산의 시간 복잡도는 다음과 같습니다:
- **삽입(push)**: O(1)
- **삭제(pop)**: O(1)
- **조회(peek)**: O(1)
  
이 모든 연산이 상수 시간(O(1))에 이루어지기 때문에 스택은 매우 효율적인 자료 구조입니다.

---

### 스택의 장단점 요약

#### 장점:
- 후입선출(LIFO) 원칙에 따라 매우 직관적인 연산 구조.
- 상수 시간 내에 데이터 삽입과 제거 가능.
- 배열 기반 스택은 메모리 접근이 빠름.

#### 단점:
- 배열 기반 스택은 고정된 크기로 인해 오버플로우 위험이 존재.
- 연결 리스트 기반 스택은 메모리 사용량이 비교적 많음.

스택은 간단하지만 강력한 자료 구조로, 다양한 컴퓨터 과학 문제에서 효율적인 해결책을 제공합니다.
 * 
 * */
public class Stack {
	// 올바른 괄호 사용을 했는지에 대한 테스트

	public static void main(String[] args) {
		Stack oo = new Stack();
		String text = "[{})({";
		System.out.println(oo.isValid(text));
	}
	public boolean isValid(String text) {
		Deque<Character> stack = new ArrayDeque<Character>();
		
		Map<Character, Character> table = new HashMap<Character, Character>();
		table.put(')', '(');
		table.put('}', '{');
		table.put(']', '[');
		
		for(int i = 0; i<text.length(); i++) {
			if(!table.containsKey(text.charAt(i))) {
				stack.push(text.charAt(i));
			} else if(stack.isEmpty() || table.get(text.charAt(i)) != stack.pop()) { // pop에서 기존에 푸쉬한 값이 비교되면서 제거된다.
				return false;
			}
		}
		return stack.size() == 0;
	}
}
