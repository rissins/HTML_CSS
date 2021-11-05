# 매일 기술블로그 Review

# 2021-11-05

### / 링크

[git cherry-pick: 다른 브랜치의 일부 커밋만 반영하고 싶을 때 : NHN Cloud Meetup](https://meetup.toast.com/posts/45)

### / 정리

## git cherry-pick: 다른 브랜치의 일부 커밋만 반영하고 싶을 때

- git을 사용할 때 대부분 master 브랜치를 이용해서 운영을 한다.  가끔 중, 대규모 개편을 하게 되면 브랜치 두 개를 동시에 관리해야 할 애로사항이 생긴다.

```
git branch
master
next-release
```

- 2개의 브랜치가 있을 때 master는 운영중인 브랜치고, next-release 는 대규모 개편때 반영될 코드이다.
- 만약 master와 next-release 둘 다 반영해야 할 오타가 발견되면 다음과 같이 하면 된다.

```
git checkout master
git commit -m -am "fixted: typo"
git log --pretty=oneline
b14b975 fixed: typo
9f57292 ...
...
```

- master에 이렇게 반영된 뒤 next-release에 반영하기 위해선 다음과 같이 하면 된다.

```
git checkout next-release
git cherry-pick b14b975
git log --pretty=oneline
23fa1e76 fixed: typo
dd0f27c ...
...
```

- git flow , 즉 feature/BTS-### 같은 브랜치를 따서 merge 하는 방식으로 운영하는 경우, 굳이 cherry-pick을 이용할 필요까지는 없다.
- single master branch 위에서 작업하는 방식으로 진행하는 방식에 유용하다.