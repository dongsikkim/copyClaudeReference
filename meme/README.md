# 최해니 이동능력 해금 🎮

조카의 첫 기는 순간을 **게임 스킬 해금 화면** 컨셉으로 만든 짤 생성기입니다.

| | |
|---|---|
| 출력 | `meme/out/haeni-mobility-unlocked.png` (1080 × 1920) |
| 템플릿 | `meme/skill-unlock.html` |
| 렌더러 | `meme/render.mjs` (Playwright + Chromium) |

## 구성

- 상단 HUD — `PLAYER · 최해니` / `AGE 06M · EXP 100%`
- 헤드라인 — `NEW ABILITY UNLOCKED` → **이동 능력 해금**
- 해금 연출 — 광원 버스트, 방사형 광선, 파티클 (시드 고정이라 렌더 결과가 항상 동일)
- 하단 스킬 카드 — `SSR · 전설` **포복 전진 Lv.1**, 스탯 바, 경고 배너

## 실행

원본 사진은 개인 사진이라 저장소에 포함하지 않습니다.
직접 준비한 세로 사진을 `meme/assets/haeni-crawl.jpg` 로 넣어주세요.
(9:16 비율 기준으로 잡혀 있고, 인물이 가로 45% / 세로 35% 지점에 오도록 크롭하면 광원과 잘 맞습니다.)

```bash
# 한글 폰트 (Black Han Sans, Noto Sans KR) 가 시스템에 설치되어 있어야 합니다
npm i playwright && npx playwright install chromium
node meme/render.mjs                 # → meme/out/haeni-mobility-unlocked.png
node meme/render.mjs /path/to/my.png # 출력 경로 지정
```

## 문구 바꾸기

`meme/skill-unlock.html` 을 열어 텍스트만 고치면 다른 "해금" 짤로 재활용할 수 있습니다.
다음 해금 후보: **붙잡고 서기 (Lv.2)**, **첫 걸음마 (Lv.3)**.
