/*
 * Daniela Alvarado Pereda A01329233
 * 27/11/2017
 * This program implements different algorithms to analyze graphs.
 */
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

struct Node;

struct Adj{
	int weight;
	struct Node* ptn;
	struct Adj* next;
};

struct Node{
	int key;
	struct Adj* head;
	struct Node* next;
};

struct Queue{
	int* array;
	int back;
};

void enqueue(struct Queue* ptq, int element){
	ptq -> array = realloc(ptq -> array, sizeof(int) * (ptq -> back + 1));
	ptq -> array[ptq -> back++] = element;
}

int dequeue(struct Queue* ptq){
	int element = ptq -> array[0];

	for(int i = 0; i < ptq -> back - 1; i++){
		ptq -> array[i] = ptq -> array[i + 1];
	}
	if(--ptq -> back){
		ptq -> array = realloc(ptq -> array, sizeof(int) * ptq -> back);
	}
	return element;
}

void printMatrix(int n, int* matrix){
	int max = 0;
	int min = 0;

	for(int row = 0; row < n; row++){
		for(int col = 0; col < n; col++){
			if(*(matrix + n * row + col) == -1){
				min = 1;
			}
			if(*(matrix + n * row + col) > max){
				max = *(matrix + n * row + col);
			}
		}
	}

	int maxDigits = 0;
	int nodes = n;
	int nDigits = 0;
	while(max != 0){
		max /= 10;
		maxDigits++;
	}
	while(nodes != 0){
		nodes /= 10;
		nDigits++;
	}
	int field = min ? (maxDigits > 2 ? maxDigits : 2) : maxDigits;

	printf("%*c", nDigits + 1, ' ');
	for(int i = 0; i < n; i++){
		printf("%*d ", field, i);
	}
	printf("\n%*c", nDigits + 1, '+');
	for(int i = 0; i < field * n + n - 1; i++){
		printf("-");
	}
	printf("\n");
	for(int row = 0; row < n; row++){
		printf("%*d|", nDigits, row);
		for(int col = 0; col < n; col++){
			printf("%*d ", field, *(matrix + n * row + col));
		}
		printf("\n");
	}
}

void adjMatrix(int n, int* matrix){
	for(int row = 0; row < n; row++){
		for(int col = 0; col < n; col++){
			scanf("%d", matrix + n * row + col);
		}
	}

	printf("\nAdjacency matrix:\n");
	printMatrix(n, matrix);
}

void edgeList(int n, int* matrix){
	int edge = 0;

	printf("\nEdge list:\n");
	for(int row = 0; row < n; row++){
		for(int col = 0; col < n; col++){
			if(*(matrix + n * row + col) != -1){
				printf("Edge %d connects node %d with node %d with a weight %d\n", edge++, row, col, *(matrix + n * row + col));
			}
		}
	}
}

void dijkstra(int n, int* matrix){
	printf("\nDijkstra:\n");
	for(int start = 0; start < n; start++){
		int perm[n];
		for(int i = 0; i < n; i++){
			perm[i] = -1;
		}
		int label[n][2];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < 2; j++){
				label[i][j] =  i == start && j == 0 ? 0 : -1;
			}
		}

		int row = start;
		int finished;
		do{
			perm[row] = 1;
			finished = 1;
			for(int col = 0; col < n; col++){
				if(perm[col] != 1 && *(matrix + n * row + col) != -1){
					if(perm[col] == -1){
						label[col][0] = label[row][0] + *(matrix + n * row + col);
						label[col][1] = row;
						perm[col] = 0;
					}
					else if(label[row][0] + *(matrix + n * row + col) < label[col][0]){
						label[col][0] = label[row][0] + *(matrix + n * row + col);
						label[col][1] = row;
					}
				}
			}

			int min = label[0][0];
			int found = 0;
			for(int i = 0; i < n; i++){
				if(found){
					if(perm[i] == 0 && label[i][0] < min){
						min = label[i][0];
						row = i;
					}
				}
				else if(perm[i] == 0){
					min = label[i][0];
					row = i;
					found = 1;
				}
			}

			for(int i = 0; i < n; i++){
				if(perm[i] == 0){
					finished = 0;
				}
			}
		}while(!finished);

		for(int i = 0; i < n; i++){
			if(label[i][0] > 0){
				printf("From node %d to node %d: %d\n", start, i, label[i][0]);
			}
		}
	}

}

struct Node* search(struct Node* ptn, int key){
    while(ptn && ptn -> key != key){
        ptn = ptn -> next;
    }
    
    return ptn;
}

struct Node* createNode(int key){
	struct Node* ptn = malloc(sizeof(struct Node));
	ptn -> key = key;
	ptn -> head = NULL;
	ptn -> next = NULL;

	return ptn;
}

struct Adj* createAdj(int weight, struct Node* ptn){
	struct Adj* pta = malloc(sizeof(struct Adj));
	pta -> weight = weight;
	pta -> ptn = ptn;
	pta -> next = NULL;

