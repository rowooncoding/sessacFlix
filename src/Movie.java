public class Movie extends Contents{
    protected String  originalId;
    protected String prequelId;
    OTTArchive ottArchive;

    public Movie(OTTArchive archive, String key) {
        super(archive, key);
        this.ottArchive= archive;
        this.originalId = medias.get(0);
        this.prequelId = medias.get(1);
    }

    public void movieInfo(){
        System.out.println("1.------------");
        System.out.println("본편 영상");
        System.out.println("제목: "+ ottArchive.mediaM.get(originalId).get("title"));
        System.out.println("영상시간: "+ ottArchive.mediaM.get(originalId).get("time"));
        System.out.println("2.------------");
        System.out.println("예고편 영상");
        System.out.println("제목: "+ ottArchive.mediaM.get(prequelId).get("title"));
        System.out.println("영상시간: "+ ottArchive.mediaM.get(prequelId).get("time"));
        System.out.println();
    }
}
