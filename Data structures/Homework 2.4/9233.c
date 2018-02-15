/*
 * Daniela Alvarado Pereda A01329233
 * 26/10/2017
 * This program implements a binary search tree and prints it in PreOrder, InOrder, PostOrder and LevelOrder.
 */
#include <stdio.h>
#include <stdlib.h>

struct node{
    int key;
    struct node* left;
    struct node* right;
};

struct node* createNode(int key){
    struct node* temp = malloc(sizeof(struct node));
    temp -> key = key;
    temp -> left = NULL;
    temp -> right = NULL;
    
    return temp;
}

void insert(struct node** ptn, int key){
    if(*ptn){
        if(key < (*ptn) -> key){
            if((*ptn) -> left){
                insert(&((*ptn) -> left), key);
            }
            else{
                (*ptn) -> left = createNode(key);
            }
        }
        else if(key > (*ptn) -> key){
            if((*ptn) -> right){
                insert(&((*ptn) -> right), key);
            }
            else{
                (*ptn) -> right = createNode(key);
            }
        }
    }
    else{
        *ptn = createNode(key);
    }
}

void preOrder(struct node* ptn){
    if(ptn){
        printf("%d\n", ptn -> key);
        preOrder(ptn -> left);
        preOrder(ptn -> right);
    }
}

void inOrder(struct node* ptn){
    if(ptn){
        inOrder(ptn -> left);
        printf("%d\n", ptn -> key);
        inOrder(ptn -> right);
    }
}

void postOrder(struct node* ptn){
    if(ptn){
        postOrder(ptn -> left);
        postOrder(ptn -> right);
        printf("%d\n", ptn -> key);
    }
}

int getLevels(struct node* ptn){
    if(!ptn){
        return 0;
    }
    
    int leftLevels = getLevels(ptn -> left);
    int rightLevels = getLevels(ptn -> right);
    
    return leftLevels > rightLevels ? leftLevels + 1 : rightLevels + 1;
}

void printLevel(struct node* ptn, int level){
    if(ptn){
        if(!level){
            printf("%d\n", ptn -> key);
        }
        else if(level > 0){
            printLevel(ptn -> left, level - 1);
            printLevel(ptn -> right, level -1);
        }
    }
}

void levelOrder(struct node* ptn){
    int levels = getLevels(ptn);
    
    for(int i = 0; i < levels; i++){
        printLevel(ptn, i);
    }
}

int main()
{
    struct node* root = NULL;
    int n;
    scanf("%d", &n);
    
    for(int i = 0; i < n; i++){
        int key;
        scanf("%d", &key);
        insert(&root, key);    
    }
    
    printf("PreOrder:\n");
    preOrder(root);
    printf("InOrder:\n");
    inOrder(root);
    printf("PostOrder:\n");
    postOrder(root);
    printf("LevelOrder:\n");
    levelOrder(root);
    
    return 0;
}
