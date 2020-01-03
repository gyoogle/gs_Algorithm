## 7강 - 3D NAND Flash의 이해(FEOL) 

<br>

##### NAND Flash

메모리 반도체에서 전원이 끊겨도 데이터를 보존하는 대표적인 비휘발성 메모리

- Planar NAND (2차원 평면에 집적)
- 3D NAND (3차원 구조로 집적)

<br>

##### 기존의 Planar Flash Memory 방식

웨이퍼당 더 많은 Chip을 생산하기 위해 Wafer Size를 증가시키고, Cell Size를 축소시켜왔다.

하지만 10nm 이하의 집적도에서 정보 저장의 물리적 한계가 존재했다. (인접한 저장 Cell 사이에서 간섭 현상 때문)

최근에는 MLC(Multi-Level Cell)과 3D Flash를 통해 집적도를 향상시켜 더 많은 Chip을 생산하게 되었다.

<br>

3D NAND 방식은, 트랜지스터를 아파트 구조처럼 3차원 수직으로 쌓아올리며 저장 공간 집적도, 속도와 내구성, 소비 전력 향상을 이뤄냈다.

<br>

#### FEOL 공정

> *FEOL : Front End Of Line*

주변 회로와 Cell 영역을 형성하고, 평탄화 공정 단계를 거친다.

##### 구성 요소

- ACT/GATE

  - IIP Layer 형성

    > *IIP : Ion Implantation (이온 주입 공정)*

    반도체가 전기적 특성을 갖게 하기 위해 이온을 필요한 영역에 주입하는 공정

  - 주변 회로(Low & High Voltage Transistor) 구분

  - 주변회로(Peri) 형성

  ```
  [Active]
  반도체층에 소스와 드레인을 연결할 수 있는 채널이
  생겨 전류를 흐를 수 있게 함
  
  [Gate]
  Gate 전압으로 Active 채널을 형성하여 전류를 흐르거나
  차단하는 역할을 함
  ```

  <br>

- MOLD/WLPAD

  - 3D NAND Flash의 Cell Transistor 영역 형성

  Mold Depo를 하여 Cell Word Line 영역을 형성한 뒤, Cell Word Line에 배선을 연결하기 위한 WLPAD 공정을 진행함

  - Mold를 계단 모양으로 식각하여 배선을 연결하는 자리를 만듦
  - WLPAD를 형성한 후 TEOS 막질을 Deposition
  - TEOS 막질 Deposition은 Cell - Peri 간 단차를 맞추기 위한 역할

  <br>

- ILD3

  - Cell - Peri 영역 평탄화

  ILD3 TEOS Deposition 후 Cell 영역의 TEOS 식각 후 CMP 공정으로 Cell과 Peri 간의 단차를 맞춤

<br>

##### CMP (Chemical Mechanical Polishing)

화학 요소와 기계적 요소를 결합한 Polishing을 통한 Wafer의 막질을 Global하게 평탄화시키는 공정

<br>

이렇게 FEOL 공정이 마무리되면 후속 공정인 Ch. Hole 공정으로 넘어가게 된다.

