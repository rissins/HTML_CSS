# Jenkins 도입기

# 0. 자동배포

---

## - **전체 Flow**

![Untitled](Jenkins%20%E1%84%83%E1%85%A9%203233e/Untitled.png)

# 1.  `GitHub WebHook`

---

- HTTP POST를 통한 간단한 이벤트 알림을 통해 어떤 일이 발생할 때 발생하는 `HTTP POST 형식의 HTTP 콜백`
- 예로, Jenkins의 `Github WebHook`은 개발자가 마스터 브랜치에 Push할 때 빌드를 트리거하는데 사용
- Flow에서 `Github`에서 `Jenkins`로 가는 것을 알 수 있다.
- Github는 Jenkins로 json Data Type을 전송하는데 `webhook_json`을 호출한다.
    - 다음과 같은 데이터를 포함한다.
        - Git Repository Name
        - Branch which was changed
        - Commit Id
        - Commit Message
        - Commit Author
    - ****Webhook payload object common properties****
        
        
        | Key | Type | Description |
        | --- | --- | --- |
        | action | string | Most webhook payloads contain an action
         property that contains the specific activity that triggered the event. |
        | sender | object | The user that triggered the event. This property is included in every webhook payload. |
        | repository | object | The repository
         where the event occurred. Webhook payloads contain the repository
         property when the event occurs from activity in a repository. |
        | organization | object | Webhook payloads contain the organization
         object when the webhook is configured for an organization or the event occurs from activity in a repository owned by an organization. |
        | installation | object | The GitHub App installation. Webhook payloads contain the installation
         property when the event is configured for and sent to a GitHub App. For more information, see "Building GitHub App
        ." |
    - 이 외에도 호출된 상태에 따라 포함되는 데이터는 달라진다. Github의 공식문서에서 더욱 자세히 알 수 있다.
        
        [Webhook events and payloads - GitHub Docs](https://docs.github.com/en/developers/webhooks-and-events/webhooks/webhook-events-and-payloads#webhook-payload-object-common-properties)
        

- **실행 단계**
    1. Jenkins에서 필요한 플러그인을 구성한다.
    2. Git Provider에 의해 trigger 될 Jenkins 작업을 생성한다.
    3. `Webhook URL`을 가져온다.
    4. `curl`을 이용하여 테스트를 한다.
    5. Git Provider에서 `Webhook URL`을 구성한다.
    6. 일부 Git 플랫폼을 사용한 Git Push ( ex. github, bitbucket, gitlab )
    
- **WebHook URL**
    - 구성
    
    | Parameter | Description | Example |
    | --- | --- | --- |
    | jenkins host | ip or public domain | my_jenkins.com or localhost:8080 |
    | easy webhook secret key | plugin configuration | 123456789 |
    | scmId | one of the well known scm: gitlab, bitbucket or github | gitlab |
    | jobId | name of any existent jenkins job | name of any existent jenkins job |
    - 예시
    
    [http://my_jenkins.com/easy-webhook-plugin-123456789/?scmId=gitlab&jobId=hello_word_job](http://my_jenkins.com/easy-webhook-plugin-123456789/?scmId=gitlab&jobId=hello_word_job)
    
- **curl을 이용한 테스트**
    
    ```c
    curl -d @/tmp/gitlab_webhook.json \
    -H "Content-Type: application/json" \
    -X POST "http://my_jenkins.com/easy-webhook-plugin-123456789/?scmId=gitlab&jobId=hello_word_job"
    ```
    

- **Git Provider에서 WebHook URL 구성**
    - `Github`
    
    ![https://jrichardsz.github.io/images/github-webhook-configuration.png](https://jrichardsz.github.io/images/github-webhook-configuration.png)
    
- **Git Push**
    - `curl`을 이용한 테스트가 성공적이라면 `Webhook`은 모든 git 플랫폼에서 사용할 준비가 됐다.
    - 등록할 URL
        - [http://my_jenkins.com/easy-webhook-plugin-123456789/?scmId=gitlab&jobId=hello_word_job](http://my_jenkins.com/easy-webhook-plugin-123456789/?scmId=gitlab&jobId=hello_word_job)
            
            → 원하는 경우 notificationUsers와 같은 새 http 쿼리 매개변수를 추가한다.
            
        - [http://my_jenkins.com/easy-webhook-plugin-123456789/?scmId=gitlab&jobId=hello_word_job&notificationUsers=jane.doe@blindspot.com](http://my_jenkins.com/easy-webhook-plugin-123456789/?scmId=gitlab&jobId=hello_word_job&notificationUsers=jane.doe@blindspot.com)
    - 이렇게 Git Push는 몇 가지 변경 사항을 적용하고 Jenkins로 이동한다.
    
     
    

# 2. Jenkins

---

- `Git Webhook trigger`를 통해  얻은 데이터로 Jenkins는 `CI / CD` 과정으로 배포를 진행한다.

## 1)  **CI (Continuous Integration)**

---

- **지속적 통합**
- 개발을 진행하면서도 품질을 관리할 수 있도록 한다.
- 여러 명이 하나의 코드에 대해서 수정을 진행해도 지속적으로 통합하면서 관리할 수 있다.
- `CI`를 적용하게 된다면 각자 기능을 구현한 뒤, main 브랜치와 통합하고 빌드와 테스트로 상태를 확인할 수 있다.
    
    → 개발자가 직접 병합한다면 불필요한 시간 소요
    
- **자동화**를 통해 자동으로 빌드와 테스트를 검증할 수 있다.
- **CI의 간단한 순서**
    1. 개발자가 구현한 코드를 기존 코드와 병합
    2. 병합된 코드가 올바르게 동작하고 빌드되는지 검증
    3. 테스트 결과 문제가 있다면 수정하고 다시 1번으로 돌아가고, 문제가 없다면 배포를 진행
    

## 2)  **CD (Continuous Deployment and Continuous Delivery)**

---

- 소프트웨어가 항상 신뢰 가능한 수준에서 배포될 수 있도록 관리하는 개념
- **지속적 배포(Continuous Deployment), 지속적 제공(Continuous Delivery)**
    - 지속적 제공
        - CI를 통해서 새로운 소스코드의 빌드와 테스트 병합까지 성공했다면, 빌드와 테스트를 거쳐 github와 같은 저장소에 업로드하는 것을 의미
    - 지속적 배포
        - 성공적으로 병합된 내역을 저장소뿐만 아니라 사용자가 사용할수 있는 배포환경까지 릴리즈
- 지속적 배포에서는 지속적 통합을 통해 빌드한 소스코드를 테스트 가능한 알파나 베타 버전으로 만든다. 이 테스트에서 문제가 발생하면 수정 후 정식 버전으로 배포를 진행한다.

## 3) Automated CI/CD with Jenkins

---

- **Jenkins의 CI/CD Flow**

![https://miro.medium.com/max/700/0*YG-yFK5U3CVYFc7s.png](https://miro.medium.com/max/700/0*YG-yFK5U3CVYFc7s.png)

- **Jenkins 자동화 과정**
    1. Git Repository를 새로 만들거나 기존 Repository를 사용한다.
    2. 각 개발자들은 master branch가 아닌 dev-branch에 commit을 한다.
    3. Jenkins는 Github에서 코드를 가져오고 특정 작업에 대해 활성화된 task로 매핑한다.
    4. job / task 가  CD / CD가 완료되었는지 확인한다.
    5. Jenkins는 코드를 pull하고 task의 커밋단계에 진입한다.
    6. 코드와 호출된 빌드된 단계를 컴파일한다.
    7. 코드를 master에 병합하고 Jenkins에서 코드를 ubuntu에 배포한다.
    
- 참고

[https://jrichardsz.github.io/devops/devops-with-git-and-jenkins-using-webhooks](https://jrichardsz.github.io/devops/devops-with-git-and-jenkins-using-webhooks)

[https://tecoble.techcourse.co.kr/post/2021-08-14-ci-cd/](https://tecoble.techcourse.co.kr/post/2021-08-14-ci-cd/)

[https://medium.com/avmconsulting-blog/automated-ci-cd-with-jenkins-39b21c7c8035](https://medium.com/avmconsulting-blog/automated-ci-cd-with-jenkins-39b21c7c8035)