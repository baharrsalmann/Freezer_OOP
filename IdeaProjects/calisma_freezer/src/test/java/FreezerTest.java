import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FreezerTest {


    @Test
    public void test1() {
        Freezer myFreezer = new Freezer(100);

        Strawberry strawberry1 = new Strawberry(30, LocalDate.of(2024, 6, 20));
        Strawberry strawberry2 = new Strawberry(40, LocalDate.of(2024, 6, 30));
        Spinach spinach = new Spinach(30, LocalDate.of(2024, 7, 5));
        Chip chip = new Chip(20, LocalDate.of(2024, 8, 3));

        assertTrue(myFreezer.put(strawberry1));
        assertTrue(myFreezer.put(strawberry2));
        assertTrue(myFreezer.put(spinach));
        assertFalse(myFreezer.put(chip));

        assertEquals(0,myFreezer.getEmptySpace());
        assertEquals(100,myFreezer.getOccupied());

        for(int i = 0; i < myFreezer.getAll().size()-1 ; i++) {
            assertTrue(myFreezer.getAll().get(i).date.isBefore(myFreezer.getAll().get(i+1).date));
        }

    }
    @Test
    public void test2() {
        Freezer myFreezer = new Freezer(100);

        Strawberry strawberry1 = new Strawberry(30, LocalDate.of(2024, 6, 20));
        Spinach spinach = new Spinach(30, LocalDate.of(2024, 7, 5));
        Chip chip = new Chip(20, LocalDate.of(2024, 8, 3));
        myFreezer.put(strawberry1);
        myFreezer.put(spinach);
        myFreezer.put(chip);
        Product removed = myFreezer.remove();
        assertEquals(removed,strawberry1);
        assertTrue(removed.equals(strawberry1));
        assertEquals(50,myFreezer.getEmptySpace());
        assertEquals(50,myFreezer.getOccupied());
    }

}