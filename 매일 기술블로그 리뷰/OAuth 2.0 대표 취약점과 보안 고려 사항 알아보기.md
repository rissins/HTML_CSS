# 매일 기술블로그 Review

# 2021-11-04

### / 링크

[OAuth 2.0 대표 취약점과 보안 고려 사항 알아보기 : NHN Cloud Meetup](https://meetup.toast.com/posts/105)

### / 정리

- OAuth 1.0에 대해 설명한  [https://github.com/rissins/study/blob/master/매일 기술블로그 리뷰/OAuth와 춤을.md](https://github.com/rissins/study/blob/master/%EB%A7%A4%EC%9D%BC%20%EA%B8%B0%EC%88%A0%EB%B8%94%EB%A1%9C%EA%B7%B8%20%EB%A6%AC%EB%B7%B0/OAuth%EC%99%80%20%EC%B6%A4%EC%9D%84.md)을 미리보는 것 추천 !

## 1. OAuth 2.0 ?

- 제 3의 앱이 자운의 소유자인 서비스 이용자를 대신하여 서비스를 요청할 수 있도록 자원 접근 권한을 위임하는 방법

### 용어

```
사용자 : Resource Owner

클라이언트 : Client

API 서버 : Resource Server

권한 부여 서버 : Authorization Server

인증 서버 : Authentication Server
```

### Authorization Code Grant 방식

- OAuth 2.0에는 총 4 가지의 인증 방법이 있다.
- 그 중 비교적 안전한 것은 Authorization Code Grant 방식 이다.
- 대표적으로 페이코에서 적용한 인증 프로세스로 이 방식을 사용중이다.

![https://developers.payco.com/static/img/@img_guide2.jpg](https://developers.payco.com/static/img/@img_guide2.jpg)

## 2. 대표 보안 취약점 - CSRF, Covert Redirect

1. CSRF 공격을 통한 계정 탈취
    1. SNS 계정 연동할 수 있는 서비스는 하나의 서비스에 여러 개의 SNS 계정을 연결할 수 있다.
    2. 계정 연동에는 OAuth 인증과정을 거치는데, 이 때 CSRF 공격으로 피해자 계정에 공격자 계정을 연동할 수 있다.
    3. **SNS 계정 연동 Flow**
        
        ```
        1. 기존 계정과 SNS 계정 연동 요청
        2. 요청 SNS 로그인 페이지 출력 (Client ID 값이 포함된 로그인 페이지)
        3. ID/PW 를 통해 SNS 계정에 로그인
        4. 로그인 성공 시 인증 서버로부터 Authorization code를 발급 받음 (Authentication Server -> 사용자)
        5. 발급 받은 code 값과 state 값을 Client 서버로 전송 (사용자 -> Client Server)
        6. code 값과 state 값 검증 후 Client 서버에 로그인 되어있는 계정과 SNS 계정이 연동됨
        ```
        
    4. state 값은 CSRF token 연할을 하는데, 만약 state 값에 대해 검증이 누락되어 있거나 미흡할 경우 사용자 계정을 탈취할 수 있다.
    5. 5번 과정에서 Client 서버로 전송하는 내용을 추출하여 만든 CSRF 공격 페이지에 사용자가 접근하면, 사용자 계정과 공격자 계정이 연동되며, 공격자의 SNS 계정을 통해 사용자 계정으로 로그인할 수 있다.
2. Convert Redirect
    1. OAuth 2.0 인증 Flow 중 `**redirect_uri` 파라미터 값에 대해 검증이 누락되거나 미흡할 경우 발생하는 취약점**
    2. 정상적인 경로라면 사용자가 로그인 성공 후 발급받은 Authorization code를 Client로 전달해야한다.
    3. 그러나 아래의 그림과 같은 방법으로 공격자는 사용자에게 변조된 Redirect URI 를 보내 로그인을 유도한다.
    4. 4번 단계에서 사용자가 Redirect URI 값이 변조된 URL로 로그인할 경우, Authorization code 값이 공격자 서버로 전달되어 공격자는 사용자의 계쩡을 탈취할 수 있다.
        
        ![https://image.toast.com/aaaadh/alpha/2017/techblog/3%282%29.png](https://image.toast.com/aaaadh/alpha/2017/techblog/3%282%29.png)
        
    5. **대응방안**
        - Authorization Server 에서 Redirect URI 값에 대해 Full Path 검증을 진행해야 한다.
        - 도메인까지만 검증하거나 일부 경로까지만 검증하도록 조치할 경우, Redirect 취약점이 존재하는 Client는 여전히 Authorization code를 탈취할 수 있다.
    6. 예시)
        
        ```
        http://client.co.kr/OAuth/Callback?code=XXXXXXXXXXXXXXXXXXXX 에서 도메인까지만 검증할 경우
        http://client.co.kr/logout?returnURL=http%3a%2f%2fattacker.NulLBr4in.com%2fcode%2f 로 변조하게되면
        도메인이 동일하여 검증을 우회하고 공격자 서버로 code를 전송합니다.
        ```
        
        - 위 예시처럼 도메인까지만 검증할 경우, code 값에 Query string이 포함되서 공격자 서버로 전달되거나 HTTP 헤더의 Referer를 참고하여, Authorization code 값을 탈취할 수 있다.
    

## 3. 보안 검수 항목

- OAuth의 경우 취약점이 발생하면 사용자 계정 탈취로 이어지기 때문에 적용 및 구현할 때 보안에 신경을 써서 진행해야한다.
    
    ![https://image.toast.com/aaaadh/alpha/2017/techblog/4%282%29.png)
    

**OAuth 2.0 보안 검수 항복**

## 4. 마무리

- OAuth 2.0 은 안전하지만 구현이 매우 복잡하다.
- 복잡함 때문에 실제로 OAuth 2.0를 제공하는 많은 서비스에서 취약점이 발견되는데, 제대로된 구현이라면 안전하지만 복잡함에 의해 취약점의 가능성이 증가한다.
- OAuth 2.0 구현 시 충분한 이해와 준비, 검토가 요구되며 이후에도 보안 검수를 통해 취약점을 관리할 필요가 있다.