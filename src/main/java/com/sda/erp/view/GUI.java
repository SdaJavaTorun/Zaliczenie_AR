package com.sda.erp.view;

public class GUI {

    public static void showMenu() {
        System.out.println("\nWitaj w systemie ERP!\n" +
                            "1. Pokaż wszystkich pracowników - krótka wersja\n" +
                            "2. Dodaj nowego pracownika\n" +
                            "3. Export do pliku danych pracownika\n" +
                            "4. Usuń pracownika\n" +
                            "5. Edycja danych pracownika\n" +
                            "6. Przejście do podmenu 1...\n" +
                            "7. Export danych i przejście do podmenu 2...\n" +
                            "8. Informacja o systemie\n" +
                            "0. Wyjście z systemu"
        );
    }

    public static void showSubMenu1() {
        System.out.println("Podmenu 1:\n" +
                            "1. Liczba pracowników z pensją nie mniejszą niż podana\n" +
                            "2. Średnia płaca w podanym dziale\n" +
                            "3. Najlepiej zarabiający: Pani i Pan\n" +
                            "4. *Wszystkie działy + stosunek kobiety/mężczyźni + średnia pensja w dziale\n" +
                            "5. Zwiększ płace pracowników o 10% + extra dodatki\n" +
                            "6. *Zwiększ pensje wszystkich o podaną kwotę\n" +
                            "7. Sortowanie pracowników według nazwiska w pliku - roznąco/malejąco\n" +
                            "8. Sortowanie pracowników według pensji w pliku - roznąco/malejąco\n" +
                            "0. Wyjście do menu głównego"
        );
    }

    public static void showSubMenu2() {
        System.out.println("Podmenu 2 - export:\n" +
                            "1. Wyświetlenie osoby o najdłuższym nazwisku\n" +
                            "2. Średnia wiek osób dzietnych\n" +
                            "3. Kodowanie nazwisk osób a pensji niższej niż średnia pensja\n" +
                            "4. *Utworzenie pliku 'pracownicy.html'\n" +
                            "0. Wyjście do menu głównego"
        );
    }

    public static void showEditMenu() {
        System.out.println("Co edytować u pracownika:\n" +
                            "1. Zmiana nazwiska (dla kobiet tylko)\n" +
                            "2. Zmiana wieku\n" +
                            "3. Zmiana płacy\n" +
                            "4. Zmiana działu\n" +
                            "0. Wyjście do menu głównego"
        );
    }

    public static String systemInfo() {
        return "\nTO JEST MOJA FIRMA";
    }
}
