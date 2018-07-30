#include<cstring>
#include<cstdio>
#include<iostream>
using namespace std;

int Memcpy(void *dst,void *src,int len)   
{   
    if(NULL == dst || NULL == src || len < 0)
    {
        return -1;
    }  
    void * ret = dst;   
    if (dst <= src || (char *)dst >= ((char *)src +len)) {   
        while (len--) {   
            *(char *)dst = *(char *)src;   
            dst = (char *)dst + 1;   
            src = (char *)src + 1;   
        }   
    }   //copy_from_head
    else {   
        dst = (char *)dst + len - 1;   
        src = (char *)src + len - 1;   
        while (len--) {   
            *(char *)dst = *(char *)src;   
            dst = (char *)dst - 1;   
        src = (char *)src - 1;   
        }   
    }   //copy_from_end
    return 1;   
}   
int main()
{
    char p1[256] = "hello,world!";   
    char p2[256] = {0};   
    int i = Memcpy(p2,p1,strlen(p1)+1);   
    printf("%s\n",p2);   
    i = Memcpy(NULL,p1,strlen(p1)+1);   
    i = Memcpy(p2,NULL,strlen(p1)+1);   
    i = Memcpy(p1+1,p1,strlen(p1)+1);   
    printf("%s\n",p1);   
    i = Memcpy(p1,p1+1,strlen(p1)+1);   
    printf("%s\n",p1);   
    system("pause");
    return 0;
}
