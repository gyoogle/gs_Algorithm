## 연결 리스트(Linked List)란?

> 연속적인 메모리 위치에 저장되지 않는 선형 데이터 구조 (포인터를 사용해서 연결)
>
> 각 노드는 **데이터 필드**와 **다음 노드에 대한 참조**를 포함하는 노드로 구성

![1547391129621](C:\Users\김규철\AppData\Roaming\Typora\typora-user-images\1547391129621.png)

##### 배열 대신 Linked List를 사용하는 이유는?

> 배열은 제한 사항이 존재
>
> 1. 배열의 크기가 고정되어 있기 때문에 미리 요소의 수를 할당 받아놔야 함
> 2. 새로운 요소 삽입에 비용이 많이 듬 (공간을 만들고, 기존 요소를 모두 이동시켜야 함)



##### Linked List 장단점

> - 장점
>
>   - 동적인 크기
>   - 삽입/삭제가 용이
>
> - 단점
>
>   - 첫 번째 노드부터 순차적으로 요소에 액세스 해야함(이진 검색 수행 불가)
>   - 포인터의 여분 메모리 공간이 목록의 각 요소에 필요
>



##### 기본적인 노드 구조체

```
struct Node {
    int data;
    struct Node *next;
};
```

데이터와 다음 노드에 대한 참조로 구성



##### 노드 3개를 잇는 Single Linked List 구현

```
      head         second         third 
        |             |             | 
        |             |             | 
    +---+---+     +---+---+     +----+----+ 
    | 1  | o----->| 2 | o-----> |  3 |  # | 
    +---+---+     +---+---+     +----+----+
```

```
void printList(struct Node *n) 
{ 
  while (n != NULL) 
  { 
     printf(" %d ", n->data); 
     n = n->next; 
  } 
} 


int main(void) {
    struct Node* head = NULL;
    struct Node* second = NULL;
    struct Node* third = NULL;
    
    // 힙에 노드 3개 할당
    head = (struct Node*)malloc(sizeof(struct Node));
    second = (struct Node*)malloc(sizeof(struct Node));
    third = (struct Node*)malloc(sizeof(struct Node));


/* 
       head           second           third 
        |                |               | 
        |                |               | 
    +---+-----+     +----+----+     +----+----+ 
    | #  | #  |     | #  | #  |     |  # |  # | 
    +---+-----+     +----+----+     +----+----+ 
*/

    head->data = 1; // 첫번째 노드 data에 1 할당
    head->next = second; // 첫번째 노드와 두번째 노드 연결

/*
       head          second         third 
        |              |              | 
        |              |              | 
    +---+---+     +----+----+     +-----+----+ 
    | 1  | o----->| #  | #  |     |  #  | #  | 
    +---+---+     +----+----+     +-----+----+     
*/
    second->data = 2;
    second->next = third;

    third->data = 3;
    third->next = NULL; //마지막 연결할 노드 없으면 NULL로

/*
      head     
        | 
        |  
    +---+---+     +---+---+       +----+------+ 
    | 1  | o----->|  2  | o-----> |  3 | NULL | 
    +---+---+     +---+---+       +----+------+ 
*/
    printList(head);
    return 0;
}

```



##### 노드 추가

```
// 앞쪽에 노드 추가
void push(struct Node** head_ref, int new_data){
    struct Node* new_node = (struct Node*) malloc(sizeof(struct Node));

    new_node->data = new_data;

    new_node->next = (*head_ref);

    (*head_ref) = new_node;
}

// 특정 노드 다음에 추가
void insertAfter(struct Node* prev_node, int new_data){
    if (prev_node == NULL){
        printf("이전 노드가 NULL이 아니어야 합니다.");
        return;
    }

    struct Node* new_node = (struct Node*) malloc(sizeof(struct Node));

    new_node->data = new_data;
    new_node->next = prev_node->next;

    prev_node->next = new_node;
    
}


// 끝에 노드 추가
void append(struct Node** head_ref, int new_data){
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));

    struct Node *last = *head_ref;

    new_node->data = new_data;

    new_node->next = NULL;

    if (*head_ref == NULL){
        *head_ref = new_node;
        return;
    }

    while(last->next != NULL){
        last = last->next;
    }

    last->next = new_node;
    return;

}

void printList(struct Node *node){
    while (node != NULL){
        printf("%d", node->data);
        node = node->next;
    }
}

int main(){

    struct Node* head = NULL;

    append(&head, 6); // 6

    push(&head, 7); // 7 6

    push(&head, 1); // 1 7 6

    append(&head, 4); // 1 7 6 4

    insertAfter(head->next, 8); // 1 7 8 6 4
    
    printList(head);

    return 0;
}
```



