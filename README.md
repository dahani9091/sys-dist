# java.util.Random
-  Random rand;
-  int ranomNum = rand.nextInt(max-min+1)+1 
# Threads:
- extends Thread :
    - Thread.sleep(ms)
    - Lunch in main:
        - ThreadClassName objName = new ThreadClassName(...)
        - objName.start()
- implements Runnable : 
    - Lunch in main:
        - ThreadClassName objName = new ThreadClassName(...)
        - Thread thrd1 = new Thread(objName,"name1")
        - Thread thrd2 = new Thread(objName,"name2")
    - Thread.currentTread.getName() # get thread name
- synchronized(this), wait, notifyAll (watch BlockingList) 
    - `You can create 2 runnables one for producer and the other for consumer, both they have a while loop to the call function (put -> prod and take -> cons) of the same instance from Blocking List `
