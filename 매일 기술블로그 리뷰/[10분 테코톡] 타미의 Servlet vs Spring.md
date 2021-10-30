# 매일 기술블로그 Review

# 2021-10-30

### / 링크

[[10분 테코톡] 🌻타미의 Servlet vs Spring](https://www.youtube.com/watch?v=2pBsXI01J6M)

### / 정리

### Servlet ?

- 웹 어프리케이션을 만들 때 필요한 인터페이스

### 탄생

- 처음 웹 프로그래밍은 정적 페이지만 불러와서 어느 사용자가 와도 같은 페이지를 출력했다.
- 사용자에 따라 다른 처리를 해줄 수 없었다.
- 그래서 동적 데이터를 처리하는 CGI의 탄생
    - CGI ?    Web Server와 프로그램 사이의 규약,  C , PHP
    - 하지만 구현체를 만들 때마다 Process를 필요해 Thread 로 변경
    - 그래서 여러 Instance에서 Singleton으로 변경 —> 오늘 날의 Servlet

### 특징

- WebContainer
    - 요청이 들어오면 Thread를 생산하고, Servlet을 실행시킨다.
    - Servlet Inteface에 따라 Servelt을 관리한다.
- 크게 Init, Service, Destroy 로 구분
    - Init : Servlet Instance 생성 (initialize)
    - Service : 실제 기능이 수행되는 곳
    - Destroy : Servlet Instance가 사라진다.
    - 각 메서드는 Servlet Container(Tomcat)이 호출
    

### 과정

1. Web.xml (설정 파일) Servlet Mapping을 WAS에게 Servlet 객체 - URL mapping 정보를 알려준다.
2. host에서 Request의 Parameter를 받는다.
3. 비지니스 로직을 처리한다
4. 결과를 담은 View를 만들어 Client한테 전송한다.

### Spring Web MVC 에서의 Servlet

- Dispatcher Servlet

1. 모든 요청이 들어왔을 때, Dispatcher Servlet으로 간다.
2. 요청에 따라 적절한 Controller를 찾는다.
    1. 찾는 방법은 Spring Framework에서 제공한다.
        1. BeanNameHandlerMapping : Bean 이름과 Url 을 Mapping하는 방식
        2. ControllerClassNameHandlerMapping
        3. SimpleUrlHandlerMapping
        4. DefaultAnnotaionHandlerMapping : Annotaion으로 Url과 Mapping하는 방식
3. 위에서 맞는 방식을 사용할지 설정파일에 저장한다.
    1. Servlet을 등록하면 그 Servlet이 사용할 설정파일이 자동으로 등록된다.
4. HandlerMapping에서찾은 Handler(Controller)의 메서드를 호출하고 ModelAndView 형태로 바꿔준다.
5. View 이름으로 실제 View 객체를 생성한다.
6. View에서 Model(data)를 포함시킨다.

 

### Spring Web MVC 있을 때와 없을 때

Url마다 Servlet을 생성하고 Web.xml으로 servlet 관리 

 → Servlet은 DispatcherServlet 1개로 관리

Servlet에서 View로 보내주는 것 까지 만들어야 했다

→ View를 강제로 분리시키는 효과를 볼 수 있었다.