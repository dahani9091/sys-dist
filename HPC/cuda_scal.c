#include<stdio.h>
#include<cuda.h>
#include <stdlib.h>
#define N 512

__global__ void dot(int *a , int *b , int *c){
    __shared__ int temp[N];
    temp[blockDim.x * blockIdx.x + threadIdx.x] = a[blockDim.x * blockIdx.x + threadIdx.x] * b[blockDim.x * blockIdx.x + threadIdx.x ] ;
    __syncthreads();
    if(0==threadIdx.x){
        int sum = 0;
        for(int i = 0; i < N ; i++)
        sum = sum +temp[i];
        *c = sum ;
    }
}
int main (){
    int *a , *b, *c;
    int *d_a , *d_b ,*d_c ;
    int size = N * sizeof (int);
    cudaMalloc((void**)&d_a,size);
    cudaMalloc((void**)&d_b,size);
    cudaMalloc((void**)&d_c,size);
    a=(int *)malloc(size);
    b=(int *)malloc(size);
    c=(int *)malloc(size);
    for(int i=0;i<N;i++)
        {
            a[i]=1;
        }
    for(int i=0;i<N;i++)
        {
            b[i]=1;
        }
    cudaMemcpy(d_a,a,size,cudaMemcpyHostToDevice);
    cudaMemcpy(d_b,b,size,cudaMemcpyHostToDevice);
    dot<<<1,N>>>(d_a,d_b,d_c);
    cudaMemcpy(c,d_c,size,cudaMemcpyDeviceToHost);
    printf("Le produit scalaire est : %d \n", *c) ;
    free(a);free(b);free(c);
    cudaFree(d_a);
    cudaFree(d_b);
    cudaFree(d_c);
    return 0;
}
