/**
 * Priority — ระดับความสำคัญของการแจ้งเตือน
 *
 * enum ใน Java เป็น class เต็มตัว: มี field, constructor และ method ได้
 * ใช้แทน int constants เพื่อความ type-safe (ส่งเลขมั่ว ๆ เข้ามาไม่ได้)
 *
 * ภารกิจ: เพิ่ม field `level` ให้แต่ละค่า — LOW=1, NORMAL=2, URGENT=3
 * (ดูตัวอย่าง enum Planet ในสไลด์เป็นแนวทาง)
 */
public enum Priority {

    LOW(1), NORMAL(2), URGENT(3);

    private final int level ;
    private Priority(int level){
        this.level=level;
    }
    /** ตัวเลขระดับความสำคัญ (มากกว่า = สำคัญกว่า) */
    public int level() {
        return this.level;
    }

    /** true เมื่อระดับของเรา "อย่างน้อยเท่ากับ" ระดับที่กำหนด */
    public boolean isAtLeast(Priority other) {
        return this.level >= other.level;
    }
}
