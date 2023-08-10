# sessacFlix
## OTT 만들기 (새싹플릭스)

- 사용자가 새싹플릭스를 실행하면 다음과 같이 컨텐츠 목록을 선택하여 볼 수 있다
    1. 컨텐츠 순위
    2. 영화 컨텐츠
    3. 시리즈 컨텐츠
    4. 관심목록 컨텐츠
- 컨텐츠 목록의 표기 예시는  다음과 같다
    - 영화 컨텐츠 목록은 영화 컨텐츠만 표기된다
    - 시리즈 컨텐츠 목록은 시리즈 컨텐츠만 표기된다
    - 순위, 관심 컨텐츠는 영화, 시리즈 둘다 표기된다
    
    ```java
    컨텐츠 순위!
    1.----------------------------------------
    제목 : 경이로운 자바
    줄거리 : 
    시리즈
    2.----------------------------------------
    제목 : 자바무비
    줄거리 :
    영화 
    3.----------------------------------------
    제목 : 킹더자바
    줄거리 :
    시리즈 
    4.----------------------------------------
    ...
    ```
    
- 컨텐츠 목록 출력 후 컨텐츠 번호를 입력하면 해당 컨텐츠의 상세 내용과 영상이 출력된다.
- 컨텐츠 표기 예시는 다음과 같다
    - 시리즈는 회차에 따른 영상이 목록으로 나온다
    - 영화는 본편영상과 예고편영상 2개가 목록으로 나온다
    
    ```java
    ----------------------------------------
    제목: 
    줄거리:
    감독: 
    연도:
    출연:
    영화
    0. 찜하기
    
    1.--------------
    본편 영상
    제목
    영상 시간
    2.--------------
    예고편 영상
    제목
    영상 시간
    --------------
    
    ----------------------------------------
    ```
    
    ```java
    ----------------------------------------
    제목: 
    줄거리:
    감독: 
    연도:
    출연:
    시리즈
    0. 찜하기
    
    1.--------------
    1회 영상
    시리즈 제목
    영상 시간
    2.--------------
    2회 영상
    시리즈 제목
    영상 시간
    3.--------------
    3회 영상
    시리즈 제목
    영상 시간
    4.--------------
    4회 영상
    시리즈 제목
    영상 시간
    --------------
    
    ----------------------------------------
    ```
    
- 컨텐츠 표기후 0번을 입력하면 나의 관심목록에 컨텐츠가 추가되고 다음과 같이 출력한다
    - <제목> 컨텐츠가 관심목록에 추가되었습니다.
    - 출력이후 목록선택으로 돌아간다
- 컨텐츠 표기후 영상 번호를 입력하면 컨텐츠의 조회수를 증가시키고 다음과 같이 출력한다
    - <영상제목> 영상이 재생됩니다.
    - 출력이후 목록선택으로 돌아간다
- 컨텐츠는 다음과 같은 정보를 포함한다
    - 컨텐츠 id
    - 제목
    - 감독
    - 줄거리
    - 출연
    - 연도
    - 조회수
    - 시리즈인 경우 회차별 영상 ID 리스트
    - 영화인 경우 본편 영상 ID, 예고편 영상 ID
- 영상은 다음과 같은 정보를 포함한다
    - 영상 id
    - 영상 제목
    - 영상 시간
    - 컨텐츠 id
- 유저는 다음과 같은 정보를 포함한다
    - 유저 ID
    - 유저  이름
    - 관심 컨텐츠 목록
- 모든 데이터는 파일로부터 읽고 맵형태로 저장하는 아카이브에서 관리된다
    - 컨텐츠 맵
        - 컨텐츠 ID = {
            - title= 제목(문자열)
            - direc= 감도(문자열)
            - year= 년도(문자열)
            - summary= 줄거리(문자열)
            - cast= 출연진(문자열)
            - views = 조회수(숫자)
            - type = 시리즈 또는 영화(문자열)
            - media = 영상아이디 리스트 {
                
                영상아이디(문자열), 영상아이디(문자열), 영상아이디(문자열)…
                
                }
                
            
            }
            
    - 영상 맵
        - 영상 ID = {
            - title = 제목(문자열)
            - time = 시간(문자열)
            - cID = 컨텐츠ID(문자열)
            
            }
            
- 상속과 인터페이스를 최소 1번 이상 사용하여야 한다.

---
## 아카이브 코드

```
public class OTTArchive {
	Map<String, Map<String, Object>> contentM;
	Map<String, Map<String, String>> mediaM;

	public OTTArchive() {
		contentM = new HashMap<String, Map<String,Object>>();
		mediaM = new HashMap<String, Map<String,String>>();
		setArchive();
	}
	
	private void setArchive() {
		List<String[]> contents = readContentBase();
		List<String> casts = readCast();
		List<String> summarys = readSummary();
		List<String[]> medias = readMedia();

		for(int i=0;i<contents.size(); i++) {
			Map<String, Object> cm = new HashMap<String, Object>();
			String[] content = contents.get(i);
			cm.put("title",content[1]);
			cm.put("direc",content[2]);
			cm.put("year",content[3]);
			cm.put("type",content[4]);
			cm.put("views",Integer.valueOf(content[5]));
			cm.put("summary",summarys.get(i));
			cm.put("cast",casts.get(i));
			cm.put("medias",new ArrayList<String>());
			contentM.put(content[0], cm);
		}
		
		for(int i=0;i<medias.size(); i++) {
			Map<String, String> mdm = new HashMap<String, String>();
			String[] media = medias.get(i);
			
			mdm.put("title",media[1]);
			mdm.put("time",media[2]);
			mdm.put("cId",media[3]);
			mediaM.put(media[0], mdm);
			((List<String>) contentM.get(media[3]).get("medias")).add(media[0]);
		}
		
		System.out.println(contentM.toString());
		System.out.println(mediaM.toString());
	}
	
	private List<String[]> readContentBase() {
		try {
			FileReader fr = new FileReader("./컨텐츠기본.txt");
			BufferedReader bin = new BufferedReader(fr);
			
			List<String[]> list = new ArrayList<>();
			while(true) {
				String line = bin.readLine();
				if (line == null) {
					break;
				}
				String[] content = line.split(" ");
				list.add(content);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	private List<String> readCast() {
		try {
			FileReader fr = new FileReader("./컨텐츠출연.txt");
			BufferedReader bin = new BufferedReader(fr);
			List<String> list = new ArrayList<>();
			while(true) {
				String line = bin.readLine();
				if (line == null) {
					break;
				}
				list.add(line);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	private List<String> readSummary() {
		try {
			FileReader fr = new FileReader("./컨텐츠줄거리.txt");
			BufferedReader bin = new BufferedReader(fr);
			List<String> list = new ArrayList<>();
			while(true) {
				String line = bin.readLine();
				if (line == null) {
					break;
				}
				list.add(line);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	private List<String[]> readMedia() {
		try {
			FileReader fr = new FileReader("./영상.txt");
			BufferedReader bin = new BufferedReader(fr);
			
			List<String[]> list = new ArrayList<>();
			while(true) {
				String line = bin.readLine();
				if (line == null) {
					break;
				}
				String[] media= line.split(" ");
				list.add(media);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
	}
}

```
