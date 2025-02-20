package com.programmars.multicampus;

/**
 * 외톨이 알파벳 (기존 문제 합성어 찾기에서 변형)
 *
 * 문자열, 해시
 *
 * 알파벳 소문자로만 이루어진 어떤 문자열에서
 * 2회 이상 나타난 알파벳이 2개 이상의 부분으로 나뉘어 있으면 외톨이 알파벳이라고 정의
 *
 * 문제의 분할 접근 :
 * - 2개 이상 연속적으로 한번만 나타나는 문자는 제외
 * - 한 글자이지만 한 번만 나타나는 문자도 제외
 * - 같은
 *
 * 문제 풀이 순서
 * 1. 완전 탐색으로 접근
 * 2. 연속적인지 아닌지를 판단
 * 3. 연속성이 끊어질 시 새로운 문자발견으로 기존(왼쪽) 문자 점검
 *  - 처음 발견한 문자면 문자의 종류에 저장
 *  - 기존에 발견했던 문자라면 외톨이 문자 판별로 추가
 * 4. 외톨이 데이터가 있다면
 *  - 중복을 제거 후 정렬하고 최종 결정
 * 5. 외톨이가 없을 시 'N'으로 최종 결정
 */
public class _01 {
    public static void main(String[] args) {

    }
}
