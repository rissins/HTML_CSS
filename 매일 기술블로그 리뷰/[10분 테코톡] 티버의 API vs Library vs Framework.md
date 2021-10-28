# 매일 기술블로그 Review

# 2021-10-28

### / 링크

[[10분 테코톡] 🙆‍♀️티버의 API vs Library vs Framework](https://www.youtube.com/watch?v=We8JKbNQeLo)

### / 정리

### API ( Application Programming Interface ) ?

 → 응용 프로그램에서 운영 체제나 프로그래밍 언어가 제공하는 기능을 제어할 수 있게 만든 인터페이스

- 특징
    - 구현과 독립적으로 사양만 정의되어 있다.
    - API에 따라 접근 권한이 필요할 수 있다.
    - Java API, 여러 기업들의 오픈 API 등이 있다.
- [https://console.cloud.google.com/](https://console.cloud.google.com/) 에서 필요한 API를 사용할 수 있다.

### Library ?

- 독립성을 가진다.
- 응용 프로그램이 능동적으로 라이브러리를 사용한다.
    - 능동적 ? → 자신에게 필요한 라이브러리를 호출하여 사용한다.
- Apache Commons, Guava, Lombok, jQuery 등

### Framework ?

 → 응용 프로그램이나 소프트웨어의 솔루션 개발을 수월하게 하기 위해 제공된 소프트웨어 환경

- 특징
    - 상호협력하는 클래스와 인터페이스의 집합이다.
    - 응용 프로그램이 수동적으로 프레임워크에 의해 사용된다.
        - 수동적 ? → 예시로 Spring framwork의 경우 프레임워크가 먼저 자기 할 일을 다한 뒤 개발자가 작성한 컨트롤러를 호출해 수행한다.
    - Spring Framework, Junit, Ruby on Rails 등
    

### 정리하자면

- Library와 API의 차이점을 구현 로직의 유무이다
- Library와 Framework의 차이점은 응용 프로그램의 흐름 주도권을 누가 가지고 있느냐 이다.