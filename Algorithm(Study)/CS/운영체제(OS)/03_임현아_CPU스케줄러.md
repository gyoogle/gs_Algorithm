# CPU 스케줄러

* #### **CPU 스케줄러란?**

  * 다중 프로그램 OS의 기본으로, 여러 프로세스들이 CPU를 교환하며 보다 생산적으로 동작한다.
  * CPU를 선점한 프로세스가 대기하는 시간을 보다 효율적으로 사용하기 위하여 사용한다.

  ![CPU scheduling](https://t1.daumcdn.net/cfile/tistory/990DB03F5C7AC10303)

  * 기본적으로 다음에 실행될 프로세스를 정하고, 프로세스들을 실행가능한 상태로 만든다.

    

* #### **비선점 vs 선점 스케줄링**

  * 스케줄링은 다음과 같은 때에 일어난다.
    1. Running → Waiting 상태 : ( ex. I/O 요청, 자식프로세스 종료 - wait() 요청을 통해 종료 )
    2. Running → Terminate 상태 : ( ex. 부모프로세스의 종료 )
    3. Running → Ready 상태 : ( ex. 인터럽트 발생 )
    4. Waiting → Ready 상태 : ( ex. I/O 완료 )
    
  * 비선점 스케줄링
    * Time-slice 가 없는 스케줄링
    * CPU를 사용중인 프로세스가 자율적으로 반납하도록 하는 방식
    * 따라서 프로세스가 자율적으로 CPU를 반납하는 시점에서 사용한다. [ 1, 2 번 시점 ]
      ![ㅇ](https://t1.daumcdn.net/cfile/tistory/998E6C405C7AC10302)
    
  * 선점 스케줄링
    * 낮은 우선순위를 가진 프로세스보다 높은 우선순위를 가진 프로세스가 CPU를 선점하는 방식
    * OS가 스케줄링의 알고리즘에 따라 적당한 프로세스에게 CPU를 할당하고, 필요시에는 회수하는 방식
    * 일반적으로 3, 4 번 시점에서 사용하지만, 상황에 따라 1, 2 에서도 스케줄링이 가능하다.
      ![ㅇ](https://t1.daumcdn.net/cfile/tistory/993815445C7AC10303)



* #### **CPU 스케줄링 알고리즘의 목적**

  * 일반적인 시스템에서는 다음과 같은 목적을 공통적으로 지닌다.
    * **No starvation** : 각각의 프로세스들이 오랜시간동안 CPU를 할당받지 못하는 상황이 없도록 한다.
    * **Fairness** : 각각의 프로세스에 공평하게 CPU를 할당해준다.
    * **Balance** : Keeping all parts of the system busy

  * Batch System [일괄처리 시스템]
    ==>  온라인처럼 일에 대한 요청이 발생했을 때, 즉각적으로 처리하는 것이 아닌 일정기간 또는 일정량을 모아뒀다가 한번에 처리하는 방식
    * **Throughput** : 시간당 최대의 작업량을 낸다.
    * **Turnaround time** : 프로세스의 생성부터 소멸까지의 시간을 최소화한다.
    * **CPU utilization** : CPU가 쉬는 시간이 없도록 한다.

  * Interactive System [대화형 시스템]
    ==> 온라인과 같이 일에 대한 요청에 대해 즉각적으로 처리하여 응답을 받을 수 있는 시스템

    * **Response time** : 즉각적으로 처리해야하는 시스템이므로 요청에 대해 응답시간을 줄이는 게 중요하다.

  * Time Sharing System
    ==> 각 프로세스에 CPU에 대한 일정시간을 할당하여 주어진 시간동안 프로그램을 수행할 수 있게하는 시스템
    * **Meeting deadlines** : 데이터의 손실을 피하며, 끝내야하는 시간 안에 도달해야한다.
    * **Predictability** : 멀티미디어 시스템에서의 품질이 저하되는 부분을 방지해야한다.

    

* #### **스케줄링 알고리즘**

  * **비선점 스케줄링 [Non-preemptive scheduling]**

    * FCFS (First Come First Served)

      * 먼저 CPU를 요청하는 프로세스를 먼저 처리하는 방식

      * 다음과 같은 프로세스 요청이 있다고 하자.

        | 프로세스 | Burst Time | Waiting Time | Turnaround Time |
        | :------: | :--------: | :----------: | :-------------: |
        |    P1    |     15     |      0       |       15        |
        |    P2    |     5      |      15      |       20        |
        |    P3    |     3      |      20      |       23        |

      * P1 → P2 → P3 순으로 프로세스가 CPU를 요청할 때, CPU는 아래와 같이 시간을 쓴다.
        ![ㅇ](https://t1.daumcdn.net/cfile/tistory/99E77B475C7AC10302)

      * P3는 P1보다 걸리는 시간(Burst time)이 짧지만, CPU를 늦게 요청했기 때문에 총 걸리는 시간(Turnaround Time)이 길다.

        **평균 Waiting Time** : (0 + 15 + 20) / 3 = 11.7

      * 만약, P3 → P2 → P1 순으로 프로세스가 CPU를 요청할 때, CPU는 아래와 같이 시간을 쓴다.
        ![스크린샷 2019-03-02 오후 7.55.17](https://t1.daumcdn.net/cfile/tistory/99E7D2475C7AC10302)

      * **평균 Waiting Time** : (0 + 3 + 8) / 3 = 2.7

      * 즉, CPU를 요청하는 프로세스의 burst time에 따라 평균 waiting time이 나빠진다.
        

    * SJF (Shortest Job First)

      * 평균 waiting time 을 최소화하기 위해 사용하는 방식

      * 버스트 시간이 짧은 프로세스부터 CPU를 할당한다.

      * 다음과 같은 프로세스가 있다고 하자

        | 프로세스 | Burst Time | Waiting Time | Turnaround Time |
        | :------: | :--------: | :----------: | :-------------: |
        |    P1    |     6      |      3       |        9        |
        |    P2    |     3      |      0       |        3        |
        |    P3    |     8      |      16      |       24        |
        |    P4    |     7      |      9       |       16        |

      * SJF에서의 스케줄링 순서는 다음과 같다.

        * P2 → P1 → P4 → P3

      * Waiting time 을 최소화하는 데는 최적이지만, burst time이 긴 프로세스은 오랜 시간 굶주려야 하므로, 위에 언급한 No starvation을 어기게 된다.
        

  * **선점 스케줄링 [Preemptive scheduling]**

    * 선점 스케줄링에는 몇가지 룰이 있다.

      * 높은 우선순위를 가지는 프로세스는 항상 먼저 스케줄되어야 한다.

        * Dynamic priority scheme : 커널안에서 프로세스의 우선순위는 지속적으로 변한다.
        * Fixed priority scheme

      * I/O-bound process는 CPU-bound process 보다 반드시 높은 우선순위에 있어야 한다.

      * Time slice 의 양은 CPU burst time 보다 조금만 더 많아야 한다.

        * time slice가 더 적을 경우, 불필요한 context switch가 많이 일어난다.
        * time slice가 훨씬 클 경우, I/O가 일어날 때에 CPU를 반납하거나, 다른 프로세스는 CPU에 굶주리는 현상이 일어날 수 있다.

      * Real-time 프로세스는 다른 프로세스에 비해 매우 높은 우선순위를 갖는다.

        

    * SRT(Shortest Remaining Time)

      * 최단 잔여시간을 우선으로 하는 스케줄링.

      * 진행 중인 프로세스가 있어도, 최단 잔여시간인 프로세스를 위해 sleep시키고 짧은 프로세스를 먼저 할당한다.

      * 선점형 SJF 스케줄링이라 불린다.

      * | 프로세스 | 도착시간 | Burst Time | 종료시간 | Waiting Time | Turnaround Time |
        | :------: | :------: | :--------: | :------: | :----------: | :-------------: |
        |    P1    |    0     |     8      |    17    |      9       |       17        |
        |    P2    |    1     |     4      |    5     |      0       |        4        |
        |    P3    |    2     |     9      |    26    |      15      |       24        |
        |    P4    |    3     |     5      |    10    |      2       |        7        |

        P1 → P2 → P3 → P4  순서대로 왔어도 도착시간에서의 잔여 시간을 비교해 CPU를 할당한다.

        ![ㅇ](https://t1.daumcdn.net/cfile/tistory/9919393F5C7AC10302)
        

    * RR(Round Robin)

      * Time Sharing System을 위해 설계된 스케줄링

      * 모든 프로세스가 같은 우선순위를 가진고, time slice를 기반으로 스케줄링한다.

      * Time slice burst가 일어나면 해당 프로세스는 스케줄링 큐의 끝으로 이동한다.
        ![ㅇ](https://t1.daumcdn.net/cfile/tistory/99F62A365C7AC10302)

      * Time slice 가 3ms 일때의 RR 스케줄링을 가지는 프로세스는 다음과 같이 동작한다.

        | 프로세스 | Burst Time | Waiting Time | Turnaround Time |
        | :------: | :--------: | :----------: | :-------------: |
        |    P1    |     13     |      10      |       23        |
        |    P2    |     7      |      3       |       10        |
        |    P3    |     3      |      12      |       15        |

        ![ㅇ](https://t1.daumcdn.net/cfile/tistory/993DF4445C7AC10302)

        평균 Waiting Time : (10 + 3 + 12) / 3 = 8.3

      * 알고리즘의 성능은 Time slice 크기와 같아진다.

        * Time slice 가 심하게 크다면 FCFS와 다를게 없다.
        * Time slice 가 너무 작다면 불필요한 Context Switch가 많이 일어난다.
          

    * Priority Scheduling (우선 순위 스케줄링)

      * 우선 순위가 높은 프로세스에 CPU를 우선 할당하는 방식의 스케줄링
      * 우선 순위는 시간 제한, 메모리 요구량, 프로세스의 중요성, 자원사용 비용 등에 따라 달라질 수 있다.
      * 우선 순위가 같을 경우, FCFS와 다를게 없다. (비선점, 선점 둘다 사용된다.)