
<div align="center">
  <img src="https://ifh.cc/g/TjraG8.png" style="width:300px">
</div>

### 🌏프로젝트 개요🌏
- 환경 보호의 중요성이 점점 더 강조되는 현대 사회에서, <br>지속 가능한 미래를 위한 실천 정보를 공유할 수 있는 **친환경 통합 플랫폼**을 구현하였습니다.
- 개발 기간 : 2023.07.24 ~ 2023.08.18
- 팀원 : [권서현](https://github.com/seohyunkwon), [박지영](https://github.com/jiyoung3725), [우종호](https://github.com/Woo-JongHo), [류예인](https://github.com/Poony95), [전수진](https://github.com/Sujin524-Jeon)

---
<br>

### 📚 Stacks 📚
- Environment
  <br>
  ![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)
  ![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
  ![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
- BackEnd
  <br>
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=openjdk&logoColor=white">
  <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  <img src="https://img.shields.io/badge/springsecurity-6DC03F?style=for-the-badge&logo=springsecurity&logoColor=white">
  <img src="https://img.shields.io/badge/springdatajpa-006600?style=for-the-badge&logo=spring&logoColor=white"><br>
  ![Twitter](https://img.shields.io/badge/MYBATIS-%23121011.svg?style=for-the-badge&logo=Twitter&logoColor=white)
  ![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)
  <img src="https://img.shields.io/badge/Oracle DB-F80000?style=for-the-badge&logo=oracle&logoColor=white">
  
- FrontEnd
  <br>
  ![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
  ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)
  ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
  ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
  ![Bootstrap](https://img.shields.io/badge/bootstrap-%238511FA.svg?style=for-the-badge&logo=bootstrap&logoColor=white)
- Communication
  <br>
  ![Notion](https://img.shields.io/badge/Notion-%23000000.svg?style=for-the-badge&logo=notion&logoColor=white)



### 🛠️ 상세 기능 설명 🛠️
- [🔗기능 구현 동영상](https://youtu.be/FuylE0zLmVo)

|<img src="https://ifh.cc/g/3DVmLS.jpg" style="width:400px">|<img src="https://ifh.cc/g/aw52h0.jpg" style="width:400px">|
|------|------|
|메인|회원가입|
|<img src="https://ifh.cc/g/3ojWOp.png" style="width:400px;height:auto">|<img src="https://ifh.cc/g/ZwLnAq.png" style="width:400px">|
|로그인|아이디/비밀번호 찾기|
|<img src="https://ifh.cc/g/rV2ZXY.jpg" style="width:400px">|<img src="https://ifh.cc/g/D9k62Q.jpg" style="width:400px">
|마이페이지-주문내역|마이페이지-상세주문내역|
|<img src="https://ifh.cc/g/3BFt66.png" style="width:400px;height:450px;">|<img src="https://ifh.cc/g/JqSaTS.png" style="width:400px">|
|마이페이지-사이드바|회원정보 수정|


- 메인
  - 전체적인 화면 디자인
  - 실시간 인기 상품, 인기 교육 프로그램 조회
- 로그인 및 회원가입
  -   Spring Security를 사용한 로그인/회원가입 구현
  -   OAuth2.0 기반 소셜 로그인 구현
  -   카카오 지도 API 연동 주소 검색 구현
  -   이메일 인증을 통한 아이디/비밀번호 찾기
- 마이페이지
  -  Session에 저장된 User 정보 기반으로 작동
  -  회원 정보 수정 기능 구현
  -  주문내역 목록 조회 기능 구현
  -  상세 주문 내역 조회 및 주문 취소, 후기 작성 구현

  <br>


### 🔑 Spring Security 🔑
- [🔗코드 바로가기](https://github.com/seohyunkwon/wearthProject/tree/master/src/main/java/com/example/demo/security)
- Bcrypt 단방향 암호화를 사용하여 사용자 정보의 보안성을 높였습니다.
- OAuth2.0 기반 소셜 로그인을 적용하여 소셜 로그인을 구현했습니다.
  - ```OAuth2UserService```를 상속받은 ```CustomOAuth2UserService```를 구현하여, 기존 회원 여부를 확인하고 로그인/회원가입을 진행했습니다.
  - ```KakaoLoginService```를 생성하여, 카카오 유저 정보를 받아왔습니다.
  - ```Role``` Enum을 생성하고, ```SecurityConfig```에서 ```Role```에 따른 사용자 레벨을 관리했습니다.
<br>

### 💾 담당 기능 파일구조💾

```

📦src
 ┣ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂example
 ┃ ┃ ┃ ┃ ┗ 📂demo
 ┃ ┃ ┃ ┃ ┃ ┣ 📂controllera
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MypageController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserinfoController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MypageMybatisRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserJpaRepository.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂security
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CustomOAuth2UserService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaoLoginService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OAuth2Attributes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Role.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SecurityConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SessionUser.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserDetailServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyPageService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyPageServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserInfoService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserInfoServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂utils
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CustomMailSender.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MailConfig.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜WearthProjectApplication.java
 ┃ ┣ 📂resources
 ┃ ┃ ┣ 📂static
 ┃ ┃ ┃ ┣ 📂js
 ┃ ┃ ┃ ┃ ┗ 📂userinfo
 ┃ ┃ ┃ ┃ ┃ ┣ 📜login.js
 ┃ ┃ ┃ ┃ ┃ ┗ 📜signup.js
 ┃ ┃ ┃ ┃ ┣ 📂Side
 ┃ ┃ ┃ ┃ ┃ ┗ 📜Sidebar.html
 ┃ ┃ ┃ ┣ 📂main
 ┃ ┃ ┃ ┃ ┗ 📜main.html
 ┃ ┃ ┃ ┣ 📂shop
 ┃ ┃ ┃ ┃ ┣ 📜order.html
 ┃ ┃ ┃ ┣ 📂userinfo
 ┃ ┃ ┃ ┃ ┣ 📜login.html
 ┃ ┃ ┃ ┃ ┣ 📜signup.html
 ┃ ┃ ┃ ┃ ┗ 📜test.html
 
```
