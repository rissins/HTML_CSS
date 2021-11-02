# 매일 기술블로그 Review

# 2021-11-02

### / 링크

[NAVER D2](https://d2.naver.com/helloworld/24942)

### / 정리

## OAuth ?

- 인증을 위한 오픈 스탠더드 프로토콜
- 사용자가 Facebook이나 트위터 같은 인터넷 서비스의 기능을 다른 애플리케이션에서도 사용할 수 있게 한 것
- 2010년 IETF OAuth 워킹그룹에 의해 IETF 표준 프로토콜로 발표
- Auth는 'Authentication(인증)' 뿐만 아니라 'Authorization(허가)' 를 포함
    - OAuth 인증을 진행할 때 해당 서비스 제공자는 '제 3자가 어떤 정보나 서비스에 사용자의 권한으로 접근하려 하는 허용하겠느냐'라는 안내 메시지를 보여준다.

## OpenID와 OAuth

- OpenID
    - 주요 목적 → 인증(Authentication)
    - Open ID를 사용하는 여러 서비스(Relying Party)는 OpenID Provider에게 인증을 위임
- OAuth
    - 주요 목적 → 허가(Authorization)
    - 해당 사용자의 담벼락(wall)에 글을 쓸 수 있는 API를 호출할 수 있는 권한이나, 친구 목록을 가져오는 API를 호출할 수 있는 권한이 있는 사용자인지 확인하는 것

## OAuth 인증 과정

- OAuth의 대표용어
    - User : Service Provider에 계정을 가지고 있으면서, Consumer를 이용하려는 사용자
    - Service Provider : OAuth르 사용하는 Open API를 제공하는 서비스
    - Consumer : OAuth 인증을 사용해 Service Provider의 기능을 사용하려는 애플리케이션이나 웹 서비스
    - Request Token
        - Consumer가 Service Provider에게 접근 권한을 인증받기 위해 사용하는 값.
        - Access Token으로 교환
    - Access Token : 인증후 Consumer가 Service Provider의 자원에 접근하기 위한 키를 포함한 값
    
    **OAuth 1.0a 인증과정**
    
    ![https://oauth.net/core/diagram.png](https://oauth.net/core/diagram.png)
    
    - Access Token : 쉽게 말해 방문증. 이 방문증으로 Consumer는 하전에 호출이 허락된 Service Provider의 오픈 API를 호출할 수 있는 것
- Request Token
    - Consumer가 Request Token 발급을 요청하고 Service Provider가 Request Token을 발급하는 과정을 "저 ~~인데 ~~를 만날 수 있을까요?" 라고 묻는 것과 같다.
    

**네이버의 OAuth API로 Request Token을 요청하는 예**

```java
GET /naver.oauth?mode=req_req_token&oauth_callback=http://example.com/OAuthRequestToken.do&oauth_consumer_key=WEhGuJZWUasHg&oauth_nonce=zSs4RFI7lakpADpSsv&oauth_signature=wz9+ZO5OLUnTors7HlyaKat1Mo0=&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1330442419&oauth_version=1.0 HTTP/1.1  
Accept-Encoding: gzip, deflate  
Connection: Keep-Alive  
Host: nid.naver.com
```

매개변수를 기준으로 정리

```java
GET http://nid.naver.com/naver.oauth?mode=req_req_token&  
oauth_callback=http://example.com/OAuthRequestToken.do&  
oauth_consumer_key=WEhGuJZWUasHg&  
oauth_nonce=zSs4RFI7lakpADpSsv&  
oauth_signature=wz9+ZO5OLUnTors7HlyaKat1Mo0=&  
oauth_signature_method=HMAC-SHA1&  
oauth_timestamp=1330442419&  
oauth_version=1.0 HTTP/1.1
```

- 
    - Request Token 발급 요청시 사용하는 매개변수
        - oauth_callback
            - Service Provider가 인증을 완료한 후 리다이렉트할 Consumer의 웹 주소
            - 만약 Consumer가 웹 애플리케이션이 아니라 리다이렉트할 주소가 없다면 소문자로 'oob'(Out Of Band라는 뜻)를 값으로 사용
        - oauth_consumer_key
            - Consumer를 구별하는 키 값. Service Provider는 이 키 값으로 Consumer를 구분
        - oauth_nonce
            - Consumer에서 임시로 생성한 임의의 문자열
            - oauth_timestamp의 값이 같은 요청에서는 유일한 값이어야 한다. 이는 악의적인 목적으로 계속 요청을 보내는 것을 막기 위해서이다.
        - oauth_signature
            - OAuth 인증 정보를 암호화하고 인코딩하여 서명 값
            - OAuth 인증 정보는 매개변수 중에서 oauth_signature를 제외한 나머지 매개변수와 HTTP 요청 방식을 문자열로 조합한 값이다. 암화 방식은 oauth_signature_method에 정의
        - oauth_signature_method
            - oauth_signature를 암호화하는 방법. HMAC-SHA1, HMAC-MD5 등을 사용
        - oauth_timestamp
            - 요청을 생성한 시점의 타임스탬프. 1970년1월 1일 00시 00분 00초 이후의 시간을 초로 환산한 초 단위의 누적 시간
        - oauth_version
            - OAuth 사용 버전. 1.0a는 1.0이라고 명시
        
- **oauth_signature 만들기**
    - 암호화 알고림즘을 이용하여 만든다.
    1. 요청 매개변수를 모두 모은다
        1. 'oauth_'로 시작하는 OAuth 관련 매개변수를 모은다.
    2. 매개변수를 정규화(Normalize)
        1. 모든 매개변수를 사전순으로 정렬하고, 각각의 키와 값에 URL 인코딩을 적용한다.
        2. URL 인코딩을 실시한 결과를 = 형태로 나열하고 각 쌍 사이에는 & 을 넣는다.
        3. 이렇게 나온 결과 전체를 또 URL 인코딩을 적용한다.
    3. Signature Base String을 만든다.
        1. HTTP method 명 (GET 또는 POST), Consumer가 호출한 HTTP URL 주소(매개변수 제외), 정규화한 매개변수를 &를 사용해 결합한다.
        2. 즉 '[GET|POST] + & + [URL 문자열로 매개변수는 제외] + & + [정규화한 매개변수]' 형태가 된다.
    4. 키 생성
        1. 3번 과정까지 거쳐 생성한 문자열을 암호화하고 암호화할 때 Consumer Secret Key를 사용한다.
        2. Consumer Secret Key를 Consumer가 Service Provider에 사용 등록을 할 때 발급받은 값이다 
        3. HMAC-SHA1 등의 암호화 방법을 이용하여 최종적인 oauth_signautre를 생성한다.
        
- **사용자 인증 페이지의 호출**
    - '안내데스크에서 김목적씨에게 방문한 손님이 있으니 안내 데스크와서 확인을 요청하는 것 ' 에 비유
    - Request Token을 요청하면, Service Provider는 Consumer에 Request Token으로 사용할 oauth_token과 oauth_token_secret을 전달
    - Access Token을 요청할 때는 Request Token의 요청에 대한 응답 값으로 받은 oauth_token_secret을 사용
    - Consumer가 웹어플리케이션이라면 HTTP 세션이나 쿠키 또는 DBMS 등에 oauth_token_secret을 저장해 놓아야 한다
    - oauth_token을 이용해 Service Provider가 정해 놓은 사용자의 인증 페이지를 User에게 보여준다.
        - 네이버의 OAuth용 사용자 인증 페이지 주소
            - 
            
            ```java
            https://nid.naver.com/naver.oauth?mode=auth_req_token
            ```
            
        - 여기에 Request Token을 요청해서 반환받은 oauth_token을 매개 변수로 전달
            - 사용자 인증화면을 가르키는 URL
                
                
            
            ```java
            https://nid.naver.com/naver.oauth?mode=auth_req_token&oauth_token=wpsCb0Mcpf9dDDC2
            ```
            
    - 로그인 화면을 호출하는 단계
        - 안내 데스크에서 김목적씨에게 전화하는 단계
        - 김목적씨가 안내데스크로 와서 나방문씨를 확인해야 하는데, 정말 나방문씨가 맞는지 아닌지 확인하는 과정이 필요
            - 이 과정이 OAuth에서 Service Provider에서 User를 인증하는 과정
            
- **Access Token 요청하기**
    - OAuth에서의 Access Token은 나방문 씨에게 지급할 방문증과 같다.
    - Access Token을 요청하는 방법은 Request Token을 요청하는 방법과 거의 같다.
        - 사용하는 매개변수의 종류가 약간 다르고 oauth_signature를 생성할 때 사용하는 키가 다르다.
        - Access Token을 요청할 때에는 매개변수 oauth_callback은 없고, oauth_token과 oauth_verifer가 있다.
    - Request Token 발급을 요청할 때에는 Consumer Secret Key를 사용해 oauth_token_secret를 생성했다.
    - 하지만 Access Token 발급을 요청할 때에는 Consumer Secret Key에 oauth_token_secret을 결합한 값(Consumer Secret Key + & + oauth_token_secret)을 사용해 aouth_token_secret를 생성한다.
    - Access Token 발급을 요청할 때 사용한 매개변수
        - oauth_consumer_key
            - Consumer를 구별하는 키 값. Service Provider는 이 키 값으로 Consumer를 구분한다.
        - oauth_nonce
            - Consumer에서 임시로 생성한 임의의 문자열. oauth_timestamp의 값이 같은 요청에서는 유일한 값이어야 한다.
            - 이는 악의적인 목적으로 계속 요청을 보내는 것을 막기 위해서이다.
        - oauth_signature
            - OAuth 인증 정보를 암호화하고 인코딩하여 서명 값.
            - OAuth 인증 정보는 매개변수 중에서 oauth_signature를 제외한 나머지 매개변수와 HTTP 요청 방식을 문자열로 조합한 값이다. 암화 방식은 oauth_signature_method에 정의된다.
        - oauth_signature_method
            - oauth_signature를 암호화하는 방법.  HMAC-SHA1, HMAC-MD5 등을 사용
        - oauth_timestamp
            - 요청을 생성한 시점의 타임스탬프. 1970년1월 1일 00시 00분 00초 이후의 시간을 초로 환산한 초 단위의 누적 시간
        - oauth_version
            - OAuth 사용 버전
        - oauth_verifier
            - Request Token 요청 시 oauth_callback으로 전달받은 oauth_verifier 값
        - oauth_token
            - Request Token 요청 시 oauth_callback으로 전달받은 oauth_token 값
    - 위의 표에 정의한 매개변수를 상황에 맞게 정의한 다음 Access Token을 요청하면 oauth_token과 oauth_token_secret을 전달받게 된다.
    - Service Provider에 따라 사용자의 아이디나 프로필 정보 같은 것들이 반환되기도 한다.
        
        
- **Access Toekn 사용하기**
    - 방문증이 발급됐고, 출입문을 통과하는 일이다.
    - User의 권한으로 Service Provider의 기능을 사용하는 것과 비슷하다.
    - 권한이 필요한 오픈 API를 호출할 수 있게 되는 것이다.
    - 네이버 카페에서 게시판 목록을 가져오기위한 URL
        - 
        
        ```java
        http://openapi.naver.com/cafe/getMenuList.xml
        ```
        
    - 특정 User의 권한을 가지고 카페 게시판 목록 반환 URL을 요청해야 해당 User가 가입한 카페의 게시판 목록을 반환받을 수 있을 것이다.
    - 이 URL을 호출할 떄에는 OAuth 매개변수를 함께 전달해야 한다.
- **Access Token을 사용해 오픈 API를 요청하는 예**
    - HTTP 헤더에 Authorization 필드를 두었고, Authorization 필드의 값 부분에 OAuth 매개변수 적는다
    - Access Token을 사용할 때는 GET이나 POST가 아닌 HEAD 방식을 사용한다.
    - 
    
    ```java
    POST /cafe/getMenuList.xml HTTP/1.1  
    Authorization: OAuth oauth_consumer_key="dpf43f3p2l4k3l03",oauth_token="nSDFh734d00sl2jdk"  
    ,oauth_signature_method="HMACSHA1",oauth_timestamp="1379123202",oauth_nonce="chapoH",oauth_signature="MdpQcU8iPSUjWoN%2FUDMsK2sui9I%3D"
    Accept-Encoding: gzip, deflate  
    Connection: Keep-Alive  
    Host: http://openapi.naver.com
    ```
    
    - Authorization필드를 매개변수를 기준으로 정리
    
    ```java
    Authorization: OAuth oauth_consumer_key="dpf43f3p2l4k3l03",  
    oauth_token="nSDFh734d00sl2jdk",  
    oauth_signature_method="HMACSHA1",  
    oauth_timestamp="1379123202",  
    oauth_nonce="csrrkjsd0OUhja",  
    oauth_signature="MdpQcU8iPGGhytrSoN%2FUDMsK2sui9I%3D"
    ```
    
    - Access Token을 사용해 오픈 API를 호출할 때 사용하는 매개변수
        - oauth_consumer_key
            - Consumer를 구별하는 키 값. Service Provider는 이 키 값으로 Consumer를 구분한다.
        - oauth_nonce
            - Consumer에서 임시로 생성한 임의의 문자열
            - oauth_timestamp의 값이 같은 요청에서는 유일한 값이어야 한다. 이는 악의적인 목적으로 계속 요청을 보내는 것을 막기 위해서이다.
        - oauth_signature
            - OAuth 인증 정보를 암호화하고 인코딩하여 서명 값
            - OAuth 인증 정보는 매개변수 중에서 oauth_signature를 제외한 나머지 매개변수와 HTTP 요청 방식을 문자열로 조합한 값
            - 암화 방식은 oauth_signature_method에 정의
        - oauth_signature_method
            - oauth_signature를 암호화하는 방법.  HMAC-SHA1, HMAC-MD5 등을 사용
        - oauth_timestamp
            - 요청을 생성한 시점의 타임스탬프. 1970년1월 1일 00시 00분 00초 이후의 시간을 초로 환산한 초 단위의 누적 시간
        - oauth_version
            - OAuth 버전
        - oauth_token
            - oauth_callback으로 전달받은 oauth_token
            

## OAuth 2.0

- OAuth 1.0은 웹 애플리케이션이 아닌 애플리케이션에서는 사용하기 곤란하다는 단점이 있다.
- 또한 절차가 복잡하여 OAuth 구현 라이브러리를 제작하기 어렵고, 이런저런 복잡한 절차 때문에 Service Provider에게도 연산 부담이 발생한다.

- **OAuth 2.0의 특징**
    - 웹 애플리케이션이 아닌 애플리케이션 지원 강화
    - 암호화가 필요 없음 HTTPS를 사용하고 HMAC을 사용하지 않는다.
    - Siganature 단순화 정렬과 URL 인코딩이 필요 없다.
    - Access Token 갱신 OAuth 1.0에서 Access Token을 받으면 Access Token을 계속 사용할 수 있었다. 트위터의 경우에는 Access Token을 만료시키지 않는다. OAuth 2.0에서는 보안 강화를 위해 Access Token의 Life-time을 지정할 수 있도록 했다.