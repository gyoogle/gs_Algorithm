#include <stdio.h>
#include <stdlib.h>

typedef struct node {
	struct node *next;
	struct node *prev;
	int val;
}node_t;

node_t *head;
void printDLL()
{
	node_t *cur = head;
	while (cur != NULL)
	{
		printf("%d \n", cur->val);
		cur = cur->next;
	}
	printf("---------------\n");
}
void destroyDLL()
{
	node_t *cur = head;
	while (head !=NULL)
	{
		head = head->next;
		free(cur);
		cur = head;
	}
}
void add_node(int v)
{
	node_t *new_node = (struct node*)malloc(sizeof(node_t));
	new_node->val = v;
	new_node->next = 0;
	new_node->prev = 0;

	if (head == 0)
	{
		head = new_node;
		return;
	}
	else
	{
		node_t *cur = head;
		while (cur->next != NULL)
		{
			cur = cur->next;
		}
		cur->next = new_node;
		new_node->prev = cur;
		return;
	}
}
void insert_node(int key, int v)
{
	node_t *cur = head;

	while (cur->val != key)
	{		
		cur = cur->next;
		if (cur == 0)
		{
			return;
		}
	}
	node_t *new_node = (node_t *)malloc(sizeof(node_t));

	new_node->val = v;
	new_node->next = cur->next;
	new_node->prev = cur;

	cur->next = new_node;	
	if (new_node->next != NULL)
	{
		new_node->next->prev = new_node;
	}
}
void delete_node(int v)
{
	node_t *cur = head;


	while (cur->val != v)
	{	
		cur = cur->next;
		if (cur == 0)
		{
			return;
		}
	}

	if (cur == head)
	{
		head = head->next;
		if (head != NULL)
		{
			head->prev = 0;
		}
		free(cur);
	}
	else
	{
		cur->prev->next = cur->next;
		if (cur->next != 0)
		{
			cur->next->prev = cur->prev;
		}
		free(cur);
	}
}
int main()
{
	add_node(1);
	add_node(2);
	add_node(3);

	printDLL();

	//destroyDLL();
	//printDLL();

	insert_node(2, 10);
	insert_node(3, 20);	
	printDLL();


	
	delete_node(10);
	delete_node(1);
	delete_node(100);
	printDLL();
}