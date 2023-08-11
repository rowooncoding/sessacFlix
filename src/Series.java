import java.util.List;

public class Series extends Contents {
    List<String> seriesId;
    OTTArchive ottArchive;

    public Series(OTTArchive archive, String key) {
        super(archive, key);
        this.ottArchive = archive;
        this.seriesId = medias;
    }

    public void seriesInfo(){
        for(int i = 0 ; i < seriesId.size() ; i++){
        System.out.println(i+1+".------------------");
        System.out.println(i+1+"회 영상");
        System.out.println("시리즈 제목: "+ottArchive.mediaM.get(seriesId.get(i)).get("title"));
        System.out.println("영상시간: "+ ottArchive.mediaM.get(seriesId.get(i)).get("time"));
        System.out.println();
        }
    }
}
