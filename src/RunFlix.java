import java.util.Scanner;

public class RunFlix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OTTArchive ottArchive = new OTTArchive();
        SessacFlix sessacFlix = new SessacFlix(ottArchive);


        System.out.println("🌱 새싹 플릭스에 오신 것을 환영합니다 🌱");
        System.out.println("-----------------------");

        // while로 반복
        while(true){
            // 메뉴를 골라주세요 문구 출력
            System.out.println("메뉴를 골라주세요");
            System.out.println("-----------------------");

            System.out.println("1. 컨텐츠 순위");
            System.out.println("2. 영화 컨텐츠");
            System.out.println("3. 시리즈 컨텐츠");
            System.out.println("4. 관심목록 컨텐츠");
            System.out.println("0. 프로그램 종료");

            // 고른 메뉴 번호 담기
            int menuNumber = scanner.nextInt();

            // 프로그램 종료
            if(menuNumber == 0){
                System.out.println("SessacFlix를 종료합니다");
                break;
            }

            // 해당 메뉴 넘버에 맞는 메뉴 보여주기
            if(menuNumber == 1){
                System.out.println("컨텐츠 순위!");

            } else if (menuNumber == 2) {
                // 1. 2번 고름
                // 3. 컨텐츠 목록 출력 : 제목, 줄거리, 타입
                // 4. 원하는 영화 번호 고름
                // 5. 상세 내용 출력
                // 5-1. 본편 영상과 예고편 영상 2개가 목록으로 나옴 부모 클래스에 있는 필드변수도 나와야함
            } else if (menuNumber == 3) {
                // 시리즈
                // 1. 제목 contentM.get("title")
                // 2. 줄거리 contentM.get("summary")
                // 3. 카테고리(시리즈인지 영화인지 if문 확인 후 contentM.get("type")으로 출력)
            } else if (menuNumber == 4) {
                // 관심목록
                // 1. 제목 contentM.get("title")
                // 2. 줄거리 contentM.get("summary")
                // 3. 카테고리(시리즈인지 영화인지 if문 확인 후 contentM.get("type")으로 출력)
            }
            break;
        }
    }
}