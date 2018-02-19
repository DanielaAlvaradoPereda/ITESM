/*
 * Daniela Alvarado Pereda A01329233
 * 05/12/2017
 * This program implements an AVL tree to organize and manage entities.
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Node{
	int key;
	char* type;
	char* brand;
	int enabled;
	struct Node* left;
	struct Node* right;
};

struct Queue{
	struct Node** array;
	int back;
};

struct Node* createNode(int key, char* type, char* brand, int enabled){
    struct Node* ptn = malloc(sizeof(struct Node));
    ptn -> key = key;
    ptn -> type = type;
    ptn -> brand = brand;
    ptn -> enabled = enabled;
    ptn -> left = NULL;
    ptn -> right = NULL;
    
    return ptn;
}

int getHeight(struct Node* ptn){
    if(!ptn){
        return 0;
    }
    
    int leftLevels = getHeight(ptn -> left);
    int rightLevels = getHeight(ptn -> right);
    
    return leftLevels > rightLevels ? leftLevels + 1 : rightLevels + 1;
}

struct Node* findFather(struct Node* ptn, struct Node* father, struct Node* child){
	if(ptn){
		if(ptn == child){
			return father;
		}
		father = findFather(ptn -> left, ptn, child);
		if(father){
			return father;
		}
		return findFather(ptn -> right, ptn, child);
	}
	else{
		return NULL;
	}
}

struct Node* isNotBalanced(struct Node* ptr, struct Node* ptn){
	if(!ptn){
		return NULL;
	}
	if(abs(getHeight(ptn -> left) - getHeight(ptn -> right)) > 1){
		return ptn;
	}
	return isNotBalanced(ptr, findFather(ptr, NULL, ptn));
}

void balanceTree(struct Node** ptr, struct Node* ptn, int key){
	struct Node* father = findFather(*ptr, NULL, ptn);
	struct Node* x;
	struct Node* y;
	struct Node* z;
	struct Node* b;
	struct Node* c;

	if(key < ptn -> key){
		z = ptn;
		if(key < ptn -> left -> key){
			y = ptn -> left;
			x = ptn -> left -> left;

			b = x -> right;
		}
		else{
			x = ptn -> left;
			y = ptn -> left -> right; 

			b = y -> left;
		}
		c = y -> right;
	}
	else{
		x = ptn;
		if(key > ptn -> right -> key){
			y = ptn -> right;
			z = ptn -> right -> right;

			c = z -> left;
		}
		else{
			z = ptn -> right;
			y = ptn -> right -> left;

			 c = y -> right;
		}
		b = y -> left;
	}

	if(!father){
		*ptr = y;
	}
	else if(ptn -> key < father -> key){
		father -> left = y;
	}
	else{
		father -> right = y;
	}
	y -> left = x;
	y -> right = z;
	x -> right = b;
	z -> left = c;
}

void insert(struct Node** ptr, struct Node* ptn, int key, char* type, char* brand, int enabled){
    if(ptn){
        if(key < ptn -> key){
            if(ptn -> left){
                insert(ptr, ptn -> left, key, type, brand, enabled);
            }
            else{
                ptn -> left = createNode(key, type, brand, enabled);

                if(ptn = isNotBalanced(*ptr, ptn)){
                	balanceTree(ptr, ptn, key);
                }
            }
        }
        else{
            if(ptn -> right){
                insert(ptr, ptn -> right, key, type, brand, enabled);
            }
            else{
                ptn -> right = createNode(key, type, brand, enabled);

                if(ptn = isNotBalanced(*ptr, ptn)){
                	balanceTree(ptr, ptn, key);
                }
            }
        }
    }
    else{
        *ptr = createNode(key, type, brand, enabled);
    }
}

int checkNode(struct Node* ptn){
	return ptn ? (ptn -> enabled ? 1 : -1) : 0;
}

void printNode(struct Node* ptn, int list){
	printf("%s|ID:\t%d\n|Tipo:\t%s\n|Marca:\t%s\n+---\n",  list ? "" : "+---\n", ptn -> key, ptn -> type, ptn -> brand);
}

int intInput(char tag[]){
	int number;
	printf("Ingrese %s:\n", tag);
	scanf("%d", &number);
	fgetc(stdin);

	return number;
}

void delete(struct Node* ptn){
	if(checkNode(ptn) == 1){
		printf("Esta a punto de eliminar el siguiente elemento\n");
		printNode(ptn, 0);
		if(intInput("1 para confirmar o 0 para cancelar")){
			ptn -> enabled = 0;
		}
	}
	else{
		printf("El elemento no existe o ha sido eliminado previamente\n");
	}
}

char* stringInput(char tag[]){
    char* string = malloc(sizeof(char) * 1026);
    printf("Ingrese %s:\n", tag);
    fgets(string, 1026, stdin);
    strtok(string, "\n");
    string = realloc(string, sizeof(char) * (strlen(string) + 1));

    return string;
}

void edit(struct Node* ptn){
	if(checkNode(ptn) == 1){
		printf("Los valores actuales del elemnento son los siguientes\n");
		printNode(ptn, 0);

		free(ptn -> type);
		free(ptn -> brand);

		ptn -> type = stringInput("el nuevo tipo");
		ptn -> brand = stringInput("la nueva marca");
	}
	else{
		printf("El elemento no existe o ha sido eliminado previamente\n");
	}
}

void recover(struct Node* ptn){
	int state = checkNode(ptn);
	if(state == -1){
		ptn -> enabled = 1;
		printf("Elemento recuperado\n");
		printNode(ptn, 0);
	}
	else{
		printf("El elemento no ha sido eliminado previamente o no existe\n");
	}
}

int inOrder(struct Node* ptn, int first){
	if(ptn){
		first = inOrder(ptn -> left, first);
		if(ptn -> enabled){
			if(first){
				printNode(ptn, 0);
				first = 0;
			}
			else{
				printNode(ptn, 1);
			}
		}
		first = inOrder(ptn -> right, first);
	}
	return first;
}

int reverseInOrder(struct Node* ptn, int first){
	if(ptn){
		first = reverseInOrder(ptn -> right, first);
		if(ptn -> enabled){
			if(first){
				printNode(ptn, 0);
				first = 0;
			}
			else{
				printNode(ptn, 1);
			}
		}
		first= reverseInOrder(ptn -> left, first);
	}
	return first;
}

struct Node** fillQueue(struct Node* ptn, struct Queue* ptq){
	if(checkNode(ptn) == 1){
		ptq -> array = realloc(ptq -> array, sizeof(struct Node*) * (ptq -> back + 1));
		ptq -> array[ptq -> back++] = ptn;

		fillQueue(ptn -> left, ptq);
		fillQueue(ptn -> right, ptq);
	}
}

void sort(struct Queue* ptq, int field, int ascending){
	int swap;
	int length = ptq -> back - 1;

    do{
        swap = 0;
        
        for(int i = 0; i < length; i++){
        	int comp = field == 1 ? strcmp(ptq -> array[i] -> type, ptq -> array[i + 1] -> type) : strcmp(ptq -> array[i] -> brand, ptq -> array[i + 1] -> brand);
        	if(ascending ? comp > 0 || !comp && ptq -> array[i] -> key > ptq -> array[i + 1] -> key :
        		comp < 0 || !comp && ptq -> array[i] -> key > ptq -> array[i + 1] -> key){
            	struct Node* temp = ptq -> array[i];
            	ptq -> array[i] = ptq -> array[i + 1];
            	ptq -> array[i + 1] = temp;
            }
            swap = 1;
        }
       	length--;
    }while(swap);
}

void printQueue(struct Queue* ptq){
	printNode(ptq -> array[0], 0);
	for(int i = 1; i < ptq -> back; i++){
		printNode(ptq -> array[i], 1);
	}
}

void report(struct Node* ptr){
	struct Queue nodes;
	switch(intInput("una opcion")){
		case 0:
			break;
		case 1:
			inOrder(ptr, 1);
			break;
		case 2:
			reverseInOrder(ptr, 1);
			break;
		case 3:
			nodes.array = malloc(sizeof(struct Node*));
			nodes.back = 0;
			fillQueue(ptr, &nodes);
			sort(&nodes, 1, 1);
			printQueue(&nodes);
			free(nodes.array);
			break;
		case 4:
			nodes.array = malloc(sizeof(struct Node*));
			nodes.back = 0;
			fillQueue(ptr, &nodes);
			sort(&nodes, 1, 0);
			printQueue(&nodes);
			free(nodes.array);
			break;
		case 5:
			nodes.array = malloc(sizeof(struct Node*));
			nodes.back = 0;
			fillQueue(ptr, &nodes);
			sort(&nodes, 2, 1);
			printQueue(&nodes);
			free(nodes.array);
			break;
		case 6:
			nodes.array = malloc(sizeof(struct Node*));
			nodes.back = 0;
			fillQueue(ptr, &nodes);
			sort(&nodes, 2, 0);
			printQueue(&nodes);
			free(nodes.array);
			break;
		default:
			printf("Opcion invalida\n");
	}
}

struct Node* searchKey(struct Node* ptn, int key){
	if(!ptn || ptn -> key == key){
		return ptn;
	}
	if(key < ptn -> key){
		return searchKey(ptn -> left, key);
	}
	return searchKey(ptn -> right, key);
}

void clearScreen()
{	
    for(int i = 1; i <= 50; i++)
    {
        printf("\n");
    }
}

void printMenu(int menu){
	clearScreen();
	switch(menu){
		case 0:
			printf("%s%s", "Menu:\n1.\tInsertar nuevo elemento\n2.\tEliminar elemento\n3.\tEditar elemento\n4.\tRecuperar elemento eliminado\n",
        		"5.\tReporte total\n6.\tBusqueda\n7.\tHerramientas administrativas\n0.\tSalir\n\n");
			break;
		case 1:
			printf("%s%s", "Opciones para reporte:\n1.\tOrden ascendente por ID\n2.\tOrden descendente por ID\n3.\tOrden ascendente por tipo\n",
        		"4.\tOrden descendente por tipo\n5.\tOrden ascendente por marca\n6.\tOrden descendente por marca\n0.\tRegresar\n\n");
			break;
		case 2:
			printf("Busqueda:\n1.\tBuscar por ID\n2.\tBuscar en tipo y marca\n0.\tRegresar\n\n");
			break;
		case 3:
			printf("Buscar por ID:\n1.\tCoincidencia exacta\n2.\tElementos con ID menor o igual\n3.\tElementos con ID mayor o igual\n0.\tRegresar\n\n");
			break;
		case 4:
			printf("Buscar en tipo y marca:\n1.\tCoincidencia exacta\n2.\tCoincidencia parcial\n0.\tRegresar\n\n");
			break;
		case 5:
			printf("Herramientas administrativas:\n1.\tGuardar respaldo de la informacion\n2.\tCargar informacion de respaldo\n0.\tRegresar\n\n");
			break;
	}
}

int findLesser(struct Node* ptn, int key, int first){
	if(ptn){
		first = findLesser(ptn-> left, key, first);
		if(ptn -> enabled && ptn -> key <= key){
			if(first){
				printNode(ptn, 0);
				first = 0;
			}
			else{
				printNode(ptn, 1);
			}
		}
		else{
			return first;
		}
		first = findLesser(ptn -> right, key, first);
	}
	return first;
}

int findGreater(struct Node* ptn, int key, int first){
	if(ptn){
		first = findGreater(ptn-> right, key, first);
		if(ptn -> enabled && ptn -> key >= key){
			if(first){
				printNode(ptn, 0);
				first = 0;
			}
			else{
				printNode(ptn, 1);
			}
		}
		else{
			return first;
		}
		first = findGreater(ptn -> left, key, first);
	}
	return first;
}

void findKey(struct Node* ptr, int key){
	printMenu(3);
	struct Node* ptn = searchKey(ptr, key);
	int result;

	switch(intInput("una opcion")){
		case 0:
			break;
		case 1:
			if(checkNode(ptn) == 1){
				printNode(ptn, 0);
				result = 0;
			}
			break;
		case 2:
			result = findLesser(ptr, key, 1);
			break;
		case 3:
			result = findGreater(ptr, key, 1);
			break;
		default:
			printf("Opcion invalida\n");
	}

	if(result){
		printf("No se encontraron elementos\n");
	}
}

int searchField(struct Node* ptn, char* string, int first){
	if(ptn){
		first = searchField(ptn -> left, string, first);
		if(ptn -> enabled && (!strcmp(ptn -> type, string) || !strcmp(ptn -> brand, string))){
			if(first){
					printNode(ptn, 0);
					first = 0;
				}
				else{
					printNode(ptn, 1);
				}
		}
		first = searchField(ptn -> right, string, first);
	}
	return first;
}

int searchSubstring(struct Node* ptn, char* string, int first){
	if(ptn){
		first = searchSubstring(ptn -> left, string, first);
		if(ptn -> enabled && (strstr(ptn -> type, string) || strstr(ptn -> brand, string))){
			if(first){
				printNode(ptn, 0);
				first = 0;
			}
			else{
				printNode(ptn, 1);
			}
		}
		first = searchSubstring(ptn -> right, string, first);
	}
	return first;
}

void findField(struct Node* ptr, char* string){
	printMenu(4);
	int result;
	switch(intInput("una opcion")){
		case 0:
			break;
		case 1:
			result = searchField(ptr, string, 1);
			break;
		case 2:
			result = searchSubstring(ptr, string, 1);
			break;
		default:
			printf("Opcion invalida\n");
	}

	if(result){
		printf("No se encontraron elementos\n");
	}

	free(string);
}

void saveLevel(struct Node* ptn, int level, FILE* ptf){
    if(ptn){
        if(!level){
        	fprintf(ptf, "%d\n%s\n%s\n%d\n", ptn -> key, ptn -> type, ptn -> brand, ptn -> enabled);
        }
        else if(level > 0){
            saveLevel(ptn -> left, level - 1, ptf);
            saveLevel(ptn -> right, level -1, ptf);
        }
    }
}

void save(struct Node* ptn, FILE* ptf){
	int levels = getHeight(ptn);

    for(int i = 0; i < levels; i++){
        saveLevel(ptn, i, ptf);
    }
    fprintf(ptf, "-1");
    fclose(ptf);
}

void deleteTree(struct Node* ptn){
	if(ptn){
		deleteTree(ptn -> left);
		deleteTree(ptn -> right);

		free(ptn -> type);
		free(ptn -> brand);
		free(ptn);
	}
}

int intFileInput(FILE* ptf){
	int number;
	fscanf(ptf, "%d", &number);
	fgetc(ptf);

	return number;
}

char* stringFileInput(FILE* ptf){
    char* string = malloc(sizeof(char) * 1026);
    fgets(string, 1026, ptf);
    strtok(string, "\n");
    string = realloc(string, sizeof(char) * (strlen(string) + 1));

    return string;
}

void load(struct Node** ptr, FILE* ptf){
	printf("Archivo de respaldo encontrado\n");
	if(intInput("1 para cargar el contenido o 0 para cancelar, si existe informacion previa, sera eliminada")){
		deleteTree(*ptr);
		*ptr = NULL;
		int key = intFileInput(ptf);

		while(key != -1){
			char* type = stringFileInput(ptf);
			char* brand = stringFileInput(ptf);
			int enabled = intFileInput(ptf);
			insert(ptr, *ptr, key, type, brand, enabled);
			key = intFileInput(ptf);
		}
		fclose(ptf);
	}
}

FILE* openFile(char* filename, char* type, int def){
	FILE* ptf = fopen(filename, type);
	if(!def){
		free(filename);
	}
	if(!ptf){
		printf("Archivo \"%s\" no encontrado\n", filename);
	}
	return ptf;
}

int main(){
	struct Node* root = NULL;
    int option;
    FILE* ptf = openFile("data", "rb", 1);

    if(ptf){
    	load(&root, ptf);
    }
    else{
    	printf("Creando nuevo archivo de respaldo\n");
    }
    do{
    	printf("Presione enter para continuar");
    	fgetc(stdin);
    	printMenu(0);
    	option = intInput("una opcion");
    	switch(option){
    		case 0:
				printf("Datos guardados en archivo \"data\"\n");
				break;
			case 1:;
		    	int key = intInput("el ID");
		    	if(!searchKey(root, key)){
		    		insert(&root, root, key, stringInput("el tipo"), stringInput("la marca"), 1);
		    	}
		    	else{
		    		printf("El ID ingresado ya esta en uso\n");
		    	}
		    	break;
	    	case 2:
	    		delete(searchKey(root, intInput("el ID del elemento a eliminar")));
	    		break;
	    	case 3:
	    		edit(searchKey(root, intInput("el ID")));
		    	break;
	    	case 4:
	    		recover(searchKey(root, intInput("el ID")));
	    		break;
    		case 5:
    			if(root){
    				printMenu(1);
    				report(root);
    			}
    			else{
    				printf("No hay elementos\n");
    			}
    			break;
		    case 6:
		    	printMenu(2);
		    	switch(intInput("una opcion")){
		    		case 0:
		    			break;
		    		case 1:
		    			findKey(root, intInput("el ID"));
		    			break;
	    			case 2:
	    				findField(root, stringInput("la cadena a buscar"));
	    				break;
	    			default:
						printf("Opcion invalida\n");
		    	}
				break;
			case 7:
				printMenu(5);
				switch(intInput("una opcion")){
					case 0:
						break;
		    		case 1:
		    			save(root, openFile(stringInput("el nombre para el archivo"), "wb+", 0));
		    			break;
	    			case 2:
	    				load(&root, openFile(stringInput("el nombre para el archivo"), "rb", 0));
	    				break;
	    			default:
						printf("Opcion invalida\n");
		    	}
				break;
			default:
				printf("Opcion invalida\n");
	    }
    }while(option);
    save(root, openFile("data", "wb+", 1));
}