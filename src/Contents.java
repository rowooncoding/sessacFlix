import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Contents implements Comparable<Contents> {
    protected String cId;
    protected String title;
    protected String direc;
    protected String summary;
    protected String cast;
    protected String year;
    protected int views;
    protected String type;
    protected List<String> medias;

    public Contents(OTTArchive archive, String key){
        this.cId = key;
        this.title = (String) archive.contentM.get(key).get("title");
        this.direc = (String) archive.contentM.get(key).get("direc");
        this.summary = (String) archive.contentM.get(key).get("summary");
        this.cast = (String) archive.contentM.get(key).get("cast");
        this.year = (String) archive.contentM.get(key).get("year");
        this.views = (int) archive.contentM.get(key).get("views");
        this.type = (String) archive.contentM.get(key).get("type");
        this.medias = (List<String>) archive.contentM.get(key).get("medias");
    }

    public interface ContentListener {
        void onAddWish();
    }

    @Override
    public int compareTo(Contents contents) {
        if (contents.views > views) {
            return 1;
        } else if (contents.views < views) {
            return -1;
        }
        return 0;
    }
}
