/*
 * Daniela Alvarado Pereda A01329233
 * 15/11/2017
 * This program implements a tree to evaluate expressions in prefix, infix and postfix.
 */
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

union Data{
	int number;
	char operator;
};

struct Key{
	union Data data;
	int type; //0 -> operator, 1 -> number
};

struct Node{
	struct Key key;
	struct Node* left;
    struct Node* right;
};

struct Stack{
	struct Node** array;
	int top; 
};

void push(struct Stack* pts, struct Node* element){
	pts -> array = realloc(pts -> array, sizeof(struct Node*) * (pts -> top + 1));
	pts -> array[pts -> top++] = element;
}

struct Node* pop(struct Stack* pts){
	return pts -> array[pts -> top-- - 1];
}

struct Node* createNode(struct Key key){
    struct Node* ptn = malloc(sizeof(struct Node));
    ptn -> key = key;
    ptn -> left = NULL;
    ptn -> right = NULL;
    
    return ptn;
}

struct Key readKey(){
	char c;
	char* string = malloc(sizeof(char));
	string[0] = '\0';
	struct Key key;

	do{
		if((c = fgetc(stdin)) == EOF){
			c = '\n';
		}
	}while(c == ' ');
	if(isdigit(c)){
		while(isdigit(c)){
			int length = strlen(string);
			string = realloc(string, sizeof(char) * (length + 2));

			string[length] = c;
			string[length + 1] = '\0';

			c = fgetc(stdin);
		}

		ungetc(c, stdin);
		key.data.number = atoi(string);
		key.type = 1;
	}
	else{
		key.data.operator = c;
		key.type = 0;
	}

	free(string);
	return key;
}

struct Node* postfix(struct Key key){
	struct Stack nodes;
	nodes.array = malloc(sizeof(struct Node*));
	nodes.top = 0;
	struct Node* ptn;

	while(key.type || key.data.operator != '\n'){
		ptn = createNode(key);
		if(key.type){
			push(&nodes, ptn);
		}
		else{
			ptn -> right = pop(&nodes);
			ptn -> left =  pop(&nodes);

			push(&nodes, ptn);
		}
		key = readKey();
	}

	return ptn;
	free(nodes.array);
}

struct Node* prefix(struct Key key){
	struct Node* ptn = createNode(key);
	if(key.type){
		return ptn;
	}

	ptn -> left = prefix(readKey());
	ptn -> right = prefix(readKey());

	return ptn;
}

struct Node* infix(struct Key key){
	struct Stack nodes;
	nodes.array = malloc(sizeof(struct Node*));
	nodes.top = 0;
	struct Node* ptn;

	while(key.type || key.data.operator != '\n'){
		if(key.type || (key.data.operator != ')' && key.data.operator != '(')){
			ptn = createNode(key);

			push(&nodes, ptn);
		}
		else if (key.data.operator == ')'){
			ptn = pop(&nodes);
			struct Node* root = pop(&nodes);
			root -> right = ptn;
			root -> left = pop(&nodes);

			push(&nodes, root);
		}
		key = readKey();
	}

	ptn = pop(&nodes);
	free(nodes.array);
	return ptn;
}

void preOrder(struct Node* ptn){
    if(ptn){
        if(ptn -> key.type){
            printf("%d ", ptn -> key.data.number);
        }
        else{
            printf("%c ", ptn -> key.data.operator);
        }
        
        preOrder(ptn -> left);
        preOrder(ptn -> right);
    }
}

void inOrder(struct Node* ptn){
    if(ptn){
    	printf(ptn -> key.type ? "" : "(");
        inOrder(ptn -> left);
        
        if(ptn -> key.type){
            printf("%d ", ptn -> key.data.number);
        }
        else{
            printf("%c ", ptn -> key.data.operator);
        }
        
        inOrder(ptn -> right);
        printf(ptn -> key.type ? "" : ")");
    }
}

void postOrder(struct Node* ptn){
    if(ptn){
        postOrder(ptn -> left);
        postOrder(ptn -> right);
        
        if(ptn -> key.type){
            printf("%d ", ptn -> key.data.number);
        }
        else{
            printf("%c ", ptn -> key.data.operator);
        }
    }
}

int evaluate(struct Node* ptn){
	if(ptn -> key.type){
		return ptn -> key.data.number;
	}

	switch(ptn -> key.data.operator){
		case '+':
			return evaluate(ptn -> left) + evaluate(ptn -> right);
		case '-':
			return evaluate(ptn -> left) - evaluate(ptn -> right);
		case '*':
			return evaluate(ptn -> left) * evaluate(ptn -> right);
		case '/':
			return evaluate(ptn -> left) / evaluate(ptn -> right);
	}
}

void deleteTree(struct Node* ptn){
	if(!ptn){
		return;
	}

	deleteTree(ptn -> left);
	deleteTree(ptn -> right);
	free(ptn);
}

int main(){
	struct Node* root = NULL;
	int n;
	scanf("%d\n", &n);

	for(int i = 0; i < n; i++){
		struct Key key = readKey();

		if(key.type){
			root = postfix(key);
		}
		else if (key.data.operator == '('){
			root = infix(key);
		}
		else{
			root = prefix(key);
			readKey();
		}

		printf("prefix: ");
		preOrder(root);
		printf("\ninfix: ");
		inOrder(root);
		printf("\npostfix: ");
		postOrder(root);
		printf("\nresult: %d\n\n", evaluate(root));
		
		deleteTree(root);
	}
}
