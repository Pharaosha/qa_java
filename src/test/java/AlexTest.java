import com.example.Alex;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class AlexTest {

    @Mock
    Feline feline;

    @Test
    public void getFriendsReturnsCorrectList() throws Exception {
        Alex alex = new Alex("Самец", feline);
        List<String> friends = alex.getFriends();
        assertEquals(3, friends.size());
        assertTrue(friends.contains("Марти"));
        assertTrue(friends.contains("Глория"));
        assertTrue(friends.contains("Мелман"));
    }

    @Test
    public void getPlaceOfLivingReturnsZoo() throws Exception {
        Alex alex = new Alex("Самец", feline);
        String livingPlace = alex.getPlaceOfLiving();
        assertEquals("Нью-Йоркский зоопарк", livingPlace);
    }

    @Test
    public void  getKittensReturnZero() throws Exception {
        Alex alex = new Alex("Самец", feline);
        int kittens = alex.getKittens();
        assertEquals(0, kittens);
    }

    @Test
    public void constructorSetsMale() throws Exception {
        Alex alex = new Alex ("Самец", feline);
        assertTrue(alex.doesHaveMane());
    }

    @Test
    public void getFoodDelegatesToCatFamily() throws Exception {
        Alex alex = new Alex("Самец", feline);
        alex.getFood();

        Mockito.verify(feline, Mockito.times(1)).getFood();
    }


}
