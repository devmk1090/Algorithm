## Algorithm & Data Structure

##### 배열(Array)
같은 타입의 연관된 데이터를 효율적으로 관리하기 위한 자료구조
- **장점**
index를 통해 원하는 위치에 있는 값에 대해 효율적으로 접근 가능
- **단점**
크기가 정해져 있으므로 유동적인 데이터의 추가, 삭제가 어려움
- **시간 복잡도**
접근 - O(1) 인덱스를 통해 값에 바로 접근
검색 - O(n) 처음 Index부터 순회
추가, 삭제 - 맨 뒤에 추가, 삭제 시 O(1), 중간 값일 시 추가, 삭제 후 데이터를 한칸씩 밀어야 하므로 O(n)

##### 스택(Stack) 
목록의 끝에서만 접근 할 수 있는 제한적인 자료구조
LIFO(Last In First Out) - 마지막에 들어온 데이터가 가장 먼저 나감
- **시간 복잡도**
접근, 검색 - O(n) 처음 Index부터 순회
추가, 삭제 - O(1) 마지막 index에 대해서 추가, 삭제 보장
- **활용**
웹 브라우저 뒤로가기(가장 나중에 열린 페이지를 먼저 보여줌)
역순 문자열 출력(문자열의 마지막부터 출력)

#### 큐(Queue)
LIFO 형태를 가지는 스택과 반대되는 개념. 한쪽 끝에서는 삽입, 한쪽 끝에서는 추출 작업이 이루어짐
FIFO (First In First Out) - 처음에 들어온 데이터가 가장 먼저 나감
- **시간 복잡도**
접근, 검색 - O(n) 처음 Index부터 순회
추가, 삭제 - O(1) 마지막 index에 추가, 처음 index 대해서 삭제 보장
- **활용**
프로세스의 스케줄링 (먼저 들어온 작업에 대한 처리)
BFS (너비 우선 탐색) 등

#### 링크드 리스트(Linked List)
data, pointer를 가지는 각 노드가 연결되어 있는 형태의 자료구조
노드를 연속적으로 연결함으로써 배열과 달리 동적인 크기를 가질 수 있음
- **장점**
노드의 중간지점에서의 자료의 추가, 삭제가 O(1)의 시간 복잡도를 가짐
- **단점**
데이터를 검색하기 위해서는 head부터 순회해야 하므로 O(n)의 시간 복잡도를 가짐
- **시간 복잡도**
접근, 검색 - O(n) 처음 Index부터 순회
추가, 삭제 - 맨 앞 또는 뒤라면 O(1), 중간 위치라면 O(n)