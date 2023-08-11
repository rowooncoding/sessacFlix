import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SessacFlix {
    OTTArchive ottArchive;
    private List<Contents> contentsList;
    private List<String> contentIdList;
    private List<String> mediaIdList;
    private int menuNumber;

    public SessacFlix(OTTArchive ottArchive){
        contentsList = new LinkedList<Contents>();
        contentIdList = new LinkedList<String>();
        mediaIdList = new LinkedList<String>();
        this.ottArchive = ottArchive;
    }

    // contentM에 있는 키들 모아두기
    public void setContentIdList() {
        contentIdList.addAll(ottArchive.contentM.keySet());
    }

    // mediaM에 있는 키들 모아두기
    public void setMediaIdList() {
        mediaIdList.addAll(ottArchive.mediaM.keySet());
    }

    void showContentsList() {
        for (int i = 0; i < contentsList.size(); i++) {
            System.out.println(i + 1 + ".---------------------------");
            System.out.println("제목: " + contentsList.get(i).title);
            System.out.println("줄거리: " + contentsList.get(i).summary);
            System.out.println(contentsList.get(i).type);
            System.out.println(contentsList.get(i).views);
            System.out.println();
        }
    }


    // 각각 컨텐츠들 리스트에 추가
    public void rankContents(){
        setContentIdList();
        for(int i = 0 ; i < ottArchive.contentM.size() ; i++){
            String key = contentIdList.get(i); // 각각 인덱스(키)의 벨류값 => 키값
            Contents contents = new Contents(ottArchive, key);

            this.contentsList.add(contents);
        }
        Collections.sort(contentsList);
        System.out.println("컨텐츠 순위!");
        showContentsList();
    }

    public void movieContents(){
        setContentIdList();
        for(int i = 0 ; i < ottArchive.contentM.size() ; i++){
            String key;
            if(ottArchive.contentM.get(contentIdList.get(i)).get("type").equals("영화")){
                key = contentIdList.get(i);
                Contents contents = new Contents(ottArchive, key);
                this.contentsList.add(contents);
            }
        }
        Collections.sort(contentsList);

        System.out.println("영화 컨텐츠");
        showContentsList();
    }

    public void seriesContents(){
        setContentIdList();
        for(int i = 0 ; i < ottArchive.contentM.size() ; i ++){
            String key;
            if(ottArchive.contentM.get(contentIdList.get(i)).get("type").equals("시리즈")){
                key = contentIdList.get(i);
                Contents contents = new Contents(ottArchive, key);
                this.contentsList.add(contents);
            }
        }
        Collections.sort(contentsList);

        System.out.println("시리즈 컨텐츠");
        showContentsList();
    }

    public void detailContents(int menuNumber){
        this.menuNumber = menuNumber - 1;
        Contents detailList = contentsList.get(this.menuNumber);

        System.out.println("제목: "+detailList.title);
        System.out.println("줄거리: "+detailList.summary);
        System.out.println("감독: "+detailList.direc);
        System.out.println("연도: "+detailList.year);
        System.out.println("출연: "+detailList.cast);
        System.out.println(detailList.type);
        System.out.println("0. 찜하기");
        System.out.println();

        if(detailList.type.equals("영화")) {

            Movie m = new Movie(ottArchive, detailList.cId);
            m.movieInfo();
        }else if(detailList.type.equals("시리즈")) {
            Series s = new Series(ottArchive, detailList.cId);
            s.seriesInfo();
        }

    }
}
