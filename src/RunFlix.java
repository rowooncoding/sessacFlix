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
                // 랭킹
                sessacFlix.rankContents();
                menuNumber = scanner.nextInt();
                sessacFlix.detailContents(menuNumber);
            } else if (menuNumber == 2) {
                // 영화
                sessacFlix.movieContents();
                menuNumber = scanner.nextInt();
                sessacFlix.detailContents(menuNumber);
            } else if (menuNumber == 3) {
                // 시리즈
                sessacFlix.seriesContents();
                menuNumber = scanner.nextInt();
                sessacFlix.detailContents(menuNumber);
            }
        }
        scanner.close();
    }
}