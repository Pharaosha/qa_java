import com.example.Alex;
import com.example.CatFamily;
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
    CatFamily catFamily;

    @Test
    public void getFriendsReturnsCorrectList() throws Exception {
        Alex alex = new Alex("Самец", catFamily);
        List<String> friends = alex.getFriends();
        assertEquals(3, friends.size());
        assertTrue(friends.contains("Марти"));
        assertTrue(friends.contains("Глория"));
        assertTrue(friends.contains("Мелман"));
    }

    @Test
    public void getPlaceOfLivingReturnsZoo() throws Exception {
        Alex alex = new Alex("Самец", catFamily);
        String livingPlace = alex.getPlaceOfLiving();
        assertEquals("Нью-Йоркский зоопарк", livingPlace);
    }

    @Test
    public void  getKittensReturnZero() throws Exception {
        Alex alex = new Alex("Самец", catFamily);
        int kittens = alex.getKittens();
        assertEquals(0, kittens);
    }

    @Test
    public void constructorSetsMale() throws Exception {
        Alex alex = new Alex ("Самец", catFamily);
        assertTrue(alex.doesHaveMane());
    }

    @Test
    public void getFoodDelegatesToCatFamily() throws Exception {
        Alex alex = new Alex("Самец", catFamily);
        alex.getFood();

        Mockito.verify(catFamily, Mockito.times(1)).getFood();
    }


}