##### Doubly Linked List

> 노드와 노드가 '서로' 연결되어 있다는 점
>
> Single Linked List는 한 방향이면 Doubly는 양 방향
>
> (즉, Previous 노드와 Next 노드로 구성)



##### 장점

> 노드의 탐색을 양쪽으로 할 수 있기 때문에 더 효율적
>
> ex) 노드가 6개일 때
>
> Doubly는 1~3 노드는 next로 탐색하고, 4~6 노드는 6부터 previous를 이용해 조회하면서, 최악의 경우 Single Linked List에서 노드 전체를 탐색해야 했는데 이를 절반으로 줄여주는 효과를 가져다 줌

따라서 상황에 따라 탐색 방향이 바뀌어야 하는 경우에는 Doubly Linked List를 사용해야 함



##### 단점

> previous 노드를 지정하기 위한 변수를 하나 더 사용해야 함 (즉, 메모리 사용 증가)
>
> 구현이 복잡해짐



하지만 장점이 워낙 커서, **현실에서 사용하는 연결 리스트는 대부분 'Double'**



이중은 구조체 선언 시 이전 노드도 추가로 필요함

```
struct Node{
    int data;
    struct Node *next;
    struct Node *prev;
};
```



```
//앞 쪽에 추가

void push(struct Node** head_ref, int new_data) 
{ 
	//할당
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node)); 
  
    new_node->data = new_data; 
  
    new_node->next = (*head_ref); 
    new_node->prev = NULL; 
  
    if ((*head_ref) != NULL) 
        (*head_ref)->prev = new_node; 
  
    (*head_ref) = new_node; 
}

// 특정 노드 다음에 추가
void insertAfter(struct Node* prev_node, int new_data) 
{ 
    // 이전 노드가 NULL인지 먼저 체크
    if (prev_node == NULL) { 
        printf("이전 노드가 NULL이면 안돼요"); 
        return; 
    } 
  
  	//할당
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node)); 
  
    //데이터 넣기
    new_node->data = new_data; 
  
    //새로운 노드의 다음 참조를 이전 노드의 다음 참조로 변경
    new_node->next = prev_node->next; 
  
    //이전 노드의 참조를 새로운 노드로 연결
    prev_node->next = new_node; 
  
    //새로운 노드의 prev 참조를 이전 노드로 연결
    new_node->prev = prev_node; 
  
   //새로운 노드의 다음 참조가 NULL이 아니면 이전 참조를 새로운 노드로 연결
    if (new_node->next != NULL) 
        new_node->next->prev = new_node; 
} 


//끝에 노드에 추가

void append(struct Node** head_ref, int new_data) 
{ 
    //할당
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node)); 
  
    struct Node* last = *head_ref;
  
   	//데이터 입력
    new_node->data = new_data; 
  
  	//새로운 노드는 마지막 노드이므로, 다음 참조는 NULL로 만들어주기
    new_node->next = NULL; 
  	
  	//만약 리스트가 비어있다면 새로운 헤드 생성
    if (*head_ref == NULL) { 
        new_node->prev = NULL; 
        *head_ref = new_node; 
        return; 
    } 
  
    //마지막 노드의 다음 참조가 NULL이 아닐 때 last의 다음 참조값 저장
    while (last->next != NULL) 
        last = last->next; 
  
    //마지막 노드의 다음 참조 값에 새로 생성한 노드 저장
    last->next = new_node; 
  
    //새로운 노드의 이전 참조도 마지막 노드로 저장
    new_node->prev = last; 
  
    return; 
} 
```

