import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Song — ADT แทน "เพลง" หนึ่งเพลง
 *
 * ⚠️ โค้ดตั้งต้นนี้ "ใช้งานได้" แต่มีบั๊กแบบเดียวกับกรณีศึกษาในสไลด์:
 *    rep exposure ทั้งขาเข้าและขาออก, producer ที่แอบ mutate ตัวเอง,
 *    ไม่ validate input และยังไม่ override equals/hashCode
 *
 * ภารกิจของคุณ: ทำให้ Song เป็น immutable class ที่ถูกต้อง "ครบสูตร 6 ข้อ"
 * และ override equals()/hashCode() ตามสัญญาของ Java (ดูรายละเอียดใน README.md)
 */
public final class Song {

    private final String title;
    private final String artist;
    private final List<String> tags;


    /**
     * สร้างเพลง 1 เพลง 
     * @param title ชื่อเพลง โดยที่เพลงต้องห้ามว่างและห้ามเป็น null
     * @param artist ชื่อศิลปิน โดยที่ชื่อศิลปินนั้นห้ามว่างและห้ามเป็น null
     * @param tags ชื่อแท็ก โดยที่ชื่อแท็กนั้นห้ามเป็น null และสมาชิกห้ามว่างและห้ามเป็น null
     * @throws IllegalArgumentException เมื่อว่างหรือเป็น null 
     */
    public Song(String title, String artist, List<String> tags) {
        if(title==null||title==""||artist==null||artist==""){throw new IllegalArgumentException("Title or Artist is null/empty");}
        if(tags == null||tags.contains(null)||tags.contains("")){throw new IllegalArgumentException("Tags has problem");}

        this.title = title;
        this.artist = artist;
        this.tags = new ArrayList<>(tags);
        checkRep();
    }


    private void checkRep(){
        assert title!=null&&title!="";
        assert artist!=null&&artist!="";
        assert tags!=null&&!tags.contains(null)&&!tags.contains("");

    }
    // ---------- observers ----------

    public String title() {
        return title;
    }

    public String artist() {
        return artist;
    }

    public List<String> tags() {
        return new ArrayList<>(tags);
    }

    // ---------- producer ----------
    /**
     * spec: คืน Song "ตัวใหม่" ที่มีแท็กเพิ่มต่อท้าย — ห้ามแก้ตัวเดิม
     * @throws IllegalArgumentException เมื่อ tag เป็น null/ว่าง
     */
    public Song withTag(String tag) {
        if(tag == null||tag =="")throw new IllegalArgumentException();
        List<String> next = new ArrayList<>(tags);
        next.add(tag);
        return new Song(title, artist, next);
    }

    // ---------- equality ----------
    @Override
    public boolean equals(Object o){
        if(this==o)return true;
        if(!(o instanceof Song))return false;
        Song s = (Song) o;
        return title.equals(s.title) && artist.equals(s.artist) && tags.equals(s.tags);
    }
    @Override
    public int hashCode(){
        return Objects.hash(title,artist,tags);
    }
    @Override
    public String toString() {
        return title + " — " + artist + " " + tags;
    }
}
