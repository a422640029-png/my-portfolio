package airport;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class airFlight {
    private int id;
    private static int countid = 0;
    private Pilot pilot;
    private int seats;
    private flightAtendant[] fad = new flightAtendant[2];
    private ArrayList<travilar> tr = new ArrayList<>();
    private String destination;
    private flyStates type;

    public airFlight() {
        this.id = ++countid;
    }

    public airFlight(int seats, String destination) {
        this(); // لضمان زيادة الـ ID
        this.seats = seats;
        this.destination = destination;
    }

    public airFlight(Pilot pilot, int seats, flightAtendant[] fad, ArrayList<travilar> tr, String destination, flyStates type) {
        this();
        this.type = type;
        this.pilot = pilot;
        this.seats = seats;
        this.fad = fad;
        this.tr = tr;
        this.destination = destination;
    }
    public void ReadData(GazaAirPort gz) {
        File f = new File("C:\\Users\\user\\Desktop\\passenger.txt");

        // قائمة مؤقتة لتجميع كل المسافرين المعتمدين من الملف دفعة واحدة
        ArrayList<travilar> loadedPassengers = new ArrayList<>();

        try (Scanner s = new Scanner(f)) {
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (line.trim().isEmpty()) continue; // تجاهل الأسطر الفارغة

                String[] spearatedValue = line.split("\\|");
                if (spearatedValue.length >= 6) {
                    String name = spearatedValue[0].trim();
                    String nathonalityId = spearatedValue[1].trim();
                    String nathonality = spearatedValue[2].trim();
                    String passbortId = spearatedValue[3].trim();
                    String finishedDate = spearatedValue[4].trim();
                    String destination = spearatedValue[5].trim();

                    travilar t = new travilar(name, nathonalityId, nathonality, passbortId, finishedDate, destination);

                    // التحقق من المقاعد المتاحة قبل الإضافة
                    if ((this.tr.size() + loadedPassengers.size()) < this.seats) {
                        loadedPassengers.add(t);
                    } else {
                        System.out.println("⚠️ تنبيه: تعذر إضافة المسافر [" + name + "] لأن عدد ركاب الملف تجاوز عدد مقاعد الرحلة (" + this.seats + ")");
                    }
                }
            }

            // إضافة جميع المسافرين المقبولين دفعة واحدة
            if (!loadedPassengers.isEmpty()) {
                this.tr.addAll(loadedPassengers); // إضافتهم لقائمة الرحلة معاً

                if (gz != null) {
                    for (travilar passenger : loadedPassengers) {
                        gz.Addperson(passenger); // إضافتهم لسجل المطار
                    }
                }
                System.out.println("✅ تم إضافة مجموعة المسافرين من الملف وعددهم (" + loadedPassengers.size() + ") مسافر إلى الرحلة دفعة واحدة بنجاح!");
            } else {
                System.out.println("⚠️ لم يتم إضافة أي مسافر، إما لأن الملف فارغ أو لا توجد مقاعد شاغرة.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("❌ لم يتم العثور على ملف المسافرين في المسار: C:\\Users\\user\\Desktop\\passenger.txt");
        }
    }

    public void addbassnger(travilar tr) throws OverSeatsExcption {
        if (this.tr.size() >= this.seats) {
            throw new OverSeatsExcption("الرحلة المتجهة إلى " + this.destination + " ممتلئة تماماً.");
        }
        this.tr.add(tr);
    }

    public void checkPassport(travilar r) throws ExpiredPassportExption {
        try {
            int year = Integer.parseInt(r.getFinishedDate());
            if (year < 2026) {
                throw new ExpiredPassportExption("سنة جواز سفر " + r.getName() + " منتهية (" + year + ")");
            }
            System.out.println("✅ جواز السفر ساري المفعول.");
        } catch (NumberFormatException e) {
            throw new ExpiredPassportExption("صيغة تاريخ انتهاء جواز السفر غير صالحة.");
        }
    }

    public void lunchLight() throws MinimumAttendantsExcption, NoPIlot, NoPASSENGER {
        if (pilot == null) {
            throw new NoPIlot("لا يوجد طيار متاح للرحلة.");
        }
        if (fad == null || fad[0] == null || fad[1] == null) {
            throw new MinimumAttendantsExcption("عدد مضيفي الطيران غير مكتمل (يلزم 2 مضيفين).");
        }
        if (tr == null || this.tr.isEmpty()) {
            throw new NoPASSENGER("لا يوجد ركاب مسجلون في هذه الرحلة.");
        }
        this.type = flyStates.Departed;
    }

    // Getters and Setters
    public Pilot getPilot() { return pilot; }
    public void setPilot(Pilot pilot) { this.pilot = pilot; }
    public int getSeats() { return seats; }
    public void setSeats(int seats) { this.seats = seats; }
    public flightAtendant[] getFad() { return fad; }
    public void setFad(flightAtendant[] fad) { this.fad = fad; }
    public ArrayList<travilar> getTr() { return tr; }
    public void setTr(ArrayList<travilar> tr) { this.tr = tr; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    public flyStates getType() { return type; }
    public void setType(flyStates type) { this.type = type; }
}