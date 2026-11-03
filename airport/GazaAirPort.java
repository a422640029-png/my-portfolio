package airport;

import java.util.ArrayList;

public class GazaAirPort {

    private final ArrayList<person> peopleList=new ArrayList<>();
    private final ArrayList<airFlight> FlightList=new ArrayList<>();


    public GazaAirPort() {

    }



    public void Addflight(airFlight flight) {
FlightList.add(flight);
    }
    public void Addperson(person p){
        peopleList.add(p);
    }

    public void genarateDailyReport() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                🇵🇸  تقرير مطار غزة الدولي  🇵🇸               ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝\n");

        // ─────────────────────────────────────────────────────────────
        // 1. قسم قائمة الأشخاص في النظام
        // ─────────────────────────────────────────────────────────────
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│  👥  سجل الأشخاص المسجلين في النظام                          │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");

        if (peopleList == null || peopleList.isEmpty()) {
            System.out.println("   ⚠️ لا يوجد أشخاص مسجلين في النظام حتى الآن.");
        } else {
            for (int i = 0; i < peopleList.size(); i++) {
                person p = peopleList.get(i);
                if (p == null) continue;

                String typeTag = "[ شخص ]   ";
                if (p instanceof Pilot)          typeTag = "[👨‍✈️ طيار]  ";
                else if (p instanceof travilar)  typeTag = "[🧳 مسافر] ";
                else if (p instanceof flightAtendant) typeTag = "[👔 مضيف]  ";

                System.out.print("  " + (i + 1) + ". " + typeTag + " ");
                p.displayInfo();
            }
        }

        System.out.println("\n ─── ✔ تم عرض جميع الأشخاص ───\n");

        // ─────────────────────────────────────────────────────────────
        // 2. قسم سجل الرحلات
        // ─────────────────────────────────────────────────────────────
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│  ✈️  جدول وتفاصيل الرحلات الجوية                             │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");

        if (FlightList == null || FlightList.isEmpty()) {
            System.out.println("   ⚠️ لا يوجد رحلات مجدولة حالياً.");
        } else {
            for (int i = 0; i < FlightList.size(); i++) {
                airFlight f = FlightList.get(i);
                if (f == null) continue;

                System.out.println("\n  🛫  [ رحلة رقم #" + f.getId() + " ] ── الوجهة: " + f.getDestination() + " (المقاعد: " + f.getSeats() + ")");
                System.out.println("  ──────────────────────────────────────────────────────────────");

                // أ) تفاصيل الطيار
                System.out.print("     👨‍✈️ الطيار: ");
                if (f.getPilot() != null) {
                    f.getPilot().displayInfo();
                } else {
                    System.out.println("❌ لم يتم تعيين طيار لهذه الرحلة.");
                }

                // ب) تفاصيل المضيفين
                System.out.println("     👔 طاقم الضيافة:");
                if (f.getFad() != null) {
                    boolean hasAttendant = false;
                    for (flightAtendant a : f.getFad()) {
                        if (a != null) {
                            System.out.print("        • ");
                            a.displayInfo();
                            hasAttendant = true;
                        }
                    }
                    if (!hasAttendant) {
                        System.out.println("        ⚠️ لم يتم تعيين مضيفين لهذه الرحلة.");
                    }
                } else {
                    System.out.println("        ⚠️ قائمة المضيفين غير معرفة.");
                }

                // ج) تفاصيل المسافرين
                System.out.println("     🧳 المسافرون على الرحلة:");
                if (f.getTr() != null && !f.getTr().isEmpty()) {
                    for (int j = 0; j < f.getTr().size(); j++) {
                        travilar r = f.getTr().get(j);
                        if (r != null) {
                            System.out.print("        (" + (j + 1) + ") ");
                            r.displayInfo();
                        }
                    }
                } else {
                    System.out.println("        🔹 لا يوجد مسافرون محجوزون على هذه الرحلة.");
                }
                System.out.println("  ──────────────────────────────────────────────────────────────");
            }
        }

        System.out.println("\n════════════════════════════════════════════════════════════════");
        System.out.println("                     🏁 نهاية التقرير اليومي                     ");
        System.out.println("════════════════════════════════════════════════════════════════\n");
    }
}










