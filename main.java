package airport;

import airport.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean running = true;
        GazaAirPort gz = new GazaAirPort();
        airFlight a = null;

        while (running) {
            System.out.println("\n==============================================");
            System.out.println("  مرحباً بكم في نظام إدارة مطار غزة الدولي  ");
            System.out.println("==============================================");
            System.out.println("1. إنشاء رحلة جديدة (وجهة، مقاعد)");
            System.out.println("2. إضافة مسافر للرحلة (فحص الجواز والسعة)");
            System.out.println("3. تعيين طيار للرحلة");
            System.out.println("4. تعيين طاقم الضيافة (2 مضيفين)");
            System.out.println("5. محاولة الإقلاع للرحلة");
            System.out.println("6. إضافة الرحلة الحالية إلى سجل المطار");
            System.out.println("7. طباعة تفاصيل النظام كاملة");
            System.out.println("8. تحميل بيانات المسافرين إلى الرحلة من ملف");
            System.out.println("9. الخروج من النظام");
            System.out.print("أدخل رقم الخيار: ");

            if (!s.hasNextInt()) {
                s.nextLine();
                continue;
            }
            int choice = s.nextInt();
            s.nextLine(); // تفريغ السطر

            switch (choice) {
                case 1:
                    System.out.print("أدخل عدد المقاعد للرحلة: ");
                    int seats = s.nextInt();
                    s.nextLine();
                    System.out.print("أدخل وجهة الرحلة: ");
                    String destination = s.nextLine();
                    a = new airFlight(seats, destination);
                    System.out.println("✅ تم إنشاء الرحلة برقم #" + a.getId());
                    break;

                case 2:
                    if (a == null) {
                        System.out.println("⚠️ أنشئ رحلة أولاً!");
                    } else {
                        System.out.print("ادخل اسم المسافر: ");
                        String travilarName = s.nextLine();
                        System.out.print("ادخل رقم الهوية: ");
                        String nathid = s.nextLine();
                        System.out.print("ادخل الجنسية: ");
                        String nathonality = s.nextLine();
                        System.out.print("ادخل رقم جواز السفر: ");
                        String passbortId = s.nextLine();
                        System.out.print("ادخل سنة انتهاء جواز السفر: ");
                        String finishedDate = s.nextLine();
                        System.out.print("ادخل وجهة المسافر: ");
                        String fdestination = s.nextLine();

                        travilar r = new travilar(travilarName, nathid, nathonality, passbortId, finishedDate, fdestination);
                        try {
                            a.checkPassport(r);
                            a.addbassnger(r);
                            gz.Addperson(r);
                            System.out.println("✅ تم إضافة المسافر بنجاح.");
                        } catch (ExpiredPassportExption e) {
                            System.out.println("❌ خطأ: " + e.getMessage());
                        } catch (OverSeatsExcption e) {
                            System.out.println("❌ خطأ: " + e.getMessage());
                        }
                    }
                    break;

                case 3:
                    if (a == null) {
                        System.out.println("⚠️ أنشئ رحلة أولاً!");
                    } else {
                        System.out.print("ادخل اسم الطيار: ");
                        String pilotName = s.nextLine();
                        System.out.print("ادخل رقم الهوية للطيار: ");
                        String pilotId = s.nextLine();
                        System.out.print("ادخل الجنسية للطيار: ");
                        String pilotNat = s.nextLine();
                        System.out.print("ادخل راتب الطيار: ");
                        double salary = s.nextDouble();
                        System.out.print("ادخل مكافآت الطيار: ");
                        double rewards = s.nextDouble();
                        System.out.print("ادخل ساعات الطيران: ");
                        int flighthours = s.nextInt();
                        s.nextLine();

                        System.out.print("ادخل الشهادات: ");
                        String certificate = s.nextLine();
                        System.out.print("ادخل الرخصة (LICENCE): ");
                        String licence = s.nextLine();

                        Pilot p = new Pilot(pilotName, pilotId, pilotNat, salary, rewards, flighthours, certificate, licence);
                        a.setPilot(p);
                        gz.Addperson(p);
                        System.out.println("✅ تم تعيين الطيار للرحلة بنجاح.");
                    }
                    break;

                case 4:
                    if (a == null) {
                        System.out.println("⚠️ أنشئ رحلة أولاً!");
                    } else {
                        flightAtendant[] newFad = new flightAtendant[2];
                        for (int i = 0; i < newFad.length; i++) {
                            System.out.println("\n--- إدخال بيانات المضيف (" + (i + 1) + ") ---");
                            System.out.print("ادخل اسم مضيف الطيران: ");
                            String attendantName = s.nextLine();
                            System.out.print("ادخل رقم الهوية للمضيف: ");
                            String attendantId = s.nextLine();
                            System.out.print("ادخل الجنسية للمضيف: ");
                            String attendantNat = s.nextLine();
                            System.out.print("ادخل راتب المضيف: ");
                            double salary = s.nextDouble();
                            System.out.print("ادخل مكافآت المضيف: ");
                            double rewards = s.nextDouble();
                            s.nextLine();

                            System.out.print("ادخل اللغات: ");
                            String language = s.nextLine();
                            System.out.print("ادخل عدد الرحلات: ");
                            int tripsNumbers = s.nextInt();
                            s.nextLine();

                            flightAtendant f = new flightAtendant(attendantName, attendantId, attendantNat, salary, rewards, language, tripsNumbers);
                            newFad[i] = f;
                            gz.Addperson(f);
                        }
                        a.setFad(newFad);
                        System.out.println("✅ تم تعيين طاقم الضيافة بنجاح.");
                    }
                    break;

                case 5:
                    if (a == null) {
                        System.out.println("⚠️ أنشئ رحلة أولاً!");
                    } else {
                        try {
                            a.lunchLight();
                            System.out.println("🛫 تم إقلاع الرحلة بنجاح!");
                        } catch (MinimumAttendantsExcption e) {
                            System.out.println("❌ تعذر الإقلاع: " + e.getMessage());
                        } catch (NoPIlot e) {
                            System.out.println("❌ تعذر الإقلاع: " + e.getMessage());
                        } catch (NoPASSENGER e) {
                            System.out.println("❌ تعذر الإقلاع: " + e.getMessage());
                        }
                    }
                    break;

                case 6:
                    if (a == null) {
                        System.out.println("⚠️ أنشئ رحلة أولاً لإضافتها إلى النظام.");
                    } else {
                        gz.Addflight(a);
                        System.out.println("✅ تم إضافة الرحلة رقم #" + a.getId() + " إلى سجلات المطار.");
                    }
                    break;

                case 7:
                    gz.genarateDailyReport();
                    break;

                case 8:
                    if (a != null) {
                        a.ReadData(gz);
                    } else {
                        System.out.println("⚠️ أنشئ رحلة أولاً لتحميل المسافرين إليها.");
                    }
                    break;

                case 9:
                    running = false;
                    System.out.println("👋 تم الخروج من النظام.");
                    break;

                default:
                    System.out.println("⚠️ خيار غير صحيح، يرجى المحاولة مرة أخرى.");
            }
        }
        s.close();
    }
}