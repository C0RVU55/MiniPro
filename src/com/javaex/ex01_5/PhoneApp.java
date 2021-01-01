package com.javaex.ex01_5;

public class PhoneApp {

	public static void main(String[] args) {
		/*
		main 함수에는 기본 구조만 구현 --> 전체의 흐름을 파악하기 좋다.
		주요기능은 phoneView(출력 기능), PhoneRepository 클래스 만들어서 구현
		
		phoneView(출력 기능) : 화면에서 데이터 받기, 필요한 메세지 출력 등 화면과 관련된 업무를 하는 클래스
		PhoneManager(데이터 저장 및 관리 기능) : 리스트에 데이터를 추가, 삭제. 데이터 수정시 PhoneDB.txt파일에 저장.
		*/
		
		// PhoneView 생성
		PhoneView phoneView = new PhoneView();

		// PhoneManager 생성 --> 생성자를 통해 파일의 정보가 리스트에 추가된다. (생성자에 리스트 불러와서)
		PhoneRepository phoneRepo = new PhoneRepository();

		// 변수
		boolean run = true;

		// 시작시 안내 문구를 출력
		phoneView.showStart();

		// while 시작
		while (run) {
			// 메뉴 출력, 입력값 리턴
			int menuNum = phoneView.showMenu();

			// switch() 시작
			switch (menuNum) {

			// 1(리스트)
			case 1:
				phoneView.showList(phoneRepo.getList());
				break;

			// 2(등록)
			case 2:
				Person phoneVO = phoneView.showAdd(); // 값을 입력해서 반환 받은 Person 클래스를 phoneVO에 대입
				phoneRepo.addInfo(phoneVO); // 해당 클래스를 리스트에 추가하고 데이터를 메모장에 저장
				phoneView.showAddResult();
				break;

			// 3(삭제)
			case 3:
				int delNo = phoneView.showDel(); // 입력 받은 int를 delNO에 대입
				phoneRepo.delInfo(delNo); // 리스트에서 해당 번호 삭제 후 리스트 장
				phoneView.showDelResult();
				break;

			// 4(검색)
			case 4:
				String keyword = phoneView.showSearch();
				phoneView.showSearchResult(phoneRepo.getList(), keyword);
				break;

			// 5(종료)
			case 5:
				phoneView.showEnd();
				run = false;
				break;

			// 없는 번호일때
			default:
				phoneView.showEtc();
				break;
			}// switch() 종료

		} // while 종료

		// 종료화면
		phoneView.showEnd();

	}

}
