# 매일 기술블로그 Review

# 2021-10-26

### / 링크

[deploy 브랜치 전략 활용 방법](https://medium.com/daangn/deploy-%EB%B8%8C%EB%9E%9C%EC%B9%98-%EC%A0%84%EB%9E%B5-%ED%99%9C%EC%9A%A9-%EB%B0%A9%EB%B2%95-545f278ca878)

### / 소감

// 협업에서 Git은 필수적인 요소가 되었다. 개인 프로젝트를 기능마다 커밋을 하면 버전 관리는 물론, 잘못된 수정으로 치명적 오류가 생겼을 때 이전 버전으로 되돌리는 등 잘 이용하면 모든 것이 너무나 편한 시스템이 된다. 대부분 각자 맡은 구역을 branch로 나눠서 커밋을 기록하고 code review와 pr을 통해 최종 확인을 받고 merge한다. 

 당근마켓은 초반엔 적은 인원이 빠른 개발을 하는 거을 목적으로 했기 때문에 특별한 브랜치 전략 없이 작업 후 테스크 코드를 develop 브랜치에 merge하고 서비스 배포시 master 브랜치에 develop 브랜치를 merge해서 배포는 방식으로 사용했다고 한다. 하지만 서비스가 성장하면서 다양한 기능들을 구현하기위해 더 많은 개발자들이 협업을 해야했다. 이럴 때 발생한 다양한 git branch 전략 문제와 해결 방안에 대해 들어볼 수 있었다.

 개인의 git 스타일대로하다가 협업의 규모와 인원이 커지면 Gitflow, GitHub flow, Gitlab flow 등 일명 Git 브랜치 전략이라고 한다.  당근마켓에서는 Gitflow를 기반으로 바꿔나갔다. 

 Gitflow에는 master, develop, feature, release, hotfix 브랜치로 구성되어 있다.

- **master:** Stable 한 코드의 Archive이며 master 브랜치로 배포하면 언제든지 stable 한 상태의 코드가 배포
- **develop:** Deploy-ready 상태의 코드가 있는 브랜치로 release 브랜치와 새로운 feature 브랜치 생성의 base가 되는 브랜치임. develop 브랜치에 들어왔다는 것은 테스트가 완료되고 언제든 배포해도 된다는 의미
- **feature:** 작업 브랜치로 develop 브랜치를 기준으로 생성
- **release:** 배포가 나갈 때 생성하는 브랜치로 develop 브랜치를 기준으로 생성하며 배포 & 모니터링이 끝난 이후에 develop 브랜치와 master 브랜치로 merge
- **hotfix:** master 브랜치에 release 브랜치가 merge된 이후에 예상치 못한 버그나 문제가 발생했을 때 빠르게 수정하기 위한 브랜치임. master 브랜치를 기준으로 생성해서 고쳐야 할 기능만 고쳐서 배포한 후에 문제가 마무리되면 develop 브랜치와 master브랜치로 merge

 gitflow가 협업에는 큰 문제가 없지만 실제로 테스트 서버와 프로덕션 서버를 운영하는 환경에서는 문제가 생겼다고 한다.  인프라 서버의 자원은 풍부해 feature 브랜치 별로 테스트가 가능했지만 프로덕션의 서버 경우 release 브랜치를 이용해 배포가 가능하다. 하지만 feature 브랜치를 테스트할려면 다른 사람의 테스트를 기다려야 한다는 것이다. 

 이를 해결하기 위해 deploy 브랜치란 전략을 사용했다고 한다. deploy 전략의 구성으로는

- 각 기능은 feature 브랜치에서 개발하며 기준 브랜치는 develop 브랜치
- **deploy 브랜치 마스터**(deploy 브랜치의 잘못된 사용을 막아주는 모더레이터 역할)가 브랜치 라이프 사이클에 맞춰 develop 브랜치 기준으로 deploy 브랜치를 생성 (ex. deploy/02)
- deploy 브랜치는 테스트 서버에 배포되는 브랜치이며 CI를 운영하는 것을 권장
- 테스트 서버에서 테스트가 필요한 feature 브랜치를 각자가 deploy 브랜치에 merge commit과 함께 merge
- deploy 브랜치에서의 기능 테스트가 끝나면 각 feature 브랜치는 Pull-request를 통해 develop 브랜치로 merge
- develop 브랜치에 commit이 추가되면 deploy 브랜치는 이 commit을 항상 merge 하여 최신 develop 브랜치 코드를 따라가야 함.

 이와 같은 전략을 사용하면 테스트 서버에서 각 feature 브랜치를 한 브랜치에 묶어서 배포할 수 있다.

 deploy 방법이 모두가 기다리지 않고 테스트 서버에 배포 할 수 있다. 하지만 새로운 개념이기에 처음하는 사람은 헷갈리고 테스트 서버 전용 브랜치이기 때문에 누군가의 실수로 테스트 서버에 장애가 생길 수도 있다. 

 협업에서 기존의 방식이 체계적이라도 환경이나 제공하는 서비스에 따라 각자의 몸에 맞게 바꿔야 할 순간이 온다. 그럴 때 위와 같은 방법으로 어떻게 하면 더 나은 해결책을 강구한다면 성장하는 계기가 될 것 같다.