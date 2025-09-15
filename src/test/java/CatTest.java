import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
    public class CatTest {

    @Mock
    Feline feline;


    @ParameterizedTest
    @CsvSource({
            "Травоядное, Трава;Различные растения",
            "Хищник, Животные;Птицы;Рыба"
    })
    void testGetFood(String animalKind, String expectedFoodString) throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of(expectedFoodString.split(";"));

        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }



        @Test
        public void catGetSoundReturnsMeow() {
            Cat cat = new Cat(feline);

            assertEquals("Мяу", cat.getSound());
        }

    @Test
    public void catGetFoodReturnsMeat() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();

    }

}

