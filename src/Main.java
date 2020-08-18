import java.util.Scanner; // scanner를 사용하기 위함
import java.util.ArrayList; // arraylist를 사용하기 위함
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
    
    while(true) {
	    // print 클래스 호출
	    print p = new print();
	    
    	// print 클래스 안의 menu 메소드 호출
		System.out.println("-------------------------");
    	p.menu();
		System.out.println("-------------------------");
		
    	String s = sc.nextLine();
    	if(s.equals("exit")) {
			exit e = new exit();
			e.print();
    		break;
    	}
    	
    	else if(s.equals("add")) {
    		add a = new add();
    		a.print();
    	}
    	
    	else if(s.equals("list")) {
    		list l = new list();
    		l.print();
    	}
    	
    	else if(s.equals("read")) {
    		read r = new read();
    		r.print();
    	}
    	
    	else if(s.equals("detail")) {
    		detail d = new detail();
    		d.print();
    	}
    	
    	else if(s.equals("update")) {
    		update u = new update();
    		u.print();
    	}
    	
    	else if(s.equals("delete")) {
			delete d = new delete();
			d.print();
    	}
    	
    	else if(s.equals("search")) {
    		search se = new search();
    		se.print();
    	}
    }
    
  }
}

class add extends function {
	void print() {
		 System.out.println("");
			System.out.println("제목을 입력하십시오.");
			title = sc.nextLine();
			// title에 입력된 값을 Titles에 저장
			Titles.add(title);
			System.out.println("내용을 입력하십시오.");
			body = sc.nextLine();
			// body에 입력된 값을 Bodies에 저장
			Bodies.add(body);
	}
}

class list extends function {
	function f = new function();
	
	void print() {
		f.remove();
	}
}

class read extends function {
	void print() {
		for(int i = 0; i < Titles.size(); i++) {
			System.out.println("");
			System.out.println("번호 : " + (i + 1));
    		System.out.println("제목 : " + Titles.get(i));
    		System.out.println("");
		}
	}
}

class detail extends function {
	function f = new function();
	
	void print() {
		System.out.println("");
		System.out.println("보고싶은 게시물의 번호를 입력해주십시오.");
		int i = sc.nextInt();
		sc.nextLine();
		if(i > Titles.size()) { 
			f.remove2();
		}
		else {
			System.out.println("");
			System.out.println("번호 : " + (i));
    		System.out.println("제목 : " + Titles.get(i - 1));
    		System.out.println("내용 : " + Bodies.get(i - 1));
    		System.out.println("");
		}
	}
}

class update extends function {
	function f = new function();
	void print() {
		System.out.println("");
		System.out.println("수정을 원하는 게시물의 번호를 입력해주십시오.");
		int i = sc.nextInt();
		sc.nextLine();
		if(i > Titles.size()) {
			f.remove2();
		}
		else {
			System.out.println("");
			System.out.println("새로운 제목을 입력해주십시오.");
			new_title = sc.nextLine();
			Titles.set((i - 1), new_title);
			System.out.println("새로운 내용을 입력해주십시오.");
			new_body = sc.nextLine();
			Bodies.set((i - 1), new_body);
			f.print();
			f.remove();
		}
	}
}

class delete extends function {
	function f = new function();
	void print() {
		System.out.println("");
		System.out.println("삭제를 원하는 게시물의 번호를 입력해주십시오.");
		int i = sc.nextInt();
		sc.nextLine();
		if(i > Titles.size()) {
			f.remove2();
		}
		else {
			Titles.remove(i - 1);
			Bodies.remove(i - 1);
			f.print();
			f.remove();
		}
	}
}

class search extends function {
	function f = new function();
	
	void print() {
		System.out.println("검색을 원하는 문자를 입력해주십시오. ");
		String s = sc.nextLine();
		if(Titles.contains(s)) {
			System.out.println(title);
		}
		else f.remove2();
	}
}

class exit {
	void print() {
		System.out.println("");
		System.out.println("프로그램을 종료합니다.");
	}
}

class function {
  // 입력받는 함수
	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> Titles = new ArrayList<String>(Arrays.asList("111", "abc", "ㄱㄴㄷ"));
	static ArrayList<String> Bodies = new ArrayList<>(Arrays.asList("111", "abc", "ㄱㄴㄷ"));
	static String title;
	static String body;
	static String new_title;
	static String new_body;
	
	void test() {
		Titles.add("abc");
		Titles.add("123");
		Titles.add("ㄱㄴㄷ");
		Bodies.add("abc");
		Bodies.add("123");
		Bodies.add("ㄱㄴㄷ");
	}
  
	void remove() {
		for(int num = 0; num < Titles.size(); num++) {
			System.out.println("번호 : " + (num + 1));
    		System.out.println("제목 : " + Titles.get(num));
    		System.out.println("내용 : " + Bodies.get(num));
    		System.out.println("");
		}
	}
	
	void remove2() {
		System.out.println("");
		System.out.println("게시물이 존재하지 않습니다.");
	}
	
	void print() {
		System.out.println("");
		System.out.println("수정이 완료되었습니다.");
		System.out.println("");
		System.out.println("-----수정 후-----");
	}
}

class print {
	void menu() {
		System.out.println("원하는 기능에 맞게 입력해주십시오.");
		System.out.println("게시물 추가 : add");
		System.out.println("게시물 조회 : list");
		System.out.println("게시물 목록 조회 : read");
		System.out.println("게시물 상세보기 : detail");
		System.out.println("게시물 수정 : update");
		System.out.println("게시물 삭제 : delete");
		System.out.println("게시물 검색 : search");
		System.out.println("프로그램 종료 : exit");
	}
}