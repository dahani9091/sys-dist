#include <stdio.h>
#include<omp.h>
int main(int argc, char* argv[ ])
{
    int iam;
    omp_set_num_threads(5);
    #pragma omp parallel 
    
    {
        iam=omp_get_thread_num();
        nd = omp_get_num_threads();
        

        #pragma omp critical
        printf("Hello from %d\n",iam);
    } /* the parallel block ends here */
    //printf("Hello, this is a serial program.\n");
    return 0;
}


/// loops


...
double time1 = omp_get_wtime();
sum = 0.0;
dx = 1.0 / (double) intervals;
#pragma omp parallel for private(x,f) reduction(+:sum)
for (i = 1; i <= n; i++) {
    x = dx * ((double) (i - 0.5));
    f = 4.0 / (1.0 + x*x);
    sum = sum + f;
}
pi = dx*sum;
time2 = omp_get_wtime() - time1;
...