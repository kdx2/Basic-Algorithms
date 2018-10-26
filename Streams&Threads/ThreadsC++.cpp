#include <iostream>
#include <cstdlib>
#include <pthread.h>
using namespace std;

// The idea is that C++ calls the OS to handle the threading for us.
// To realise that, the f(x) pthread_create() is used. It needs 4 parameters:
/* id_of_thread, some obj. which defines thread attributes or NULL, pointer to the
 * start function of the thread, pointer to the args of that function.
*/
// The thread is terminated by pthread_exit(status);
// source: https://www.tutorialspoint.com/cplusplus/cpp_multithreading.htm

#define NUM_THREADS 5

void *PrintHello(void * threadid) {
    long tid;
    tid = (long)threadid;
    std::cout<<"Hello world! Thread ID = "<< tid << endl;
    pthread_exit(NULL);
}

int main() {
    pthread_t threads[NUM_THREADS];
    int rc;

    int * i;
    for (i=0; *i<NUM_THREADS; i++) {
        std::cout << "main() : creating thread #" << i << endl;
        rc = pthread_create(&threads[*i], NULL, PrintHello, (void *) i);

        if (rc) {
            std::cout << "Error: unable to create thread #" << rc << endl;
            exit(-1);
        }
    }
    pthread_exit(NULL);
    return 0;
}