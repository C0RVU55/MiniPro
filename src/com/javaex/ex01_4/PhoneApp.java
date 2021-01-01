package com.javaex.ex01_4;

import java.io.IOException;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		
		/* 
		 * main에는 기본 구조만 구현해서 전체흐름을 파악하기 쉬움.
		 * 주요기능은 PhoneManager에 구현
		 */
		
		// PhoneManager 생성
		// 파일에서 데이터 불러오기+스캐너 연결 (리스트와 스캐너까지 따로 뺌)
		// 기능을 PhoneManager에 완전 분리
		PhoneManager pManager = new PhoneManager();

		// 시작 타이틀 출력
		pManager.showTitle();

		// 실행 
		boolean run = true;
		while (run) {
			// 메뉴 출력, 입력값 리턴
			int menuNum = pManager.showMenu();

			// switch() 시작
			switch (menuNum) {

			// 1(리스트)
			case 1:
				pManager.showList();
				break;

			// 2(등록)
			case 2:
				pManager.showAdd();
				break;

			// 3(삭제)
			case 3:
				pManager.showRemove();
				break;

			// 4(검색)
			case 4:
				pManager.showSearch();
				break;

			// 5(종료)
			case 5:
				run = false;
				break;

			// 없는 번호일때
			default:
				pManager.showEtc();
				break;

			}// switch() 종료

		} // while 종료

		// 종료화면
		pManager.showEnd(); // 출력문을 아예 main에서 제외해서 구조 파악 용이

	}

}