	return pta;
}

void adjList(struct Node** pth, int n, int* matrix){
	struct Node* ptn = createNode(0);
	*pth = ptn;
	for(int key = 1; key < n; key++){
		ptn -> next = createNode(key);
		ptn = ptn -> next;
	}

	ptn = *pth;
	for(int row = 0; row < n; row++){
		struct Adj* pta;
		for(int col = 0; col < n; col++){
			if(*(matrix + n * row + col) != -1){
				if(!ptn -> head){
					pta = createAdj(*(matrix + n * row + col), search(*pth, col));
					ptn -> head = pta;
				}
				else{
					pta -> next = createAdj(*(matrix + n * row + col), search(*pth, col));
					pta = pta -> next;
				}
			}
		}
		ptn = ptn -> next;
	}
	
	ptn = *pth;
	printf("\nAdjacency list:\n");
	while(ptn){
        struct Adj* pta = ptn -> head;
        while(pta){
        	printf("Node %d connects with node %d(weight: %d)\n", ptn -> key, pta -> ptn -> key, pta -> weight);
        	pta = pta -> next;
        }
        ptn = ptn -> next;
    }
}

void sort(struct Queue* ptq){
	int swap;
	int length = ptq -> back - 1;

    do{
        swap = 0;
        
        for(int i = 0; i < length; i++){
            if(ptq -> array[i] > ptq-> array[i + 1]){
            	int temp = ptq -> array[i];
            	ptq -> array[i] = ptq -> array[i + 1];
            	ptq -> array[i + 1] = temp;
            }
            swap = 1;
        }
       	length--;
    }while(swap);
}

void bfs(int n, int* matrix){
	printf("\nBFS:\n");
	struct Queue nodes;
	nodes.array = malloc(sizeof(int));
	nodes.back = 0;
	struct Queue level;
	level.array = malloc(sizeof(int));
	level.back = 0;

	for(int node = 0; node < n; node++){
		printf("From node %d: ", node);
		int visited[n];
		int this = 0;
		int next = 0;

		for(int i = 0; i < n; i++){
			visited[i] = i == node ? 1: 0;
		}
		enqueue(&nodes, node);
		this++;

		while(this != 0 || next != 0){
			int row = dequeue(&nodes);
			enqueue(&level, row);
			this--;

			for(int col = 0; col < n; col++){
				if(!visited[col] && *(matrix + n * row + col) != -1){
					enqueue(&nodes, col);
					visited[col] = 1;
					next++;
				}
			}

			if(!this){
				sort(&level);
				for(int i = level.back; i > 0; i--){
					printf("%d ", dequeue(&level));
				}
				this = next;
				next = 0;
			}
		}
		printf("\n");
	}
	free(nodes.array);
	free(level.array);
}

void traverse(struct Node* ptn, int* visited){
	printf("%d ", ptn -> key);
	visited[ptn -> key] = 1;
	struct Adj* pta = ptn -> head;
	while(pta){
		if(!visited[pta -> ptn -> key]){
			traverse(pta -> ptn, visited);
		}
		pta = pta -> next;
	}
	return;
}

void dfs(struct Node* ptn, int n){
	printf("\nDFS: \n");
	while(ptn){
		printf("From node %d: ", ptn -> key);
		int visited[n];
		for (int i = 0; i < n; ++i)
		{
			visited[i] = 0;
		}

		traverse(ptn, visited);

		printf("\n");
		ptn = ptn -> next;
	}
}

void floyd(int n, int* matrix){
	for(int i = 0; i < n; i++){
		*(matrix + n * i + i) = 0;
	}
	int routes[n][n];
	for(int row = 0; row < n; row++){
		for(int col = 0; col < n; col++){
			routes[row][col] = col;
		}
	}

	for(int node = 0; node < n; node++){
		for(int row = 0; row < n; row++){
			for(int col = 0; col < n; col++){
				if(*(matrix + n * node + col) != -1 && *(matrix + n * row + node) != -1){
					if(*(matrix + n * row + col) == -1 || *(matrix + n * node + col) + *(matrix + n * row + node) < *(matrix + n * row + col)){
						*(matrix + n * row + col) = *(matrix + n * node + col) + *(matrix + n * row + node);
						routes[row][col] = node;
					}
				}
			}
		}
	}

	printf("\nFloyd:\nAdjacency matrix:\n");
	printMatrix(n, matrix);
	printf("Routes matrix:\n");
	printMatrix(n, *routes);
}

int main(){
	struct Node* head = NULL;
	int n;
	scanf("%d\n", &n);
	int matrix[n][n];

	adjMatrix(n, *matrix);
	edgeList(n, *matrix);
	adjList(&head, n, *matrix);
	bfs(n, *matrix);
	dfs(head, n);
	dijkstra(n, *matrix);
	floyd(n, *matrix);

	return 0;
}