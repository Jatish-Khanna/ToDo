

struct LinkedList {
  int data;
  struct LinkedList *next;
};

typedef struct LinkedList *list;

list get_new_node(int data_to_store) {
  list new_node = (list)(malloc(sizeof(struct LinkedList)));
  new_node->data = data_to_store;
  new_node->next = NULL;
  return new_node;
}

void insert_node(list **head, int data_to_store) {

  if(*head == NULL) {
    *head = get_new_node(data_to_store);
    return;
  }
  
  list current = *head;
  list prev = NULL;
  
  while(current != NULL && current->data < data_to_store) {
    prev = current;
    current = current->next;
  }
  
  list new_node = get_new_node(data_to_store);
  
  if(prev != NULL) {
    prev->next = new_node;
  } else {
    *head = new_node;
  }
  new_node->next = current;
}

void print_nodes(list **head) {
  list current = *head;
  while(current != NULL) {
    printf("%d->", current->data);
    current = current->next;
  }
  
  printf("NULL\n-----------\n");
}


int main() {
  list head = NULL;
  int arr[5] = {5, 1, 0, 4, 2};
  int count = 0;
  int length = sizeof(arr)/sizeof(arr[0]);
  
  while(count < length) {
    insert_node(&head, arr[count]);
    count++;
  }
  
  print_nodes(&head);
  
  return 0;
}
