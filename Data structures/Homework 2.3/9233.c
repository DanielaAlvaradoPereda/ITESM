/*
 * Daniela Alvarado Pereda A01329233
 * 23/10/2017
 * This program implements a linked list with strings as data and performs several related operations.
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct node{
    char* data;
    struct node* next;
};

struct node* findLast(struct node* ptn, struct node* ptl){
    while(ptn && ptn -> next != ptl){
        ptn = ptn -> next;
    }
    
    return ptn;
}

void dataAlloc(char** nodeData, char* data, int size){
    *nodeData = malloc(sizeof(char) * size);
    strncpy(*nodeData, data, size);
    
    free(data);
}

void insertBeg(struct node** pth, char* data){
    struct node* temp = malloc(sizeof(struct node));
    dataAlloc(&(temp -> data), data, strlen(data) + 1);
    temp -> next = *pth;
    
    *pth = temp;
}

void insertEnd(struct node** pth, char* data){
    struct node* temp = malloc(sizeof(struct node));
    dataAlloc(&(temp -> data), data, strlen(data) + 1);
    temp -> next = NULL;
    
    if(*pth){
        findLast(*pth, NULL) -> next = temp;
    }
    else{
        *pth = temp;
    }
}

void insertBefore(struct node** pth, struct node* ref, char* data){
    if(ref){
        struct node* temp = malloc(sizeof(struct node));
        dataAlloc(&(temp -> data), data, strlen(data) + 1);
        temp -> next = ref;
        
        if(ref != *pth){
            findLast(*pth, ref) -> next = temp;
        }
        else{
            *pth = temp;
        }
    }
    else{
        printf("Invalid action\n");
    }
}

void insertAfter(struct node** pth, struct node* ref, char* data){
    if(ref){
        struct node* temp = malloc(sizeof(struct node));
        dataAlloc(&(temp -> data), data, strlen(data) + 1);
        temp -> next = ref -> next;
        
        ref -> next = temp;
    }
    else{
        printf("Invalid action\n");
    }
}

void insertNBefore(struct node** pth, int n, struct node* ref, char* data){
    for(int i = 0; ref && i < n; i++){
        ref = findLast(*pth, ref);
    }
    
    if(ref){
        struct node* temp = malloc(sizeof(struct node));
        dataAlloc(&(temp -> data), data, strlen(data) + 1);
        temp -> next = ref;
        
        if(ref != *pth){
            findLast(*pth, ref) -> next = temp;
        }
        else{
            *pth = temp;
        }
    }
    else{
        printf("Invalid action\n");
    }
}

void insertNAfter(struct node** pth, int n, struct node* ref, char* data){
    for(int i = 0; ref && i < n; i++){
        ref = ref -> next;
    }
    
    if(ref){
        struct node* temp = malloc(sizeof(struct node));
        dataAlloc(&(temp -> data), data, strlen(data) + 1);
        temp -> next = ref -> next;
        
        ref -> next = temp;
    }
    else{
        printf("Invalid action\n");
    }
}

void deleteBeg(struct node** pth){
    if(*pth){
        struct node* temp = *pth;
        *pth = temp -> next;
        
        free(temp);
    }
    else{
        printf("Invalid action\n");
    }
}

void deleteEnd(struct node** pth){
    if(*pth){
        struct node* temp = findLast(*pth, NULL);
        if(temp != *pth){
            findLast(*pth, temp) -> next = NULL;
        }
        else{
            *pth = NULL;
        }
        
        free(temp);
    }
    else{
        printf("Invalid action\n");
    }
}

void deleteBefore(struct node** pth, struct node* ref){
    if(ref && ref != *pth){
        struct node* temp = findLast(*pth, ref);
        if(temp != *pth){
            findLast(*pth, temp) -> next = ref;
        }
        else{
            *pth = ref;
        }
        
        free(temp);
    }
    else{
        printf("Invalid action\n");
    }
}

void deleteAfter(struct node** pth, struct node* ref){
    if(ref && ref -> next != NULL){
        struct node* temp = ref -> next;
        ref -> next = temp -> next;
        
        free(temp);
    }
    else{
        printf("Invalid action\n");
    }
}

void deleteNBefore(struct node** pth, int n, struct node* ref){
    for(int i = 0; ref && i < n; i++){
        ref = findLast(*pth, ref);
    }
    
    if(ref && ref != *pth){
        struct node* temp = findLast(*pth, ref);
        if(temp != *pth){
            findLast(*pth, temp) -> next = ref;
        }
        else{
            *pth = ref;
        }
        
        free(temp);
    }
    else{
        printf("Invalid action\n");
    }
}

void deleteNAfter(struct node** pth, int n, struct node* ref){
    for(int i = 0; ref && i < n; i++){
        ref = ref -> next;
    }
    
    if(ref && ref -> next != NULL){
        struct node* temp = ref -> next;
        ref -> next = temp -> next;
        
        free(temp);
    }
    else{
        printf("Invalid action\n");
    }
}

void print(struct node* ptn){
    while(ptn){
        printf("%s\n", ptn -> data);
        ptn = ptn -> next;
    }
}

void reversePrint(struct node* pth){
    struct node* ptn = findLast(pth, NULL);
    
    while(ptn){
        printf("%s\n", ptn -> data);
        ptn = findLast(pth, ptn);
    }
}

void recursivePrint(struct node* ptn){
    if(!ptn){
        return;
    }
    
    printf("%s\n", ptn -> data);
    recursivePrint(ptn -> next);
}

void recursiveReversePrint(struct node* ptn){
    if(!ptn){
        return;
    }
    
    recursiveReversePrint(ptn -> next);
    printf("%s\n", ptn -> data);
}

struct node* search(struct node* ptn, char* data){
    while(ptn && strcmp(ptn -> data, data)){
        ptn = ptn -> next;
    }
    
    return ptn;
}

struct node* reverseSearch(struct node* pth, char* data){
    struct node* ptn = findLast(pth, NULL);
    
    while(ptn && strcmp(ptn -> data, data)){
        ptn = findLast(pth, ptn);
    }
    
    return ptn;
}

struct node* recursiveSearch(struct node* ptn, char* data){
    if(!ptn || !strcmp(ptn -> data, data)){
        return ptn;
    }
    
    return recursiveSearch(ptn -> next, data);
}

struct node* recursiveReverseSearch(struct node* ptn, char* data){
    if(!ptn){
        return ptn;
    }
    
    struct node* test = recursiveReverseSearch(ptn -> next, data);
    if(test){
        return test;
    }
    else if(!ptn || !strcmp(ptn -> data, data)){
        return ptn;
    }
    else{
        return NULL;
    }
}

void ascendingSort(struct node** pth){
    if(*pth){
        int swap;
        
        do{
            struct node* ptn = *pth;
            swap = 0;
            
            while(ptn -> next){
                struct node* temp = ptn -> next;
                
                if(strcmp(ptn -> data, temp -> data) > 0){
                    ptn -> next = temp -> next;
                    temp -> next = ptn;
                    if(ptn != *pth){
                        findLast(*pth, ptn) -> next = temp;
                    }
                    else{
                        *pth = temp;
                    }
                    swap = 1;
                }
                ptn = temp;
            }
        }while(swap);
    }
}

void descendingSort(struct node** pth){
    if(*pth){
        int swap;
        
        do{
            struct node* ptn = *pth;
            swap = 0;
            
            while(ptn -> next){
                struct node* temp = ptn -> next;
                
                if(strcmp(ptn -> data, temp -> data) < 0){
                    ptn -> next = temp -> next;
                    temp -> next = ptn;
                    if(ptn != *pth){
                        findLast(*pth, ptn) -> next = temp;
                    }
                    else{
                        *pth = temp;
                    }
                    swap = 1;
                }
                ptn = temp;
            }
        }while(swap);
    }
}

void printMenu(){
    printf("\n%s%s%s%s", "Menu:\n1.\tInsert at the beginning\n2.\tInsert at the end\n3.\tInsert before\n4.\tInsert after\n5.\tInsert n before\n",
        "6.\tInsert n after\n7.\tDelete at the beginning\n8.\tDelete at the end\n9.\tDelete before\n10.\tDelete after\n11.\tDelete n before\n12.\tDelete n after\n",
        "13.\tPrint\n14.\tPrint backwards\n15.\tRecursive print\n16.\tRecursive backwards print\n17.\tSearch\n18.\tSearch from last to first\n",
        "19.\tRecursive search\n20.\tRecursive search from last to first\n21.\tAcending sort\n22.\tDescending sort\n0.\tQuit\n\nEnter an option:\n");
}

char* input(char tag[]){
    char* string = malloc(sizeof(char) * 1026);
    printf("Enter the %s:\n", tag);
    fgets(string, 1026, stdin);
    strtok(string, "\n");

    return string;
}

int main(){
    struct node* head = NULL;
    int option;
    
    do{
        int displacement;
        char* ptr;
        struct node* reference;
        char* string;
    
        printMenu();
        scanf("%d", &option);
        fgetc(stdin);
        
        switch(option){
            case 1:
                string = input("string");
                insertBeg(&head, string);
                break;
            case 2:
                string = input("string");
                insertEnd(&head, string);
                break;  
            case 3:
                reference = search(head, input("reference"));
                string = input("string");
                insertBefore(&head, reference, string);
                break;         
            case 4:
                reference = search(head, input("reference"));
                string = input("string");
                insertAfter(&head, reference, string);
                break;
            case 5:
                displacement = strtol(input("displacement"), &ptr, 10);
                reference = search(head, input("reference"));
                string = input("string");
                insertNBefore(&head, displacement, reference, string);
                break;  
            case 6:
                displacement = strtol(input("displacement"), &ptr, 10);
                reference = search(head, input("reference"));
                string = input("string");
                insertNAfter(&head, displacement, reference, string);
                break;   
            case 7:
                deleteBeg(&head);
                break; 
            case 8:
                deleteEnd(&head);
                break; 
            case 9:
                reference = search(head, input("reference"));
                deleteBefore(&head, reference);
                break;
            case 10:
                reference = search(head, input("reference"));
                deleteAfter(&head, reference);
                break;
            case 11:
                displacement = strtol(input("displacement"), &ptr, 10);
                reference = search(head, input("reference"));
                deleteNBefore(&head, displacement, reference);
                break;
            case 12:
                displacement = strtol(input("displacement"), &ptr, 10);
                reference = search(head, input("reference"));
                deleteNAfter(&head, displacement, reference);
                break;
            case 13:
                print(head);
                break;  
            case 14:
                reversePrint(head);
                break;  
            case 15:
                recursivePrint(head);
                break;
            case 16:
                recursiveReversePrint(head);
                break;  
            case 17:
                reference = search(head, input("string"));
                printf(reference ? "String found at: %p\n" : "String not found\n", reference);
                break;
            case 18:
                reference = reverseSearch(head, input("string"));
                printf(reference ? "String found at: %p\n" : "String not found\n", reference);
                break;
            case 19:
                reference = recursiveSearch(head, input("string"));
                printf(reference ? "String found at: %p\n" : "String not found\n", reference);
                break;
            case 20:
                reference = recursiveReverseSearch(head, input("string"));
                printf(reference ? "String found at: %p\n" : "String not found\n", reference);
                break;
            case 21:
                ascendingSort(&head);
                break;
            case 22:
                descendingSort(&head);
                break;
            case 0:
                break;
            default:
                printf("Invalid input\n");
        }
    }while(option);
    return 0;
}
