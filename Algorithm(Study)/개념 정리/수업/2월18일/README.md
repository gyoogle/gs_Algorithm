## 2월 18일(월)



### 그래프

> DFS
>
> BFS



선형 자료구조 ( 1 : 1 )

비선형 자료구조 ( 1 : N ) = 그래프



트리 : 사이클이 없는 그래프

이진트리 : 차수가 최대 2개 - 포화, 완전, 편향 (순회 : 전위, 중위, 후위)

순회 : DFS, BFS



##### 그래프 유형

> 무향 그래프 : 방향이 없음~
>
> 유향 그래프 : 방향이 있음~
>
> 가중치 그래프 : 이동 비용/시간이 담긴 그래프 (ex. 최단 경로)
>
> 사이클 없는 방향 그래프 




완전 그래프 : 정점들에 대해 가능한 모든 간선들을 가진 그래프

부분 그래프 : 일부 정점이나 간선 제외한 그래프



##### 그래프 경로

> 단순경로 : 경로 중 한 정점을 최대 한 번만 지나는 경로
>
> 사이클 : 시작한 정점에서 끝나는 경로



인접 행렬 : 메모리를 너무 낭비



##### MST(최소신장트리)

> 모든 정점을 연결하는 간선들의 가중치의 합이 최소가 되는 트리
>
> 두 정점 사이의 최소 비용의 경로 찾기



##### PRIM 알고리즘

##### KRUSKAL 알고리즘
