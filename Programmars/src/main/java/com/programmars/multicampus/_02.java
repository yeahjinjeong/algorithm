package com.programmars.multicampus;

/**
 * 점프와 순간 이동
 *
 * 문제 간략 설명
 *
 * 문자 풀이 순서
 *
 * Top-Down으로 접근
 * 0계단부터 시작이 아닌 최종 계단부터 역으로 이동 1칸으로 도착할 때까지 반복
 * 건전지 소모를 최소한으로 우선순위 코드!
 *  - 지금까지 온 이동거리의 2배는 건전지 소모가 없음
 *   - 즉! 지금 위치의 절반으로 아래를 건전지 소모없이 내려갈 수 있음
 *  - 지금 위치가 짝수라면 절반을 내려오고
 *  - 지금 위치가 홀수라면 최소한의 건전지 사용을 위해 1칸만 내려옴
 *
 *  - 처음 시작은 순간이동을 할 수 없음(이동한 거리가 없기 때문에!)
 *
 */
public class _02 {
}