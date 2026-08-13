/**
 * CountingNotifier — ตัวห่อ (wrapper) ที่นับจำนวนครั้งการส่ง
 *
 * "Prefer composition over inheritance":
 * ห้ามสืบทอด EmailNotifier/SmsNotifier (ไม่ใช่ is-a เชิงพฤติกรรม
 * และจะห่อได้ทีละชนิด) — ให้ "ถือ" Notifier ตัวในไว้ (has-a)
 * แล้ว "มอบงาน" (delegate) ให้มันทำ จึงห่อช่องทางชนิดไหนก็ได้
 *
 * รูปแบบนี้คือ Decorator pattern แบบเดียวกับ CountingSet ในสไลด์
 */
public final class CountingNotifier implements Notifier {

    private final Notifier inner ;
    private int count;


    /**
     * @param inner ช่องทางจริงที่จะมอบงานให้ ห้าม null
     * @throws IllegalArgumentException เมื่อ inner เป็น null
     */
    public CountingNotifier(Notifier inner) {
        if(inner == null)throw new IllegalArgumentException();
        this.inner = inner;
        count =0 ;
    }

    @Override
    public void send(String message) {
        inner.send(message);
        count ++;
    }

    /** จำนวนครั้งที่ send ถูกเรียกบน wrapper ตัวนี้ */
    public int sendCount() {
        return count;
    }
}
