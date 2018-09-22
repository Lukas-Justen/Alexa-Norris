import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public final class RestaurantRouletteHandler extends SkillStreamHandler {


    public RestaurantRouletteHandler() {
        super(getSkill());
    }

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new RandomRestaurantHandler())
                .build();
    }



}
